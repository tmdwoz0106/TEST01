<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<h1>전체 페이지</h1>
<sec:authentication property="principal" var="UserVO"/>
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
	<a href="/BoardType.do?board_type=가입인사"><button>가입인사</button></a>
	<a href="/BoardType.do?board_type=자유게시판"><button>자유게시판</button></a>
	<a href="/BoardType.do?board_type=질문코너"><button>질문코너</button></a>
	<table border="1" width="70%">
		<tr>
			<td colspan="2" style="text-align: center;">제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
			<td>좋아요</td>
		</tr>
		<tbody id="tbody"></tbody>
	</table>
	
	<div id="paging"></div>
	<a href="/insertBoard.do"><button>게시글 추가</button></a> |
	<a href="/UserDetail.do?user_no=${UserVO.user_no}"><button>내정보</button></a>
	<form action="/logout" method="POST">
		<sec:csrfInput/>
		<button type="submit">로그아웃</button> |
	</form>
</body>
</html>