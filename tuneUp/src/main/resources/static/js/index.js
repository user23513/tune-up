//전역변수 선언 - 모든 홈페이지에서 사용 할 수 있게 index에 저장
var socket = null;

$(document).ready(function(){
	//웹소켓 연결
	connectWs();
	
	//데이터를 전달 받았을 때
	socket.onmessage = onMessage; //toast 생성
	
	//서버가 끊겼을 때 호출
	socket.onclose = function(){
		setTimeout(function(){connectWs();}, 500);
	}
})

function connectWs(){
	sock = new SockJS("http://192.168.0.19:80/ws/alarm");
	socket = sock;
	
	//이벤트 리스너(커넥션이 연결되었을 때 서버 호출된다)
	sock.onopen = function(){}
};

//toast생성 및 추가
function onMessage(msg){
	var data = msg.data;
	
	/*$.ajax({
		url: 'bellCount',
		dataType:'json',
		success: function(res){
			console.log(res);
			$("#bellCount").text(res);
		}
	});*/
	let bellCount = $("#bell").text();
	$("#bell").text(Number(bellCount)+1);
	
	if(data.includes("긴급공지")) {
		//alert
		let alert = "<div style='z-index: -1;' class='alert alert-danger alert-dismissible fade show' role='alert' aria-live='assertive' aria-atomic='true'>";
	    alert += "<i class='ri-alarm-warning-fill'></i><strong class='mr-auto'>"+data+"</strong>";
	    alert += "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>";
	    $("#alertNotice").append(alert);   
	}else{
		//toast
		let toast = "<div aria-live='polite' aria-atomic='true' class='position-relative'>";
		toast += "<div class='toast-container position-absolute top-0 end-0 p-3'>";
		toast += "<div class='toast' role='alert' aria-live='assertive' aria-atomic='true'>";
	    toast += "<div class='toast-header'><strong class='mr-auto'>알림</strong>";
	    toast += "<button type='button' class='btn-close' data-bs-dismiss='toast' aria-label='Close'></button>";
	    toast += "</div><div class='toast-body'>" + data + "</div></div></div></div>";
	    $("#aa").append(toast);   // msgStack div에 생성한 toast 추가
		$(".toast").toast({"animation": true, "autohide": false});
        $('.toast').toast('show');
	    
	
	}
	
}

