var myNum: number = 5;
var myString: string = "Hello Universe";
var anythingOne: string = "Hey";
anythingOne = "25";
var anythingTwo: string = "Hey";
anythingTwo = "[1, 2, 3, 4]";
var anythingThree: string = "Hey";
anythingThree = "{ x: 1, y: 2 }";
// There are two ways of declaring an array type
var arrayNumbersOne: number[] = [1, 2, 3, 4, 5, 6];
var arrayNumbersTwo: Array<number> = [1, 2, 3, 4, 5, 6];
var myObj: object = { x: 5, y: 10 };
// function constructor
var MyNode = (function () {
  function MyNode(val: number): void {
    this.val = 0;
    this.val = val;
  }
  MyNode.prototype.doSomething = function (): void {
    this._priv = 10;
  };
  return MyNode;
})();
var myNodeInstance = new MyNode(1);
console.log(myNodeInstance.val);
// This function will return nothing.
function myFunction(): void {
  console.log("Hello World");
}
