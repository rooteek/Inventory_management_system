/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import Com.FormModel.VendorVO;
import Com.Service.VendorService;
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
public class VendorController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        VendorVO vendorVO = new VendorVO();
        VendorService vendorService = new VendorService();
        String partyName = request.getParameter("partyName");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String pincode = request.getParameter("pincode");
        String pan = request.getParameter("pan");
        String registrationType = request.getParameter("registrationType");
        String mobileNo = request.getParameter("mobileNo");
        String email = request.getParameter("email");
        String gstNo = request.getParameter("gstNo");
        String nameOnPassbook = request.getParameter("nameOnPassbook");
        String bankAcNo = request.getParameter("bankAcNo");
        String ifscCode = request.getParameter("ifscCode");

        String process = request.getParameter("process");
        ResultSet rs;
        RequestDispatcher rd;
        try {
            if (process.equals("addFormVendor")) {
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("vendorJsp.jsp");
                rd.forward(request, response);
            }
            if (process.equals("viewVendor")) {
                rs = vendorService.fetchAllVendorService();
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("vendor.jsp");
                rd.forward(request, response);
            }
            if (process.equals("addVendor")) {
                vendorVO.setPartyName(partyName);
                vendorVO.setAddress(address);
                vendorVO.setState(state);
                vendorVO.setCity(city);
                vendorVO.setPincode(Integer.parseInt(pincode));
                vendorVO.setPan(pan);
                vendorVO.setRegistrationType(registrationType);
                vendorVO.setMobileNo(mobileNo);
                vendorVO.setEmail(email);
                vendorVO.setGstNo(gstNo);
                vendorVO.setNameOnPassbook(nameOnPassbook);
                vendorVO.setBankAcNo(bankAcNo);
                vendorVO.setIfscCode(ifscCode);
                int status = vendorService.insertVendorService(vendorVO);
                out.println(status);
            }
            if (process.equals("searchVendor")) {
                String vendorId = request.getParameter("vendorId");
                rs = vendorService.fetchVendorByIdService(Integer.valueOf(vendorId));
                request.setAttribute("resultSet", rs);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("ventorUpdatePage.jsp");
                rd.forward(request, response);
            }
            if (process.equals("deleteVendor")) {
                int vendorId = Integer.parseInt(request.getParameter("vendorId"));
                int status = vendorService.deleteVendorService(vendorId);
                request.setAttribute("process", process);
                rd = request.getRequestDispatcher("vendorJsp.jsp");
                rd.forward(request, response);
                out.println(status);
            }
            if (process.equals("updateVendor")) {
                String vendorId = request.getParameter("vendorId");
                vendorVO.setVendorId(Integer.parseInt(vendorId));
                vendorVO.setPartyName(partyName);
                vendorVO.setAddress(address);
                vendorVO.setState(state);
                vendorVO.setCity(city);
                vendorVO.setPincode(Integer.parseInt(pincode));
                vendorVO.setPan(pan);
                vendorVO.setRegistrationType(registrationType);
                vendorVO.setMobileNo(mobileNo);
                vendorVO.setEmail(email);
                vendorVO.setGstNo(gstNo);
                vendorVO.setNameOnPassbook(nameOnPassbook);
                vendorVO.setBankAcNo(bankAcNo);
                vendorVO.setIfscCode(ifscCode);
                int status = vendorService.updateVendorService(vendorVO);
                out.println(status);
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        } finally {
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
