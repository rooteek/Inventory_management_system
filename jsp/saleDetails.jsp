<%-- 
    Document   : saleDetails
    Created on : 12-Mar-2024, 11:01:33 pm
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
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    </head>
    <body>
        <div class="table">
            <div class="table_header">
                <div class="tableHeader1">
                    <!--<p>Product Details</p>-->
                    <button class="add_category" onclick="processMethod('saleBill')">+ Add New</button>
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
                            <th>Invoice No.</th>
                            <th></th>
                            <th>Date</th>
                            <th></th>
                            <th>Particulars</th>
                            <th></th>
                            <th>Total Amt</th>
                            <th></th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                            while (rs.next()) {
                        %>
                        <tr>
                            <td onclick="viewIndividualSale(<%= rs.getInt(1)%>, 'viewIndividualSale')"><%= rs.getInt(1)%><td>
                            <td onclick="viewIndividualSale(<%= rs.getInt(1)%>, 'viewIndividualSale')"><%= rs.getString(3)%><td>
                            <td onclick="viewIndividualSale(<%= rs.getInt(1)%>, 'viewIndividualSale')"><%= rs.getString(2)%><td>
                            <td onclick="viewIndividualSale(<%= rs.getInt(1)%>, 'viewIndividualSale')"><%= rs.getInt(4)%><td>

                            <td>
                                <button  class="deleteDataList" onclick="return viewIndividualSale(<%= rs.getInt(1)%>,'deleteIndividualSale')"><i class='bx bx-trash'></i></button>
                            </td>
                        </tr>
                        <%
                            }
                        %>
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
                    <h2 class="">New ITem</h2>
                    <label for=""onclick="removePopup()">X</label>
                </div>
                <iframe src="addItemPage.jsp" frameborder="0"></iframe>
            </div>
        </div>
    </body>
</html>

