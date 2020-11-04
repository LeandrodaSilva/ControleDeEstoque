/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;

import model.businessObject.Security;
import model.dataAcessObject.SettingsDAO;
import model.dataAcessObject.UserDAO;
import model.interfaces.LoginOperation;
import view.InsertUser;
import view.Login;
import view.Main;
import view.SettingsUI;

/**
 *
 * @author Aluno
 */
public class ControllerLogin extends Controller implements LoginOperation 
{

    private final Login login;

    public ControllerLogin(Login login) {
        this.login = login;

        login.getbEnter().addActionListener(this);
        login.getbRegister().addActionListener(this);
        login.getTfUser().addActionListener(this);
        login.getbConfig().addActionListener(this);
        login.getbConfig().addMouseListener(this);

        ControllerHead.add(login.getTbHead(), login);
        add(login.getbEnter());
        add(login.getbRegister());
        add(login.getTfUser());
        add(login.getPfPasswd());

        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getbEnter()) {
            if (verifyFrameElements()) {
                login();
            }
        }
        if (e.getSource() == this.login.getbRegister()) {
            InsertUser insertUser = new InsertUser();
            insertUser.setVisible(true);
            new ControllerInsertUser(insertUser, this.login);
            this.login.setEnabled(false);
        }
        if (e.getSource() == this.login.getbConfig()) {
            SettingsUI settingsUI = new SettingsUI();
            settingsUI.getHead().getbMinimize().setEnabled(false);
            new ControllerSettings(settingsUI, this.login, SettingsDAO.readSettings().getMode());
            this.login.setEnabled(false);
            settingsUI.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.login.getbConfig()) {
            this.login.getbConfig().setIcon(
                    new javax.swing.ImageIcon(
                            getClass().getResource("/view/images/configBlue.png")));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.login.getbConfig()) {
            this.login.getbConfig().setIcon(
                    new javax.swing.ImageIcon(
                            getClass().getResource("/view/images/configBlack.png")));
        }
    }

    @Override
    public boolean verifyFrameElements() {
        boolean result = true;
        if (this.login.getTfUser().getText().equals("")) {
            result = false;
            this.login.getTfUser().setBorder(this.login.getTfUser().border.red);
        } else {
            this.login.getTfUser().setBorder(this.login.getTfUser().border.black);
        }
        if (this.login.getPfPasswd().getText().equals("")) {
            result = false;
            this.login.getPfPasswd().setBorder(this.login.getPfPasswd().border.red);
        } else {
            this.login.getPfPasswd().setBorder(this.login.getPfPasswd().border.black);
        }
        return result;
    }

    @Override
    public void getFrameElements() {
        if (verifyFrameElements()) {

            this.login.setUserName(this.login.getTfUser().getText());

            this.login.setUserPassword(this.login.getPfPasswd().getText());
        } else {
            System.out.println("Há campos não preenchidos");
        }
    }

    @Override
    public void login() {
        getFrameElements();
        try {
            this.login.setUserOnStorage(
                    UserDAO.readUser(
                            this.login.getUserName()));
            if (Security.loginCheck(
                    this.login.getUserName(),
                    this.login.getUserPassword(),
                    this.login.getUserOnStorage())
                    && this.login.getUserOnStorage() != null) {
                System.out.println("Login autorizado");
                this.login.setVisible(false);
                  new ControllerMain(new Main());
            } else {
                JLabel lErro = this.login.getlErro();
                lErro.setText("Usuário não cadastrado ou dados incorretos.");
                lErro.setVisible(true);
            }
        } catch (IOException ex) {
            this.login.getlErro().setVisible(true);
            JOptionPane.showMessageDialog(
                    this.login,
                    "Cadastre um usuário",
                    "Alerta",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
