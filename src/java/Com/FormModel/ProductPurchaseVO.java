/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.FormModel;

/**
 *
 * @author admin
 */
public class ProductPurchaseVO {
      
        private Integer srNo;
        private Integer invoiceNo;
	private String productName;
	private Integer quantity;
	private String unit;
	private Integer price;
	private Integer amount;

    public ProductPurchaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
        
    public ProductPurchaseVO(Integer srNo, Integer invoiceNo, String productName, Integer quantity, String unit, Integer price,Integer amount) {
        this.srNo = srNo;
        this.invoiceNo = invoiceNo;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
     
    public Integer getAmount(){
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
