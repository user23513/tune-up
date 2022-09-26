$(document).ready(function(){
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	//댓글 등록 버튼 클릭 시
	$("#rBtn").on("click", e => {
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