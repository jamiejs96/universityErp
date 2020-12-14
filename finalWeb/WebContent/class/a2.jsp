<%@page import="java.util.ArrayList"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 출결</title>
<script src="https://kit.fontawesome.com/41a45cc36e.js"
	crossorigin="anonymous"></script>
<style>
input[id*="subject"] {
	display: none;
}

input[id*="subject"]+label {
	display: block;
	padding: 20px;
	border: 1px solid gray;
	background: gray;
	color: #fff;
	border-bottom: none;
	cursor: pointer;
	position: relative;
}

i {
	display: flex;
	float: right;
	color: white;
	font-size: 25px;
}

input[id*="subject"]+label+div {
	max-height: 0;
	transition: all .35s;
	overflow: hidden;
}

input[id*="subject"]+label+div p {
	display: inline-block;
	padding: 20px;
}

input[id*="subject"]:checked+label+div {
	max-height: 700px;
}
</style>
</head>
<body>

	<div class="accordion">
		<form method="post" action="/attendProc">
			<input type="radio" name="accordion" id="subject01">
			<label	for="subject01">하브하브<i class="fas fa-chevron-circle-down"></i></label>
			<div>
				<p>aaa</p>
			</div>
			<input type="radio" name="accordion" id="subject02"> <label
				for="subject02">블랙블랙<i class="fas fa-chevron-circle-down"></i></label>
			<div>
				<p>bbbbb</p>
			</div>
			<input type="radio" name="accordion" id="subject03"> <label
				for="subject03">윙윙<i class="fas fa-chevron-circle-down"></i></label>
			<div>
				<p>ccccc</p>
			</div>

		</form>
	</div>

</body>
</html>