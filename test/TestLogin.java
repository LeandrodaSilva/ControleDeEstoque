
import controllers.LoginController;
import views.LoginView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class TestLogin {
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new LoginController(login);
    }
}
