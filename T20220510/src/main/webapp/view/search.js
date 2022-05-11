
document.addEventListener('DOMContentLoaded', init);

function init() {
	let form = document.getElementById("form");
	form.addEventListener('submit', searchEvent);
}

function searchEvent(e) {
	e.preventDefault();
	
	let form = document.forms[0]; 
	let job = form.job.value;
	let bookCodeVal = form.bookCode.value;
	
	fetch('./searchBook.do', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded'
		},
		body: `job=${job}&bookCode=${bookCodeVal}`
	})
		.then(data => data.json())
		.then(result => {
			console.log(result);
			let div = document.getElementById('result');
			
			if(job == "remove") {
				let hidden = document.getElementById('hiddenCode');
				let htitle = document.createElement('h3');
				let ul = document.createElement('ul');
				let li_code = document.createElement('li');
				let li_author = document.createElement('li');
				let li_press = document.createElement('li');
				let li_price = document.createElement('li');
				
				htitle.innerHTML = result.bookTitle;
				hidden.value = result.bookCode;
				console.log(div);
				div.appendChild(htitle);
				div.appendChild(ul);
				ul.appendChild(li_code);
				ul.appendChild(li_author);
				ul.appendChild(li_press);
				ul.appendChild(li_price);
				
				li_code.innerHTML = `코드: ${result.bookCode}`;
				li_author.innerHTML = `저자: ${result.bookAuthor}`;
				li_press.innerHTML = `출판: ${result.bookPress}`;
				li_price.innerHTML = `가격: ${result.bookPrice}`;
			} else if(job == "modify") {
				let mform = document.forms[1]
				let inCode = mform.code;
				let inTitle = mform.title;
				let inAuthor = mform.author;
				let inPress = mform.press;
				let inPrice = mform.price;
				
				inCode.value = result.bookCode;
				inTitle.value = result.bookTitle;
				inAuthor.value = result.bookAuthor;
				inPress.value = result.bookPress;
				inPrice.value = result.bookPrice;
			}
		})
		.catch(err => console.log(err));
}
