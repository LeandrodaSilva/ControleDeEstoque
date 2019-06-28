/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.businessObject.RandomValue;
import model.dataAcessObject.DirDAO;
import model.dataAcessObject.ItemDAO;
import model.dataAcessObject.SettingsDAO;
import model.interfaces.Operations;
import model.valueObject.Item;
import view.InsertItem;
import view.Main;

/**
 *
 * @author ld_si
 */
public class ControllerInsertItem extends Controller implements Operations{
    
    private InsertItem insert;
    private Main root;
    public Item item;
    private static ArrayList<Item> itens;
    public String option = "new";
    private ControllerMain controllerMain;
    
    public ControllerInsertItem(InsertItem insert, Main root, ControllerMain controllerMain) {
        this.insert = insert;
        this.root = root;
        this.controllerMain = controllerMain;
        
        insert.getjButtonSave().addActionListener(this);
        
        insert.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(insert.getHead(), insert, root, 1, true);
        add(insert.getjButtonClear());
        add(insert.getjButtonDelete());
        add(insert.getjButtonSave());
        add(insert.getjTextFieldName());
        add(insert.getjTextFieldPrice());
        add(insert.getjTextFieldQuantity());
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.insert.getjButtonSave()) {
            save();
        }
        
    }

    @Override
    public void setFrameElements() {
        this.insert.getjTextFieldQuantity().setText(Integer.toString(item.getItemQuantity()));
        this.insert.getjTextFieldPrice().setText(Double.toString(item.getItemPrice()));
        this.insert.getjTextAreaDescription().setText(item.getItemDescription());
        this.insert.getjTextFieldName().setText(item.getItemName());
    }

    @Override
    public void delete() {
//        if (JOptionPane.showConfirmDialog(this.insert,
//                "Deseja realmente excluir?", "Confirmação",
//                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
//            return;
//        }
//        try {
//            getFrameElements();
//
//            int index = 0;
//            for (int i = 0; i < itens.size(); i++) {
//                if (itens.get(i).getItemCode() == item.getItemCode()) {
//                    index = i;
//                    itens.remove(index);
//                    break;
//                }
//            }
//
//            if (itens.isEmpty()) {
//                switch (SettingsDAO.readSettings().getMode()) {
//                    case 0:
//                        DirDAO.delete(DirDAO.dir.getDirItem());
//                        break;
//                    case 1:
//                        DirDAO.delete(DirDAO.dir.getDirItemBinary());
//                        break;
//                }
//
//                DefaultTableModel dtm = (DefaultTableModel) root.getjTable().getModel();
//                dtm.removeRow(index);
//            } else {
//                switch (SettingsDAO.readSettings().getMode()) {
//                    case 0:
//                        DirDAO.delete(DirDAO.dir.getDirItem());
//                        for (int i = 0; i < itens.size(); i++) {
//                            ItemDAO.writeItem(itens.get(i));
//                        }
//                        break;
//                    case 1:
//                        DirDAO.delete(DirDAO.dir.getDirItemBinary());
//                        ItemDAO.writeItem(itens);
//                        break;
//                }
//
//                root.reloadTableItem();
//            }
//
//            root.setEnabled(true);
//            JOptionPane.showMessageDialog(rootPane, "Item deletado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
//            this.dispose();
//        } catch (IOException ex) {
//            System.out.println("Erro na remoção");
//            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//        }
    }

    @Override
    public void save() {
        this.item = new Item();
        if (!verifyFrameElements()) {
            System.out.println("Erro - Campos incompletos");
            return;
        }
        try {
            ArrayList<Item> itens = ItemDAO.readItem();
            getFrameElements();

            if (option.equals("edit")) {
                edit();
                return;
            }

            setDataCode();

            itens.add(item);
            DirDAO.delete(DirDAO.dir.getDirItem());
            ItemDAO.writeItem(itens);

            root.getjTable().refresh(controllerMain.tmItem);
            root.getjTable().repaint();
            root.setEnabled(true);

            JOptionPane.showMessageDialog(this.insert, "Item cadastrado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);

            this.insert.dispose();
        } catch (IOException ex) {
            System.out.println("Erro na inserção");
            JOptionPane.showMessageDialog(this.insert, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setDataCode() {
        RandomValue rv = new RandomValue();
        item.setItemCode(rv.getRandomCode());
    }

    @Override
    public void getFrameElements() {
        item.setItemQuantity(Integer.parseInt(this.insert.getjTextFieldQuantity().getText()));
        item.setItemName(this.insert.getjTextFieldName().getText());
        item.setItemDescription(this.insert.getjTextAreaDescription().getText());
        item.setItemPrice(Double.parseDouble(this.insert.getjTextFieldPrice().getText()));
    }

    @Override
    public boolean verifyFrameElements() {
        try {
            Integer.parseInt(this.insert.getjTextFieldQuantity().getText());
            this.insert.getjTextFieldQuantity().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.insert, "Somente números na quantidade", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.insert.getjTextFieldQuantity().setText("");
            this.insert.getjTextFieldQuantity().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            return false;
        }
        try {
            Double.parseDouble(this.insert.getjTextFieldPrice().getText());
            this.insert.getjTextFieldPrice().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.insert, "Somente números de ponto flutuante no preço", "Alerta", JOptionPane.WARNING_MESSAGE);
            this.insert.getjTextFieldPrice().setText("");
            this.insert.getjTextFieldPrice().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            return false;
        }
        return true;
    }

    @Override
    public void removeFrameElements() {
        this.insert.getjTextFieldPrice().setText("");
        this.insert.getjTextFieldQuantity().setText("");
        this.insert.getjTextFieldName().setText("");
        this.insert.getjTextAreaDescription().setText("");
    }

    public void edit() {
//        try {
//            int index = 0;
//            for (int i = 0; i < itens.size(); i++) {
//                if (itens.get(i).getItemCode() == item.getItemCode()) {
//                    index = i;
//                    itens.set(index, item);
//                    break;
//                }
//            }
//            switch (SettingsDAO.readSettings().getMode()) {
//                case 0:
//                    DirDAO.delete(DirDAO.dir.getDirItem());
//                    for (int i = 0; i < itens.size(); i++) {
//                        ItemDAO.writeItem(itens.get(i));
//                    }
//                    break;
//                default:
//                    DirDAO.delete(DirDAO.dir.getDirItemBinary());
//                    ItemDAO.writeItem(itens);
//            }
//            root.reloadTableItem();
//            root.setEnabled(true);
//
//            JOptionPane.showMessageDialog(rootPane, "Item cadastrado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
//
//            this.dispose();
//
//        } catch (FileNotFoundException ex) {
//            System.out.println("edit - Erro: "+ex.getMessage());
//        } catch (IOException ex) {
//            System.out.println("edit - Erro: "+ex.getMessage());
//        }

    }
    
}
