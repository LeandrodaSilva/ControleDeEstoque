/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import view.basic.Button;
import view.basic.Head;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class Main extends javax.swing.JFrame{
    private Head head;
    private JButton jButtonEdit;
    private JButton jButtonInsert;
    private JComboBox<String> jComboBoxType;
    private JLabel jLabelBackground;
    private JLabel jLabelSearch;
    private JLabel jLabelShow;
    private JScrollPane jScrollPane1;
    public JTable jTable;
    private TextField jTextFieldSearch;

    public Main() {
        this.setTitle("Controle de Estoque");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        this.head = new Head("Controle de Estoque");
        this.head.setBounds(0, 0, 800, 50);
        this.jButtonEdit = new Button("Editar");
        this.jButtonInsert = new Button("Inserir");
        this.jLabelBackground = new JLabel();
        this.jLabelShow = new JLabel("Mostrar");
        this.jLabelSearch = new JLabel("Pesquisar");
        this.jComboBoxType = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.jTable = new JTable();
        this.jTextFieldSearch = new TextField();
        
        this.add(head);
        
        
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public JButton getjButtonEdit() {
        return jButtonEdit;
    }

    public void setjButtonEdit(JButton jButtonEdit) {
        this.jButtonEdit = jButtonEdit;
    }

    public JButton getjButtonInsert() {
        return jButtonInsert;
    }

    public void setjButtonInsert(JButton jButtonInsert) {
        this.jButtonInsert = jButtonInsert;
    }

    public JComboBox<String> getjComboBoxType() {
        return jComboBoxType;
    }

    public void setjComboBoxType(JComboBox<String> jComboBoxType) {
        this.jComboBoxType = jComboBoxType;
    }

    public JLabel getjLabelBackground() {
        return jLabelBackground;
    }

    public void setjLabelBackground(JLabel jLabelBackground) {
        this.jLabelBackground = jLabelBackground;
    }

    public JLabel getjLabelSearch() {
        return jLabelSearch;
    }

    public void setjLabelSearch(JLabel jLabelSearch) {
        this.jLabelSearch = jLabelSearch;
    }

    public JLabel getjLabelShow() {
        return jLabelShow;
    }

    public void setjLabelShow(JLabel jLabelShow) {
        this.jLabelShow = jLabelShow;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public TextField getjTextFieldSearch() {
        return jTextFieldSearch;
    }

    public void setjTextFieldSearch(TextField jTextFieldSearch) {
        this.jTextFieldSearch = jTextFieldSearch;
    }
    
    
}
