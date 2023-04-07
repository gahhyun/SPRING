<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <style type="text/css">
    	*{box-sizing: border-box;}
    	.title{
    		font-size: 50px;
    		margin: 40px 0 30px 0;
    	}
    	form{
    		width: 400px;
    		height: 600px;
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
    	
    	.msg{
    		height: 30px;
    		text-align: center;
    		font-size: 16px;
    		color: red;
    		margin-bottom: 20px;
    	}
    	
    	label{
    		width: 300px;
    		height: 30px;
    		margin-top: 4px;
    	}
    	
    	.input-field{
    		width: 300px;
    		height: 40px; 
    		border: 1px solid #33ff33; 
    		border-radius: 5px;
    		padding: 0 10px;
    		margin-bottom: 10px;  		
    	}
    	button {
			background-color: #33ff33;
			color: white;
			width: 300px;
			height: 50px;
			font-size: 17px;
			border: none;
			border-radius: 5px;
			margin: 20px 0 30px 0;
		}
    
    </style>
    <title>로그인</title>
</head>
<body>
	
	<form action="<c:url value="/login/result"/>" method="post" onsubmit="return formcheck(this)" >
		<div class="title">Login</div>	
		<div class="msg" id="msg"></div>
		
		<label>아이디</label>
		<input type="text" name="id" class="input-field" placeholder="6~12자리 영대소문자,숫자 조합" autofocus/>
		<label>비밀번호</label>
    	<input type="password" name="pwd" class="input-field" placeholder="8~12자리 영대소문자,숫자 조합" />
    	<button>회원가입</button>
	</form>
	
	<script type="text/javascript">
		function formcheck(frm) {
			let msg = ''
			
			if(frm.pwd.value.length < 8){
				setMessage('pwd 길이는 8자리 이상이어야 합니다', frm.pwd)
				return false;
			}
			
			if(frm.id.value.length < 6){
				setMessage('id 길이는 6자리 이상이어야 합니다', frm.id)
				return false;
			}
			
			return true;		
		}
		
		
		function setMessage(msg, element) {
			document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle">${'${msg}'}</i>`
			
			if(element){
				element.select()		
			}
		}
	</script>
    
</body>
</html>