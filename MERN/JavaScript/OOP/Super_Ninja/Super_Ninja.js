class Ninja {
  constructor(name) {
    this.name = name;
    this.health = 60;
    this.speed = 3;
    this.strength = 3;
  }

  sayName() {
    console.log(this.name);
  }

  showStats() {
    console.log(`Name: ${this.name}`);
    console.log(`Strength: ${this.strength}`);
    console.log(`Speed: ${this.speed}`);
    console.log(`Health: ${this.health}`);
  }

  drinkSake() {
    this.health += 10;
  }
}

class Sensei extends Ninja {
  constructor(name) {
    super(name);
    this.wisdom = 10;
    this.health = 200;
    this.speed = 10;
    this.strength = 10;
  }

  speakWisdom() {
    this.drinkSake();
    console.log("This is a wise message!");
  }
}

const sensei1 = new Sensei("Sanad");
sensei1.showStats();
sensei1.speakWisdom();
sensei1.showStats();
