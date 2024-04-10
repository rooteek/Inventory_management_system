/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.Service;

import Com.FormModel.CategoryVO;
import Com.Repository.CategoryRepo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class CategoryService {
    CategoryRepo categoryRepo = new CategoryRepo();
    
    
    public int insertCategoryService(CategoryVO categoryVO) throws SQLException, ClassNotFoundException {
        return categoryRepo.insertCategoryRepo(categoryVO);
    }

    
    public ResultSet fetchCategoryByIdService(int categoryId) throws ClassNotFoundException, SQLException {
       return categoryRepo.fetchCategoryByIdRepo(categoryId);
    }

    
    public ResultSet fetchAllCategoryService() throws ClassNotFoundException, SQLException {
        return categoryRepo.fetchAllCategoryRepo();
    }

    
    public int updateCategoryService(CategoryVO categoryVO) throws SQLException, ClassNotFoundException {
        return categoryRepo.updateCategoryRepo(categoryVO);
    }

    
    public int deleteCategoryService(int categoryId) throws SQLException, ClassNotFoundException {
        return categoryRepo.deleteCategoryRepo(categoryId);
    }
    
}
