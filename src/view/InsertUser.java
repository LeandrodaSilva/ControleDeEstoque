/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import view.basic.Button;
import view.basic.Head;
import view.basic.PasswordField;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class InsertUser extends JFrame{
    private Button jButtonClear;
    private Button jButtonSave;
    private JLabel jLabelName;
    private JLabel jLabelPasswd;
    private PasswordField jPasswordField;
    private TextField jTextFieldName;
    private Head head;
    private JLabel lbackground;
    
    public InsertUser() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuário");
        setResizable(false);
        setSize(600, 400);
        setUndecorated(true);
        setLocationRelativeTo(null);
        
        head = new Head("Cadastrar Usuário");
        jLabelPasswd = new JLabel("Senha");
        jLabelName = new JLabel("Nome de usuário");
        jTextFieldName = new TextField();
        jButtonSave = new Button("Salvar");
        jButtonClear = new Button("Limpar");
        jPasswordField = new PasswordField();
        lbackground = new JLabel();
        
        
        jLabelPasswd.setBounds(80, 170, 69, 16);
        jLabelName.setBounds(80, 130, 120, 16);
        jButtonSave.setBounds(460, 340, 58, 32);
        jButtonClear.setBounds(70, 340, 60, 32);
        jPasswordField.setBounds(230, 170, 200, 22);
        jTextFieldName.setBounds(230, 130, 200, 24);
        head.setBounds(0, 0, 600, 50);
        lbackground.setBounds(0, 50, 800, 550);
        lbackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
        
        
        
        add(jButtonClear);
        add(jButtonSave);
        add(jLabelName);
        add(jPasswordField);
        add(jTextFieldName);
        add(jLabelPasswd);
        add(head);
        add(lbackground);
        
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
    
    

    public Button getjButtonClear() {
        return jButtonClear;
    }

    public void setjButtonClear(Button jButtonClear) {
        this.jButtonClear = jButtonClear;
    }

    public Button getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(Button jButtonSave) {
        this.jButtonSave = jButtonSave;
    }

    public JLabel getjLabelName() {
        return jLabelName;
    }

    public void setjLabelName(JLabel jLabelName) {
        this.jLabelName = jLabelName;
    }

    public JLabel getjLabelPasswd() {
        return jLabelPasswd;
    }

    public void setjLabelPasswd(JLabel jLabelPasswd) {
        this.jLabelPasswd = jLabelPasswd;
    }

    public PasswordField getjPasswordField() {
        return jPasswordField;
    }

    public void setjPasswordField(PasswordField jPasswordField) {
        this.jPasswordField = jPasswordField;
    }

    public TextField getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(TextField jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }
    
    
    
}
