<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 성적</title>
<style>
body, html {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	box-sizing: border-box;
	
} 
</style>
</head>
<body>
<div id="wrap">
		<header>
			<jsp:include page="../Header.jsp" />
		</header>
		<div id="middle">
			<div id="menu">
				<jsp:include page="../Menu.jsp" />
			</div>
			<div id="scoreSection">
				<jsp:include page="scoreSection.jsp" />
			</div>
		</div>
		<footer>
			<jsp:include page="../Footer.jsp" />
		</footer>
	</div>

</body>
</html>