/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.dataAcessObject.ProviderDAO;
import model.valueObject.Provider;

/**
 *
 * @author ld_si
 */
public class TableModelProvider extends DefaultTableModel {

    private ArrayList<Provider> providerArray;

    public TableModelProvider() {
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

        this.providerArray = (ArrayList<Provider>) ProviderDAO.readProvider();

        if (providerArray == null) {
            System.out.println("provider nulo");
            setNumRows(0);
            return;
        }
        int size = this.providerArray.size();

        Provider provider;

        for (int i = 0; i < size; i++) {
            provider = (Provider) providerArray.get(i);
            linha[0] = provider.getName();
            linha[1] = provider.getCnpj();
            linha[2] = provider.getAdress();
            addRow(linha);
        }

    }

}
