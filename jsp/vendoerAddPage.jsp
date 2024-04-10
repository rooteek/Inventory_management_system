<%-- 
    Document   : vendoerAddPage
    Created on : 06-Apr-2024, 8:20:19 am
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/addCustomerPage.css">
        <script src="JS/CustomerProcess.js" defer></script>
        <script src="JS/index.js" defer></script>
        <title>Document</title>
    </head>

    <body>   
        <%
            String parameterValue = (String) request.getAttribute("itemActivity");
//            out.println("Received value: " + parameterValue);
%> 
        <div class="main-container">
            <div class="client-details">
                <div class="client-info">
                    <h4><u>Vendor Client Info</u></h4>

                    <table>
                        <tr>
                            <td>Name </td>
                            <td>:<input type="text" id="partyName"></td>
                        </tr>
                        <tr>
                            <td>Mobile No.</td>
                            <td>:<input type="text" id="mobileNo"></td>
                        </tr>
                        <tr>
                            <td>Email </td>
                            <td>:<input type="text" id="email"></td>
                        </tr>
                        <tr>
                            <td>Address</td>
                            <td>:<input type="text" id="address"></td>
                        </tr>
                        <tr>
                            <td>State</td>
                            <td>:
                                <select name="" id="state" onclick="suggestion('suggestState')" oninput="suggestion('suggestCity')">
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td>:
                                <select name="" id="city">
                                    
                                </select>

                            </td>
                        </tr>
                        <tr>
                            <td>Pin</td>
                            <td>:<input type="text" id="pincode"></td>
                        </tr>
                    </table>
                </div>
                <div class="client-info">
                    <h4><u>Back Details</u></h4>
                    <table>
                        <tr>
                            <td>Bank Name</td>
                            <td>:<input type="text" id="nameOnPassbook"></td>
                        </tr>
                        <tr>
                            <td>A/c No.</td>
                            <td>:<input type="text" id="bankAcNo"></td>
                        </tr>
                        <tr>
                            <td>IFSC Code</td>
                            <td>:<input type="text" id="ifscCode"></td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <h5><u>Tax Registration details</u> </h5>
                            </td>
                        </tr>
                        <tr>
                            <td>Pan</td>
                            <td>:<input type="text" id="pan"></td>
                        </tr>
                        <tr>
                            <td>Registration type</td>
                            <td>:
                                <select name="" id="registrationType">
                                    <option value="" selected disabled>Select Type</option>
                                    <option value="Regular">Regular</option>
                                    <option value="Unregistered">Unregistered</option>
                                    <option value="Unknown">Unknown</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>GST No.</td>
                            <td>:<input type="text" id="gstNo"></td>
                        </tr>

                    </table>
                </div>
            </div>
            <div class="addCustomerBtn">
                <div id="ajaxID"></div>
                <button onclick="insertVendor()">Add Details</button>
            </div>
        </div>
    </body>

</html>
