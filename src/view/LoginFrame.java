
package view;

import controller.ControllerLogin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
        c = new ControllerLogin(this);
    }

    public JButton getBt_cadastro() {
        return bt_cadastro;
    }

    public void setBt_cadastro(JButton bt_cadastro) {
        this.bt_cadastro = bt_cadastro;
    }

    public JButton getBt_login() {
        return bt_login;
    }

    public void setBt_login(JButton bt_login) {
        this.bt_login = bt_login;
    }

    public JLabel getLbl_senha_login() {
        return lbl_senha_login;
    }

    public void setLbl_senha_login(JLabel lbl_senha_login) {
        this.lbl_senha_login = lbl_senha_login;
    }

    public JLabel getLbl_usuario_login() {
        return lbl_usuario_login;
    }

    public void setLbl_usuario_login(JLabel lbl_usuario_login) {
        this.lbl_usuario_login = lbl_usuario_login;
    }

    public JTextField getTxt_senha_login() {
        return txt_senha_login;
    }

    public void setTxt_senha_login(JTextField txt_senha_login) {
        this.txt_senha_login = txt_senha_login;
    }

    public JTextField getTxt_usuario_login() {
        return txt_usuario_login;
    }

    public void setTxt_usuario_login(JTextField txt_usuario_login) {
        this.txt_usuario_login = txt_usuario_login;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        txt_usuario_login = new javax.swing.JTextField();
        lbl_usuario_login = new javax.swing.JLabel();
        txt_senha_login = new javax.swing.JTextField();
        lbl_senha_login = new javax.swing.JLabel();
        bt_login = new javax.swing.JButton();
        bt_cadastro = new javax.swing.JButton();

        setTitle("Sistema de Alunos");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jLayeredPane1.setBackground(new java.awt.Color(51, 51, 51));
        jLayeredPane1.setOpaque(true);

        lbl_usuario_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_usuario_login.setForeground(java.awt.SystemColor.controlLtHighlight);
        lbl_usuario_login.setText("Usuário:");

        lbl_senha_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_senha_login.setForeground(java.awt.SystemColor.controlLtHighlight);
        lbl_senha_login.setText("Senha:");

        bt_login.setBackground(new java.awt.Color(0, 110, 171));
        bt_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_login.setForeground(new java.awt.Color(255, 255, 255));
        bt_login.setText("LOGIN");
        bt_login.setBorderPainted(false);
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });

        bt_cadastro.setBackground(new java.awt.Color(0, 110, 171));
        bt_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bt_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        bt_cadastro.setText("CADASTRO");
        bt_cadastro.setBorderPainted(false);
        bt_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastroActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(txt_usuario_login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_usuario_login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txt_senha_login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl_senha_login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bt_login, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bt_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_usuario_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario_login))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha_login))
                .addGap(39, 39, 39)
                .addComponent(bt_login)
                .addGap(18, 18, 18)
                .addComponent(bt_cadastro)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastroActionPerformed
        CadastroFrame cf = new CadastroFrame();
        cf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_cadastroActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        c.loginAluno();
        this.setVisible(false);
    }//GEN-LAST:event_bt_loginActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginFrame().setVisible(true);
//            }
//        });
//    }
    

    private ControllerLogin c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastro;
    private javax.swing.JButton bt_login;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbl_senha_login;
    private javax.swing.JLabel lbl_usuario_login;
    private javax.swing.JTextField txt_senha_login;
    private javax.swing.JTextField txt_usuario_login;
    // End of variables declaration//GEN-END:variables
}
