<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[hello.jsp]</title>
</head>
<body>
	<%
		String data = request.getParameter("title");
	if(data == "hb" || data.equals("hb")){
	%>
		<font size=6 color=blue>
			<b><%= data %> 로그인 성공!!! </b>
		</font><br>
		<img src="images/bt_login.gif" width=250 height=50>
	
	<%
	}else{ response.sendRedirect("index.jsp"); }
	%>
</body>
</html>