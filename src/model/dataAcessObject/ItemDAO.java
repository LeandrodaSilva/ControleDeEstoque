/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.valueObject.Dir;

import model.valueObject.Item;

/**
 *
 * @author ld_si
 */
public class ItemDAO extends DirDAO {

    public ItemDAO(Dir dir) {
        super(dir);
    }

    /**
     *
     * @param item
     * @throws IOException
     */
    public static void writeItem(Item item) throws IOException {
        TextDAO.writeText(item.getItemCode() + ","
                + item.getItemQuantity() + ","
                + item.getItemName() + ","
                + item.getItemDescription() + ","
                + item.getItemPrice() + ";" + System.getProperty("line.separator"),
                dir.getDir(), dir.getDirItem(), true);

    }

    public static void writeItem(ArrayList<Item> item) throws IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 1:
                BinaryDAO.writeBinary(dir.getDir() + dir.getDirItemBinary(), item, false);
                break;
            case 2:
                
                break;
        }
    }

    /**
     *
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Item> readItem()
            throws FileNotFoundException, IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirItem());
                ArrayList<Item> itens = new ArrayList<>();

                int code = 0,
                 qtd = 0,
                 v1,
                 v2,
                 v3,
                 v4;
                String name = "",
                 description = "";
                double price = 0.0;

                for (String line : lido) {
                    v1 = line.indexOf(",");
                    v2 = line.indexOf(",", v1 + 1);
                    v3 = line.indexOf(",", v2 + 1);
                    v4 = line.indexOf(",", v3 + 1);

                    code = Integer.parseInt(line.substring(0, v1));
                    qtd = Integer.parseInt(line.substring(v1 + 1, v2));
                    name = line.substring(v2 + 1, v3);
                    description = line.substring(v3 + 1, v4);
                    price = Double.parseDouble(line.substring(v4 + 1, line.indexOf(";")));
                    itens.add(new Item(code, qtd, name, description, price));
                }

                return itens;
            case 1: {
                try {
                    return (ArrayList) BinaryDAO.readBinary(dir.getDir() + dir.getDirItemBinary());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                }
            }
            default:
                return null;
        }
    }
}
