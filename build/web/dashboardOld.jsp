<%-- 
    Document   : dashboard
    Created on : 21-Dec-2023, 5:38:25 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <%--
        if(session.getAttribute("username")==null){
            response.sendRedirect("singup.jsp");
        }
    --%>
    <body>
        <h1>Hello This is Dashboard!</h1>
        <button onclick="process('insert')">Add</button>
        <button onclick="process('view')">view</button>
        <button onclick="process('update')">Update</button>
        <button onclick="process('delete')">Delete</button>
        <button onclick="logoutPage()">Logout</button>
        <div id="ajaxa"></div>
        <script src="JS/index.js"></script>
    </body>
</html>
