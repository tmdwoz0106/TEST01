function modify(){
	$.ajax({
		url:"/MoidfyUser.do",
		type:"POST",
		data:$("#modifyForm").serialize(),
		dataType:"JSON",
		success : function(result){
			console.log(result);
			alert(result.msg);
			
			if(result.result == 1){
				location.href = "/UserDetail.do?user_no="+$("#USER_NO").val();
			}else{
				location.href = "/UserModify.do?user_no="+$("#USER_NO").val();
			}
		}
	})
}