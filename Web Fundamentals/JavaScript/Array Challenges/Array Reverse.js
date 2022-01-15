function reverse(arr) {
  var tempArr = [];
  for (var i = arr.length - 1; i >= 0; i--) {
    tempArr.push(arr[i]);
  }
  arr = tempArr;
  return arr;
}

var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // we expect back ["e", "d", "c", "b", "a"]
