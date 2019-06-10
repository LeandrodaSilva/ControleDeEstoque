/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControllerSettings;
import java.awt.Point;
import java.io.IOException;
import model.dataAcessObject.DirDAO;
import model.businessObject.Security;
import javax.swing.JOptionPane;
import model.dataAcessObject.SettingsDAO;
import model.dataAcessObject.UserDAO;
import model.valueObject.User;
import model.valueObject.Settings;

/**
 *
 * @author ld_si
 */
public class LoginUI extends javax.swing.JFrame {
    private Point point = new Point();
    /**
     * Creates new form LoginUI
     */

    public LoginUI() {
        initComponents();
    }

    public LoginUI(int mode) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordFieldPasswd = new javax.swing.JPasswordField();
        jButtonEnter = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jLabelUser = new javax.swing.JLabel();
        jLabelPasswd = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabelUserError = new javax.swing.JLabel();
        jLabelPasswdError = new javax.swing.JLabel();
        jButtonNew = new javax.swing.JButton();
        jLabelLoginError = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPasswordFieldPasswd.setText("admin");
        jPasswordFieldPasswd.setToolTipText("Senha");
        jPasswordFieldPasswd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPasswordFieldPasswd.setPreferredSize(new java.awt.Dimension(50, 30));
        getContentPane().add(jPasswordFieldPasswd);
        jPasswordFieldPasswd.setBounds(340, 310, 150, 40);

        jButtonEnter.setText("Logar");
        jButtonEnter.setBorder(null);
        jButtonEnter.setFocusable(false);
        jButtonEnter.setPreferredSize(new java.awt.Dimension(70, 35));
        jButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnterActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEnter);
        jButtonEnter.setBounds(420, 480, 110, 35);

        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/closeBlack.png"))); // NOI18N
        jButtonClose.setToolTipText("Fechar janela");
        jButtonClose.setBorder(null);
        jButtonClose.setBorderPainted(false);
        jButtonClose.setContentAreaFilled(false);
        jButtonClose.setFocusPainted(false);
        jButtonClose.setPreferredSize(new java.awt.Dimension(30, 30));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose);
        jButtonClose.setBounds(760, 10, 30, 30);

        jLabelUser.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUser.setText("Usuário");
        jLabelUser.setFocusable(false);
        getContentPane().add(jLabelUser);
        jLabelUser.setBounds(220, 260, 80, 16);

        jLabelPasswd.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPasswd.setText("Senha");
        jLabelPasswd.setFocusable(false);
        getContentPane().add(jLabelPasswd);
        jLabelPasswd.setBounds(221, 320, 70, 16);

        jLabelTitle.setFont(jLabelTitle.getFont().deriveFont(jLabelTitle.getFont().getSize()+24f));
        jLabelTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Controle de Estoque");
        jLabelTitle.setFocusable(false);
        getContentPane().add(jLabelTitle);
        jLabelTitle.setBounds(150, 70, 530, 90);

        jTextFieldUser.setText("admin");
        jTextFieldUser.setToolTipText("Usuário");
        jTextFieldUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(jTextFieldUser);
        jTextFieldUser.setBounds(340, 250, 150, 40);

        jLabelUserError.setForeground(new java.awt.Color(255, 0, 0));
        jLabelUserError.setText("Insira o usuário");
        jLabelUserError.setFocusable(false);
        getContentPane().add(jLabelUserError);
        jLabelUserError.setBounds(510, 260, 190, 16);
        jLabelUserError.setVisible(false);

        jLabelPasswdError.setForeground(new java.awt.Color(255, 0, 0));
        jLabelPasswdError.setText("Insira a senha");
        jLabelPasswdError.setFocusable(false);
        getContentPane().add(jLabelPasswdError);
        jLabelPasswdError.setBounds(510, 320, 150, 16);
        jLabelPasswdError.setVisible(false);

        jButtonNew.setText("Cadastrar");
        jButtonNew.setBorder(null);
        jButtonNew.setFocusable(false);
        jButtonNew.setPreferredSize(new java.awt.Dimension(70, 35));
        jButtonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNew);
        jButtonNew.setBounds(310, 480, 100, 35);

        jLabelLoginError.setForeground(new java.awt.Color(255, 0, 0));
        jLabelLoginError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLoginError.setText("Usuário não cadastrado ou dados incorretos");
        jLabelLoginError.setFocusable(false);
        getContentPane().add(jLabelLoginError);
        jLabelLoginError.setBounds(250, 430, 360, 30);
        jLabelLoginError.setVisible(false);

        jButton1.setText("Modo de operação");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 380, 150, 32);

        jLabelBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/white-wallpapers.jpeg"))); // NOI18N
        jLabelBackground.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane,
                "Deseja realmente sair?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterActionPerformed
        User user;
        try {
            
            user = (User) UserDAO.readUser(jTextFieldUser.getText());
                
                if (checkBox() && Security.loginCheck(jTextFieldUser.getText(), jPasswordFieldPasswd.getText(), user)) {
                    System.out.println("Acesso permitido");
                    this.setVisible(false);
                    MainUI mainUI = new MainUI();
                    mainUI.start();
                } else {
                    jLabelLoginError.setVisible(true);
                }
           

        } catch (IOException ex) {
            jLabelLoginError.setVisible(true);
            JOptionPane.showMessageDialog(rootPane, "Cadastre um usuário", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonEnterActionPerformed

    private void jButtonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewActionPerformed
        InsertUserUI insertUserUI = new InsertUserUI();
        insertUserUI.setVisible(true);
        insertUserUI.loginUI = this;
        this.setEnabled(false);

    }//GEN-LAST:event_jButtonNewActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.point.x = evt.getX();
        this.point.y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SettingsUI settingsUI = new SettingsUI();
        new ControllerSettings(settingsUI, SettingsDAO.readSettings().getMode());
        settingsUI.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonClose;
    public javax.swing.JButton jButtonEnter;
    private javax.swing.JButton jButtonNew;
    public javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelLoginError;
    private javax.swing.JLabel jLabelPasswd;
    private javax.swing.JLabel jLabelPasswdError;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUserError;
    private javax.swing.JPasswordField jPasswordFieldPasswd;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

    private Boolean checkBox() {
        int i = 0;
        if (jTextFieldUser.getText().equals("")) {
            i++;
            jLabelUserError.setVisible(true);
            jTextFieldUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        } else {
            jLabelUserError.setVisible(false);
            jTextFieldUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        }
        if (jPasswordFieldPasswd.getText().equals("")) {
            i++;
            jLabelPasswdError.setVisible(true);
            jPasswordFieldPasswd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        } else {
            jLabelPasswdError.setVisible(false);
            jPasswordFieldPasswd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        }
        return i <= 0;
    }
}
