<%@page import="com.earth.pluto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 속성 저장 */
	pageContext.setAttribute("earthInteger", 629);
	pageContext.setAttribute("earthString", "페이지 영역의 문자열");
	pageContext.setAttribute("pagePerson", new Person("이순신", 40));
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>page 영역</title>
</head>
<body>
    <h2>>page 영역의 속성값 읽기</h2>
    <%
    	Integer pInteger = (Integer)(pageContext.getAttribute("earthInteger"));
    	String pString = pageContext.getAttribute("earthString").toString();
    	Person person = (Person)(pageContext.getAttribute("pagePerson"));
    %>
    <ul>
    	<li>Integer 객체 : <%=pInteger %></li>
    	<li>String 객체 :<%=pString %> </li>
    	<li>Person 객체:<%=person.getName() %> , <%=person.getAge() %> </li>
    </ul>
    
    <h2>inciude된 파일에서 읽어오기</h2>
    <%@ include file="pageContextInclud.jsp" %>
</body>
</html>