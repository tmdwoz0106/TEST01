<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/delete.js"></script>
</head>
<body>
<h1>상세 페이지</h1>
<c:if test="${nick eq vo.USER_NICK}">
<button type="button" onclick="remove()">삭제</button> |
<a href="/BoardModify.do?board_no=${vo.BOARD_NO }"><button>수정</button></a> |
</c:if>
<a href="/home.do"><button>홈으로</button></a>
<form id="deleteForm">
<table border="1">
	<tr>
		<td>글 번호</td>
		<td><input type="text" name="board_no" value="${vo.BOARD_NO }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>글 제목</td>
		<td><input type="text" name="board_title" value="${vo.BOARD_TITLE }" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>글 내용</td>
		<td><input type="text" name="board_content" value="${vo.BOARD_CONTENT }" readonly="readonly" /></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="user_nick" value="${vo.USER_NICK}" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>작성 날짜</td>
		<td><input type="text" name="board_day" value="${vo.BOARD_DAY }" readonly="readonly" /></td>
	</tr>
</table>
</form>
</body>
</html>