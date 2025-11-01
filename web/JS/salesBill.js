


document.addEventListener("click", function () {

    const invoiceBody = document.getElementById('invoiceBody');

    function updateSrNumbers() {
        const rows = invoiceBody.querySelectorAll('tr');
        rows.forEach(function (row, index) {
            const srNoCell = row.querySelector('td:first-child');
            if (srNoCell) {
                srNoCell.textContent = index + 1;
            }
        });
    }

    updateSrNumbers();
    // Function to create new row when input box is last and Enter is pressed


    function createNewRow(event) {

        moveFocus(event);
        if (event.key === 'Enter') {
            const currentRow = event.target.closest('tr');
            const inputs = currentRow.querySelectorAll('input');
            const currentIndex = Array.from(inputs).indexOf(event.target);
            moveFocus(event);

            if (currentIndex === inputs.length - 1) {
                const nextRow = currentRow.nextElementSibling;
                if (nextRow) {
                    const nextInputs = nextRow.querySelectorAll('input');
                    nextInputs[0].focus(); // Focus on the first input of the next row
                } else {
                    const newRow = currentRow.cloneNode(true);
                    const newInputs = newRow.querySelectorAll('input');
                    newInputs.forEach(input => input.value = ''); // Clear input values in new row



                    if (!currentRow.querySelector('button')) {
                        const removeButton = document.createElement('button');
                        removeButton.textContent = 'X';
                        removeButton.style.color = "red";
                        removeButton.style.background = "none";
                        removeButton.style.border = "none";
                        removeButton.style.fontSize = "20px";
                        removeButton.addEventListener('click', () => {
                            invoiceBody.removeChild(newRow);
                            generateSerialNumber();
                            updateTotal();
                            updateTotalAmt();
                            updateSrNumbers();

                        });
                        const removeCell = document.createElement('td');
                        removeCell.appendChild(removeButton);
                        newRow.appendChild(removeCell);
                    }

                    invoiceBody.appendChild(newRow);
                    newInputs[0].focus(); // Focus on the first input of the new row
                    updateSrNumbers();
                }
            } else {
                inputs[currentIndex + 1].focus(); // Move focus to next input in the same row
            }
        }
    }

    // Add event listeners to input fields
    invoiceBody.addEventListener('keydown', createNewRow);

    // Event listener for remove buttons
    invoiceBody.addEventListener('click', function (event) {
        if (event.target && event.target.tagName === 'BUTTON' && event.target.textContent === 'X') {
            const rowToRemove = event.target.closest('tr');
            invoiceBody.removeChild(rowToRemove);
        }
    });
});


function removeProduct(btn) {
    var row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
    updateTotal();
    updateTotalAmt();
}

function moveFocus(event) {
    const invoiceBody = document.getElementById('invoiceBody');
    const currentInput = event.target;
    const currentCell = currentInput.parentNode;
    const currentRow = currentCell.parentNode;
    const currentIndex = Array.from(currentRow.querySelectorAll('td')).indexOf(currentCell);

    switch (event.key) {
        case "ArrowDown":
            event.preventDefault();
            navigateToAdjacentCell(currentRow.nextElementSibling, currentIndex);
            break;
        case "ArrowUp":
            event.preventDefault();
            navigateToAdjacentCell(currentRow.previousElementSibling, currentIndex);
            break;
        case "ArrowRight":
            navigateToAdjacentCell(currentRow, currentIndex + 1);
            break;
        case "ArrowLeft":
            navigateToAdjacentCell(currentRow, currentIndex - 1);
            break;
    }
}

function calculateAmount(input) {
    var row = input.parentNode.parentNode;
    var quantity = row.getElementsByClassName('quantity')[0].value;
    var rate = row.getElementsByClassName('rate')[0].value;
    var amount = quantity * rate;
    row.getElementsByClassName('amount')[0].value = amount;
    updateTotal();
    updateTotalAmt();
}

function navigateToAdjacentCell(row, index) {
    if (row) {
        const cells = row.querySelectorAll('td');
        if (index >= 0 && index < cells.length) {
            const input = cells[index].querySelector('input');
            if (input) {
                input.focus();
            }
        }
    }
}

function updateTotal() {
    var total = 0;
    var amounts = document.querySelectorAll('.amount');
    for (var i = 0; i < amounts.length; i++) {
        total += parseFloat(amounts[i].value);
    }
    document.getElementById('netAmt').value = total;
    document.getElementById('netAmt').innerText = total;
    updateTotalAmt();
}

function updateTotalAmt() {

    let netAmt = parseFloat(document.getElementById('netAmt').value);
    let gst = parseFloat(document.getElementById('gst').value);
    let discount = parseFloat(document.getElementById('discount').value);
    let freight = parseFloat(document.getElementById('freight').value);
    let totalAmt = netAmt + ((netAmt * gst) / 100) + freight - discount;

    document.getElementById('totalAmt').value = totalAmt;
    document.getElementById('totalAmt').innerText = totalAmt;
}



