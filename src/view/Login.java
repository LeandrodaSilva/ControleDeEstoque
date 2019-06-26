/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.basic.Head;
import javax.swing.JLabel;
import model.valueObject.User;
import view.basic.Button;
import view.basic.PasswordField;
import view.basic.TextField;

/**
 *
 * @author Aluno
 */
public class Login extends JFrame {
    private User userOnStorage;
    private String userName;
    private String userPassword;
    
    
    private Button bEnter;
    private Button bRegister;
    private JButton bConfig;
    private TextField tfUser;
    private PasswordField pfPasswd;
    private Head tbHead;
    private JLabel lbackground;
    private JLabel lUser;
    private JLabel lPasswd;
    private JLabel lErro;

    public Login() {
        this.setTitle("Login");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        this.bEnter = new Button("Logar");
        this.bRegister = new Button("Cadastrar");
        this.bConfig = new JButton("");
        this.tfUser = new TextField("admin");
        this.pfPasswd = new PasswordField("admin");
        this.tbHead = new Head("Tela de Login");
        this.lbackground = new JLabel("back");
        this.lUser = new JLabel("Usuário");
        this.lPasswd = new JLabel("Senha");
        this.lErro = new JLabel("Usuário não cadastrado ou dados incorretos.");
        
        this.lErro.setBounds(270, 380, 300, 35);
        this.lErro.setForeground(Color.red);
        this.lErro.setVisible(false);
        this.tbHead.setBounds(0, 0, 800, 50);
        this.lUser.setBounds(200, 210, 100, 35);
        this.tfUser.setBounds(300, 210, 200, 35);
        this.lPasswd.setBounds(200, 270, 100, 35);
        this.pfPasswd.setBounds(300, 270, 200, 35);
        this.bEnter.setBounds(410, 480, 100, 35);
        this.bRegister.setBounds(290, 480, 100, 35);
        this.bConfig.setBounds(20, 60, 35, 35);
        this.bConfig.setBorder(null);
        this.bConfig.setFocusable(false);
        this.bConfig.setBackground(Color.WHITE);
        this.bConfig.setForeground(Color.WHITE);
        this.bConfig.setBorderPainted(false);
        this.bConfig.setPreferredSize(new java.awt.Dimension(35, 35));
        this.bConfig.setIcon(new ImageIcon(getClass().getResource("/view/images/configBlack.png")));
        this.lbackground.setBounds(0, 50, 800, 550);
        this.lbackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
        
        this.add(bEnter);
        this.add(bRegister);
        this.add(bConfig);
        this.add(lUser);
        this.add(lErro);
        this.add(tfUser);
        this.add(lPasswd);
        this.add(pfPasswd);
        this.add(tbHead);
        this.add(lbackground);
    }

    public JLabel getLbackground() {
        return lbackground;
    }

    public void setLbackground(JLabel lbackground) {
        this.lbackground = lbackground;
    }
    
    public User getUserOnStorage() {
        return userOnStorage;
    }

    public void setUserOnStorage(User userOnStorage) {
        this.userOnStorage = userOnStorage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public JLabel getlErro() {
        return lErro;
    }

    public void setlErro(JLabel lErro) {
        this.lErro = lErro;
    }
    
    

    public Button getbEnter() {
        return bEnter;
    }

    public void setbEnter(Button bEnter) {
        this.bEnter = bEnter;
    }

    public Button getbRegister() {
        return bRegister;
    }

    public void setbRegister(Button bRegister) {
        this.bRegister = bRegister;
    }

    public JButton getbConfig() {
        return bConfig;
    }

    public void setbConfig(JButton bConfig) {
        this.bConfig = bConfig;
    }
    
    public TextField getTfUser() {
        return tfUser;
    }

    public void setTfUser(TextField tfUser) {
        this.tfUser = tfUser;
    }

    public PasswordField getPfPasswd() {
        return pfPasswd;
    }

    public void setPfPasswd(PasswordField pfPasswd) {
        this.pfPasswd = pfPasswd;
    }

    public Head getTbHead() {
        return tbHead;
    }

    public void setTbHead(Head tbHead) {
        this.tbHead = tbHead;
    }

    public JLabel getlUser() {
        return lUser;
    }

    public void setlUser(JLabel lUser) {
        this.lUser = lUser;
    }

    public JLabel getlPasswd() {
        return lPasswd;
    }

    public void setlPasswd(JLabel lPasswd) {
        this.lPasswd = lPasswd;
    }
}
