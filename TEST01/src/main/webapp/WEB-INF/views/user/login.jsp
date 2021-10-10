<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/login.js"></script>
</head>
<body>
<form id="loginForm">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="user_id" value="tmdwoz0106"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="user_pw" value="as112404as"/></td>
		</tr>
	</table>
</form>
<button type="button" onclick="login()">로그인</button>
<a href="/join.do"><button>회원가입</button></a>
</body>
</html>