$(function(){
	list(1);
})
function list(page){
	$.ajax({
		url:"/main.do",
		type:"GET",
		data:{page:page , keyword:$("#keyword").val(), type:$("#type option:selected").val()},
		dataType:"JSON",
		async: false,
		success : function(result){
			var list = result.list;
			$("#tbody").empty();
			$("#paging").empty();
			for(var i = 0; i <list.length; i++){
				$.ajax({
					url:"/likeSu.do",
					type:"GET",
					data:{board_no:list[i].BOARD_NO},
					dataType:"JSON",
					async: false,
					success : function(likeSu){
						console.log(likeSu);
						var html = "<tr>"
				   		html += "<td>"+list[i].BOARD_TYPE+"</td>"
				   		html += "<td><a href = /BoardDetail.do?board_no="+list[i].BOARD_NO+">"+list[i].BOARD_TITLE+"</td>"
				    	html += "<td>"+list[i].USER_NICK+"</td>"
				    	html += "<td>"+list[i].BOARD_DAY+"</td>"
				   	 	html += "<td>"+list[i].BOARD_VIEW+"</td>"
				    	html += "<td>"+likeSu.su+"</td>"
						$("#tbody").append(html);				
					}
				})
				
			}
			if(result.prev){
				$("#paging").append("<button onclick = list("+Number(page-1)+")>이전</button>")
			}
			for(var i = result.startPage; i <= result.endPage; i++){
				$("#paging").append("<button onclick = list("+i+")>"+i+"</button>")
			}
			if(result.next){
				$("#paging").append("<button onclick = list("+Number(page+1)+")>다음</button>")
			}
		}
	})
}