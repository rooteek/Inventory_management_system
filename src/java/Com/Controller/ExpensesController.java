/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import Com.FormModel.ExpensesVO;
import Com.FormModel.ProductExpensesVO;
import Com.Service.ExpensesService;
import Com.Service.ProductExpensesService;
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
public class ExpensesController extends HttpServlet {

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ProductExpensesVO productExpensesVO = new ProductExpensesVO();
        ExpensesVO expensesVO = new ExpensesVO();
        ProductExpensesService productExpensesService = new ProductExpensesService();
        ExpensesService expensesService = new ExpensesService();
        
        String process = request.getParameter("process");
        String invoiceNo = request.getParameter("invoiceNo");
        String expenseName = request.getParameter("expenseName");
        String billDate = request.getParameter("billDate");
        String gst = request.getParameter("gst");
        String freight = request.getParameter("freight");
        String discount = request.getParameter("discount");
        String netAmt = request.getParameter("netAmt");
        String totalAmt = request.getParameter("totalAmt");
        
        
        String productName = request.getParameter("productNameArray");                
        String amount = request.getParameter("amountArray");
        
        ResultSet rs ;
        ResultSet rs1 ;
        RequestDispatcher rd;

        try {
            
           if(process.equals("addFormExpenses")){
                request.setAttribute("process",process);
                rd = request.getRequestDispatcher("expensesJsp.jsp");
                rd.forward(request, response);
            } 
           
           if(process.equals("deleteIndividualExpenses")){
                request.setAttribute("process",process);
                productExpensesService.deleteProductExpensesService(Integer.valueOf(invoiceNo));
                expensesService.deleteExpensesService(Integer.valueOf(invoiceNo));
              
                rd = request.getRequestDispatcher("expensesJsp.jsp");
                rd.forward(request, response);
            } 
           
           if(process.equals("addExpenses")){
               
               String[] productNameArray = productName.trim().split("-");
               String[] amountArray = amount.trim().split("-");
               
                request.setAttribute("process",process);
                expensesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                expensesVO.setExpenseName(expenseName);
                expensesVO.setBillDate(billDate);
                expensesVO.setFreight(Integer.valueOf(freight));
                expensesVO.setGst(Integer.valueOf(gst));
                expensesVO.setDiscount(Integer.valueOf(discount));
                expensesVO.setNetAmt(Integer.valueOf(netAmt));
                expensesVO.setTotalAmt(Integer.valueOf(totalAmt));
                int status = expensesService.insertExpensesService(expensesVO);
                if(status == 1){
                    for(int i = 0 ; i<productNameArray.length;i++){                        
                            
                        productExpensesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                        productExpensesVO.setProductName(productNameArray[i]);
                        productExpensesVO.setAmount(Integer.valueOf(amountArray[i]));
                        int pStatus = productExpensesService.insertProductExpensesService(productExpensesVO);
                        out.println(pStatus);
                    }
                
                }
                rd = request.getRequestDispatcher("expensesJsp.jsp");
                rd.forward(request, response);
            }
           
           
            if(process.equals("viewAllExpenses")){
               request.setAttribute("process",process);
               rs = expensesService.fetchAllExpensesService();
               request.setAttribute("resultSet", rs);
               rd = request.getRequestDispatcher("expensesDetails.jsp");
               rd.forward(request, response); 
            }
           
            if(process.equals("updateExpenses")){
               
               String[] productNameArray = productName.trim().split("-");
               String[] amountArray = amount.trim().split("-");
               
                request.setAttribute("process",process);
                expensesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                expensesVO.setExpenseName(expenseName);
                expensesVO.setBillDate(billDate);
                expensesVO.setFreight(Integer.valueOf(freight));
                expensesVO.setGst(Integer.valueOf(gst));
                expensesVO.setDiscount(Integer.valueOf(discount));
                expensesVO.setNetAmt(Integer.valueOf(netAmt));
                expensesVO.setTotalAmt(Integer.valueOf(totalAmt));
                int status = expensesService.updateExpensesService(expensesVO);
                int dStatus = productExpensesService.deleteProductExpensesService(Integer.valueOf(invoiceNo));
                if(status == 1){
                    for(int i = 0 ; i<productNameArray.length;i++){                        
                            
                        productExpensesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                        productExpensesVO.setProductName(productNameArray[i]);
                        productExpensesVO.setAmount(Integer.valueOf(amountArray[i]));
                        int pStatus = productExpensesService.insertProductExpensesService(productExpensesVO);
                        out.println(pStatus);
                    }
                
                }
                rd = request.getRequestDispatcher("expensesJsp.jsp");
                rd.forward(request, response);
            }
            
            if(process.equals("viewIndividualExpenses")){
               request.setAttribute("process",process);
               rs = expensesService.fetchExpensesByIdService(Integer.valueOf(invoiceNo));
               rs1 = productExpensesService.fetchAllProductExpensesService(Integer.valueOf(invoiceNo));
               request.setAttribute("resultSet", rs);
               request.setAttribute("productSet", rs1);
               rd = request.getRequestDispatcher("expensesJsp.jsp");
               rd.forward(request, response); 
            }
        }
        catch(Exception e){
            e.printStackTrace() ;
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
