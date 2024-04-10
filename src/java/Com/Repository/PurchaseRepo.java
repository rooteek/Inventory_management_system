/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Repository;

import Com.FormModel.PurchaseVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class PurchaseRepo {
     String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    public int insertPurchaseRepo(PurchaseVO purchaseVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.PURCHASE_INVOICE(INVOICE_NO,VENDOR_ID,BILL_DATE,GST,FREIGHT,DISCOUNT,NET_AMT,TOTAL_AMT) VALUES(?,(SELECT VENDOR_ID FROM SA_MANAGEMENT.VENDOR_MST WHERE PARTY_NAME=?),?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, purchaseVO.getInvoiceNo());
        pstm.setString(2, purchaseVO.getVendorName());
        pstm.setString(3, purchaseVO.getBillDate());
        pstm.setInt(4, purchaseVO.getGst());
        pstm.setInt(5, purchaseVO.getFreight());
        pstm.setInt(6, purchaseVO.getDiscount());
        pstm.setInt(7, purchaseVO.getNetAmt());
        pstm.setInt(8, purchaseVO.getTotalAmt());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public ResultSet fetchPurchaseByIdRepo(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT P.INVOICE_NO,V.PARTY_NAME,P.BILL_DATE,P.GST,P.FREIGHT,P.DISCOUNT,P.NET_AMT,P.TOTAL_AMT FROM SA_MANAGEMENT.PURCHASE_INVOICE P JOIN SA_MANAGEMENT.VENDOR_MST V ON (P.VENDOR_ID = V.VENDOR_ID) WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, invoiceNo);
        ResultSet purchase =  pstm.executeQuery();
        return purchase ;
    }

    
    public ResultSet fetchAllPurchaseRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT P.INVOICE_NO,V.PARTY_NAME,P.BILL_DATE,P.TOTAL_AMT FROM SA_MANAGEMENT.PURCHASE_INVOICE P JOIN SA_MANAGEMENT.VENDOR_MST V ON (P.VENDOR_ID = V.VENDOR_ID)";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet purchase =  pstm.executeQuery();
        return purchase;
    }

    
    public int updatePurchaseRepo(PurchaseVO purchaseVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.PURCHASE_INVOICE SET VENDOR_ID = (SELECT VENDOR_ID FROM SA_MANAGEMENT.VENDOR_MST WHERE PARTY_NAME=?),BILL_DATE = ?,GST = ?,FREIGHT = ?,DISCOUNT = ?,NET_AMT = ?,TOTAL_AMT = ? WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, purchaseVO.getVendorName());
        pstm.setString(2, purchaseVO.getBillDate());
        pstm.setInt(3, purchaseVO.getGst());
        pstm.setInt(4, purchaseVO.getFreight());
        pstm.setInt(5, purchaseVO.getDiscount());
        pstm.setInt(6, purchaseVO.getNetAmt());
        pstm.setInt(7, purchaseVO.getTotalAmt());
        pstm.setInt(8, purchaseVO.getInvoiceNo());
        int status = pstm.executeUpdate();
        return status ;  
    }

    
    public int deletePurchaseRepo(Integer invoiceNo) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.PURCHASE_INVOICE WHERE INVOICE_NO = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, invoiceNo);
       int status =  pstm.executeUpdate();
       return status ;
    }
}
