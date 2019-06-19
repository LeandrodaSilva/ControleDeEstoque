/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.basic;

import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author ld_si
 */
public class Button extends javax.swing.JButton{
    private Border line;
    private Border margin;
    public Border borderBlack;
    public Border borderBlue;
    public Border borderGrey;
    
    public Button(String tittle) {
        this.setText(tittle);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        
        this.line = new LineBorder(new java.awt.Color(0, 0, 0), 2, true);
        this.margin = new EmptyBorder(5, 15, 5, 15);
        this.borderBlack = new CompoundBorder(line, margin);
        
        this.line = new LineBorder(new java.awt.Color(51, 153, 255), 4, true);
        this.borderBlue = new CompoundBorder(line, margin);
        
        this.line = new LineBorder(new java.awt.Color(153, 153, 153), 4, true);
        this.borderGrey = new CompoundBorder(line, margin);
        
        this.setBorder(borderBlack);
        this.setFocusable(false);
    }
}
