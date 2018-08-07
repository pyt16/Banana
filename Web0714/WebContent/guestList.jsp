<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestList.jsp]</title>
	<style type="text/css">
	  *{font-size:18pt; font-weight:bold;}
	  a{text-decoration:none;font-size:18pt; color:blue;}
	  a:hover{text-decoration:underline;font-size:20pt; color:green;}
	</style>
	
	<script type="text/javascript">
	  function changeClear( ){
		 myform.keyword.value="";
		 myform.keyword.focus( ); 
	  }
	</script>
</head>
<body>
<%
  
%>
 
<table width=900 border=1 cellspacing="0" >
  <tr align="right">
    <td colspan="6">조회:${searchGtotal} / 총:${Gtotal} &nbsp;&nbsp;</td>
  </tr>
  
  <tr bgcolor="yellow">
    <td>행번호</td>  <td>사번</td>   <td>이름</td> 
    <td>제목</td>   <td>날짜</td> <td>급여</td>
  </tr>
   
 <c:forEach var="dto" items="${naver}">  
  <tr>
    <td> ${dto.rn}  </td>
    <td> ${dto.sabun}  </td>
    <td> ${dto.getName()}   </td>
    <td> <a href="detail.do?idx=${dto.sabun}"> ${dto.title} </a> </td>
    <td> ${dto.nalja}  </td>
    <td> ${dto.pay}   </td>
  </tr>
 </c:forEach> 
   
 
 <!-- MVC2, SPRING 페이징계산을 자바에서처리, JSTL사용  -->
 <tr align="center">
  <td colspan="6">
	   <c:if test="${startpage>10}">
	    <a href="list.do?pageNum=${startpage-10}">[이전]</a>
	   </c:if>
	   
	  <c:forEach var="i" begin="${startpage}" end="${endpage}">
	     <c:choose>
	       <c:when test="${pageNUM==i}"> <font color=red>[${i}]</font></c:when>
	       <c:otherwise>
	         <a href="list.do?pageNum=${i}${returnpage}">[${i}]</a>
	       </c:otherwise>
	     </c:choose>
	  </c:forEach>
	  
	   <c:if test="${endpage<pagecount}">
	      <a href="list.do?pageNum=${startpage+10}">[다음]</a>
	   </c:if>
  </td>
 </tr>
 
 <tr align="center">
 	<td colspan="6">
 	  <form name="myform"   action="list.do">
 	      <select name="keyfield" onchange="changeClear();">
 	      	<option value="" selected="selected">전체검색</option>
 	      	<option value="name"  <c:if test="${! empty AA}">selected</c:if> >이름검색</option>
 	      	<option value="title" <c:if test="${! empty BB}">selected</c:if> >제목검색</option>
 	      	<option value="">내용검색&nbsp;&nbsp; </option>
 	      </select>
 	      <input type="text" name="keyword"  value="${sval}">
 	      <input type="submit" value="검색 ">   
 	  </form>
 	</td>
 </tr>

</table>
      
 <br>
 <a href="./login.jsp"> [로그인] </a>
 <a href="./index.jsp"> [index] </a>
 <a href="./guestJoin.jsp"> [guestJoin] </a>
 <a href="./list.do"> [list.do] </a>
</body>
</html>








