<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/standard.css" rel="stylesheet">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>graduate Section</title>
<style>
#graduateSection {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#graduateWrap {
	position: relative;
	height: 100%;
	margin: 0px 200px;
}

.personal {
	position: relative;
	width: 100%;
	height: 30%;
}

.personal h2 {
	margin: 0px;
	padding: 20px;
	color: #555;
	border-bottom: 1px solid #ccc;
}

.tab_content {
	position: relative;
	height: 70%;
	margin: 0 70px;
}

input[type="radio"] {
	display: none;
}

input[type="radio"]+label {
	display: inline-block;
	margin-top: 50px;
	padding: 20px;
	background: #F5f4f1;
	color: #999;
	font-size: 14px;
	cursor: pointer;
	width: 100px;
	height: 15px;
	text-align: center;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

input[type="radio"]:checked+label {
	background: #E1E9DD;
	color: #454545;
}

.contentBox {
	margin: 0;
	padding: 0;
	width: 1200px;
	height: 340px;
	background: #E1E9DD;
	display: none;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	border-top-right-radius: 10px;
}

.personal>label {
	display: inline-block;
	font-size: 20px;
	margin-top: 20px;
	margin-left: 40px;
}

.personal label>input {
	border: transparent;
	border-radius: 5px;
	background: #f5f4f1;
	margin: 15px 10px 25px;
	width: 150px;
	height: 35px;
	outline: none;
	text-align: center;
}

input[id="graduate01"]:checked ~ .con1 {
	display: block;
}

input[id="graduate02"]:checked ~ .con2 {
	display: block;
}

input[id="graduate03"]:checked ~ .con3 {
	display: block;
}

h3 {
	margin: 0;
	padding-top:60px ;
	padding-left:20px;
	padding-bottom:30px;
}

span {
	margin: 0;
	padding: 20px;
}

.spanspan {
	margin: 0;
	padding: 40px;
	color: red;
}

.spanspan1 {
	margin: 0;
	padding: 50px;
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
	<div id="graduateWrap">
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
		<!-- 기본정보  -->
		<div class="personal">
			<h2>기본정보</h2>
			<label>성명<input type="text" name="name" size="10"
				value=${member.name } disabled></label> <label>학번<input
				type="text" name="no" size="10" value=${member.no } disabled></label>
			<label>학적<input type="text" name="no" size="10"
				value=${stdadd.stdStatus } disabled></label> <label>평점<input
				type="text" name="gender" size="10" value=${stdadd.stdGrade }
				disabled></label> <label>총이수학점<input type="text"
				name="major" size="10" value=${stdAdd.stdTotalCredit } disabled></label>
		</div>

		<div class="tab_content">
			<input type="radio" name="graduate" id="graduate01" checked>
			<label for="graduate01">졸업요건</label> <input type="radio"
				name="graduate" id="graduate02"> <label for="graduate02">졸업인증</label>
			<input type="radio" name="graduate" id="graduate03"> <label
				for="graduate03">조기졸업</label>

			<div class="contentBox con1">
				<h3>학사학위전공심화과정 졸업요건</h3>
				<span>1.학사과정의 졸업에 필요한 최소 이수학점은 입학전 전적대학의 인정학점과 우리대학 학사학위과정의
					기본이수 학점인 30학점을 합하여 총 150학점 이상 이수<br />
				</span> <span class="spanspan">※인정학점이 120학점 미만인 자는 졸업학점 확보를 위하여 부족학점
					만큼 추가 이수하여야 한다.<br> <br>
				</span> <span>2.공통필수 1과목을 포함하여 공통교과 6학점 이상 이수<br /> <br></span> <span>3.전공필수
					이수학점을 포함하여 소속학부 전공교과 12학점 이상 이수<br /> <br>
				</span> <span> 4.졸업작품심사 통과자<br /> <br></span>

			</div>
			<div class="contentBox con2">
				<h3>인증영역</h3>
				<span>외국어 영역[외국인 학부생의 경우, 한국어능력시험(TOPIK) 적용]<br />
				<br> <br></span> <span> ◆외국어 영역 인증 대체 <br></span> <span
					class="spanspan1"> 외국어 강의로 진행한 교양 및 전공 교과목을 9학점 이상 이수(과목별
					등급이 B0이상),졸업대상자가 해당 요건에 의한 외국어 영역 졸업인증 대체를 신청한 경우 <br>
				</span> <span> ◆면제대상<br /></span> <span class="spanspan1"> 외국어 영역 :
					예체능계열 학생, 특수교육대상자 특별전형으로 입학한 학생, 외국인 학생, 계약학과 학생, 그 밖에 졸업자격인증위원회에서
					특별히 인증하는 자<br />
				</span> <span class="spanspan1">사회봉사 영역 : 외국인 학생, 계약학과 학생, 그 밖에 졸업자격
					인증위원회에서 특별히 인정하는 자 <br>
				</span> <span>◆신청기간<br /></span> <span class="spanspan1">별도의 신청기간
					없음<br />
				</span>
			</div>
			<div class="contentBox con3">
				<h3>신청대상<br /></h3><span> 5학기 또는 6학기까지 취득 성적 평점 평균이 4.0 이상이며, 남은 학기(한 학기) 동안 졸업 최저
				이수학점을 취득할 수 있는 자<br /></span><span>학사경고자, 학칙 제85조에 의한 징계처분자, 학칙 제74조에 의한 해당 학기
				휴학자는 제외</span>
			
				<h3>신청방법 및 기간<br /></h3> <span>교무처 시행공고에 따라 대학행정정보시스템에서 신청<br /></span>
				
			</div>

		</div>
	</div>
	<script>
      const grdbtn1 = document.querySelector('.grdbtn1');
      const grdbtn2 = document.querySelector('.grdbtn2');
      const grdbtn3 = document.querySelector('.grdbtn3');
      const grdbox1 = document.querySelector('.grdbox1');
      const grdbox2 = document.querySelector('.grdbox2');
      const grdbox3 = document.querySelector('.grdbox3');

      grdbtn1.addEventListener('click', () => {
        grdbox1.style.display = 'block';
        grdbox2.style.display = 'none';
        grdbox3.style.display = 'none';
      });
      grdbtn2.addEventListener('click', () => {
        grdbox1.style.display = 'none';
        grdbox2.style.display = 'block';
        grdbox3.style.display = 'none';
      });
      grdbtn3.addEventListener('click', () => {
        grdbox1.style.display = 'none';
        grdbox2.style.display = 'none';
        grdbox3.style.display = 'block';
      });
    </script>

</body>
</html>