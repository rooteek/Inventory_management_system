
package Com.Service;

import Com.FormModel.CustomerDetails;
import Com.Repository.CustomerProcessRepository;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerProcessService {
 CustomerProcessRepository customerProcessRespo = new CustomerProcessRepository();
     public int insertCustomerRepo(CustomerDetails CustomDet) throws SQLException, ClassNotFoundException {
        return customerProcessRespo.insertCustomerRepo(CustomDet);
     }
     public ResultSet fetchAllCustomerRepo() throws ClassNotFoundException, SQLException {
         return customerProcessRespo.fetchAllCustomerRepo();
     }
     public ResultSet fetchCustomerByIdRepo(int customerId) throws ClassNotFoundException, SQLException {
         return customerProcessRespo.fetchCustomerByIdRepo(customerId);
     }
      public int deleteCustomerRepo(int customerId) throws SQLException, ClassNotFoundException {
          return customerProcessRespo.deleteCustomerRepo(customerId);
      }
       public int updateCustomerRepo(CustomerDetails customerVO) throws SQLException, ClassNotFoundException {
           return customerProcessRespo.updateCustomerRepo(customerVO);
       }
}
