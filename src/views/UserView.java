/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import views.components.ButtonComponent;
import views.components.HeadComponent;
import views.components.PasswordFieldComponent;
import views.components.TextFieldComponent;

/**
 *
 * @author ld_si
 */
public class UserView extends JFrame{
    private ButtonComponent jButtonClear;
    private ButtonComponent jButtonSave;
    private JLabel jLabelName;
    private JLabel jLabelPasswd;
    private PasswordFieldComponent jPasswordField;
    private TextFieldComponent jTextFieldName;
    private HeadComponent head;
    private JLabel lbackground;
    
    public UserView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Cadastro de usuário");
        setResizable(false);
        setSize(600, 400);
        setUndecorated(true);
        setLocationRelativeTo(null);
        
        head = new HeadComponent("Cadastrar Usuário");
        jLabelPasswd = new JLabel("Senha");
        jLabelName = new JLabel("Nome de usuário");
        jTextFieldName = new TextFieldComponent();
        jButtonSave = new ButtonComponent("Salvar");
        jButtonClear = new ButtonComponent("Limpar");
        jPasswordField = new PasswordFieldComponent();
        lbackground = new JLabel();
        
        
        jLabelPasswd.setBounds(80, 170, 69, 16);
        jLabelName.setBounds(80, 130, 120, 16);
        jButtonSave.setBounds(460, 340, 58, 32);
        jButtonClear.setBounds(70, 340, 60, 32);
        jPasswordField.setBounds(230, 170, 200, 22);
        jTextFieldName.setBounds(230, 130, 200, 24);
        head.setBounds(0, 0, 600, 50);
        lbackground.setBounds(0, 50, 800, 550);
        lbackground.setIcon(new ImageIcon(getClass().getResource("/views/images/back.png")));
        
        
        
        add(jButtonClear);
        add(jButtonSave);
        add(jLabelName);
        add(jPasswordField);
        add(jTextFieldName);
        add(jLabelPasswd);
        add(head);
        add(lbackground);
        
    }

    public HeadComponent getHead() {
        return head;
    }

    public void setHead(HeadComponent head) {
        this.head = head;
    }
    
    

    public ButtonComponent getjButtonClear() {
        return jButtonClear;
    }

    public void setjButtonClear(ButtonComponent jButtonClear) {
        this.jButtonClear = jButtonClear;
    }

    public ButtonComponent getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(ButtonComponent jButtonSave) {
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

    public PasswordFieldComponent getjPasswordField() {
        return jPasswordField;
    }

    public void setjPasswordField(PasswordFieldComponent jPasswordField) {
        this.jPasswordField = jPasswordField;
    }

    public TextFieldComponent getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(TextFieldComponent jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }
    
    
    
}
