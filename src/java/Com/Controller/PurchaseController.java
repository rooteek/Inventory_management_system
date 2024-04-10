/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Com.Controller;

import Com.FormModel.ProductPurchaseVO;
import Com.FormModel.PurchaseVO;
import Com.Service.ProductPurchaseService;
import Com.Service.PurchaseService;
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
public class PurchaseController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ProductPurchaseVO productPurchaseVO = new ProductPurchaseVO();
        PurchaseVO purchaseVO = new PurchaseVO();
        ProductPurchaseService productPurchaseService = new ProductPurchaseService();
        PurchaseService purchaseService = new PurchaseService();
        
        String process = request.getParameter("process");
        String invoiceNo = request.getParameter("invoiceNo");
        String vendorName = request.getParameter("vendorName");
        String billDate = request.getParameter("billDate");
        String gst = request.getParameter("gst");
        String freight = request.getParameter("freight");
        String discount = request.getParameter("discount");
        String netAmt = request.getParameter("netAmt");
        String totalAmt = request.getParameter("totalAmt");
        
        
        String productName = request.getParameter("productNameArray");                
        String quantity = request.getParameter("quantityArray");
        String unit = request.getParameter("unitArray");
        String rate = request.getParameter("rateArray");
        String amount = request.getParameter("amountArray");
        
        ResultSet rs ;
        ResultSet rs1 ;
        RequestDispatcher rd;

        try {
            
           if(process.equals("addFormPurchase")){
                request.setAttribute("process",process);
                rd = request.getRequestDispatcher("purchaseJsp.jsp");
                rd.forward(request, response);
            } 
           
           if(process.equals("deleteIndividualPurchase")){
                request.setAttribute("process",process);
                productPurchaseService.deleteProductPurchaseService(Integer.valueOf(invoiceNo));
                purchaseService.deletePurchaseService(Integer.valueOf(invoiceNo));
                
                rd = request.getRequestDispatcher("purchaseJsp.jsp");
                rd.forward(request, response);
            } 
           
           if(process.equals("addPurchase")){
               
               String[] productNameArray = productName.trim().split("-");
               String[] quantityArray = quantity.trim().split("-");
               String[] unitArray = unit.trim().split("-");
               String[] rateArray = rate.trim().split("-");
               String[] amountArray = amount.trim().split("-");
               
                request.setAttribute("process",process);
                purchaseVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                purchaseVO.setVendorName(vendorName);
                purchaseVO.setBillDate(billDate);
                purchaseVO.setFreight(Integer.valueOf(freight));
                purchaseVO.setGst(Integer.valueOf(gst));
                purchaseVO.setDiscount(Integer.valueOf(discount));
                purchaseVO.setNetAmt(Integer.valueOf(netAmt));
                purchaseVO.setTotalAmt(Integer.valueOf(totalAmt));
                int status = purchaseService.insertPurchaseService(purchaseVO);
                if(status == 1){
                    for(int i = 0 ; i<productNameArray.length;i++){                        
                            
                        productPurchaseVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                        productPurchaseVO.setProductName(productNameArray[i]);
                        productPurchaseVO.setQuantity(Integer.valueOf(quantityArray[i]));
                        productPurchaseVO.setUnit(unitArray[i]);
                        productPurchaseVO.setPrice(Integer.valueOf(rateArray[i]));
                        productPurchaseVO.setAmount(Integer.valueOf(amountArray[i]));
                        int pStatus = productPurchaseService.insertProductPurchaseService(productPurchaseVO);
                        out.println(pStatus);
                    }
                
                }
                rd = request.getRequestDispatcher("purchaseJsp.jsp");
                rd.forward(request, response);
            }
           
           
            if(process.equals("viewAllPurchase")){
               request.setAttribute("process",process);
               rs = purchaseService.fetchAllPurchaseService();
               request.setAttribute("resultSet", rs);
               rd = request.getRequestDispatcher("purchaseDetails.jsp");
               rd.forward(request, response); 
            }
           
            if(process.equals("updatePurchase")){
               
               String[] productNameArray = productName.trim().split("-");
               String[] quantityArray = quantity.trim().split("-");
               String[] unitArray = unit.trim().split("-");
               String[] rateArray = rate.trim().split("-");
               String[] amountArray = amount.trim().split("-");
               out.print(amountArray[0]);
               
                request.setAttribute("process",process);
                purchaseVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                purchaseVO.setVendorName(vendorName);
                purchaseVO.setBillDate(billDate);
                purchaseVO.setFreight(Integer.valueOf(freight));
                purchaseVO.setGst(Integer.valueOf(gst));
                purchaseVO.setDiscount(Integer.valueOf(discount));
                purchaseVO.setNetAmt(Integer.valueOf(netAmt));
                purchaseVO.setTotalAmt(Integer.valueOf(totalAmt));
                int status = purchaseService.updatePurchaseService(purchaseVO);
                int dStatus = productPurchaseService.deleteProductPurchaseService(Integer.valueOf(invoiceNo));
                if(status == 1){
                    for(int i = 0 ; i<productNameArray.length;i++){                        
                            
                        productPurchaseVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                        productPurchaseVO.setProductName(productNameArray[i]);
                        productPurchaseVO.setQuantity(Integer.valueOf(quantityArray[i]));
                        productPurchaseVO.setUnit(unitArray[i]);
                        productPurchaseVO.setPrice(Integer.valueOf(rateArray[i]));
                        productPurchaseVO.setAmount(Integer.valueOf(amountArray[i]));
                        int pStatus = productPurchaseService.insertProductPurchaseService(productPurchaseVO);
                        out.println(pStatus);
                    }
                
                }
                rd = request.getRequestDispatcher("purchaseJsp.jsp");
                rd.forward(request, response);
            }
            
            if(process.equals("viewIndividualPurchase")){
               request.setAttribute("process",process);
               rs = purchaseService.fetchPurchaseByIdService(Integer.valueOf(invoiceNo));
               rs1 = productPurchaseService.fetchAllProductPurchaseService(Integer.valueOf(invoiceNo));
               request.setAttribute("resultSet", rs);
               request.setAttribute("productSet", rs1);
               rd = request.getRequestDispatcher("purchaseJsp.jsp");
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
