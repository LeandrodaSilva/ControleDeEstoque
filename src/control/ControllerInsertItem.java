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
import javax.swing.JOptionPane;
import model.businessObject.RandomValue;
import model.dataAcessObject.DirDAO;
import model.dataAcessObject.ItemDAO;
import model.dataAcessObject.SettingsDAO;
import model.interfaces.Operations;
import model.valueObject.Item;
import view.InsertItem;
import view.Main;
import view.basic.TableModelItem;

/**
 *
 * @author ld_si
 */
public class ControllerInsertItem extends Controller implements Operations {

    private InsertItem insert;
    private Main root;
    public Item item;
    private static ArrayList<Item> itens;
    public static final int NEW = 0;
    public static final int EDIT = 1;
    private int option = -1;
    private ControllerMain controllerMain;

    public ControllerInsertItem(InsertItem insert, Main root, ControllerMain controllerMain, int option) {
        this.insert = insert;
        this.root = root;
        this.controllerMain = controllerMain;
        this.option = option;

        if (option == EDIT) {
            add(insert.getjButtonDelete());
            try {
                this.itens = ItemDAO.readItem();
                this.item = itens.get(controllerMain.selected);
                setFrameElements();
            } catch (IOException ex) {
                System.out.println("Erro - " + ex.getMessage());
            }
        }

        insert.getjButtonSave().addActionListener(this);
        insert.getjButtonDelete().addActionListener(this);
        insert.getjButtonClear().addActionListener(this);

        insert.getHead().getbMinimize().setEnabled(false);
        ControllerHead.add(insert.getHead(), insert, root, 1, true);
        add(insert.getjButtonClear());
        add(insert.getjButtonSave());
        add(insert.getjTextFieldName());
        add(insert.getjTextFieldPrice());
        add(insert.getjTextFieldQuantity());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.insert.getjButtonSave()) {
            if (!verifyFrameElements()) {
                System.out.println("Erro - Campos incompletos");
                return;
            }
            if (option == EDIT) {
                edit();
            } else {
                save();
            }
        }
        if (e.getSource() == this.insert.getjButtonDelete()) {
            delete();
        }
        if (e.getSource() == this.insert.getjButtonClear()) {
            removeFrameElements();
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
        if (JOptionPane.showConfirmDialog(this.insert,
                "Deseja realmente excluir?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
            return;
        }
        try {

            itens.remove(controllerMain.selected);

            if (itens.isEmpty()) {
                if (SettingsDAO.readSettings().getMode() != 2){
                    DirDAO.deleteItemDir();
                }else{
                    ItemDAO.deleteItem(item, controllerMain.selected) ;
                }
                

                controllerMain.tmItem.removeRow(controllerMain.selected);
            } else {

                ItemDAO.deleteItem(item, controllerMain.selected) ;

                controllerMain.tmItem.removeRow(controllerMain.selected);
            }

            root.setEnabled(true);
            JOptionPane.showMessageDialog(insert, "Item deletado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            this.insert.dispose();
        } catch (IOException ex) {
            System.out.println("Erro na remoção");
            JOptionPane.showMessageDialog(this.insert, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void save() {
        this.item = new Item();
        try {
            ArrayList<Item> itens = ItemDAO.readItem();
        
            getFrameElements();
 
            setDataCode(this.item);

            itens.add(item);

            
            ItemDAO.deleteItem(item, controllerMain.selected);
            
            ItemDAO.writeItem(itens);
            
            controllerMain.tmItem = new TableModelItem();
            controllerMain.tmItem.loadTableModelRowsValues();
            root.jTable.setModel(controllerMain.tmItem);

            root.setEnabled(true);

            JOptionPane.showMessageDialog(this.insert, "Item cadastrado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);

            this.insert.dispose();
        } catch (IOException ex) {
            System.out.println("Erro na inserção");
            JOptionPane.showMessageDialog(this.insert, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setDataCode(Item item) {
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
        try {
            getFrameElements();
            
            ItemDAO.editItem(item, controllerMain.selected);
            

            controllerMain.tmItem = new TableModelItem();
            controllerMain.tmItem.loadTableModelRowsValues();
            root.jTable.setModel(controllerMain.tmItem);
            root.setEnabled(true);

            JOptionPane.showMessageDialog(this.insert, "Item editado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);

            this.insert.dispose();

        } catch (FileNotFoundException ex) {
            System.out.println("edit - Erro: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("edit - Erro: " + ex.getMessage());
        }

    }

}
