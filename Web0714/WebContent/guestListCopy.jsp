<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="net.hb.common.DBbean" %>
<%@ page import="net.hb.common.DBSQL" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [guestListCopy.jsp]</title>
	<style type="text/css">
	  *{font-size:16pt; font-weight:bold;}
	  a{text-decoration:none;font-size:16pt; color:blue;}
	</style>
</head>
<body>
<%
	//복사본 guestListCopy.jsp
  DBSQL ds=new DBSQL();
  int mytotal=ds.dbCount();
  //:::::::::::::::::::::::::::::::::::::::::
   int start=0,end=0, pageNUM=0;
   int temp=0,startpage=0,endpage=0;
   int pagecount=0;
   String pnum="0";	
   
   pnum=request.getParameter("pageNum");
   if(pnum==null || pnum=="") pnum="1";
   pageNUM=Integer.parseInt(pnum); //[7]숫자화
    
   start=(pageNUM-1)*10+1;
   end=pageNUM*10;
   
   if(mytotal%10==0){pagecount=mytotal/10; }
   else{pagecount=(mytotal/10)+1;  }
   
   temp=(pageNUM-1)%10; //[21] ~[24]~ [30]
   startpage=pageNUM-temp;
   endpage=startpage+9;
   if(endpage>pagecount){endpage=pagecount;}
  //:::::::::::::::::::::::::::::::::::::::::::
  ArrayList<DBbean> AL=ds.dbSelect(start,end);
%>
 
<table width=900 border=1 cellspacing="0" >
  <tr align="right">
    <td colspan="6">레코드갯수 : <%=mytotal%> &nbsp;&nbsp;</td>
  </tr>
  
  <tr bgcolor="yellow">
    <td>행번호</td>  <td>사번</td>   <td>이름</td> 
    <td>제목</td>   <td>날짜</td> <td>급여</td>
  </tr>
   
<%
 int num=mytotal-((pageNUM-1)*10);
 for(int i=0; i<AL.size(); i++) { 
	DBbean bb=AL.get(i);
	int Gsabun=bb.getSabun();	
%>   
  <tr>
    <td> <%= num-- %>  </td>
    <td> <%= bb.getSabun() %>  </td>
    <td> <%= bb.getName() %>   </td>
    <td> <a href="guestDetail.jsp?idx=<%=Gsabun%>"> <%= bb.getTitle() %> </a> </td>
    <td> <%= bb.getNalja() %>  </td>
    <td> <%= bb.getPay() %>   </td>
  </tr>
<%   
 } //for end
%>   
 
 <!-- MVC2, SPRING 페이징계산을 자바에서처리, JSTL사용  -->
 <tr align="center">
  <td colspan="6">
    <%
     //이전 [1] [11] [21] [31]
     if(startpage>10){
    	 out.print("<a href=guestList.jsp?pageNum="+(startpage-10)+">[이전]</a>");	 
     }
    		 
     for(int i=startpage;i<=endpage;i++){
       out.print("<a href=guestList.jsp?pageNum="+i+">["+i+"]</a>"); 
     }
    
     //다음  [10] [20] [30] <32
     if(endpage<pagecount){
      out.print("<a href=guestList.jsp?pageNum="+(startpage+10)+">[다음]</a>");  
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








