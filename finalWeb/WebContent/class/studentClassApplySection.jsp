<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>classApplyStSection</title>
<link href="/css/standard.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/class/jsClass/studentClassApply.js"></script>
<script>
var subStr = ['subNo','subName','profName','subTime','subDay','subCredit','subCapacity'];
//JSTL을 이용해서 JSP로 받아온 수강신청이 되어있는 강의의 목록(currSubList)를 받아오는 스크립트.
//서버에서 넘어온 currSubList가 null이 아닐 경우 아래의 jstl문이 실행되고
//javascript에 아래의 코드가 추가됨.
<c:if test="${currSubList != null }">

var sub = new Array();

<c:forEach var="subject" items="${currSubList}" varStatus="status">
 sub[${status.index }] = new Object();
 sub[${status.index }] = {
 subNo : ${subject.subNo },
 subName : '${subject.subName }',
 profName : '${subject.profName }',
 subTime : ${subject.subTime },
 subDay : '${subject.subDay }',
 subCredit : ${subject.subCredit },
 subCapacity : ${subject.subCapacity }
};
</c:forEach>
</c:if>

  </script>


<style>
#middle {
	width: 100%;
	height: calc(75% - 15px);
}

#studentClassApplySection {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#search {
	background: #f5f4f1;
	position: relative;
	width: 100%;
	height: 10%;
}

#category {
	position: absolute;
	margin: 30px 100px;
	transform: translate(-50%, -50%);
}

#search select {
	background: #fff;
	border-radius: 5px;
	color: #5d5d5d;
	padding: 5px;
	width: 90px;
	height: 40px;
	outline: none;
	font-size: 15px;
	/* box-shadow: 0 5px 25px rgba(0,0,0,0.2); */
	-webkit-appearance: button;
	appearance: button;
	outline: none;
}

#search input {
	position: absolute;
	margin: 10px 160px;
	tansform: translate(-50%, -50%);
	background-color: #fff;
	border-radius: 5px;
	color: #5d5d5d;
	padding: 4px;
	width: 250px;
	height: 30px;
	border: solid 1px grey;
	font-size: 15px;
	/* box-shadow: 0 5px 25px rgba(0,0,0,0.2); */
	outline: none;
}

#allSub {
	position: relative;
	width: 100%;
	height: 50%;
	height: 270px;
	overflow-y: auto;
}

#mySub {
	position: relative;
	width: 100%;
	height: 40%;
	height: 261px;
	overflow-y: auto;
}

#subjects {
	border-collapse: separate;
	border-spacing: 2px;
	text-align: center;
	line-height: 1rem;
}

#subjects th {
	position: sticky;
	top: 0;
	width: 195px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #B9CFD2;
	border-radius: 5px;
}

#subjects td {
	width: 195px;
	padding: 10px;
	vertical-align: top;
	height: 3px;
	border-bottom: 1px solid #f5f4f1;
	background: #f5f4f1;
	border-radius: 5px;
}

#mySub table {
	border-collapse: separate;
	border-spacing: 2px;
	text-align: center;
	line-height: 1rem;
	bottom: -1px;
}

#mySubjects th {
	position: sticky;
	top: 0;
	width: 195px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #B9CFD2;
	border-radius: 5px;
}

#mySubjects td {
	width: 195px;
	padding: 10px;
	vertical-align: top;
	height: 3px;
	border-bottom: 1px solid #f5f4f1;
	background: #f5f4f1;
	border-radius: 5px;
	bottom: -1px;
}

#nowSubjects td {
	width: 195px;
	padding: 10px;
	vertical-align: top;
	height: 3px;
	border-bottom: 1px solid #ccc;
	background: #ccc;
	border-radius: 5px;
	background: #ccc;
}

#spanspan {
	position: relative;
	margin: 20px 0px 10px 50px;
	background-color: #fff;
	border-radius: 5px;
	color: #5d5d5d;
	padding: 4px;
	width: 150px;
	height: 30px;
	border: solid 1px grey;
	font-size: 15px;
	/* box-shadow: 0 5px 25px rgba(0,0,0,0.2); */
	outline: none;
}

.a {
	margin: 0;
	margin-bottom: 5px;
	padding: 10px;
	width: 500px;
	padding-left: 30px;
	margin: 0;
}

.b {
	margin: 0;
	padding-top: 25px;
	display: inline-block;
	padding-left: 30px;
}
</style>

</head>
<body>
	<div id="search">
		<!-- 과목 또는 교수명 검색  id:category -->
		<select name="category" id="category">
			<option value="prof_name">교수명</option>
			<!-- 교수명  -->
			<option value="sub_name">과목명</option>
			<!-- 과목명 -->
		</select> <input type="text" name="word" id="word" onkeyup="searchFunction()">
		<!-- 검색버튼  -->
	</div>

	<!-- AJAX로 검색된 과목들의 목록이 뜨는 테이블. 검색어를 입력하지 않은 상태라면 모든 과목이 뜰 수 있도록 수정할 예정 -->
	<h3 class="a">전체 과목</h3>
	<div id="allSub">

		<table id="subjects"></table>
	</div>


	<!-- 내가 신청한 과목들 목록 -->
	<h3 class="b">내가 신청한 과목</h3>
	<input type="button" value="수강신청" id="spanspan">
	<div id="mySub">
		<form id="mySubjects"></form>

		<!-- 새로 신청한 과목들 목록  -->
		<form id="nowSubjects" action="/insertSub" method="post">
			<!-- <input type="submit" value="수강신청">
		 -->
		</form>
	</div>

	<script>

	
$('#spanspan').on('click',function(){
	var nowForm = document.querySelector('#nowSubjects');
	nowForm.submit();
})
</script>
</body>
</html>