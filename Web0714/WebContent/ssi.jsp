<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.Date" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="net.hb.common.DBSQL" %>
<%@ page import="net.hb.common.DBbean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
   <style type="text/css">
    *{font-size:16pt; font-weight:bold;}
    a{text-decoration:none; font-size:16pt; color:blue; }
    a:hover{text-decoration:underline; font-size:20pt; color:green; } 
  </style>	
</head>
<body>
  <%
    //ssi.jsp문서 기존내용 전부 삭제 
    DBSQL  dbsql = new DBSQL( );
    DBbean bean = new DBbean( );
    //dbsql.dbInsert(7789,"kim","수요일",92);
  %>
 </body>
</html>












