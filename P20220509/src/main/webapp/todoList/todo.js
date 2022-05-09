console.log("0016v1");

document.addEventListener('DOMContentLoaded', init);
let input;
let ul;

function init() {
	input = document.getElementById("myInput");
	ul = document.getElementById("myUL");
	
	fetch('../todo')
		.then(result => result.json())
		.then( (list) => {
			list.forEach(data => {
				addLiElement(data.idx, data.content, data.checked);
			})
		})
		.catch(err => console.log(err));
		
		
}
// TODO
function newTodoElement() {
	let inputValue = input.value;
	if(inputValue === '') {
		alert("내용이 없습니다.");
	} else {
		fetch('../todo',{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: `job=insert&content=${inputValue}`
		}).then(data => data.text())
			.then(result => {
				//console.log(result);
				if(result > 0) addLiElement(result, inputValue, 0);
			})
			.catch(err => console.log(err));
	}
	input.value = "";
}

function addLiElement(idx, content, checked) {
	let li = document.createElement('li');
	let txt = document.createTextNode(content);
	let cross = document.createTextNode("\u00D7");
	let closeBtn = document.createElement("SPAN");
	
	//document.getElementById("myUL").appendChild(li);
	ul.appendChild(li);
	li.appendChild(txt);
  li.appendChild(closeBtn);
  li.setAttribute('id', "todo_"+idx);
  li.addEventListener('click', checkLi);
	closeBtn.className = "close";
  closeBtn.appendChild(cross);
  closeBtn.addEventListener('click', deleteLiEvent);
  
	li.getAttribute('class');
  if(checked == 1) {
		li.setAttribute('class', 'checked');
	}
}

// event

function deleteLiEvent(e) {
	let div = this.parentElement;
	let todoId = ""
	todoId = div.getAttribute("id");
	let idx = todoId.split('_')[1];
	
	fetch('../todo',{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: `job=delete&idx=${idx}`
		})
		.then(data => data.text())
		.then(result => {
			if(result) {
				div.remove();
			}
		})
		.catch(err => console.log(err));
}

function checkLi(e) {
	if(e.target.tagName === 'LI') {
		let li = e.target;
		let ckCls = li.getAttribute("class");
		let todoId = li.getAttribute("id");
		let content = li.firstChild.nodeValue;
		
		let checked = (ckCls == 'checked')?0:1;
		let idx = todoId.split('_')[1];
		
		fetch('../todo',{
			method: 'POST',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: `job=update&idx=${idx}&check=${checked}&content=${content}`
		})
		.then(data => data.text())
		.then(result => {
			if(result) {
				// e.target.classList.toggle('checked');
				li.setAttribute('class', (checked==1)?'checked':'');
			}
		})
		.catch(err => console.log(err))
		
	}
}