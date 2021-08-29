<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
<script>
	//result가 비어있지 않으면 true 비어있으면 false
	var result = ${not empty result}
	if(result){
		alert("${result}");
	}
</script>
</head>
<body>
	<h1>게시글 리스트</h1>
	<a href="/board/write">게시글 작성</a>
	<c:if test="${boardListView.boardTotalCount == 0}">
		<h2>등록된 게시글이 없습니다.</h2>
	</c:if>
	<c:if test="${boardListView.boardTotalCount != 0 }">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardListView.boardList }">
					<tr>
						<td>${board.id}</td>
						<td><a href="/board/detail?id=${board.id}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.writeDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 페이징 -->
		<section>
			<c:forEach var="pageNumber" begin="1" end="${boardListView.pageTotalCount}">
				<a href="list?pageNumber=${pageNumber}">[${pageNumber}]</a>
			</c:forEach>
		</section>
	</c:if>
</body>
</html>




