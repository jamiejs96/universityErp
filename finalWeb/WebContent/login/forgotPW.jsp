<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box; /*border-box : 테두리를 기준으로 크기를 정함*/
	color: gray;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-size: cover;
	background: #f5f4f1;
}

body::before {
	content: "";
	position: absolute;
	z-index: 1;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
}

.findTitle {
	position: relative;
	z-index: 2;
	border:none;
	border-top: 40px solid #ccc;
	background: #c8e3d0;
	border-radius: 20px;
	box-shadow: 10px 10px 10px #ccc;
}

/* 비밀번호 찾기 제목 css */
.findTitle h2 {
	font-size: 50px;
	color: gray;
	text-align: center;
	margin: 30px;
}
i{
font-size: 40px;
padding:10px;
}
.radio-area {
	width: 400px;
	position: relative;
	text-align: center;
}

.radio-area label {
	margin-left:80px;
	
}

.text-area {
	width: 500px;
	position: relative;
	margin-top: 20px;
}
.text-area::first-child {
	margin-top: 0;
}
.text-area label {
	position: absolute;
	color: gray;
	left: 10px;
	top: 15px;
	font-size: 17px;
}

.text-area input {
	width: 100%;
	padding: 50px 10px 10px;
	background-color: transparent;
	border: none;
	border-bottom: 1px solid #aeb0af;
	outline: none;
}
.submitBtn{
margin:20px;
text-align: center;
}

.submitBtn input{
width:30%;
height:40px;
background-color:#f5f4f1;
color :gray;
font-size:20px;
border: none;
border: none;
border-radius: 10px;
outline:none;
}

input:-webkit-autofill {
   -webkit-box-shadow: 0 0 0 1000px #c8e3d0 inset;
}


출처: https://web-atelier.tistory.com/30 [웹아틀리에 - Web atelier]
</style>

</head>
<body>
	<div class="findTitle">
		<h2>
			<i class="fas fa-unlock"></i>비밀번호 찾기
		</h2>

		<form action="/forgotPw" method="post">
			<div class="radio-area">
				<label><input type="radio" name="job" value="1" checked>STUDENT</label>
				<label><input type="radio" name="job" value="0">PROFESSOR</label>
			</div>

			<div class="text-area">
				<label>이름</label><input type="text" name="name" required> <br>
			</div>
			<div class="text-area">
				<label>학번</label><input type="number" name="no" required> <br>
			</div>
			<div class="text-area">
				<label>이메일</label><input type="text" name="email" required> <br>
			</div>
			<div class="submitBtn">
				<input type="button" onclick="submit()" value="비밀번호 찾기">
			</div>
		</form>

	</div>
</body>
</html>