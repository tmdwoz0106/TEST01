//function insert(){
//	$.ajax({
//		url:"/BoardInsert.do",
//		type:"POST",
//		data:$("#insertForm").serialize(),
//		dataType:"JSON",
//		success :function(result){
//			$.ajax({
//				url:"/fileUpload.do",
//				data:$("#FileData"),
//				processData: false,
//                contentType: false,
//				type:"POST",
//				success : function(result){
//					alert("게시글이 등록되었습니다");
//					location.href = "/home.do";
//				}
//			})
//		}
//	})
//}

function insert(){
	alert("추가 성공");
}