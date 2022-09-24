$(document).ready(function(){
        
	$("#rBtn").on("click", e => {
		socket.send('reply,현지,997,은지id,seq');
        console.log(socket)
        socket.onmessage = onMessage;
	      //메세지를 보냈을 때 호출
		function onMessage(msg){
			console.log("dd")
			//서버에서 받아온 메세지
			var data = msg.data;
			console.log('ReceiveMessage: '+data+'|n');
			
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
			alert( '알림: ' + data);
		}
		
		//에러가 발생했을 때 호출
		socket.onerror = function(err){console.log('Errors: ', err);}
		})
		
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

});
