function changeText(element) {
  if (element.innerText == "Login") {
    element.innerText = "Logout";
  } else {
    element.innerText = "Login";
  }
}

function hideButton(element) {
  element.remove();
}

function showAlert() {
  alert("Ninja was liked");
}
