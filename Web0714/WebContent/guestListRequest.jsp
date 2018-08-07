<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="net.hb.common.GuestDTO" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestListRequest.jsp]</title>
	<style type="text/css">
	  *{font-size:16pt; font-weight:bold;}
	  a{text-decoration:none;font-size:16pt; color:blue;}
	</style>
</head>
<body>
 
<table width=900 border=1 cellspacing="0" >
  <tr align="right">
    <td colspan="6">레코드갯수 : <%=33%> &nbsp;&nbsp;</td>
  </tr>
  
  <tr bgcolor="yellow">
    <td>행번호</td>  <td>사번</td>   <td>이름</td> 
    <td>제목</td>   <td>날짜</td> <td>급여</td>
  </tr>
  <%
    //guestListRequest.jsp
  	ArrayList<GuestDTO> ob = (ArrayList<GuestDTO>)request.getAttribute("naver");
    for(int i=0; i<ob.size(); i++){
    	GuestDTO dto = ob.get(i);
  %>  
  <tr>
    <td> <%= dto.getRn() %>  </td>
    <td> <%= dto.getSabun() %>  </td>
    <td> <%= dto.getName() %>   </td>
    <td> <%= dto.getTitle() %> </td>
    <td> <%= dto.getNalja() %>  </td>
    <td> <%= dto.getPay() %>   </td>
  </tr>
  <%
    }//for end
  %>
 
 <tr align="center">
  <td colspan="6">
    <%
    		 
     for(int i=1; i<=10; i++){
       out.print("<a href=guestList.jsp>["+i+"]</a>"); 
     }
     
    %>
  </td>
 </tr>

</table>
      
 <br>
 <a href="./login.jsp"> [로그인] </a>
 <a href="./index.jsp"> [index] </a>
 <a href="./guestJoin.jsp"> [guestJoin] </a>
 <a href="./guestList.jsp"> [guestList] </a>
</body>
</html>








