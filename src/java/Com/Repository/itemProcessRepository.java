
package Com.Repository;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class itemProcessRepository {
    
    
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    ResultSet rs;
    Connection con;
    public ResultSet showItemList() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        String query = "select PRODUCT_ID,PRODUCT_NAME,SALES_PRICE,PURCHASE_PRICE,CATEGORY_ID,HSN_CODE,IMAGE from PRODUCT_MST";
        PreparedStatement pstm = con.prepareStatement(query);
        rs = pstm.executeQuery();
        return rs;
    }
    public int deleteData(String id) throws SQLException {
        con = DriverManager.getConnection(path, username, password);
        String query="delete  from item where user_id=?";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1, id);
        int state=pstm.executeUpdate();
        return state;
    }
}
