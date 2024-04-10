package Com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginRepository {

    String path = "jdbc:mysql://localhost:3306/rut";
    String username = "root";
    String password = "root";
    String query;
    Connection con;

    public int loginValidation(String user, String pass) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "select count(*) from admin where usernmae=? and password=?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, user);
        pstm.setString(2, pass);
        ResultSet rs = pstm.executeQuery();
        int state = 0;
        if (rs.next()) {
            state = rs.getInt(1);
        }
        return state;
    }
}
