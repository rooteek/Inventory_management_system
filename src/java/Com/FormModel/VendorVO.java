package Com.FormModel;

public class VendorVO {

    private int vendorId;
    private String partyName;
    private String address;
    private String state;
    private String city;
    private int pincode;
    private String registrationType;
    private String pan;
    private String mobileNo;
    private String email;
    private String gstNo;
    private String nameOnPassbook;
    private String bankAcNo;
    private String ifscCode;

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public VendorVO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public VendorVO(int vendorId, String partyName, String address, String state, String city, int pincode, String registrationType, String pan, String mobileNo, String email, String gstNo, String nameOnPassbook, String bankAcNo, String ifscCode) {
        super();
        this.vendorId = vendorId;
        this.partyName = partyName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.registrationType = registrationType;
        this.pan = pan;
        this.mobileNo = mobileNo;
        this.email = email;
        this.gstNo = gstNo;
        this.nameOnPassbook = nameOnPassbook;
        this.bankAcNo = bankAcNo;
        this.ifscCode = ifscCode;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getNameOnPassbook() {
        return nameOnPassbook;
    }

    public void setNameOnPassbook(String nameOnPassbook) {
        this.nameOnPassbook = nameOnPassbook;
    }

    public String getBankAcNo() {
        return bankAcNo;
    }

    public void setBankAcNo(String bankAcNo) {
        this.bankAcNo = bankAcNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public void setPincode(String pincode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
