<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="bbs.BbsDAO"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
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

#updateComplete {
	margin: 0px 13px;
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
	if (userID == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 하세요.')");
		script.println("location.href = '/../main.jsp'");
		script.println("</script>");
	}
	int bbsNo = 0;
	if (request.getParameter("bbsNo") != null) {
		bbsNo = Integer.parseInt(request.getParameter("bbsNo"));
	}
	if (bbsNo == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다.')");
		script.println("location.href = '/../main.jsp'");
		script.println("</script>");
	}
	Bbs bbs = new BbsDAO().getBbs(bbsNo);
	if (!userID.equals(bbs.getUserID())) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('권한이 없습니다.')");
		script.println("location.href = '/../main.jsp'");
		script.println("</script>");
	}
	%>



	<div class="board">
		<form action="/board/updateAction.jsp?bbsNo=<%=bbsNo%>" method="post">

			<h1 id="header">공지 수정</h1>
			<table id="writeSection">
				<tr>
					<td><textarea id="bbsTitle" name="bbsTitle" maxlength="60"><%=bbs.getBbsTitle()%></textarea></td>
				</tr>

				<tr>
					<td><textarea id="bbsContent" name="bbsContent"
							maxlength="2100"><%=bbs.getBbsContent()%></textarea></td>
				</tr>
			</table>

			<input type="button" id="listBtn"
				onclick="location.href='../main.jsp'" value="목록"> <input
				type="submit" value="저장" id="updateComplete">
		</form>




	</div>








</body>
</html>