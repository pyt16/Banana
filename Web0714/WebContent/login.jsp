<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>[login.jsp]</title>
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
		var xhr;
		
		function first(){
			return new XMLHttpRequest();
		}//first end
		
		function two(){
			//var a = myform.userid.value;
			//var b = myform.pwd.value;
			var a = document.getElementById("userid").value;
			var b = document.getElementById("pwd").value;
			//alert("id=" +a+" pwd=" +b);
			var url = "login.do?uid="+a+"&upwd="+b;
			xhr = first();
			xhr.onreadystatechange = disp;
			xhr.open("post", url, true);
			xhr.send(null);
		}//two end
		
		function disp(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var str = xhr.responseText;
					document.getElementById("msg").innerHTML = str;
				}
			}
		}//disp end
	
	</script>
</head>
<body>
	<div id="msg">
	
	<table width="550" border="1" cellspacing="0">
		<form method="post">
		<tr>
			<td width=350> <b>userid: </b></td>
			<td> <input type="text" name="userid" id="userid" value="hb" ></td>
			
			<td rowspan=2 align="center">
			 <input type="button" onclick="two();" value="LOG-IN" id="LOG-IN" >
			</td>
		</tr>
		
		<tr>
			<td width=350><b>userpw: </b> </td>
			<td>
			  <input type="text"  name="pwd" id="pwd" value="1234">       
			</td>
		</tr>
		</form>
	</table>
	</div>
</body>
</html>

