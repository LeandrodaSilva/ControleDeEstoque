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
public class ProviderView extends JFrame{
    private ButtonComponent jButtonClear;
    private ButtonComponent jButtonDelete;
    private ButtonComponent jButtonSave;
    private JLabel jLabelEnde;
    private JLabel jLabelName;
    private JLabel jLabelPrice;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaAdress;
    private TextFieldComponent jTextFieldCnpj;
    private TextFieldComponent jTextFieldName;
    private HeadComponent head;
    private JLabel lbackground;
    
    public ProviderView() {
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
        jTextFieldCnpj = new TextFieldComponent();
        jTextFieldName = new TextFieldComponent();
        jButtonSave = new ButtonComponent("Salvar");
        jButtonClear = new ButtonComponent("Limpar");
        jButtonDelete = new ButtonComponent("Deletar");
        head = new HeadComponent("Cadastrar Fornecedor");
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
        lbackground.setIcon(new ImageIcon(getClass().getResource("/views/images/back.png")));
        
        
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

    public TextFieldComponent getjTextFieldCnpj() {
        return jTextFieldCnpj;
    }

    public void setjTextFieldCnpj(TextFieldComponent jTextFieldCnpj) {
        this.jTextFieldCnpj = jTextFieldCnpj;
    }

    public TextFieldComponent getjTextFieldName() {
        return jTextFieldName;
    }

    public void setjTextFieldName(TextFieldComponent jTextFieldName) {
        this.jTextFieldName = jTextFieldName;
    }

    public HeadComponent getHead() {
        return head;
    }

    public void setHead(HeadComponent head) {
        this.head = head;
    }

    public JLabel getLbackground() {
        return lbackground;
    }

    public void setLbackground(JLabel lbackground) {
        this.lbackground = lbackground;
    }
    
    
    
}
