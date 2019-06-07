/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Item;
import model.Login;
import model.Provider;
import model.Settings;

/**
 *
 * @author ld_silva
 */
public class Sgbd {

    public static String dir;
    public static final String DIRUSER = "/user.txt";
    public static final String DIRITEM = "/item.txt";
    public static final String DIRPROVIDER = "/provider.txt";
    public static final String DIRSETTINGS = "/conf.txt";
    public static final String DIRUSERB = "/user.obj";
    public static final String DIRITEMB = "/item.obj";
    public static final String DIRPROVIDERB = "/provider.obj";
    public static final String DIRSETTINGSB = "/conf.obj";

    public static void start() {
        Sgbd.makeDir();
        if (Sgbd.notExist(Sgbd.DIRSETTINGS)) {
            Sgbd.writeSettings(new Settings(0));
        }
    }

    /**
     *
     * @return dir
     */
    public static String getDir() {
        return dir;
    }

    /**
     *
     * @param dire
     */
    private static void setDir(String dire) {
        dir = dire;
    }

    /**
     * Cria o directório "ControleDeEstoque" na pasta do usuário para armazenar
     * os dados
     */
    public static void makeDir() {
        setDir(System.getProperty("user.dir") + "/ControleDeEstoque");
        File dire = new File(getDir());
        if (!dire.exists()) {
            try {
                if (dire.mkdir()) {
                    System.out.println("Criado directório");
                }
            } catch (SecurityException se) {
                System.out.println("Erro de segurança");
                JOptionPane.showMessageDialog(null, se.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            System.out.println("Directório já existe");
        }
    }

    /**
     *
     * @param type - Verifica a não existência dos arquivos(data.txt, user.txt)
     * passando "data" ou "user"
     * @return Boolean - Retorna true se não existir e false se existir
     */
    public static Boolean notExist(String type) {
        switch (type) {
            case DIRITEM:
                File item = new File(dir + DIRITEM);

                if (item.exists()) {
                    return false;
                }
                break;
            case DIRITEMB:
                File itemb = new File(dir + DIRITEMB);

                if (itemb.exists()) {
                    return false;
                }
                break;
            case DIRPROVIDER:
                File provider = new File(dir + DIRPROVIDER);

                if (provider.exists()) {
                    return false;
                }
                break;
            case DIRPROVIDERB:
                File providerb = new File(dir + DIRPROVIDERB);

                if (providerb.exists()) {
                    return false;
                }
                break;
            case DIRUSER:
                File user = new File(dir + DIRUSER);

                if (user.exists()) {
                    return false;
                }
                break;
            case DIRUSERB:
                File userb = new File(dir + DIRUSERB);

                if (userb.exists()) {
                    return false;
                }
                break;
            case DIRSETTINGS:
                File settings = new File(dir + DIRSETTINGS);

                if (settings.exists()) {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     *
     * @param item
     * @throws IOException
     */
    public static void writeItem(Item item) throws IOException {
        Archive.writeText(item.getItemCode() + ","
                + item.getItemQuantity() + ","
                + item.getItemName() + ","
                + item.getItemDescription() + ","
                + item.getItemPrice() + ";" + System.getProperty("line.separator"),
                dir, DIRITEM, true);

    }
    
     public static void writeItem(ArrayList<Item> item) throws IOException {
        Archive.writeBinary(dir+DIRITEMB, item, false);
    }

    /**
     *
     * @param provider
     * @throws IOException
     */
    public static void writeProvider(Provider provider) throws IOException {
        Archive.writeText(provider.getName() + ","
                + provider.getCnpj() + ","
                + provider.getAdress() + ";" + System.getProperty("line.separator"),
                dir, DIRPROVIDER, true);
    }

    /**
     *
     * @param user
     * @throws IOException
     */
    public static void writeUser(Login user) throws IOException {
        switch (Sgbd.readSettings().getMode()) {
            case 0:
                Archive.writeText(user.getUserName() + ","
                        + user.getSalt() + ","
                        + user.getHash() + ";" + System.getProperty("line.separator"),
                        dir, DIRUSER, false);
                break;
            case 1:
                Archive.writeBinary(dir + DIRUSERB, user, false);
                break;
        }
    }

    /**
     *
     * @param settings
     */
    public static void writeSettings(Settings settings) {
        try {
            Archive.writeText(settings.getMode() + ";",
                    dir, DIRSETTINGS, false);
        } catch (IOException ex) {
            System.out.println("Metodo: writeSettings\nErro: " + ex.getMessage());
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
        switch (Sgbd.readSettings().getMode()) {
            case 0:
                ArrayList<String> lido = Archive.readText(dir + DIRITEM);
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
            case 1:
                return (ArrayList) Archive.readBinary(dir + DIRITEMB);
            default:
                return null;
        }
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList readProvider()
            throws FileNotFoundException, IOException {
        ArrayList<String> lido = Archive.readText(dir + DIRPROVIDER);
        ArrayList<Provider> providers = new ArrayList<>();

        String name, cnpj, adress;
        int v1, v2;

        for (String line : lido) {
            v1 = line.indexOf(",");
            v2 = line.indexOf(",", v1 + 1);

            name = line.substring(0, v1);
            cnpj = line.substring(v1 + 1, v2);
            adress = line.substring(v2 + 1, line.indexOf(";"));

            providers.add(new Provider(name, cnpj, adress));
        }

        return providers;
    }

    /**
     *
     * @return @throws FileNotFoundException
     * @throws IOException
     */
    public static Login readUser() throws FileNotFoundException, IOException {
        switch (Sgbd.readSettings().getMode()) {
            case 0:
                ArrayList<String> lido = Archive.readText(dir + DIRUSER);
                int v1,
                 v2;
                String line = lido.get(0);

                v1 = line.indexOf(",");
                v2 = line.indexOf(",", v1 + 1);

                Login user = new Login(line.substring(0, v1),
                        line.substring(v1 + 1, v2),
                        line.substring(v2 + 1, line.indexOf(";")));
                return user;
            case 1:
                return (Login) Archive.readBinary(dir+DIRUSERB);
            default:
                return null;
        }
    }

    /**
     *
     * @return Settings
     */
    public static Settings readSettings() {
        try {

            ArrayList<String> lido = Archive.readText(dir + DIRSETTINGS);
            String line = lido.get(0);

            int mode = Integer.parseInt(line.substring(0, line.lastIndexOf(";")));
            return new Settings(mode);

        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param file
     * @throws FileNotFoundException
     */
    public static void deleteData(String file) throws FileNotFoundException {
        File arq = new File(dir + file);
        if (arq.exists()) {
            arq.delete();
        }
    }

}
