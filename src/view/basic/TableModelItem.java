/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.dataAcessObject.ItemDAO;
import model.valueObject.Item;
import static view.MainUI.dtmItem;

/**
 *
 * @author ld_si
 */
public class TableModelItem extends DefaultTableModel {
    public static ArrayList itemArray;
    
    public TableModelItem() {
        addColumn("Código");
        addColumn("Quantidade");
        addColumn("Nome");
        addColumn("Descrição");
        addColumn("Preço");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
    public void loadTableModelRowsValues() {
        try {
            String[] lines = new String[5];
            this.itemArray = (ArrayList<Item>) ItemDAO.readItem();
            int size = this.itemArray.size();

            Item item;

            for (int i = 0; i < size; i++) {
                item = (Item) this.itemArray.get(i);
                lines[0] = Integer.toString(item.getItemCode());
                lines[1] = Integer.toString(item.getItemQuantity());
                lines[2] = item.getItemName();
                lines[3] = item.getItemDescription();
                lines[4] = Double.toString(item.getItemPrice());
                dtmItem.addRow(lines);
            }
            System.out.println("loadTableModelItemRowsValues - sucess!");
        } catch (IOException ex) {
            System.out.println(this.getClass().toString()+" - Erro: " + ex.getMessage());
        }
    }
}
