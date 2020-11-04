/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.valueObject;

/**
 *
 * @author leandro
 */
public class Settings {
    private int mode;
    public static final int TEXT_MODE = 0;
    public static final int BINARY_MODE = 1;
    public static final int DATABASE_MODE = 2;

    public Settings(int mode) {
        
        this.mode = mode;
        
    }
    
    
    
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) throws IndexOutOfBoundsException {
        
        this.mode = mode;
        
    }
    
}
