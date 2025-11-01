<%-- 
    Document   : stockPage
    Created on : 09-Apr-2024, 11:50:28 am
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Table Design</title>
        <!--<link rel="stylesheet" href="CSS/item.css">-->
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <!-- <link rel="stylesheet" href=""> -->
    </head>
    <body>
        <div class="table">
            <div class="table_header">
                <div class="tableHeader1">
                    <!--<p>Product Details</p>-->
                    <!--<button class="add_new" onclick="addPopupScreen('insert')">+ Add New</button>-->
                    <input type="hidden" id="hiddenInput" name="parameterName">
                </div>
                <div class="tableHeader2">
                    <input type="text" placeholder="Customer">
                    <button class="item-exp">Export</button>
                </div>
            </div>
            <!--<div id="getData"></div>-->
            <div class="table_section">
                <table>
                    <thead>
                        <tr>
                            <th>SR No.</th>
                            <th>Product Name</th>
                            <th>Unit</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ResultSet rs = (ResultSet) request.getAttribute("stockView");
                            while (rs.next()) {
                        %>
                        <tr>
                            <td><%= rs.getInt(1)%></td>
                            <td><%= rs.getString(2) %></td>
                            <td><%=rs.getString(3) %></td>
                            <td><%=rs.getInt(4) %></td>
                        </tr>

                        <%}%>
                    </tbody>
                </table>
                <div id="deleteCustomer"></div>
            </div>
            <div class="pagination">
                <div><<</div>
                <div><</div>
                <div>1</div>
                <div>2</div>
                <div>></div>
                <div>>></div>
            </div>

        </div>

        <div class="insert-item" id="insert-item"> 
            <div class="insert-details">
                <div class="heading">
                    <h2 class="">New Vendor</h2>
                    <label for=""onclick="removePopup('add-x')">X</label>
                </div>
                <iframe src="vendoerAddPage.jsp" frameborder="0"></iframe>
            </div>
        </div>
        <!-- ----------Css in item.css----------- -->
        <div class="insert-item" id="insert-item2"> 
            <div class="insert-details">
                <div class="heading">
                    <h2 class="">Update Vendor</h2>
                    <label for=""onclick="removePopup('update-x')">X</label>
                </div>
                <div id="getData"></div>
                <!--<iframe src="customerUpdatePage.jsp" frameborder="0"></iframe>-->
            </div>
        </div>
    </body>
</html>
