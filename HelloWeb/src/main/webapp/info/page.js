// page.js
console.log(member1);

let field = 'fullName';
console.log(member1.fullName);
console.log(member2['fullName']);
console.log(member3[field]);

// 배열요소를 반복적으로 for..of
for (let member of members) {
  console.log(`이름은 ${member['fullName']}이고 나이는 ${member['age']} 점수는 ${member['score']}`);
}

// 오브젝트의 속성(필드)을 반복적으로 for..in
for(let fieldName in member1) {
  console.log(`${fieldName} => ${member1[fieldName]}`);
}

// 각 배열요소의 각 필드를 출력.
for(let member of members) {
  for(let fieldName in member) {
    console.log(`${fieldName} => ${member[fieldName]}`);
  }
  console.log("----------------------------");
}

document.write('<table border=1>');
let fields = ['score', 'age', 'fullName']; // 선택적으로 필드 출력
document.write('<tr>');
for(let prop of fields) { 
  document.write(`<th>${prop} </th>`); 
}
document.write('<th>전송</th>')
document.write('</tr>');
for(let member of members) {
  document.write('<tr>')
  for(let prop of fields) {
    //console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]} </td>`);
  }
  document.write(`<td><button>클릭</button></td>`)
  document.write('</tr>')
  console.log("----------------------------");
}
document.write('</table>');