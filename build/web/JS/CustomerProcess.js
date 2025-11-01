//function ajaxCall(method, url, data, destination, isHtml) {
//    var xhttp = new XMLHttpRequest();
//    xhttp.onreadystatechange = function () {
//        if (this.readyState == 4 && this.status == 200) {
//            if (isHtml) {
//                document.getElementById(destination).innerHTML = this.responseText;
//            } else {
//                document.getElementById(destination).value = this.responseText;
//            }
//        }
//    };
//    xhttp.open(method, url, false);
//    xhttp.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
//    xhttp.send(data);
//}
//
//
