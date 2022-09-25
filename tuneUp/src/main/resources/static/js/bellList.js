$(document).ready(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	//나의 사원번호
	let empNo = $("#empNo").val();
	
	//bellList를 ajax로
	$.ajax({
		url: 'bellList',
		beforeSend:function(xhr){
			xhr.setRequestHeader(header,token);  
		},
		type: 'post',
		data: {'empNo':empNo},
		dataType: 'json',
		success: function(bellList){
			console.log(bellList);
		}
	})

})