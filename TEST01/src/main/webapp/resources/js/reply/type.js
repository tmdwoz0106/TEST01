//삭제
function reply_delete(reply_no) {
	if (confirm("정말 삭제하시겠습니까??") == true) {
		$.ajax({
			url:"/typeDelete.do",
			type:"POST",
			data:{reply_no:reply_no},
			dataType:"JSON",
			success : function(result){
				alert("삭제 성공");
				location.href = "/typeDetail.do?board_no="+$("#BOARD_no").val();
			}
		})
	}
}
//추가
function modalClose(){
	$("#reply_input").val("");
	 $("#popup").fadeOut();
}
function modalAdd(reply_group,reply_depth){
	$("#reply_Group").val(reply_group);
	$("#reply_Depth").val(reply_depth);
	var content = $("#reply_input").val();
	$("#reply_Content").val(content);
	$("#insertReply").submit();
}


function modalOpen(reply_group,reply_depth){
	$("#reply_Group").val(reply_group);
	$("#reply_Depth").val(reply_depth);
	$("#popup_").css('display','flex').hide().fadeIn();
}
function modalClose_(){
	$("#reply_").val("");
	$("#popup_").fadeOut();
}
function modalAdd_(){
	var content = $("#reply_").val();
	$("#reply_Content").val(content);
	$("#insertReply").submit();
}

//수정
function reply_modify(reply_no){
	$("#REPLY_no").val(reply_no);
	$("#modal").show();
}

function closeModal(){
	$("#reply_MODIFY").val("");
	$("#modal").hide();
}

function ModifyReply(){
	var reply = $("#reply_MODIFY").val();
	$("#REPLY_Content").val(reply);
	$("#MODIFY_Reply").submit();
}