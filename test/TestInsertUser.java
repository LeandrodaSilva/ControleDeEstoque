
import controllers.UserController;
import views.UserView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestInsertUser {
    public static void main(String[] args) {
        UserView insert = new UserView();
        insert.setVisible(true);
        new UserController(insert, null);
        
    }
}
