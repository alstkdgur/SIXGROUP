<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogInForm</title>
</head>
<body>
   <input type="text" name="memberInfo" placeholder="아이디를 입력해주세요"/>
   <input type="password" name="memberInfo" placeholder="패스워드를 입력해주세요"/>
   <input type="button" value="서버 요청" onClick="moveLoginForm()"/>
</body>

<script>
  function moveLoginForm(){
	 var memberInfo = document.getElementByName("memberInfo");
      
	 var form = document.createElement("form");
	 form.action = "Login";
	 form.method = "POST";
	 
	 form.appendChild(memberInfo);
	 document.body.appendChild(form);
	 
	 form.submit();
  }
</script>
</html>