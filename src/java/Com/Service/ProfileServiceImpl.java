/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.FormModel.EmployeeDetailVO;
import Com.Repository.ProfileRepoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ProfileServiceImpl {


    ProfileRepoImpl profileRepo = new ProfileRepoImpl();

    
    public ResultSet fetchProfileByIdService(String userId) throws ClassNotFoundException, SQLException {
        return profileRepo.fetchProfileByIdRepo(userId);
    }

    
    public int updateProfileService(EmployeeDetailVO employeeDetailVO) throws SQLException, ClassNotFoundException {
        return profileRepo.updateProfileRepo(employeeDetailVO);
    }    

    
    public int changePasswordService(String userId, String oldPass, String newPass) throws ClassNotFoundException, SQLException {
        return profileRepo.changePasswordRepo(userId, oldPass, newPass);
    }    
}
