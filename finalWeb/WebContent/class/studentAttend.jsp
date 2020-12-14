<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentAttend</title>
<link href="/css/standard.css" rel="stylesheet">
<script src="/js/jquery-3.5.1.min.js"></script>
<script src="jsClass/studentClassApply.js" rel="stylesheet"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js"	crossorigin="anonymous"></script>
</head>
<body>
<div id="wrap">
		<header>
			<jsp:include page="/Header.jsp" />
		</header>
		<div id="middle">
			<div id="menu">
				<jsp:include page="/Menu.jsp" />
			</div>
			<div id="studentAttendSection">
				<jsp:include page="studentAttendSection.jsp" />
			</div>
		</div>
		<footer>
			<jsp:include page="/Footer.jsp" />
		</footer>
	</div>
</body>
</body>
</html>