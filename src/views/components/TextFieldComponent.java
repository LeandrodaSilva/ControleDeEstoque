/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ld_si
 */
public class TextFieldComponent extends javax.swing.JTextField {
    
    public BorderColorComponent border;
    
    public TextFieldComponent() {
        this.border = new BorderColorComponent();
        setBorder(border.black);
    }

    public TextFieldComponent(String admin) {
        this.setText(admin);
        this.border = new BorderColorComponent();
        setBorder(border.black);
    }

    public String getVerifiedText() throws Exception{
        if (this.getText() != null && this.getText().length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(this.getText());
            if (matcher.matches()) {
                return this.getText();
            }
        }
        throw new Exception("Erro- texto possui caracteres não aceitos");
    }

}
