/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import views.components.ButtonComponent;
import views.components.HeadComponent;
import views.components.RoundIconComponent;

/**
 *
 * @author ld_si
 */
public class SettingsView extends JFrame {

    private JLabel jlMode;
    private JRadioButton jrText;
    private JRadioButton jrBinary;
    private JRadioButton jrCloud;
    private ButtonComponent jbSave;
    private final JLabel background;
    private HeadComponent head;
    
    public final RoundIconComponent iconBlue = new RoundIconComponent(new Color(181 , 230, 29));
    public final RoundIconComponent iconBlack = new RoundIconComponent(Color.BLACK);
    
    public SettingsView() {

        this.setTitle("Configurações");
        this.setResizable(false);
        this.setSize(400, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);

        this.jlMode = new JLabel("Selecione o modo de armazenamento");
        
        
        this.jrText = new JRadioButton("Salvar em Texto");
        this.jrBinary = new JRadioButton("Salvar em Binário");
        this.jrCloud = new JRadioButton("Salvar em Banco de Dados");

        this.jbSave = new ButtonComponent("Salvar");

        this.background = new JLabel("back");

        this.head = new HeadComponent("Configurações");

        this.jlMode.setBounds(50, 65, 300, 25);

        this.jrText.setBounds(100, 100, 300, 25);
        this.jrText.setIcon(iconBlack);
        this.jrText.setContentAreaFilled(false);
        this.jrText.setFocusable(false);
        this.jrBinary.setBounds(100, 130, 300, 25);
        this.jrBinary.setIcon(iconBlack);
        this.jrBinary.setContentAreaFilled(false);
        this.jrBinary.setFocusable(false);
        this.jrCloud.setBounds(100, 160, 300, 25);
        this.jrCloud.setIcon(iconBlack);
        this.jrCloud.setContentAreaFilled(false);
        this.jrCloud.setFocusable(false);

        this.jbSave.setBounds(150, 240, 100, 25);

        this.background.setBounds(0, 0, 400, 300);
        this.background.setIcon(new ImageIcon(getClass().getResource("/views/images/back.png")));

        this.head.setBounds(0, 0, 400, 50);

        this.add(jlMode);

        this.add(jrText);
        this.add(jrBinary);
        this.add(jrCloud);

        this.add(jbSave);

        this.add(head);

        this.add(background);
    }

    public JRadioButton getJrText() {
        return jrText;
    }

    public void setJrText(JRadioButton jrText) {
        this.jrText = jrText;
    }

    public JRadioButton getJrBinary() {
        return jrBinary;
    }

    public void setJrBinary(JRadioButton jrBinary) {
        this.jrBinary = jrBinary;
    }

    public JRadioButton getJrCloud() {
        return jrCloud;
    }

    public void setJrCloud(JRadioButton jrCloud) {
        this.jrCloud = jrCloud;
    }

    public HeadComponent getHead() {
        return head;
    }

    public void setHead(HeadComponent head) {
        this.head = head;
    }

    public JLabel getJlMode() {
        return jlMode;
    }

    public void setJlMode(JLabel jlMode) {
        this.jlMode = jlMode;
    }

    public ButtonComponent getJbSave() {
        return jbSave;
    }

    public void setJbSave(ButtonComponent jbSave) {
        this.jbSave = jbSave;
    }

}
