/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author garry
 */
public class ProductMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) //throws MyException
    {
        // TODO code application logic here
        try{
            
            
            String s1="anju";
             String s2="tenjuu";
            
            System.out.println(s1.equals(s2));
            //System.out.println(2/0);
        Product p1=new Product("1","keyboard",1,10.50f);
        System.out.println(p1);
        p1.addstock(10);
        
       System.out.println( p1);
        p1.getQuantity();
        }//of try 
        catch(MyException e ){
            System.out.println(e.getMessage());
        }//of catch of ME
        
        catch(ArithmeticException e ){
            System.out.println(e.getMessage());
        }//of catch of ME
        catch(Exception e ){
            
        }
        finally
        {
            System.out.println("done ");
        }
    }
    
}
