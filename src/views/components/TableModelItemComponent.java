/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.dataAcessObject.ItemDAO;
import models.valueObject.ItemVO;

/**
 *
 * @author ld_si
 */
public class TableModelItemComponent extends DefaultTableModel {
    public static ArrayList<ItemVO> itemArray;
    
    public TableModelItemComponent() {
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
            this.itemArray =  ItemDAO.readItem();
            if (itemArray == null) {
                return;
            }
            int size = this.itemArray.size();

            ItemVO item;

            for (int i = 0; i < size; i++) {
                item = (ItemVO) this.itemArray.get(i);
                lines[0] = Integer.toString(item.getItemCode());
                lines[1] = Integer.toString(item.getItemQuantity());
                lines[2] = item.getItemName();
                lines[3] = item.getItemDescription();
                lines[4] = Double.toString(item.getItemPrice());
                addRow(lines);
            }
            System.out.println("loadTableModelItemRowsValues - sucess!");
        } catch (IOException ex) {
            System.out.println(this.getClass().toString()+" - Erro: " + ex.getMessage());
        }
    }
}
