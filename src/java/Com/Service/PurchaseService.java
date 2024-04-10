
package Com.Service;

import Com.FormModel.PurchaseVO;
import Com.Repository.PurchaseRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseService {

    PurchaseRepo purchaseRepo = new PurchaseRepo();
    
    
    public int insertPurchaseService(PurchaseVO purchaseVO) throws SQLException, ClassNotFoundException {
        return purchaseRepo.insertPurchaseRepo(purchaseVO);
    }

    
    public ResultSet fetchPurchaseByIdService(Integer invoicenNo) throws ClassNotFoundException, SQLException {
        return purchaseRepo.fetchPurchaseByIdRepo(invoicenNo);
    }

    
    public ResultSet fetchAllPurchaseService() throws ClassNotFoundException, SQLException {
        return purchaseRepo.fetchAllPurchaseRepo();
    }

    
    public int updatePurchaseService(PurchaseVO purchaseVO) throws SQLException, ClassNotFoundException {
        return purchaseRepo.updatePurchaseRepo(purchaseVO);
    }

    
    public int deletePurchaseService(Integer invoiceNo) throws SQLException, ClassNotFoundException {
        return purchaseRepo.deletePurchaseRepo(invoiceNo);
    }
    
}
