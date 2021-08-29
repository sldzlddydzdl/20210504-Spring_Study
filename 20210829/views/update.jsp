<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
	<h1>게시글 수정하기</h1>
	<form action="/board/update" method="post">
		<input type="hidden" name="id" value="${board.id}"><br>
		<input type="text" name="writer" value="${board.writer}" readonly="readonly"><br>
		
		<fmt:parseDate value="${board.writeDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate"/>
		<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm:ss" var="writeDate"/>
		<input type="text" name="writeDate" value="${writeDate}" readonly="readonly"><br>
		<input type="text" name="title" value="${board.title}"><br>
		<textarea rows="10" cols="50" name="content">${board.content}</textarea><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>




