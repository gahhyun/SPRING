<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="loginout" value="${sessionScope.id==null ? 'Login' : 'Logout' }" />
<c:set var="loginoutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout' }" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="<c:url value='/resources/css/menu.css' />"/>
    <title>earth</title>
    
</head>
<body>
    <div id="menu">
    	<ul>
    		<li id="logo"><a href="<c:url value='/'/>">OTTT</li>
    		<li><a href="<c:url value='/'/>">Home</a></li>
    		<li><a href="<c:url value='/'/>">main</a></li>
    		<li><a href="<c:url value='${loginoutLink }'/>">${loginout}</a></li>
    		<li><a href="<c:url value='/'/>">SingUp</a></li>
    		<li><a href=""><i class="fa fa-search"></i></a></li>
    	</ul>
    </div>
    <div id="main2" style="background: black;">
    	<h1 class="before2" style="text-align: center; color: white;">
    		로그인 필요
    	</h1>
    </div>
</body>
</html>