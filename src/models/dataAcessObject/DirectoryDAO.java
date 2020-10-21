/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dataAcessObject;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import models.valueObject.DirectoryVO;
import models.valueObject.SettingsVO;

/**
 *
 * @author ld_silva
 */
public abstract class DirectoryDAO {

    public static DirectoryVO dir;

    /**
     *
     * @param dir
     */
    public DirectoryDAO(DirectoryVO dir) {
        this.dir = dir;
        write();
        if (!exist(dir.getDirSettings())) {
            SettingsDAO.writeSettings(new SettingsVO(0));
        }
    }

    /**
     *
     * @return dir
     */
    public String getDir() {
        return dir.getDir();
    }

    /**
     *
     * @param dir
     */
    public void setDir(String dir) {
        this.dir.setDir(dir);
    }

    /**
     * Cria o directório "ControleDeEstoque" na pasta do usuário para armazenar
     * os dados
     */
    public void write() {
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
    public static Boolean exist(String type) {
        if (type.equals(dir.getDir())) {
            File item = new File(dir.getDir() + dir.getDirItem());

            if (item.exists()) {
                return true;
            }
        }
        if (type.equals(dir.getDirItemBinary())) {
            File item = new File(dir.getDir() + dir.getDirItemBinary());

            if (item.exists()) {
                return true;
            }
        }
        if (type.equals(dir.getDirProvider())) {
            File item = new File(dir.getDir() + dir.getDirProvider());

            if (item.exists()) {
                return true;
            }
        }
        if (type.equals(dir.getDirProviderBinary())) {
            File item = new File(dir.getDir() + dir.getDirProviderBinary());

            if (item.exists()) {
                return true;
            }
        }
        if (type.equals(dir.getDirUser())) {
            File item = new File(dir.getDir() + dir.getDirUser());

            if (item.exists()) {
                return true;
            }
        }
        if (type.equals(dir.getDirUserBinary())) {
            File item = new File(dir.getDir() + dir.getDirUserBinary());

            if (item.exists()) {
                return true;
            }
        }
        if (type.equals(dir.getDirSettings())) {
            File item = new File(dir.getDir() + dir.getDirSettings());

            if (item.exists()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param file
     * @throws FileNotFoundException
     */
    public static void delete(String file) throws FileNotFoundException {
        File arq = new File(dir.getDir() + file);
        System.out.println("Não foi deletado "+file);
        if (arq.exists()) {
            System.out.println("Deletado "+file);
            arq.delete();
        }
    }
    
    /**
     * 
     * @throws FileNotFoundException 
     */
    public static void deleteItemDir() throws FileNotFoundException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                DirectoryDAO.delete(DirectoryDAO.dir.getDirItem());
                break;
            case 1:
                DirectoryDAO.delete(DirectoryDAO.dir.getDirItemBinary());
                break;
        }
    }
    
    /**
     * 
     * @throws FileNotFoundException 
     */
    public static void deleteProviderDir() throws FileNotFoundException {
        switch (SettingsDAO.readSettings().getMode()) {
            case 0:
                DirectoryDAO.delete(DirectoryDAO.dir.getDirProvider());
                break;
            case 1:
                DirectoryDAO.delete(DirectoryDAO.dir.getDirProviderBinary());
                break;
        }
    }

}
