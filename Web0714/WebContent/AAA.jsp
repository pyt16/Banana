<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [AAA.jsp]</title>
	<style type="text/css">
	  *{font-size:16pt; font-weight:bold; }
	</style>
	<script type="text/javascript">
	</script>
</head>
<body>
	
	<form method="post" action="./BBB.jsp" enctype="multipart/form-data">
		이름: <input type="text" name="name" value="이순신"><br>
		제목: <input type="text" name="title" value="test"><br>
		파일: <input type="file" name="file1"><br>
		test: A<input type="checkbox" name="checkbox" value="A">
			 B<input type="checkbox" name="checkbox" value="B">
			 C<input type="checkbox" name="checkbox" value="C"><br>
		<input type="submit" value="파일전송하기">
	</form>
   
</body>
</html>