/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.FormModel;



public class EmployeeDetailVO {

	private String empFullName; 
	private String birthDate;
	private String gender;
	private String phoneNo;
	private String email;
	private String address;
	private String state;
	private String city;
	private String pincode;
	private String joiningDate;
	private String userId;
	private String password ;
	private String department ;
	private String status ;
	
	public EmployeeDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

    public EmployeeDetailVO(String empFullName, String birthDate, String gender, String phoneNo, String email, String address, String state, String city, String pincode, String joiningDate, String userId, String password, String department,String status) {
        this.empFullName = empFullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.state = state;
        this.city = city;
        this.pincode = pincode;
        this.joiningDate = joiningDate;
        this.userId = userId;
        this.password = password;
        this.department = department;
        this.status = status;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
	
	

}
