/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.Repository.DashboardProcessRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardProcessServi {

    DashboardProcessRepo dashboardProcessRepo = new DashboardProcessRepo();

    public ResultSet fetchAllCustomerRepo() throws ClassNotFoundException, SQLException {
        return dashboardProcessRepo.fetchAllCustomerRepo();
    }

    public ResultSet fetchAllSalesService() throws ClassNotFoundException, SQLException {
        return dashboardProcessRepo.fetchAllSalesRepo();
    }

    public ResultSet fetchAllPurchaseRepo() throws ClassNotFoundException, SQLException {
        return dashboardProcessRepo.fetchAllPurchaseRepo();
    }

    public ResultSet fetchAllVendorRepo() throws ClassNotFoundException, SQLException {
        return dashboardProcessRepo.fetchAllVendorRepo();
    }

    public ResultSet fetchStockRepo() throws ClassNotFoundException, SQLException {
        return dashboardProcessRepo.fetchStockRepo();

    }
}
