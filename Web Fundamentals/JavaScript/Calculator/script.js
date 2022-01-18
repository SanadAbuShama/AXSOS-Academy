var operation = "";
var firstNum = "";
var secondNum = "";

var displayDiv = document.querySelector("#display");

// Set numbers and display

function press(input) {
  if (operation == "") {
    firstNum += input;
    displayDiv.innerText = firstNum;
  } else {
    secondNum += input;
    displayDiv.innerText = secondNum;
  }
}

// Set mathematical operation

function setOP(operationInput) {
  operation = operationInput;
}

// Clear all values

function clr() {
  firstNum = "";
  secondNum = "";
  operation = "";
  displayDiv.innerText = 0;
}

// Calculate the result based on the operation and display it

function calculate() {
  var result = 0;

  if (firstNum != "") {
    result = firstNum;
  }
  if (secondNum != "" && operation != "") {
    if (operation == "+") {
      result = parseFloat(firstNum) + parseFloat(secondNum);
    } else if (operation == "-") {
      result = parseFloat(firstNum) - parseFloat(secondNum);
    } else if (operation == "*") {
      result = parseFloat(firstNum) * parseFloat(secondNum);
    } else if (operation == "/") {
      result = parseFloat(firstNum) / parseFloat(secondNum);
    }
  }
  displayDiv.innerText = result;
  firstNum = result;
  secondNum = "";
}
