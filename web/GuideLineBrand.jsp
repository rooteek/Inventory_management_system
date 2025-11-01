<%-- 
    Document   : GuideLineBrand
    Created on : 29-Dec-2023, 8:17:20 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Brading Page</title>
        <link rel="stylesheet" href="CSS/guidelineBrand.css">
    </head>
    <body>
    <center>

        <h2 >Guided By</h2>
        <p>
            We cannot solve problems with the kind of thinking we employed when we came up with them<br>
            Success is not final; failure is not fatal: It is the courage to continue that counts
        </p>
        <p></p>
    </center>
    <div class="logos"> 
        <div class="logos-slide">
            <img src="img/BrandImage/Zoho-Books-logo.png" alt="keep">
            <img src="img/BrandImage/angkasa pura logistics.png" alt="try">
            <img src="img/BrandImage/aplos.png" alt="and">
            <img src="img/BrandImage/bill com.png" alt="Good">
            <img src="img/BrandImage/Infosys_logo.svg.png" alt="Luck">
            <img src="img/BrandImage/Oracle_Logo.jpg" alt="For">
            <img src="img/BrandImage/profitbooks-png.png" alt="The">
            <img src="img/BrandImage/saasu.png" alt="Life">
            <img src="img/BrandImage/sap-se.png" alt="❤❤❤❤❤❤❤❤">
            <img src="img/BrandImage/udhna clg logo.png" alt="💕💕💕💕">
            <img src="img/BrandImage/xero png.png" alt="😘😘😘😘😘😘">
        </div>
    </div>

    <script>
        var copy = document.querySelector(".logos-slide").cloneNode(true);
        document.querySelector(".logos").appendChild(copy);
    </script>
</body>
</html>
