
package Com.Service;

import Com.FormModel.EmployeeDetailVO;
import Com.Repository.ProfileRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileService {
   
    ProfileRepo profileRepo = new ProfileRepo();

    
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
