<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.searchModal {
display: none;
position: fixed;
z-index: 10;
left: 0;
top: 0;
width: 100%;
height: 100%;
overflow: auto; 
background-color: rgb(0,0,0); 
background-color: rgba(0,0,0,0.4);
}
.search-modal-content {
background-color: #fefefe;
margin: 15% auto;
padding: 20px;
border: 1px solid #888;
width: 30%;
}
</style>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/reply/type.js"></script>

</head>
<body>
<h1>상세보기</h1>
<a href="/BoardType.do?board_type=${vo.BOARD_TYPE }"><button>게시판</button></a>
<input type="hidden" value="${vo.BOARD_NO }" name="board_no" readonly="readonly" id="BOARD_no"/>
<table border="1">
	<tr>
		<td>분류</td>
		<td><input type="text" name="board_type" value="${vo.BOARD_TYPE }" readonly="readonly" id="BOARD_type"/></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="board_title" value="${vo.BOARD_TITLE }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="board_content" value="${vo.BOARD_CONTENT }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="user_nick" value="${vo.USER_NICK }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><input type="text" name="board_day" value="${vo.BOARD_DAY }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>좋아요</td>
		<td><input type="text" value="${likeCnt }" readonly="readonly" /></td>
	</tr>
</table>
<c:if test="${likeCheck <= 0}">
	<button style="border: none; background: none; font-size: 13px;" onclick="like(${vo.BOARD_NO},${user_no},${likeMax})">좋아요~꾹</button>
</c:if>
<c:if test="${likeCheck > 0 }">
	<button style="border: none; background: none; font-size: 13px;" onclick="${vo.BOARD_NO},${user_no}">싫아요~꾹</button>
</c:if>
<hr />
   <div>
    <div class="popup">
      <div class="popup-body">
          <div class="body-contentbox">
            <input type="text" id="reply_input" placeholder="댓글 입력 창..." style="width: 400px; height: 50px;" />
          </div>
      </div>
      <div class="popup-foot">
        <span class="pop-btn confirm" id="confirm" onclick="modalAdd(0,0)">댓글</span>
        <span class="pop-btn close" id="close" onclick="modalClose()">취소</span>
	  </div>
     </div>
    </div>
     <br />
	<c:forEach var="reply" items="${list }">
	<div style="font-size: 13px;">
		<c:forEach begin="0" end="${reply.REPLY_DEPTH }">
			&nbsp;
		</c:forEach>
		<c:if test="${reply.REPLY_DEPTH != 0}">
			ㄴ
		</c:if>
			${reply.USER_NICK} | ${reply.REPLY_DAY }
			${reply.REPLY_CONTENT }
			<c:if test="${reply.USER_NICK eq user_nick}">
     			<button style="border: none;background: none; font-size: 13px;" onclick="reply_delete(${reply.REPLY_NO})">삭제</button>
     			<button style="border: none;background: none; font-size: 13px;" onclick="reply_modify(${reply.REPLY_NO})">수정</button>
     		</c:if>
			<c:if test="${reply.REPLY_DEPTH == 0 and reply.REPLY_GROUP == 0}">
				<div>
					<button style="border: none;background: none; font-size:14px" onclick="modalOpen(${reply.REPLY_NO},${reply.REPLY_DEPTH+1 })">답글</button>
       					
     			</div>
     					<div id="popup_" style="display: none;">
            				<input type="text" id="reply_" placeholder="답글 입력" style="width: 400px; height: 50px;" />
          					<button onclick="modalAdd_()" style="border: none; background: none; font-size: 13px; " id="reply_reply" >답글</button>
       						<button onclick="modalClose_()" style="border: none; background: none; font-size: 13px; " id="cancle_">취소</button>
     					</div>	
       		</c:if>
	</div>
	</c:forEach>
	<div id="modal" class="searchModal">
		<div class="search-modal-content">
			<div class="page-header">
				<h1>댓글 수정</h1>
			</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-12">
								<input type="text" id="reply_MODIFY" style="width: 400px; height: 100px;"/>
							</div>
						</div>
					</div>
				</div>
			<hr>
				<div style="cursor:pointer;background-color:#DDDDDD;text-align: center; height: 50px; width: 400px; right: auto;">
					<button style="font-size: 13pt; border: none; background: none; height: 50px; width: 200px; float: left;" onclick="ModifyReply()">수정</button>
					<button style="font-size: 13pt; border: none; background: none; height: 50px; width: 200px; float: right;" onClick="closeModal();" >취소</button>
				</div>
		</div>
	</div>

	<form action="/inserttype.do" method="get" id="insertReply" style="display: none;">
		<input type="text" name="reply_no" value="${max }" id="reply_NO"/>
		<input type="text" name="user_no" value="${user_no }"/>
		<input type="text" name="board_no" value="${vo.BOARD_NO}"/>
		<input type="text" name="reply_content" id="reply_Content"/>
		<input type="text" name="reply_day" />
		<input type="text" name="reply_group" value="0" id="reply_Group"/>
		<input type="text" name="reply_depth" value="0" id="reply_Depth"/>
	</form>
	
	<form action="/typeModify.do" method="get" id="MODIFY_Reply" style="display: none;">
		<input type="text" name="reply_no" id="REPLY_no"/>
		<input type="text" name="user_no" value="${user_no }"/>
		<input type="text" name="board_no" value="${vo.BOARD_NO}"/>
		<input type="text" name="reply_content" id="REPLY_Content"/>
	</form>
</body>
</html>