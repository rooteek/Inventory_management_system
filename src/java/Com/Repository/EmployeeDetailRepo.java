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


public class EmployeeDetailRepo {
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
        public int insertEmployeeDetailRepo(EmployeeDetailVO employeeDetailVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.EMPLOYEE_DETAILS(EMPLOYEE_FULLNAME,BIRTH_DATE,GENDER,PHONE_NO,EMAIL,ADDRESS,STATE,CITY,PINCODE,JOINING_DATE,USERID,PASSWORD,DEPARTMENT,STATUS) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        pstm.setString(10, employeeDetailVO.getJoiningDate());
        pstm.setString(11, employeeDetailVO.getUserId());
        pstm.setString(12, employeeDetailVO.getPassword());
        pstm.setString(13, employeeDetailVO.getDepartment());
        pstm.setString(14, employeeDetailVO.getStatus());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public ResultSet fetchEmployeeDetailByIdRepo(String userId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT EMPLOYEE_FULLNAME,BIRTH_DATE,GENDER,PHONE_NO,EMAIL,ADDRESS,STATE,CITY,PINCODE,JOINING_DATE,USERID,DEPARTMENT,STATUS FROM SA_MANAGEMENT.EMPLOYEE_DETAILS WHERE USERID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, userId);
        ResultSet emp =  pstm.executeQuery();
        return emp ;
    }

    
    public ResultSet fetchAllEmployeeDetailRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT EMPLOYEE_FULLNAME,USERID,DEPARTMENT,PHONE_NO,EMAIL FROM SA_MANAGEMENT.EMPLOYEE_DETAILS ";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet emp =  pstm.executeQuery();
        return emp ;
    }

    
    public int updateEmployeeDetailRepo(EmployeeDetailVO employeeDetailVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.EMPLOYEE_DETAILS SET EMPLOYEE_FULLNAME=?,BIRTH_DATE=?,GENDER=?,PHONE_NO=?,EMAIL=?,ADDRESS=?,STATE=?,CITY=?,PINCODE=?,JOINING_DATE=?,DEPARTMENT=?,STATUS=? WHERE USERID = ?";
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
        pstm.setString(10, employeeDetailVO.getJoiningDate());        
        pstm.setString(11, employeeDetailVO.getDepartment());
        pstm.setString(12, employeeDetailVO.getStatus()); 
        pstm.setString(13, employeeDetailVO.getUserId());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public int deleteEmployeeDetailRepo(String userId) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.EMPLOYEE_DETAILS WHERE USERID = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setString(1, userId);
       int status =  pstm.executeUpdate();
       return status ;
    }
    
    
    public ResultSet loginValidation(String userId,String lPassword,String department) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="SELECT STATUS FROM SA_MANAGEMENT.EMPLOYEE_DETAILS WHERE USERID = ? and PASSWORD = ? and DEPARTMENT = ? ";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setString(1, userId);
       pstm.setString(2, lPassword);
       pstm.setString(3, department);
       ResultSet rs =  pstm.executeQuery();
       return rs;
    }
    
}
