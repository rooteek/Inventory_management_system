<%-- 
    Document   : navbar
    Created on : 03-Feb-2024, 10:49:00 am
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="CSS/profileInfo.css">
    </head>

    <body>
        <div class="hero">
            <nav>
                <div class="toggle-sidebar">
                    <i class="bx bx-menu"></i>
                </div>
                <ul>

                    <li><a href="#">Home</a></li>
                    <li><a href="#">Features</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                </ul>

                <img src="img/prifilePhoto/myCharector.jpeg" alt="user-pic" class="user-pic" onclick="toggleMenu()">

                <div class="sub-menu-wrap" id="subMenu">
                    <div class="sub-menu">
                        <div class="user-info">
                            <img src="img/prifilePhoto/myCharector.jpeg" alt="user">
                            <h3>User Name Profile</h3>
                        </div>
                        <hr>
                        <a href="profilePage.jsp" class="sub-menu-link">
                            <img src="img/resource/profile.png" alt="">
                            <p>Edit Profile</p>
                            <span>></span>
                        </a>
                        <a href="#" class="sub-menu-link">
                            <img src="img/resource/setting.png" alt="">
                            <p>Settings & Privacy</p>
                            <span>></span>
                        </a>
                        <a href="#" class="sub-menu-link">
                            <img src="img/resource/help.png" alt="">
                            <p>Help & Support</p>
                            <span>></span>
                        </a>
                        <a href="#" class="sub-menu-link">
                            <img src="img/resource/logout.png" alt="">
                            <p>Logout</p>
                            <span>></span>
                        </a>
                    </div>
                </div>
            </nav>
        </div>
        <script>
            let subMenu = document.getElementById("subMenu");
            function toggleMenu() {
                subMenu.classList.toggle("open-menu");
            }
        </script>
    </body>

</html>