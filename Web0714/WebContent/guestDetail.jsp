<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>[guestDetail]</title>
  <Style>
	*{font-size:16pt; font-weight:bold;}
	a{font-size:16pt; color:blue; text-decoration:none;}
	a:hover{font-size:20pt; color:green; text-decoration:underline;}
	div.tit{font-size:26pt; font-weight:bold; color:red; }
  </Style>

</head>
<body>

 <table width=700 border=1 cellspacing="0" cellpadding="2">
   <tr>
	  <td colspan='2' align="center"> 
	    <div class='tit'> ${dto.name}님의 상세정보 </div> 
	  </td>
   </tr>
	
   <tr>
	 <td rowspan="5" align="center">
	   <img src = './images/bbb.gif'>
	 </td>
     <td>사번 : ${dto.sabun} </td>
   </tr>
  
 <tr><td>이름 : ${dto.name} </td></tr>
 <tr><td>제목 : ${dto.title} </td></tr>
 <tr><td>날자 : ${dto.nalja} </td></tr>
 <tr><td>급여 : ${dto.pay} </td></tr>

 <tr>
	<td colspan='2' align="center"> 
	   <a href="index.jsp">[index]</a>
	   <a href="delete.do?idx=${dto.sabun} ">[삭제]</a>
	   <a href="guestJoin.jsp">[guestJoin]</a>
	   <a href="preEdit.do?idx=${dto.sabun}">[수정]</a>
	   <a href="list.do">[전체출력]</a><br>
	</td>
 </tr>
</table>

 <p>
   <jsp:include page="guestreply.jsp" flush="false" /> 
 <br>
 

</body>
</html>



