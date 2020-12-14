<%@page import="java.util.ArrayList"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/standard.css" rel="stylesheet">
<meta charset="UTF-8">
<title>출결 Section</title>
<style>
#studentAttendSection {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#attend {
	position: relative;
	width: 97%;
	height: 100%;
	left: 50%;
	margin-left: -49%;
}

.row17 {
	position: relative;
	width: 100%;
	height: 100%;
	margin: 5px;
}

.row16 {
	position: relative;
	width: 100%;
	height: 100%;
	margin: 5px;
}

input[id*="subject"] {
	display: none;
}

input[id*="subject"]+label {
	display: block;
	padding: 20px;
	border: 1px solid #fff;
	background: #D9E7E9;
	color: #555;
	border-bottom: none;
	cursor: pointer;
	position: relative;
	border-radius: 10px;
	text-align: center;
	font-size: 15px;
}

#attendTable i {
	display: flex;
	float: right;
	color: white;
	font-size: 25px;
}

input[id*="subject"]+label+div {
	max-height: 0;
	transition: all .35s;
	overflow: hidden;
}

input[id*="subject"]+label+div span {
	display: inline-block;
	width: 50px;
	height: 10px;
	background: #B9CFD2;
	padding: 20px;
	border-radius: 5px;
	text-align: center;
}

input[id*="subject"]+label+div .col {
	background: #f5f4f1;
}

input[id*="subject"]+label+div .aaa {
	display: inline-block;
	width: 130px;
	height: 10px;
	background: #B9CFD2;
}

input[id*="subject"]+label+div .bbb {
	display: inline-block;
	width: 130px;
	height: 10px;
	background: #f5f4f1;
}
input[id*="subject"]+label+div .ccc {
	display: inline-block;
	width: 55px;
	height: 10px;
	background: #B9CFD2;
}
input[id*="subject"]+label+div .ddd {
	display: inline-block;
	width: 55px;
	height: 10px;
	background: #f5f4f1;
}
input[id*="subject"]:checked+label+div {
	max-height: 5000px;
}
h2{
	margin:0;
	border-bottom:1px solid #ccc;
	padding-top:40px;
	padding-left:150px;
	padding-bottom:20px;
	
}

form{
margin-top:20px;
}
</style>
</head>
<body>

	<input type="hidden" id="hiddenJob" value="${member.job }">

	<!-- job이 1이면 학생이니까 학생부분만 보이도록 -->
	<c:if test="${member.job==1 }">
		<div class="attend">
		<h2> 출결 </h2>
			<form method="post" action="/attendProc">
				<c:forEach var="item" items="${subjectList }" varStatus="status">
					<div id="attendTable">
						<input type="radio" name="sub_no" id="subject${status.index }"
							value="${item.subNo }"> <label
							for="subject${status.index }">${item.subName }<i
							class="fas fa-chevron-circle-down"></i></label>
						<div id="info${status.index}">
							<div class="row17">
								<span class="ccc">교수명</span> <span class="aaa">과목명</span> 
								<span class="colflied">1주차</span> <span class="colflied">2주차</span> 
								<span class="colflied">3주차</span> <span class="colflied">4주차</span> 
								<span class="colflied">5주차</span> <span class="colflied">6주차</span>
								<span class="colflied">7주차</span> <span class="colflied">8주차</span>
								<span class="colflied">9주차</span> <span class="colflied">10주차</span>
								<span class="colflied">11주차</span> <span class="colflied">12주차</span>
								<span class="colflied">13주차</span> <span class="colflied">14주차</span>
								<span class="colflied">15주차</span>
							</div>
							<div class="row16">
								<span class="ddd"></span> <span class="bbb"></span> <span
									class="col"></span> <span class="col"></span> <span class="col"></span>
								<span class="col"></span> <span class="col"></span> <span
									class="col"></span> <span class="col"></span> <span class="col"></span>
								<span class="col"></span> <span class="col"></span> <span
									class="col"></span> <span class="col"></span> <span class="col"></span>
								<span class="col"></span> <span class="col"></span>
							</div>
						</div>
					</div>
				</c:forEach>
			</form>
	</c:if>
	<!-- 학생용 if 끝 -->


	<!-- job이 0이면 교수니까 학생부분만 보이도록 -->
	<c:if test="${member.job == 0}">
		<div class="attend">
			<form method="post" action="/attendProc">
				<c:forEach var="item" items="${subjectList }" varStatus="status">
					<div id="attendTable">
						<input type="radio" name="sub_no" id="subject${status.index }"
							value="${item.subNo }"> <label
							for="subject${status.index }">${item.subName }<i
							class="fas fa-chevron-circle-down"></i></label>
						<div id="info">
							<div class="row17">
								<span class="ccc">학생명</span> <span class="aaa">학번</span> <span
									class="colflied">1주차</span> <span class="colflied">2주차</span> <span
									class="colflied">3주차</span> <span class="colflied">4주차</span> <span
									class="colflied">5주차</span> <span class="colflied">6주차</span> <span
									class="colflied">7주차</span> <span class="colflied">8주차</span> <span
									class="colflied">9주차</span> <span class="colflied">10주차</span>
								<span class="colflied">11주차</span> <span class="colflied">12주차</span>
								<span class="colflied">13주차</span> <span class="colflied">14주차</span>
								<span class="colflied">15주차</span>
							</div>
							<div class="row16">
								<span class="ddd"></span> <span class="bbb"></span> <span
									class="col"></span> <span class="col"></span> <span class="col"></span>
								<span class="col"></span> <span class="col"></span> <span
									class="col"></span> <span class="col"></span> <span class="col"></span>
								<span class="col"></span> <span class="col"></span> <span
									class="col"></span> <span class="col"></span> <span class="col"></span>
								<span class="col"></span> <span class="col"></span>
							</div>
						</div>
					</div>
				</c:forEach>
			</form>
	</c:if>
	<!-- 교수용 if 끝 -->
	</div>
	<script>
		var JSONstrForProf = [ "stdName", "stdNo", "attWeek1", "attWeek2",
				"attWeek3", "attWeek4", "attWeek5", "attWeek6", "attWeek7",
				"attWeek8", "attWeek9", "attWeek10", "attWeek11", "attWeek12",
				"attWeek13", "attWeek14", "attWeek15" ];
		var JSONstrForStd = [ "profName", "subName", "attWeek1", "attWeek2",
				"attWeek3", "attWeek4", "attWeek5", "attWeek6", "attWeek7",
				"attWeek8", "attWeek9", "attWeek10", "attWeek11", "attWeek12",
				"attWeek13", "attWeek14", "attWeek15" ];

		$('input[name="sub_no"]')
				.on(
						'click',
						function(self) {
							var subject = $(this);
							var subNo = this.value;
							var job = document.querySelector('#hiddenJob').value;

							var parent = this.closest('div');
							var div1 = parent.lastChild;
							var info = div1.previousSibling;
							var row16 = info.children[1];

							var httpRequest = new XMLHttpRequest();

							httpRequest.onreadystatechange = function() {

								if (httpRequest.readyState == 4
										&& httpRequest.status == 200) {
									var text = httpRequest.responseText;
									var json = new Array();
									json = JSON.parse(text);
									console.log(json);
									//활용부분

									if (json.length == 1) { //학생이면
										var jStd = json[0];
										for (var i = 0; i < JSONstrForStd.length; i++) {
											row16.children[i].innerHTML = jStd[JSONstrForStd[i]];
										}
									} else { //교수면
										for (var n = 1; n < json.length; n++) {
											var row = row16.cloneNode(true);
											info.appendChild(row);
										}
										//json에 있는 학생 수 만큼 row16을 info에 추가.

										/*
										JSON에는 student0~N까지의 항목이 들어가있고
										그 갯수만큼 row16이 복사되어야하고
										그 갯수만큼 for문이 돌아가야함.
										
										 */

										for (var i = 1; i < info.children.length; i++) {
											console.log(info.children.length);
											var stdColumn = info.children[i];
											var stdJSON = json[(i - 1)];
											console.log(stdJSON);
											console.log(i);
											console.log(stdColumn);
											console.log(stdColumn)

											for (var j = 0; j < JSONstrForProf.length; j++) {
												stdColumn.children[j].innerHTML = stdJSON[JSONstrForProf[j]];
											}

										}
									}
									//활용부분
								}

							};

							httpRequest.open('post', '/attendProc', true);
							httpRequest.setRequestHeader("Content-Type",
									"application/x-www-form-urlencoded");
							httpRequest.send('sub_no=' + subNo);

						});
	</script>
</body>

</html>
