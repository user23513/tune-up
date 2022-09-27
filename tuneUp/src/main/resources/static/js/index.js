//전역변수 선언 - 모든 홈페이지에서 사용 할 수 있게 index에 저장
var socket = null;
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");

$(document).ready(function(){
	//웹소켓 연결
	connectWs();
	
	//데이터를 전달 받았을 때
	socket.onmessage = onMessage; //toast 생성
	
	//서버가 끊겼을 때 호출
	socket.onclose = function(){
		//setTimeout(function(){connectWs();}, 500);
	}
	
	//게시글 등록 버튼 눌렀을 때 소켓에 메세지 보내는 함수
	$("#noticeBtn").on("click", function(){
        let content = tinymce.activeEditor.getContent();
        let title = $("#ttl").val();
        $("#cntn").val(content);
        $("#frm").submit();
        
        if($('#emerg').is(':checked')){
        	socket.send('notice,'+title);
        }
    });
    
	//댓글 등록 버튼 클릭 시
	$(".socket").on("click", e => {
		let postNo = $("#postNo").val(); //게시글 번호
		let receiverNm = $("#receiverNm").text(); //게시글 쓴 사원이름
		let receiverNo = $("#receiverNo").val(); //게시글 쓴 사원번호
		let postTitle = $("#postTitle").text(); //게시글 제목
		let cntn = $("#rCntn").val();    //댓글 내용
		let empNo = $("#empNo").val();   //댓글 쓴 사원번호
		let wrtr = $("#wrtr").val();     //댓글 쓴 사원이름
		let rList = $("<div>").attr("id", "rList");
		let bellCntn = wrtr+'님이 <a id="freeTitle" data-no='+postNo+' href="javascript:void(0);" onClick="freeTitle()">['+postTitle+']</a>게시글에 댓글을 남겼습니다.';
			
        //전송한 정보를 db에 저장
		//내가 등록한 댓글은 db에 저장되지 않고
		//내 게시글에 댓글 달 경우는 나에게 알림이 가지 않도록
		if(receiverNo != empNo) {
			$.ajax({
				url: 'bellInsert',
				beforeSend:function(xhr){
					   xhr.setRequestHeader(header,token);  
				},
				type: 'post',
				data: {
					'sender': wrtr,
					'receiver': receiverNm,
					'cntn': bellCntn,
					'empNo': receiverNo
				},
				dataType: 'text',
				success: function(res){ 
					//db전송 성공시 실시간 알림 전송
					//소켓에 전달되는 메세지
					//handler에서 ,(comma)를 이용해서 분리시킨다
					console.log(res)
					socket.send('reply,'+wrtr+','+receiverNm+','+receiverNo+','+postNo+','+postTitle);

				}
			})
		}
	})
})

//웹소켓 연결 함수
function connectWs(){
	sock = new SockJS("http://192.168.0.19:80/ws/alarm"); //다른곳에서도 사용하려고 내 ip주소 적어놓음
	socket = sock;
	
	//이벤트 리스너(커넥션이 연결되었을 때 서버 호출된다)
	sock.onopen = function(){console.log("connect!")}
};

//toast생성 및 추가 (웹소켓으로 보낸 메세지 받는 함수)
function onMessage(msg){
	var data = msg.data;
	
	let bellCount = $("#bell").text();
	$("#bell").text(Number(bellCount)+1);
	
	if(data.includes("공지")) {
		//alert
		let alert = "<div class='alert alert-danger alert-dismissible fade show' role='alert' aria-live='assertive' aria-atomic='true'>";
	    alert += "<i class='ri-alarm-warning-fill'></i><strong class='mr-auto'>"+data+"</strong>";
	    alert += "<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button></div>";
	    $("#alertNotice").append(alert);   
	}else{
		//toast
		let toast = "<div class='toast' role='alert' aria-live='assertive' aria-atomic='true'>";
		toast += "<div class='toast-header'><strong class='me-auto'>알림</strong>";
	    toast += "<button type='button' class='btn-close' data-bs-dismiss='toast' aria-label='Close'></button></div>";
	    toast += "<div class='toast-body'>" + data + "</div></div>";
	    $("#bellArea").append(toast);   // bellArea div에 생성한 toast 추가
		$(".toast").toast({"animation": true, "autohide": false});
        $('.toast').toast('show');
	    
	
	}
	
}

