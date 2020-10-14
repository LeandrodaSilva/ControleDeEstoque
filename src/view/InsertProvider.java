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
public class InsertProvider extends JFrame{
    private Button jButtonClear;
    private Button jButtonDelete;
    private Button jButtonSave;
    private JLabel jLabelEnde;
    private JLabel jLabelName;
    private JLabel jLabelPrice;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaAdress;
    private TextField jTextFieldCnpj;
    private TextField jTextFieldName;
    private Head head;
    private JLabel lbackground;
    
    public InsertProvider() {
        setResizable(false);
        setSize(600,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        jLabelName = new javax.swing.JLabel("Nome");
        jLabelPrice = new javax.swing.JLabel("CNPJ");
        jLabelEnde = new javax.swing.JLabel("Endereço");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAdress = new JTextArea();
        jTextFieldCnpj = new TextField();
        jTextFieldName = new TextField();
        jButtonSave = new Button("Salvar");
        jButtonClear = new Button("Limpar");
        jButtonDelete = new Button("Deletar");
        head = new Head("Cadastrar Fornecedor");
        lbackground = new JLabel();

        jLabelName.setBounds(37, 64, 60, 16);
        jLabelPrice.setBounds(37, 102, 60, 16);
        jLabelEnde.setBounds(37, 144, 90, 16);
        jTextAreaAdress.setColumns(20);
        jTextAreaAdress.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAdress);
        jScrollPane1.setBounds(37, 166, 514, 120);
        jTextFieldCnpj.setBounds(94, 98, 209, 24);
        jTextFieldName.setBounds(94, 60, 431, 24);
        jButtonSave.setBounds(485, 350, 66, 32); 
        jButtonClear.setBounds(37, 350, 70, 32);
        jButtonDelete.setBounds(113, 350, 71, 32);
        head.setBounds(0, 0, 600, 50);
        lbackground.setBounds(0, 50, 800, 550);
        lbackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
        
        
        add(jLabelName);
        add(jButtonDelete);
        add(jButtonClear);
        add(jButtonSave);
        add(jTextFieldName);
        add(jTextFieldCnpj);
        add(jScrollPane1);
        add(jLabelEnde);
        add(jLabelPrice);
        add(head);
        add(lbackground);
 
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

    public JLabel getjLabelEnde() {
        return jLabelEnde;
    }

    public void setjLabelEnde(JLabel jLabelEnde) {
        this.jLabelEnde = jLabelEnde;
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

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTextArea getjTextAreaAdress() {
        return jTextAreaAdress;
    }

    public void setjTextAreaAdress(JTextArea jTextAreaAdress) {
        this.jTextAreaAdress = jTextAreaAdress;
    }

    public TextField getjTextFieldCnpj() {
        return jTextFieldCnpj;
    }

    public void setjTextFieldCnpj(TextField jTextFieldCnpj) {
        this.jTextFieldCnpj = jTextFieldCnpj;
    }

    public TextField getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(TextField jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public JLabel getLbackground() {
        return lbackground;
    }

    public void setLbackground(JLabel lbackground) {
        this.lbackground = lbackground;
    }
    
    
    
}
