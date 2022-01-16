function getHoursMinutesSeconds() {
  return [
    new Date().getSeconds(),
    new Date().getMinutes(),
    new Date().getHours(),
  ];
}

setInterval(function () {
  var time = getHoursMinutesSeconds();
  var secondsDegrees = (time[0] / 60) * 360;
  var minutesDegrees = (time[1] / 60) * 360;
  var hourDegrees = ((time[2] / 12) * 360) % 360;

  document.querySelector("#seconds").style.transform = `rotate(${
    secondsDegrees + 180
  }deg)`;
  document.querySelector("#minutes").style.transform = `rotate(${
    minutesDegrees + 180
  }deg)`;
  document.querySelector("#hour").style.transform = `rotate(${
    hourDegrees + 180
  }deg)`;
}, 1000);
