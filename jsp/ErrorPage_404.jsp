<%-- 
    Document   : ErrorPage
    Created on : 11-Jan-2024, 6:59:06 am
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .Image {
                background: url(img/ErrorImg/404Error.png);
                width: 20%;
                height: 170px;
                background-repeat: no-repeat;
                /* border: 2px solid black; */
            }
            .text-center{
                display: flex;
                flex-direction: column;
                place-items: center;
            }
        </style>
    </head>
    <body>
    <center>
        <div class="text-center">
            <div class="Image">
            </div>
            <h1>Page not for</h1>
            <button><a href="homePage.jsp">Go to Home page</a></button>
        </div>
    </center>
</body>
</html>
