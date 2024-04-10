<%-- 
    Document   : customerUpdatePage
    Created on : 04-Apr-2024, 12:15:15 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/addCustomerPage.css">
        <script src="JS/index.js" defer></script>
        <title>Document</title>
    </head>

    <body>   
        <%
            String parameterValue = (String) request.getAttribute("itemActivity");
//            out.println("Received value: " + parameterValue + "<br>");
        %> 

        <%
            ResultSet rss = (ResultSet) request.getAttribute("resultS");
//            out.print("the value of rss is: " + rss);
            while (rss.next()) {
//            out.print("Column 1: " + rss.getString(2));
%>
        <div class="main-container">
            <div class="client-details">
                <div class="client-info">
                    <h4><u>Client Info</u></h4>

                    <table>

                        <tr hidden>
                            <td>ID</td>
                            <td>:<input type="text" value="<%= rss.getString("CUSTOMER_ID")%>" id="cusomerID"></td>
                        </tr>
                        <tr>
                            <td>Name </td>
                            <td>:<input type="text" value="<%= rss.getString("CUSTOMER_NAME")%>" id="cusomerName"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>:<input type="text" value="<%= rss.getString("CUSTOMER_MAIL")%>" id="mail"></td>
                        </tr>
                        <tr>
                            <td>Mobile No.</td>
                            <td>:<input type="text" value="<%= rss.getString("MOBILE_NO")%>" id="mobile"></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td>:<input type="text" value="<%= rss.getString("ADDRESS")%>" id="address"></td>
                        </tr>
                        <tr>
                            <td>State</td>
                            <td>:
                                <select name="" id="state" >
                                    <option value="<%= rss.getString("STATE")%>" selected><%= rss.getString("STATE")%></option>
                                    <option value="Gujarat">Gujarat</option>
                                    <option value="Maharashtra">Maharashtra</option>
                                    <option value="Rajasthan">Rajasthan</option>
                                    <option value="Punjab">Punjab</option>
                                    <option value="Delhi">Delhi</option>
                                    <option value="Utar Pradesh">Utar Pradesh</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td>:
                                <select name="" id="city">
                                    <option value="<%= rss.getString("CITY")%>" selected><%= rss.getString("CITY")%></option>
                                    <option value="Surat">Surat</option>
                                    <option value="Mumbai">Mumbai</option>
                                    <option value="Pune">Pune</option>
                                    <option value="Ahemdabad">Ahemdabad</option>
                                    <option value="Delhi">Delhi</option>
                                    <option value="Pali">Pali</option>
                                </select>

                            </td>
                        </tr>
                        <tr>
                            <td>Pin</td>
                            <td>:<input type="text" value="<%= rss.getString("PINCODE")%>" id="pin"></td>
                        </tr>


                    </table>
                </div>
                <div class="client-info">
                    <h4><u>Back Details</u></h4>
                    <table>
                        <tr>
                            <td>Bank Name</td>
                            <td>:<input type="text" value="<%= rss.getString("NAME_ON_PASSBOOK")%>" id="bankName"></td>
                        </tr>
                        <tr>
                            <td>A/c No.</td>
                            <td>:<input type="text" value="<%= rss.getString("BANK_AC_NO")%>" id="bankNo"></td>
                        </tr>
                        <tr>
                            <td>IFSC Code</td>
                            <td>:<input type="text" value="<%= rss.getString("IFSC_CODE")%>" id="ifscCode"></td>
                        </tr>


                        <tr>
                            <td>
                                <br>
                                <h5><u>Tax Registration details</u> </h5>
                            </td>
                        </tr>
                        <tr>
                            <td>Pan</td>
                            <td>:<input type="text" value="<%= rss.getString("PAN")%>" id="panNo"></td>
                        </tr>
                        <tr>
                            <td>Registration type</td>
                            <td>:
                                <select name="" id="registerType">
                                    <option value="<%= rss.getString("REGISTRATION_TYPE")%>" selected><%= rss.getString("REGISTRATION_TYPE")%></option>
                                    <option value="">Regular</option>
                                    <option value="">Unregistered</option>
                                    <option value="">Unknown</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>GST No.</td>
                            <td>:<input type="text" value="<%= rss.getString("GST_NO")%>" id="gstNo"></td>
                        </tr>


                    </table>
                    <%
                        }
                    %>

                </div>

            </div>

            <div class="updateCustomerBtn">
                <div id="ajaxID"></div>
                <button onclick="updateCustomerData()" >Update Details</button>
                <div id="UIC"></div>
            </div>
        </div>
    </body>

</html>
