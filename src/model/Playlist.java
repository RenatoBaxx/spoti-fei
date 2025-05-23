/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author RJUTWE
 */
public class Playlist {
    private int id;
    private String nome;
    private Aluno dono;
    private String[] idsMusicas;

    public Playlist() {
    }
    
    public Playlist(int id, String nome) {
    this.id = id;
    this.nome = nome;
    }

    
    public Playlist(String nome, String[] idsMusicas) {
    this.nome = nome;
    this.idsMusicas = idsMusicas;
    }

    public Playlist(int id, String nome, Aluno dono) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno getDono() {
        return dono;
    }

    public void setDono(Aluno dono) {
        this.dono = dono;
    }
    public String[] getIdsMusicas() {   
        return idsMusicas; 
    }
}
