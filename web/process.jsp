<%-- 
    Document   : process
    Created on : 21-Dec-2023, 6:08:59 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${process eq 'saleBill'}">

    
    <center>
        <h2>Insert Data</h2>
        <form>
            <div>
                <input type="text" placeholder="Enter your name" required id="name"/>
            </div>
            <div>
                <input type="email" placeholder="Enter your Email" required="" id="email">
            </div>
            <div>
                <input type="text" placeholder="Enter your Passowrd" required id="password">
            </div>
            <div>
                <input type="text" placeholder="Enter your Mobile" required id="mobile" >
            </div>
            <div>
                <input type="text" placeholder="Enter you Address" required id="address">
            </div>
            <div><button onclick="return insertData()">Insert Data</button></div>
        </form>
    <div id="DataInsert"></div>
    </center>
</c:if>
<c:if test="${process eq 'view' or process eq 'delete' }">

    <h2>View</h2>
    <table>
        <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>User Email</th>
                <th>User Password</th>
                <th>Mobile</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <%
                ResultSet rs = (ResultSet) request.getAttribute("resultSet");
                while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt(1)%></td>
                <td><%= rs.getString(2)%></td>
                <td><%= rs.getString(3)%></td>
                <td><%= rs.getString(4)%></td>
                <td><%= rs.getString(5)%></td>
                <td><%= rs.getString(6)%></td>
                <c:if test="${process eq 'delete'}">
                    <td><button onclick="deleteData(this)" did="<%= rs.getInt(1)%>">Delete</button></td>
                </c:if>
            </tr>
            <%
                }
            %>
        </tbody>


    </table>
    <div id="DataDelete"></div>
</c:if>
<c:if test="${process eq 'update'}">

    <h2>update</h2>
</c:if>
<%--<c:if test="${process eq 'delete'}">

    <h2>delte</h2>
</c:if>--%>