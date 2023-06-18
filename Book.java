/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

/**
 *
 * @author trion
 */
public class Book {
    
     private String title;
    private String author;
    private int price;
    private int quantity;
    private String serialNo;
   
    
    // Constructor- instansiate all objects of Book class
    public Book(String title, String author, int price, int quantity, String serial) 
    {
        this.title = title;
        this.author = author;
        if (price > 10 && price < 100)
        {
            this.price = price;
        }
        
        if (quantity>=0 && quantity < 500)
        {
            this.quantity = quantity;
        }
        this.serialNo = serial;
    }
   
    // Getters and setters for all objects
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
   
    public String getAuthor()
    {
        return author;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
   
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price) 
    {
        this.price = price;
    }
   
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
   
    public String getSerialNo()
    {
        return serialNo;
    }
    public void setSerialNo(String serialNo)
    {
        this.serialNo = serialNo;
    }
    

    
}
