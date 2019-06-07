/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import view.LoginUI;

/**
 *
 * @author ld_si
 */
public class Main {
    public static void main(String[] args) {
        Sgbd.start();
        LoginUI loginUI = new LoginUI(Sgbd.readSettings().getMode());
        loginUI.start();
    }
}
