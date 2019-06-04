/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author leandro
 */
public class Settings {
    private int mode;

    public Settings(int mode) throws IndexOutOfBoundsException {
        if (mode < 0 || mode > 1) {
            throw new IndexOutOfBoundsException("Valor X fora do intervalo 0 <= X <= 1 ");
        }else{
            this.mode = mode;
        }
    }
    
    
    
    public int getMode() {
        return mode;
    }

    public void setMode(int mode) throws IndexOutOfBoundsException {
         if (mode < 0 || mode > 1) {
            throw new IndexOutOfBoundsException("Valor X fora do intervalo 0 <= X <= 1 ");
        }else{
            this.mode = mode;
        }
    }
    
}
