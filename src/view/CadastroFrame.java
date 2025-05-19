
package view;

import controller.ControllerCadastro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroFrame extends javax.swing.JFrame {

    public CadastroFrame() {
        initComponents();
        c = new ControllerCadastro(this);
    }

    public JButton getBr_cadastrar() {
        return br_cadastrar;
    }

    public void setBr_cadastrar(JButton br_cadastrar) {
        this.br_cadastrar = br_cadastrar;
    }

    public JLabel getLbl_nome_cadastro() {
        return lbl_nome_cadastro;
    }

    public void setLbl_nome_cadastro(JLabel lbl_nome_cadastro) {
        this.lbl_nome_cadastro = lbl_nome_cadastro;
    }

    public JLabel getLbl_senha_cadastro() {
        return lbl_senha_cadastro;
    }

    public void setLbl_senha_cadastro(JLabel lbl_senha_cadastro) {
        this.lbl_senha_cadastro = lbl_senha_cadastro;
    }

    public JLabel getLbl_usuario_cadastro() {
        return lbl_usuario_cadastro;
    }

    public void setLbl_usuario_cadastro(JLabel lbl_usuario_cadastro) {
        this.lbl_usuario_cadastro = lbl_usuario_cadastro;
    }

    public JTextField getTxt_nome_cadastro() {
        return txt_nome_cadastro;
    }

    public void setTxt_nome_cadastro(JTextField txt_nome_cadastro) {
        this.txt_nome_cadastro = txt_nome_cadastro;
    }

    public JTextField getTxt_senha_cadastro() {
        return txt_senha_cadastro;
    }

    public void setTxt_senha_cadastro(JTextField txt_senha_cadastro) {
        this.txt_senha_cadastro = txt_senha_cadastro;
    }

    public JTextField getTxt_usuario_cadastro() {
        return txt_usuario_cadastro;
    }

    public void setTxt_usuario_cadastro(JTextField txt_usuario_cadastro) {
        this.txt_usuario_cadastro = txt_usuario_cadastro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lbl_nome_cadastro = new javax.swing.JLabel();
        lbl_senha_cadastro = new javax.swing.JLabel();
        txt_senha_cadastro = new javax.swing.JTextField();
        br_cadastrar = new javax.swing.JButton();
        txt_usuario_cadastro = new javax.swing.JTextField();
        lbl_usuario_cadastro = new javax.swing.JLabel();
        txt_nome_cadastro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Cadastro - Spotifei");

        jLayeredPane1.setBackground(new java.awt.Color(51, 51, 51));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLayeredPane2.setBackground(new java.awt.Color(102, 102, 102));
        jLayeredPane2.setOpaque(true);

        lbl_nome_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nome_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome_cadastro.setText("Nome:");

        lbl_senha_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_senha_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_senha_cadastro.setText("Senha:");

        txt_senha_cadastro.setBackground(new java.awt.Color(102, 102, 102));
        txt_senha_cadastro.setForeground(new java.awt.Color(255, 255, 255));

        br_cadastrar.setBackground(new java.awt.Color(0, 110, 171));
        br_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        br_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        br_cadastrar.setText("CADASTRAR");
        br_cadastrar.setBorder(null);
        br_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                br_cadastrarActionPerformed(evt);
            }
        });

        txt_usuario_cadastro.setBackground(new java.awt.Color(102, 102, 102));
        txt_usuario_cadastro.setForeground(new java.awt.Color(255, 255, 255));

        lbl_usuario_cadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_usuario_cadastro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario_cadastro.setText("Usuário:");

        txt_nome_cadastro.setBackground(new java.awt.Color(102, 102, 102));
        txt_nome_cadastro.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Já Possui Cadastro? Clique Aqui");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ja_possui_cadastro(evt);
            }
        });

        jLayeredPane2.setLayer(lbl_nome_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_senha_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txt_senha_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(br_cadastrar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txt_usuario_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(lbl_usuario_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txt_nome_cadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(lbl_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(lbl_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(lbl_nome_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(br_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(131, 131, 131))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senha_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(br_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spotifeilogosf.png"))); // NOI18N

        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(105, 105, 105))
            .addComponent(jLayeredPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void br_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_br_cadastrarActionPerformed
        c.salvarAluno();
    }//GEN-LAST:event_br_cadastrarActionPerformed

    private void btn_ja_possui_cadastro(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ja_possui_cadastro
        LoginFrame cf = new LoginFrame();
        cf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ja_possui_cadastro

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
//            java.util.logging.Logger.getLogger(CadastroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CadastroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CadastroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CadastroFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CadastroFrame().setVisible(true);
//            }
//        });
//    }

    private ControllerCadastro c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton br_cadastrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLabel lbl_nome_cadastro;
    private javax.swing.JLabel lbl_senha_cadastro;
    private javax.swing.JLabel lbl_usuario_cadastro;
    private javax.swing.JTextField txt_nome_cadastro;
    private javax.swing.JTextField txt_senha_cadastro;
    private javax.swing.JTextField txt_usuario_cadastro;
    // End of variables declaration//GEN-END:variables
}
