/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import javax.swing.table.TableModel;

/**
 *
 * @author ld_si
 */
public class TableComponent extends javax.swing.JTable{

    public TableComponent() {
    }

    public TableComponent(TableModel dm) {
        super(dm);
    }
    
    public void hideColumn(String columnName) {
        switch (columnName) {
            case "Descrição":
                getColumn("Descrição").setMinWidth(0);
                getColumn("Descrição").setPreferredWidth(0);
                getColumn("Descrição").setMaxWidth(0);
                break;
        }
    }
   
    
    public void refresh(TableModelItemComponent tmItem){
        TableModelItemComponent reload = new TableModelItemComponent();
        reload.loadTableModelRowsValues();
        tmItem = reload;
        //hideColumn("Descrição");
        setModel(tmItem);       
    }
    
    public void refresh(TableModelProviderComponent tmProvider){
        tmProvider = new TableModelProviderComponent();
        tmProvider.loadTableModelRowsValues();
        setModel(tmProvider);       
    }
    
}
