/**
 * ajax.js
 */
console.log("1542_1");
 
// 비동기.
 let val = 10;
 setTimeout(function(){
	val += 5;
	console.log('hello -> ' + val);
	
	setTimeout(function(){
		val += 3;
		console.log('hello2 -> ' + val);
		
		setTimeout(function(){
			val += 4;
			console.log('hello2 -> ' + val);
		}, 1000); //
			
	}, 1000); //

}, 2000); // 1000 = 1초

let success = true;

let promise = new Promise(function(resolve, reject) {
	if(success) {
		resolve('success');		
	} else {
		reject('error');		
	}
});

promise
	.then(function(result){
		console.log(result);
	})
	.then(function (result) {
		console.log(result);
	})
	.then(function (result) {
		console.log(result);
	})
	.catch(function(err){
		console.log(err);
	});






