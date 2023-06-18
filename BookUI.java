/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventory;

/**
 *
 * @author trion
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BookUI extends javax.swing.JFrame {

    /**
     * Creates new form BookUI
     */
    private static final String USERNAME = "inventoryadmin";
    private static final String PASSWORD = "xyz";

    private BookShop store;
    private TextField usernameField;
    private PasswordField passwordField;
    private TextArea outputArea;
    private Inventoryy inventory;
    
    private Connection connection;

    public BookUI() {
        initComponents();
    }
    
    public static void createDatabase(){
        Connection conn = null;
        Statement statement = null;
        
        final String newTable = "books";
        
        try {
            conn = DriverManager.getConnection("jdbc:derby:InventoryDB;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(BookUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try
         {
             statement = conn.createStatement();
             
             
             statement.addBatch("drop table books");
             
             //String sqlCreateTable = ;
             
             statement.addBatch("CREATE TABLE books (TITLE VARCHAR(70), AUTHOR VARCHAR(50), PRICE int, QUANTITY INT, SERIALNO VARCHAR(30))");
             System.out.println("making table ");
             statement.executeBatch();
             
         }
         
         catch (SQLException ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
         }
        
    }

    /*public BookUI(Book userBook) {
        initComponents();
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        removenewButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        exitButton.setText("EXIT");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        removenewButton.setText("Remove");
        removenewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removenewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(removenewButton)
                .addGap(185, 185, 185)
                .addComponent(exitButton)
                .addContainerGap(279, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(removenewButton))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

                                               
    /*Connection conn = null;
    Statement statement = null;
    
    final String newTable = "Books";
    
    try {
        conn = DriverManager.getConnection("jdbc:derby:InventoryDB;create=true");
    } catch (SQLException ex) {
        Logger.getLogger(BookUI.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    try {
        statement = conn.createStatement();
        
        statement.executeUpdate("DROP TABLE IF EXISTS " + newTable);
        
        String sqlCreateTable = "CREATE TABLE " + newTable + " (TITLE VARCHAR(70), AUTHOR VARCHAR(50), PRICE FLOAT, QUANTITY INT, SERIALNO VARCHAR(30))";
        
        statement.executeUpdate(sqlCreateTable);
    } catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
    }

    // Create a new dialog to prompt the user for book details

    JDialog dialog = new JDialog();
    // ... rest of your code ...

    // Declare a final statement object to be used inside the ActionListener
    final Statement finalStatement = statement;

    addButton.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            final String title = titleField.getText();
            final String author = authorField.getText();
            final double price = Double.parseDouble(priceField.getText());
            final int quantity = Integer.parseInt(quantityField.getText());
            final String serial = serialField.getText();

            Book book = new Book(title, author, price, quantity, serial);

            try {
                finalStatement.executeQuery("INSERT INTO " + newTable + " VALUES ('" + book.getTitle() + "','" + book.getAuthor() + "','" + book.getPrice() + "','" + book.getQuantity() + "','" + book.getSerialNo() + "');");
                jTextArea2.append("Book added successfully:\n" + book.getTitle());
                dialog.dispose();
            } catch (SQLException ex) {
                System.err.println("SQLException: " + ex.getMessage());
            }
        }
    });

    // ... rest of your code ...

 */
        
        
        
        
        
        Connection conn = null;
        Statement statement = null;
        
        final String newTable = "books";
        
        try {
            conn = DriverManager.getConnection("jdbc:derby:InventoryDB;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(BookUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try
         {
             statement = conn.createStatement();
             
             
             statement.executeUpdate("drop table books ");
             
             String sqlCreateTable = "CREATE TABLE books (TITLE VARCHAR(70), AUTHOR VARCHAR(50), PRICE INT, QUANTITY INT, SERIALNO VARCHAR(30))";
             
             statement.executeUpdate(sqlCreateTable);
             
         }
         
         catch (SQLException ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
         }
        
        
        
        // Create a new dialog to prompt the user for book details
        
        
        
        
        JDialog dialog = new JDialog();
        dialog.setTitle("Add Book");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set up the book detail input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField titleField = new JTextField();
        titleField.setToolTipText("Title");

        JTextField authorField = new JTextField();
        authorField.setToolTipText("Author");

        JTextField priceField = new JTextField();
        priceField.setToolTipText("Price");

        JTextField quantityField = new JTextField();
        quantityField.setToolTipText("Quantity");

        JTextField serialField = new JTextField();
        serialField.setToolTipText("Serial Number");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Serial Number:"));
        inputPanel.add(serialField);

        // Set up the dialog buttons
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
    
        final Statement finalStatement = statement;

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                final String title = titleField.getText();
                final String author = authorField.getText();
                final int price = Integer.parseInt(priceField.getText());
                final int quantity = Integer.parseInt(quantityField.getText());
                final String serial = serialField.getText();
                
                createDatabase();

                Book book = new Book(title, author, price, quantity, serial);
                
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                book.setQuantity(quantity);
                book.setSerialNo(serial);
                
                System.out.println("here are titles"+title + author + price + quantity+ serial);
                //store.addBook(book);
               
                try {
                
                //finalStatement.executeQuery("insert into books values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getPrice()+"','"+book.getQuantity()+"','"+book.getSerialNo()+"')");
                                                                   
                finalStatement.executeUpdate("INSERT INTO books VALUES ('" + book.getTitle() + "','" + book.getAuthor() + "', 100, 100, '" + book.getSerialNo() + "')");


                //finalStatement.executeQuery("insert into books values('"+book.getTitle()+"','"+book.getAuthor()+"', 100'"+book.getPrice()+"','"+book.getQuantity()+"','"+book.getSerialNo()+"')");
                
                jTextArea2.append("\nBook added successfully:" + book.getTitle());
                dialog.dispose();
                } catch (SQLException ex)
                {
                     System.err.println("SQLException: " + ex.getMessage());
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        dialog.setLayout(new BorderLayout());
        dialog.add(inputPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(null); // Center the dialog on the screen
        dialog.setVisible(true);

        

       
       
        
    }//GEN-LAST:event_addButtonActionPerformed

    
    
    
    
    
    //changes number of books
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

       Connection conn = null;
        Statement statement = null;
        
        final String newTable = "books";
        
        try {
            conn = DriverManager.getConnection("jdbc:derby:InventoryDB;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(BookUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try
         {
             statement = conn.createStatement();
             
             
             statement.executeUpdate("drop table books ");
             
             String sqlCreateTable = "CREATE TABLE books (TITLE VARCHAR(70), AUTHOR VARCHAR(50), PRICE INT, QUANTITY INT, SERIALNO VARCHAR(30))";
             
             statement.executeUpdate(sqlCreateTable);
             
         }
         
         catch (SQLException ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
         }
        
        
        
        // Create a new dialog to prompt the user for book details
        
        
        
        
        JDialog dialog = new JDialog();
        dialog.setTitle("Add Book");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set up the book detail input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField titleField = new JTextField();
        titleField.setToolTipText("Title");

        JTextField authorField = new JTextField();
        authorField.setToolTipText("Author");

        JTextField priceField = new JTextField();
        priceField.setToolTipText("Price");

        JTextField quantityField = new JTextField();
        quantityField.setToolTipText("Quantity");

        JTextField serialField = new JTextField();
        serialField.setToolTipText("Serial Number");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Serial Number:"));
        inputPanel.add(serialField);

        // Set up the dialog buttons
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
    
        final Statement finalStatement = statement;

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                final String title = titleField.getText();
                final String author = authorField.getText();
                final int price = Integer.parseInt(priceField.getText());
                final int quantity = Integer.parseInt(quantityField.getText());
                final String serial = serialField.getText();
                
                createDatabase();

                Book book = new Book(title, author, price, quantity, serial);
                
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                book.setQuantity(quantity);
                book.setSerialNo(serial);
                
                System.out.println("here are titles"+title + author + price + quantity+ serial);
                //store.addBook(book);
               
                try {
                
                //finalStatement.executeQuery("insert into books values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getPrice()+"','"+book.getQuantity()+"','"+book.getSerialNo()+"')");
                                                                   
                //finalStatement.executeUpdate("INSERT INTO books VALUES ('" + book.getTitle() + "','" + book.getAuthor() + "', 100, 100, '" + book.getSerialNo() + "')");


                //finalStatement.executeQuery("insert into books values('"+book.getTitle()+"','"+book.getAuthor()+"', 100'"+book.getPrice()+"','"+book.getQuantity()+"','"+book.getSerialNo()+"')");
                
                finalStatement.executeUpdate("update books set quantity=" + book.getQuantity() );
                
                jTextArea2.append("\nBook updated successfully:" + book.getTitle());
                dialog.dispose();
                } catch (SQLException ex)
                {
                     System.err.println("SQLException: " + ex.getMessage());
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        dialog.setLayout(new BorderLayout());
        dialog.add(inputPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(null); // Center the dialog on the screen
        dialog.setVisible(true);
        
          
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void removenewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removenewButtonActionPerformed
        // TODO add your handling code here:
        
        Connection conn = null;
        Statement statement = null;
        
        final String newTable = "books";
        
        try {
            conn = DriverManager.getConnection("jdbc:derby:InventoryDB;create=true");
        } catch (SQLException ex) {
            Logger.getLogger(BookUI.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try
         {
             statement = conn.createStatement();
             
             
             statement.executeUpdate("drop table books ");
             
             String sqlCreateTable = "CREATE TABLE books (TITLE VARCHAR(70), AUTHOR VARCHAR(50), PRICE INT, QUANTITY INT, SERIALNO VARCHAR(30))";
             
             statement.executeUpdate(sqlCreateTable);
             
         }
         
         catch (SQLException ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
         }
        
        
        
        // Create a new dialog to prompt the user for book details
        
        
        
        
        JDialog dialog = new JDialog();
        dialog.setTitle("Add Book");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set up the book detail input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField titleField = new JTextField();
        titleField.setToolTipText("Title");

        JTextField authorField = new JTextField();
        authorField.setToolTipText("Author");

        JTextField priceField = new JTextField();
        priceField.setToolTipText("Price");

        JTextField quantityField = new JTextField();
        quantityField.setToolTipText("Quantity");

        JTextField serialField = new JTextField();
        serialField.setToolTipText("Serial Number");

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Serial Number:"));
        inputPanel.add(serialField);

        // Set up the dialog buttons
        JButton addButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");
    
        final Statement finalStatement = statement;

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                final String title = titleField.getText();
                final String author = authorField.getText();
                final int price = Integer.parseInt(priceField.getText());
                final int quantity = Integer.parseInt(quantityField.getText());
                final String serial = serialField.getText();
                
                createDatabase();

                Book book = new Book(title, author, price, quantity, serial);
                
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                book.setQuantity(quantity);
                book.setSerialNo(serial);
                
                System.out.println("here are titles"+title + author + price + quantity+ serial);
                //store.addBook(book);
               
                try {
                
                //finalStatement.executeQuery("insert into books values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getPrice()+"','"+book.getQuantity()+"','"+book.getSerialNo()+"')");
                                                                   
                //finalStatement.executeUpdate("INSERT INTO books VALUES ('" + book.getTitle() + "','" + book.getAuthor() + "', 100, 100, '" + book.getSerialNo() + "')");
                finalStatement.executeUpdate("remove from books where serialno==" + book.getSerialNo() );

                //finalStatement.executeQuery("insert into books values('"+book.getTitle()+"','"+book.getAuthor()+"', 100'"+book.getPrice()+"','"+book.getQuantity()+"','"+book.getSerialNo()+"')");
                
                jTextArea2.append("\nBook removed successfully:" + book.getTitle());
                dialog.dispose();
                } catch (SQLException ex)
                {
                     System.err.println("SQLException: " + ex.getMessage());
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        dialog.setLayout(new BorderLayout());
        dialog.add(inputPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(null); // Center the dialog on the screen
        dialog.setVisible(true);
        
    }//GEN-LAST:event_removenewButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton removenewButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
