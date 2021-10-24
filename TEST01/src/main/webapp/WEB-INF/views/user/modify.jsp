<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/modify.js"></script>
</head>
<body>
<form id="modifyForm">
	<input type="hidden" name="user_no" value="${vo.USER_NO }" readonly="readonly" id="USER_NO"/>
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>닉네임</td>
			<td>이메일</td>
		</tr>
		<tr>
			<td><input type="text" placeholder="${vo.USER_ID }" name="user_id" /></td>
			<td><input type="text" name="user_pw" /></td>
			<td><input type="text" placeholder="${vo.USER_NICK }" name="user_nick" /></td>
			<td><input type="text" placeholder="${vo.USER_EMAIL }" name="user_email" /></td>
		</tr>
	</table>
</form>
<button type="button" onclick="modify()">정보 수정</button> |
<a href="/home.do"><button>홈으로</button></a>
</body>
</html>