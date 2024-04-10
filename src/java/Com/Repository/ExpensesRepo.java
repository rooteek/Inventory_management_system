
package Com.Repository;

import Com.FormModel.ExpensesVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpensesRepo {
    
    String path = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    String username = "root";
    String password = "root";
    Connection con;
    String query;
    
    
    public int insertExpensesRepo(ExpensesVO expensesVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="INSERT INTO SA_MANAGEMENT.EXPENSES(INVOICE_NO,EXPENSE_NAME,BILL_DATE,GST,FREIGHT,DISCOUNT,NET_AMT,TOTAL_AMT) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, expensesVO.getInvoiceNo());
        pstm.setString(2, expensesVO.getExpenseName());
        pstm.setString(3, expensesVO.getBillDate());
        pstm.setInt(4, expensesVO.getGst());
        pstm.setInt(5, expensesVO.getFreight());
        pstm.setInt(6, expensesVO.getDiscount());
        pstm.setInt(7, expensesVO.getNetAmt());
        pstm.setInt(8, expensesVO.getTotalAmt());
        int status = pstm.executeUpdate();
        return status ;
    }

    
    public ResultSet fetchExpensesByIdRepo(Integer invoiceNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT INVOICE_NO,EXPENSE_NAME,BILL_DATE,GST,FREIGHT,DISCOUNT,NET_AMT,TOTAL_AMT FROM SA_MANAGEMENT.EXPENSES WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, invoiceNo);
        ResultSet expenses =  pstm.executeQuery();
        return expenses ;
    }

    
    public ResultSet fetchAllExpensesRepo() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="SELECT INVOICE_NO,EXPENSE_NAME,BILL_DATE,TOTAL_AMT FROM SA_MANAGEMENT.EXPENSES";
        PreparedStatement pstm = con.prepareStatement(query);
        ResultSet expenses =  pstm.executeQuery();
        return expenses ;
    }

    
    public int updateExpensesRepo(ExpensesVO expensesVO) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(path, username, password);
        query="UPDATE SA_MANAGEMENT.EXPENSES SET EXPENSE_NAME = ?,BILL_DATE = ?,GST = ?,FREIGHT = ?,DISCOUNT = ?,NET_AMT = ?,TOTAL_AMT = ? WHERE INVOICE_NO = ?";
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, expensesVO.getExpenseName());
        pstm.setString(2, expensesVO.getBillDate());
        pstm.setInt(3, expensesVO.getGst());
        pstm.setInt(4, expensesVO.getFreight());
        pstm.setInt(5, expensesVO.getDiscount());
        pstm.setInt(6, expensesVO.getNetAmt());
        pstm.setInt(7, expensesVO.getTotalAmt());
        pstm.setInt(8, expensesVO.getInvoiceNo());
        int status = pstm.executeUpdate();
        return status ;  
    }

    
    public int deleteExpensesRepo(Integer invoiceNo) throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection(path, username, password);
       query="DELETE FROM SA_MANAGEMENT.EXPENSES WHERE INVOICE_NO = ?";
       PreparedStatement pstm = con.prepareStatement(query);
       pstm.setInt(1, invoiceNo);
       int status =  pstm.executeUpdate();
       return status ;
    }

}
