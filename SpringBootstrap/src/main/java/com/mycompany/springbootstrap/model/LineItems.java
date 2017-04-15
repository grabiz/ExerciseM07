/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.model;

import java.io.Serializable;

/**
 *
 * @author NGUYEN
 */
public class LineItems implements Serializable {
    private Product product;
    private int quantity;

    public LineItems() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal(){
        return quantity*product.getPrice();
    }
    
}
