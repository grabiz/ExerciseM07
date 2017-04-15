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
public class Product implements Serializable {

    private int id;
    private String branch;
    private double price;
    private String description;

    public Product() {
    }

    public Product(int id, String branch, double price, String description) {
        this.id = id;
        this.branch = branch;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
