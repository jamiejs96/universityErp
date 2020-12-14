<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/standard.css">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="https://kit.fontawesome.com/41a45cc36e.js"
	crossorigin="anonymous"></script>
<title>Menu</title>

<style>
#menu {
	position: absolute;
	height: calc(75% - 10px);
	border-radius: 4px;
	background: #EBF5EB;
	width: 160px;
	z-index: 3;
}

.item {
	overflow: hidden;
}

ul {
	margin: 0;
	padding: 0;
	text-decoration: none;
	position: relative;
	width: 100%;
}

.btn {
	display: block;
	border-radius: 4px;
	position: relative;
	padding: 16px 20px;
	background: #EBF5EB;
	color: #4d4d4d;
}

.btn::before {
	content: "";
	position: absolute;
	width: 14px;
	height: 14px;
	background: #EBF5EB;
	left: 20px;
	bottom: -7px;
	transform: rotate(45deg);
}

.btn i {
	margin-right: 10px;
}

.smenu {
	background: #A9C7B2;
	overflow: hidden;
	transition: max-height 0.5s;
	max-height: 0;
}

.smenu a {
	display: block;
	padding: 16px 26px;
	color: #454545;
	font-size: 14px;
	margin: 4px 0;
	position: relative;
	margin: 4px 0;
}

.smenu a:before {
	content: "";
	position: absolute;
	width: 6px;
	height: 100%;
	background: #fff;
	left: 0px;
	top: 0;
	transition: 0.5s;
	opacity: 0;
}

.smenu a:hover:before {
	opacity: 1;
}

.item:target .smenu {
	max-height: 20em;
} /*추가됫어용*/
#logout {
	background: coral;
	border: 1px solid;
	padding: 5px;
	position: fixed;
	top: 50px;
	right: 100px;
	color: white;
}
</style>
<script>
	var logout = function() {
		alert('로그아웃 되었습니다.');
		location.href = '/login/logout.jsp';
	}
</script>
</head>
<body>
	<nav class="menu">
		<ul>
			<li class="item" id="personal"><a href="#personal" class="btn"><i class="fas fa-user"></i>개인</a>
				<div class="smenu">
					<a href="/personal/personalInfo.jsp">개인정보</a>
				</div>
			</li>

			<li class="item" id="class"><a href="#class" class="btn"> <i class="fas fa-book-open"></i>수업</a>
				<div class="smenu">
					<a href="/currSub">수강신청</a> <a href="/attendBeforeSelect">출결</a> 
					<a href="/absentBeforeSelect">결석신청</a>
				</div>
			</li>

			<li class="item" id="score"><a href="#score" class="btn"><i class="fas fa-star-half-alt"></i>성적</a>
				<div class="smenu">
					<a href="/semesterProc">학기별성적</a>
				</div>
			</li>
			
			<li class="item" id="school"><a href="#school" class="btn"><i class="fas fa-clipboard-list"></i>학적</a>
				<div class="smenu">
					<a href="/restBack">휴학/복학</a>
				</div>
			</li>
			
			<li class="item" id="graduate"><a href="#graduate" class="btn"><i class="fas fa-clipboard-list"></i>졸업</a>
				<div class="smenu">
					<a href="/GraduateProc">졸업요건확인</a>
				</div>
			</li>

		</ul>
	</nav>
	<span id="logout" onclick="logout()">로그아웃</span>
</body>
</html>