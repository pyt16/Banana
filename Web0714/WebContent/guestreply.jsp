<%@ page language="java" contentType="text/html; charset=UTF-8"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestreply.jsp]</title>
	<style type="text/css">
	  *{font-size:18pt; font-weight:bold;}
	  a{text-decoration:none;font-size:18pt; color:blue;}
	  a:hover{text-decoration:underline;font-size:20pt; color:green;}
	</style>
</head>
<body>
 <!-- guestreply.jsp문서  단독실행금지 -->

<form  method="get"  action="reply.do" >
  <table width="700"  border='0' cellspacing="0">
 	<input type="hidden"  name="insert"  value="flag">
 	<input type="hidden"  name="sabun"  value="${reply_sabun}">
 	<tr align="center">
 	  <td><b><img src="images/x1.gif">작성자:<img src="images/x1.gif"></b>
 		<input type="text"  name="writer" size=20> 
 		<input type="submit"  value="댓글저장 "  style="height:25pt;">     
 	  </td>
 	</tr>
 	<tr align="center">
 	  <td>
 		<textarea  name="content" cols="60" rows=3></textarea>
 	  </td>
 	</tr>
  </table>
 </form>

 
 <p>
  <table width="650"  border='0' cellspacing="0">
   <tr  bgcolor="pink"  height='30'  align="center">
 	   <td colspan=4>댓글 데이타 내용 표시</td>       
   </tr>
 
  <tr  
    onMouseOver="style.background='#00FFFF'" 
    onMouseOut="style.background='' "
  >
	 <c:forEach var="rbean" items="${rnaver}">
	    <td width=100> ${rbean.writer} </td>
	 	<td width=100> ${rbean.content} </td>  
	 	<td width=300> ${rbean.sabun}</td>
	 	<td width=150> 
	 	   <a href=" "> [수정] </a>
		   <a href="replyDelete.do"> [삭제] </a> 
	 	 </td>  
	 </c:forEach>     
  </tr>
  
</table>	
</body>
</html>