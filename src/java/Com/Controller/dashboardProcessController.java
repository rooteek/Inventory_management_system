/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import Com.Service.DashboardProcessServi;
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
public class dashboardProcessController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        DashboardProcessServi dashboardProcessServi = new DashboardProcessServi();
                
        PrintWriter out = response.getWriter();
        RequestDispatcher rd;
        ResultSet rs,ro,rc,rp,rv;

        try {
            String process = request.getParameter("process");
            if (process.equals("dashboard")) {
                rc= dashboardProcessServi.fetchAllCustomerRepo();
                ro=dashboardProcessServi.fetchAllSalesService();
                rp=dashboardProcessServi.fetchAllPurchaseRepo();
                rv=dashboardProcessServi.fetchAllVendorRepo();
                request.setAttribute("resultSet", rc);
                request.setAttribute("recentOrder", ro);
                request.setAttribute("resultPurchase", rp);
                request.setAttribute("resultVendor", rv);
                rd = request.getRequestDispatcher("dashboard.jsp");
                rd.forward(request, response);
            }
            if (process.equals("item")) {
//                request.setAttribute("itemActivity", itemActivity);
//                request.setAttribute("parameterName", itemActivity);
//                out.print("The parameterNAme is ------->" + itemActivity);
                rd = request.getRequestDispatcher("item.jsp");
                rd.forward(request, response);
            }
            if (process.equals("ledger")) {
                rd = request.getRequestDispatcher("ledger.jsp");
                rd.forward(request, response);
            }
            if (process.equals("saleOrder")) {
                rd = request.getRequestDispatcher("saleOrder.jsp");
                rd.forward(request, response);
            }
            if (process.equals("color")) {
                rd = request.getRequestDispatcher("colorPage.jsp");
                rd.forward(request, response);
            }
            if (process.equals("itemCategory")) {
                rd = request.getRequestDispatcher("itemCategory.jsp");
                rd.forward(request, response);
            }
            if (process.equals("saleBill")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("salesBill.jsp");
                rd.forward(request, response);
            }
            if (process.equals("purchaseBill")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("billGenerator.jsp");
                rd.forward(request, response);
            }
            if (process.equals("addEmployee")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("employeeAdd.jsp");
                rd.forward(request, response);
            }
            if (process.equals("profilePage")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profilePage.jsp");
                rd.forward(request, response);
            }
            if (process.equals("purchaseDetails")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("purchaseDetails.jsp");
                rd.forward(request, response);
            }
            if (process.equals("saleDetails")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("saleDetails.jsp");
                rd.forward(request, response);
            }
            if (process.equals("setting")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("setting.html");
                rd.forward(request, response);
            }
            if (process.equals("updateCutomer")) {
                String itemActivity = request.getParameter("itemActivity");
                request.setAttribute("itemActivity", itemActivity);
                System.out.println("The parameterNAme is ------->" + itemActivity);
                rd = request.getRequestDispatcher("addCustomerPage.jsp");
                rd.forward(request, response);
            }
//            if (process.equals("vendor")) {
//                request.setAttribute("process", process);
//                rd = request.getRequestDispatcher("vendor.jsp");
//                rd.forward(request, response);
//            }
            if (process.equals("profilePage")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profilePage.jsp");
                rd.forward(request, response);
            }
            if (process.equals("profileDetails")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profilePageDetails.jsp");
                rd.forward(request, response);
            }
            if (process.equals("profileDetailsEdit")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profilePageDetails.jsp");
                rd.forward(request, response);
            }
            if (process.equals("profilePasswordChange")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profilePageDetails.jsp");
                rd.forward(request, response);
            }
            if (process.equals("profileNotification")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profilePageDetails.jsp");
                rd.forward(request, response);
            }
            if (process.equals("stockPage")) {
                rs=dashboardProcessServi.fetchStockRepo();
                request.setAttribute("stockView", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("stockPage.jsp");
                rd.forward(request, response);
            }
            

        } catch (Exception ex) {
            System.out.println("The Error is " + ex);

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
