<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>400</title>
</head>
<body>
    <h1>[400] 잘못된 요청입니다. 확인 후 다시 한번 요청해주세요.</h1>
    발생한 예외 : ${pageContext.exception }<br>
    예외 메세지 : ${pageContext.exception.message }<br>
    
    <ol>
    	<c:forEach items="${pageContext.exception.stackTrace }" var="i">
    		<li>${i.toString() }</li>
    	</c:forEach>
    </ol>
</body>
</html>