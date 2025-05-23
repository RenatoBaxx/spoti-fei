package controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Historico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class ControllerHistorico {
    private Connection conn;
    private Aluno aluno;


    public ControllerHistorico(Connection conn, Aluno aluno) {
        this.conn = conn;
        this.aluno = aluno;
    }

    public DefaultTableModel ultimasBuscas() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[] { "Título", "Artista", "Gênero" });

    try {
        int idAluno = buscarIdAlunoPorNome(aluno.getNome());

        String sql = "SELECT m.titulo, a.nome AS artista, m.genero " +
                     "FROM historico_buscas h " +
                     "JOIN musica m ON h.id_musica = m.id " +
                     "JOIN artista a ON m.id_artista = a.id " +
                     "WHERE h.id_aluno = ? " +
                     "ORDER BY h.id DESC " +
                     "LIMIT 10";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAluno);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[] {
                rs.getString("titulo"),
                rs.getString("artista"),
                rs.getString("genero")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar histórico: " + e.getMessage());
    }

    return modelo;
}

 public DefaultTableModel listarCurtidas(String tipo) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[] { "Título", "Artista", "Gênero" });

    try {
        int idAluno = buscarIdAlunoPorNome(aluno.getNome());

        String sql = "SELECT m.titulo, a.nome AS artista, m.genero " +
                     "FROM curtida c " +
                     "JOIN musica m ON c.id_musica = m.id " +
                     "JOIN artista a ON m.id_artista = a.id " +
                     "WHERE c.id_aluno = ? AND c.tipo = ? " +
                     "ORDER BY c.data DESC";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAluno);
        stmt.setString(2, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[] {
                rs.getString("titulo"),
                rs.getString("artista"),
                rs.getString("genero")
            });
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar " + tipo + ": " + e.getMessage());
    }

    return modelo;
}

    private DefaultTableModel montarTabela(List<Historico> lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Título", "Artista", "Gênero" });

        for (Historico h : lista) {
            modelo.addRow(new Object[] {
                h.getTitulo(),
                h.getArtista(),
                h.getGenero()
            });
        }

        return modelo;
    }
    
    private int buscarIdAlunoPorNome(String nome) throws SQLException {
        String sql = "SELECT id FROM aluno WHERE nome = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        return rs.next() ? rs.getInt("id") : -1;
}

}
