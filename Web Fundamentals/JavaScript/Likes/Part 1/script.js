var likesNum = document.querySelector("span");
var count = 0;
function addLike() {
  count++;
  likesNum.innerText = `${count} Like(s)`;
}
