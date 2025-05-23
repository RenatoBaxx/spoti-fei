/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JOptionPane;

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
import java.sql.Statement;
import java.util.ArrayList;
import model.Playlist;
import view.PlaylistFrame;


/**
 *
 * @author RJUTWE
 */
public class ControllerPlaylist {
    private Connection conn;
    private Aluno aluno;
    private PlaylistFrame playlistFrame;

    public ControllerPlaylist(Connection conn, PlaylistFrame playlistFrame, Aluno aluno) {
    this.conn = conn;
    this.playlistFrame = playlistFrame;
    this.aluno = aluno;
    }

    public ControllerPlaylist(Connection conn, Aluno aluno) {
        this.conn = conn;
        this.aluno = aluno;
    }


    
   public void criarPlaylist(Playlist playlist, Aluno aluno){
    try {
        conn.setAutoCommit(false);

        int idAluno = buscarIdAlunoPorNome(aluno.getNome());
        if (idAluno == -1) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            return;
        }

        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO playlist (nome, id_aluno) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, playlist.getNome());
        ps.setInt(2, idAluno);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idPlaylist = rs.getInt(1);
            for (String idStr : playlist.getIdsMusicas()) {
                int idMusica = Integer.parseInt(idStr.trim());
                PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO playlist_musica (id_playlist, id_musica) VALUES (?, ?)");
                ps2.setInt(1, idPlaylist);
                ps2.setInt(2, idMusica);
                ps2.executeUpdate();
            }
        }

        conn.commit();
        JOptionPane.showMessageDialog(null, "Playlist criada com sucesso!");

    } catch (Exception e) {
        try { conn.rollback(); } catch (Exception ignore) {}
        JOptionPane.showMessageDialog(null, "Erro ao criar playlist: " + e.getMessage());
    }
}
   
 public void carregarPlaylists() {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(new String[] { "ID", "Nome da Playlist", "Músicas" });

    try {
        int idAluno = buscarIdAlunoPorNome(aluno.getNome());

        String sql = """
            SELECT p.id, p.nome, 
                   STRING_AGG(m.titulo, ', ') AS musicas
            FROM playlist p
            JOIN playlist_musica pm ON p.id = pm.id_playlist
            JOIN musica m ON pm.id_musica = m.id
            WHERE p.id_aluno = ?
            GROUP BY p.id, p.nome
            ORDER BY p.id
        """;

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idAluno);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            modelo.addRow(new Object[] {
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("musicas")
            });
        }

        playlistFrame.getjTable1().setModel(modelo);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao carregar playlists: " + e.getMessage());
    }
}
 
 public void adicionarMusicasNaPlaylist(int idPlaylist, String[] idsMusicas) {
    try {
        for (String idStr : idsMusicas) {
            int idMusica = Integer.parseInt(idStr.trim());

            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO playlist_musica (id_playlist, id_musica) VALUES (?, ?)");
            ps.setInt(1, idPlaylist);
            ps.setInt(2, idMusica);
            ps.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Músicas adicionadas à playlist!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar músicas: " + e.getMessage());
    }
}

public void removerMusicasDaPlaylist(int idPlaylist, String[] idsMusicas) {
    try {
        for (String idStr : idsMusicas) {
            int idMusica = Integer.parseInt(idStr.trim());

            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM playlist_musica WHERE id_playlist = ? AND id_musica = ?");
            ps.setInt(1, idPlaylist);
            ps.setInt(2, idMusica);
            ps.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Músicas removidas da playlist!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao remover músicas: " + e.getMessage());
    }
}

public void apagarPlaylist(int idPlaylist) {
    try {
        PreparedStatement ps1 = conn.prepareStatement(
            "DELETE FROM playlist_musica WHERE id_playlist = ?");
        ps1.setInt(1, idPlaylist);
        ps1.executeUpdate();

        PreparedStatement ps2 = conn.prepareStatement(
            "DELETE FROM playlist WHERE id = ?");
        ps2.setInt(1, idPlaylist);
        ps2.executeUpdate();

        JOptionPane.showMessageDialog(null, "Playlist apagada com sucesso!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao apagar playlist: " + e.getMessage());
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
