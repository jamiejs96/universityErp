<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/41a45cc36e.js"	crossorigin="anonymous"></script>
<link href="/css/standard.css" rel="stylesheet">
<title>성적Section</title>
<style>
#scoreSection {
	float: right;
	position: relative;
	width: calc(100% - 160px);
	height: 100%;
}

#scoreWrap {
	position: relative;
	/* height: 100%; */
	margin: 0 200px;
}

#scoreTable {
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

input[id*="sem"] {
	display: none;
}

input[id*="sem"]+label {
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

#scoreTable i {
	display: flex;
	float: right;
	color: white;
	font-size: 25px;
}

input[id*="sem"]+label+div {
	max-height: 0;
	transition: all .35s;
	overflow: hidden;
}

input[id*="sem"]+label+div span {
	display: inline-block;
	width: 218px;
	height: 10px;
	background: #B9CFD2;
	padding: 20px;
	border-radius: 5px;
	text-align: center;
}

input[id*="sem"]+label+div .col {
	background: #f5f4f1;
}

input[id*="sem"]:checked+label+div {
	max-height: 1000px;
}
</style>

</head>
<body>
	   <div id="scoreWrap">
      <c:forEach var="semester" items="${scores }" varStatus="status">
         <div id="scoreTable">
            <!-- 학기별로 빼옴 -->
            <c:set var="score" value="${semester.value }" />
            <!--  학기별로 빼온 list에서 또 forEach사용해서 각각의 과목을 빼옴 -->


            <input type="radio" name="subNumber"
               id="sem${semester.key }" value="${item.subNo }"> <label
               for="sem${semester.key }">20${fn:substring(semester.key,0,2)}년&nbsp;
               ${fn:substring(semester.key,3,4)}학기<i
               class="fas fa-chevron-circle-down"></i>
            </label>
            <div id="info${semester.key}">
               <div class="row17">
                  <span class="colflied">강의코드</span> <span class="colflied">강의명</span>
                  <span class="colflied">교수명</span> <span class="colflied">학생성적</span>
                  <span class="colflied">학점</span>
               </div>
               <c:forEach var="s" items="${score}">
                  <div class="row16">
                     <span class="col">${s.subNo }</span> <span class="col">${s.subName }</span>
                     <span class="col">${s.profName}</span> <span class="col">${s.stdScore }</span>
                     <span class="col">${s.subCredit }</span>
                  </div>
               </c:forEach>
            </div>
         </div>
      </c:forEach>
   </div>
</body>
</html>