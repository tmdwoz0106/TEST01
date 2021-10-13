function like(board_no,user_no,like_no){
	$.ajax({
		url:"/like.do",
		type:"POST",
		data:{board_no:board_no , user_no:user_no , like_no:like_no},
		dataType:"JSON",
		success : function(result){
			location.href = "/BoardDetail.do?board_no="+$("#Board_NO").val();
		}
	})
}

function likeDelete(board_no,user_no){
	$.ajax({
		url:"/likeDelete.do",
		type:"POST",
		data:{board_no:board_no , user_no:user_no},
		dataType:"JSON",
		success : function(result){
			location.href = "/BoardDetail.do?board_no="+$("#Board_NO").val();
		}
	})
}