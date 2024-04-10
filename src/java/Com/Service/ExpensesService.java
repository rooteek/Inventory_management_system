
package Com.Service;
import Com.FormModel.ExpensesVO;
import java.sql.ResultSet;
import java.sql.SQLException;


import Com.Repository.ExpensesRepo;

public class ExpensesService {
    
    ExpensesRepo expensesRepoImpl = new ExpensesRepo();

    
    public int insertExpensesService(ExpensesVO expensesVO) throws SQLException, ClassNotFoundException {
        return expensesRepoImpl.insertExpensesRepo(expensesVO);
    }

    
    public ResultSet fetchExpensesByIdService(Integer invoicenNo) throws ClassNotFoundException, SQLException {
        return expensesRepoImpl.fetchExpensesByIdRepo(invoicenNo);
    }

    
    public ResultSet fetchAllExpensesService() throws ClassNotFoundException, SQLException {
       return expensesRepoImpl.fetchAllExpensesRepo();
    }

    
    public int updateExpensesService(ExpensesVO expensesVO) throws SQLException, ClassNotFoundException {
        return expensesRepoImpl.updateExpensesRepo(expensesVO);
    }

    
    public int deleteExpensesService(Integer invoiceNo) throws SQLException, ClassNotFoundException {
        return expensesRepoImpl.deleteExpensesRepo(invoiceNo);
    }
    
}
