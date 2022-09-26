$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$("#rBtn").on("click", e => {
		let postNo = $("#postNo").val(); //게시글 번호
		let receiverNm = $("#receiverNm").text(); //게시글 쓴 사원이름
		let receiverNo = $("#receiverNo").val(); //게시글 쓴 사원번호
		let postTitlt = $("#postTitle").val(); //게시글 제목
		let cntn = $("#rCntn").val();    //댓글 내용
		let empNo = $("#empNo").val();   //댓글 쓴 사원번호
		let wrtr = $("#wrtr").val();     //댓글 쓴 사원이름
		let rList = $("<div>").attr("id", "rList");
			
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
					'cntn': cntn,
					'empNo': receiverNo
				},
				dataType: 'text',
				success: function(res){ //db전송 성공시 실시간 알림 전송
					//소켓에 전달되는 메세지
					//handler에서 ,(comma)를 이용해서 분리시킨다
					console.log(res)
					socket.send('reply,'+wrtr+','+receiverNm+','+receiverNo+',seq');
				}
			})
			//modal.find('.modal-body textarea').val('');	// textarea 초기화
		}
	})
})
        
	
		
		
		
        //socket.onmessage = onMessage;
	      //메세지를 보냈을 때 호출
		/*function onMessage(msg){
			console.log("dd")
			//서버에서 받아온 메세지
			var data = msg.data;
			console.log('ReceiveMessage: '+data+'|n');*/
			
			//알림창의 갯수를 비동기처리로 알림이 올때마다 숫자를 변경해주는 부분
			//없어도 알림에는 상관 없음
			/*$.ajax({
				url: '',
				type: 'post',
				dataType: 'text',
				success: function(data){
					if(data == '0'){
					}else{
						$("#alarmCountSpan").addClass('bell-badge-danger bell-badge')
						                    .text(data);
					}
				},
				error: function(err){
					alert('err');
				}
			});*/
			
			//모달 알림
			/*var toastTop = app.toast.create({
				text: '알림: ' + data + '|n',
				position: 'top',
				closeButton: true
			});
			con
			toastTop.open();*/
			//alert( '알림: ' + data);
		//}
		
		//에러가 발생했을 때 호출
		//socket.onerror = function(err){console.log('Errors: ', err);}
		//});
		
		/*var AlarmData = {
			"myAlarm_receiverEmail" : receiverEmail,
			"myAlarm_callerNickname" : memNickname,
			"myAlarm_title" : "스크랩 알림",
			"myAlarm_content" :  memNickname + "님이 <a type='external' href='/mentor/essayboard/essayboardView?pg=1&seq="+essayboard_seq+"&mentors="+ memberSeq +"'>" + essayboard_seq + "</a>번 에세이를 스크랩 했습니다."
	};
	//스크랩 알림 DB저장
	$.ajax({
		type : 'post',
		url : '/mentor/member/saveAlarm',
		data : JSON.stringify(AlarmData),
		contentType: "application/json; charset=utf-8",
		dataType : 'text',
		success : function(data){
			if(socket){
				let socketMsg = "scrap," + memNickname +","+ memberSeq +","+ receiverEmail +","+ essayboard_seq;
				console.log("msgmsg : " + socketMsg);
				socket.send(socketMsg);
			}

		},
		error : function(err){
			console.log(err);
		}
	});*/

//})
