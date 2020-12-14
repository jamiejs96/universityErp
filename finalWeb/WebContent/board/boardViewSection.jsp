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

.board h1 {
	margin: 0px 10px 5px;
	font-size: 20px;
	padding-top: 10px;
	color: #555;
}

#titleTable {
	margin-left : 10px;
	margin-bottom : 0px;
width: 660px;
border-top: 1px solid #444444;
border-bottom: 1px solid #444444;
border-color: #DCDCDC;
}

#bbsTitle {
    font-size: 17px;
	margin: 0;
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 4px;
}


#IDandDate label {
	display: inline-block;
	size: 10px;
	font-size: 13px;
	margin-left: 10px;
}

#labelDate {
}

#IDandDate input {
	border: transparent;
	border-radius: 5px;
	background: #f5f4f1;
	margin: 7px 10px 7px ;
	width: 90px;
	height: 22px;
	outline: none;
	text-align: center;
}

#bbsContent textarea{
	padding-top: 5px;
	padding-left: 7px;
	margin: 0px 5px;
	height: 283px;
	width: 660px;
	vertical-align: top;
	background: #f5f4f1;
	resize: none;
	border: transparent;
	border-radius: 10px;	
}

#listBtn {
	color: #000000;
	margin: 5px 10px;
	border: transparent !important;
	width: 50px !important;
	height: 30px !important;
	border-radius: 9px !important;
	background: #A1C2AF !important;
}

#updateBtn {
	color: #000000;
	margin: 5px 10px;
	border: transparent !important;
	width: 50px !important;
	height: 30px !important;
	border-radius: 9px !important;
	background: #A1C2AF !important;
	float: right;
}

#deleteBtn {
	color: #000000;
	margin: 5px 10px;
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
	%>









	<div class="board">
		<h1>학사 공지</h1>


		<table id="titleTable">
			<tr>
				<td colspan="4" id="bbsTitle"><%=bbs.getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","")%></td>
			</tr>
		</table>
		<div id="IDandDate">
			<label id = "labelUserID">작성자<input type="text" name="userID" size="10"
				value=<%=bbs.getUserID()%> disabled></label> <label id = "labelDate">작성일<input
				type="text" name="date" size="10" value=<%=bbs.getBbsDate()%>
				disabled></label>
		</div>
		
		<div id="bbsContent">
		<textarea maxlength="60" readonly><%=bbs.getBbsContent().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n","")%></textarea>			
		</div>





		<input type="button" id="listBtn"
			onclick="location.href='../main.jsp'" value="목록">
		<%
			if (userID != null && userID.equals(bbs.getUserID())) {
		%>
		<input type="button" id="deleteBtn" onclick="goDelete()" value="삭제">
		<input type="button" id="updateBtn"
			onclick="goPage('boardUpdateSection',<%=bbsNo%>)" value="수정">

		<%
			}
		%>

	</div>






	<script>
function goPage(url, param){ 
   var page = '/board/' + url + '.jsp';
   if(param != null){
      var params = '?bbsNo=' + param;
      page = page + params;
   }
    $('#boardMainSection').load(page);
}

function goDelete() {
	var page = '/board/deleteAction.jsp?bbsNo=<%=bbsNo%>' ;
	var cf = confirm("삭제하시겠습니까?");
	if(cf){
	    $('#boardMainSection').load(page);
	}
}
</script>
</body>
</html>