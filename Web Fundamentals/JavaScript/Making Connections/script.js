var connectionRequests = 2;
var yourConnections = 500;

function changeName() {
  document.querySelector(".personaldetails h2").innerText = "Sanad Abu Shama";
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
