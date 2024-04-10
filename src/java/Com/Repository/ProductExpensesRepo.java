/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Repository;

import Com.FormModel.ProductExpensesVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ProductExpensesRepo {
   
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    public int insertProductExpensesRepo(ProductExpensesVO productExpensesVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.PRODUCT_IN_EXPENSES(INVOICE_NO,PRODUCT_NAME,AMOUNT) VALUES(?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1,productExpensesVO.getInvoiceNo());
        pstm.setString(2,productExpensesVO.getProductName());
        pstm.setInt(3, productExpensesVO.getAmount());
        int status = pstm.executeUpdate();
        return status;
    }

    
    public ResultSet fetchAllProductExpensesRepo(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT INVOICE_NO,PRODUCT_NAME,AMOUNT FROM SA_MANAGEMENT.PRODUCT_IN_EXPENSES WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1,invoiceNo);
        ResultSet productInSales = pstm.executeQuery();
        return productInSales;
    }

    
    public int deleteProductExpensesRepo(Integer invoiceNo) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.PRODUCT_IN_EXPENSES WHERE INVOICE_NO = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, invoiceNo);
       int status =  pstm.executeUpdate();
       return status ;
    }
    
 
}
