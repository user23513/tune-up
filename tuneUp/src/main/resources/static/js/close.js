//서버가 끊겼을 때 호출
socket.onclose = function(){
	console.log('connect close!');
	//setTimeout(function(){connectWs();}, 1000);
}