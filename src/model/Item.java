/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ld_si
 */
public class Item implements Serializable{

    private String itemName;
    private int itemCode;
    private int itemQuantity;
    private double itemPrice;
    private String itemDescription;

    /**
     *
     * @param itemCode - Inteiro contendo o código do item
     * @param itemQuantity - Inteiro contendo a quantidade do item
     * @param itemName - String contendo o nome do item
     * @param itemPrice - Double contendo o preço do item
     */
    public Item(int itemCode, int itemQuantity, String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemDescription = "";
        this.itemCode = itemCode;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    /**
     *
     * @param itemCode - Inteiro contendo o código do item
     * @param itemQuantity - Inteiro contendo a quantidade do item
     * @param itemName - String contendo o nome do item
     * @param itemDescription - String contendo a descriçao do item
     * @param itemPrice - Double contendo o preço do item
     */
    public Item(int itemCode, int itemQuantity, String itemName, String itemDescription, double itemPrice) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    /**
     *@see Inicializa com 0 ou ""
     */
    public Item() {
        this.itemName = "";
        this.itemCode = 0;
        this.itemQuantity = 0;
        this.itemPrice = 0;
        this.itemDescription = "";
    }

    /**
     * @author Leandro da Silva
     * @return String - Retorna o nome do item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @author Leandro da Silva
     * @param itemName - Atribui o nome do item
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return int - Retorna um inteiro com o código do item
     */
    public int getItemCode() {
        return itemCode;
    }

    /**
     *
     * @param itemCode - Atribui o código do item
     */
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    /**
     *
     * @return int - Retorna um inteiro com a quantidade do item
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     *
     * @param itemQuantity - Atribui um inteiro como quantidade do item
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     *
     * @return double - Retorna um double com o preço do item
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     *
     * @param itemPrice - Atribui um double como preço do item
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     *
     * @return String - Retorna uma string com a descriçao do item
     */
    public String getItemDescription() {
        return itemDescription;
    }
    /**
     * 
     * @param itemDescription - Atribui uma string com a descrição do item 
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

}
