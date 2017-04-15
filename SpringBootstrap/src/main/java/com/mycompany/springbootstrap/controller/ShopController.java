/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootstrap.controller;

import com.mycompany.springbootstrap.dao.impl.DataIOFromFilesImpl;
import com.mycompany.springbootstrap.model.Cart;
import com.mycompany.springbootstrap.model.LineItems;
import com.mycompany.springbootstrap.model.Product;
import com.mycompany.springbootstrap.utils.DoesProductExist;
import com.mycompany.springbootstrap.utils.GetProductFromID;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NGUYEN
 */
@Controller
public class ShopController {
    
    @RequestMapping(value = "showList")
    public ModelAndView ShowList(HttpSession session) throws FileNotFoundException {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ListProduct");
        DataIOFromFilesImpl readData = new DataIOFromFilesImpl();
        ArrayList<Product> prodList = readData.ReadData();
        mv.addObject("listProduct", prodList);
        session.setAttribute("list", prodList);
        return mv;
    }
    
    @RequestMapping(value = "addEdit")
    public ModelAndView OrderList(HttpSession session, HttpServletRequest req) {
        String[] action = req.getParameterValues("action");
        int prodId = Integer.parseInt(req.getParameter("prodId"));
        ModelAndView mv = new ModelAndView();
        
        if (action[0].equals("add")) {
            
            if (session.getAttribute("cart") == null) {
                Cart cart = new Cart();
                session.setAttribute("cart", cart);
            }
            
            Product product = GetProductFromID.getProductFromID(prodId);
            
            Cart cart = (Cart) session.getAttribute("cart");
            LineItems lineItems = new LineItems();
            
            lineItems.setProduct(product);
            if (DoesProductExist.Quantity(cart.getLineItems(), product) > 0) {
                lineItems.setQuantity(DoesProductExist.Quantity(cart.getLineItems(), product));
            } else {
                
                lineItems.setQuantity(1);
            }
            
            cart.addToCart(lineItems);
            session.setAttribute("cart", cart);
            mv.setViewName("Order");
            return mv;
        } else {
            Product product = new Product();
            product = GetProductFromID.getProductFromID(prodId);
            mv.addObject("product", product);
            mv.setViewName("EditData");
            return mv;
            
        }
    }
    
    @RequestMapping(value = "saveCancel")
    public String SaveOrCancel(HttpSession session, HttpServletRequest req) {
        String[] action = req.getParameterValues("action");
        int id = Integer.parseInt(req.getParameter("id"));
        String branch = req.getParameter("branch");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        Product product = new Product(id, branch, price, description);
        ModelAndView mv = new ModelAndView();
        if (action[0].equals("save")) {
            DataIOFromFilesImpl update = new DataIOFromFilesImpl();
            update.UpdateData(product);
        }
        return "redirect:/showList";
    }
    
    @RequestMapping(value = "order", method = POST)
    public String OrderProcess(HttpSession session, HttpServletRequest req) {
        String[] action = req.getParameterValues("action");
        Cart cart = (Cart) session.getAttribute("cart");
        String[] removeStr = req.getParameterValues("checkbox");
        String[] quantityIdStr = req.getParameterValues("quantityId");
        String[] quantityProdStr = req.getParameterValues("quantityProd");
        
        if (action[0].equals("update")) {
            if (quantityIdStr != null) {
                for (int i = 0; i < quantityIdStr.length; i++) {
                    Product product = GetProductFromID.getProductFromID(Integer.parseInt(quantityIdStr[i]));
                    LineItems lineItem = new LineItems();
                    lineItem.setProduct(product);
                    lineItem.setQuantity(Integer.parseInt(quantityProdStr[i]));
                    cart.addToCart(lineItem);
                }
                session.setAttribute("cart", cart);
            }
            return "Order";
        } else {
            if (removeStr != null) {
                ArrayList<LineItems> lines = cart.getLineItems();
                for (String i : removeStr) {
                    for (int j = 0; j < lines.size(); j++) {
                        
                        if (lines.get(j).getProduct().getId() == Integer.parseInt(i)) {
                            cart.removeFromCart(lines.get(j));
                        }
                    }
                    
                }
                session.setAttribute("cart", cart);
            }
            return "Order";
        }
    }
    
    //Return order page--This will make update/remove works 
    @RequestMapping(value = "order", method = GET)
    public void OrderProcessGET(HttpSession session, HttpServletRequest req) 
    {
    }
    
    @RequestMapping(value = "continue")
    public String Continue() {
        return "redirect:/showList";
    }
    
    @RequestMapping(value = "checkout")
    public ModelAndView Checkout(HttpSession session
    ) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Thanks");
        Cart cart = (Cart) session.getAttribute("cart");
        DataIOFromFilesImpl write = new DataIOFromFilesImpl();
        write.ProductInvoiceExport(cart);
        return mv;
    }
}
