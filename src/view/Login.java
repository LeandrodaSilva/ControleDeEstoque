/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import view.basic.Head;
import javax.swing.JLabel;
import javax.swing.JTextField;
import view.basic.Button;
import view.basic.TextField;

/**
 *
 * @author Aluno
 */
public class Login extends javax.swing.JFrame {

    private Button bEnter;
    private Button bRegister;
    private TextField tfUser;
    private TextField tfPasswd;
    private Head tbHead;
    private JLabel background;
    private JLabel lUser;
    private JLabel lPasswd;

    public Login() {
        this.setTitle("Login");
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        this.bEnter = new Button("Logar");
        this.bRegister = new Button("Cadastrar");
        this.tfUser = new TextField();
        this.tfPasswd = new TextField();
        this.tbHead = new Head("Tela de Login");
        this.background = new JLabel("back");
        this.lUser = new JLabel("Usuário");
        this.lPasswd = new JLabel("Senha");
        
        this.tbHead.setBounds(0, 0, 800, 50);
        this.lUser.setBounds(200, 210, 100, 35);
        this.tfUser.setBounds(300, 210, 200, 35);
        this.lPasswd.setBounds(200, 270, 100, 35);
        this.tfPasswd.setBounds(300, 270, 200, 35);
        this.bEnter.setBounds(410, 480, 100, 35);
        this.bRegister.setBounds(290, 480, 100, 35);
        this.background.setBounds(0, 50, 800, 550);
        this.background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/back.png")));
        
        this.add(bEnter);
        this.add(bRegister);
        this.add(lUser);
        this.add(tfUser);
        this.add(lPasswd);
        this.add(tfPasswd);
        this.add(tbHead);
        this.add(background);
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

    public TextField getTfUser() {
        return tfUser;
    }

    public void setTfUser(TextField tfUser) {
        this.tfUser = tfUser;
    }

    public TextField getTfPasswd() {
        return tfPasswd;
    }

    public void setTfPasswd(TextField tfPasswd) {
        this.tfPasswd = tfPasswd;
    }

    public Head getTbHead() {
        return tbHead;
    }

    public void setTbHead(Head tbHead) {
        this.tbHead = tbHead;
    }

}
