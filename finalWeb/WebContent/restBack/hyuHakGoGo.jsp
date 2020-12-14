<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%
	response.setContentType("text/html; charset=UTF-8");
request.setCharacterEncoding("utf-8");
//post 방식일때 request로 받은 문자열을 한글로 받으려면
//request.setCharacterEncoding("utf-8"); 필수
%>
<html>
<head>
<link href="/css/standard.css" rel="stylesheet">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js"	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>학생 휴학 Section</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	var status = '${stdAdd.stdStatus}';

	var bb;

	$(function() {

		switch (status) {
		case '1':
			console.log(status);
		case '2':
			console.log(status);
			document.querySelector('#reason').setAttribute('disabled', '');
			document.querySelector('#submitBtn').setAttribute('value', '복학신청');
			break;
		case '3':
			alert('휴학 신청을 할 수 없습니다. 개인정보 페이지로 돌아갑니다.');
			location.href = '/personal/personalInfo.jsp';
			break;
		case '4':
			console.log(status);
			alert('이미 휴학 신청이 되어있습니다.\n교수님의 승인을 기다려주세요.');
			location.href = '/personal/personalInfo.jsp';
			break;
		}
	});

	function inc() {
		if (arguments[0].value == 3) {
			document.querySelector("#y").value++;
			arguments[0].value = 1;
		}
	}
	function nextSem() {
		var num = document.querySelector('#sem');
		if (num.value == 2) {
			num.value = 1;
			document.querySelector("#y").value++;
		} else {
			num.value++;
		}

	}
	function prevSem() {
		var num = document.querySelector('#sem');
		if (num.value == 1) {
			num.value = 2;
			document.querySelector("#y").value--;
		} else {
			num.value--;
		}
	}
</script>

<style>


#hyuHak {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#hyuHakGoGoWrap {
	position: relative;
	height: 100%;
	margin: 0px 150px;
}

.mtitle {
	margin: 0 auto;
	padding-left: 50px;
	padding-top: 20px;
	padding-bottom: 10px;
	font-size: 30px;
	border-bottom: 1px solid #ccc;
}

#info {
	position: relative;
	width: 100%;
	height: 7%;
}

#info label {
	display: inline-block;
	position: relative;
	font-size: 20px;
	margin: 10px;
	maring-left: 50px;
}

#info input {
	border: transparent;
	width: 150px;
	margin-left: 5px;
	font-size: 20px;
	background: #f5f4f1;
	border-radius: 5px;
	text-align: center;
	outline: none;
}

#hyuList {
	position: relative;
	width: 100;
	height: 25%;
}

select {
	position: relative;
	margin-top: 20px;
	margin-left: 50px;
	width: 550px;
	height: 150px;
	margin-left: 200px;
}

form {
	position: relative;
	width: 100%;
	height: 26.5%;
}

form label {
	position: relative;
	display: inline-block;
	margin-left: 50px;
}

form input {
	position: relative;
	margin-top: 20px;
	margin-left: 10px;
	border: transparent;
	background: #f5f4f1;
	border-radius: 5px;
	width: 150px;
	height: 26px;
	outline: none;
	text-align: center;
}

#beforeSemester {
	position: relative;
	background-color: #fff;
	border-radius: 5px;
	color: #5d5d5d;
	width: 100px;
	height: 26px;
	border: solid 1px grey;
	font-size: 15px;
	/* box-shadow: 0 5px 25px rgba(0,0,0,0.2); */
	outline: none;
}

#afterSemester {
	position: relative;
	background-color: #fff;
	border-radius: 5px;
	color: #5d5d5d;
	width: 100px;
	height: 26px;
	border: solid 1px grey;
	font-size: 15px;
	/* box-shadow: 0 5px 25px rgba(0,0,0,0.2); */
	outline: none;
}

form textarea {
	position: relative;
	display: inline-block;
	margin: 20px;
	outline: none;
	width: 550px;
	height: 145px;
	margin-left: 200px;
}

#submitBtn {
	position: absolute;
	background: #80bf9b;
	width: 100px;
	height: 30px;
	border-radius: 25px;
	outline: none;
	margin-top: 140px;
}
</style>

</head>
<body>
	<div id="hyuHakGoGoWrap">
		<c:choose>
			<c:when test="${stdAdd.stdStatus==0 }">
				<c:set var="status" value="재학중"></c:set>
			</c:when>
			<c:when test="${stdAdd.stdStatus==1 }">
				<c:set var="status" value="휴학중"></c:set>
			</c:when>
			<c:when test="${stdAdd.stdStatus==2 }">
				<c:set var="status" value="군휴학"></c:set>
			</c:when>
			<c:when test="${stdAdd.stdStatus==3 }">
				<c:set var="status" value="자퇴??"></c:set>
			</c:when>
			<c:when test="${stdAdd.stdStatus==4 }">
				<c:set var="status" value="휴학신청중"></c:set>
			</c:when>
		</c:choose>


		<div class="mtitle">학생정보</div>
		<div id="info">
			<label>학번<input type="text" name="no" size="10"
				value=${member.no } readonly></label> <label>학년 <input
				type="text" size="10" value="${stdAdd.stdGrade }" readonly></label>
			<label>상태 <input type="text" size="10" value="${status }"
				readonly></label>
		</div>
		<%--  <table class="schoolbase">
		<tbody>
			<tr>
				<td>학번</td>
				<td>${member.no }</td>
				<td>학년</td>
				<td>${stdAdd.stdGrade}</td>
				<td>학생상태</td>
				<td>${status }</td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>  --%>

		<div class="mtitle">휴/복학내역</div>
		<div id="hyuList">
			<c:if test="${hyuList != null }">
				<select size="10">
					<c:forEach var="item" items="${hyuList}">
						<option>${fn:substring(item.start,0,4)} ${fn:substring(item.start,4,5)}학기부터| ${item.period}학기 | ${item.reason }</option>
					</c:forEach>
				</select>
			</c:if>
			<c:if test="${hyuList == null }">
				<h3>이력없음</h3>
			</c:if>
		</div>

		<div class="mtitle">휴/복학 신청</div>
		<form action="/restBackApply" method="post"
			onsubmit="if(!confirm('계속 진행하시겠습니까?}')){return false;}">
			<label>시작학기 <input type="number" name="year" id="y"
				value="2020" size="5" required> <input type="number"
				name="sem" id="sem" value="2" max="2" min="1" size="3" required></label>
			<input type="button" onclick="nextSem()" value="다음학기"
				id="beforeSemester"></input> <input type="button"
				onclick="prevSem()" value="이전학기" id="afterSemester"></input> <label>총
				신청 학기 <input type="number" name="count" min="1" max="4" size="3"
				value="1" required>
			</label><br>
			<textarea rows="5" cols="50" placeholder="휴학신청사유를 적어주세요"
				name="reason" id="reason" required></textarea>
			<input type="submit" value="휴학신청" id="submitBtn" name="flag">
		</form>
	</div>

</body>
</html>