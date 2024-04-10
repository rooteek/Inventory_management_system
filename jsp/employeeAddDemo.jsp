<%-- 
    Document   : employeeAddDemo
    Created on : 13-Mar-2024, 11:31:50 am
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/employeeAddDemo.css">
    <<script src="JS/index.js"></script>
    <title>Profile Page</title>
</head>

<body>
    <div class="main-page">
        <div class="profile-img">
            <h3>Add New Employee</h3>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit. Sint, aspernatur minima tenetur magni veniam consequatur eligendi modi ipsam cum a mollitia accusamus eveniet neque doloremque esse, voluptatibus maxime nisi minus!Lorem
                <img src="img/resource/1595828806_pinchy_attention.gif" alt="img">
                <!--<label for="">Already have accout?<a href="">Sign in</a></label>-->
            
        </div>

        <!-- Accout Details -->
        <div class="profile-details">
            <h4>Accout Details</h4>
            <hr>
            <br>
            <form action="#" method="post">
                <div class="form-group">
                    <label for="company">Company Name:</label>
                    <input type="text" id="company" name="company" required>
                </div>
                <div class="name-group">
                    <div class="form-group">
                        <label for="first-name">First Name:</label>
                        <input type="text" id="first-name" name="first-name" required>
                    </div>
                    <div class="form-group">
                        <label for="last-name">Last Name:</label>
                        <input type="text" id="last-name" name="last-name" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <div class="form-inline">
                    <div class="form-group">
                        <label for="state">State:</label>
                        <select id="state" name="state" required>
                            <option value="" disabled selected>Select State</option>
                            <option value="state1">State 1</option>
                            <option value="state2">State 2</option>
                            <!-- Add more states here -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="city">City:</label>
                        <select id="city" name="city" required>
                            <option value="" disabled selected>Select City</option>
                            <option value="city1">City 1</option>
                            <option value="city2">City 2</option>
                            <!-- Add more cities here -->
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="address">E-mail:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <div class="form-inline">
                    <div class="form-group">
                        <label for="mobile">Mobile:</label>
                        <input type="tel" id="mobile" name="mobile" required>
                    </div>
                    <div class="form-group">
                        <label for="birthday">Birthday:</label>
                        <input type="date" id="birthday" name="birthday" required>
                    </div>
                </div>
                <button type="submit" onclick="redirecDashboard()">Submit</button>
            </form>
        </div>
    </div>
</body>

</html>
