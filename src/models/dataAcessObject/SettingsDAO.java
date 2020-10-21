/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dataAcessObject;

import java.io.IOException;
import java.util.ArrayList;
import models.valueObject.DirectoryVO;
import models.valueObject.SettingsVO;

/**
 *
 * @author ld_si
 */
public class SettingsDAO extends DirectoryDAO {

    public SettingsDAO(DirectoryVO dir) {
        super(dir);
    }

    /**
     *
     * @param settings
     */
    public static void writeSettings(SettingsVO settings) {
        try {
            TextDAO.writeText(settings.getMode() + ";",
                    dir.getDir(), dir.getDirSettings(), false);
        } catch (IOException ex) {
            System.out.println("Metodo: writeSettings\nErro: " + ex.getMessage());
        }
    }
    
    /**
     *
     * @return Settings
     */
    public static SettingsVO readSettings() {
        try {

            ArrayList<String> lido = TextDAO.readText(dir.getDir() + dir.getDirSettings());
            String line = lido.get(0);

            int mode = Integer.parseInt(line.substring(0, line.lastIndexOf(";")));
            return new SettingsVO(mode);

        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return null;
    }
}
