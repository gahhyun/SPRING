<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 클래스 영역 --%>
 <%!
 	int getRandomInt(int range) {
	 return new Random().nextInt(range+1);
 }
 %>
 
<%-- 메서드 영역 --%>
<% 
   int idx1 = getRandomInt(6); 
   int idx2 = getRandomInt(6);
%>

<!DOCTYPE html>
<html lang="ko">
<!--  -->
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>JSP 페이지</title>
</head>
<body>
   <img alt="주사위1" src="img/dice<%=idx1%>.jpg">
   <img alt="주사위2" src="img/dice<%=idx2%>.jpg">
</body>
</html>