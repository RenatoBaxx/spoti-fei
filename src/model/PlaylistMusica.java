/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author RJUTWE
 */
public class PlaylistMusica {
    private Playlist playlist;
    private Musica musica;

    public PlaylistMusica() {
    }

    public PlaylistMusica(Playlist playlist, Musica musica) {
        this.playlist = playlist;
        this.musica = musica;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }
}
