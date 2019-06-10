/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import model.dataAcessObject.DirDAO;
import model.dataAcessObject.SettingsDAO;
import model.valueObject.Dir;
import view.LoginUI;

/**
 *
 * @author ld_si
 */
public class Run {
    
    private static SettingsDAO settingsDAO = new SettingsDAO(new Dir());
    
    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI(settingsDAO.readSettings().getMode());
        loginUI.start();
    }
}
