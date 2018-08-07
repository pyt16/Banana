<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestJoin.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;}
    a{text-decoration:none; font-size:20pt; color:red; }
    a:hover{text-decoration:underline; font-size:26pt; color:green; } 
  </style>
  
</head>
<body>
  <font color=blue> guestJoin.jsp </font> <p>
  
  <form name="myform"  method="post" action="insert.do">
  	사번: <input type="text" name="sabun"> <br>
  	이름: <input type="text" name="name"  value="bc"> <br>
        제목: <input type="text" name="title" value="snow"> <br>
        급여: <input type="text" name="pay" value="97"> <br>
     <input type="submit"  value="MVC2저장">
     <input type="reset" value="입력취소">
  </form>
    
  <p>
  <a href="index.jsp"> [index] </a>
  <a href="guestJoin.jsp"> [guestJoin] </a>
  <a href="list.do"> [전체출력] </a>
</body>
</html>




