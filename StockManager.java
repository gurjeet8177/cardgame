
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *this class simulates an inventory/stock of products. products can be added, searched ,updated and delete. 
 * @author Gurjeet Sandhu
 * @since July 13,2017
 * @version 1.0
 */
public class StockManager {
  
    private ArrayList<Product> stock;
    
    
    public StockManager(){
    stock=new ArrayList<Product>();
    }
    
    
    public Product findProductById(String id) throws Exception{
    
    for(Product p: stock)
        if(p.getId().equalsIgnoreCase(id))
        return p;
      throw new Exception("no match is found");
    }
    
    
    
     public Product findProductByName(String name) throws Exception{
    
    for(Product p: stock)
        if(p.getName().equalsIgnoreCase(name))
        return p;
    //return null
      throw new Exception("no match is found");
    }
     
     
     public void addProduct(Product product) throws MyException
     {
     
     
         
     }
}
