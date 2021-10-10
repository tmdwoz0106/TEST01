<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/delete.js"></script>
</head>
<body>
<form id="deleteForm">
	<input type="hidden" name="user_no" value="${vo.USER_NO }" id="USER_NO"/>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>닉네임</td>
			<td>이메일</td>
		</tr>
		<tr>
			<td><input type="text" name="user_id" value="${vo.USER_ID }" readonly="readonly" /></td>
			<td><input type="text" name="user_pw" value="${vo.USER_PW }" readonly="readonly" /></td>
			<td><input type="text" name="user_nick" value="${vo.USER_NICK }" readonly="readonly" /></td>
			<td><input type="text" name="user_email" value="${vo.USER_EMAIL }" readonly="readonly" /></td>
		</tr>
	</table>
</form>
<button type="button" onclick="remove()">탈퇴</button> |
<a href="/UserModify.do?user_no=${vo.USER_NO }"><button>정보 수정</button></a> |
<a href="/home.do"><button>홈</button></a>
</body>
</html>