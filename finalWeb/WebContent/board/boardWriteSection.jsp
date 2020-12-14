<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="bbs.BbsDAO"%>
<% request.setCharacterEncoding("UTF-8"); %>
<link href="/css/standard.css" rel="stylesheet">
<!DOCTYPE html>
<html>



<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

.board {
	position: relative;
	width: calc(100% - 530px);
	height: 100%;
}

#header {
	margin: 0px 10px;
	font-size: 20px;
	padding-top: 10px;
	color: #555;
}

#writeSection {
	margin: 5px;
	margin-left: 2px;
	width: 650px;
	position: relative;
}

#bbsTitle {
	height: 20px;
	width: 650px;
	padding: 5px 5px;
	margin-left: 0px;
	vertical-align: top;
	background: #f5f4f1;
	border-radius: 5px;
	resize: none;
} 

#bbsContent {
	height: 309px;
	width: 650px;
	padding: 5px 5px;
	margin-left: 0px;
	vertical-align: top;
	background: #f5f4f1;
	border-radius: 5px;
	resize: none;
}

#listBtn {
	color: #000000;
	margin: 0px 10px;
	border: transparent !important;
	width: 50px !important;
	height: 30px !important;
	border-radius: 9px !important;
	background: #A1C2AF !important;
}

#writeComplete{
	margin:0px 13px;
	border: transparent !important;
	width: 50px !important;
	height: 30px !important;
	border-radius: 9px !important;
	background: #A1C2AF !important;
	float: right;
}


</style>
</head>



<body>
	<%
		String userID = null;
	if (session.getAttribute("id") != null) {
		userID = session.getAttribute("id") + "";
	}
	%>


	<div class="board">
		<form action="/board/writeAction.jsp" method="post">
			
						<h1 id="header">공지 작성</h1>
					
			<table id="writeSection">
					<tr>
						<td><textarea id="bbsTitle" placeholder="제목을 입력하세요."
								name="bbsTitle" maxlength="60"></textarea></td>
					</tr>
					
					<tr>
						<td><textarea id="bbsContent" placeholder="내용을 입력하세요."
								name="bbsContent" maxlength="2100"></textarea></td>
					</tr>
			</table>
			<input type="button" id="listBtn"
			onclick="location.href='../main.jsp'" value="목록">
			<input type="submit" value="저장" id="writeComplete">
		
		
		</form>
	</div>
</body>
</html>