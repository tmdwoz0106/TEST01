$(function(){
	typeBoard(1);
})
function typeBoard(page){	
	$.ajax({
		url:"/TypeBoard.do",
		type:"GET",
		data:{board_type:$("#boardType").val(),page:page, type:$("#type option:selected").val(), keyword:$("#keyword").val()},
		dataType:"JSON",
		async: false,
		success : function(result){
			console.log(result);
			$("#tbody").empty();
			$("#paging").empty();
			var list = result.list;
			for(var i = 0; i < list.length; i++){
				$.ajax({
					url:"/likeSu.do",
					type:"GET",
					data:{board_no:list[i].BOARD_NO},
					async: false,
					dataType:"JSON",
					success : function(likeSU){
						var html = "<tr>"
						html += "<td>"+list[i].BOARD_TYPE+"</td>"
						html += "<td><a href = /typeDetail.do?board_no="+list[i].BOARD_NO+">"+list[i].BOARD_TITLE+"</td>"
						html += "<td>"+list[i].USER_NICK+"</td>"
						html += "<td>"+list[i].BOARD_DAY+"</td>"
						html += "<td>"+list[i].BOARD_VIEW+"</td>"
						html += "<td>"+likeSU.su+"</td>"
						html += "</tr>" 
						$("#tbody").append(html)
						}
					})
				}
			if(result.prev){
				$("#paging").append("<button onclick = typeBoard("+Number(page-1)+")>이전</button>")
			}
			for(var i = result.startPage; i <= result.endPage; i++){
				$("#paging").append("<button onclick = typeBoard("+i+")>"+i+"</button>")
			}
			if(result.next){
				$("#paging").append("<button onclick = typeBoard("+Number(page+1)+")>다음</button>")
			}
		}
	})
}