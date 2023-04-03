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
    <h2>page 영역 속성값 읽기</h2>
    <%
    	Object pInteger = pageContext.getAttribute("earthInteger");
    	Object pString = pageContext.getAttribute("earthString");
    	Object person = pageContext.getAttribute("pagePerson");
    %>
    
    <ul>		
    	<li>Integer 객체 : <%= (pInteger == null ? "값 없음" : pInteger) %></li>
    	<li>String 객체 : <%= (pString == null ? "값 없음" : pString) %></li>
    	<li>Person 객체 : <%= (person == null ? "값 없음" : person) %></li>
    </ul>
</body>
</html>