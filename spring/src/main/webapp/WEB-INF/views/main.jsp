<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<link rel="stylesheet" type="text/css" href="/resources/css/movie.css"/>

<!DOCTYPE html>
<html>

<head>
	<title>main</title>
</head>
<body>
<h1>
	MOVIE SELECTION
</h1>

	<section id="section">${mvList }</section>

</body>
<script>
function goDate(mvCode){
	   var mvCode = mvCode;         
	   
	   var form = document.createElement("form");
	   form.action = "date";
	   form.method = "GET";

	   
	   //서버전송 데이터 : mvCode
	      var input = document.createElement("input");
	      input.type = "hidden";
	      input.name = "mvCode";
	      input.value = mvCode;
	      form.appendChild(input);
	   
	   
	   document.body.appendChild(form);
	   form.submit();
	}
</script>
</html>
