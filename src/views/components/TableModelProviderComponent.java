/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.dataAcessObject.ProviderDAO;
import models.valueObject.ProviderVO;

/**
 *
 * @author ld_si
 */
public class TableModelProviderComponent extends DefaultTableModel {

    private ArrayList<ProviderVO> providerArray;

    public TableModelProviderComponent() {
        addColumn("Nome da Empresa");
        addColumn("CNPJ");
        addColumn("Endereço");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void loadTableModelRowsValues() {

        String[] linha = new String[3];

        this.providerArray = (ArrayList<ProviderVO>) ProviderDAO.readProvider();

        if (providerArray == null) {
            System.out.println("provider nulo");
            setNumRows(0);
            return;
        }
        int size = this.providerArray.size();

        ProviderVO provider;

        for (int i = 0; i < size; i++) {
            provider = (ProviderVO) providerArray.get(i);
            linha[0] = provider.getName();
            linha[1] = provider.getCnpj();
            linha[2] = provider.getAdress();
            addRow(linha);
        }

    }

}
