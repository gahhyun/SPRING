<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page 영역</title>
</head>
<body>
    <h4>include 페이지</h4>
    <%
    Integer pInteger2 = (Integer)(pageContext.getAttribute("earthInteger"));
    %>
    <ul>
		<li>Integer 객체 : <%=pInteger2 %></li>    
    </ul>
    
    <a href="pageContextLocation.jsp" >pageContextLocation.jsp 바로가기 </a>
</body>
</html>