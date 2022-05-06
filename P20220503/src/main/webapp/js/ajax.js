console.log("1244v1");
		
let fields = ['id', 'name', 'email', 'passwd', 'profile'];

function makeTr(member = {}) {
	let tr = document.createElement('tr');
	for (let field of fields) {
		let td = document.createElement('td');
		td.innerHTML = member[field]?member[field]:'';
		tr.appendChild(td);
	}
		return tr;
}
			
function init() {
	// 서버에서 회원리스트 => 화면출력.
	//let ajax = new XMLHttpRequest();
	fetch('memberListJson.do')
		.then(result => result.json())
		.then(list => {
			let tlist = document.getElementById('list');
			list.forEach(member => {
				let tr = makeTr(member);
				tlist.appendChild(tr);
			});
		})
		.catch(error => console.log(error));
	
	// 업로드 버튼에 이벤트 추가
	let frm = document.forms.frm;
	frm.addEventListener('submit', function(e) {
		e.preventDefault();
		
		let formData = new FormData(frm); // form 태그요소 multipart요청으로 처리.
		let queryStr = formDataToEncoding(formData);
//		for(let keyVal of formData.entries()) {
//			console.log(keyVal[0] + ", "+ keyVal[1]);
//		}
		
		// url, 요청방식{}
		fetch(frm.action, {
				method: 'POST',
				headers: {'Content-type': 'application/x-www-form-urlencoded'},
				body: queryStr,
			})
			.then(data => data.json()) // text형식 출력.
			.then(result => {
				document.getElementById("list").append(makeTr(result));
			})
			.catch(error => console.log(error));
		
	});
}
		
		
init();

function formDataToEncoding(frmData = []) {
	// id=user1&name=Hong&passwd=1234&email=hong...
	let ary = [];
	for(let keyVal of frmData.entries()) {
		ary.push(keyVal[0] + '=' + keyVal[1]); // id=hong
	}
	return ary.join('&');
}


