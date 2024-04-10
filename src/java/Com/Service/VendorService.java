
package Com.Service;

import Com.FormModel.VendorVO;
import Com.Repository.VendorRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendorService {
    
    VendorRepo vendorRepo = new VendorRepo();
    
    
    public int insertVendorService(VendorVO vendorVO) throws SQLException, ClassNotFoundException {
        return vendorRepo.insertVendorRepo(vendorVO);
    }

    
    public ResultSet fetchVendorByIdService(Integer vendorId) throws ClassNotFoundException, SQLException {
       return vendorRepo.fetchVendorByIdRepo(vendorId);
    }

    
    public ResultSet fetchAllVendorService() throws ClassNotFoundException, SQLException {
        return vendorRepo.fetchAllVendorRepo();
    }

    
    public int updateVendorService(VendorVO vendorVO) throws SQLException, ClassNotFoundException {
        return vendorRepo.updateVendorRepo(vendorVO);
    }

    
    public int deleteVendorService(Integer vendorId) throws SQLException, ClassNotFoundException {
        return vendorRepo.deleteVendorRepo(vendorId);
    }
    
}
