
import controllers.HomeController;
import views.HomeView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ld_si
 */
public class TestMain {
    public static void main(String[] args) {
        new HomeController(new HomeView());
    }
}
