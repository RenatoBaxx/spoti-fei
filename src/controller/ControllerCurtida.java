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
        int idMusica = Integer.parseInt(idMusicaStr); // você esqueceu disso
        int idAluno = buscarIdAlunoPorNome(aluno.getNome());

        if (idAluno == -1) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            return;
        }

        Date data = new Date(System.currentTimeMillis());

        String checkSql = "SELECT * FROM curtida WHERE id_aluno = ? AND id_musica = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setInt(1, idAluno);
        checkStmt.setInt(2, idMusica);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String updateSql = "UPDATE curtida SET tipo = 'curtir', data = ? WHERE id_aluno = ? AND id_musica = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setDate(1, data);
            updateStmt.setInt(2, idAluno);
            updateStmt.setInt(3, idMusica);
            updateStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curtida atualizada.");
        } else {
            String insertSql = "INSERT INTO curtida (id_aluno, id_musica, tipo, data) VALUES (?, ?, 'curtir', ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, idAluno);
            insertStmt.setInt(2, idMusica);
            insertStmt.setDate(3, data);
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Música curtida com sucesso!");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID da música inválido.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao curtir música: " + e.getMessage());
    }
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
    
    public void descurtirMusica(String idMusicaStr) {
    try {
        int idMusica = Integer.parseInt(idMusicaStr);
        int idAluno = buscarIdAlunoPorNome(aluno.getNome());

        if (idAluno == -1) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            return;
        }

        Date data = new Date(System.currentTimeMillis());

        String checkSql = "SELECT * FROM curtida WHERE id_aluno = ? AND id_musica = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        checkStmt.setInt(1, idAluno);
        checkStmt.setInt(2, idMusica);
        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            String updateSql = "UPDATE curtida SET tipo = 'descurtir', data = ? WHERE id_aluno = ? AND id_musica = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setDate(1, data);
            updateStmt.setInt(2, idAluno);
            updateStmt.setInt(3, idMusica);
            updateStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Descurtida atualizada.");
        } else {
            String insertSql = "INSERT INTO curtida (id_aluno, id_musica, tipo, data) VALUES (?, ?, 'descurtir', ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setInt(1, idAluno);
            insertStmt.setInt(2, idMusica);
            insertStmt.setDate(3, data);
            insertStmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Música descurtida com sucesso!");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID da música inválido.");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao descurtir música: " + e.getMessage());
    }
}

    
        private int buscarIdAlunoPorNome(String nome) throws SQLException {
        String sql = "SELECT id FROM aluno WHERE nome = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? rs.getInt("id") : -1;
}



}
