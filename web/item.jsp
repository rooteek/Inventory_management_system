<%-- 
    Document   : item
    Created on : 07-Mar-2024, 11:52:32 pm
    Author     : admin
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%--<%@page import="com.mysql.cj.jdbc.Blob"%>--%>
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
                        <button class="add_new" onclick="addPopupScreen('insert')">+ Add New</button>
                        <input type="hidden" id="hiddenInput" name="parameterName">
                    </div>
                    <div class="tableHeader2">
                        <input type="text" placeholder="Product">
                        <button class="item-exp">Export</button>
                    </div>
                </div>
                <div class="table_section">
                    <table>
                        <thead>
                            <tr>
                                <th>SR No.</th>
                                <th>Product</th>
                                <th>Name</th>
                                <th>Sale Pr</th>
                                <th>Purchase Pr</th>
                                <th>Category</th>
                                <th>HSN</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int sr = 1;
                                ResultSet rs = (ResultSet) request.getAttribute("resultSet");

                                while (rs.next()) {
                            %>
                            <tr>
                                <td><%= sr++%></td>
                                <td><img src="showImage.jsp?productId=<%= rs.getInt("PRODUCT_ID")%>" alt="alt"/></td>
                                <td><%= rs.getString("PRODUCT_NAME")%></td>
                                <td><%= rs.getInt("SALES_PRICE")%></td>
                                <td><%= rs.getInt("PURCHASE_PRICE")%></td>
                                <td><%= rs.getString("CATEGORY_ID")%></td>
                                <td><%= rs.getInt("HSN_CODE")%></td>
                                <td>
                                    <button class="editDataList" onclick="getItem(this)" uid="<%= rs.getInt("PRODUCT_ID")%>"><i class='bx bx-edit'></i></button>
                                    <button class="deleteDataList" onclick="itemDelete(this)" did="<%= rs.getInt("PRODUCT_ID")%>"><i class='bx bx-trash'></i></button>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <div id="getData"></div>
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
                        <h2 class="">New ITem</h2>
                        <%--
                            String parameterValue = request.getParameter("parameterName");
                            out.println("Received value: " + parameterValue);
                        --%> 

                        <label for=""onclick="removePopup('add-x')" >X</label>
                    </div>
                    <iframe src="addItemPage.jsp" frameborder="0">
                    </iframe>
                </div>
            </div>
    </body>
</html>