/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.util.ArrayList;

import models.dataAcessObject.ItemDAO;
import models.valueObject.ItemVO;
import views.ItemView;
import views.ProviderView;
import views.LoginView;
import views.HomeView;
import views.ReportView;
import views.components.TableModelItemComponent;
import views.components.TableModelProviderComponent;

import javax.swing.*;

/**
 *
 * @author ld_si
 */
public class HomeController extends EffectController {

    private HomeView main;
    protected TableModelItemComponent tmItem;
    protected TableModelProviderComponent tmProvider;
    protected int selected;
    protected ArrayList<ItemVO> itens;

    public HomeController(HomeView main) {
        this.main = main;

        tmItem = new TableModelItemComponent();
        tmItem.loadTableModelRowsValues();
        tmProvider = new TableModelProviderComponent();
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
        
        HeadController.add(this.main.getHead(), this.main);
        add(main.getjButtonInsert());
        add(main.getjButtonEdit());
        add(main.getjTextFieldSearch());
        add(main.getjComboBoxType());
        add(main.getjButtonRelatorio());
        add(main.getjButtonSair());

        new SearchController(main.getjTextFieldSearch(),
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
                    ItemView insert = new ItemView();
                    insert.getHead().getbMinimize().setEnabled(false);
                    insert.getjButtonDelete().setEnabled(false);
                    insert.getjButtonDelete().setBorder(insert.getjButtonDelete().border.grey);
                    new ItemController(insert, this.main, this, ItemController.NEW);
                    this.main.setEnabled(false);
                    insert.setVisible(true);
                    break;
                case "Fornecedor":
                    ProviderView insertProvider = new ProviderView();
                    insertProvider.setVisible(true);
                    new ProviderController(insertProvider, this.main, this, ProviderController.NEW);
                    this.main.setEnabled(false);
                    break;
            }
        }

        if (e.getSource() == this.main.getjButtonEdit()) {
            System.out.println("Edit");
            switch(this.main.getjComboBoxType().getSelectedItem().toString()){
                case "Produtos":
                    ItemView insert = new ItemView();
                    insert.getHead().getbMinimize().setEnabled(false);
                    new ItemController(insert, this.main, this, ItemController.EDIT);
                    this.main.setEnabled(false);
                    insert.setVisible(true);
                    break;
                case "Fornecedor":
                    ProviderView insertProvider = new ProviderView();
                    insertProvider.setVisible(true);
                    new ProviderController(insertProvider, this.main, this, ProviderController.EDIT);
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
            new LoginController(new LoginView());
        }
        
        if (e.getSource() == this.main.getjButtonRelatorio()) {
            ReportView frame = new ReportView();
            frame.setVisible(true);
            new ReportController(frame, this.main);
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
