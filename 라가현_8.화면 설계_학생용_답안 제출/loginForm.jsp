<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style type="text/css">
    	*{box-sizing: border-box;}
    	.box{
    		width: 500px;
    		height: 280px;
    		display: flex;
    		flex-direction: column;
    		align-items: center;
    		position: absolute;
    		top:50%;
    		left: 50%;
    		border: 1px solid #33ff33;
    		border-radius: 10px;
    		transform: translate(-50%, -50%);
    	}
    	
    	.title{
    		font-size: 70px;
    		
    	}
    	
    </style>
    <title>login result</title>
</head>
<body>
	<div class="box">
		<div class="title">로그인 완료!</div>
		    <h1>id : ${param.id }</h1>
    		<h1>pwd : ${param.pwd }</h1>
	</div>
    	
    
</body>
</html>