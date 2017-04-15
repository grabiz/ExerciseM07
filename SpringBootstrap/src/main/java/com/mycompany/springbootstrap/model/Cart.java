/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.model;

import com.mycompany.springbootstrap.utils.DoesProductExist;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN
 */
public class Cart {
    private ArrayList<LineItems> lineItems;

    public Cart() {
        this.lineItems = new ArrayList<>();
    }

    public ArrayList<LineItems> getLineItems() {
        return lineItems;
    }
   
   public void addToCart(LineItems lineItem)
   {
        if(DoesProductExist.Quantity(lineItems, lineItem.getProduct())==0)
        {
           lineItems.add(lineItem);
        }
        else
        {
           for(LineItems l: lineItems){
               if(l.getProduct().getId()==lineItem.getProduct().getId())
               {
                    l.setQuantity(lineItem.getQuantity());
               }
           }
        }
   }
   public void removeFromCart(LineItems lineItem)
   {
      lineItems.remove(lineItem);
   }
}
