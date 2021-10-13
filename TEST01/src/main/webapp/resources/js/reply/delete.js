function reply_delete(reply_no) {
	if (confirm("정말 삭제하시겠습니까??") == true) {
		$.ajax({
			url:"/replyDelete.do",
			type:"POST",
			data:{reply_no:reply_no},
			dataType:"JSON",
			success : function(result){
				alert("삭제 성공");
				location.href = "/BoardDetail.do?board_no="+$("#Board_NO").val();
			}
		})

	}
}