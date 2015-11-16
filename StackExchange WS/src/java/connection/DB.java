/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class DB {
    // JDBC driver name and database URL
  static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
  static final String DB_URL="jdbc:mysql://localhost:3306/stackexchange?zeroDateTimeBehavior=convertToNull";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "";
  
  public static Connection connect() {
    Connection con = null;
    try {
      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      
      con = DriverManager.getConnection(DB_URL, USER, PASS);
      
    } catch (SQLException | ClassNotFoundException ex) {
    }
    
    return con;
  }
}
