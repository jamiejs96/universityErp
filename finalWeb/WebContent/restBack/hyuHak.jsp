<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/standard.css" rel="stylesheet">
</head>
<body>
<c:set var="job" value='hyuHakGoGo.jsp'></c:set>
<c:if test="${member.job ==0}">
<c:set var="job" value="hyuHakProf.jsp"></c:set>
</c:if>
</body>
<div id="wrap">
		<header>
			<jsp:include page="/Header.jsp" />
		</header>
		<div id="middle">
			<div id="menu">
				<jsp:include page="/Menu.jsp" />
			</div>
			<div id="hyuHak">
				<jsp:include page="${job }" />
			</div>
		</div>
		<footer>
			<jsp:include page="/Footer.jsp" />
		</footer>
	</div>
</body>
</html>