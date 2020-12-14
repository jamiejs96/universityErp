<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
   
<%@ page import="bbs.BbsDAO"%>
<%@ page import="member.proc.LoginProc"%>
<%@ page import= "member.dao.MemberDAO"%>
<%@ page import= "member.dto.Member"%>
<%@ page import= "member.dto.StudentAdd"%>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="bbs" class="bbs.Bbs" scope="page" />
<jsp:setProperty name="bbs" property="bbsTitle" />
<jsp:setProperty name="bbs" property="bbsContent" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사공지</title>
</head>
<body>
   <%
      String userID = null ;
         if (session.getAttribute("id") != null) {
      userID = session.getAttribute("id") + "";
         }
         
         if (userID == null) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('로그인을 하세요.')");
      script.println("location.href = '/../main.jsp'");
      script.println("</script>");
         } else {
      if (bbs.getBbsTitle() == null || bbs.getBbsContent() == null) {
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('입력이 완료되었는지 확인하세요.')");
         script.println("history.back()");
         script.println("</script>");
      } else {
         BbsDAO bbsDAO = new BbsDAO();
         int result = bbsDAO.write(bbs.getBbsTitle(), userID, bbs.getBbsContent());
         if (result == -1) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('글쓰기에 실패하였습니다.')");
      script.println("history.back()");
      script.println("</script");
         } else {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("location.href = '/../main.jsp'");
      script.println("</script>"); 
         }
      }
         }
   %>
</body>

</html>