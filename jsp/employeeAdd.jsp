<%-- 
    Document   : employeeAdd
    Created on : 12-Mar-2024, 9:28:20 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/employeeAdd.css">
        <title>Profile Page</title>
    </head>

    <body>
        <div class="main-page">
            <!-- Employee Details -->
            <div class="employee-details">
                <h4>Employee Details</h4>
                <hr>
                <br>
                <div >
                    <!-- <div class="form-group">
                        <label for="company">Company Name:</label>
                        <input type="text" id="company" name="company" required>
                    </div> -->
                    <div class="name-group">
                        <div class="form-group">
                            <label for="first-name">First Name:</label>
                            <input type="text" id="empFullName" name="first-name" required>
                        </div>
                        <div class="form-group">
                            <label for="last-name">Birth Date</label>
                            <input type="date" id="birthDate" name="last-name" required>
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
                    <div class="name-group">
                        <div class="form-group">
                            <label for="first-name">Pincode</label>
                            <input type="text" id="pincode" name="first-name" required>
                        </div>
                        <div class="form-group">
                            <label for="last-name">User ID:</label>
                            <input type="text" id="userId" name="last-name" required>
                        </div>
                        <div class="form-group">
                            <label for="last-name">Password:</label>
                            <input type="text" id="password" name="last-name" required>
                        </div>
                    </div>

                    <div class="form-inline">
                        <div class="form-group form-cheking">
                            <div class="form-group">
                                <!--<label for="">Gender:</label>-->
                                <div class="form-group">
                                    <label for="departmentId">Gender</label>
                                    <select id="gender" name="city" required>
                                        <option value="" disabled selected>Select Gender</option>
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                        <!-- Add more cities here -->
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="">Joining Date:</label>
                                <!-- <div class=""> -->
                                <input type="date" id="joiningDate" name="gender" required>
                                <!-- </div> -->
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="departmentId">Department:</label>
                            <select id="department" name="city" required>
                                <option value="" disabled selected>Select Department</option>
                                <option value="admin">Admin</option>
                                <option value="sales">Sales</option>
                                <option value="purchase">Purchase</option>
                                <!-- Add more cities here -->
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="departmentId">Status</label>
                            <select id="status" name="city" required>
                                <option value="" disabled selected>Select Department</option>
                                <option value="active">Active</option>
                                <option value="inactive">Inactive</option>
                                <!-- Add more cities here -->
                            </select>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="mobile">Mobile:</label>
                            <input type="tel" id="phoneNo" name="mobile" required>
                        </div>
                        <div class="form-group">
                            <label for="birthday">Email:</label>
                            <input type="email" id="email" name="birthday" required>
                        </div>
                    </div>

                    <button onclick="return addEmployee()">Submit</button>
                </div>
            </div>
        </div>
    </body>
</html>