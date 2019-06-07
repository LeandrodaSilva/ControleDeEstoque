/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Sgbd;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Item;
import model.Provider;

/**
 *
 * @author ld_si
 */
public final class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    private static Point point;
    private static ArrayList providers;
    private static ArrayList itens;
    public static DefaultTableModel dtmItem;
    public static DefaultTableModel dtmProvider;
    public static int selected;

    public MainUI() {
        MainUI.point = new Point();
        MainUI.dtmItem = new DefaultTableModel();
        MainUI.dtmProvider = new DefaultTableModel();
        initComponents();
        confModelItem(dtmItem);
        confModelProvider(dtmProvider);
        switch (Sgbd.readSettings().getMode()) {
            case 0:
                if (!Sgbd.notExist(Sgbd.DIRITEM)) {
                    try {
                        populaTabelaItem();
                    } catch (IOException ex) {
                        System.out.println("Erro ao popular a tabela itens");
                    }
                }
                break;
            case 1:
                if (!Sgbd.notExist(Sgbd.DIRITEMB)) {
                    try {
                        populaTabelaItem();
                    } catch (IOException ex) {
                        System.out.println("Erro ao popular a tabela itens");
                    }
                    break;
                }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSearch = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimizar = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jComboBoxType = new javax.swing.JComboBox<>();
        jLabelTittle = new javax.swing.JLabel();
        jLabelShow = new javax.swing.JLabel();
        jButtonEdit = new javax.swing.JButton();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de estoque");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabelSearch.setText("Pesquisar");
        jLabelSearch.setFocusable(false);
        getContentPane().add(jLabelSearch);
        jLabelSearch.setBounds(10, 110, 110, 20);

        jTextFieldSearch.setMinimumSize(new java.awt.Dimension(14, 200));
        jTextFieldSearch.setPreferredSize(new java.awt.Dimension(400, 50));
        jTextFieldSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextFieldSearchCaretUpdate(evt);
            }
        });
        getContentPane().add(jTextFieldSearch);
        jTextFieldSearch.setBounds(120, 110, 670, 30);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Quantidade", "Nome", "Preço"
            }
        ));
        jTable.setFocusable(false);
        jTable.setShowVerticalLines(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 146, 788, 520);

        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/closeBlack.png"))); // NOI18N
        jButtonClose.setToolTipText("Fechar");
        jButtonClose.setBorder(null);
        jButtonClose.setBorderPainted(false);
        jButtonClose.setContentAreaFilled(false);
        jButtonClose.setFocusPainted(false);
        jButtonClose.setHideActionText(true);
        jButtonClose.setPreferredSize(new java.awt.Dimension(30, 30));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose);
        jButtonClose.setBounds(760, 10, 30, 30);

        jButtonMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimizeBlack.png"))); // NOI18N
        jButtonMinimizar.setToolTipText("Minimizar");
        jButtonMinimizar.setBorder(null);
        jButtonMinimizar.setBorderPainted(false);
        jButtonMinimizar.setContentAreaFilled(false);
        jButtonMinimizar.setFocusPainted(false);
        jButtonMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinimizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMinimizar);
        jButtonMinimizar.setBounds(710, 10, 30, 30);

        jButtonInsert.setText("Adicionar");
        jButtonInsert.setFocusable(false);
        jButtonInsert.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButtonInsert.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonInsert.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsert);
        jButtonInsert.setBounds(200, 70, 100, 30);

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produtos", "Fornecedor" }));
        jComboBoxType.setFocusable(false);
        jComboBoxType.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jComboBoxTypeMouseWheelMoved(evt);
            }
        });
        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxType);
        jComboBoxType.setBounds(70, 70, 110, 25);

        jLabelTittle.setFont(jLabelTittle.getFont().deriveFont(jLabelTittle.getFont().getSize()+24f));
        jLabelTittle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTittle.setText("Controle de Estoque");
        jLabelTittle.setFocusable(false);
        getContentPane().add(jLabelTittle);
        jLabelTittle.setBounds(150, 0, 510, 50);

        jLabelShow.setText("Mostrar");
        jLabelShow.setFocusable(false);
        getContentPane().add(jLabelShow);
        jLabelShow.setBounds(10, 70, 60, 15);

        jButtonEdit.setText("Editar");
        jButtonEdit.setFocusable(false);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEdit);
        jButtonEdit.setBounds(310, 70, 110, 31);

        jLabelBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/white-wallpapers.jpeg"))); // NOI18N
        getContentPane().add(jLabelBackground);
        jLabelBackground.setBounds(0, 0, 800, 600);

        getAccessibleContext().setAccessibleParent(this);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        switch (jComboBoxType.getSelectedItem().toString()) {
            case "Produtos":
                InsertItemUI insertItemUI = new InsertItemUI(this, "new");
                insertItemUI.setVisible(true);
                insertItemUI.setAlwaysOnTop(true);
                break;
            case "Fornecedor":
                InsertProviderUI insertProviderUI = new InsertProviderUI(this, "new");
                insertProviderUI.mainUI = this;
                insertProviderUI.setVisible(true);
                insertProviderUI.setAlwaysOnTop(true);
                break;
        }
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jTextFieldSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextFieldSearchCaretUpdate

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable.getModel());
        jTable.setRowSorter(sorter);
        String text = jTextFieldSearch.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.err.println("Erro na busca: " + pse.getMessage());
            }
        }
    }//GEN-LAST:event_jTextFieldSearchCaretUpdate

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane,
                "Deseja realmente sair?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinimizarActionPerformed
        this.setExtendedState(MainUI.ICONIFIED);
    }//GEN-LAST:event_jButtonMinimizarActionPerformed


    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        MainUI.point.x = evt.getX();
        MainUI.point.y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        selected = jTable.getSelectedRow();
        System.out.println("Indice selecionado: " + selected);

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            jButtonEdit.doClick();
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if (jTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um item primeiro", "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        switch (jComboBoxType.getSelectedItem().toString()) {
            case "Produtos":
                System.out.println("Entrou opcao editar\nTodos os itens:\n");
                for (int i = 0; i < itens.size(); i++) {
                    Item teste = (Item) itens.get(i);
                    System.out.println(teste.getItemCode());
                }
                InsertItemUI insertItemUI = new InsertItemUI(
                        this,
                        "edit",
                        MainUI.itens,
                        selected
                );
                insertItemUI.setTitle("Editar Produto");
                insertItemUI.setVisible(true);
                insertItemUI.setAlwaysOnTop(true);
                break;
            case "Fornecedor":
                System.out.println("Entrou opcao editar\nTodos os fornecedores:\n");
                for (int i = 0; i < providers.size(); i++) {
                    Provider provider = (Provider) providers.get(i);
                    System.out.println(provider.getCnpj());
                }
                InsertProviderUI insertProviderUI = new InsertProviderUI(
                        this,
                        "edit",
                        MainUI.providers,
                        selected
                );
                insertProviderUI.setTitle("Editar Fornecedor");
                insertProviderUI.setVisible(true);
                insertProviderUI.setAlwaysOnTop(true);
                break;
        }
        this.setEnabled(false);
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
        switch (jComboBoxType.getSelectedItem().toString()) {
            case "Produtos": {
                try {
                    if (!Sgbd.notExist(Sgbd.DIRITEM)) {
                        populaTabelaItem();
                        jTable.setModel(dtmItem);
                    } else {
                        dtmProvider.setNumRows(0);
                        dtmItem.setNumRows(0);
                        jTable.setModel(dtmItem);
                        jTable.getColumn("Descrição").setMinWidth(0);
                        jTable.getColumn("Descrição").setPreferredWidth(0);
                        jTable.getColumn("Descrição").setMaxWidth(0);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Fornecedor": {
                if (Sgbd.readSettings().getMode() == 1) {
                    jComboBoxType.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(rootPane, "Essa tabela está inativa no modo binário", "Alerta", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        if (!Sgbd.notExist(Sgbd.DIRPROVIDER)) {
                            populaTabelaProvider();
                            jTable.setModel(dtmProvider);
                        } else {
                            dtmItem.setNumRows(0);
                            dtmProvider.setNumRows(0);
                            jTable.setModel(dtmProvider);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            break;
        }
    }//GEN-LAST:event_jComboBoxTypeActionPerformed

    private void jComboBoxTypeMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jComboBoxTypeMouseWheelMoved
        if (evt.getWheelRotation() < 0) {
            jComboBoxType.setSelectedIndex(0);
        }
        if (evt.getWheelRotation() > 0) {
            if (Sgbd.readSettings().getMode() == 1) {
                JOptionPane.showMessageDialog(rootPane, "Essa tabela está inativa no modo binário", "Alerta", JOptionPane.WARNING_MESSAGE);
            } else {
                jComboBoxType.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_jComboBoxTypeMouseWheelMoved

    public static void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonMinimizar;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelShow;
    private javax.swing.JLabel jLabelTittle;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables

    public void populaTabelaItem() throws IOException {
        String[] linha = new String[5];
        dtmItem = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        confModelItem(dtmItem);

        MainUI.itens = (ArrayList<Item>) Sgbd.readItem();
        int size = itens.size();
        Item item;

        for (int i = 0; i < size; i++) {
            item = (Item) itens.get(i);
            linha[0] = Integer.toString(item.getItemCode());
            linha[1] = Integer.toString(item.getItemQuantity());
            linha[2] = item.getItemName();
            linha[3] = item.getItemDescription();
            linha[4] = Double.toString(item.getItemPrice());
            dtmItem.addRow(linha);
        }

        jTable.setModel(dtmItem);

        jTable.getColumn("Descrição").setMinWidth(0);
        jTable.getColumn("Descrição").setPreferredWidth(0);
        jTable.getColumn("Descrição").setMaxWidth(0);

        RowSorter<TableModel> sorter = new TableRowSorter<>(dtmItem);
        jTable.setRowSorter(sorter);
    }

    public void populaTabelaProvider() throws IOException {
        String[] linha = new String[3];
        dtmProvider = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        confModelProvider(dtmProvider);

        MainUI.providers = (ArrayList<Provider>) Sgbd.readProvider();
        int size = providers.size();
        Provider provider;

        for (int i = 0; i < size; i++) {
            provider = (Provider) providers.get(i);
            linha[0] = provider.getName();
            linha[1] = provider.getCnpj();
            linha[2] = provider.getAdress();
            dtmProvider.addRow(linha);
        }

        jTable.setModel(dtmProvider);

        RowSorter<TableModel> sorter = new TableRowSorter<>(dtmProvider);
        jTable.setRowSorter(sorter);
    }

    public void populaTabelaItem(Item item) throws IOException {
        String[] linha = new String[5];
        dtmItem = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        confModelItem(dtmItem);

        linha[0] = Integer.toString(item.getItemCode());
        linha[1] = Integer.toString(item.getItemQuantity());
        linha[2] = item.getItemName();
        linha[3] = item.getItemDescription();
        linha[4] = Double.toString(item.getItemPrice());

        dtmItem.addRow(linha);

        jTable.setModel(dtmItem);

        jTable.getColumn("Descrição").setMinWidth(0);
        jTable.getColumn("Descrição").setPreferredWidth(0);
        jTable.getColumn("Descrição").setMaxWidth(0);

        RowSorter<TableModel> sorter = new TableRowSorter<>(dtmItem);
        jTable.setRowSorter(sorter);
    }

    public void populaTabelaProvider(Provider provider) throws IOException {
        String[] linha = new String[3];
        dtmProvider = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        confModelProvider(dtmProvider);

        linha[0] = provider.getName();
        linha[1] = provider.getCnpj();
        linha[2] = provider.getAdress();

        dtmProvider.addRow(linha);

        jTable.setModel(dtmProvider);

        RowSorter<TableModel> sorter = new TableRowSorter<>(dtmProvider);
        jTable.setRowSorter(sorter);
    }

    public void confModelItem(DefaultTableModel dtm) {
        dtm.addColumn("Código");
        dtm.addColumn("Quantidade");
        dtm.addColumn("Nome");
        dtm.addColumn("Descrição");
        dtm.addColumn("Preço");
    }

    public void confModelProvider(DefaultTableModel dtm) {
        dtm.addColumn("Nome da Empresa");
        dtm.addColumn("CNPJ");
        dtm.addColumn("Endereço");
    }

}