<%-- 
    Document   : profilePage
    Created on : 01-Mar-2024, 12:07:53 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/profilePage.css"/>
        <script src="JS/index.js"></script>
        <title>JSP Page</title>
    </head>
    <body onload="profileProcess('profileDetails')">
        <div class="profile_container">
            <nav>
                <a onclick="profileProcess('profileDetails')">Profile</a>
                <a onclick="profileProcess('profileDetailsEdit')">Edit</a>
                <a onclick="profileProcess('profilePasswordChange')">Security</a>
                <a onclick="profileProcess('profileNotification')">Notification</a>
                <a href="mainPage.jsp">Dashboard</a>
            </nav>
            <hr>

            <!--------------profile Details------------------- -->
            <div class="profile_details" id="profile_ajax">
               
            </div>
        </div>
    </body>
</html>
