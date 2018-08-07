<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="net.hb.common.DBSQL" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<!-- <jsp:useBean id="ds2" class="net.hb.common.DBSQL" /> -->
<% 
	String data = request.getParameter("idx");
	DBSQL dbsql = new DBSQL();
	dbsql.dbDelete(data);
	response.sendRedirect("guestList.jsp");
%>
</body>
</html>








