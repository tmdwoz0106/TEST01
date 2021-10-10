function modify(){
	$.ajax({
		url:"/ModifyBoard.do",
		type:"POST",
		data:$("#modifyForm").serialize(),
		dataType:"JSON",
		success : function(result){
			alert("수정 성공");
			location.href = "/BoardDetail.do?board_no="+$("#board_NO").val();
		}
	})
}