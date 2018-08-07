<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi2.jsp" %>
<%@ page import="net.hb.common.DBSQL" %>
<%@ page import="net.hb.common.DBbean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestEditSave.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;}
    a{text-decoration:none; font-size:20pt; color:red; }
    a:hover{text-decoration:underline; font-size:26pt; color:green; } 
  </style>	
</head>
<body>
  <font color=blue> guestEditSave.jsp </font> <p> 
<% 
	DBSQL dbsql = new DBSQL();
	DBbean bean = new DBbean();
		bean.setSabun(Integer.parseInt(request.getParameter("sabun")));
		bean.setName(request.getParameter("name"));
		bean.setTitle(request.getParameter("title"));
		bean.setPay(Integer.parseInt(request.getParameter("pay")));
	dbsql.dbEdit(bean);
	response.sendRedirect("guestList.jsp");

%>
</body>
</html>








