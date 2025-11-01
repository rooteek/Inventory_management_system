document.addEventListener("click", function () {
    
  const invoiceBody = document.getElementById('invoice-body');

  // Function to create new row when input box is last and Enter is pressed
  function createNewRow(event) {
    if (event.key === 'Enter') {
      const currentRow = event.target.closest('tr');
      const inputs = currentRow.querySelectorAll('input');
      const currentIndex = Array.from(inputs).indexOf(event.target);

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
            removeButton.textContent = 'x';
            removeButton.style.color = "red";
            removeButton.style.background = "none";
            removeButton.style.border = "none";
            removeButton.style.fontSize = "20px";
            removeButton.addEventListener('click', () => {
              invoiceBody.removeChild(newRow);
              updateTotal();
            });
            const removeCell = document.createElement('td');
            removeCell.appendChild(removeButton);
            newRow.appendChild(removeCell);
          }

          invoiceBody.appendChild(newRow);
          newInputs[0].focus(); // Focus on the first input of the new row
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
    if (event.target && event.target.tagName === 'BUTTON' && event.target.textContent === 'x') {
      const rowToRemove = event.target.closest('tr');
      invoiceBody.removeChild(rowToRemove);
      updateTotal();
    }
  });
});

    
function removeProduct(btn) {
  var row = btn.parentNode.parentNode;
  row.parentNode.removeChild(row);
  updateTotal();
}

function calculateAmount(input) {
  var row = input.parentNode.parentNode;
  var quantity = row.getElementsByClassName('quantity')[0].value;
  var rate = row.getElementsByClassName('rate')[0].value;
  var amount = quantity * rate;
  row.getElementsByClassName('amount')[0].value = amount.toFixed(2);
  updateTotal();
}
function updateTotal() {
  var total = 0;
  var amounts = document.querySelectorAll('.amount');
  for (var i = 0; i < amounts.length; i++) {
    total += parseFloat(amounts[i].value);
  }
  document.getElementById('total-amount').innerText = total.toFixed(2);
}