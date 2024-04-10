/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Repository;

import Com.FormModel.EmployeeDetailVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileRepo {
    
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    
    public ResultSet fetchProfileByIdRepo(String userId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT EMPLOYEE_FULLNAME,BIRTH_DATE,GENDER,PHONE_NO,EMAIL,ADDRESS,STATE,CITY,PINCODE,JOINING_DATE,USERID,DEPARTMENT,STATUS FROM SA_MANAGEMENT.EMPLOYEE_DETAILS WHERE USERID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, userId);
        ResultSet emp =  pstm.executeQuery();
        return emp ;
    }

    

    
    public int updateProfileRepo(EmployeeDetailVO employeeDetailVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.EMPLOYEE_DETAILS SET EMPLOYEE_FULLNAME=?,BIRTH_DATE=?,GENDER=?,PHONE_NO=?,EMAIL=?,ADDRESS=?,STATE=?,CITY=?,PINCODE=? WHERE USERID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, employeeDetailVO.getEmpFullName());
        pstm.setString(2, employeeDetailVO.getBirthDate());
        pstm.setString(3, employeeDetailVO.getGender());
        pstm.setString(4, employeeDetailVO.getPhoneNo());
        pstm.setString(5, employeeDetailVO.getEmail());
        pstm.setString(6, employeeDetailVO.getAddress());
        pstm.setString(7, employeeDetailVO.getState());
        pstm.setString(8, employeeDetailVO.getCity());
        pstm.setString(9, employeeDetailVO.getPincode());
        pstm.setString(10, employeeDetailVO.getUserId());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public int changePasswordRepo(String userId,String oldPass,String newPass) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.EMPLOYEE_DETAILS SET PASSWORD = ? WHERE USERID = ? AND PASSWORD = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1,newPass);
        pstm.setString(2,userId);
        pstm.setString(3,oldPass);
        int status = pstm.executeUpdate();
        return status ;
    }    

}
