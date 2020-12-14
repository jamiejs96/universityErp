<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Pangolin&display=swap"
	rel="stylesheet">
<link href="/css/standard.css" rel="stylesheet">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>개인정보 Section</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap')
	;

#hyuHak {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#hyuHakProfWrap {
	position: relative;
	height: 100%;
	margin: 0px 150px;
}
#prof{
position: relative;
height:20%;
box-sizing: border-box;
border-bottom:1px solid #ccc;
}
#prof > label{
display:inline-block;
margin-top:50px;
margin-left:100px;
font-size:30px;
}
#prof span{
margin-right:50px;
display:flex;
float:right;
}

table{
position:relative;
margin-top:30px;
width:100%;
}
table th {
	position: sticky;
	top: 0;
	width: 195px;
	height:15px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #B9CFD2;
	border-radius: 5px;
}

table td {
	width: 195px;
	padding: 10px;
	vertical-align: top;
	height: 30px;
	border-bottom: 1px solid #f5f4f1;
	background: #f5f4f1;
	border-radius: 5px;
	text-align: center;
}

.submit{
position: relative;
	margin-top: 20px;
	border: transparent;
	background: #f5f4f1;
	border-radius: 5px;
	width: 100%;
	height: 35px;
	outline: none;
	text-align: center;
	}
	
input[type=checkbox] {
zoom: 2;

}
[출처] CSS - checkbox 네모 크기를 늘리는 방법|작성자 케네스
</style>
</head>
<body>
	<div id="hyuHakProfWrap">
	<div id="prof">
		<label>휴학 신청목록</label><br>
		<span>${member.name } 교수님.</span>
	</div>

		<form method="post" action="/confirmRestBack">
			<table>
				<tr>
					<th>학번</th>
					<th>이름</th>
					<th>시작</th>
					<th>몇학기</th>
					<th>이유</th>
					<th>체크</th>
				</tr>
				<c:forEach var="item" items="${boardList}">
					<tr>
						<td>${item.stdNo }</td>
						<td>${item.stdName }</td>
						<td>${item.start }</td>
						<td>${item.period }</td>
						<td>${item.reason }</td>
						<td><input type="checkbox" value="${item.stdNo}"
							name="stdNums"></td>
					</tr>
				</c:forEach>
			</table>
				<input type="submit" class="submit" value="휴학허용">
		</form>
	</div>
</body>
</html>



