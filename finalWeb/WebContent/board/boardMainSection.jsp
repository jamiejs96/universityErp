<%@page import="bbs.Bbs"%>
<%@page import="bbs.BbsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8"); %>
<link href="/css/standard.css" rel="stylesheet">
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>학사공지</title>


<style type="text/css">



#board {
	position: relative;
	width: calc(100% - 510px);
	height: 100%;
}

.boardTitle {
	position: relative;
}

.boardTitle h1 {
	margin: 0px 10px;
	font-size: 20px;
	padding-top: 10px;
	color: #555;
	
}

.boardTable {
	margin: 5px;
	position: relative;
}

.boardTable th {
	padding: 4px;
	color: #fff;
	background: #B9CFD2;
	border-radius: 5px;
}

.boardTable td {
	padding: 5px;
	background: #f5f4f1;
	border-radius: 5px;
}

#bodyTitle {
	color: #000000;
	text-decoration: none;
	
}

#no{
	width: 60px;
	table-layout: fixed;

}

#title{
	width: 930px;
	table-layout: fixed;

}

#userID{
	width: 210px;
	table-layout: fixed;

}

#date{
	width: 210px;
	table-layout: fixed;
}

#bbsNo{
    text-align: center;
}


#bbsUserID{
    text-align: center;

}

#bbsTitle{
   	padding-left: 8px;
}

#bbsDate{
    text-align: center;
}

.boardBtn {
	position: relative;
}

#prePageBtn, #nextPageBtn {
	color: #000000;
	margin: 0px 10px;
	border: transparent !important;
	width: 50px !important;
	height: 30px !important;
	border-radius: 9px !important;
	background: #A1C2AF !important;
}

#writeBtn {
	color: #000000;
	margin: 0px 10px;
	border: transparent !important;
	width: 70px !important;
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
	int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	%>


	<div id="board">
		<div class="boardTitle">
			<h1>학사 공지</h1>
		</div>
		
		
		<table class="boardTable">
			<thead>
				<tr id="tableHead">
					<th id="no">번호</th>
					<th id="title">제       목</th>
					<th id="userID">작 성 자</th>
					<th id="date">작 성 일</th>
				</tr>
			</thead>

			<tbody>
				<%
					BbsDAO bbsDAO = new BbsDAO();
				ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr id="tableBody">
					<td id="bbsNo"><%=list.get(i).getBbsNo()%></td>
					<td id="bbsTitle"><a id="bodyTitle" href="javascript:void(0);"
						onclick="goPage('boardViewSection', <%=list.get(i).getBbsNo()%>)">
							<%=list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
		.replaceAll("\n", "")%></a></td>
					<td id="bbsUserID"><%=list.get(i).getUserID()%></td>
					<td id="bbsDate"><%=list.get(i).getBbsDate()%></td>
					<%
						}
					%>
				</tr>
			</tbody>
		</table>
		
		
		
		<div class="boardBtn">
			<%
				if (pageNumber != 1) {
			%>
			<input type="button" id="prePageBtn"
				onclick="goNextPrePage('boardMainSection', <%=pageNumber - 1%>)" value = "이전" >
			<%
				}
			if (bbsDAO.nextPage(pageNumber + 1)) {
			%>
			<input type="button" id="nextPageBtn"
				onclick="goNextPrePage('boardMainSection', <%=pageNumber + 1%>)" value = "다음" >	
			<%
				}
			%>
			<input type="button" id="writeBtn"
				onclick="goPage('boardWriteSection')" value = "글쓰기" >
		</div>
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

function goNextPrePage(url, param){ 
   var page = '/board/' + url + '.jsp';
   if(param != null){
      var params = '?pageNumber=' + param;
      page = page + params;
   }
   $('#boardMainSection').load(page);
}
</script>

</body>
</html>