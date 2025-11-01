<%-- 
    Document   : expensesJsp
    Created on : 05-Apr-2024, 7:01:37 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    
    <script src="index.js"></script>
    <script src="js/ganerateBill.js"></script>
    
</head>
<body>

    <c:if test="${process eq 'addFormExpenses'}" >
        
        <div class="billContainer">
            <div class="billDetails">
                <div class="billDetails1">
                    <table>
                        <tr>
                            <td style="background: #0298CF; color: white; text-align: center;">Invoice No.</td>
                            <td>: <input id="invoiceNo" type="number" name=""></td>
                        </tr>
                        <tr>
                            <td>Expense Title</td>
                            <td>: <input id="expenseName" type="text" ></td>
                        </tr>
                    </table>
                </div>
                <div class="billDetails2">
                    <table>
                        <tr>
                            <td>
                                <label for="">Date </label>
                            </td>
                            <td>
                                : <input type="date" id="billDate">
                            </td>
                        </tr>
                        <tr>
                    </table>
                </div>
            </div>
            <div class="productDetails">
                <div id="invoice-container">
                    <table id="invoice-table" class="productDetails_table">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Expenses</th> 
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody id="invoiceBody">
                            <tr>
                                <td>1</td>
                                <td><input type="text" class="productName" onkeydown="createNewRow(event)" ></td>
                                
                                <td><input type="text" class="amount" onkeydown="createNewRow(event)" oninput ="return updateTotal()"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="addCharges">

                </div>
                <div class="billFooter">
                    <div class="billFooter-1">
                        <table>
                            <tr>
                                <td>
                                    <label for="">GST </label>
                                </td>
                                <td>
                                    <input type="number" id="gst" value=0 oninput="updateTotalAmt()"> %
                                </td>
                            
                            
                                <td>
                                    <label for="">Freight </label>
                                </td>
                                <td>
                                    <input type="number" id="freight" value=0 oninput="updateTotalAmt()"> %
                                </td>
                                
                                <td>
                                    <label for="">Discount </label>
                                </td>
                                <td>
                                    <input type="number" id="discount" value=0 oninput="updateTotalAmt()"> %
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="billFooter-2">
                        <p>Net Amount: <span id="netAmt">0.00</span></p> <br>
                        <p>Total Amount: <span id="totalAmt"> 0.00</span></p><br>
                        <p><button type="button" class="saveButton" onclick="return addExpenses()" value="Save">Save</button></p>
                    </div>
                    
                </div>
            </div>

        </div>
    </c:if>

    <c:if test="${process eq 'viewAllExpenses'}" >
        <table>
            <thead>
                <tr>
                    <th>Invoice No.</th>
                    <th>Expenses Name</th>
                    <th>Bill Date</th>
                    <th>Total Amount</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                    while(rs.next()){
                %>
                <tr >
                    <td onclick="viewIndividualExpenses(<%= rs.getInt(1)%>,'viewIndividualExpenses')"><%= rs.getInt(1)%><td>
                    <td onclick="viewIndividualExpenses(<%= rs.getInt(1)%>,'viewIndividualExpenses')"><%= rs.getString(2)%><td>
                    <td onclick="viewIndividualExpenses(<%= rs.getInt(1)%>,'viewIndividualExpenses')"><%= rs.getString(3)%><td>
                    <td onclick="viewIndividualExpenses(<%= rs.getInt(1)%>,'viewIndividualExpenses')"><%= rs.getInt(4)%><td>
                    <td><button id="deleteExpenses"  onclick="return viewIndividualExpenses(<%= rs.getInt(1)%>,'deleteIndividualExpenses')"><i class='bx bx-trash'></i></button></td>    
                </tr>
                <%
                    }
                %>
            <tbody>
        </table>
    </c:if>
    
    
    <c:if test="${process eq 'viewIndividualExpenses'}" >
    
    <% 
        ResultSet rs = (ResultSet) request.getAttribute("resultSet");
        while(rs.next()){
    %>
        <div class="billContainer">
            <div class="billDetails">
                <div class="billDetails1">
                    <table>
                        <tr>
                            <td style="background: #0298CF; color: white; text-align: center;">Invoice No.</td>
                            <td>: <input id="invoiceNo" type="number" value="<%=rs.getInt(1)%>" readonly></td>
                        </tr>
                        <tr>                            
                            <td>Expense Title</td>
                            <td>: <input id="expenseName" value="<%=rs.getString(2)%>" type="text"></td>
                        </tr>                        
                    </table>
                </div>
                <div class="billDetails2">
                    <table>
                        <tr>
                            <td>
                                <label for="">Date </label>
                            </td>
                            <td>
                                : <input type="date" id="billDate" value="<%=rs.getString(3)%>">
                            </td>
                        </tr>
                        <tr>
                    </table>
                </div>
            </div>
            <div class="productDetails">
                <div id="invoice-container">
                    <table id="invoice-table" class="productDetails_table">
                        <thead>
                            <tr>
                                <th>SR No.</th>
                                <th>Expenses</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody id="invoiceBody">
                            <%
                                 ResultSet ps = (ResultSet) request.getAttribute("productSet");
                                 while(ps.next()){                               
                            %>
                            <tr>
                                <td>1</td>
                                <td><input value="<%=ps.getString(2)%>" type="text" class="productName" onkeydown="createNewRow(event)"  ></td>
                                <td><input value="<%=ps.getInt(3)%>" type="text" class="amount" oninput ="return updateTotal()" ></td>
                                <td><button>x</button></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="addCharges">

                </div>
                <div class="billFooter">
                    <div class="billFooter-1">
                        <table>
                            <tr>
                                <td>
                                    <label for="">GST </label>
                                </td>
                                <td>
                                    <input  value="<%=rs.getInt(4)%>" type="number" id="gst" value=0 oninput="updateTotalAmt()"> %
                                </td>
                            
                            
                                <td>
                                    <label for="">Freight </label>
                                </td>
                                <td>
                                    <input  value="<%=rs.getInt(5)%>" type="number" id="freight" oninput="updateTotalAmt()"> %
                                </td>
                                
                                <td>
                                    <label for="">Discount </label>
                                </td>
                                <td>
                                    <input  value="<%=rs.getInt(6)%>" type="number" id="discount" oninput="updateTotalAmt()"> %
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="billFooter-2">
                         <p>Net Amount: <span readonly value="<%=rs.getInt(7)%>" id="netAmt" ><%=rs.getInt(7)%></span></p> <br>
                        <p>Total Amount: <span readonly value="<%=rs.getInt(8)%>" id="totalAmt" ><%=rs.getInt(8)%></span></p><br>
                        <p><span><input type="button" onclick="return updateExpenses()" value="Save"></span></p><br>
                    </div>
                    
                </div>
            </div>

        </div>

    <% } %>
    </c:if>
    
</body>

