var connectionRequests = 2;
var yourConnections = 500;

function changeName() {
  var a = prompt("Enter the name");
  if (a != "") {
    document.querySelector(".personaldetails h2").innerText = a;
  }
}

function removeRequest(element) {
  element.parentElement.parentElement.remove();
  connectionRequests--;
  document.querySelector(".sidebar .number").innerText = connectionRequests;
  if (element.alt == "accept") {
    yourConnections++;
    document.querySelector(".connections .number").innerText = yourConnections;
  }
}
