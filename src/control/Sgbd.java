/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.Reflection.getAttributesMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        File dir = new File(getDir());
        if (!dir.exists()) {
            try {
                if (dir.mkdir()) {
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
            case DIRPROVIDER:
                File provider = new File(dir + DIRPROVIDER);

                if (provider.exists()) {
                    return false;
                }
                break;
            case DIRUSER:
                File user = new File(dir + DIRUSER);

                if (user.exists()) {
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
        Archive.writeText(user.getUserName() + ","
                + user.getSalt() + ","
                + user.getHash() + ";" + System.getProperty("line.separator"),
                dir, DIRUSER, false);
    }
    
    /**
     * 
     * @param settings
     * @throws IOException 
     */
    public static void writeSettings(Settings settings){
        try {
            Archive.writeText(settings.getMode()+ ";",
                    dir, DIRSETTINGS, false);
        } catch (IOException ex) {
            System.out.println("Metodo: writeSettings\nErro: "+ex.getMessage());
        }
    }

    /**
     *
     * @return ArrayList
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList readItem() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader(dir + DIRITEM);
        BufferedReader bf = new BufferedReader(arq);
        ArrayList itens = new ArrayList();

        String line = bf.readLine();
        int code = 0;
        int qtd = 0;
        String name = "";
        String description = "";
        double price = 0.0;

        int v1, v2, v3, v4;
        while (line != null) {
            System.out.println("Linha: " + line);

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
            line = bf.readLine();
        }

        arq.close();
        bf.close();

        return itens;
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static Login readUser() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader(dir + DIRUSER);
        BufferedReader bf = new BufferedReader(arq);
        String line = bf.readLine();
        int v1, v2;

        v1 = line.indexOf(",");
        v2 = line.indexOf(",", v1 + 1);

        Login user = new Login(line.substring(0, v1),
                line.substring(v1 + 1, v2),
                line.substring(v2 + 1, line.indexOf(";")));

        return user;
    }
    
    public static Settings readSettings() {
        FileReader arq = null;
        try {
            arq = new FileReader(dir + DIRSETTINGS);
            BufferedReader bf = new BufferedReader(arq);
            String line = bf.readLine();
            int mode = Integer.parseInt(line.substring(0, line.lastIndexOf(";")));
            Settings setting = new Settings(mode);
            return setting;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sgbd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sgbd.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                return null;
            }
        }
        return null;
    }
    
    
    
    /**
     * 
     * @throws FileNotFoundException 
     */
    public static void deleteData(String file) throws FileNotFoundException {
        File arq = new File(dir + file);
        if (arq.exists()) {
            arq.delete();
        }
    }
    
    /**
     * 
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static ArrayList readProvider() throws FileNotFoundException, IOException {
        FileReader arq = new FileReader(dir + DIRPROVIDER);
        BufferedReader bf = new BufferedReader(arq);
        ArrayList providers = new ArrayList();

        String line = bf.readLine();

        String name = "";
        String cnpj = "";
        String adress = "";

        int v1, v2;
        while (line != null) {
            System.out.println("Linha: " + line);

            v1 = line.indexOf(",");
            v2 = line.indexOf(",", v1 + 1);

            System.out.println("v1: " + v1 + " v2: " + v2);

            name = line.substring(0, v1);
            cnpj = line.substring(v1 + 1, v2);
            adress = line.substring(v2 + 1, line.indexOf(";"));

            providers.add(new Provider(name, cnpj, adress));
            line = bf.readLine();
        }

        arq.close();
        bf.close();

        return providers;
    }
}
