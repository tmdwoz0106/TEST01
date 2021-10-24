<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<form id="joinForm" action="/join.do" method="POST">
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
<input type="hidden" value="ROLE_USER" name="user_role" />
<input type="hidden" value="1" name="user_enabled" />
<sec:csrfInput/>
<button type="submit">가입하기</button> |
</form>
<a href="/"><button>로그인페이지</button></a>
</body>
</html>