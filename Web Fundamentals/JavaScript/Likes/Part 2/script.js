var likes = [9, 12, 9];

function addLike(element) {
  if (element.id == "first") {
    likes[0]++;
    document.querySelector("section:first-of-type span").innerText =
      likes[0] + " Likes(s)";
  } else if (element.id == "second") {
    likes[1]++;
    document.querySelector("section:nth-of-type(2) span").innerText =
      likes[1] + " Likes(s)";
  } else if (element.id == "third") {
    likes[2]++;
    document.querySelector("section:last-of-type span").innerText =
      likes[2] + " Likes(s)";
  }
}
