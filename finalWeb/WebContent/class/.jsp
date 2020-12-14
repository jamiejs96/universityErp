<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<div id="mainSection">
			<jsp:include page="../mainSection.jsp" />
			</div>
		</div>
		<footer><jsp:include page="../Footer.jsp" /></footer>
	</div>

</body>
</html>