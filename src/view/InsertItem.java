/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import view.basic.Button;
import view.basic.Head;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class InsertItem extends JFrame{
    private Button jButtonClear;
    private Button jButtonDelete;
    private Button jButtonSave;
    private JLabel jLabelDescription;
    private JLabel jLabelName;
    private JLabel jLabelPrice;
    private JLabel jLabelQuantity;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaDescription;
    private TextField jTextFieldName;
    private TextField jTextFieldPrice;
    private TextField jTextFieldQuantity;
    private Head head;
    private JLabel lbackground;
    
    
    public InsertItem() {
        setResizable(false);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        lbackground = new JLabel("back");
        lbackground.setBounds(0, 50, 800, 550);
        lbackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
        
        jButtonClear = new Button("Limpar");
        jButtonDelete = new Button("Deletar");
        jButtonSave = new Button("Salvar");
        
        jLabelDescription = new JLabel("Descrição");
        jLabelName = new JLabel("Nome");
        jLabelPrice = new JLabel("Preço");
        jLabelQuantity = new JLabel("Quantidade");
        
        jScrollPane1 = new JScrollPane();
        jTextAreaDescription = new JTextArea();
        
        jTextFieldName = new TextField();
        jTextFieldPrice = new TextField();
        jTextFieldQuantity = new TextField();
        
        head = new Head("Cadastrar Produto");
        
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
        jLabelDescription.setBounds(37, 144, 58, 16);
        jLabelPrice.setBounds(272, 64, 52, 16);
        jLabelName.setBounds(37, 106, 33, 16);
        jLabelQuantity.setBounds(37, 60, 80, 16);
        
        
 
        
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

    public Button getjButtonDelete() {
        return jButtonDelete;
    }

    public void setjButtonDelete(Button jButtonDelete) {
        this.jButtonDelete = jButtonDelete;
    }

    public Button getjButtonSave() {
        return jButtonSave;
    }

    public void setjButtonSave(Button jButtonSave) {
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

    public TextField getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(TextField jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public TextField getjTextFieldPrice() {
        return jTextFieldPrice;
    }

    public void setjTextFieldPrice(TextField jTextFieldPrice) {
        this.jTextFieldPrice = jTextFieldPrice;
    }

    public TextField getjTextFieldQuantity() {
        return jTextFieldQuantity;
    }

    public void setjTextFieldQuantity(TextField jTextFieldQuantity) {
        this.jTextFieldQuantity = jTextFieldQuantity;
    }
    
    
}
