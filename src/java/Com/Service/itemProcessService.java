/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.Repository.itemProcessRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
public class itemProcessService {
    itemProcessRepository ipr = new itemProcessRepository();
    public ResultSet showItemList() throws SQLException, ClassNotFoundException {
        return ipr.showItemList();
    }
    public int deleteData(String id) throws SQLException{
        return ipr.deleteData(id);
    }
}
