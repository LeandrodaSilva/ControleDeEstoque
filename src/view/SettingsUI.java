/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author ld_si
 */
public class SettingsUI extends javax.swing.JFrame{
    private JLabel jlMode;
    private JLabel jlText;
    private JLabel jlBinary;
    private JLabel jlCloud;
    private JCheckBox jcText;
    private JCheckBox jcBinary;
    private JCheckBox jcCloud;
    private JButton jbSave;

    public SettingsUI() {
        
        this.setTitle("Configurações");
        this.setResizable(false);
        this.setSize(400, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.jlMode = new JLabel("Selecione o modo");
        this.jlText = new JLabel("Texto");
        this.jlBinary = new JLabel("Binário");
        this.jlCloud = new JLabel("Nuvem");
        this.jcText = new JCheckBox();
        this.jcBinary = new JCheckBox();
        this.jcCloud = new JCheckBox();
        this.jbSave = new JButton("Salvar");
       
        
        this.jlMode.setBounds(150, 25, 150, 25);
        this.jlText.setBounds(75, 60, 50, 25);
        this.jlBinary.setBounds(75, 90, 50, 25);
        this.jlCloud.setBounds(75, 120, 50, 25);
        this.jcText.setBounds(150, 60, 25, 25);
        this.jcBinary.setBounds(150, 90, 25, 25);
        this.jcCloud.setBounds(150, 120, 25, 25);
        this.jbSave.setBounds(150, 200, 100, 25);
        
        
        this.add(jlMode);
        this.add(jlText);
        this.add(jlBinary);
        this.add(jlCloud);
        this.add(jcText);
        this.add(jcBinary);
        this.add(jcCloud);
        this.add(jbSave);
    }

    public JLabel getJlMode() {
        return jlMode;
    }

    public void setJlMode(JLabel jlMode) {
        this.jlMode = jlMode;
    }

    public JLabel getJlText() {
        return jlText;
    }

    public void setJlText(JLabel jlText) {
        this.jlText = jlText;
    }

    public JLabel getJlBinary() {
        return jlBinary;
    }

    public void setJlBinary(JLabel jlBinary) {
        this.jlBinary = jlBinary;
    }

    public JLabel getJlCloud() {
        return jlCloud;
    }

    public void setJlCloud(JLabel jlCloud) {
        this.jlCloud = jlCloud;
    }

    public JCheckBox getJcText() {
        return jcText;
    }

    public void setJcText(JCheckBox jcText) {
        this.jcText = jcText;
    }

    public JCheckBox getJcBinary() {
        return jcBinary;
    }

    public void setJcBinary(JCheckBox jcBinary) {
        this.jcBinary = jcBinary;
    }

    public JCheckBox getJcCloud() {
        return jcCloud;
    }

    public void setJcCloud(JCheckBox jcCloud) {
        this.jcCloud = jcCloud;
    }

    public JButton getJbSave() {
        return jbSave;
    }

    public void setJbSave(JButton jbSave) {
        this.jbSave = jbSave;
    }
    
    
    
}
