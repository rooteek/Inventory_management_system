package Com.Controller;

import Com.Service.ProcessService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;

public class ProcessController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ProcessService processServi = new ProcessService();

        String process = request.getParameter("process");
        RequestDispatcher rd;
        ResultSet rs;
        try {
            if (process.equals("insert")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("process.jsp");
                rd.forward(request, response);
                System.out.println(process);
            }
            if (process.equals("intData")) {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String mobile = request.getParameter("mobile");
                String address = request.getParameter("address");
                int state = processServi.insertData(name, email, password, mobile, address);
                out.print(state);
            }

            if (process.equals("view") || process.equals("update") || process.equals("delete")) {
                rs = processServi.showData();
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("process.jsp");
                rd.forward(request, response);
                System.out.println(process);
            }

            if (process.equals("dell")) {
                String id = request.getParameter("id");
                int status = processServi.deleteData(id);
                out.print(status);
            }

        } catch (Exception ex) {
            System.out.println("The Error is ----> " + ex);
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
