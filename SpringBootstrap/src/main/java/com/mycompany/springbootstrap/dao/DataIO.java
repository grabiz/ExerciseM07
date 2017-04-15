/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.dao;

import com.mycompany.springbootstrap.model.Cart;
import com.mycompany.springbootstrap.model.Product;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN
 */
public interface DataIO {
    public final String path ="D:/productList.txt";
    public ArrayList<Product> ReadData();
    public void WriteData(ArrayList<Product> list);
    public void ProductInvoiceExport(Cart cart);
    public void UpdateData(Product product);
}
