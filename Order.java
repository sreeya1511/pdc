/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author trion
 */
public class Order {
    
    private Customer customer;
   
    private Book orderedBooks;  //similar to object of Inventory class
   
    // Constructor
    public Order(Customer customer, Book orderedBooks)
    {
        this.customer = customer;
       
        this.orderedBooks = orderedBooks;
    }
   
    // Getters and setters for each property
    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
   
    
    
   
    //get list of books that have been ordered
    public Book getOrderedBooks() 
    {
        return orderedBooks;
    }
    public void setOrderedBooks(Book orderedBooks) 
    {
        this.orderedBooks = orderedBooks;
    }
    
}
