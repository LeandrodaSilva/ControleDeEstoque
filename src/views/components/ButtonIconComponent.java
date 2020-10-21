/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

/**
 *
 * @author ld_si
 */
public class ButtonIconComponent extends javax.swing.JButton{
    /** 
     * Um botão que exibe apenas a imagem passada por parâmetro.
     * @param urlIcon Caminho para a imagem
     * @param x  Tamanho no eixo X - Horizontal
     * @param y  Tamanho no eixo Y - Vertical
     */
    public ButtonIconComponent(String urlIcon, int x, int y) {
        setIcon(new javax.swing.ImageIcon(getClass().getResource(urlIcon)));
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setPreferredSize(new java.awt.Dimension(x, y));
    }
    
}
