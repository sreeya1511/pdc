/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author trion
 */
public class BookDatabase {
    
    //Passing log in info
    private static String USERNAME = "pdc";
    private static String PASSWORD = "pdc";
    private static String URL = "jdbc:derby:InventoryDB; create=true";

    private Connection conn;

    //Connecting to database
   // public BookDatabasehrows SQLException{
     //   establishConnection();
    //}

    public Connection getConnection(){
        return this.getConn();
    }

    public void establishConnection() throws SQLException {
        setConn(DriverManager.getConnection(getURL(), getUSERNAME(), getPASSWORD()));
    }

    public static String getUSERNAME(){
        return USERNAME;
    }

    public static void setUSERNAME(String aUSERNAME){
        USERNAME = aUSERNAME;
    }

    public static String getPASSWORD(){
        return PASSWORD;
    }

    public static void setPASSWORD(String aPASSWORD){
        PASSWORD = aPASSWORD;
    }

    public static String getURL(){
        return URL;
    }

    public static void setURL (String aURL) {
        URL = aURL;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection aConn){
        this.conn = aConn;
    }
    
}
