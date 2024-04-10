<%-- 
    Document   : dashboard
    Created on : 19-Jan-2024, 9:51:33 am
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/index.js"></script>
        <link rel="stylesheet" href="CSS/dashboard.css"/>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js" defer></script>

    </head>
    <body>
        <div class="cardBox">
            <div class="card">
                <div>
                    <div class="numbers">1,504</div>
                    <div class="cardName">Daily Sales</div>
                </div>
                <div class="iconBx">
                    <ion-icon name="cart-outline"></ion-icon>
                </div>
            </div>
            <div class="card">
                <div>
                    <div class="numbers">1,200</div>
                    <div class="cardName">Daily Purchase</div>
                </div>
                <div class="iconBx">
                    <ion-icon name="card-outline"></ion-icon>
                </div>
            </div>
            <div class="card">
                <div>
                    <div class="numbers">100</div>
                    <div class="cardName">Profit</div>
                </div>
                <div class="iconBx">
                    <ion-icon name="bar-chart-outline"></ion-icon>
                </div>
            </div>
            <div class="card">
                <div>
                    <div class="numbers">80</div>
                    <div class="cardName">Expenses</div>
                </div>
                <div class="iconBx">
                    <ion-icon name="calendar-outline"></ion-icon>
                </div>
            </div>
        </div>
        <!--Order Details list-->
        <div class="details">
            <div class="recentOrders">
                <div class="cardHeader">
                    <h2>Recent Order</h2>
                    <a class="btn" onclick="viewAllSales()">View All</a>
                </div>
                <table>
                    <thead>
                        <tr>
                            <td>Name</td>
                            <td>Price</td>
                            <td>Type</td>
                            <td>Status</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ResultSet ro = (ResultSet) request.getAttribute("recentOrder");
                            while (ro.next()) {

                        %>
                        <tr>
                            <td><%= ro.getString("CUSTOMER_NAME")%></td>
                            <td><%= ro.getString("TOTAL_AMT")%></td>
                            <td><%= ro.getString("REGISTRATION_TYPE")%></td>
                            <td><span class="status delivered">Delivered</span></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
            <!-- New Customers -->
            <div class="recentCustomers">
                <div class="cardHeader">
                    <h2>Recent Customers</h2>
                </div>
                <table>
                    <%
                        ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                        while (rs.next()) {


                    %>
                    <tr>
                        <!--<td width="60px"><div class="imgBx"><img src="img/dashboard/img1.jpg" alt=""></div></td>-->
                        <td><h4><%= rs.getString("CUSTOMER_NAME")%></h4></td>
                        <td><span><%= rs.getString("STATE")%></span></td>
                        <td><span><%= rs.getString("CITY")%></span></td>
                    </tr>


                    <%
                        }
                    %>
                </table>
            </div>
        </div>

        <div class="details">
            <div class="recentOrders">
                <div class="cardHeader">
                    <h2>Recent Purchase</h2>
                    <a class="btn" onclick="viewAllSales()">View All</a>
                </div>
                <table>
                    <thead>
                        <tr>
                            <td>Name</td>
                            <td>Price</td>
                            <td>Type</td>
                            <td>Status</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ResultSet rp = (ResultSet) request.getAttribute("resultPurchase");
                            while (rp.next()) {


                        %>
                        <tr>
                            <td><%= rp.getString("PARTY_NAME")%></td>
                            <td><%= rp.getString("TOTAL_AMT")%></td>
                            <td><%= rp.getString("REGISTRATION_TYPE")%></td>
                            <td>sat</td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <!-- New Customers -->
            <div class="recentCustomers">
                <div class="cardHeader">
                    <h2>Recent Vendor</h2>
                </div>
                <table>
                    <%
                        ResultSet rv = (ResultSet) request.getAttribute("resultVendor");
                        while (rv.next()) {

                    %>
                    <tr class="vendorRow">
                        <td><%= rv.getString("PARTY_NAME")%></td>
                        <td><%= rv.getString("STATE")%></td>
                        <td><%= rv.getString("CITY")%></td>
                    </tr>
                    <%}%>

                </table>
            </div>
        </div>



        <script src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js"></script>
        <script src="JS/graphChat.js"></script>
        <script src="JS/dashboard.js"></script>
        <script src="JS/index.js"></script>

    </body>
</html>


