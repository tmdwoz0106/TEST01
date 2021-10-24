<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<!-- <script type="text/javascript" src="/resources/js/user/login.js"></script> -->
</head>
<body>
<form id="loginForm" action="/login" method="POST">
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
	<sec:csrfInput/>
<button type="submit">로그인</button>
</form>
<a href="/join.do"><button>회원가입</button></a>
<div>
<a href="/IdFind.do"><button style="border: none; background: none; font-size: 13px;">아이디 찾기,비밀번호 찾기</button></a>
</div>
</body>
</html>