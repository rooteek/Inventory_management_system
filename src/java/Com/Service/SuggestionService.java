/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.Repository.SuggestionRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class SuggestionService {
      SuggestionRepo suggestionRepo = new SuggestionRepo();
    
    
    
    public ResultSet searchCustomerNameService(String name) throws SQLException, ClassNotFoundException {
        return suggestionRepo.searchCustomerName(name);
    }

    
    public ResultSet searchProductNameService(String name) throws SQLException, ClassNotFoundException {
        return suggestionRepo.searchProductName(name);
    }
    
    
    public ResultSet searchVendorNameService(String name) throws SQLException, ClassNotFoundException {
        return suggestionRepo.searchVendorName(name);
    }

    
    public ResultSet searchStateNameService() throws SQLException, ClassNotFoundException {
       return suggestionRepo.searchStateName();
    }

    
    public ResultSet searchCityNameService(String state) throws SQLException, ClassNotFoundException {
        return suggestionRepo.searchCityName(state);
    }
    
    public ResultSet searchCategoryService() throws SQLException, ClassNotFoundException {
        return suggestionRepo.searchCategoryName();
    }
}
