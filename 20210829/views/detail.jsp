<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기 페이지</title>
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded",function(){
		var updateBtn = document.querySelector("table button");
		console.dir(updateBtn);
		updateBtn.onclick = function(){
			console.log("/board/update?id=${board.id}");
			///board/update?id=100
			location.href="/board/update?id=${board.id}";
		}
		
		//삭제버튼 이벤트
		var deleteBtn = document.querySelectorAll("table button")[1];
		deleteBtn.addEventListener("click",function(){
			//post방식으로 요청해보자
			var form = document.createElement("form");
			form.setAttribute("charset","UTF-8");
			form.setAttribute("method","post");
			form.setAttribute("action","/board/delete");
			
			//폼에 넣어줄 값들 추가
			//id값 추가
			var idField = document.createElement("input");
			idField.setAttribute("type","hidden");
			idField.setAttribute("name","id");
			idField.setAttribute("value",${board.id});
			
			form.appendChild(idField);
			
			//폼을 화면에 붙여주자
			document.body.appendChild(form);
			form.submit();
		})
	});
</script>
</head>
<body>
	<h1>게시글 상세보기</h1>
	<c:if test="${board == null}">
		<h2>요청하신 게시글이 없습니다.</h2>
		<a href="/board/list">목록으로 돌아가기</a>
	</c:if>
	<c:if test="${board != null}">
		<table>
			<tbody>
				<tr>
					<th>${board.title}</th>
					<td>${board.writer}<td>
					<td>${board.writeDate}</td>
					<td>${board.updateDate}</td>
				</tr>
				<tr>
					<td colspan="4">${board.content}</td>
				<tr>
				<tr>
					<td colspan="4">
						<button>수정</button>
						<button>삭제</button>
					<td>
				</tr>
			</tbody>
		</table>
	</c:if>
</body>
</html>