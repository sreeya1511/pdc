/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.util.ArrayList;

/**
 *
 * @author trion
 */
public class BookShop {
    
    private Inventory inventory;  //instance of Inventoryy class- represents Inventoryy in physical store
    
    
    // constructor - instansiate
    public BookShop() 
    {
        this.inventory = new Inventory();
    }
   
    // method to add new book to inventory
    public void addBook(Book newBook) {
        this.inventory.addBook(newBook);
    }
    
    
   
    // method to remove book from inventory
    /*public void removeBook(Book bookToRemove) 
    {
        this.inventory.removeBook(bookToRemove);
    }*/
   
    //method to remove book from inventory- takes serial as parameter- in case 2 books have same name
    //serial is always unique
    public void removeBook(String serial) 
    {
    for (Book book : inventory.getListOfBooks())   
    //iterate through listOfBooks to check for equality
    //each object in getListOfBooks collection is assigned to book to check equality
    {
        if (book.getSerialNo().equals(serial))  // check current book = serial in parameter
        {
            inventory.removeBook(book);
            break;
        }
    }
    
    }
    
    // get book with particular serial
    public Book getBook(String serial) 
    {
    //iterate through ListOfBooks
    for (Book book : inventory.getListOfBooks()) 
    {
        //checks if parameter serial = current book serial
        if (book.getSerialNo().equals(serial)) {
            return book;
        }
    }
    return null;
}
    
    // method to process a new order made by customer
    //takes customer object and Book ArrayList as parameter
    //returns type Order
//    public Order processOrder(Customer customer, Book orderedBooks) {
//        
//        // create new Order object
//        Order newOrder = new Order(customer,  orderedBooks);
//        
//        //iterate through orderedBooks
//        for (Book book : orderedBooks) 
//        {
//            int currentQuantity = book.getQuantity();
//            
//            
//            if (currentQuantity > 0) {
//                //no of books reduces in inventory - because customer placed order
//                book.setQuantity(currentQuantity - 1);
//            } else 
//            {
//                System.out.println("Error: no stock in store for " + book.getTitle());
//            }
//        }
//        return newOrder;
//    }
   
    // method to get current inventory of books
    //public Book getInventory() 
    //{
      //  return inventory.getListOfBooks();
    //}
    
    // string representation of list of books in Inventoryy class
    public String toString()
    {
    
        
        String displayString = " ";
    
        displayString+="Current inventory: ";
        for (Book book : inventory.getListOfBooks()) 
    {
        displayString+=(book.getTitle())+" by "+(book.getAuthor())+", Quantity: "+(book.getQuantity())+" ";
    }    
        return displayString.toString();
    
    }
    
    //method to check if a book exists in inventory with serial as parameter
    public boolean bookExists(String serial) 
    {
    for (Book book : inventory.getListOfBooks())
    {
        if (book.getSerialNo().equals(serial)) //checking if serial of current book = serial in parameter
        {
            return true;
        }
    }
    return false;
    }
    
    
}
