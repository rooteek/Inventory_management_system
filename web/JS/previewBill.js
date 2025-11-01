document.addEventListener('DOMContentLoaded', function () {
    const invoiceData = JSON.parse(localStorage.getItem('invoiceData'));
    const invoiceBody = document.getElementById('invoiceBody');

    if (invoiceData && invoiceData.length > 0) {
        let totalAmount = 0;

        invoiceData.forEach(item => {
            const amount = item.quantity * item.rate;
            totalAmount += amount;

            const detailRow = document.createElement('tr');
            detailRow.className = "bill_table_row";
            detailRow.innerHTML = `
                <td>${item.productName}</td>
                <td>${item.quantity}</td>
                <td>${item.unit}</td>
                <td>${item.rate}</td>
                <td>${amount}</td>
            `;
            invoiceBody.appendChild(detailRow);
        });

        const totalRow = document.createElement('tr');
        totalRow.className = "bill_table_total_row";
        totalRow.innerHTML = `
            <td colspan="4">Total:</td>
            <td>${totalAmount}</td>
        `;
        invoiceBody.appendChild(totalRow);
    } else {
        invoiceBody.innerHTML = '<tr><td colspan="5">No invoice data found!</td></tr>';
    }
});



function previewInvoice() {
    const inputRows = document.querySelectorAll('.inputRow');
    const invoiceData = [];

    inputRows.forEach(row => {
        const productName = row.querySelector('.productName').value;
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


//function previewInvoice() {
//    const inputRows = document.querySelectorAll('.inputRow');
//    const invoiceData = [];
//
//    inputRows.forEach(row => {
//        const productName = row.querySelector('.product-name').value;
//        const quantity = row.querySelector('.quantity').value;
//        const unit = row.querySelector('.unit').value;
//        const rate = row.querySelector('.rate').value;
//
//        if (productName && quantity && unit && rate) {
//            invoiceData.push({productName, quantity, unit, rate});
//        }
//    });
//
//    if (invoiceData.length > 0) {
//        localStorage.setItem('invoiceData', JSON.stringify(invoiceData));
//        window.open('billPreviewPage.jsp', '_blank');
//    } else {
//        alert('Please fill in details for at least one product.');
//    }
//}
//function printInvoice() {
//    window.print(); // Trigger browser's print dialog
//}