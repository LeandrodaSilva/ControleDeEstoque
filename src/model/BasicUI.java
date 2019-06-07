/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Point;

/**
 *
 * @author Aluno
 */
public class BasicUI extends javax.swing.JFrame{
    private Point point = new Point();
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
        point.x = evt.getX();
        point.y = evt.getY();
    }                                 

    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        Point p = getLocation();
        setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
    public void hello(){
        System.out.println("hello");
    } 
}
