/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dataAcessObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.valueObject.DirectoryVO;

import models.valueObject.ItemVO;

/**
 *
 * @author ld_si
 */
public class ItemDAO extends DirectoryDAO {

    public ItemDAO(DirectoryVO dir) {
        super(dir);
    }

    /**
     *
     * @param item
     * @throws IOException
     */
    public static void writeItem(ItemVO item) throws IOException {
        TextDAO.writeText(item.getItemCode() + ","
                + item.getItemQuantity() + ","
                + item.getItemName() + ","
                + item.getItemDescription() + ","
                + item.getItemPrice() + ";" + System.getProperty("line.separator"),
                dir.getDir(), dir.getDirItem(), true);

    }

    /**
     *
     * @param itens
     * @throws IOException
     */
    public static void writeItem(ArrayList<ItemVO> itens) throws IOException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                for (ItemVO item : itens) {
                    TextDAO.writeText(item.getItemCode() + ","
                            + item.getItemQuantity() + ","
                            + item.getItemName() + ","
                            + item.getItemDescription() + ","
                            + item.getItemPrice() + ";" + System.getProperty("line.separator"),
                            dir.getDir(), dir.getDirItem(), true);
                }
                break;
            case 1:
                System.out.println("Tentando gravar binario");
                BinaryDAO.writeBinary(dir.getDir() + dir.getDirItemBinary(), itens, false);
                break;
            case 2:
                ConnectionDAO cdao = new ConnectionDAO();
                cdao.createConection();

                for (int i = 0; i < itens.size(); i++) {
                    ItemVO item = (ItemVO) itens.get(i);
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
    public static ArrayList<ItemVO> readItem()
            throws FileNotFoundException, IOException {
        ArrayList<ItemVO> itens = new ArrayList<ItemVO>();
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirItem());

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
                    itens.add(new ItemVO(code, qtd, name, description, price));
                }

                return itens;
            case 1:
                try {
                    return (ArrayList) BinaryDAO.readBinary(dir.getDir() + dir.getDirItemBinary());
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro: " + ex.getMessage() + " retornado null");
                    return new ArrayList<ItemVO>();
                }
            case 2:
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
                    return new ArrayList<ItemVO>();
                }
                try {

                    System.out.println("ResultSet item: " + rs.getObject(1).toString());
                    do {
                        itens.add(new ItemVO(Integer.parseInt(rs.getString(1)),
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
    public static void editItem(ItemVO item, int index)
            throws FileNotFoundException, IOException {
        ArrayList<ItemVO> itens = ItemDAO.readItem();
        itens.set(index, item);
        if (SettingsDAO.readSettings().getMode() != 2) {
            DirectoryDAO.deleteItemDir();
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
    
    
    public static void deleteItem(ItemVO item, int index) throws IOException{
        ArrayList<ItemVO> itens = ItemDAO.readItem();
        if (SettingsDAO.readSettings().getMode() != 2) {
            DirectoryDAO.deleteItemDir();
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
