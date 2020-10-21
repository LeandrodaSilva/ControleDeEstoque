/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import views.components.ButtonComponent;
import views.components.HeadComponent;
import views.components.TextFieldComponent;

/**
 *
 * @author ld_si
 */
public class ItemView extends JFrame{
    private ButtonComponent jButtonClear;
    private ButtonComponent jButtonDelete;
    private ButtonComponent jButtonSave;
    private JLabel jLabelDescription;
    private JLabel jLabelName;
    private JLabel jLabelPrice;
    private JLabel jLabelQuantity;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaDescription;
    private TextFieldComponent jTextFieldName;
    private TextFieldComponent jTextFieldPrice;
    private TextFieldComponent jTextFieldQuantity;
    private HeadComponent head;
    private JLabel lbackground;
    
    
    public ItemView() {
        setResizable(false);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        lbackground = new JLabel("back");
        lbackground.setBounds(0, 50, 800, 550);
        lbackground.setIcon(new ImageIcon(getClass().getResource("/views/images/back.png")));
        
        jButtonClear = new ButtonComponent("Limpar");
        jButtonDelete = new ButtonComponent("Deletar");
        jButtonSave = new ButtonComponent("Salvar");
        
        jLabelDescription = new JLabel("Descrição");
        jLabelName = new JLabel("Nome");
        jLabelPrice = new JLabel("Preço");
        jLabelQuantity = new JLabel("Quantidade");
        
        jScrollPane1 = new JScrollPane();
        jTextAreaDescription = new JTextArea();
        
        jTextFieldName = new TextFieldComponent();
        jTextFieldPrice = new TextFieldComponent();
        jTextFieldQuantity = new TextFieldComponent();
        
        head = new HeadComponent("Cadastrar Produto");
        
        head.setBounds(0, 0, 600, 50);
        jButtonClear.setBounds(37, 350, 70, 32);
        jButtonSave.setBounds(485, 350, 66, 32);
        jButtonDelete.setBounds(125, 350, 71, 32);
        jTextFieldName.setBounds(120, 102, 431, 24);
        jTextFieldPrice.setBounds(342, 60, 209, 24);
        jTextFieldQuantity.setBounds(120, 60, 134, 24);
        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(3);
        jScrollPane1.setViewportView(jTextAreaDescription);
        jScrollPane1.setBounds(37, 186, 514, 120);
        jLabelDescription.setBounds(37, 144, 90, 16);
        jLabelPrice.setBounds(272, 64, 52, 16);
        jLabelName.setBounds(37, 106, 60, 16);
        jLabelQuantity.setBounds(37, 60, 100, 16);
        
        
 
        
        add(jButtonClear);
        add(jButtonDelete);
        add(jButtonSave);
        add(jTextFieldName);
        add(jTextFieldPrice);
        add(jTextFieldQuantity);
        add(jLabelDescription);
        add(jLabelName);
        add(jLabelPrice);
        add(jLabelQuantity);
        add(jScrollPane1);
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

    public ButtonComponent getjButtonDelete() {
        return jButtonDelete;
    }

    public void setjButtonDelete(ButtonComponent jButtonDelete) {
        this.jButtonDelete = jButtonDelete;
    }

    public ButtonComponent getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(ButtonComponent jButtonSave) {
        this.jButtonSave = jButtonSave;
    }

    public JLabel getjLabelDescription() {
        return jLabelDescription;
    }

    public void setjLabelDescription(JLabel jLabelDescription) {
        this.jLabelDescription = jLabelDescription;
    }

    public JLabel getjLabelName() {
        return jLabelName;
    }

    public void setjLabelName(JLabel jLabelName) {
        this.jLabelName = jLabelName;
    }

    public JLabel getjLabelPrice() {
        return jLabelPrice;
    }

    public void setjLabelPrice(JLabel jLabelPrice) {
        this.jLabelPrice = jLabelPrice;
    }

    public JLabel getjLabelQuantity() {
        return jLabelQuantity;
    }

    public void setjLabelQuantity(JLabel jLabelQuantity) {
        this.jLabelQuantity = jLabelQuantity;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextAreaDescription() {
        return jTextAreaDescription;
    }

    public void setjTextAreaDescription(JTextArea jTextAreaDescription) {
        this.jTextAreaDescription = jTextAreaDescription;
    }

    public TextFieldComponent getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(TextFieldComponent jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public TextFieldComponent getjTextFieldPrice() {
        return jTextFieldPrice;
    }

    public void setjTextFieldPrice(TextFieldComponent jTextFieldPrice) {
        this.jTextFieldPrice = jTextFieldPrice;
    }

    public TextFieldComponent getjTextFieldQuantity() {
        return jTextFieldQuantity;
    }

    public void setjTextFieldQuantity(TextFieldComponent jTextFieldQuantity) {
        this.jTextFieldQuantity = jTextFieldQuantity;
    }
    
    
}
