// object.js

let member1 = {
  fullName: 'Hong',
  age: 20,
  score: 80
};

let member2 = {
  fullName: 'Hwang',
  age: 22,
  score: 88
};

let member3 = {
  fullName: 'Park',
  age: 25,
  score: 92
};

member1.fullName = '홍';

console.log(member1.fullName);
console.log(member1.age + member2.age);

// {key: value}, {key: value}

const members = [member1, member2, member3];
// 홍의 나이는 20이고 점수는 80입니다.

let htmlStr = "";
htmlStr += "<ul>";
for(let mem of members) {
  htmlStr += `<li>${mem.fullName}의 나이는 ${mem.age}이고 점수는 ${mem.score}입니다. </li>`
  // htmlStr += "<li>"+mem.fullName+"의 나이는 "+mem.age+"이고 점수는 "+mem.score+"입니다. </li>";
  // console.log(mem.fullName+"의 나이는 "+mem.age+"이고 점수는 "+mem.score+"입니다.");
}
htmlStr += "</ul>";
document.write(htmlStr);
let welcome = `안녕하세요.
반갑습니다.`;
console.log(welcome);