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



