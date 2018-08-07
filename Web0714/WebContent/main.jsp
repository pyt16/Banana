<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title> [main.jsp] </title>
 </head>
<body>
  <%
    String msg="";
    Cookie[] ck=request.getCookies();
    if(ck != null ){
       for(int i=0; i<ck.length; i++){
    	 String data=ck[i].getName();
      	 if(data.equals("daum")){msg=ck[i].getValue();}
      	 else{  }
       }
    }
  %>
 
  <div align="center">
  	<img src='images/a3.png'> <p>
  	<font size=6  color="blue">
  		<b> Waiting...Loading...</b> <p>
  		<b> <%= msg %> 방문을 환영합니다</b> <p>
  	</font> <p>
  
     
  </div>
</body>
</html>
