package Com.Repository;

import Com.FormModel.CustomerDetails;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerProcessRepository {

    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    ResultSet rs;
    Connection con;
    String query;

    public int insertCustomerRepo(CustomerDetails CustomDet) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "insert into CUSTOMER_MST(CUSTOMER_NAME,ADDRESS,STATE,CITY,PINCODE,\n"
                + "PAN,REGISTRATION_TYPE,MOBILE_NO,CUSTOMER_MAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE) \n"
                + "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, CustomDet.getCutomerName());
        pstm.setString(2, CustomDet.getAddress());
        pstm.setString(3, CustomDet.getState());
        pstm.setString(4, CustomDet.getCity());
        pstm.setInt(5, CustomDet.getPin());
        pstm.setString(6, CustomDet.getPanNo());
        pstm.setString(7, CustomDet.getRegisterType());
        pstm.setString(8, CustomDet.getMobile());
        pstm.setString(9, CustomDet.getMail());
        pstm.setString(10, CustomDet.getGstNo());
        pstm.setString(11, CustomDet.getBankName());
        pstm.setString(12, CustomDet.getBankNo());
        pstm.setString(13, CustomDet.getIfscCode());
        int status = pstm.executeUpdate();
        return status;
    }

    public ResultSet fetchCustomerByIdRepo(int customerId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "SELECT CUSTOMER_ID,CUSTOMER_NAME,ADDRESS,STATE,CITY,PINCODE,PAN,REGISTRATION_TYPE,MOBILE_NO,CUSTOMER_MAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE FROM SA_MANAGEMENT.CUSTOMER_MST WHERE CUSTOMER_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, customerId);
        ResultSet customer = pstm.executeQuery();
        return customer;
    }

    public ResultSet fetchAllCustomerRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "SELECT CUSTOMER_ID,CUSTOMER_NAME,STATE,REGISTRATION_TYPE,MOBILE_NO,GST_NO FROM SA_MANAGEMENT.CUSTOMER_MST";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet customer = pstm.executeQuery();
        System.out.println("The Cusotmer in repository is ---------->" + customer);
        return customer;
    }

    public int updateCustomerRepo(CustomerDetails customerVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "UPDATE CUSTOMER_MST SET CUSTOMER_NAME = ?,ADDRESS = ?,"
                + "STATE = ?,CITY = ?,PINCODE = ?,PAN = ?,REGISTRATION_TYPE = ?,"
                + "MOBILE_NO = ?,CUSTOMER_MAIL = ? ,GST_NO = ?,NAME_ON_PASSBOOK = ?,"
                + "BANK_AC_NO = ?,IFSC_CODE = ? WHERE CUSTOMER_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, customerVO.getCutomerName());
        pstm.setString(2, customerVO.getAddress());
        pstm.setString(3, customerVO.getState());
        pstm.setString(4, customerVO.getCity());
        pstm.setInt(5, customerVO.getPin());
        pstm.setString(6, customerVO.getPanNo());
        pstm.setString(7, customerVO.getRegisterType());
        pstm.setString(8, customerVO.getMobile());
        pstm.setString(9, customerVO.getMail());
        pstm.setString(10, customerVO.getGstNo());
        pstm.setString(11, customerVO.getBankName());
        pstm.setString(12, customerVO.getBankNo());
        pstm.setString(13, customerVO.getIfscCode());
        pstm.setInt(14, customerVO.getCustomerId());
        int status = pstm.executeUpdate();
        System.out.println("This is Update Fuction --->" + status);
        return status;
    }

    public int deleteCustomerRepo(int customerId) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(path, username, password);
        query = "DELETE FROM SA_MANAGEMENT.CUSTOMER_MST WHERE CUSTOMER_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, customerId);
        int status = pstm.executeUpdate();
        return status;
    }
}
