<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/find.js"></script>
</head>
<body>
<h1>아이디 찾기</h1>
<form id="FindForm">
<table>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="user_email" /></td>
	</tr>
</table>
</form>
<button type="button" onclick="find()">아이디,비밀번호 찾기</button>
</body>
</html>