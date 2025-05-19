/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Musica;
import model.Artista;

/**
 *
 * @author RJUTWE
 */
public class MusicaDAO {
    private Connection conn;

    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Musica> listar() throws SQLException {
    List<Musica> musicas = new ArrayList<>();
    String sql = "SELECT m.id, m.titulo, m.genero, a.nome AS artista_nome " +
                 "FROM musica m JOIN artista a ON m.id_artista = a.id";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        Artista artista = new Artista();
        artista.setNome(rs.getString("artista_nome"));

        Musica musica = new Musica();
        musica.setId(rs.getInt("id"));
        musica.setTitulo(rs.getString("titulo"));
        musica.setGenero(rs.getString("genero"));
        musica.setArtista(artista);

        musicas.add(musica);
    }

    return musicas;
}

    
}
