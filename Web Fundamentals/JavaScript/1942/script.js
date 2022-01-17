var score = 0;
var hero = {
  x: 300,
  y: 300,
};

var enemies = [
  {
    x: 100,
    y: 10,
  },
  {
    x: 200,
    y: 30,
  },
  {
    x: 300,
    y: 20,
  },
  {
    x: 400,
    y: 40,
  },
  {
    x: 500,
    y: 25,
  },
  {
    x: 600,
    y: 21,
  },
  {
    x: 700,
    y: 13,
  },
];

var bullets = [];

function displayHero() {
  document.getElementById("hero").style.top = hero.y + "px";
  document.getElementById("hero").style.left = hero.x + "px";
}

function displayEnemies() {
  var output = "";
  for (var i = 0; i < enemies.length; i += 2) {
    output +=
      "<div class='enemy1' style='top: " +
      enemies[i].y +
      "px; left: " +
      enemies[i].x +
      "px'></div>";
  }
  for (var i = 1; i < enemies.length; i += 2) {
    output +=
      "<div class='enemy2' style='top: " +
      enemies[i].y +
      "px; left: " +
      enemies[i].x +
      "px'></div>";
  }
  document.getElementById("enemies").innerHTML = output;
}

function displayBullets() {
  var output = "";
  for (var i = 0; i < bullets.length; i++) {
    output +=
      "<div class='bullet' style='top: " +
      bullets[i].y +
      "px; left: " +
      bullets[i].x +
      "px'></div>";
  }
  document.getElementById("bullets").innerHTML = output;
}

function displayScore() {
  document.getElementById("score").innerHTML = score;
}

function moveEnemies() {
  for (var i = 0; i < enemies.length; i++) {
    enemies[i].y += 10;

    if (enemies[i].y > 540) {
      enemies[i].x = Math.random() * 500;
      enemies[i].y = 0;
    }
  }
}

function moveBullets() {
  for (var i = 0; i < bullets.length; i++) {
    bullets[i].y -= 10;

    if (bullets[i].y < 0) {
      bullets.splice(i, 1);
    }
  }
}

function playSound() {
  document.getElementById("hitsound").play();
}

function explode(x, y) {
  document.getElementById("explosion").style.background =
    "url('imgs/1942.gif')";
  document.getElementById("explosion").style.backgroundPosition = "-60px -30px";
  document.getElementById("explosion").style.top = y - 10;
  document.getElementById("explosion").style.left = x;
  setTimeout(function () {
    document.getElementById("explosion").style.background = "none";
  }, 100);
}

function detectCollisions() {
  for (var i = 0; i < bullets.length; i++) {
    for (var j = 0; j < enemies.length; j++) {
      if (
        Math.abs(bullets[i].x - enemies[j].x) < 10 &&
        Math.abs(bullets[i].y - enemies[j].y) < 10
      ) {
        playSound();
        explode(enemies[j].x, enemies[j].y);
        bullets.splice(i, 1);
        enemies.splice(j, 1);
        score += 10;
      }
    }
  }
  for (var i = 0; i < enemies.length; i++) {
    if (Math.abs(enemies[i].x - hero.x) < 30 && enemies[i].y == hero.y) {
      explode(enemies[i].x, enemies[i].y);
      enemies.splice(i, 1);
      score -= 50;
    }
  }
}

function gameLoop() {
  displayHero();
  moveEnemies();
  displayEnemies();
  moveBullets();
  displayBullets();
  detectCollisions();
  displayScore();
}

setInterval(gameLoop, 100);

document.onkeydown = function (e) {
  if (e.key == "ArrowLeft") {
    hero.x -= 10;
  } else if (e.key == "ArrowRight") {
    hero.x += 10;
  } else if (e.key == "ArrowUp") {
    hero.y -= 10;
  } else if (e.key == "ArrowDown") {
    hero.y += 10;
  } else if (e.key == " ") {
    bullets.push({ x: hero.x + 5.5, y: hero.y - 12 });
  }
  displayBullets();
  displayHero();
};

displayHero();
displayEnemies();
