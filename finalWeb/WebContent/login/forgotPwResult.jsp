<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비번찾기2</title>
<script src="https://kit.fontawesome.com/41a45cc36e.js"	crossorigin="anonymous"></script>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box; /*border-box : 테두리를 기준으로 크기를 정함*/
	text-decoration: none;
	color: gray;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-size: cover;
}

.wrap {
	position: relative;
	width: 100%;
	height: 100%;
	background: #f5f4f1;
}

.find {
	position: absolute;
	width: 400px;
	height: 220px;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -110px;
	background: #c8e3d0;
	border-radius: 15px;
	border-top: 50px solid #ccc;
	box-shadow: 10px 10px 10px #ccc;
	text-align: center;
	
}
i{
color: #f57d7d;
margin:5px;
}
p{
margin:30px;
font-size:23px;
}

a{
font-size:30px;
color: #f57d7d;
border-radius: 5px;
}

</style>

</head>
<body>
	<div class="wrap">
		<!--  비번이 맞으면 -->
		<c:if test="${forgotPwMember != null }">
			<div class="find">
				<p>${forgotPwMember.name }님 비밀번호 <br>
				 <i class="fas fa-heart"></i><Strong>${forgotPwMember.pw }</Strong><i class="fas fa-heart"></i>
				<p>
				<a href="/login/login.jsp">로그인하러 가기</a>
			</div>
		</c:if>



		<!--  비번이 틀리면 -->
		<c:if test="${forgotPwMember == null }">
			<div class="find">
				<p><i class="fas fa-times"></i>일치하는 정보가 없습니다.<i class="fas fa-times"></i></p>
				<a href="/login/forgotPW.jsp">다시 비번찾기</a>
			</div>
		</c:if>
	</div>
</body>
</html>