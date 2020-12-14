<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<link rel="stylesheet" href="/css/style_login.css">
<script src="/js/jquery-3.5.1.min.js"></script>
</head>

<body>
   <section class="login-form">
      <h1>SOL UNIVERSITY</h1>
      <form>
         <div class="radio-area">
            <ul>
               <input type="radio" name="job" value="1" checked
                  onclick="pwCheck()">
               <span class="job">STUDENT</span>
               <input type="radio" name="job" value="0" onclick="pwCheck()">
               <span class="job">PROFESSOR</span>
            </ul>
         </div>
         <div class="int-area">
            <input type="text" id="id" name="id" autocomplete="off" required
               onchange="pwCheck()"> <label for="id">NUMBER</label>
         </div>
         <div class="int-area">
            <input type="password" id="pw" name="pw" autocomplete="off" required>
            <label for="pw">PASSWORD</label>
         </div>
         <div class="btn-area">
            <button type="button" id="btn" onclick="login()">LOGIN</button>
         </div>
         <div class="caption">
            <a href="forgotPW.jsp">FORGOT PASSWORD</a>
         </div>
      </form>
   </section>
   <script>
      let j_id = $("#id");
      let j_pw = $("#pw");
      let j_btn = $("#btn");

      var num = /^[0-9]*$/;

      $(j_btn)
            .on(
                  'click',
                  function abc() {
                     //function login() {
                     if ($(j_id).val() == "") {
                        $(j_id).next('label').addClass('warning');
                        setTimeout(function() {
                           $('label').removeClass('warning');
                        }, 1500);

                     } else if ($(j_pw).val() == "") {
                        $(j_pw).next('label').addClass('warning');
                        setTimeout(function() {
                           $('label').removeClass('warning');
                        }, 1500);
                     } else {
                        var formPw = document.querySelector('#pw').value;
                        if (DBpw == formPw) {
                           var id = document.querySelector('#id').value;
                           var job = document
                                 .querySelector('input[name="job"]:checked').value;
                           location.href = '/loginProc?id=' + id
                                 + '&job=' + job;
                        } else {
                           alert('아이디 혹은 비밀번호가 일치하지 않습니다.');
                        }
                     }
                  });

      var DBpw;

      function pwCheck() {

         var regexp = /[^0-9]/gi;
         var v = document.querySelector('#id');
         if (regexp.test(v.value)) {
            alert("숫자만 입력 가능합니다.");
            //숫자 이외에 입력된애들 다 지워줌.
            v.value = v.value.replace(regexp, '');
            //지워준 이후 id칸에 있는 번호로 다시한번 비밀번호를 DB에서 가져옴
            pwCheck();

         } else if (v.value != "") {

            var id = document.querySelector('#id').value;
            var job = document.querySelector('input[name="job"]:checked').value;

            var httpRequest = new XMLHttpRequest();
            httpRequest.onreadystatechange = function() {
               if (httpRequest.readyState == 4
                     && httpRequest.status == 200) {
                  var text = httpRequest.responseText;
                  var json = JSON.parse(text);
                  DBpw = json.pw;
                  document.querySelector('#div1').innerHTML = DBpw;
               }

            };
            httpRequest.open('post', '/jsonPw', true);
            httpRequest.setRequestHeader("Content-Type",
                  "application/x-www-form-urlencoded");
            httpRequest.send('id=' + id + '&job=' + job);

         }
      }
   </script>
   <div id="div1">ddd</div>
</body>

</html>