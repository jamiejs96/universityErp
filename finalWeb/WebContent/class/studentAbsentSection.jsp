<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentAbsentSection</title>
<link href="/css/standard.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/41a45cc36e.js" crossorigin="anonymous"></script>
<script>
var today = new Date();
var weekendCheck = function(){
    
	var d = new Date(document.querySelector('#date').value);
	if(d.getDay() ==6 || d.getDay() == 0){
		alert('주말 선택 안되요 ㅠㅠ 평일로 선택쿠다사이');
    document.querySelector('#date').value = '';
	} else if (today > d){
        alert('이미 지난 시간은 선택할 수 없어요 ㅠㅠ')
    document.querySelector('#date').value = '';
    }
	document.querySelector('#day').value = d.getDay();
	
};
</script>

<style>
#studentAbsentSection {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#bogun{
position: relative;
height:94%;
margin:20px 150px;
}

table{
position: relative;
margin: 0 auto;
width:60%;
padding:20px;
text-align: center;
}


table th {
	position: sticky;
	top: 0;
	width: 195px;
	height:15px;
	padding: 10px;
	vertical-align: top;
	color: #fff;
	background: #B9CFD2;
	border-radius: 5px;
}

table td {
	width: 195px;
	padding: 10px;
	vertical-align: top;
	height: 3px;
	border-bottom: 1px solid #f5f4f1;
	background: #f5f4f1;
	border-radius: 5px;
}

form{
position: relative;
width:100%;
height:9%;
border-bottom:1.3px solid #B5C1CC;
}

input#date{
display:inline-block;
margin-top:10px;
margin-left:300px;
height:60%;
border:1px solid gray;
border-radius: 3px;
text-align: center;
}

label>i{
font-size: 25px;
color: gray;
margin-left:10px;
margin-right:5px;
}

</style>
</head>
<body>

<div id="bogun">
<c:set var="kind" value="보건" />
<c:if test="${member.gender == 'M' }">
<c:set var="kind" value="예비군" />
</c:if>

<form action="/absent" method="post">
<input type="date" name="date" required id="date" onchange="weekendCheck()">
<c:if test="${member.gender == 'F' }">
<label><i class="fas fa-female"></i>보건<input type="radio" name="kind" value="1" checked></label>
</c:if>
<c:if test="${member.gender == 'M' }">
<label><i class="fas fa-male"></i>예비군<input type="radio" name="kind" value="2" checked></label>
</c:if>
<input type="hidden" name="day" id="day">
<input type="submit" value="선택">
</form>

<table>
<tr><th>학번</th><th>신청일</th><th>종류</th></tr>
<c:forEach var="item" items="${absList }">
<tr><td>${item.stdNo }</td><td>${item.date }</td><td>${kind}</td></tr>
</c:forEach>
</table>



<c:if test="${absentFlag !=null }">
<c:if test="${absentFlag == '0'}">
<script>
alert('너 아직 쉰지 21일 안됫잖아!');
</script>

</c:if>

</c:if>

</div>
</body>
</html>