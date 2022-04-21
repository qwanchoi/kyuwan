// variable.js

var myName = 'CKW'; // string

// var yourName; // undefined

console.log(typeof myName);

myName = 100; // number
console.log(typeof myName);

myName = true; // boolean
console.log(typeof myName);

myName = null; // object
console.log(typeof myName);

console.log("=================================");

console.log(typeof yourName); // js 는 var 형태 변수는 최상위에 생성됨
var yourName = "홍길통";
console.log(typeof yourName);

// 전역변수(스크립트변수), 지역변수(함수안에서 변수)

function checkInfo() {
  var myName = "ChoiKW";
  console.log(myName);
}
checkInfo();
console.log(myName);

// ES6 (ES2015) => let, const
// let 블럭레벨 변수선언.

// let myName = 'Hong'; // 동일명 변수이름 에러출력
function info() {
  let myName = "Hong";
  console.log(myName);
}
info();

{
  let myName = "Hong";
  console.log(myName);
}

{
  let myName = "Hwang";
  console.log(myName);
}

const otherName = "Hong";
// otherName = "Hwang";

// var, et => 변수선언.
// const => 상수선언.
