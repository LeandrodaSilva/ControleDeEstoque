/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Aluno
 */
public class Login extends javax.swing.JFrame {

    private JButton bEnter;
    private JButton bRegister;
    private JTextField tfUser;
    private JTextField tfPasswd;
    private Head tbHead;
    private JLabel background;

    public Login() {
        this.setTitle("Login");
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        this.bEnter = createSimpleButton("Logar");
        this.bRegister = createSimpleButton("Cadastrar");
        this.tfUser = new JTextField();
        this.tfPasswd = new JTextField();
        this.tbHead = new Head("Login");
        this.background = new JLabel("back");

        this.bEnter.setBounds(420, 480, 110, 35);
        this.bRegister.setBounds(300, 480, 110, 35);
        this.tbHead.setBounds(0, 0, 800, 50);
        this.background.setBounds(0, 50, 800, 550);
        this.background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/back.png")));

        this.add(bEnter);
        this.add(bRegister);
        this.add(tbHead);
        this.add(background);
    }

    private static JButton createSimpleButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        return button;
    }

    public JButton getbEnter() {
        return bEnter;
    }

    public void setbEnter(JButton bEnter) {
        this.bEnter = bEnter;
    }

    public JButton getbRegister() {
        return bRegister;
    }

    public void setbRegister(JButton bRegister) {
        this.bRegister = bRegister;
    }

    public JTextField getTfUser() {
        return tfUser;
    }

    public void setTfUser(JTextField tfUser) {
        this.tfUser = tfUser;
    }

    public JTextField getTfPasswd() {
        return tfPasswd;
    }

    public void setTfPasswd(JTextField tfPasswd) {
        this.tfPasswd = tfPasswd;
    }

    public Head getTbHead() {
        return tbHead;
    }

    public void setTbHead(Head tbHead) {
        this.tbHead = tbHead;
    }

}
