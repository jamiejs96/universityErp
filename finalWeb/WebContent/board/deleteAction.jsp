<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="bbs.Bbs"%>
<%@ page import="java.io.PrintWriter"%>
<% request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학사공지</title>
</head>
<body>
   <%
   String userID = null;
   if (session.getAttribute("id") != null) {
      userID = session.getAttribute("id") + "";
   }
         if (userID == null) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('로그인을 하세요.')");
      script.println("location.href = '/../main.jsp'");
      script.println("</script>");
         }
         int bbsNo = 0;
         if (request.getParameter("bbsNo") != null) {
      bbsNo = Integer.parseInt(request.getParameter("bbsNo"));
         }
         if (bbsNo == 0) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('유효하지 않은 글입니다.')");
      script.println("location.href = '/../main.jsp'");
      script.println("</script>");
         }
         Bbs bbs = new BbsDAO().getBbs(bbsNo);
         if (!userID.equals(bbs.getUserID())) {
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("alert('권한이 없습니다.')");
      script.println("location.href = '/../main.jsp'");
      script.println("</script>");
         } else {
      BbsDAO bbsDAO = new BbsDAO();
      int result = bbsDAO.delete(bbsNo);
      if (result == -1) {
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('글삭제에 실패하였습니다.')");
         script.println("history.back()");
         script.println("</script");
      } else {
         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("location.href = '/../main.jsp'");
         script.println("</script>");
             }
         }
   %>
</body>
</html>