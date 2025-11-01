<%-- 
    Document   : index
    Created on : 16-Dec-2023, 6:20:48 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="ErrorPage_404.jsp" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>signin-sinup</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="CSS/signUp.css">
    </head>

    <body>

        <div class="login_form">
            <div class="login_design_img">
                <div class="login_img_contianer">
                    <img src="img/signUp/inginpage_image.webp" alt="">
                    <span><i class='bx bxl-unity'></i> FEATURE HIGHLIGHT</span>
                    <p><strong>Deliver information better with Visme HotSpots.</strong> Add beacons to objects in your designs and link them to audios, videos, slides or web pages.</p>
                </div>
            </div>
            <div class="login_details">
                <div class="login_details_container">
                    <div class="login_details_container_img">
                        <img src="img/logo/logoofIn.jpg" alt="logo">
                        <h1><mark> Stock Pilot</mark></h1>
                    </div>
                    <h3>Create amazing <br> content</h3>
                    <h4>Welcome back! Please use your email or another service to sign in.</h4>
                    <div>
                        <div class="sign-in-form">
                            <div class="inpur-field">
                                <i class="fas fa-user"></i>
                                <input type="text" placeholder="Username" name="username" id="userId">
                            </div>
                            <div class="inpur-field">
                                <i class="fas fa-lock"></i>
                                <input type="password" placeholder="Password" name="password" id="password">
                            </div>
                            <div class="input-status">
                                <label for="departmentId">Department:</label>
                                <select id="department" name="city" required>
                                    <option value="" disabled selected>Select Department</option>
                                    <option value="admin">Admin</option>
                                    <option value="sales">Sales</option>
                                    <option value="purchase">Purchase</option>
                                    <!-- Add more cities here -->
                                </select>
                            </div>
                            <!--<input type="submit" value="Login" class="btn" onclick="validationCheck()">-->
                            <button onclick="return validationCheck()" class="btn">Login</button>
                            <div id="statusAjax"></div>
                            <br>
                            <!--<p class="account-text">Don't have account? <a href="#" id="sign-up-btn2">Apply </a></p>-->
                        </div>
                    </div>
                </div>
                <div class="login_img">
                    <label for="" onclick="redirecPage('homePage')" title="Home">X</label>
                </div>
            </div>
        </div>
        <script src="JS/index.js"></script>
    </body>

</html>
