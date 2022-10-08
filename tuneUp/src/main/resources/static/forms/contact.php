<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<script>
//=============  할 일  ====================
	//todo 체크박스 이벤트
	$('[name="todoCk"]').change(function() {
		let todoNo = this.closest("div").data("postNo");
		let postNo = this.closest("div").data("todoNo");
		if ($(this).is(':checked')) {
			console.log(todoNo + " 체크됨");
			
			//cmpltYn 값을 Y로 변경
			$.ajax({
				url : "cmpltYnUpdate",
				beforeSend:function(xhr){
					xhr.setRequestHeader(header,token);  
				},
				type : "post",
				data: {"cmpltYn" : "Y", "todoNo" : todoNo},
				success:function(res){
				}
			})
			
			//상태바 모션 변경
  			$.ajax({
				url : "todoPercent",
				beforeSend:function(xhr){
					xhr.setRequestHeader(header,token);  
				},
				type : "post",
				data: {"postNo" : postNo},
				success:function(res){
					/* console.log(res)
					let test = $(this).closest(".sc").children("[name=proBar]").text();
					console.log(test); */
					//$(this).closest(".sc").children(".proBar").remove();
					
					
					/* let test =$(this).closest(".sc").children("progress").attr('th:value', res);
					console.log("test = " +test)
					$(this).closest(".sc").children("[name=perc]").html(res) */
					
					
					
				}
			})
		}
		else {
			console.log(todoNo + " 체크 해제")
			$.ajax({
				url : "cmpltYnUpdate",
				beforeSend:function(xhr){
					xhr.setRequestHeader(header,token);  
				},
				type : "post",
				data: {"cmpltYn" : "N", "todoNo" : todoNo},
				success:function(res){
				}
			})
			//상태바 모션 변경
  			$.ajax({
				url : "todoPercent",
				beforeSend:function(xhr){
					xhr.setRequestHeader(header,token);  
				},
				type : "post",
				data: {"postNo" : postNo},
				success:function(res){
				}
			})
		}
	});

</script>


    
</body>
</html>