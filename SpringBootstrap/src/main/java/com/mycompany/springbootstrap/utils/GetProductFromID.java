/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.utils;

import com.mycompany.springbootstrap.dao.impl.DataIOFromFilesImpl;
import com.mycompany.springbootstrap.model.Product;
import java.util.ArrayList;

/**
 *
 * @author NGUYEN
 */
public class GetProductFromID {
    public static Product getProductFromID(int id){
        DataIOFromFilesImpl read = new DataIOFromFilesImpl();
        ArrayList<Product> list = read.ReadData();
        return list.get(id);
    }
}
