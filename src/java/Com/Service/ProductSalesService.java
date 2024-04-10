/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.FormModel.ProductSalesVO;
import Com.Repository.ProductSalesRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ProductSalesService {
    ProductSalesRepo productSalesRepo = new ProductSalesRepo();
    
    
    public int insertProductSalesService(ProductSalesVO productSalesVO) throws SQLException, ClassNotFoundException {
        return productSalesRepo.insertProductSalesRepo(productSalesVO);
    }


    
    public ResultSet fetchAllProductSalesService(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        return productSalesRepo.fetchAllProductSalesRepo(invoiceNo);
    }

    
    public int deleteProductSalesService(Integer invoiceNo) throws SQLException, ClassNotFoundException {
        return productSalesRepo.deleteProductSalesRepo(invoiceNo);
    }
}
