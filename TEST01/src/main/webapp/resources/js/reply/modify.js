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