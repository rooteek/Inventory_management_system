/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.FormModel.SalesVO;
import Com.Repository.SalesRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SalesService {
    SalesRepo salesRepo = new SalesRepo();
    
    
    public int insertSalesService(SalesVO salesVO) throws SQLException, ClassNotFoundException {
        return salesRepo.insertSalesRepo(salesVO);
    }

    
    public ResultSet fetchSalesByIdService(Integer invoicenNo) throws ClassNotFoundException, SQLException {
        return salesRepo.fetchSalesByIdRepo(invoicenNo);
    }

    
    public ResultSet fetchAllSalesService() throws ClassNotFoundException, SQLException {
        return salesRepo.fetchAllSalesRepo();
    }

    
    public int updateSalesService(SalesVO salesVO) throws SQLException, ClassNotFoundException {
        return salesRepo.updateSalesRepo(salesVO);
    }

    
    public int deleteSalesService(Integer invoiceNo) throws SQLException, ClassNotFoundException {
        return salesRepo.deleteSalesRepo(invoiceNo);
    }
}
