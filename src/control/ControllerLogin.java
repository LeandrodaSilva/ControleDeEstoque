/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.businessObject.Security;
import model.dataAcessObject.SettingsDAO;
import model.dataAcessObject.UserDAO;
import model.interfaces.LoginOperation;
import view.InsertUserUI;
import view.Login;
import view.Main;
import view.SettingsUI;

/**
 *
 * @author Aluno
 */
public class ControllerLogin implements ActionListener, 
    MouseListener, LoginOperation 
{

    private final Login login;

    public ControllerLogin(Login login) {
        this.login = login;

        this.login.getbEnter().addActionListener(this);
        this.login.getbRegister().addActionListener(this);
        this.login.getTfUser().addActionListener(this);
        this.login.getbConfig().addActionListener(this);
        this.login.getbConfig().addMouseListener(this);

        new ControllerHead(this.login.getTbHead(), this.login);
        new ControllerEfect(this.login.getbEnter());
        new ControllerEfect(this.login.getbRegister());
        new ControllerEfect(this.login.getTfUser());
        new ControllerEfect(this.login.getPfPasswd());

        this.login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getbEnter()) {
            if (verifyFrameElements()) {
                login();
            }
        }
        if (e.getSource() == this.login.getbRegister()) {
            InsertUserUI insertUserUI = new InsertUserUI();
            insertUserUI.setVisible(true);
            insertUserUI.loginUI = this.login;
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
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
    public void setFrameElements() {

    }

    @Override
    public void removeFrameElements() {

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
//                MainUI mainUI = new MainUI();
//                //mainUI.start();
//                mainUI.setVisible(true);
                  new ControllerMain(new Main());
            } else {
                this.login.getlErro().setVisible(true);
            }
        } catch (IOException ex) {
            this.login.getlErro().setVisible(true);
            JOptionPane.showMessageDialog(
                    this.login,
                    "Cadastre um usuário",
                    "Alerta",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

}
