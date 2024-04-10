
package Com.Controller;

import Com.FormModel.EmployeeDetailVO;
import Com.Service.ProfileServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileController1 extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EmployeeDetailVO employeeVO = new EmployeeDetailVO();
        ProfileServiceImpl profileService = new ProfileServiceImpl();
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
        String newPswd = request.getParameter("newPswd");
        
        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("userId");
        String process = request.getParameter("process");
        ResultSet rs ;
        RequestDispatcher rd;
        try {
            
            
            if(process.equals("viewProfile") || process.equals("updateFormProfile")){
                rs = profileService.fetchProfileByIdService(user_id);
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profileJsp.jsp");
                rd.forward(request, response); 
                
            }
             
            if(process.equals("updateProfile")){
                employeeVO.setEmpFullName(empFullName);
                employeeVO.setBirthDate(birthDate);
                employeeVO.setGender(gender);
                employeeVO.setPhoneNo(phoneNo);
                employeeVO.setEmail(email);
                employeeVO.setAddress(address);
                employeeVO.setState(state);
                employeeVO.setCity(city);
                employeeVO.setPincode(pincode);    
                employeeVO.setUserId(user_id);
                int status = profileService.updateProfileService(employeeVO);
                rd = request.getRequestDispatcher("profileJsp.jsp");
                rd.forward(request, response);
                out.println(status);
            }
            
            if(process.equals("changePasswordForm")){
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profileJsp.jsp");
                rd.forward(request, response); 
            }
            
            if(process.equals("changePassword")){
                System.out.println(user_id);   
                System.out.println(password);   
                System.out.println(newPswd);   
                int status = profileService.changePasswordService(user_id, password, newPswd);                
                System.out.println(status);  
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("profileJsp.jsp");
                rd.forward(request, response);                
                 
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
