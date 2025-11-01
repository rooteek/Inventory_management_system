<%-- 
    Document   : billGenerator
    Created on : 10-Mar-2024, 12:37:12 pm
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
        <link rel="stylesheet" href="CSS/billGenerator.css">
        <script src="JS/billGenerator.js" defer></script>
    </head>

    <body>
        <div class="billContainer">
            <c:if test="${process eq 'saleBill'}">
                <div class="billHeader">
                    <div class="billHeader-1">
                        <table>
                            <tr>
                                <td style="background: #007bff; color: white; text-align: center;">Sales No.</td>
                                <td>: <input type="text"></td>
                            </tr>
                            <tr>
                                <td>Sales Name</td>
                                <td>: <input type="text"></td>
                            </tr>
                            <tr>
                                <td>Sales ledger</td>
                                <td>: <input type="text"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="billHeader-2">
                        <label for=""><input type="date"></label>
                    </div>
                </div>
            </c:if>
            <c:if test="${process eq 'purchaseBill'}">
                <div class="billHeader">
                    <div class="billHeader-1">
                        <table>
                            <tr>
                                <td style="background: #007bff; color: white; text-align: center;">Purchase No.</td>
                                <td>: <input type="text"></td>
                            </tr>
                            <tr>
                                <td>Purchase Name</td>
                                <td>: <input type="text"></td>
                            </tr>
                            <tr>
                                <td>Purchase ledger</td>
                                <td>: <input type="text"></td>
                            </tr>
                        </table>
                    </div>
                    <div class="billHeader-2">
                        <label for=""><input type="date"></label>
                    </div>
                </div>
            </c:if>
            <div class="productDetails">
                <div id="invoice-container">
                    <table id="invoice-table" class="productDetails_table">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>unit</th>
                                <th>Rate</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody id="invoice-body" class="invoiceBody">
                            <tr class="inputRow">
                                <td><input type="text" class="product-name"></td>
                                <td><input type="number" class="quantity" oninput="calculateAmount(this)"></td>
                                <td><input type="text" class="unit" ></td>
                                <td><input type="number" class="rate" oninput="calculateAmount(this)"></td>
                                <td><input type="text" class="amount" readonly></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="addCharges">

                </div>
                <div class="billFooter">
                    <div class="billFooter-1">
                        <label for="">Gst</label>
                        <input type="text">
                    </div>
                    <div class="billFooter-2">  
                        <!-- <input type="total" readonly onblur="" id="totalordercost"> -->
                        <p>Total Amount: <span id="total-amount">0.00</span></p>    
                    </div>
                </div>
            </div>

            <div class="billButtons">
                <div>
                    <!--<button>add</button>-->
                    <button>+</button>
                    <button>-</button>
                </div>
                <div>
                    <button onclick="" class="saveButton">Save</button>
                    <button onclick="previewInvoice()" class="priviewButton">PreView</button>
                </div>
            </div>

            <!--            <div class="insert-item" id="insert-item"> 
                            <div class="insert-details">
                                <div class="heading">
                                    <h2 class="">New ITem</h2>
                                    <label for=""onclick="removePopup()">X</label>
                                </div>
                                <iframe src="billPreviewPage.jsp" frameborder="0"></iframe>
                            </div>
                        </div>-->
        </div>

        <script src="JS/previewBill.js"></script>

        <script>
                        function previewInvoice() {
                            const inputRows = document.querySelectorAll('.inputRow');
                            const invoiceData = [];

                            inputRows.forEach(row => {
                                const productName = row.querySelector('.product-name').value;
                                const quantity = row.querySelector('.quantity').value;
                                const unit = row.querySelector('.unit').value;
                                const rate = row.querySelector('.rate').value;

                                if (productName && quantity && unit && rate) {
                                    invoiceData.push({productName, quantity, unit, rate});
                                }
                            });

                            if (invoiceData.length > 0) {
                                localStorage.setItem('invoiceData', JSON.stringify(invoiceData));
                                window.open('billPreviewPage.jsp', '_blank');
                            } else {
                                alert('Please fill in details for at least one product.');
                            }
                        }
        </script>
    </body>
</html>
