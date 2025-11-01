<%-- 
    Document   : profilePageDetails
    Created on : 01-Mar-2024, 12:07:53 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet" %>
<link rel="stylesheet" href="CSS/profilePage.css"/>

<c:if test="${process eq 'viewProfile'}">

    <!-- ------------Profile Details------------- -->
    <div class="profile_detail">
        <h3>Profile Details <button onclick="viewProfile('updateFormProfile')">UPDATE DETAILS</button></h3>
        
        <div class="profile_detail_container">
            <form>
                <%
                    ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                    while (rs.next()) {


                %>
                <div class="form-group">
                    <label for="company">Full Name:</label>
                    <input type="text" id="empFullName" name="company" value="<%= rs.getString("EMPLOYEE_FULLNAME")%>" required>
                </div>
                <div class="name-group">
                    <div class="form-group">
                        <label for="first-name">Birth date</label>
                        <input type="text" id="birthDate" name="first-name" value="<%= rs.getString("BIRTH_DATE")%>"" required>
                    </div>
                    <div class="form-group">
                        <label for="last-name">Gender</label>
                        <input type="text" id="gender" name="last-name" value="<%= rs.getString("GENDER")%>"" required>
                    </div>
                </div>
                <div class="form-inline">
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" value="<%= rs.getString("ADDRESS")%>"" required>
                    </div>
                    <div class="form-address">
                        <div>
                            <label for="state">State:</label>
                            <input type="text" id="state" name="address" value="<%= rs.getString("STATE")%>"" required>
                        </div>
                        <div>
                            <label for="city">City:</label>
                            <input type="text" id="city" name="address" value="<%= rs.getString("CITY")%>"" required>
                        </div>
                    </div>
                </div>

                <div class="form-inline">
                    <div class="form-group">
                        <label for="mobile">Pincode</label>
                        <input type="tel" id="pincode" name="mobile" value="<%= rs.getString("PINCODE")%>"" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Joining Date</label>
                        <input type="email" id="joiningDate" name="birthday" value="<%= rs.getString("JOINING_DATE")%>"" required>
                    </div>
                </div>

                <div class="form-inline">
                    <div class="form-group">
                        <label for="mobile">Mobile:</label>
                        <input type="tel" id="phoneNo" name="mobile" value="<%= rs.getString("PHONE_NO")%>"" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Email:</label>
                        <input type="email" id="birthday" name="birthday" value="<%= rs.getString("EMAIL")%>"" required>
                    </div>
                </div>

                <div class="form-inline">
                    <div class="form-group">
                        <label for="address">User Id</label>
                        <input type="text" id="userId" name="address" value="<%= rs.getString("USERID")%>"" required>
                    </div>
                    <div class="form-address">
                        <div>
                            <label for="state">Department</label>
                            <input type="text" id="department" name="address" value="<%= rs.getString("DEPARTMENT")%>"" required>
                        </div>
                        <div>
                            <label for="city">Status</label>
                            <input type="text" id="status" name="address" value="<%= rs.getString("STATUS")%>"" required>
                        </div>
                    </div>
                </div>
                <!-- <button type="submit">Submit</button> -->
                <%
                    }
                %>
            </form>
        </div>
    </div>
</c:if>
<c:if test="${process eq 'updateFormProfile'}">

    <!-- ------------Profile Details------------- -->
    <div class="profile_detail">
        <h3>Profile Details <button>UPDATE DETAILS</button> <button class="changePassword">CHANGE PASSWORD</button></h3>
        
        <div class="profile_detail_container">
            <form>
                <%
                    ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                    while (rs.next()) {


                %>
                <div class="form-group">
                    <label for="company">Full Name:</label>
                    <input type="text" id="empFullName" name="company" value="<%= rs.getString("EMPLOYEE_FULLNAME")%>" required>
                </div>
                <div class="name-group">
                    <div class="form-group">
                        <label for="first-name">Birth date</label>
                        <input type="text" id="birthDate" name="first-name" value="<%= rs.getString("BIRTH_DATE")%>"" required>
                    </div>
                    <div class="form-group">
                        <label for="last-name">Gender</label>
                        <input type="text" id="gender" name="last-name" value="<%= rs.getString("GENDER")%>"" required>
                    </div>
                </div>
                <div class="form-inline">
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" value="<%= rs.getString("ADDRESS")%>"" required>
                    </div>
                    <div class="form-address">
                        <div>
                            <label for="state">State:</label>
                            <input type="text" id="state" name="address" value="<%= rs.getString("STATE")%>"" required>
                        </div>
                        <div>
                            <label for="city">City:</label>
                            <input type="text" id="city" name="address" value="<%= rs.getString("CITY")%>"" required>
                        </div>
                    </div>
                </div>

                <div class="form-inline">
                    <div class="form-group">
                        <label for="mobile">Pincode</label>
                        <input type="tel" id="pincode" name="mobile" value="<%= rs.getString("PINCODE")%>"" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Joining Date</label>
                        <input type="email" id="joiningDate" name="birthday" value="<%= rs.getString("JOINING_DATE")%>"" required>
                    </div>
                </div>

                <div class="form-inline">
                    <div class="form-group">
                        <label for="mobile">Mobile:</label>
                        <input type="tel" id="phoneNo" name="mobile" value="<%= rs.getString("PHONE_NO")%>"" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Email:</label>
                        <input type="email" id="birthday" name="birthday" value="<%= rs.getString("EMAIL")%>"" required>
                    </div>
                </div>

                
                <!-- <button type="submit">Submit</button> -->
                <%
                    }
                %>
                <button>Update Profile</button>
            </form>
        </div>
    </div>
</c:if>


<c:if test="${process eq 'profileDetailsEdit'}">


    <!-- ------------Profile Details------------- -->
    <div class="profile_detail">
        <div>
            <h3>Profile Details he</h3>

        </div>

        <div class="profile_detail_container">
            <form action="#" method="post">
                <div class="form-group">
                    <label for="company">Company Name:</label>
                    <input type="text" id="company" name="company" required>
                </div>
                <div class="name-group">
                    <div class="form-group">
                        <label for="first-name">First Name:</label>
                        <input type="text" id="first-name" name="first-name" required>
                    </div>
                    <div class="form-group">
                        <label for="last-name">Last Name:</label>
                        <input type="text" id="last-name" name="last-name" required>
                    </div>
                </div>
                <div class="form-inline">
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" required>
                    </div>
                    <div class="form-address">
                        <div>
                            <label for="state">State:</label>
                            <input type="text" id="address" name="address" required>
                        </div>
                        <div>
                            <label for="city">City:</label>
                            <input type="text" id="address" name="address" required>
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <label for="address">E-mail:</label>
                    <input type="text" id="address" name="address" required>
                </div>

                <div class="form-inline">
                    <div class="form-group">
                        <label for="mobile">Mobile:</label>
                        <input type="tel" id="mobile" name="mobile" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Email:</label>
                        <input type="email" id="birthday" name="birthday" required>
                    </div>
                </div>

                <button type="submit" onclick="updateProfile()" >Update</button> 
            </form>
        </div>
    </div>
</c:if>

<c:if test="${process eq 'profilePasswordChange'}">
    <h1>profilePasswordChange</h1>
</c:if>
<c:if test="${process eq 'profileNotification'}">
    <h1>profileNotification</h1>
</c:if>
