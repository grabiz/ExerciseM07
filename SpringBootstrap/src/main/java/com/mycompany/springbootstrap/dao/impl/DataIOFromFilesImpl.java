/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.dao.impl;

import com.mycompany.springbootstrap.dao.DataIO;
import com.mycompany.springbootstrap.model.Cart;
import com.mycompany.springbootstrap.model.LineItems;
import com.mycompany.springbootstrap.model.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGUYEN
 */
public class DataIOFromFilesImpl implements DataIO {

    @Override
    public ArrayList<Product> ReadData() {
        
        try {
            ArrayList<Product> listProduct = new ArrayList<>();
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String textLine;
            while ((textLine = reader.readLine()) != null) {
                String[] attributes = textLine.split(",");
                Product product = new Product();
                product.setId(Integer.parseInt(attributes[0]));
                product.setBranch(attributes[1]);
                product.setPrice(Double.parseDouble(attributes[2]));
                product.setDescription(attributes[3]);
                listProduct.add(product);
            }
            return listProduct;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataIOFromFilesImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(DataIOFromFilesImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void WriteData(ArrayList<Product> list) {
        File file = new File(path);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Product prod : list) {
                writer.write(prod.getId() + "," + prod.getBranch() + "," + prod.getPrice() + "," + prod.getDescription());
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DataIOFromFilesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void UpdateData(Product product) {
        ArrayList<Product> listProd = ReadData();
        listProd.set(product.getId(), product);
        for(Product l:listProd)
        {
           System.out.println(l.getId()+l.getBranch());
        }
        WriteData(listProd);
    }

    @Override
    public void ProductInvoiceExport(Cart cart) {
        File file = new File("D:/checkout.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            ArrayList<LineItems> list = cart.getLineItems();
            
            for (LineItems line : list) {
                writer.write(line.getProduct().getId() + "/" + line.getProduct().getBranch() + "/" 
                        +line.getProduct().getPrice() + "/" + line.getProduct().getDescription()+ "/"
                        +line.getTotal());
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(DataIOFromFilesImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
