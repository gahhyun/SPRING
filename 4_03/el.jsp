<%@page import="java.util.ArrayList"%>
<%@page import="com.earth.bicycle.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "이순신");
	request.setAttribute("list",new ArrayList());
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EL</title>
</head>
<body>
    <%= person.getCar().getColor() %> <br>
    ${person.getCar().getColor()}<br>
    ${person.car.color }<br>
    ${name}<br>
    ${requestScope.name }<br><br>
    
    <%=request.getAttribute("name") %>
    <%=request.getParameter("id") %>			<!-- 출력X -->
    ${pageContext.request.getParameter("id")}  <!-- null -->
    ${param.id }								<!-- 출력X -->
    <br>
    <br>
    ${"1"+1 }	<!-- 2 출력 -->
    <br>
    ${"1" += "1" }	<!-- 11 출력 -->
    <br>
    ${"2" > 1 }	<!-- true 출력 -->
	<br>
	${null }	<!-- 빈 공간으로 출력됨 -->
	<br>
	${null + 1 } <!-- 1 출력/ 연산가능 -->    
	<br>
	${""+ null } <!-- 0 출력 -->
	<br>
	${"" - 1 }  <!-- -1 출력 -->
	<br>
	${empty null }  <!-- true 출력 -->
    <br>
    ${empty list }  <!-- true 출력 -->
    <br>
    ${null == 0 }  <!-- false 출력 -->
    <br>
    ${null eq 0 }  <!-- false 출력 -->
    <br>
    <br>
    ${name == "이순신" }  <!-- true 출력 -->
    ${name != "이순신" }  <!-- false 출력 -->
    <br>
    ${name eq "이순신" }  <!-- true 출력 -->
    ${name ne "이순신" }  <!-- false 출력 -->
    <br>
    ${name.equals("이순신") }  <!-- true 출력 -->
</body>
</html>