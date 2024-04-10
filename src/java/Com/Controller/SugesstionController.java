/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import Com.Service.SuggestionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class SugesstionController extends HttpServlet {

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        SuggestionService suggestionService = new SuggestionService();
        String process = request.getParameter("process");
        
        String cName = request.getParameter("cName");
        String pName = request.getParameter("pName");
        String vName = request.getParameter("vName");
        String stName = request.getParameter("stName");
        
        
        ResultSet rs ;
        RequestDispatcher rd;
        
        try {
            if (process.equals("suggestCustomer")) {
                rs = suggestionService.searchCustomerNameService(cName);
                request.setAttribute("process",process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("suggestionJsp.jsp");
                rd.forward(request, response);
            }
            
            if (process.equals("suggestVendor")) {
                rs = suggestionService.searchVendorNameService(vName);
                request.setAttribute("process",process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("suggestionJsp.jsp");
                rd.forward(request, response);
            }
            
            if (process.equals("suggestProduct")) {
                rs = suggestionService.searchProductNameService(pName);
                request.setAttribute("process",process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("suggestionJsp.jsp");
                rd.forward(request, response);
            }
            
            if (process.equals("suggestState")) {
                rs = suggestionService.searchStateNameService();
                request.setAttribute("process",process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("suggestionJsp.jsp");
                rd.forward(request, response);
            }
            
            if (process.equals("suggestCity")) {
                rs = suggestionService.searchCityNameService(stName);
                request.setAttribute("process",process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("suggestionJsp.jsp");
                rd.forward(request, response);
            }
            
            if (process.equals("suggestCategory")) {
                rs = suggestionService.searchCategoryService();
                request.setAttribute("process",process);
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("suggestionJsp.jsp");
                rd.forward(request, response);
            }
            
        }
        catch(Exception e){
            out.println(e.fillInStackTrace()) ;
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
