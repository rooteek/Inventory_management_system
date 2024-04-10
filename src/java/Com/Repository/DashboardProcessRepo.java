package Com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardProcessRepo {

    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    ResultSet rs;
    Connection con;
    String query;

    public ResultSet fetchAllCustomerRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,CITY,REGISTRATION_TYPE,MOBILE_NO,GST_NO FROM SA_MANAGEMENT.CUSTOMER_MST";
        PreparedStatement pstm = con.prepareStatement(query);
        rs = pstm.executeQuery();
        System.out.println("The Cusotmer in repository is ---------->" + rs);
        return rs;
    }

    public ResultSet fetchAllSalesRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT S.INVOICE_NO,C.CUSTOMER_NAME,C.REGISTRATION_TYPE,S.BILL_DATE,S.TOTAL_AMT FROM SA_MANAGEMENT.SALES_INVOICE S JOIN SA_MANAGEMENT.CUSTOMER_MST C ON (S.CUSTOMER_ID = C.CUSTOMER_ID)";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet sales =  pstm.executeQuery();
        return sales;
    }
    public ResultSet fetchAllPurchaseRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT P.INVOICE_NO,V.PARTY_NAME,V.REGISTRATION_TYPE,P.BILL_DATE,P.TOTAL_AMT FROM SA_MANAGEMENT.PURCHASE_INVOICE P JOIN SA_MANAGEMENT.VENDOR_MST V ON (P.VENDOR_ID = V.VENDOR_ID)";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet purchase =  pstm.executeQuery();
        return purchase;
    }
    public ResultSet fetchAllVendorRepo() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="SELECT VENDOR_ID,PARTY_NAME,ADDRESS,STATE,CITY,PINCODE,PAN,REGISTRATION_TYPE,MOBILE_NO,EMAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE FROM SA_MANAGEMENT.VENDOR_MST";
       PreparedStatement pstm = con.prepareStatement(query);
       ResultSet vendor =  pstm.executeQuery();
       return vendor ;
    }
   public ResultSet fetchStockRepo() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
//        query="SELECT S.SR_NO , P.PRODUCT_NAME , S.UNIT , S.QUANTITY FROM SA_MANAGEMENT.STOCK_MANAGEMENT S JOIN SA_MANAGEMENT.PRODUCT_MST P IN (S.PRODUCT_ID = P.PRODUCT_ID)";
        query="select * from sa_management.stock_management";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet status = pstm.executeQuery();
        return status;
    }
}
