<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/list.js"></script>
<script type="text/javascript" src="/resources/js/user/logout.js"></script>
</head>
<body>
<h1>리스트 페이지</h1>

<label>검색</label>
	<select id="type">
		<option value="board_title">제목</option>
		<option value="board_content">내용</option>
		<option value="user_nick">작성자</option>
		<option value="board_day">날짜</option>
		<option value="board_type">글 목록</option>
	</select>
<label>검색</label>	
	<input type="text" id="keyword" />
	<button type="button" onclick="list(1)">검색</button>
	<hr />
	<table border="1" width="70%">
		<tr>
			<td colspan="2" style="text-align: center;">제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<tbody id="tbody"></tbody>
	</table>
	
	<div id="paging"></div>
	<a href="/insertBoard.do"><button>게시글 추가</button></a> |
	<button onclick="logout()" type="button">로그아웃</button> |
	<a href="/UserDetail.do?user_no=${user_no}"><button>내정보</button></a>
</body>
</html>