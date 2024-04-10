/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.Repository.queryRepository;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessService {

    queryRepository queryRepo = new queryRepository();

    public ResultSet showData() throws SQLException, ClassNotFoundException {
        return queryRepo.showData();
    }

    public int deleteData(String id) throws SQLException {
        return queryRepo.deleteData(id);
    }

    public int insertData(String name, String email, String pass, String mobile, String address) throws SQLException,ClassNotFoundException {
        return queryRepo.insertData(name, email, pass, mobile, address);
    }

}
