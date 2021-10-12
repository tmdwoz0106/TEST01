<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세보기</h1>
<input type="hidden" value="${vo.BOARD_NO }" name="board_no" readonly="readonly"/>
<table border="1">
	<tr>
		<td>분류</td>
		<td><input type="text" name="board_type" value="${vo.BOARD_TYPE }" readonly="readonly"/></td>
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
</table>
<a href="/BoardType.do?board_type=${vo.BOARD_TYPE }"><button>게시판</button></a>
</body>
</html>