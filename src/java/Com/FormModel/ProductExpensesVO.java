/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.FormModel;

/**
 *
 * @author admin
 */
public class ProductExpensesVO {
    
        private Integer srNo;
        private Integer invoiceNo;
	private String productName;
	private Integer amount;

    public ProductExpensesVO() {
		super();
		// TODO Auto-generated constructor stub
	}
        
    public ProductExpensesVO(Integer srNo, Integer invoiceNo, String productName,Integer amount) {
        this.srNo = srNo;
        this.invoiceNo = invoiceNo;
        this.productName = productName;
        this.amount = amount;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public Integer getAmount(){
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
        
  
}
