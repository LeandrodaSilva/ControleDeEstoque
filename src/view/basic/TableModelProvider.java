/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ld_si
 */
public class TableModelProvider extends DefaultTableModel {

    public TableModelProvider() {
        addColumn("Nome da Empresa");
        addColumn("CNPJ");
        addColumn("Endereço");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
