
package controller;

import DAO.AlunoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import view.AltExcFrame;

public class ControllerUsuario {
    private AltExcFrame view;
    private Aluno aluno;

    public ControllerUsuario(AltExcFrame view, Aluno aluno) {
        this.view = view;
        this.aluno = aluno;
    }
    
    public void atualizar(){
        String novaSenha = view.getTxt_senha_altexc().getText();
        String usuario = view.getLbl_usuario_altexc().getText();
        Aluno aluno = new Aluno("", usuario, novaSenha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AlunoDAO dao = new AlunoDAO(conn);
            dao.atualizar(aluno);
            JOptionPane.showMessageDialog(view, "Senha de Usuário atualizada com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void remover(){
        String usuario = aluno.getUsuario();
        int option = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir o cadastro",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if(option != 1){
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                AlunoDAO dao = new AlunoDAO(conn);
                dao.remover(aluno);
                JOptionPane.showMessageDialog(view, "Usuario removido com Sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(view, "Falha de conexão!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
