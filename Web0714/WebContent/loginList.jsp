<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ include file="ssi2.jsp" %>

<html>
<head>
<title> [loginList.jsp] </title>
	<style type="text/css">
	  b,a{text-decoration:none; font-size:20pt; font-weight:bold; }
	  a:hover{color:red; font-size:34pt; font-weight:bold;  }
	</style>
</head>
<body>
	<font size=7> <b> [loginList.jsp] </b></font> <p>		
<%
try{
  String usera=request.getParameter("userid");
  String userb=request.getParameter("pwd");
  
  msg="select count(*) as Lcnt from login where userid=? and pwd=?";
  PST=CN.prepareStatement(msg);
  	PST.setString(1, usera);
  	PST.setString(2, userb);
  RS=PST.executeQuery(); //executeUpdate( )=>insert,delete,update
  RS.next(); total=RS.getInt("Lcnt");

  //msg="select count(*) as Lcnt from login where userid='"+ usera +"' and pwd='" + userb +"'";
  //ST=CN.createStatement();
  //RS=ST.executeQuery(msg);
  //if(RS.next()==true){ total=RS.getInt("Lcnt"); }
  
  if(total>0){
	Cookie ck=new Cookie("daum", usera);
	ck.setMaxAge(60); //1분 60초 
	response.addCookie(ck);
	//response.sendRedirect("main.jsp");
	response.sendRedirect("cookieindex.jsp");
	//자바스크립트로 쿠키응용 main.jsp대신 cookindex.jsp변경
	//자바스크립트 팝업창 이벤트창=공지창 cookiepopup.jsp미리서작성
   }else{ response.sendRedirect("login.jsp");  }
 }catch(Exception ex){ response.sendRedirect("guestList.jsp"); }
%>
	

</body>
</html>









