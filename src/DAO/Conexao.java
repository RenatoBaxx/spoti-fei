package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection() {
        try {
            Connection conexao = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/aluno",  // nome do banco
                    "postgres", "renato25");                            // usuário e senha
            System.out.println("Conexão bem-sucedida!");
            return conexao;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados:");
            e.printStackTrace(); 
            return null;
        }
    }
}
