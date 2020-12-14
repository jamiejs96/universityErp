<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link href="/css/standard.css" rel="stylesheet">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>개인정보 Section</title>
<style>

#personalInfoSection {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

form {
	position: relative;
	height: 100%;
	margin: 0px 200px;
}

h2 {
	margin: 0px;
	padding-top:60px ;
	padding-left:20px;
	padding-bottom:30px;
	color: #555;
	border-bottom: 1px solid #ccc;
}

h2 i {
	color: #555;
	margin: 0;
	padding: 0 5px;
}

.button {
	position: relative;
	width: 500px;
	left: 35%;
}

.button>input {
position:relative;
	width: 90px;
	height: 30px ;
	background: #fff;
	border-radius: 5px;
	color: gray;
	border: solid 1px gray;
	font-size: 15px;
	outline: none;
	margin:30px;
}


input {
	border: transparent;
	border-radius: 5px;
	background: #f5f4f1;
	margin-top: 40px;
	margin-left: 5px;
	margin-bottom:70px;
	width: 150px;
	height: 35px;
	outline: none;
	text-align: center;
}

label {
	margin: 0;
	padding: 50px 30px;
	font-size: 20px;
}

#confirm-btn {
	visibility: hidden;
}
</style>

<script>
	var editButton = function() {
		var e = document.querySelectorAll('.editable');
		var btn = document.querySelector('#confirm-btn');
		btn.style.visibility = "visible";
		for (i in e) {
			e[i].removeAttribute('disabled');
		}
	}
</script>
</head>
<body>
	<form action="/editProc" method="post">
		<!-- 기본정보  -->
		<div id="personal">
			<h2>
				<i class="fas fa-info-circle"></i>기본정보
			</h2>

			<label>성명<input type="text" name="name" size="10"
				value=${member.name } disabled class="editable"></label> <label>학번<input
				type="text" name="no" size="10" value=${member.no } disabled></label>
			<label>생일<input type="text" name="no" size="10"
				value=${member.birth } disabled></label>  <label>성별<input
				type="text" name="gender" size="10" value=${member.gender } disabled
				class="editable"></label> <label>이메일<input
				type="text" name="email" size="10" value=${member.email } disabled
				class="editable"></label>
			<!--         member = new Member(dbNo, dbPw, dbName, dbBirth, dbMajor, dbEmail, dbGender, s); -->

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
			<c:if test="${member.job ==1 }">
				<!-- 추가정보  -->
				
				
				<h2>
					<i class="fas fa-info-circle"></i>추가정보
				</h2>
				<label>소속<input type="text"
				name="major" size="10" value=${member.major } disabled></label> 
				<label>학년 <input type="text" size="10"
					value="${stdAdd.stdGrade }" readonly>
				</label>
				<label>상태 <input type="text" size="10" value="${status }"
					readonly></label>
				<label>총 이수 학점<input type="text" size="10"
					value="${stdAdd.stdTotalCredit }" readonly></label>

			</c:if>
			<div class="button">
				<input type="button" onclick="editButton()" value="수정"> <input
					type="submit" value="확인" id="confirm-btn">
			</div>

		</div>
	</form>

</body>
</html>