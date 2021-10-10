<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/modify.js"></script>
</head>
<body>
<h1>수정페이지</h1>
<form id="modifyForm">
<input type="hidden" name="board_no" value="${vo.BOARD_NO }" id="board_NO"/>
	<table border="1">
		<tr>
			<td>타입</td>
			<td>제목</td>
			<td>내용</td>
		</tr>
		<tr>
			<td>
				<select name="board_type">
					<option value="가입인사">가입인사</option>
					<option value="자유게시판">자유게시판</option>
					<option value="Q&A">Q&A</option>
				</select>
			</td>
			<td><input type="text" name="board_title" /></td>
			<td><input type="text" name="board_content" /></td>
		</tr>
	</table>
</form>
<button type="button" onclick="modify()">수정</button>
</body>
</html>