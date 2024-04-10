
package Com.Repository;

import Com.FormModel.SalesVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesRepo {
   
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
//    @Override
    public int insertSalesRepo(SalesVO salesVO) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.SALES_INVOICE(INVOICE_NO,CUSTOMER_ID,BILL_DATE,GST,FREIGHT,DISCOUNT,NET_AMT,TOTAL_AMT) VALUES(?,(SELECT CUSTOMER_ID FROM SA_MANAGEMENT.CUSTOMER_MST WHERE CUSTOMER_NAME=?),?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, salesVO.getInvoiceNo());
        pstm.setString(2, salesVO.getCustomerName());
        pstm.setString(3, salesVO.getBillDate());
        pstm.setInt(4, salesVO.getGst());
        pstm.setInt(5, salesVO.getFreight());
        pstm.setInt(6, salesVO.getDiscount());
        pstm.setInt(7, salesVO.getNetAmt());
        pstm.setInt(8, salesVO.getTotalAmt());

        int status = pstm.executeUpdate();
        return status ; 
    }

//    @Override
    public ResultSet fetchAllSalesRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT S.INVOICE_NO,C.CUSTOMER_NAME,S.BILL_DATE,S.TOTAL_AMT FROM SA_MANAGEMENT.SALES_INVOICE S JOIN SA_MANAGEMENT.CUSTOMER_MST C ON (S.CUSTOMER_ID = C.CUSTOMER_ID)";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet sales =  pstm.executeQuery();
        return sales;
    }

//    @Override
    public ResultSet fetchSalesByIdRepo(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT S.INVOICE_NO,C.CUSTOMER_NAME,S.BILL_DATE,S.GST,S.FREIGHT,S.DISCOUNT,S.NET_AMT,S.TOTAL_AMT FROM SA_MANAGEMENT.SALES_INVOICE S JOIN SA_MANAGEMENT.CUSTOMER_MST C ON (S.CUSTOMER_ID = C.CUSTOMER_ID) WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, invoiceNo);
        ResultSet sales =  pstm.executeQuery();
        return sales;
    }
    
//    @Override
    public int updateSalesRepo(SalesVO salesVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.SALES_INVOICE SET CUSTOMER_ID = (SELECT CUSTOMER_ID FROM SA_MANAGEMENT.CUSTOMER_MST WHERE CUSTOMER_NAME=?),BILL_DATE = ?,GST = ?,FREIGHT = ?,DISCOUNT = ?,NET_AMT = ?,TOTAL_AMT = ? WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, salesVO.getCustomerName());
        pstm.setString(2, salesVO.getBillDate());
        pstm.setInt(3, salesVO.getGst());
        pstm.setInt(4, salesVO.getFreight());
        pstm.setInt(5, salesVO.getDiscount());
        pstm.setInt(6, salesVO.getNetAmt());
        pstm.setInt(7, salesVO.getTotalAmt());
        pstm.setInt(8, salesVO.getInvoiceNo());
        int status = pstm.executeUpdate();
        return status ;  
    }

//    @Override
    public int deleteSalesRepo(Integer invoiceNo) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.SALES_INVOICE WHERE INVOICE_NO = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, invoiceNo);
       int status =  pstm.executeUpdate();
       return status ;
    }
 
}
