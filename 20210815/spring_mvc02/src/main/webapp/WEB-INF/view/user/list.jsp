<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<h1> 유저 화면 리스트 </h1>
	<c:forEach var="user" items="${users}">
		<section>
			id : ${user.id}<br>
			유저아이디 : ${user.userId }<br>
			비밀번호 : ${user.password }<br>
			생일 : ${user.birthDate }<br>
			가입일 : ${user.joinDate }
		</section>
	</c:forEach>
</body>
</html>