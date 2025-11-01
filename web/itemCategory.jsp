<%-- 
    Document   : itemCategory
    Created on : 12-Mar-2024, 3:10:51 pm
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
        <link rel="stylesheet" href="CSS/itemCategory.css"/>

        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="JS/index.js" defer></script>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    </head>
    <body>
        <div class="table">
            <div class="table_header">
                <div class="tableHeader1">
                    <!--<p>Product Details</p>-->
                    <button class="add_category" onclick="addPopupScreen('insert')">+ Add New</button>
                    <input type="hidden" id="hiddenInput" name="parameterName">
                </div>
                <div class="tableHeader2">
                    <input type="text" placeholder="Product">
                    <button class="btn-pdf"><i class='bx bxs-file-pdf'></i>Export PDF</button>
                    <button class="btn-excel"><i class='bx bx-export'></i>Export Excel</button>
                </div>
            </div>
            <div class="table_section">
                <table>
                    <thead>
                        <tr>
                            <th>SR No.</th>
                            <th>Category Name</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int cout = 1;
                            ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                            while (rs.next()) {


                        %>
                        <tr>
                            <td><%= cout++%></td>
                            <td><%= rs.getString("CATEGORY_NAME")%></td>
                            <td>
                                <button class="editDataList"><i class='bx bxs-edit'></i><label></label></button>
                                <button class="deleteDataList" onclick=""><i class='bx bx-trash'></i></button>
                            </td>
                        </tr>
                        <%
                            }%>
                    </tbody>
                </table>
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
                    <h2 class="">New Category</h2>
                    <label for=""onclick="removePopup('add-x')">X</label>
                </div>
                <iframe src="itemCategoryAdd.jsp" frameborder="0"></iframe>
            </div>
        </div>
    </body>
</html>
