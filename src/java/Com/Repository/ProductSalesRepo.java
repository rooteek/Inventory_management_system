
package Com.Repository;

import Com.FormModel.ProductSalesVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSalesRepo {
    
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    public int insertProductSalesRepo(ProductSalesVO productSalesVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.PRODUCT_IN_SALES(INVOICE_NO,PRODUCT_ID,QUANTITY,UNIT,PRICE,AMOUNT) VALUES(?,(SELECT PRODUCT_ID FROM SA_MANAGEMENT.PRODUCT_MST WHERE PRODUCT_NAME = ?),?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1,productSalesVO.getInvoiceNo());
        pstm.setString(2,productSalesVO.getProductName());
        pstm.setInt(3,productSalesVO.getQuantity());
        pstm.setString(4,productSalesVO.getUnit());
        pstm.setInt(5,productSalesVO.getPrice());
        pstm.setInt(6, productSalesVO.getAmount());
        int status = pstm.executeUpdate();
        return status;
    }

    public ResultSet fetchAllProductSalesRepo(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT S.INVOICE_NO,P.PRODUCT_NAME,S.QUANTITY,S.UNIT,S.PRICE,S.AMOUNT FROM SA_MANAGEMENT.PRODUCT_IN_SALES S JOIN SA_MANAGEMENT.PRODUCT_MST P ON (S.PRODUCT_ID = P.PRODUCT_ID) WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1,invoiceNo);
        ResultSet productInSales = pstm.executeQuery();
        return productInSales;
    }

    public int deleteProductSalesRepo(Integer invoiceNo) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.PRODUCT_IN_SALES WHERE INVOICE_NO = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, invoiceNo);
       int status =  pstm.executeUpdate();
       return status ;
    }
    

}
