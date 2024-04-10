
package Com.Service;

import Com.FormModel.ProductPurchaseVO;
import Com.Repository.ProductPurchaseRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPurchaseService {
        ProductPurchaseRepo productPurchaseRepo = new ProductPurchaseRepo();
    
    
    public int insertProductPurchaseService(ProductPurchaseVO productPurchaseVO) throws SQLException, ClassNotFoundException {
        return productPurchaseRepo.insertProductPurchaseRepo(productPurchaseVO);
    }


    
    public ResultSet fetchAllProductPurchaseService(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        return productPurchaseRepo.fetchAllProductPurchaseRepo(invoiceNo);
    }

    
    public int deleteProductPurchaseService(Integer invoiceNo) throws SQLException, ClassNotFoundException {
        return productPurchaseRepo.deleteProductPurchaseRepo(invoiceNo);
    }

}
