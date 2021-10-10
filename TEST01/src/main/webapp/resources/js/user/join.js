function join(){
	$.ajax({
		url:"/joinus.do",
		type:"POST",
		data:$("#joinForm").serialize(),
		dataType:"JSON",
		success : function(result){
			console.log(result);
			
			alert(result.msg);
			
			if(result.result == 1){
				location.href = "/";
			}else{
				location.href = "/join.do";
			}
		}
	})
}