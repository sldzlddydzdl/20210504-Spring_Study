<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<link href="/resources/css/user.css" rel="stylesheet">
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded" , function(){
		var btn = document.querySelector("#getList");
		btn.onclick = function(){
			fetch('/user/list')
			  // .then(function(response) {
			  //   return response.json();
			  // }) // 결과 값을 json 으로 바꾸고
			  .then(response => response.json()) // 위 세줄을 한줄로 표시
			  .then(function(myJson) { // 그다음 그 받은 json 을 
			    console.log(JSON.stringify(myJson));
			  	console.log(myJson); // 콘솔로 찍는다.
			  	
			  	// 서버에서 받은 데이터를 이용해서 화면을 만들어 보여준다!
			  	var ul = document.createElement("ul")
			  	for(var user of myJson){ // java 의 foreach
			  		console.log(user);
			  		let li = document.createElement("li");
			  		
			  		var str  = "아이디 : " + user.id;
			  		str += ", 유저아이디 : " + user.userId;
			  		str += ", 비밀번호 : " + user.password;
			  		str += ", 생일 : " + user.birthDate[0] + "/" + user.birthDate[1] + "/" + user.birthDate[2];
			  		str += ", 가입일 : " + user.joinDate[0] + "/" + user.joinDate[1] + "/" + user.joinDate[2] + " " + user.joinDate[3]+":"+user.joinDate[4]+":"+user.joinDate[5];
			  		
			  		li.innerHTML = str; 
			  		console.log(li);
			  		ul.appendChild(li);
			  	}
			  	var body = document.querySelector("body");
			  	console.log(ul);
			  	console.log(body);
			  	body.appendChild(ul);
			  }); 
		}
	});
</script>
</head>
<body>
	<h1>ajax 를 이용한 데이터 요청</h1>
	<button id="getList">유저 리스트 가져오기</button>
	
</body>
</html>