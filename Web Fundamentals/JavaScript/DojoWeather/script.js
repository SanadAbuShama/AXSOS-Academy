var tempCels = [];
for (var i = 0; i < 8; i++) {
  tempCels.push(parseInt(document.getElementById(`temp${i}`).innerText));
}
console.log(tempCels);
function weatherReport() {
  alert("Loading weather report...");
}

function changeCursor(element) {
  element.style.cursor = "pointer";
}

function changeTemp(element) {
  if (element.value == "fah") {
    for (var i = 0; i < tempCels.length; i++) {
      document.getElementById(`temp${i}`).innerText =
        Math.floor(tempCels[i] * (9 / 5) + 32) + "°";
    }
  } else {
    for (var i = 0; i < tempCels.length; i++) {
      document.getElementById(`temp${i}`).innerText = tempCels[i] + "°";
    }
  }
}

function removeMessage(element) {
  element.parentElement.remove();
}
