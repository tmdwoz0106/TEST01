function login(){
	$.ajax({
		url:"/login.do",
		type:"POST",
		data:$("#loginForm").serialize(),
		dataType:"JSON",
		success : function(result){
			var vo =result.result;
			if(vo.msg != null){
				alert(vo.msg);
				location.href = "/";
			}else {
				alert("환영합니다 회원님");
				location.href = "/home.do";
			}
		}
	})
}