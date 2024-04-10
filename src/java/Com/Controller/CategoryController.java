
package Com.Controller;

import Com.FormModel.CategoryVO;
import Com.Service.CategoryService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryController extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CategoryVO categoryVO = new CategoryVO();
        CategoryService categoryService = new CategoryService();
        String cateId = request.getParameter("cateId");
        String cateName = request.getParameter("cateName");
        String process = request.getParameter("process");
        ResultSet rs ;
        RequestDispatcher rd;
        PrintWriter out = response.getWriter();
        try {
            if(process.equals("addForm")){
                request.setAttribute("process",process);
                rd = request.getRequestDispatcher("categoryJsp.jsp");
                rd.forward(request, response);
            }
            if(process.equals("view")){
                rs= categoryService.fetchAllCategoryService();
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("itemCategory.jsp");
                rd.forward(request, response);
            }
            if(process.equals("add")){
               categoryVO.setCategoryId(Integer.parseInt(cateId));
               categoryVO.setCategoryName(cateName);
               int state= categoryService.insertCategoryService(categoryVO);
               out.println(state);
            }
            if(process.equals("search")){
                rs= categoryService.fetchCategoryByIdService(Integer.parseInt(cateId));
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("categoryJsp.jsp");
                rd.forward(request, response); 
            }
            if(process.equals("delete")){
                int state = categoryService.deleteCategoryService(Integer.parseInt(cateId));
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("categoryJsp.jsp");
                rd.forward(request, response);
                
            }
            if(process.equals("update")){
                categoryVO.setCategoryId(Integer.parseInt(cateId));
                categoryVO.setCategoryName(cateName);
                int state = categoryService.updateCategoryService(categoryVO);
                out.println(state);
            }
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
            
         finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
