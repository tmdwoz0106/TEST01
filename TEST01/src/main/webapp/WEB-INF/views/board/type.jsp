<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/type.js"></script>
</head>
<body>
<h1>${board_type}</h1>
<input type="hidden" name="board_type" id="boardType" value="${board_type}"/>
<label>검색</label>
	<select id="type">
		<option value="board_title">제목</option>
		<option value="board_content">내용</option>
		<option value="user_nick">작성자</option>
		<option value="board_day">날짜</option>
	</select>
<label>검색</label>
	<input type="text" id="keyword" />
	<button type="button" onclick="typeBoard(1)">검색</button>
	
	<table border="1" width = "70%">
		<tr>
			<td></td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
			<td>좋아요</td>
		</tr>
	<tbody id="tbody"></tbody>
	</table>
	<div id="paging"></div>
</body>
<a href="/home.do"><button>전체</button></a> |
<c:if test="${board_type eq '가입인사'}">
<a href="/BoardType.do?board_type=자유게시판"><button>자유게시판</button></a> |
<a href="/BoardType.do?board_type=질문코너"><button>질문코너</button></a>
</c:if>
<c:if test="${board_type eq '자유게시판'}">
<a href="/BoardType.do?board_type=가입인사"><button>가입인사</button></a> |
<a href="/BoardType.do?board_type=질문코너"><button>질문코너</button></a>
</c:if>
<c:if test="${board_type eq '질문코너'}">
<a href="/BoardType.do?board_type=자유게시판"><button>자유게시판</button></a> |
<a href="/BoardType.do?board_type=가입인사"><button>가입인사</button></a>
</c:if>
</html>