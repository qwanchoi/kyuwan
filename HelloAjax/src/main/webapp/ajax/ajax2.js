/**
 * ajax2.js
 */
console.log('1600_1')

let val = 6;
 
let promise = new Promise((resolve, reject) => {
	val -= 1;
	if(val > 0) {
		resolve('success, ' + val);
	} else {
		reject('error');
	}
});

promise
	.then( resolve => {
		return new Promise((resolve, reject) => {
			val -= 2;
			if(val > 0) {
				resolve('success, ' + val);
			} else {
				reject('error');
			}
		});
	})
	.then()
	.catch();







