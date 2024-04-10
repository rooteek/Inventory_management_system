/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.FormModel.ProductExpensesVO;
import Com.Repository.ProductExpensesRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductExpensesService {
    
    ProductExpensesRepo productExpensesRepo = new ProductExpensesRepo();
    
    
    public int insertProductExpensesService(ProductExpensesVO productExpensesVO) throws SQLException, ClassNotFoundException {
        return productExpensesRepo.insertProductExpensesRepo(productExpensesVO);
    }


    
    public ResultSet fetchAllProductExpensesService(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        return productExpensesRepo.fetchAllProductExpensesRepo(invoiceNo);
    }

    
    public int deleteProductExpensesService(Integer invoiceNo) throws SQLException, ClassNotFoundException {
        return productExpensesRepo.deleteProductExpensesRepo(invoiceNo);
    }

}
