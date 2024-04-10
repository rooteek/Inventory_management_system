package Com.Repository;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class queryRepository {

    String path = "jdbc:mysql://localhost:3306/rut";
    String username = "root";
    String password = "root";
    ResultSet rs;
    Connection con;

    public ResultSet showData() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        String query = "select * from curd";
        PreparedStatement pstm = con.prepareStatement(query);
        rs = pstm.executeQuery();
        return rs;
    }
    public int deleteData(String id) throws SQLException {
        con = DriverManager.getConnection(path, username, password);
        String query="delete  from curd where user_id=?";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1, id);
        int state=pstm.executeUpdate();
        return state;
    }
    public int insertData(String name,String email,String pass,String mobile,String address) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection(path, username, password);
        String query="insert into curd(uname,email,password,mobile,address) values(?,?,?,?,?)";
        PreparedStatement pstm=con.prepareStatement(query);
        pstm.setString(1, name);
        pstm.setString(2, email);
        pstm.setString(3, pass);
        pstm.setString(4, mobile);
        pstm.setString(5, address);
        int state=pstm.executeUpdate();
        return state;
    }
}
