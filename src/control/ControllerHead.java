/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import view.Head;

/**
 *
 * @author Aluno
 */
public class ControllerHead implements ActionListener, MouseListener, MouseMotionListener{
    private Head head;
    private Point point = new Point();
    private JFrame frame;
    
    public ControllerHead(Head head, JFrame frame) {
        this.head = head;
        this.frame = frame;
        
        this.head.getbClose().addActionListener(this);
        this.head.getbClose().addMouseListener(this);
        this.head.getbMinimize().addActionListener(this);
        this.head.getbMinimize().addMouseListener(this);
        this.head.addMouseMotionListener(this);
        this.head.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.head.getbClose()) {
            System.exit(0);
        }
        if (e.getSource() == this.head.getbMinimize()) {
            this.frame.setExtendedState(this.frame.ICONIFIED);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        point.x = e.getX();
        point.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.head.getbClose()) {
            this.head.getbClose().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/closeR.png")));
        }
        if (e.getSource() == this.head.getbMinimize()) {
            this.head.getbMinimize().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimizeBl.png")));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.head.getbClose()) {
            this.head.getbClose().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/closeB.png")));
        }
        if (e.getSource() == this.head.getbMinimize()) {
            this.head.getbMinimize().setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minimizeB.png")));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = this.frame.getLocation();
        this.frame.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    
}
