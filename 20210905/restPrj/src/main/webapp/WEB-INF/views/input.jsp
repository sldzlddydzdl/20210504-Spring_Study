<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input.jsp</title>
</head>
<body>
	<h1>유저 정보 입력 폼</h1>					 <!-- 파일업로드 하기위해서 요 방식으로 해야함 -->
	<form action="/user/input" method="post" enctype="multipart/form-data">
		<input type="text" name="userId" placeholder="유저 아이디"><br>
		<input type="password" name="password" placeholder="password"><br>
		생년월일 : <input type="date" name="birthDate" ><br>
		<input type="datetime" name="joinDate" placeholder="가입일"><br>
		프로필 사진 : <input type="file" name="profile"><br>
		<button>가입!</button>
	</form>
</body>
</html>