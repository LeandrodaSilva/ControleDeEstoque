/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.valueObject;

/**
 *
 * @author leandro
 */
public class SettingsVO {
    private int mode;

    public SettingsVO(int mode) {
        
        this.mode = mode;
        
    }
    
    
    
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) throws IndexOutOfBoundsException {
        
        this.mode = mode;
        
    }
    
}
