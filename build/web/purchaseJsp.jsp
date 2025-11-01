<%-- 
    Document   : purchaseJsp
    Created on : 05-Apr-2024, 6:14:15 pm
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    
    
</head>
<body>

    <c:if test="${process eq 'addFormPurchase'}" >
        
        <div class="billContainer">
            <div class="billDetails">
                <div class="billDetails1">
                    <table>
                        <tr>
                            <td style="background: #0298CF; color: white; text-align: center;">Invoice No.</td>
                            <td>: <input id="invoiceNo" type="number" name=""></td>
                        </tr>
                        <tr>
                            
                            <td>Vendor Name</td>
                            <td>: <input id="vendorName" list="VName" onkeyup="return suggestion('suggestVendor')" type="text" >
                                <datalist id="VName"></datalist>
                            </td>
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
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Unit</th>
                                <th>Rate</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody id="invoiceBody">
                            <tr class="inputRow">
                                <td>1</td>
                                <td><input type="text" class="productName" list="pName" onkeyup="return suggestion('suggestProduct')" onkeydown="createNewRow(event)" >
                                    <datalist id="pName"></datalist>
                                </td>
                                <td><input type="number" class="quantity" onkeydown="createNewRow(event)" oninput ="return calculateAmount(this)"></td>
                                <td><input type="text" class="unit" list="unitList"  onkeydown="createNewRow(event)" >
                                    <datalist id="unitList">
                                        <option>Box</option>
                                        <option>Pc.</option>
                                        <option>Kg</option>
                                    </datalist>
                                </td>
                                <td><input type="number" class="rate" onkeydown="createNewRow(event)" oninput="return calculateAmount(this)"></td>
                                <td><input type="text" class="amount" readonly onkeydown="createNewRow(event)"></td>
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
                        <!--<p><input type="button" onclick="return addPurchase()" value="Save"></p>-->
                    </div>
                    
                </div>
            </div>

            <div class="billButtons">
                <div>
                    <!--<button>add</button>-->
                    <button>+</button>
                    <button>-</button>
                </div>
                <div>
                    <button onclick="" class="saveButton" onclick="return addPurchase()">Save</button>
                    <button onclick="previewInvoice()" class="priviewButton">PreView</button>
                </div>
            </div>
        </div>
    </c:if>

    <c:if test="${process eq 'viewAllPurchase'}" >
        <table>
            <thead>
                <tr>
                    <th>Invoice No.</th>
                    <th>Party Name</th>
                    <th>Bill Date</th>
                    <th>Total Amount</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                    while(rs.next()){
                %>
                <tr>
                    <td onclick="viewIndividualPurchase(<%= rs.getInt(1)%>,'viewIndividualPurchase')"><%= rs.getInt(1)%><td>
                    <td onclick="viewIndividualPurchase(<%= rs.getInt(1)%>,'viewIndividualPurchase')"><%= rs.getString(2)%><td>
                    <td onclick="viewIndividualPurchase(<%= rs.getInt(1)%>,'viewIndividualPurchase')"><%= rs.getString(3)%><td>
                    <td onclick="viewIndividualPurchase(<%= rs.getInt(1)%>,'viewIndividualPurchase')"><%= rs.getInt(4)%><td>
                    <td><button id="deletePurchase"  onclick="return viewIndividualPurchase(<%= rs.getInt(1)%>,'deleteIndividualPurchase')">Delete </button></td>    
                </tr>
                <%
                    }
                %>
            <tbody>
        </table>
    </c:if>
    
    
    <c:if test="${process eq 'viewIndividualPurchase'}" >
    
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
                            
                            <td>Vendor Name</td>
                            <td>: <input id="vendorName" list="VName" value="<%=rs.getString(2)%>" onkeyup="return suggestion('suggestVendor')" type="text">
                                <datalist id="VName"></datalist>
                            </td>
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
                    <button onclick=" return createNewRow('Enter')" >Add Row</button>
                    <table id="invoice-table" class="productDetails_table">
                        <thead>
                            <tr>
                                <th>SR No.</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Unit</th>
                                <th>Rate</th>
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
                                <td><input value="<%=ps.getString(2)%>" type="text" class="productName" list="pName" onkeyup="return suggestion('suggestProduct')" onkeydown="createNewRow(event)"  >
                                    <datalist id="pName"></datalist>
                                </td>
                                <td><input value="<%=ps.getInt(3)%>" type="number" class="quantity" onkeydown="createNewRow(event)" oninput ="return calculateAmount(this)"></td>
                                <td><input value="<%=ps.getString(4)%>" type="text" class="unit" list="unitList" onkeydown="createNewRow(event)" >
                                    <datalist id="unitList">
                                        <option>Box</option>
                                        <option>Pc.</option>
                                        <option>Kg</option>
                                    </datalist>
                                </td>
                                <td><input value="<%=ps.getInt(5)%>" type="number" class="rate" onkeydown="createNewRow(event)" oninput="return calculateAmount(this)"></td>
                                <td><input value="<%=ps.getInt(6)%>" type="text" class="amount" readonly ></td>
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
                        <p>Net Amount: <span readonly value="<%=rs.getInt(7)%>" id="netAmt"><%=rs.getInt(7)%></span></p> <br>
                        <p>Total Amount: <span readonly value="<%=rs.getInt(8)%>" id="totalAmt"><%=rs.getInt(8)%></span></p><br>
                        <p><span><input type="button" onclick="return updatePurchase()" value="Save"></span></p><br>
                    </div>
                    
                </div>
            </div>

        </div>

    <% } %>
    </c:if>
    
</body>

