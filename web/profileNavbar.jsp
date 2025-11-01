<%-- 
    Document   : profileNavbar
    Created on : 07-Mar-2024, 11:43:22 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/profileNavbar.css">
    </head>
    <body>
        <div class="hero">
            <nav>
                <div class="toggle-sidebar">
                    <!--<i class="bx bx-menu"></i>-->
                </div>
                <ul>

                    <li><a href="homePage.jsp">Home</a></li>
                    <li><a href="#">Features</a></li>
                    <li><a href="#">Help</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>

                <img src="img/resource/profile.png" title="profile" alt="user-pic" class="user-pic" onclick="viewProfile('viewProfile')">
            </nav>
        </div>
    </body>
</html>
