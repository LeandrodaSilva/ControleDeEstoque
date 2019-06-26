/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import view.InsertItem;
import view.Main;
import view.basic.TableModelItem;
import view.basic.TableModelProvider;

/**
 *
 * @author ld_si
 */
public class ControllerMain implements ActionListener {

    private Main main;
    private TableModelItem tmItem;
    private TableModelProvider tmProvider;
    private int selected;

    public ControllerMain(Main main) {
        this.main = main;

        this.tmItem = new TableModelItem();
        this.tmItem.loadTableModelRowsValues();

        this.tmProvider = new TableModelProvider();
        this.tmProvider.loadTableModelRowsValues();

        this.main.getjComboBoxType().addActionListener(this);
        this.main.getjComboBoxType().addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent evt) {
                jComboBoxTypeMouseWheelMoved(evt);
            }
        });
        this.main.getjButtonInsert().addActionListener(this);
        this.main.getjTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        new ControllerHead(this.main.getHead(), this.main);
        new ControllerEfect(this.main.getjButtonInsert());
        new ControllerEfect(this.main.getjButtonEdit());
        new ControllerEfect(this.main.getjTextFieldSearch());
        new ControllerEfect(this.main.getjComboBoxType());
        new ControllerSearch(this.main.getjTextFieldSearch(),
                this.main.getjTable());

        this.main.getjTable().setModel(tmItem);
        this.main.getjTable().hideColumn("Descrição");

        this.main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.main.getjComboBoxType()) {
            switch (this.main.getjComboBoxType().getSelectedItem().toString()) {
                case "Produtos":
                    this.main.getjTable().setModel(tmItem);
                    this.main.getjTable().hideColumn("Descrição");
                    break;
                case "Fornecedor":
                    this.main.getjTable().setModel(tmProvider);
                    break;
            }
        }

        if (e.getSource() == this.main.getjButtonInsert()) {
            System.out.println("Insert");
            InsertItem insert = new InsertItem();
            insert.getHead().getbMinimize().setEnabled(false);
            new ControllerInsert(insert, this.main);
            this.main.setEnabled(false);
            insert.setVisible(true);
        }

        if (e.getSource() == this.main.getjButtonEdit()) {
            System.out.println("Edit");
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
