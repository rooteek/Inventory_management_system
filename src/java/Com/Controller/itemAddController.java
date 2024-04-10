/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class itemAddController extends HttpServlet {

    private String jdbcURL = "jdbc:mysql://localhost:3306/SA_MANAGEMENT";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String itemID = request.getParameter("itemId");
        String name = request.getParameter("itemName");
        String hsn = request.getParameter("itemHsn");
        String category = request.getParameter("itemCategory");
        String sale_price= request.getParameter("itemSalePrice");
        String purchae_price=request.getParameter("itemPurchasePrice");
        Part filePart = request.getPart("itemImage");
            try {
                Class.forName("com.mysql.jdbc.Driver");

                // Establish database connection
                Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

                // SQL query to insert image data into database
                String sql = "INSERT INTO SA_MANAGEMENT.PRODUCT_MST (PRODUCT_ID,PRODUCT_NAME,SALES_PRICE,PURCHASE_PRICE,CATEGORY_ID,HSN_CODE,IMAGE) VALUES (?,?,?,?,(SELECT CATEGORY_ID FROM SA_MANAGEMENT.CATEGORY_MST WHERE CATEGORY_NAME = ?),?,?)";
                PreparedStatement statement = conn.prepareStatement(sql);

                // Set parameters for the query
                InputStream inputStream = filePart.getInputStream();
                statement.setString(1, itemID);
                statement.setString(2, name);
                statement.setString(3, sale_price);
                statement.setString(4, purchae_price);
                statement.setString(5, category);
                statement.setString(6, hsn);
                statement.setBlob(7, inputStream);
                // Execute the query
                statement.executeUpdate();

                // Close resources
                statement.close();
                conn.close();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Data Inserted Successfully');");
                out.println("location='addItemPage.jsp';");
                out.println("</script>");
//                response.getWriter().println("Image uploaded successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("Error uploading image: " + e.getMessage());
                out.println("<script type=\"text/javascript\">");
//                out.println("alert('Please Fill all Details in the Box')");
                out.println("location='addItemPage.jsp';");
                out.println("</script>");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
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
