<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 결과</title>
</head>
<body>
	<!-- 폼값 처리하기 위한 내장 객체 
        -param
            -request.getParameter("매개변수명")과 동일하게 요청 매개변수의 값을 받아옴
        -paramValues
            -request.getParameterValues("매개변수명")과 동일하게 요청 매개변수의 값을 문자열 배열로 받아옴
            -다중 선택이 가능한 checkbox를 통해 전달된 폼값을 받을 때 사용 -->
            
    <h1>id : ${param.id }</h1>
    <h1>pwd : ${param.pwd }</h1>
    <h1>name : ${param.name }</h1>
    <h1>email : ${param.email }</h1>
    <h1>birth : ${param.birth }</h1>
    <h1>sns : ${paramValues.sns[0] }</h1>
    <h1>sns : ${paramValues.sns[1] }</h1>
    <h1>sns : ${paramValues.sns[2] }</h1>
</body>
</html>

