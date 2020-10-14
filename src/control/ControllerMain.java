/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.util.ArrayList;
import model.dataAcessObject.ItemDAO;
import model.valueObject.Item;
import view.InsertItem;
import view.InsertProvider;
import view.Login;
import view.Main;
import view.basic.Relatorio;
import view.basic.TableModelItem;
import view.basic.TableModelProvider;

import javax.swing.*;

/**
 *
 * @author ld_si
 */
public class ControllerMain extends Controller{

    private Main main;
    protected TableModelItem tmItem;
    protected TableModelProvider tmProvider;
    protected int selected;
    protected ArrayList<Item> itens;

    public ControllerMain(Main main) {
        this.main = main;

        tmItem = new TableModelItem();
        tmItem.loadTableModelRowsValues();
        tmProvider = new TableModelProvider();
        tmProvider.loadTableModelRowsValues();
        
        try {
            itens = ItemDAO.readItem();
        } catch (IOException ex) {
            System.out.println("Erro controllerMain - "+ex.getMessage());
        }
        
        main.getjComboBoxType().addActionListener(this);
        main.getjComboBoxType().addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent evt) {
                jComboBoxTypeMouseWheelMoved(evt);
            }
        });
        main.getjButtonInsert().addActionListener(this);
        this.main.getjTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        
        main.getjButtonEdit().addActionListener(this);
        main.getjButtonRelatorio().addActionListener(this);
        main.getjButtonSair().addActionListener(this);
        
        ControllerHead.add(this.main.getHead(), this.main);
        add(main.getjButtonInsert());
        add(main.getjButtonEdit());
        add(main.getjTextFieldSearch());
        add(main.getjComboBoxType());
        add(main.getjButtonRelatorio());
        add(main.getjButtonSair());

        new ControllerSearch(main.getjTextFieldSearch(),
                this.main.getjTable());

        this.main.getjTable().setModel(tmItem);
        //this.main.getjTable().hideColumn("Descrição");

        this.main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.main.getjComboBoxType()) {
            switch (this.main.getjComboBoxType().getSelectedItem().toString()) {
                case "Produtos":
                    this.main.getjTable().setModel(tmItem);
                    //this.main.getjTable().hideColumn("Descrição");
                    break;
                case "Fornecedor":
                    this.main.getjTable().setModel(tmProvider);
                    break;
            }
        }

        if (e.getSource() == this.main.getjButtonInsert()) {
            System.out.println("Insert");
            switch(this.main.getjComboBoxType().getSelectedItem().toString()){
                case "Produtos":
                    InsertItem insert = new InsertItem();
                    insert.getHead().getbMinimize().setEnabled(false);
                    insert.getjButtonDelete().setEnabled(false);
                    insert.getjButtonDelete().setBorder(insert.getjButtonDelete().border.grey);
                    new ControllerInsertItem(insert, this.main, this, ControllerInsertItem.NEW);
                    this.main.setEnabled(false);
                    insert.setVisible(true);
                    break;
                case "Fornecedor":
                    InsertProvider insertProvider = new InsertProvider();
                    insertProvider.setVisible(true);
                    new ControllerInsertProvider(insertProvider, this.main);
                    this.main.setEnabled(false);
                    break;
            }
        }

        if (e.getSource() == this.main.getjButtonEdit()) {
            System.out.println("Edit");
            switch(this.main.getjComboBoxType().getSelectedItem().toString()){
                case "Produtos":
                    InsertItem insert = new InsertItem();
                    insert.getHead().getbMinimize().setEnabled(false);
                    new ControllerInsertItem(insert, this.main, this, ControllerInsertItem.EDIT);
                    this.main.setEnabled(false);
                    insert.setVisible(true);
                    break;
                case "Fornecedor":
                    InsertProvider insertProvider = new InsertProvider();
                    insertProvider.setVisible(true);
                    new ControllerInsertProvider(insertProvider, this.main);
                    this.main.setEnabled(false);
                    break;
            }
        }

        if (e.getSource() == this.main.getjButtonSair()) {
            System.out.println("Sair");
            if (JOptionPane.showConfirmDialog(this.main,
                    "Deseja realmente sair e ir para a tela de login?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION) {
                return;
            }
            this.main.dispose();
            new ControllerLogin(new Login());
        }
        
        if (e.getSource() == this.main.getjButtonRelatorio()) {
            Relatorio frame = new Relatorio();
            frame.setVisible(true);
            new ControllerRelatorio(frame, this.main);
        }
    }

    private void tableMouseClicked(MouseEvent e) {
        selected = this.main.getjTable().getSelectedRow();
        System.out.println("Indice selecionado: " + selected);

        if (e.getClickCount() == 2 && !e.isConsumed()) {
            e.consume();
            this.main.getjButtonEdit().doClick();
        }
    }

    private void jComboBoxTypeMouseWheelMoved(MouseWheelEvent evt) {
        if (evt.getWheelRotation() < 0) {
            this.main.getjComboBoxType().setSelectedIndex(0);
        }
        if (evt.getWheelRotation() > 0) {
            this.main.getjComboBoxType().setSelectedIndex(1);
        }
    }
    
   
}
