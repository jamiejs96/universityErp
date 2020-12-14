      var strForJSON = ['a', 'b', 'c', 'd', 'e', 'f', 'g'];
      //strForJSON는 JSON의 이름을 얻기 위해 만든 배열변수
      var request = new XMLHttpRequest();
      //request는 검색을 하기 위한 AJAX 변수
      var cart = new Array();
      var regexp = /[^0-9]/gi;
    
         
      

      /*
      테이블의 아이디   ****이거 안보면 후회함!!!
      #subjects : AJAX로 검색된 과목들의 목록이 뜨는 테이블. 검색어를 입력하지 않은 상태라면 모든 과목이 뜨도록 수정할 예쩡
      
      #cucucu : 수강신청을 이미 해놓은 과목들의 목록
      
      #nowSubjects  subjects테이블 내에서 검색결과로 뜬 과목들 중 주황색 '신청' 버튼을 누르면 추가되는 테이블
      
      */
      
      var createMySubjects;
//      var cucuFunc;
      // #mySubjects테이블 내에 목록을 생성해주는 함수
      $(function(){
        createMySubjects = function(){
         var mySubjects = document.querySelector('#mySubjects');
         mySubjects.innerHTML= ""; //mySubjects의 내용물을 텅 비워줌
         var table = document.createElement('table'); //<table> </table> 
         //
         var upperTr = document.createElement('tr');
//        upperTr.innerHTML = "안녕";
        upperTr.innerHTML = '<th>강의코드</th><th>강의명</th><th>교수명</th><th>시간</th><th>요일</th><th>학점</th><th>정원</th><th>신청</th>';
        table.appendChild(upperTr);
        //
         for(var n in sub){
            var currTr = document.createElement('tr'); //<tr> </tr>
            for(var k in subStr){
               if(k==0){
                  hiddenInput = document.createElement('input'); //<input> </input>
                  hiddenInput.setAttribute('value',sub[n][subStr[k]]); //<input value="170211"> </input>
                  hiddenInput.setAttribute('type','hidden');  //<input value="170211" type="hidden"> </input>
                  currTr.appendChild(hiddenInput); //  <tr> <input value="170211" type="hidden"> </input> </tr>
               }
            var currTd = document.createElement('td');
            currTd.innerHTML = sub[n][subStr[k]];
            currTr.appendChild(currTd); //<tr> aㅁㅇㄻㅇㄻㅇㄻㄴㅇㄹ </tr>
            } //안쪽 for문 끝
            var currDel = document.createElement('td'); // <td> </td>
            currDel.setAttribute('value','삭제'); // <td value='삭제'> </td>
            currDel.innerHTML = '삭제';     // <td value='삭제'>삭제</td>
            currTr.appendChild(currDel); // <tr. fadfadf</tr>
            
            table.appendChild(currTr);   //<table> <tr>adfadf</tr> </table>
         }
         mySubjects.appendChild(table); 
         };
         
         createMySubjects();
      });
      

      
      
      //주황색 '신청' 버튼을 눌렀을때 해당 과목이 이미 신청한 과목과 중복되지 않는지 확인하는 함수
      $(function () {
         $('#subjects').on('click', 'td:last-child', function (self) {
            var subArr = new Array();
            for (var i = 0; i < 7; i++) {
//            for (var i = 0; i < 6; i++) {
               subArr[i] = this.closest('tr').children[i];
            }
            var flag = false;
            
            
            for(var n in sub){
               if((sub[n].subNo) == subArr[0].textContent.replace(regexp,'')){
                  flag = true;
               }
            }
            
            for(var n in cart){
               if(cart[n][0].textContent == subArr[0].textContent){
                  flag = true;
               }
            }
            if(flag == false){   
               cart.push(subArr);
            }
            writeNowSubjects();
         });
      });

      
      
      //추가한 과목의 목록을 #nowSubjects에 만들어주는 함수(cart변수에 들어가있는 애들을 만들어줌)
      function writeNowSubjects() {
         var nowSubjects = document.querySelector('#nowSubjects');
         nowSubjects.innerHTML = '';

         var tab = document.createElement('table');

         /*var submitBtn = document.createElement('input');
         submitBtn.setAttribute('type','submit');
         submitBtn.setAttribute('value','수강신청');
         nowSubjects.appendChild(submitBtn);*/
			


         //var tr =  document.createElement('tr');
         //tr.setAttribute('id','ulul'); //trtr로 바꿔야함
        
         
         for (var i in cart) {
            var tr = document.createElement('tr');
            for (var j in cart[i]) {
               var td = document.createElement('td');
               if (j == 0) {
                  //inin.setAttribute('name', 'subNo' + i);
                  var hiddenInput = document.createElement('input');
                  hiddenInput.setAttribute('type','hidden');
                  hiddenInput.setAttribute('name','subNo'+i);
                  
                  var text = cart[i][j].textContent.replace(regexp,'');
                  if(regexp.test(text)){
                     text = text.replace(regexp,'');
                  }
                  hiddenInput.setAttribute('value',text)
                  td.innerHTML =  text;
                  tr.appendChild(hiddenInput);
               }else{
                  td.innerHTML = cart[i][j].textContent;
            
               }
               tr.appendChild(td);
            }
            var del = document.createElement('td');
            del.innerHTML = '삭제';
            del.setAttribute('value','삭제');
            tr.appendChild(del);
            tab.appendChild(tr);
         }
         nowSubjects.appendChild(tab);

/*         var submitBtn = document.createElement('input');
         submitBtn.setAttribute('type','submit');
         submitBtn.setAttribute('value','수강신청');
         nowSubjects.appendChild(submitBtn);*/
      }



      $(function(){
         searchFunction();
      });

      //검색창에 검색어를 입력했을때 서버에 AJAX로 비동기 통신해서
      //JSON을 받아오는 함수
      function searchFunction() {
         request.open('post','/subProc',true)
         request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
         request.onreadystatechange = searchProcess;
         var str = 'category=' +document.querySelector("#category").value+'&word=' +document.querySelector('#word').value;
         request.send(str);
      }
      
      //위의 searchFunction 내부에서 사용되는 함수로
      //받아온 JSON을 이용해서 #subjects에 테이블을 만들어주는 함수
      function searchProcess() {
         var table = document.querySelector('#subjects');
         table.innerHTML = '';

         if (request.readyState == 4 && request.status == 200) {
            
            var upperTr = document.createElement('tr');
//            upperTr.innerHTML = "안녕";
            upperTr.innerHTML = '<th>강의코드</th><th>강의명</th><th>교수명</th><th>시간</th><th>요일</th><th>학점</th><th>정원</th><th>신청</th>';
            table.appendChild(upperTr);
            //서버로부터 받아온 JSON
            var object = eval('(' + request.responseText + ')');
            var result = object.result;
               for (var i = 0; i < result.length; i++) {
                  var row = document.createElement('tr');
                  var j = 0;
                  for (j = 0; j < strForJSON.length; j++) {
                     var cell = document.createElement('td');
                     cell.innerHTML = result[i][j][strForJSON[j]];
                     row.appendChild(cell);
                  }
                  var c = document.createElement('td');
                  c.innerHTML = "신청";
                  row.appendChild(c);
                  table.appendChild(row);

               }
         }
      }
      
      
      
      $(function(){
         $('#mySubjects').on('click','[value="삭제"]',function(self){
            //alert(this.value)
            
            //cucucu에 현재 신청된 과목의 삭제버튼을 누르면 해당 li의 첫번째에 있는 value값을 가져옴.
            var subNo = this.closest('tr').children[0].value;
            
            //해당 value값과 동일한 값을 가진 sub를 null로 만듦
            for(var i =0; i<sub.length;i++){
               if(sub[i].subNo == subNo){
                  if (i > -1) {
                       sub.splice(i, 1);
                     }
               }
            }
            
            var deleteRequest = new XMLHttpRequest();
            //mySubjects에 있는 삭제 버튼을 누를 경우 DB에 해당 과목을 삭제 하는 AJAX
            var str = 'subNo='+subNo;
            //DB에 AJAX로 삭제 쿼리를 보냄.
            deleteRequest.open('post','/delCurrSub',true)
            deleteRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            deleteRequest.send(str);
            
            //삭제된 이후 createMySubjects함수(현재수강신청 목록을 갱신)해주는 함수 실행
            
            createMySubjects();
            
            //DB로 삭제 보냈음.
            
            //deleteRequest.onreadystatechange = searchProcess;
            //var str = 'category=' +document.querySelector("#category").value+'&word=' +document.querySelector('#word').value;
         })
      });
      
      $(function(){
         //cart에 추가된 목록에서 삭제버튼을 누르게 되면
         $('#nowSubjects').on('click','[value="삭제"]',function(self){
            var delCartSubNo = this.closest('tr').children[0].value;
            for(var i in cart){
               //해당 라인의 첫번째 박스의 value(st_no)과 일치하는 값이 있는 cart의 요소를 삭제하고
               if(cart[i][0].textContent == delCartSubNo){
                  if (i > -1) {
                       cart.splice(i, 1);
                     }
               }
            }
            //목록을 다시 만들어줌.
            writeNowSubjects();
         });
      })