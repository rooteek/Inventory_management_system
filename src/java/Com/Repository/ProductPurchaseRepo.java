/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Repository;

import Com.FormModel.ProductPurchaseVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ProductPurchaseRepo {
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    public int insertProductPurchaseRepo(ProductPurchaseVO productPurchaseVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.PRODUCT_IN_PURCHASE(INVOICE_NO,PRODUCT_ID,QUANTITY,UNIT,PRICE,AMOUNT) VALUES(?,(SELECT PRODUCT_ID FROM SA_MANAGEMENT.PRODUCT_MST WHERE PRODUCT_NAME = ?),?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1,productPurchaseVO.getInvoiceNo());
        pstm.setString(2,productPurchaseVO.getProductName());
        pstm.setInt(3,productPurchaseVO.getQuantity());
        pstm.setString(4,productPurchaseVO.getUnit());
        pstm.setInt(5,productPurchaseVO.getPrice());
        pstm.setInt(6, productPurchaseVO.getAmount());
        int status = pstm.executeUpdate();
        return status;
    }

    
    public ResultSet fetchAllProductPurchaseRepo(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT S.INVOICE_NO,P.PRODUCT_NAME,S.QUANTITY,S.UNIT,S.PRICE,S.AMOUNT FROM SA_MANAGEMENT.PRODUCT_IN_PURCHASE S JOIN SA_MANAGEMENT.PRODUCT_MST P ON (S.PRODUCT_ID = P.PRODUCT_ID) WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1,invoiceNo);
        ResultSet productInSales = pstm.executeQuery();
        return productInSales;
    }

    
    public int deleteProductPurchaseRepo(Integer invoiceNo) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.PRODUCT_IN_PURCHASE WHERE INVOICE_NO = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, invoiceNo);
       int status =  pstm.executeUpdate();
       return status ;
    }
    
}
