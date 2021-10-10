<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/join.js"></script>
</head>
<body>
<h1>회원가입</h1>
<form id="joinForm">
<input type="hidden" name="user_no" value="${max}"/>
<table>
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>닉네임</td>
		<td>이메일</td>
	</tr>
	<tr>
		<td><input type="text" name="user_id" /></td>
		<td><input type="text" name="user_pw" /></td>
		<td><input type="text" name="user_nick" /></td>
		<td><input type="text" name="user_email" /></td>
	</tr>
</table>
</form>
<button type="button" onclick="join()">가입하기</button>
</body>
</html>