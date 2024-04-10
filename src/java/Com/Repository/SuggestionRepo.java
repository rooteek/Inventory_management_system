/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SuggestionRepo {
   
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    public ResultSet searchCustomerName(String name) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="SELECT PARTY_NAME FROM SA_MANAGEMENT.CUSTOMER_MST WHERE PARTY_NAME LIKE ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setString(1, "%" + name + "%");
       ResultSet rs = pstm.executeQuery();
       return rs;

    }
    
    
    public ResultSet searchProductName(String name) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
        query="SELECT PRODUCT_NAME FROM SA_MANAGEMENT.PRODUCT_MST WHERE PRODUCT_NAME LIKE ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setString(1, "%" + name + "%");
       ResultSet rs = pstm.executeQuery();
       return rs;

    }
    
    
    public ResultSet searchVendorName(String name) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="SELECT PARTY_NAME FROM SA_MANAGEMENT.VENDOR_MST WHERE PARTY_NAME LIKE ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setString(1, "%" + name + "%");
       ResultSet rs = pstm.executeQuery();
       return rs;
    }
    
    
    public ResultSet searchStateName() throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="SELECT STATE_NAME FROM SA_MANAGEMENT.ALL_STATES";
       PreparedStatement pstm = con.prepareStatement(query);
       //pstm.setString(1, "%" + name + "%");
       ResultSet rs = pstm.executeQuery();
       return rs;
    }
    
    
    public ResultSet searchCityName(String state) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="select city_name from all_cities C  join ALL_STATES S on C.STATE_CODE = S.state_code where S.STATE_CODE = (SELECT STATE_CODE FROM ALL_STATES WHERE STATE_NAME = ?);";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setString(1,state);
       ResultSet rs = pstm.executeQuery();
       return rs;
    } 
    
    public ResultSet searchCategoryName() throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="select CATEGORY_NAME from SA_MANAGEMENT.CATEGORY_MST";
       PreparedStatement pstm = con.prepareStatement(query);
       ResultSet rs = pstm.executeQuery();
       return rs;
    } 
}
