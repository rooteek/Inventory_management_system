/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import Com.FormModel.EmployeeDetailVO;
import Com.Service.EmployeeDetailService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class EmployeeController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EmployeeDetailVO employeeVO = new EmployeeDetailVO();
        EmployeeDetailService employeeService = new EmployeeDetailService();
        PrintWriter out = response.getWriter();

        String empFullName = request.getParameter("empFullName");
        String birthDate = request.getParameter("birthDate");
        String gender = request.getParameter("gender");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String joiningDate = request.getParameter("joiningDate");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String department = request.getParameter("department");
        String activeStatus = request.getParameter("status");
        
        HttpSession session = request.getSession();
        String process = request.getParameter("process");
        ResultSet rs ;
        RequestDispatcher rd;
        try {
            if(process.equals("addFormEmployee")){
                request.setAttribute("process",process);
                rd = request.getRequestDispatcher("employeeJsp.jsp");
                rd.forward(request, response);                                      
            }
            if(process.equals("addEmployee")){
                
                employeeVO.setEmpFullName(empFullName);
                employeeVO.setBirthDate(birthDate);
                employeeVO.setGender(gender);
                employeeVO.setPhoneNo(phoneNo);
                employeeVO.setEmail(email);
                employeeVO.setAddress(address);
                employeeVO.setState(state);
                employeeVO.setCity(city);
                employeeVO.setPincode(pincode);
                employeeVO.setJoiningDate(joiningDate);
                employeeVO.setUserId(userId);
                employeeVO.setPassword(password);
                employeeVO.setDepartment(department);
                employeeVO.setStatus(activeStatus);
                int status = employeeService.insertEmployeeDetailService(employeeVO);
                out.println(status);
            }
            if(process.equals("viewEmployee")){
                rs = employeeService.fetchAllEmployeeDetailService();
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("employeeJsp.jsp");
                rd.forward(request, response); 
            }
            
            if(process.equals("searchEmployee")){
                rs = employeeService.fetchEmployeeDetailByIdService(userId);
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("employeeJsp.jsp");
                rd.forward(request, response); 
            }
            
            if(process.equals("viewIndividualEmp")){
                rs = employeeService.fetchEmployeeDetailByIdService(userId);
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("employeeJsp.jsp");
                rd.forward(request, response); 
            }
            if(process.equals("deleteEmployeeById")){
                int status = employeeService.deleteEmployeeDetailService(userId);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("employeeJsp.jsp");
                rd.forward(request, response);
                out.println(status);
            }
            if(process.equals("updateEmployee")){
                employeeVO.setEmpFullName(empFullName);
                employeeVO.setBirthDate(birthDate);
                employeeVO.setGender(gender);
                employeeVO.setPhoneNo(phoneNo);
                employeeVO.setEmail(email);
                employeeVO.setAddress(address);
                employeeVO.setState(state);
                employeeVO.setCity(city);
                employeeVO.setPincode(pincode);
                employeeVO.setJoiningDate(joiningDate);
                employeeVO.setUserId(userId);                
                employeeVO.setDepartment(department);
                employeeVO.setStatus(activeStatus);
                int status = employeeService.updateEmployeeDetailService(employeeVO);
                rd = request.getRequestDispatcher("employeeJsp.jsp");
                rd.forward(request, response);
                out.println(status);
            }
            if(process.equals("loginValidation")){
                employeeVO.setUserId(userId);
                employeeVO.setPassword(password);
                employeeVO.setDepartment(department);
                rs = employeeService.loginValidationService(userId, password, department);               
                while(rs.next()){
                   out.println (rs.getString(1));
                }
                session.setAttribute("userId", userId);                
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
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
