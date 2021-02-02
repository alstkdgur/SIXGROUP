<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<style>
* {
  box-sizing: border-box;
}
body {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0;
}
.line {
  width: 1260px;
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
}
#section{
	width:480px
}
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
