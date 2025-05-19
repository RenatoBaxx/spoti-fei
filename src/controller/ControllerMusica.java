/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.MusicaDAO;
import model.Musica;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author RJUTWE
 */
public class ControllerMusica {
   private MusicaDAO dao;

    public ControllerMusica(Connection conn) {
        this.dao = new MusicaDAO(conn);
    }

    public List<Musica> listarMusicas() {
        try {
            return dao.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}