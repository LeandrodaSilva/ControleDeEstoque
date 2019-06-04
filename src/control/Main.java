/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Settings;
import view.LoginUI;

/**
 *
 * @author ld_si
 */
public class Main {
    public static void main(String[] args) {
        Sgbd.makeDir();
//        if (!Sgbd.notExist(Sgbd.DIRSETTINGS)) {
//            Sgbd.writeSettings(new Settings(0));
//        }
        LoginUI loginUI = new LoginUI(Sgbd.readSettings().getMode());
        loginUI.start();
       
    }
}
