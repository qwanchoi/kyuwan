/**
 * post.js
*/

document.addEventListener('DOMContentLoaded', init);

// 리스트.
function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json');
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText);
//		console.log(data);
		let tbodyList = document.getElementById('list');
		data.forEach( elem => {
			tbodyList.appendChild(makeTr(elem));
		});
	} //end of onload = function()
	
	let modBtn = document.querySelector('input[type="button"]');
	modBtn.addEventListener('click', function(e) {
		let no = document.querySelector('input[name="sno"]').value;
		let name = document.querySelector('input[name="sname"]').value;
		let eng = document.querySelector('input[name="eScore"]').value;
		let kor = document.querySelector('input[name="kScore"]').value;
		
		let xhtp = new XMLHttpRequest();
		xhtp.open('get',`modStudentServlet?sno=${no}&sname=${name}&eScore=${eng}&kScore=${kor}`);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				// 결과값으로 받은 값을 => 새로운 tr.
				let obj = {
					studentNo: result.studentNo,
					studentName: result.studentName,
					engScore: result.engScore,	
					korScore: result.korScore
				}
				console.log(result.studentNo);
				let newTr = makeTr(obj);
				let oldTr = document.getElementById("sno_"+result.studentNo);
				document.getElementById('list').replaceChild(newTr, oldTr); // 새로운 tr => 이전 tr 대체.
			} else {
				alert('변경 중 오류.');
			}
		}
	});
} // end of init()

// 변경처리.
function modStudent() {
	
}

// 한건추가.
function addStudent(e) {
	e.preventDefault(); // submit -> 차단.
// 	console.log(e);
	
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;
	
	let xhtp = new XMLHttpRequest(); // 비동기방식으로 서버의 파일요청.
	xhtp.open('get', `addStudentServlet?sno=${no}&sname=${name}&eScore=${eng}&kScore=${kor}`);
	xhtp.send();
	xhtp.onload = function() {
		console.log(xhtp.responseText); // {"retCode":"Success"}
		let result = JSON.parse(xhtp.responseText); // {retCode: "Success"}
		if (result.retCode == "Success") {
			// 리스트 새로운 값 추가.
			successCallBack2(result); // {retCode:?, studNo:?, studName:?, escore:?, kscore:?}
		} else if (result.retCode == 'Fail'){
			// 처리중 에러가 발생.
			failCallBack();
		}
	} // end of function()
} // end of addStudent(e);


function makeTr(student) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', 'sno_'+student.studentNo); // 라인 삭제
	for(let field in student) {
		let td = document.createElement('td');
		td.innerHTML = student[field];
		tr.appendChild(td);
	}
	// 삭제버튼 생성.
	let delBtn = document.createElement('button'); //<button></button>
	delBtn.innerHTML = '삭제';
	
	// 이벤트 등록.
	delBtn.addEventListener('click', function(e){
		let row = this.parentElement.parentElement;
		let id = row.firstChild.innerHTML;
//		console.log(id);
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'delStudentServlet?delId='+id);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if(result.retCode == 'OK') {
				//console.log(result.retVal);
				document.getElementById('sno_'+result.retVal).remove();
				alert(result.retVal + '번이 삭제 되었습니다.');
			} else {
				console.log(result.retVal);
			}
		}
	});
	
	let td = document.createElement('td'); //<td></td>
	td.appendChild(delBtn); // <td><button>삭제</button></td>
	tr.appendChild(td);
	
	return tr;
} // end of makeTr(student)

function successCallBack2(retObj) {
	//resp.getWriter().println("{\"retCode\":\"Success\", \"studNo\":studentNo, \"studName\":\"studentName\", \"engScore\":engScore, \"korScore\":korScore }");
	let student = {
		studentNo: retObj.studNo,
		studentName: retObj.studName,
		engScore: retObj.engScore,
		korScore: retObj.korScore
	};
	
	let row = makeTr(student);
	document.getElementById('list').appendChild(row);
} // end of successCallBack2()

function successCallBack() {
	// 사용자 입력값을 id='list' 하위 추가.
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;
	let stud = {};
	stud.sno = no;
	stud.sname = name;
	stud.escore = eng;
	stud.kscore = kor;
	
	let row = makeTr(stud);
	document.getElementById('list').appendChild(row);
}

function failCallBack() {
	alert('처리중 에러발생.');
}