<%@ page language="java" contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestEdit.jsp]</title>
  <style type="text/css">
    *{font-size:25pt; font-weight:bold;}
    a{text-decoration:none; font-size:25pt; color:red; }
    a:hover{text-decoration:underline; font-size:30pt; color:green; } 
  </style>
  
</head>
<body>

  <font color=blue> guestEdit.jsp </font> <p>
  <form name="myform"  action="edit.do" method="get">
  	수정사번:	
  	 <input type="text" name="sabun" value="${dto.sabun}" readonly>	<br>
  	수정이름:
  	 <input type="text" name="name" value="${dto.name}"> <br>
        수정제목:
     <input type="text" name="title" value="${dto.title}"> <br>
        수정급여:
      <input type="text" name="pay" value="${dto.pay}"> <br>
      
      <input type="submit"  value="MVC2수정처리">
      <input type="reset" value="수정취소">
  </form>
    
  <p>
  <a href="index.jsp"> [index] </a>
  <a href="guestJoin.jsp"> [guestJoin] </a>
  <a href="list.do"> [전체출력] </a>
</body>
</html>


