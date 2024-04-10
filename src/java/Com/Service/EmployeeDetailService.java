/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.FormModel.EmployeeDetailVO;
import Com.Repository.EmployeeDetailRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class EmployeeDetailService {
    
    EmployeeDetailRepo empDetailRepo = new EmployeeDetailRepo();
    
    
    public int insertEmployeeDetailService(EmployeeDetailVO employeeDetailVO) throws SQLException, ClassNotFoundException {
        return empDetailRepo.insertEmployeeDetailRepo(employeeDetailVO);
    }

    
    public ResultSet fetchEmployeeDetailByIdService(String userId) throws ClassNotFoundException, SQLException {
        return empDetailRepo.fetchEmployeeDetailByIdRepo(userId);
    }

    
    public ResultSet fetchAllEmployeeDetailService() throws ClassNotFoundException, SQLException {
        return empDetailRepo.fetchAllEmployeeDetailRepo();
    }

    
    public int updateEmployeeDetailService(EmployeeDetailVO employeeDetailVO) throws SQLException, ClassNotFoundException {
        return empDetailRepo.updateEmployeeDetailRepo(employeeDetailVO);
    }

    
    public int deleteEmployeeDetailService(String userId) throws SQLException, ClassNotFoundException {
        return empDetailRepo.deleteEmployeeDetailRepo(userId);
    }
    
    
    public ResultSet loginValidationService(String userId,String lPassword,String department) throws SQLException, ClassNotFoundException {
        return empDetailRepo.loginValidation(userId, lPassword, department);
    }
    

}
