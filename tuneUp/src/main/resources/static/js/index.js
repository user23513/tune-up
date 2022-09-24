//전역변수 선언 - 모든 홈페이지에서 사용 할 수 있게 index에 저장
var socket = null;

$(document).ready(function(){
	
	$('#login').on("click", e=>{
		connectWs();
		$("#frm").submit();
	})
	//웹소켓 연결??
	connectWs();
})

function connectWs(){
	sock = new WebSocket("ws://localhost:80/ws/alarm");
	socket = sock;
	
	//이벤트 리스너(커넥션이 연결되었을 때 서버 호출된다)
	sock.onopen = function(){}
	console.log('info: connection opened!');
};