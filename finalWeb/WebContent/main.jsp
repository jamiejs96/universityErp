<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js" crossorigin="anonymous"></script>
<link href="/css/standard.css" rel="stylesheet">
<meta charset="UTF-8">
<title>메인페이지</title>
<link>

<style>

#boardMainSection {
	float: right; 
	position : relative;
	width: calc(100% - 160px);
	height: 100%;
	position: relative;
}

</style>
</head>
<body>
	<div id="wrap">
		<header>
			<jsp:include page="Header.jsp" />
		</header>
		<div id="middle">
			<div id="menu">
			<jsp:include page="Menu.jsp" />
			</div>
			<div id="boardMainSection">
			</div>
		</div>
		<footer><jsp:include page="Footer.jsp" /></footer>
	</div>


</body>

<script>
window.onload= function(){ 
   $('#boardMainSection').load('/board/boardMainSection.jsp');   
}
</script>

</html>