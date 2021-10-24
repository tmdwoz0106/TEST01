function find(){
	$.ajax({
		url:"/UserFind.do",
		type:"POST",
		data:$("#FindForm").serialize(),
		dataType:"JSON",
		success : function(result){
			var msg = result.result;
			console.log(msg);
			alert("아이디 = " + msg.USER_ID +" , "+ "비밀번호 = " + msg.USER_PW);
			location.href = "/";			
		}
	})
}