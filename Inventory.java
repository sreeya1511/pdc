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
public class Inventory {
    
    //object of Inventory class- ArrayList of type <Book>- named listOfBooks
     private ArrayList<Book> listOfBooks;
   
    // Constructor- create new instance of inventory class
    public Inventory()
    {
        this.listOfBooks = new ArrayList<Book>();
        
    }
   
    // method to add new book to inventory
    //takes type Book as parameter
    public void addBook(Book newBook)
    {
        this.listOfBooks.add(newBook);
    }
   
    // method to remove book from inventory
    public void removeBook(Book bookRemove)
    {
        this.listOfBooks.remove(bookRemove);
    }
    
    
   
    // method to update quantity of a book in inventory
    public void updateBookQuantity(Book bookUpdate, int newQuantity)
    {
        bookUpdate.setQuantity(newQuantity);
    }
   
    // method to update price of book the inventory
    public void updateBookPrice(Book bookToUpdate, int newPrice) 
    {
        bookToUpdate.setPrice(newPrice);
    }
   
    // method to return list of books in inventory
    public ArrayList<Book> getListOfBooks()
    {
        return listOfBooks;
    }
    
}
