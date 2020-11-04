/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAcessObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.valueObject.Dir;

import model.valueObject.Item;
import model.valueObject.Settings;

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
        TextDAO.writeText(item.toString(), dir.getDir(), dir.getDirItem(), true);
    }

    /**
     *
     * @param itens
     * @throws IOException
     */
    public static void writeItem(ArrayList<Item> itens) throws IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case Settings.TEXT_MODE:
                for (Item item : itens) {
                    TextDAO.writeText(item.toString(), dir.getDir(), dir.getDirItem(), true);
                }
                break;
            case Settings.BINARY_MODE:
                System.out.println("Tentando gravar binario");
                BinaryDAO.writeBinary(dir.getDir() + dir.getDirItemBinary(), itens, false);
                break;
            case Settings.DATABASE_MODE:
                ConnectionDAO cdao = new ConnectionDAO();
                cdao.createConection();

                for (int i = 0; i < itens.size(); i++) {
                    Item item = (Item) itens.get(i);
                    cdao.writeCloud("INSERT INTO public.item(\n"
                            + "	itemcode, itemquantity, itemname, itemdescription, itemprice)\n"
                            + "	VALUES (" + item.getItemCode() + ", " + item.getItemQuantity() + ", '" + item.getItemName() + "', '" + item.getItemDescription() + "', " + item.getItemPrice() + ");");
                }
                cdao.closeConection();
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
        ArrayList<Item> itens = new ArrayList<Item>();
        switch (SettingsDAO.readSettings().getMode()) {
            case Settings.TEXT_MODE:
                ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirItem());

                int code = 0, qtd = 0, v1, v2, v3, v4;
                String name = "", description = "";
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
            case Settings.BINARY_MODE:
                try {
                    return (ArrayList) BinaryDAO.readBinary(dir.getDir() + dir.getDirItemBinary());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro: " + ex.getMessage() + " retornado null");
                    return new ArrayList<Item>();
                }
            case Settings.DATABASE_MODE:
                ConnectionDAO cdao = new ConnectionDAO();
                cdao.createConection();

                ResultSet rs = cdao.readCloud("SELECT itemcode, "
                        + "itemquantity, "
                        + "itemname, "
                        + "itemdescription, "
                        + "itemprice "
                        + "FROM public.item;");

                if (rs == null) {
                    System.out.println("rs nulo retornado array vazio");
                    return new ArrayList<Item>();
                }
                try {

                    System.out.println("ResultSet item: " + rs.getObject(1).toString());
                    do {
                        itens.add(new Item(Integer.parseInt(rs.getString(1)),
                                Integer.parseInt(rs.getString(2)),
                                rs.getString(3),
                                rs.getString(4),
                                Double.parseDouble(rs.getString(5))));
                    } while (rs.next());
                    System.out.println("Cloud - item recuperado: ");
                    return itens;
                } catch (SQLException ex) {
                    System.out.println("ResultSet Erro - item: " + ex.getMessage());
                }

            default:
                return null;
        }
    }

    /**
     *
     * @param item
     * @param index
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void editItem(Item item, int index)
            throws FileNotFoundException, IOException {
        ArrayList<Item> itens = ItemDAO.readItem();
        itens.set(index, item);
        if (SettingsDAO.readSettings().getMode() != Settings.DATABASE_MODE) {
            DirDAO.deleteItemDir();
            ItemDAO.writeItem(itens);
        } else {
            ConnectionDAO cdao = new ConnectionDAO();
            cdao.createConection();

            cdao.writeCloud("UPDATE public.item SET itemquantity= " + item.getItemQuantity() + " , "
                    + "itemname = '" + item.getItemName() + "', "
                    + "itemdescription = '" + item.getItemDescription() + "', "
                    + "itemprice=" + item.getItemPrice() + " "
                    + "WHERE public.item.itemcode = " + item.getItemCode() + ";");

            cdao.closeConection();
        }
    }
    
    
    public static void deleteItem(Item item, int index) throws IOException{
        ArrayList<Item> itens = ItemDAO.readItem();
        if (SettingsDAO.readSettings().getMode() != Settings.DATABASE_MODE) {
//            DirDAO.deleteItemDir();
            itens.remove(index);
            ItemDAO.writeItem(itens);
        } else {
            ConnectionDAO cdao = new ConnectionDAO();
            cdao.createConection();

            cdao.writeCloud("DELETE FROM public.item WHERE public.item.itemcode = "+item.getItemCode()+";");

            cdao.closeConection();
        }
    }
}
