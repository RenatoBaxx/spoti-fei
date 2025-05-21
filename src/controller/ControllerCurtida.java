package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ControllerCurtida {

    private Connection conn;
    private Aluno aluno;

    public ControllerCurtida(Connection conn, Aluno aluno) {
        this.conn = conn;
        this.aluno = aluno;
    }

    public void curtirMusica(String idMusicaStr) {
        try {
            int idMusica = Integer.parseInt(idMusicaStr);
            int idAluno = buscarIdAlunoPorNome(aluno.getNome());

            if (idAluno == -1) {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                return;
            }

            String tipo = "curtir";
            Date data = new Date(System.currentTimeMillis());

            String sql = "INSERT INTO curtida (id_aluno, id_musica, tipo, data) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            stmt.setInt(2, idMusica);
            stmt.setString(3, tipo);
            stmt.setDate(4, data);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Música curtida com sucesso!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID da música inválido.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao curtir música: " + e.getMessage());
        }
    }

    private int buscarIdAlunoPorNome(String nome) throws SQLException {
        String sql = "SELECT id FROM aluno WHERE nome = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1; // não encontrado
    }
    


    public DefaultTableModel getTabelaMusicasCurtidas() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[] { "Nome", "Genero", "Artista" });

    String sql = "SELECT m.titulo, m.genero, ar.nome AS artista_nome " +
             "FROM curtida c " +
             "JOIN musica m ON c.id_musica = m.id " +
             "JOIN aluno a ON c.id_aluno = a.id " +
             "JOIN artista ar ON m.id_artista = ar.id " +
             "WHERE a.nome = ? AND c.tipo = 'curtir'";


    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, aluno.getNome());
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            modelo.addRow(new Object[] {
                rs.getString("titulo"),
                rs.getString("genero"),
                rs.getString("artista_nome")
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar músicas curtidas: " + e.getMessage());
    }

    return modelo;
}
    
    public void deletarCurtida(String idMusicaStr) {
    try {
        int idMusica = Integer.parseInt(idMusicaStr);
        int idAluno = buscarIdAlunoPorNome(aluno.getNome());

        if (idAluno == -1) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            return;
        }

        String sql = "DELETE FROM curtida WHERE id_aluno = ? AND id_musica = ? AND tipo = 'curtir'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAluno);
        stmt.setInt(2, idMusica);

        int rowsDeleted = stmt.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Curtida removida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma curtida encontrada para remover.");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID da música inválido.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao remover curtida: " + e.getMessage());
    }
}



}
