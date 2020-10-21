/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import views.components.ButtonComponent;
import views.components.ComboBoxComponent;
import views.components.HeadComponent;
import views.components.TableComponent;
import views.components.TextFieldComponent;

/**
 *
 * @author ld_si
 */
public class HomeView extends JFrame{
    private HeadComponent head;
    private ButtonComponent jButtonEdit;
    private ButtonComponent jButtonInsert;
    private ButtonComponent jButtonRelatorio;
    private ButtonComponent jButtonSair;
    private ComboBoxComponent jComboBoxType;
    private JLabel jLabelBackground;
    private JLabel jLabelSearch;
    private JLabel jLabelShow;
    private JScrollPane jScrollPane1;
    public TableComponent jTable;
    private TextFieldComponent jTextFieldSearch;
    

    public HomeView() {
        
        this.setTitle("Controle de Estoque");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        
        this.head = new HeadComponent("Controle de Estoque");
        this.head.setBounds(0, 0, 800, 50);

        this.jButtonEdit = new ButtonComponent("Editar");
        this.jButtonEdit.setBounds(360 , 70, 110, 30);

        this.jButtonRelatorio = new ButtonComponent("Relatório");
        this.jButtonRelatorio.setBounds(480 , 70, 110, 30);

        this.jButtonInsert = new ButtonComponent("Inserir");
        this.jButtonInsert.setBounds(250, 70, 100, 30);

        this.jButtonSair = new ButtonComponent("Sair");
        this.jButtonSair.setBounds(680, 70, 100, 30);

        this.jLabelBackground = new JLabel();
        this.jLabelBackground.setBounds(0, 50, 800, 550);
        this.jLabelBackground.setIcon(new ImageIcon(getClass().getResource("/views/images/back.png")));

        this.jLabelShow = new JLabel("Mostrar");
        this.jLabelShow.setBounds(10, 70, 60, 16);

        this.jLabelSearch = new JLabel("Pesquisar");
        this.jLabelSearch.setBounds(10, 110, 110, 20);

        this.jComboBoxType = new ComboBoxComponent(new DefaultComboBoxModel<>(
                new String[] { "Produtos", "Fornecedor" }));
        this.jComboBoxType.setBounds(120, 70, 110, 30);
        
        
        this.jScrollPane1 = new JScrollPane();

        this.jTable = new TableComponent();
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

        this.jTextFieldSearch = new TextFieldComponent();
        this.jTextFieldSearch.setBounds(120, 110, 670, 30);
       
        
        this.add(head);
        this.add(jButtonInsert);
        this.add(jButtonEdit);
        this.add(jButtonRelatorio);
        this.add(jButtonSair);
        this.add(jTextFieldSearch);
        this.add(jLabelShow);
        this.add(jLabelSearch);
        this.add(jComboBoxType);
        this.add(jLabelBackground);
        
        
    }

    public ButtonComponent getjButtonRelatorio() {
        return jButtonRelatorio;
    }

    public void setjButtonRelatorio(ButtonComponent jButtonRelatorio) {
        this.jButtonRelatorio = jButtonRelatorio;
    }
    
    
    public HeadComponent getHead() {
        return head;
    }

    public void setHead(HeadComponent head) {
        this.head = head;
    }

    public ButtonComponent getjButtonEdit() {
        return jButtonEdit;
    }

    public void setjButtonEdit(ButtonComponent jButtonEdit) {
        this.jButtonEdit = jButtonEdit;
    }

    public ButtonComponent getjButtonInsert() {
        return jButtonInsert;
    }

    public void setjButtonInsert(ButtonComponent jButtonInsert) {
        this.jButtonInsert = jButtonInsert;
    }

    public ComboBoxComponent getjComboBoxType() {
        return jComboBoxType;
    }

    public void setjComboBoxType(ComboBoxComponent jComboBoxType) {
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

    public TableComponent getjTable() {
        return jTable;
    }

    public void setjTable(TableComponent jTable) {
        this.jTable = jTable;
    }

    public TextFieldComponent getjTextFieldSearch() {
        return jTextFieldSearch;
    }

    public void setjTextFieldSearch(TextFieldComponent jTextFieldSearch) {
        this.jTextFieldSearch = jTextFieldSearch;
    }

    public ButtonComponent getjButtonSair() {
        return jButtonSair;
    }

    public void setjButtonSair(ButtonComponent jButtonSair) {
        this.jButtonSair = jButtonSair;
    }
}
