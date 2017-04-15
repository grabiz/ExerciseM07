/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.utils;

import com.mycompany.springbootstrap.model.LineItems;
import com.mycompany.springbootstrap.model.Product;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN
 */
public class DoesProductExist {

    public static int Quantity(ArrayList<LineItems> lineItems, Product product) {
        int quantity = 0;
        for (LineItems l : lineItems) {
            if (l.getProduct().getId() == product.getId()) {
                
                return quantity=l.getQuantity();
            }

        }
        return quantity;

    }
    
}
