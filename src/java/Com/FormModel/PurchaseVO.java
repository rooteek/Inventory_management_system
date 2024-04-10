
package Com.FormModel;
public class PurchaseVO {
 
	private Integer invoiceNo;
	private String vendorName;
	private String billDate;
	private Integer gst;
	private Integer freight;
	private Integer discount;
	private Integer netAmt;
	private Integer totalAmt;
	
	public PurchaseVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PurchaseVO(Integer invoiceNo, String vendorName, String billDate, Integer gst,
			Integer freight, Integer discount, Integer netAmt, Integer totalAmt) {
		super();
		this.invoiceNo = invoiceNo;
		this.vendorName = vendorName;
		this.billDate = billDate;
		this.gst = gst;
		this.freight = freight;
		this.discount = discount;
		this.netAmt = netAmt;
		this.totalAmt = totalAmt;
	}
	
	public Integer getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(Integer invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public Integer getGst() {
		return gst;
	}
	public void setGst(Integer gst) {
		this.gst = gst;
	}
	public Integer getFreight() {
		return freight;
	}
	public void setFreight(Integer freight) {
		this.freight = freight;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(Integer netAmt) {
		this.netAmt = netAmt;
	}
	public Integer getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Integer totalAmt) {
		this.totalAmt = totalAmt;
	}
   
}
