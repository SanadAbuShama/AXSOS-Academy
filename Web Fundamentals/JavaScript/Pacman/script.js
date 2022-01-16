// Variables

var world = [
  [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 3, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 3, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 3, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 3, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2],
  [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2],
  [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2],
];

var pacman = {
  x: 1,
  y: 1,
};

var ghost = {
  x: 10,
  y: 10,
};

var score = 0;

// Functions

function displayWorld() {
  var output = "";
  for (var i = 0; i < world.length; i++) {
    output += "\n<div class='row'>\n";
    for (var j = 0; j < world[i].length; j++) {
      if (world[i][j] == 2) {
        output += "<div class='brick'></div>";
      } else if (world[i][j] == 1) {
        output += "<div class='coin'></div>";
      } else if (world[i][j] == 3) {
        output += "<div class='cherry'></div>";
      }
      if (world[i][j] == 0) {
        output += "<div class='empty'></div>";
      }
    }
    output += "\n</div>";
  }
  //console.log(output);
  document.getElementById("world").innerHTML = output;
}

function displayPacman() {
  document.getElementById("pacman").style.left = `${pacman.x * 20}px`;
  document.getElementById("pacman").style.top = `${pacman.y * 20}px`;
}
function displayGhost() {
  document.getElementById("ghost").style.left = `${ghost.x * 20}px`;
  document.getElementById("ghost").style.top = `${ghost.y * 20}px`;
}
function displayScore() {
  document.getElementById("score").innerText = score;
}

function endGame() {
  document.getElementById("gameover").innerText = "Game Over Pacman is Dead :(";
  document.getElementById("pacman").id = "";
}

function moveGhost() {
  var num = Math.floor(Math.random() * 4) + 1;
  if (num == 1 && world[ghost.y][ghost.x + 1] != 2) {
    ghost.x++;
  }
  if (num == 2 && world[ghost.y][ghost.x - 1] != 2) {
    ghost.x--;
  }
  if (num == 3 && world[ghost.y + 1][ghost.x] != 2) {
    ghost.y++;
  }
  if (num == 4 && world[ghost.y - 1][ghost.x] != 2) {
    ghost.y--;
  }
  if (ghost.x == pacman.x && ghost.y == pacman.y) {
    endGame();
  }
  displayGhost();
}

document.onkeydown = function movePacman(e) {
  if (e.key == "ArrowRight" && world[pacman.y][pacman.x + 1] != 2) {
    pacman.x++;
    document.getElementById("pacman").style.transform = `rotate(0deg)`;
  } else if (e.key == "ArrowLeft" && world[pacman.y][pacman.x - 1] != 2) {
    pacman.x--;
    document.getElementById("pacman").style.transform = `rotate(180deg)`;
  } else if (e.key == "ArrowUp" && world[pacman.y - 1][pacman.x] != 2) {
    pacman.y--;
    document.getElementById("pacman").style.transform = `rotate(270deg)`;
  } else if (e.key == "ArrowDown" && world[pacman.y + 1][pacman.x] != 2) {
    pacman.y++;
    document.getElementById("pacman").style.transform = `rotate(90deg)`;
  }
  if (world[pacman.y][pacman.x] == 1) {
    world[pacman.y][pacman.x] = 0;
    score += 10;
  } else if (world[pacman.y][pacman.x] == 3) {
    world[pacman.y][pacman.x] = 0;
    score += 50;
  }
  if (world[pacman.y][pacman.x] == world[ghost.y][ghost.x]) {
    endGame();
  }
  displayScore();
  displayWorld();
  displayPacman();
};

setInterval(moveGhost, 1000);

displayWorld();
displayPacman();
displayScore();
displayGhost();
