<%-- 
    Document   : billPreviewPage
    Created on : 28-Mar-2024, 4:02:32 pm
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- <link rel="stylesheet" href="style.css"> -->
        <link rel="stylesheet" href="CSS/billPreviewPage.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <title>Preview</title>
    </head>

    <body>
        <div class="previewBill_contaier">
            <h2>INVOICE</h2>
            <div class="preview_bill_heading">
                <div class="preview_bill_info">
                    <div class="preview_bill_company_details">
                        <h3>In2 man</h3>
                        <h4>Company Profesion</h4>
                        <p>44 vijya nagar, udhna <br>surat-394210 Gujarat</p>
                        <p>E-Mail : CompanyMailId@mail.com</p>
                    </div>
                    <div class="preview_bill_customer_details">
                        <h3>Customer</h3>
                        <h4>Customer Name</h4>
                        <p>Customer Address</p>
                    </div>
                </div>
                <div class="preview_bill_info2">
                    <div class="bill_no preview_bill_info2_div">
                        Invoice No.
                        <p>1</p>
                    </div>
                    <div class="bill_date preview_bill_info2_div">
                        Dated
                        <p>01/01/2023</p>
                    </div>
                    <div class="bill_payment_mode preview_bill_info2_div">
                        Mode/ Terms of Payment
                        <input type="text">
                    </div>
                    <div class="bill_reference preview_bill_info2_div">
                        Reference No & Date.
                        <p>001</p>
                    </div>
                    <div class="bill_reference preview_bill_info2_div">
                        Dispatched Through
                        <p>001</p>
                    </div>
                    <div class="bill_reference preview_bill_info2_div">
                        Delivery Note Date
                        <input type="date">
                    </div>
                    <div class="team_of_delivery preview_bill_info2_div">
                        Teams of Delivery
                        <textarea name="" id="" cols="30" rows="4"></textarea>
                    </div>
                </div>
            </div>
            <div class="preview_bill_details">
                <table id="invoiceDetails">
                    <thead>
                        <tr>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Unit</th>
                            <th>Rate</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <tbody id="invoiceBody" class="preview_bill_table_body"></tbody>
                </table>
            </div>
            <div class="preview_bill_footer">
                <div class="bill_discription">
                    <p>Remarks:</p>
                    <h4>this is discrition</h4>
                </div>
                <div class="bill_backDetails">
                    <p>Compnay's Bank Details</p>
                    <p>A/c Holder's Name : <b>Bank Holder Name</b></p>
                    <p>Bank Name : <b>Bank name</b></p>
                    <p>A/c No. <b>799837293872937</b></p>
                    <p>IFCI Code :<b>IFCI Code</b></p>
                    <div class="bill_sign">
                        Authorised Signatory
                    </div>
                </div>
            </div>
            <button class="bill_print" title="print" onclick="window.print()" id="printButton"><i class='bx bx-printer'></i></button>
        </div>
        <script src="JS/previewBill.js"></script>
    </body>
</html>


