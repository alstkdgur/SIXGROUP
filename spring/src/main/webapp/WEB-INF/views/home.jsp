<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${welcome} 
</h1>
<P>  The time on the server is ${serverTime}. </P>
 <a href="http://192.168.0.36/loginForm">로그인폼 이동</a> 
</body>
</html>
