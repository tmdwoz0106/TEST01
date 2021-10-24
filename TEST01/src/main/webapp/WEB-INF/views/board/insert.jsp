<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/insert.js"></script>
</head>
<body>
<form id="FileForm" action="/BoardInsert.do" enctype="multipart/form-data" method="POST">
	<table>
		<tr>
			<td>글 타입</td>
			<td><select name="board_type">
					<option value="가입인사">가입인사</option>
					<option value="자유게시판">자유게시판</option>
					<option value="질문코너">질문코너</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>글 제목</td>
			<td><input type="text" name="board_title" /></td>
		</tr>
		<tr>
			<td>글 내용</td>
			<td><input type="text" name="board_content" style="height: 500px"/></td>
		</tr>
	</table>
	<input multiple="multiple" type="file" name="file" />
<!-- 	<input type="file" name="file" /> -->
	<input type="hidden" name="user_no" value="${user_no }"/>
	<input type="hidden" name="board_no" value="${max }"/>
	<br />
	<button type="submit" onclick="insert()">게시글 추가</button>
</form>
</body>
</html>