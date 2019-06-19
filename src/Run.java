/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import control.ControllerLogin;
import model.dataAcessObject.SettingsDAO;
import model.valueObject.Dir;
import view.Login;

/**
 *
 * @author ld_si
 */
public class Run {

    public static void main(String[] args) {
        new SettingsDAO(new Dir());
        new ControllerLogin(new Login());
    }
}
