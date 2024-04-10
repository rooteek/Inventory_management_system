package Com.Controller;

import Com.FormModel.CustomerDetails;
import Com.Service.CustomerProcessService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerProcessController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        CustomerProcessService customerProcessService = new CustomerProcessService();
        CustomerDetails customerDetails = new CustomerDetails();
        RequestDispatcher rd;
        ResultSet rs;

        String process = request.getParameter("process");
        String cutomerName = request.getParameter("cutomerName");
        String mobile = request.getParameter("mobile");
        String mail = request.getParameter("mail");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pin = request.getParameter("pin");
        String bankName = request.getParameter("bankName");
        String bankNo = request.getParameter("bankNo");
        String ifscCode = request.getParameter("ifscCode");
        String panNo = request.getParameter("panNo");
        String registerType = request.getParameter("registerType");
        String gstNo = request.getParameter("gstNo");
        try {
            if (process.equals("addCustomer")) {
                customerDetails.setCutomerName(cutomerName);
                customerDetails.setAddress(address);
                customerDetails.setState(state);
                customerDetails.setCity(city);
                customerDetails.setPin(Integer.parseInt(pin));
                customerDetails.setPanNo(panNo);
                customerDetails.setRegisterType(registerType);
                customerDetails.setMobile(mobile);
                customerDetails.setMail(mail);
                customerDetails.setGstNo(gstNo);
                customerDetails.setBankName(bankName);
                customerDetails.setBankNo(bankNo);
                customerDetails.setIfscCode(ifscCode);
                int status = customerProcessService.insertCustomerRepo(customerDetails);
                out.println(status);
            }
            if (process.equals("customer")) {
                request.setAttribute("process", process);
                rs = customerProcessService.fetchAllCustomerRepo();
                request.setAttribute("resultSet", rs);
                rd = request.getRequestDispatcher("customer.jsp");
                rd.forward(request, response);
            }
            if (process.equals("getCustomerData")) {
                int uid = Integer.parseInt(request.getParameter("uid"));
                rs = customerProcessService.fetchCustomerByIdRepo(uid);
                request.setAttribute("process", process);
                request.setAttribute("resultS", rs);
                System.out.println("The rs value -----------> " + rs);
                System.out.println("The uid value -----------> " + uid);
                rd = request.getRequestDispatcher("customerUpdatePage.jsp");
                rd.forward(request, response);
            }
            if(process.equals("updateCustomer")){
                int custoemrID= Integer.parseInt(request.getParameter("customerId"));
                customerDetails.setCustomerId(custoemrID);
                customerDetails.setCutomerName(cutomerName);
                customerDetails.setAddress(address);
                customerDetails.setState(state);
                customerDetails.setCity(city);
                customerDetails.setPin(Integer.parseInt(pin));
                customerDetails.setPanNo(panNo);
                customerDetails.setRegisterType(registerType);
                customerDetails.setMobile(mobile);
                customerDetails.setMail(mail);
                customerDetails.setGstNo(gstNo);
                customerDetails.setBankName(bankName);
                customerDetails.setBankNo(bankNo);
                customerDetails.setIfscCode(ifscCode);
                int status=customerProcessService.updateCustomerRepo(customerDetails);
                out.print(status);
            }
            if(process.equals("deleteCustomerData")){
                int did = Integer.parseInt(request.getParameter("did"));
                int status=customerProcessService.deleteCustomerRepo(did);
                out.print(status);
            }

        } catch (Exception ex) {
            System.out.println("The Error is -------------->" + ex.getMessage());
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
