
package Com.Repository;

import Com.FormModel.VendorVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorRepo {

 String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    public int insertVendorRepo(VendorVO vendorVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.VENDOR_MST(PARTY_NAME,ADDRESS,STATE,CITY,PINCODE,PAN,REGISTRATION_TYPE,MOBILE_NO,EMAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, vendorVO.getPartyName());
        pstm.setString(2, vendorVO.getAddress());
        pstm.setString(3, vendorVO.getState());
        pstm.setString(4, vendorVO.getCity());
        pstm.setInt(5, vendorVO.getPincode());
        pstm.setString(6, vendorVO.getPan());
        pstm.setString(7, vendorVO.getRegistrationType());
        pstm.setString(8, vendorVO.getMobileNo());
        pstm.setString(9, vendorVO.getEmail());
        pstm.setString(10, vendorVO.getGstNo());
        pstm.setString(11, vendorVO.getNameOnPassbook());
        pstm.setString(12, vendorVO.getBankAcNo());
        pstm.setString(13, vendorVO.getIfscCode());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public ResultSet fetchVendorByIdRepo(int vendorId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT VENDOR_ID,PARTY_NAME,ADDRESS,STATE,CITY,PINCODE,PAN,REGISTRATION_TYPE,MOBILE_NO,EMAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE FROM SA_MANAGEMENT.VENDOR_MST WHERE VENDOR_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, vendorId);
        ResultSet vendor =  pstm.executeQuery();
        return vendor ;
    }

    
    public ResultSet fetchAllVendorRepo() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="SELECT VENDOR_ID,PARTY_NAME,ADDRESS,STATE,CITY,PINCODE,PAN,REGISTRATION_TYPE,MOBILE_NO,EMAIL,GST_NO,NAME_ON_PASSBOOK,BANK_AC_NO,IFSC_CODE FROM SA_MANAGEMENT.VENDOR_MST";
       PreparedStatement pstm = con.prepareStatement(query);
       ResultSet vendor =  pstm.executeQuery();
       return vendor ;
    }

    
    public int updateVendorRepo(VendorVO vendorVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.VENDOR_MST SET PARTY_NAME = ?,ADDRESS = ?,STATE = ?,CITY = ?,PINCODE = ?,PAN = ?,REGISTRATION_TYPE = ?,MOBILE_NO = ?,EMAIL = ?,GST_NO = ?,NAME_ON_PASSBOOK = ?,BANK_AC_NO = ?,IFSC_CODE = ? WHERE VENDOR_ID = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, vendorVO.getPartyName());
        pstm.setString(2, vendorVO.getAddress());
        pstm.setString(3, vendorVO.getState());
        pstm.setString(4, vendorVO.getCity());
        pstm.setInt(5, vendorVO.getPincode());
        pstm.setString(6, vendorVO.getPan());
        pstm.setString(7, vendorVO.getRegistrationType());
        pstm.setString(8, vendorVO.getMobileNo());
        pstm.setString(9, vendorVO.getEmail());
        pstm.setString(10, vendorVO.getGstNo());
        pstm.setString(11, vendorVO.getNameOnPassbook());
        pstm.setString(12, vendorVO.getBankAcNo());
        pstm.setString(13, vendorVO.getIfscCode());
        pstm.setInt(14, vendorVO.getVendorId());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public int deleteVendorRepo(int vendorId) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.VENDOR_MST WHERE VENDOR_ID = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, vendorId);
       int status =  pstm.executeUpdate();
       return status ;
    }
       
}
