<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>[loginCopy.jsp]</title>
	<style type="text/css">
		input, b{font-size: 20pt; font-weight: bold;}
		a{text-decoration: none;font-size: 20pt; font-weight: bold;}
		a:hover {color: red; font-size: 20pt; font-weight: bold;}
		#LOG-IN{
		 font-size:26pt; font-weight: bold; 
		 background:"#00FF00"; height:120; 
		}
	</style>
	
	<script type="text/javascript">
	
	
	</script>
</head>
<body>
	<font size=7 color=blue>  [loginCopy.jsp] </font><p>
	
	<table width="550" border="1" cellspacing="0">
		<form action="login.do" method="post" >
		<tr>
			<td width=350> <b>userid: </b></td>
			<td> <input type="text" name="userid" value="hb" ></td>
			
			<td rowspan=2 align="center">
			 <input type="submit" value="LOG-IN" id="LOG-IN" >
			</td>
		</tr>
		
		<tr>
			<td width=350><b>userpw: </b> </td>
			<td>
			  <input type="text"  name="pwd" value="1234">       
			</td>
		</tr>
		</form>
	</table>
	
	<P>
		<a href="index.jsp">[시작화면]</a>
		<a href="guest.jsp">[등록화면]</a>
		<a href="list.do">[list.do]</a>
</body>
</html>

