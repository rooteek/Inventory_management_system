<%-- 
    Document   : purchaseMainPage
    Created on : 06-Apr-2024, 2:15:05 pm
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Side Menu</title>
        <!--<link rel="stylesheet" href="CSS/billGenerator.css">-->
        <link rel="stylesheet" href="CSS/dashboard.css"/>
        <link rel="stylesheet" href="CSS/item.css">
        <link rel="stylesheet" href="CSS/itemCategory.css"/>
        <link rel="stylesheet" href="CSS/addItemPage.css">
        <link rel="stylesheet" href="CSS/employeeAdd.css">
        <link rel="stylesheet" href="CSS/billPreviewPage.css">
        <link rel="stylesheet" href="CSS/addCustomerPage.css">
        <link rel="stylesheet" href="CSS/salesBills.css"/>

        <!--<link rel="stylesheet" href="CSS/addCustomerPage.css">-->
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!--<script src="JS/billGenerator.js" defer></script>-->
        <script src="JS/salesBill.js" defer></script>
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <script src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.1/dist/chart.umd.min.js"></script>
    </head>
    
    
    <body onload="processMethod('dashboard')">
        <div class="sidebar">
            <div class="dash_logo">

                <a href="">
                    <div><i class='bx bxl-kubernetes'></i>Zeeco</div>
                </a>
            </div>
            <!--<button onclick="return dashboard()">Dashboard</button>-->
            <a class=""><i class='bx bx-category-alt'></i><label onclick="processMethod('dashboard')"> Dashboard</label> </a>
            <div class="submenu">
                <a href="#" class="parent" onclick="opelList()"> <i class='bx bx-collection'></i> Inventory <span
                        class="arrow">&#9660;</span></a>
                <div class="sub-content">
                    <a href="#"><label onclick="itemProcessMethod('item')">Item</label></a>
                    <a href="#"><label onclick="processMethod('itemCategory')">category</label></a>
                    <a href="#"><label onclick="processMethod('color')">Color</label></a>
                    <a href="#"><label onclick="">Ledger</label></a>
                </div>
            </div>
            <!--            <div class="submenu">
                            <a href="#" class="parent"><i class='bx bxs-cart-alt'></i> Sale <span class="arrow">&#9660;</span></a>
                            <div class="sub-content">
                                <a href="#"><label onclick="processMethod('saleBill')">Generate Bill</label></a>
                                <a href="#"><label onclick="viewAllSales()">Sale Invoices</label></a>
                                <a href="#"><label onclick="processMethod('saleOrder')">Sale Order</label></a>
                                <a href="#"><label>Sale Return</label></a>
                            </div>
                        </div>-->
            <div class="submenu">
                <a href="#" class="parent"><i class='bx bx-book-alt'></i>Purchase <span class="arrow">&#9660;</span></a>
                <div class="sub-content">
                    <a href="#"><label onclick="addFormPurchase()">Generate bill</label></a>
                    <a href="#"><label onclick="viewAllPurchase()">Purchase Inv.</label></a>
                    <!--<a href="#"><label>Purchase Order</label></a>-->
                    <!--<a href="#"><label>Purchase Return</label></a>-->
                </div>
            </div>
<!--            <div class="submenu">
                <a href="#" class="parent"><i class='bx bx-copy-alt'></i>Party <span class="arrow">&#9660;</span></a>
                <div class="sub-content">
                    <a href="#"><label onclick="CustomerProcessMethod('customer')">Customer Master</label></a>
                    <a href="#"><label onclick="viewVendor()">Vendor Master </label></a>
                    <a href="#"><label>Purchase Order</label></a>
                    <a href="#"><label>Purchase Return</label></a>
                </div>
            </div>-->
             <a href="#"><i class='bx bxs-carousel'></i><label label onclick="viewVendor()">Vendor Master</label></a>
            <div class="submenu">
                <a href="#" class="parent"><i class='bx bx-wallet-alt'></i>Expenses <span class="arrow">&#9660;</span></a>
                <div class="sub-content">
                    <a href="#"><label onclick="addFormExpenses()">Generate Exp.</label></a>
                    <a href="#"><label onclick="viewAllExpenses()">View Exp.</label></a>
                    <!--<a href="#"><label>Purchase Order</label></a>-->
                    <!--<a href="#"><label>Purchase Return</label></a>-->
                </div>
            </div>
<!--            <div class="submenu">
                <a href="#" class="parent"><i class='bx bx-group'></i>Employee <span class="arrow">&#9660;</span></a>
                <div class="sub-content">
                    <a href="#"><label onclick="processMethod('addEmployee')">Employee Mr.</label></a>
                    <a href="#"><label onclick="employeePageDemo()">Add Employee</label></a>
                    <a href="#"><label>Purchase Order</label></a>
                    <a href="#"><label>Purchase Return</label></a>
                </div>
            </div>-->
            <div class="submenu">
                <a href="#" class="parent"><i class='bx bx-notepad'></i>Billing <span class="arrow">&#9660;</span></a>
                <div class="sub-content">
                    <!--<a href="#"><label onclick="processMethod('saleDetails')">Sales</label></a>-->
                    <a href="#"><label>Expenses</label></a>
                    <a href="#"><label onclick="processMethod('purchaseDetails')">Purchase</label></a>
                    <!--<a href="#"><label>Purchase Return</label></a>-->
                </div>
            </div>
            <!--<a href="#"><i class='bx bxs-carousel'></i><label>Department</label></a>-->
            <a href="#"><i class='bx bx-line-chart'></i><label onclick="">Stock</label></a>
            <!--<a href="#"><i class='bx bx-history'></i><label>History</label></a>-->
            <a href="#"><i class='bx bx-log-out'></i><label onclick="logoutPage()">Logout</label></a>
        </div>
        <div class="content">
            <%@include file="profileNavbar.jsp" %>
            <div id="ajaxCall"></div>
        </div>


        <script src="JS/setting.js"></script>
        <!--<script src="JS/graphChat.js"></script>-->
        <script src="JS/dashboard.js"></script>
        <script src="JS/index.js"></script>
        <script src="JS/previewBill.js"></script>

    </body>
</html>