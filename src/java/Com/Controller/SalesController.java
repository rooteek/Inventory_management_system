
package Com.Controller;

import Com.FormModel.ProductSalesVO;
import Com.FormModel.SalesVO;
import Com.Service.ProductSalesService;
import Com.Service.SalesService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.sql.ResultSet;

public class SalesController extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        ProductSalesVO productSalesVO = new ProductSalesVO();
        SalesVO salesVO = new SalesVO();
        ProductSalesService productSalesService = new ProductSalesService();
        SalesService saleService = new SalesService();
        
        String process = request.getParameter("process");
        String invoiceNo = request.getParameter("invoiceNo");
        String customerName = request.getParameter("customerName");
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
          
           if(process.equals("addFormSales")){
                request.setAttribute("process",process);
                rd = request.getRequestDispatcher("salesJsp.jsp");
                rd.forward(request, response);
            } 
           
           if(process.equals("deleteIndividualSale")){
                request.setAttribute("process",process);
                int delProSales= productSalesService.deleteProductSalesService(Integer.valueOf(invoiceNo));               
                int delSales= saleService.deleteSalesService(Integer.valueOf(invoiceNo));
                
                
            } 
           
           if(process.equals("addSales")){
               
               String[] productNameArray = productName.trim().split("-");
               String[] quantityArray = quantity.trim().split("-");
               String[] unitArray = unit.trim().split("-");
               String[] rateArray = rate.trim().split("-");
               String[] amountArray = amount.trim().split("-");
               out.print(amountArray[0]);
               
                request.setAttribute("process",process);
                salesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                salesVO.setCustomerName(customerName);
                salesVO.setBillDate(billDate);
                salesVO.setFreight(Integer.valueOf(freight));
                salesVO.setGst(Integer.valueOf(gst));
                salesVO.setDiscount(Integer.valueOf(discount));
                salesVO.setNetAmt(Integer.valueOf(netAmt));
                salesVO.setTotalAmt(Integer.valueOf(totalAmt));
                int status = saleService.insertSalesService(salesVO);
                if(status == 1){
                    for(int i = 0 ; i<productNameArray.length;i++){                        
                            
                        productSalesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                        productSalesVO.setProductName(productNameArray[i]);
                        productSalesVO.setQuantity(Integer.valueOf(quantityArray[i]));
                        productSalesVO.setUnit(unitArray[i]);
                        productSalesVO.setPrice(Integer.valueOf(rateArray[i]));
                        productSalesVO.setAmount(Integer.valueOf(amountArray[i]));
                        int pStatus = productSalesService.insertProductSalesService(productSalesVO);
                        out.println(pStatus);
                    }
                
                }
                rd = request.getRequestDispatcher("salesJsp.jsp");
                rd.forward(request, response);
            }
           
           
            if(process.equals("viewAllSales")){
               request.setAttribute("process",process);
               rs = saleService.fetchAllSalesService();
               request.setAttribute("resultSet", rs);
               rd = request.getRequestDispatcher("saleDetails.jsp");
               rd.forward(request, response); 
            }
           
            if(process.equals("updateSales")){
               
               String[] productNameArray = productName.trim().split("-");
               String[] quantityArray = quantity.trim().split("-");
               String[] unitArray = unit.trim().split("-");
               String[] rateArray = rate.trim().split("-");
               String[] amountArray = amount.trim().split("-");
               out.print(amountArray[0]);
               
                request.setAttribute("process",process);
                salesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                salesVO.setCustomerName(customerName);
                salesVO.setBillDate(billDate);
                salesVO.setFreight(Integer.valueOf(freight));
                salesVO.setGst(Integer.valueOf(gst));
                salesVO.setDiscount(Integer.valueOf(discount));
                salesVO.setNetAmt(Integer.valueOf(netAmt));
                salesVO.setTotalAmt(Integer.valueOf(totalAmt));
                int status = saleService.updateSalesService(salesVO);
                int dStatus = productSalesService.deleteProductSalesService(Integer.valueOf(invoiceNo));
                if(status == 1){
                    for(int i = 0 ; i<productNameArray.length;i++){                        
                            
                        productSalesVO.setInvoiceNo(Integer.valueOf(invoiceNo));
                        productSalesVO.setProductName(productNameArray[i]);
                        productSalesVO.setQuantity(Integer.valueOf(quantityArray[i]));
                        productSalesVO.setUnit(unitArray[i]);
                        productSalesVO.setPrice(Integer.valueOf(rateArray[i]));
                        productSalesVO.setAmount(Integer.valueOf(amountArray[i]));
                        int pStatus = productSalesService.insertProductSalesService(productSalesVO);
                        out.println(pStatus);
                    }
                
                }
                rd = request.getRequestDispatcher("salesJsp.jsp");
                rd.forward(request, response);
            }
            
            if(process.equals("viewIndividualSale")){
               request.setAttribute("process",process);
               rs = saleService.fetchSalesByIdService(Integer.valueOf(invoiceNo));
               rs1 = productSalesService.fetchAllProductSalesService(Integer.parseInt(invoiceNo));
               request.setAttribute("resultSet", rs);
               request.setAttribute("productSet", rs1);
               rd = request.getRequestDispatcher("salesBill.jsp");
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
