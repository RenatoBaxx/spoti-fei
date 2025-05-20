package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Musica;
import view.Home;

public class ControllerHome {
    private Connection conn;
    private Aluno aluno;
    private Home home;

    public ControllerHome(Connection conn, Aluno aluno, Home home) {
        this.conn = conn;
        this.aluno = aluno;
        this.home = home;

        carregarTabela();
        
       this.home.getBtn_search().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String termo = home.getInput_BarraPesquisa().getText().trim();
                buscarMusicas(termo);
            }
        });
    }

  private void buscarMusicas(String termo) {
    String sql = "SELECT m.id, m.titulo, a.nome AS artista, m.genero " +
                 "FROM musica m " +
                 "JOIN artista a ON m.id_artista = a.id " +
                 "WHERE LOWER(m.titulo) LIKE ? " +
                 "OR LOWER(a.nome) LIKE ? " +
                 "OR LOWER(m.genero) LIKE ?";





        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            String parametro = "%" + termo.toLowerCase() + "%";
            stmt.setString(1, parametro);
            stmt.setString(2, parametro);
            stmt.setString(3, parametro);

            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) home.getjTable1().getModel();
            model.setRowCount(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String artista = rs.getString("artista");
                String genero = rs.getString("genero");

                model.addRow(new Object[]{id, titulo, genero, artista});

                String sqlAluno = "SELECT id FROM aluno WHERE usuario = ?";
                try (PreparedStatement alunoStmt = conn.prepareStatement(sqlAluno)) {
                    alunoStmt.setString(1, aluno.getUsuario());
                    ResultSet alunoRs = alunoStmt.executeQuery();

                    if (alunoRs.next()) {
                        int idAluno = alunoRs.getInt("id");

                        String insertHistorico = "INSERT INTO historico_buscas (id_aluno, id_musica) VALUES (?, ?)";
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertHistorico)) {
                            insertStmt.setInt(1, idAluno);
                            insertStmt.setInt(2, id);
                            insertStmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(home, "Erro ao buscar músicas: " + ex.getMessage());
        }
  }

    
    public void carregarTabela() {
        ControllerMusica controller = new ControllerMusica(conn);
        List<Musica> lista = controller.listarMusicas();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Título");
        modelo.addColumn("Gênero");
        modelo.addColumn("Artista");

        for (Musica m : lista) {
            modelo.addRow(new Object[]{
                m.getId(),
                m.getTitulo(),
                m.getGenero(),
                m.getArtista().getNome()
            });
        }
        home.getjTable1().setModel(modelo);
    }
}
