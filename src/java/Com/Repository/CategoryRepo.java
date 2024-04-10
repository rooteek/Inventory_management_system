
package Com.Repository;

import Com.FormModel.CategoryVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepo {
    
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    
    public int insertCategoryRepo(CategoryVO categoryVO) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO CATEGORY_MST(CATEGORY_ID,CATEGORY_NAME) VALUES(?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, categoryVO.getCategoryId());
        pstm.setString(2, categoryVO.getCategoryName());
        int status = pstm.executeUpdate();
        return status ;
    }
    
    
    public ResultSet fetchCategoryByIdRepo(int categoryId) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT CATEGORY_ID,CATEGORY_NAME FROM SA_MANAGEMENT.CATEGORY_MST WHERE CATEGORY_ID = ? ";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, categoryId);
        ResultSet category =  pstm.executeQuery();
        return category ;
    }
    
    
    public ResultSet fetchAllCategoryRepo() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT CATEGORY_ID,CATEGORY_NAME FROM SA_MANAGEMENT.CATEGORY_MST";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet category =  pstm.executeQuery();
        return category ;
    }
    
    
    public int updateCategoryRepo(CategoryVO categoryVO) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.CATEGORY_MST SET CATEGORY_NAME = ? WHERE CATEGORY_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, categoryVO.getCategoryName());
        pstm.setInt(2, categoryVO.getCategoryId());
        int status = pstm.executeUpdate();
        return status ;
    }
    
    
    public int deleteCategoryRepo(int categoryId) throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="DELETE FROM SA_MANAGEMENT.CATEGORY_MST WHERE CATEGORY_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, categoryId);
        int status = pstm.executeUpdate();
        return status ;
    }
    
    
}
