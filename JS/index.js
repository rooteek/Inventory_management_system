function ajaxCall(method, url, data, destination, isHtml) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            if (isHtml) {
                document.getElementById(destination).innerHTML = this.responseText;
            } else {
                document.getElementById(destination).value = this.responseText;
            }
        }
    };
    xhttp.open(method, url, false);
    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
    xhttp.send(data);
}


function validationCheck() {
    userId = document.getElementById("userId").value;
    password = document.getElementById("password").value;
    department = document.getElementById("department").value;
    ajaxCall("POST", "EmployeeController", "process=loginValidation&userId=" + userId + "&password=" + password + "&department=" + department, "statusAjax", true);
    status = document.getElementById("statusAjax").innerHTML.trim();
    if (status === 'active') {
        if (department == 'admin') {
            window.location.href = "mainPage.jsp";
        }
        if (department == 'sales') {
            window.location.href = "saleMainPage.jsp";
        }
        if (department == 'purchase') {
            window.location.href = "purchaseMainPage.jsp";
        }

        alert("login Successfull...");
    } else if (status === 'inactive') {
        alert("you are not to allow login");
    } else {
        alert("Invalid Username, password , department");
    }
//    return true;
}

//function validationCheck() {
//    name = document.getElementById("username").value;
//    password = document.getElementById("password").value;
//    ajaxCall("POST", "loginController", "username=" + name + "&password=" + password, "ajaax", true);
//    status = document.getElementById("ajaax").innerHTML;
////    alert("user is :" + name + " pas :" + password + " status : " + status)
//    if (status == '1') {
//        alert("login Successfull...");
//        window.location.href = "mainPage.jsp";
//    } else {
//        alert("Id And Password wrong");
//    }
//    return false;
//}


function logoutPage() {
    a = confirm("Do you realy want to logou?");
    if (a) {
        window.location.href = "logoutController";
    }
}

function process(process) {
    ajaxCall("POST", "ProcessController", "process=" + process, "ajaxa", true);
}


function processMethod(process) {
//    alert(process);
    ajaxCall("POST", "dashboardProcessController", "process=" + process, "ajaxCall", true);
}
function profileProcess(process) {
    alert(process);
    ajaxCall("POST", "dashboardProcessController", "process=" + process, "profile_ajax", true);


}

function  redirecPage(process) {
    if (process == 'homePage') {
        window.location.href = "homePage.jsp";
    }
    if (process == 'loginPage') {
        window.location.href = "loginPage.jsp";
    }
    if (process == 'profilePage') {
        window.location.href = "profilePage.jsp";
//        viewProfile('')
    }
}

// -------------------------Pop up Window----------------------
function addPopupScreen(activities) {
    alert(activities);
    document.getElementById("hiddenInput").value = activities;
    if (activities == 'insert') {
        document.getElementById("insert-item").style.display = "block";
//        suggestion('suggestState');
    }
//    if (activities == 'update') {
//        document.getElementById("insert-item2").style.display = "block";
//    }
}
function removePopup(activities) {
    alert(activities)
    if (activities == 'update-x') {
        document.getElementById("insert-item2").style.display = "none";
    }
    if (activities == 'add-x') {

        document.getElementById("insert-item").style.display = "none";
    }

}



// ----------------- Item process Method -----------------
function itemProcessMethod(process) {
//    alert(process);
    ajaxCall("POST", "itemProcessControler", "process=" + process, "ajaxCall", true);
}

function itemDelete(element) {
    id = element.getAttribute("did");
    alert(id);

    conf = confirm("Do you Realy want ot delete the data");
    if (conf) {

    }
}

function getItem(updateId) {
    let uid = updateId.getAttribute('uid');
    alert(uid);
    ajaxCall("POST", "itemProcessControler", "process=getItem&id=" + uid, "getItem", true);
}


// --------------------------- Suggestion ---------------------------
function suggestion(process) {
    if (process === 'suggestCustomer') {
        customerName = document.getElementById('customerName').value;
        cName = customerName.split(" ")[0];
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&cName=' + cName, 'CName', true);
    }
    if (process === 'suggestVendor') {
        vendorName = document.getElementById('vendorName').value;
        vName = vendorName.split(" ")[0];
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&vName=' + vName, 'VName', true);
    }
    if (process === 'suggestProduct') {
        productName = document.getElementsByClassName('productName');
        let index = 0;
        Array.from(productName).forEach(function (element) {
            currentValue = element.value;
            index++;
        });
        pName = currentValue.split(" ")[0];
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&pName=' + pName, 'pName', true);
    }

    if (process === 'suggestState') {
        state = document.getElementById('state').value;
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&stName=' + state, 'state', true);
    }
    if (process === 'suggestCity') {
        state = document.getElementById('state').value;
        city = document.getElementById('city').value;
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&stName=' + state + '&ctName=' + city, 'city', true);
    }

}







//------------- Customer Process -----------------

function CustomerProcessMethod(process) {
//    alert("Tis is CustomerProcessMethod +"+process)
    ajaxCall("POST", "CustomerProcessController", "process=" + process, "ajaxCall", true);

}

function insertCustomerDetials() {
    cutomerName = document.getElementById('cutomerName').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    mobile = document.getElementById('mobile').value;
    gstNo = document.getElementById('gstNo').value;
    bankName = document.getElementById('bankName').value;
    bankNo = document.getElementById('bankNo').value;
    pin = document.getElementById('pin').value;
    mail = document.getElementById('mail').value;
    panNo = document.getElementById('panNo').value;
    registerType = document.getElementById('registerType').value;
    ifscCode = document.getElementById('ifscCode').value;
    alert(state);
    ajaxCall('POST', 'CustomerProcessController', 'process=updateCustomer&cutomerName='
            + cutomerName + '&address=' + address + '&state='
            + state + '&city=' + city + '&mobile=' + mobile +
            '&gstNo=' + gstNo + '&bankName=' + bankName + '&bankNo='
            + bankNo + '&ifscCode=' + ifscCode + '&mail=' + mail + '&panNo=' + panNo + '&registerType=' + registerType + '&pin=' + pin, 'ajaxID', true);
    let status = document.getElementById("ajaxID").innerHTML;
    if (status == 1) {
        alert('Data Inserted Successfully');
        location = 'addCustomerPage.jsp';
    } else {
        alert('Data not Inserted');
    }
}
function updateCustomerData() {
    alert("This is UpdatCustomer");
    cutomerID = document.getElementById('cusomerID').value;
    cutomerName = document.getElementById('cusomerName').value;
    mail = document.getElementById('mail').value;
    mobile = document.getElementById('mobile').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    pin = document.getElementById('pin').value;
    bankName = document.getElementById('bankName').value;
    bankNo = document.getElementById('bankNo').value;
    ifscCode = document.getElementById('ifscCode').value;
    panNo = document.getElementById('panNo').value;
    registerType = document.getElementById('registerType').value;
    gstNo = document.getElementById('gstNo').value;
//    alert(cutomerID);
//    alert(cutomerName);
//    alert(mail);
//    alert(mobile);
//    alert(address);
//    alert(state);
//    alert(city);
//    alert(pin);
//    alert(bankName);
//    alert(bankNo);
//    alert(ifscCode);
//    alert(panNo);
//    alert(registerType);
//    alert(gstNo);
    ajaxCall('POST', 'CustomerProcessController', 'process=updateCustomer&customerId='+cutomerID+
    '&cusomerName='+ cutomerName + '&address=' + address + '&state='
            + state + '&city=' + city + '&mobile=' + mobile +
            '&gstNo=' + gstNo + '&bankName=' + bankName + '&bankNo='
            + bankNo + '&ifscCode=' + ifscCode + '&mail=' + mail + '&panNo=' + panNo +
            '&registerType=' + registerType + '&pin=' + pin, 'UIC', true);

    let status = document.getElementById("UIC").innerHTML;
    if (status == 1) {
        alert("Data Update Sucessfully....")
    } else {
        alert("Something want wrong")
    }
}


function getCustomerDetials(element) {
//    alert(element);
//    let getData = location = "customerUpdatePage.jsp";
    ajaxCall("POST", "CustomerProcessController", "process=getCustomerData&uid=" + element, "getData", true);
    document.getElementById("insert-item2").style.display = "block";
}



function deleteCustomerData(element) {
    let did = element.getAttribute("did");
    alert(did);
    ajaxCall("POST", "CustomerProcessController", "process=deleteCustomerData&did=" + did, "deleteCustomer", true);
    let status = document.getElementById("deleteCustomer").innerHTML;
    if (status == 1) {
        alert("Data Details sucessfulle.");
        CustomerProcessMethod('customer');

    } else {
        alert("There is some erroe.");
    }

}


// ----------------------------------- Vendor -----------------------------------
//function addFormVendor(){
//     ajaxCall('POST','VendorController','process=addFormVendor','ajax',true);
//     suggestion('suggestState');
//}

function viewVendor() {
//    alert("vendor Load ");
    ajaxCall('POST', 'VendorController', 'process=viewVendor', 'ajaxCall', true);
}


function insertVendor() {
    alert("vendor Load ");
//    vendorId = document.getElementById('vendorId').value;
    partyName = document.getElementById('partyName').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    mobileNo = document.getElementById('mobileNo').value;
    gstNo = document.getElementById('gstNo').value;
    nameOnPassbook = document.getElementById('nameOnPassbook').value;
    bankAcNo = document.getElementById('bankAcNo').value;
    ifscCode = document.getElementById('ifscCode').value;
    registrationType = document.getElementById('registrationType').value;
    pan = document.getElementById('pan').value;
    pincode = document.getElementById('pincode').value;
    email = document.getElementById('email').value;

//    alert(partyName);
//    alert(address);
//    alert(state);
//    alert(city);
//    alert(mobileNo);
//    alert(gstNo);
//    alert(nameOnPassbook);
//    alert(bankAcNo);
//    alert(ifscCode);
//    alert(registrationType);
//    alert(pan);
//    alert(pincode);
//    alert(email);

    ajaxCall('POST', 'VendorController', 'process=addVendor&partyName=' + partyName + '&address=' +
            address + '&state=' + state + '&city=' + city + '&mobileNo=' + mobileNo +
            '&gstNo=' + gstNo + '&nameOnPassbook=' + nameOnPassbook + '&bankAcNo=' + bankAcNo +
            '&ifscCode=' + ifscCode + '&registrationType=' + registrationType + '&pan=' + pan +
            '&pincode=' + pincode + '&email=' + email, 'ajaxID', true);

    let status = document.getElementById("ajaxID").innerHTML;
    if (status == 1) {
        alert('Data Inserted Successfully');
        location = 'vendoerAddPage.jsp';
    } else {
        alert('Data not Inserted');
    }
}

function searchVendorById(vendorId) {
    alert(vendorId)
    ajaxCall('POST', 'VendorController', 'process=searchVendor&vendorId=' + vendorId, 'getData', true);
    document.getElementById("insert-item2").style.display = "block";

    suggestion('suggestState');
}

function deleteVendorById(vendorId) {
    ajaxCall('POST', 'VendorController', 'process=deleteVendor&vendorId=' + vendorId, 'ajax', false);
    status = document.getElementById('ajax').innerHTML;
    alert(status);
}

function updateVendor(vendorId) {
//    vendorId = document.getElementById('vendorId').value;
    partyName = document.getElementById('partyName').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    mobileNo = document.getElementById('mobileNo').value;
    gstNo = document.getElementById('gstNo').value;
    nameOnPassbook = document.getElementById('nameOnPassbook').value;
    bankAcNo = document.getElementById('bankAcNo').value;
    ifscCode = document.getElementById('ifscCode').value;
    registrationType = document.getElementById('registrationType').value;
    pan = document.getElementById('pan').value;
    pincode = document.getElementById('pincode').value;
    email = document.getElementById('email').value;

    ajaxCall('POST', 'VendorController', 'process=updateVendor&vendorId=' + vendorId +
            '&partyName=' + partyName + '&address=' + address + '&state=' + state +
            '&city=' + city + '&mobileNo=' + mobileNo + '&gstNo=' + gstNo +
            '&nameOnPassbook=' + nameOnPassbook + '&bankAcNo=' + bankAcNo +
            '&ifscCode=' + ifscCode + "&registrationType=" + registrationType + "&pan=" + pan +
            "&pincode=" + pincode + "&email=" + email, 'uvi', true);
    status = document.getElementById("uvi").innerHTML;
    if (status == 1) {
        alert("Update Successfully")
    } else {
        alert("someing want worng in update")
    }

}


// Category
function addFormCategory(){
     ajaxCall('POST','CategoryController','process=addForm','ajaxCall',true);
}

function viewCategory(){
    ajaxCall('POST','CategoryController','process=view','ajaxCall',true);
}

function addCategory(){
    cateId = document.getElementById('cateId').value;
    cateName = document.getElementById('cateName').value;
    ajaxCall('POST','CategoryController','process=add&cateId='+cateId+'&cateName='+cateName,'ajax',true);
}

function searchCateById(cateId){
    ajaxCall('POST','CategoryController','process=search&cateId='+cateId,'ajax',true);
}

function deleteCateById(cateId){
    ajaxCall('POST','CategoryController','process=delete&cateId='+cateId,'ajax',true);
}

function updateCategory(){
    cateId = document.getElementById('cateId').value;
    cateName = document.getElementById('cateName').value;
    ajaxCall('POST','CategoryController','process=update&cateId='+cateId+'&cateName='+cateName,'ajax',true);   
}


// ---------------------------SAle Bill ----------------------

function addSales() {

    invoiceNo = document.getElementById('invoiceNo').value;
    customerName = document.getElementById('customerName').value;
    billDate = document.getElementById('billDate').value;
    gst = document.getElementById('gst').value;
    freight = document.getElementById('freight').value;
    discount = document.getElementById('discount').value;
    netAmt = document.getElementById('netAmt').value;
    totalAmt = document.getElementById('totalAmt').value;

    const productNameArray = new FormData();
    const productName = document.getElementsByClassName('productName');
    for (let i = 0; i < productName.length; i++) {
        const element = productName[i];
        productNameArray.append('productName[]', element.value);
    }
    let productNameString = '';
    for (const entry of productNameArray.entries()) {
        productNameString += entry[1] + '-'; // Concatenate key-value pairs
    }


    const quantityArray = new FormData();
    const quantity = document.getElementsByClassName('quantity');
    for (let i = 0; i < quantity.length; i++) {
        const element = quantity[i];
        quantityArray.append('quantity[]', element.value);
    }
    let quantityString = '';
    for (const entry of quantityArray.entries()) {
        quantityString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const rateArray = new FormData();
    const rate = document.getElementsByClassName('rate');
    for (let i = 0; i < rate.length; i++) {
        const element = rate[i];
        rateArray.append('rate[]', element.value);
    }
    let rateString = '';
    for (const entry of rateArray.entries()) {
        rateString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const unitArray = new FormData();
    unit = document.getElementsByClassName('unit');
    for (let i = 0; i < unit.length; i++) {
        const element = unit[i];
        unitArray.append('unit[]', element.value);
    }
    let unitString = '';
    for (const entry of unitArray.entries()) {
        unitString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const amountArray = new FormData();
    amount = document.getElementsByClassName('amount');
    for (let i = 0; i < amount.length; i++) {
        const element = amount[i];
        amountArray.append('amount[]', element.value);
    }
    let amountString = '';
    for (const entry of amountArray.entries()) {
        amountString += entry[1] + '-'; // Concatenate key-value pairs
    }

    ajaxCall('POST', 'SalesController', 'process=addSales&invoiceNo=' + invoiceNo + '&customerName=' + customerName + '&billDate=' + billDate + '&gst=' + gst + '&freight=' + freight + '&discount=' + discount + '&netAmt=' + netAmt + '&totalAmt=' + totalAmt + '&productNameArray=' + productNameString + '&quantityArray=' + quantityString + '&rateArray=' + rateString + '&unitArray=' + unitString + '&amountArray=' + amountString, 'ajax', true);

}

function viewAllSales() {
//    alert(process);
    ajaxCall("POST", "SalesController", "process=viewAllSales", "ajaxCall", true);
}

function viewIndividualSale(invoiceNo, process) {
    alert(invoiceNo);
    ajaxCall('POST', 'SalesController', 'process=' + process + '&invoiceNo=' + invoiceNo, 'ajaxCall', true);
//    viewAllSales()
    if (process == 'deleteIndividualSale') {
        viewAllSales()
    }
}

function updateSales() {

    invoiceNo = document.getElementById('invoiceNo').value;
    customerName = document.getElementById('customerName').value;
    billDate = document.getElementById('billDate').value;
    gst = document.getElementById('gst').value;
    freight = document.getElementById('freight').value;
    discount = document.getElementById('discount').value;
    netAmt = document.getElementById('netAmt').textContent.trim();
    totalAmt = document.getElementById('totalAmt').textContent.trim();

    const productNameArray = new FormData();
    const productName = document.getElementsByClassName('productName');
    for (let i = 0; i < productName.length; i++) {
        const element = productName[i];
        productNameArray.append('productName[]', element.value);
    }
    let productNameString = '';
    for (const entry of productNameArray.entries()) {
        productNameString += entry[1] + '-'; // Concatenate key-value pairs
    }


    const quantityArray = new FormData();
    const quantity = document.getElementsByClassName('quantity');
    for (let i = 0; i < quantity.length; i++) {
        const element = quantity[i];
        quantityArray.append('quantity[]', element.value);
    }
    let quantityString = '';
    for (const entry of quantityArray.entries()) {
        quantityString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const rateArray = new FormData();
    const rate = document.getElementsByClassName('rate');
    for (let i = 0; i < rate.length; i++) {
        const element = rate[i];
        rateArray.append('rate[]', element.value);
    }
    let rateString = '';
    for (const entry of rateArray.entries()) {
        rateString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const unitArray = new FormData();
    unit = document.getElementsByClassName('unit');
    for (let i = 0; i < unit.length; i++) {
        const element = unit[i];
        unitArray.append('unit[]', element.value);
    }
    let unitString = '';
    for (const entry of unitArray.entries()) {
        unitString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const amountArray = new FormData();
    amount = document.getElementsByClassName('amount');
    for (let i = 0; i < amount.length; i++) {
        const element = amount[i];
        amountArray.append('amount[]', element.value);
    }
    let amountString = '';
    for (const entry of amountArray.entries()) {
        amountString += entry[1] + '-'; // Concatenate key-value pairs
    }

    ajaxCall('POST', 'SalesController', 'process=updateSales&invoiceNo=' + invoiceNo + '&customerName=' + customerName + '&billDate=' + billDate + '&gst=' + gst + '&freight=' + freight + '&discount=' + discount + '&netAmt=' + netAmt + '&totalAmt=' + totalAmt + '&productNameArray=' + productNameString + '&quantityArray=' + quantityString + '&rateArray=' + rateString + '&unitArray=' + unitString + '&amountArray=' + amountString, 'ajax', true);

}
// -----------------------Purchase Bill------------------------
function addFormPurchase() {
    ajaxCall('POST', 'PurchaseController', 'process=addFormPurchase', 'ajaxCall', true);
}

function addPurchase() {

    invoiceNo = document.getElementById('invoiceNo').value;
    vendorName = document.getElementById('vendorName').value;
    billDate = document.getElementById('billDate').value;
    gst = document.getElementById('gst').value;
    freight = document.getElementById('freight').value;
    discount = document.getElementById('discount').value;
    netAmt = document.getElementById('netAmt').value;
    totalAmt = document.getElementById('totalAmt').value;

    const productNameArray = new FormData();
    const productName = document.getElementsByClassName('productName');
    for (let i = 0; i < productName.length; i++) {
        const element = productName[i];
        productNameArray.append('productName[]', element.value);
    }
    let productNameString = '';
    for (const entry of productNameArray.entries()) {
        productNameString += entry[1] + '-'; // Concatenate key-value pairs
    }


    const quantityArray = new FormData();
    const quantity = document.getElementsByClassName('quantity');
    for (let i = 0; i < quantity.length; i++) {
        const element = quantity[i];
        quantityArray.append('quantity[]', element.value);
    }
    let quantityString = '';
    for (const entry of quantityArray.entries()) {
        quantityString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const rateArray = new FormData();
    const rate = document.getElementsByClassName('rate');
    for (let i = 0; i < rate.length; i++) {
        const element = rate[i];
        rateArray.append('rate[]', element.value);
    }
    let rateString = '';
    for (const entry of rateArray.entries()) {
        rateString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const unitArray = new FormData();
    unit = document.getElementsByClassName('unit');
    for (let i = 0; i < unit.length; i++) {
        const element = unit[i];
        unitArray.append('unit[]', element.value);
    }
    let unitString = '';
    for (const entry of unitArray.entries()) {
        unitString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const amountArray = new FormData();
    amount = document.getElementsByClassName('amount');
    for (let i = 0; i < amount.length; i++) {
        const element = amount[i];
        amountArray.append('amount[]', element.value);
    }
    let amountString = '';
    for (const entry of amountArray.entries()) {
        amountString += entry[1] + '-'; // Concatenate key-value pairs
    }

    ajaxCall('POST', 'PurchaseController', 'process=addPurchase&invoiceNo=' + invoiceNo + '&vendorName=' + vendorName + '&billDate=' + billDate + '&gst=' + gst + '&freight=' + freight + '&discount=' + discount + '&netAmt=' + netAmt + '&totalAmt=' + totalAmt + '&productNameArray=' + productNameString + '&quantityArray=' + quantityString + '&rateArray=' + rateString + '&unitArray=' + unitString + '&amountArray=' + amountString, 'ajax', true);

}

function viewAllPurchase() {
    ajaxCall('POST', 'PurchaseController', 'process=viewAllPurchase', 'ajaxCall', true);
}

function viewIndividualPurchase(invoiceNo, process) {
    ajaxCall('POST', 'PurchaseController', 'process=' + process + '&invoiceNo=' + invoiceNo, 'ajaxCall', true);
}

function updatePurchase() {

    invoiceNo = document.getElementById('invoiceNo').value;
    vendorName = document.getElementById('vendorName').value;
    billDate = document.getElementById('billDate').value;
    gst = document.getElementById('gst').value;
    freight = document.getElementById('freight').value;
    discount = document.getElementById('discount').value;
    netAmt = document.getElementById('netAmt').value;
    totalAmt = document.getElementById('totalAmt').value;

    const productNameArray = new FormData();
    const productName = document.getElementsByClassName('productName');
    for (let i = 0; i < productName.length; i++) {
        const element = productName[i];
        productNameArray.append('productName[]', element.value);
    }
    let productNameString = '';
    for (const entry of productNameArray.entries()) {
        productNameString += entry[1] + '-'; // Concatenate key-value pairs
    }


    const quantityArray = new FormData();
    const quantity = document.getElementsByClassName('quantity');
    for (let i = 0; i < quantity.length; i++) {
        const element = quantity[i];
        quantityArray.append('quantity[]', element.value);
    }
    let quantityString = '';
    for (const entry of quantityArray.entries()) {
        quantityString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const rateArray = new FormData();
    const rate = document.getElementsByClassName('rate');
    for (let i = 0; i < rate.length; i++) {
        const element = rate[i];
        rateArray.append('rate[]', element.value);
    }
    let rateString = '';
    for (const entry of rateArray.entries()) {
        rateString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const unitArray = new FormData();
    unit = document.getElementsByClassName('unit');
    for (let i = 0; i < unit.length; i++) {
        const element = unit[i];
        unitArray.append('unit[]', element.value);
    }
    let unitString = '';
    for (const entry of unitArray.entries()) {
        unitString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const amountArray = new FormData();
    amount = document.getElementsByClassName('amount');
    for (let i = 0; i < amount.length; i++) {
        const element = amount[i];
        amountArray.append('amount[]', element.value);
    }
    let amountString = '';
    for (const entry of amountArray.entries()) {
        amountString += entry[1] + '-'; // Concatenate key-value pairs
    }

    ajaxCall('POST', 'PurchaseController', 'process=updatePurchase&invoiceNo=' + invoiceNo + '&vendorName=' + vendorName + '&billDate=' + billDate + '&gst=' + gst + '&freight=' + freight + '&discount=' + discount + '&netAmt=' + netAmt + '&totalAmt=' + totalAmt + '&productNameArray=' + productNameString + '&quantityArray=' + quantityString + '&rateArray=' + rateString + '&unitArray=' + unitString + '&amountArray=' + amountString, 'ajax', true);

}


// --------------------------------------Expenses--------------------------------------
function addFormExpenses() {
    ajaxCall('POST', 'ExpensesController', 'process=addFormExpenses', 'ajaxCall', true);
}

function addExpenses() {

    invoiceNo = document.getElementById('invoiceNo').value;
    expenseName = document.getElementById('expenseName').value;
    billDate = document.getElementById('billDate').value;
    gst = document.getElementById('gst').value;
    freight = document.getElementById('freight').value;
    discount = document.getElementById('discount').value;
    netAmt = document.getElementById('netAmt').value;
    totalAmt = document.getElementById('totalAmt').value;

    const productNameArray = new FormData();
    const productName = document.getElementsByClassName('productName');
    for (let i = 0; i < productName.length; i++) {
        const element = productName[i];
        productNameArray.append('productName[]', element.value);
    }
    let productNameString = '';
    for (const entry of productNameArray.entries()) {
        productNameString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const amountArray = new FormData();
    amount = document.getElementsByClassName('amount');
    for (let i = 0; i < amount.length; i++) {
        const element = amount[i];
        amountArray.append('amount[]', element.value);
    }
    let amountString = '';
    for (const entry of amountArray.entries()) {
        amountString += entry[1] + '-'; // Concatenate key-value pairs
    }

    ajaxCall('POST', 'ExpensesController', 'process=addExpenses&invoiceNo=' + invoiceNo + '&expenseName=' + expenseName + '&billDate=' + billDate + '&gst=' + gst + '&freight=' + freight + '&discount=' + discount + '&netAmt=' + netAmt + '&totalAmt=' + totalAmt + '&productNameArray=' + productNameString + '&amountArray=' + amountString, 'ajax', true);

}

function viewAllExpenses() {
    ajaxCall('POST', 'ExpensesController', 'process=viewAllExpenses', 'ajaxCall', true);
}

function viewIndividualExpenses(invoiceNo, process) {
    ajaxCall('POST', 'ExpensesController', 'process=' + process + '&invoiceNo=' + invoiceNo, 'ajaxCall', true);
}

function updateExpenses() {

    const invoiceNo = document.getElementById('invoiceNo').value;
    const expenseName = document.getElementById('expenseName').value;
    const billDate = document.getElementById('billDate').value;
    const gst = document.getElementById('gst').value;
    const freight = document.getElementById('freight').value;
    const discount = document.getElementById('discount').value;
    const netAmt = document.getElementById('netAmt').textContent;
    const totalAmt = document.getElementById('totalAmt').textContent;

    alert(totalAmt);

    const productNameArray = new FormData();
    const productName = document.getElementsByClassName('productName');
    for (let i = 0; i < productName.length; i++) {
        const element = productName[i];
        productNameArray.append('productName[]', element.value);
    }
    let productNameString = '';
    for (const entry of productNameArray.entries()) {
        productNameString += entry[1] + '-'; // Concatenate key-value pairs
    }

    const amountArray = new FormData();
    amount = document.getElementsByClassName('amount');
    for (let i = 0; i < amount.length; i++) {
        const element = amount[i];
        amountArray.append('amount[]', element.value);
    }
    let amountString = '';
    for (const entry of amountArray.entries()) {
        amountString += entry[1] + '-'; // Concatenate key-value pairs
    }

    ajaxCall('POST', 'ExpensesController', 'process=updateExpenses&invoiceNo=' + invoiceNo + '&expenseName=' + expenseName + '&billDate=' + billDate + '&gst=' + gst + '&freight=' + freight + '&discount=' + discount + '&netAmt=' + netAmt + '&totalAmt=' + totalAmt + '&productNameArray=' + productNameString + '&amountArray=' + amountString, 'ajax', true);

}









// ------------------- Old Code --------------------

function deleteData(elemenet) {
    id = elemenet.getAttribute("did");
    alert(id)
    ajaxCall("POST", "ProcessController", "process=dell&id=" + id, "DataDelete", true)
    status = document.getElementById("DataDelete").innerHTML
    if (status == '1') {
        alert("Data Successfull Deleted");
        process('delete')
    }
}

function insertData() {
    name = document.getElementById("name").value;
    email = document.getElementById("email").value;
    password = document.getElementById("password").value;
    mobile = document.getElementById("mobile").value;
    address = document.getElementById("address").value;

    ajaxCall("POST", "ProcessController", "process=intData&name=" + name + "&email=" + email + "&password=" + password + "&mobile=" + mobile + "&address=" + address, "DataInsert", true)
    status = document.getElementById("DataInsert").innerHTML;
    if (status == '1') {
        alert("Data insert Successfullly...");
        process('delete');
    } else {
        alert("Data not insert Successfully....");
    }
    return false;
}


//----------------//Profile--------------------

function viewProfile(process) {
    ajaxCall('POST', 'ProfileController', 'process=' + process, 'ajaxCall', true);
    suggestion('suggestState');
}
function updateProfile() {
    empFullName = document.getElementById('empFullName').value;
    birthDate = document.getElementById('birthDate').value;
    gender = document.getElementById('gender').value;
    phoneNo = document.getElementById('phoneNo').value;
    email = document.getElementById('email').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    pincode = document.getElementById('pincode').value;

    ajaxCall('POST', 'ProfileController', 'process=updateProfile&empFullName=' + empFullName + '&birthDate=' + birthDate + '&gender=' + gender + '&phoneNo=' + phoneNo + '&email=' + email + '&address=' + address + '&state=' + state + '&city=' + city + '&pincode=' + pincode, 'ajax', true);

}

function changePasswordForm() {
    ajaxCall('POST', 'ProfileController', 'process=changePasswordForm', 'ajaxCall', true);
}

function changePassword() {
    oldPswd = document.getElementById('oldPswd').value;
    newPswd = document.getElementById('newPswd').value;
    conNewPswd = document.getElementById('conNewPswd').value;
    if (conNewPswd === newPswd) {
        ajaxCall('POST', 'ProfileController', 'process=changePassword&password=' + oldPswd + '&newPswd=' + newPswd, 'ajaxCall', true);
        alert("Password Changed");
    } else {
        alert("New Password and Confirm Password is not same.");
    }
}


// ------------------- Employee ------------------

//Employee
function addFormEmployee() {
    ajaxCall('POST', 'EmployeeController', 'process=addFormEmployee', 'ajax', true);
    suggestion('suggestState');
}

function viewEmployee() {
    ajaxCall('POST', 'EmployeeController', 'process=viewEmployee', 'ajax', true);
}

function addEmployee() {
    alert("Insert Employee  Method")
    empFullName = document.getElementById('empFullName').value;
    birthDate = document.getElementById('birthDate').value;
    gender = document.getElementById('gender').value;
    phoneNo = document.getElementById('phoneNo').value;
    email = document.getElementById('email').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    pincode = document.getElementById('pincode').value;
    joiningDate = document.getElementById('joiningDate').value;
    userId = document.getElementById('userId').value;
    password = document.getElementById('password').value;
    department = document.getElementById('department').value;
    status = document.getElementById('status').value;
    ajaxCall('POST', 'EmployeeController', 'process=addEmployee&empFullName=' + empFullName + '&birthDate=' + birthDate + '&gender=' + gender + '&phoneNo=' + phoneNo + '&email=' + email + '&address=' + address + '&state=' + state + '&city=' + city + '&pincode=' + pincode + '&joiningDate=' + joiningDate + '&userId=' + userId + '&password=' + password + '&department=' + department + '&status=' + status, 'ajax', true);

    alert("Process Complete");
}

function viewIndividualEmp(userId, process) {
    ajaxCall('POST', 'EmployeeController', 'process=' + process + '&userId=' + userId, 'ajax', true);
    suggestion('suggestState');
}

function updateEmployee() {
    empFullName = document.getElementById('empFullName').value;
    birthDate = document.getElementById('birthDate').value;
    gender = document.getElementById('gender').value;
    phoneNo = document.getElementById('phoneNo').value;
    email = document.getElementById('email').value;
    address = document.getElementById('address').value;
    state = document.getElementById('state').value;
    city = document.getElementById('city').value;
    pincode = document.getElementById('pincode').value;
    joiningDate = document.getElementById('joiningDate').value;
    userId = document.getElementById('userId').value;
    password = document.getElementById('password').value;
    department = document.getElementById('department').value;
    status = document.getElementById('status').value;
    ajaxCall('POST', 'EmployeeController', 'process=updateEmployee&empFullName=' + empFullName + '&birthDate=' + birthDate + '&gender=' + gender + '&phoneNo=' + phoneNo + '&email=' + email + '&address=' + address + '&state=' + state + '&city=' + city + '&pincode=' + pincode + '&joiningDate=' + joiningDate + '&userId=' + userId + '&password=' + password + '&department=' + department + '&status=' + status, 'ajax', true);
}


//Suggestion
function suggestion(process) {
//    alert(process);
    if (process === 'suggestCustomer') {
        customerName = document.getElementById('customerName').value;
        cName = customerName.split(" ")[0];
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&cName=' + cName, 'CName', true);
    }
    if (process === 'suggestVendor') {
        vendorName = document.getElementById('vendorName').value;
        vName = vendorName.split(" ")[0];
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&vName=' + vName, 'VName', true);
    }
    if (process === 'suggestProduct') {
        productName = document.getElementsByClassName('productName');
        let index = 0;
        Array.from(productName).forEach(function (element) {
            currentValue = element.value;
            index++;
        });
        pName = currentValue.split(" ")[0];
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&pName=' + pName, 'pName', true);
    }

    if (process === 'suggestState') {
//        state = document.getElementById('state').value;
        ajaxCall('POST', 'SugesstionController', 'process=' + process, 'state', true);
    }
    if (process === 'suggestCity') {
        state = document.getElementById('state').value;
        city = document.getElementById('city').value;
        ajaxCall('POST', 'SugesstionController', 'process=' + process + '&stName=' + state + '&ctName=' + city, 'city', true);
    }

    if (process === 'suggestCategory') 
    {
        
            ajaxCall('POST', 'SugesstionController', 'process=' + process, 'unitName', true);
        }
}
