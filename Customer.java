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
public class Customer {
    
    private String name;
     private int phoneNumber;
    private String address;
    private String email;
   
    // Constructor- instansiate all objects of Customer class
    public Customer(String name, String address, String email, int number)
    {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = number;
    }
   
    // getters and setters for all objects
    public String getName()
    {
        return name;
    }
    public void setName(String name)   
    {
        this.name = name;
    }
    
    public int getNumber()
    {
        return phoneNumber;
    }
    public void setNumber(int number)
    {
        this.phoneNumber = number;
    }
    
    
   
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
        
    }
   
    public String getEmail() 
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
