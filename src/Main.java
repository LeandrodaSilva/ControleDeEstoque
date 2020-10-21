/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.LoginController;
import models.dataAcessObject.SettingsDAO;
import models.valueObject.DirectoryVO;
import views.LoginView;

/**
 *
 * @author ld_si
 */
public class Main {

    public static void main(String[] args) {
        new SettingsDAO(new DirectoryVO());
        new LoginController(new LoginView());
    }
}
