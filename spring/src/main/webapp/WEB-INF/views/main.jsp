<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<style>
.item_top{
	width:100px;
	hight:200px;
}
.item_bottom{
	width:100px;
	hight:20px;
}
</style>
<head>
	<title>main</title>
</head>
<body>
<h1>
	MOVIE SELECTION
</h1>

	<section id="section">${gList }</section>

</body>
</html>
