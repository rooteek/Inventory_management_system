<%-- 
    Document   : addItemPage
    Created on : 07-Mar-2024, 11:53:10 pm
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
        <link rel="stylesheet" href="CSS/addItemPage.css">
        <script src="JS/index.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </head>

    <body>

        <%
            String parameterValue = request.getParameter("parameterName");
//            String parameterValue="hello";
//            out.println("Received value: " + parameterValue);
        %>        
        


            <form action="itemAddController" method="post" enctype="multipart/form-data">
            <div class="details">
                <div class="item_details">
                    <table>
                        <tr>
                            <td>Type</td>
                            <td>
                                <div>
                                    <input type="radio" name="type" id="goods">&nbsp;<label
                                        for="goods">Goods</label>&nbsp;&nbsp;
                                    <input type="radio" name="type" id="services">&nbsp;<label
                                        for="services">Services</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Product ID</td>
                            <td><input type="text" class="txtfield" name="itemId" id="itemName" required></td>
                        </tr>
                        <tr>
                            <td>Name*</td>
                            <td><input type="text" class="txtfield" name="itemName" id="itemName" required></td>
                        </tr>
                        <tr>
                            <td>HSN*</td>
                            <td><input type="text" class="txtfield" name="itemHsn" id="hsnCode" required></td>
                        </tr>
                        <tr>
                            <td>Category*</td>
                            <td><select name="itemCategory" id="unitName" class="txtfield" onclick="return suggestion('suggestCategory')" required >
                                    
                                </select>
                            </td>
                        </tr>
                    </table>
                    <div class="addItemBtn">
                        <button type="submit">Add Details</button>
                    </div>
                </div>
                <div class="img-uploader">
                    <h4>Upload Product Image</h4><br>
                    <input type="file" name="itemImage" accept="image/*" required class="inputImage">
                    <table>
                        <tr>
                            <td>
                                <label>Sale Price</label>
                            </td>
                            <td>
                                <input type="text" name="itemSalePrice">
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <label>Purchase Price</label>
                            </td>
                            <td>
                                <input type="text" name="itemPurchasePrice">
                            </td>
                        </tr>
                    </table>

                </div>

            </div>
        </form>
    </body>
</html>
