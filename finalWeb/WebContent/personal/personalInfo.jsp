<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/standard.jsp" rel="stylesheet">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js"	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>개인정보</title>

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
			<div id="personalInfoSection">
				<jsp:include page="personalInfoSection.jsp" />
			</div>
		</div>
		<footer>
			<jsp:include page="/Footer.jsp" />
		</footer>
	</div>
</body>
</html>