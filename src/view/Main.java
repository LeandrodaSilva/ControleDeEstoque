/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import view.basic.Button;
import view.basic.ComboBox;
import view.basic.Head;
import view.basic.Table;
import view.basic.TextField;

/**
 *
 * @author ld_si
 */
public class Main extends JFrame{
    private Head head;
    private Button jButtonEdit;
    private Button jButtonInsert;
    private Button jButtonRelatorio;
    private ComboBox jComboBoxType;
    private JLabel jLabelBackground;
    private JLabel jLabelSearch;
    private JLabel jLabelShow;
    private JScrollPane jScrollPane1;
    public Table jTable;
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
        this.jButtonEdit.setBounds(360 , 70, 110, 30);
        this.jButtonRelatorio = new Button("Relatório");
        this.jButtonRelatorio.setBounds(480 , 70, 110, 30);
        this.jButtonInsert = new Button("Inserir");
        this.jButtonInsert.setBounds(250, 70, 100, 30);
        this.jLabelBackground = new JLabel();
        this.jLabelBackground.setBounds(0, 50, 800, 550);
        this.jLabelBackground.setIcon(new ImageIcon(getClass().getResource("/view/images/back.png")));
        this.jLabelShow = new JLabel("Mostrar");
        this.jLabelShow.setBounds(10, 70, 60, 16);
        this.jLabelSearch = new JLabel("Pesquisar");
        this.jLabelSearch.setBounds(10, 110, 110, 20);
        this.jComboBoxType = new ComboBox(new DefaultComboBoxModel<>(
                new String[] { "Produtos", "Fornecedor" }));
        this.jComboBoxType.setBounds(120, 70, 110, 30);
        
        
        this.jScrollPane1 = new JScrollPane();
        this.jTable = new Table();
        this.jTable.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Quantidade", "Nome", "Preço"
            }
        ));
        this.jTable.setFocusable(false);
        this.jTable.setShowVerticalLines(false);
        this.jScrollPane1.setViewportView(jTable);
        this.getContentPane().add(jScrollPane1);
        this.jScrollPane1.setBounds(6, 146, 788, 520);
        this.jTextFieldSearch = new TextField();
        this.jTextFieldSearch.setBounds(120, 110, 670, 30);
       
        
        this.add(head);
        this.add(jButtonInsert);
        this.add(jButtonEdit);
        this.add(jButtonRelatorio);
        this.add(jTextFieldSearch);
        this.add(jLabelShow);
        this.add(jLabelSearch);
        this.add(jComboBoxType);
        this.add(jLabelBackground);
        
        
    }

    public Button getjButtonRelatorio() {
        return jButtonRelatorio;
    }

    public void setjButtonRelatorio(Button jButtonRelatorio) {
        this.jButtonRelatorio = jButtonRelatorio;
    }
    
    
    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Button getjButtonEdit() {
        return jButtonEdit;
    }

    public void setjButtonEdit(Button jButtonEdit) {
        this.jButtonEdit = jButtonEdit;
    }

    public Button getjButtonInsert() {
        return jButtonInsert;
    }

    public void setjButtonInsert(Button jButtonInsert) {
        this.jButtonInsert = jButtonInsert;
    }

    public ComboBox getjComboBoxType() {
        return jComboBoxType;
    }

    public void setjComboBoxType(ComboBox jComboBoxType) {
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

    public Table getjTable() {
        return jTable;
    }

    public void setjTable(Table jTable) {
        this.jTable = jTable;
    }

    public TextField getjTextFieldSearch() {
        return jTextFieldSearch;
    }

    public void setjTextFieldSearch(TextField jTextFieldSearch) {
        this.jTextFieldSearch = jTextFieldSearch;
    }
    
    
}
