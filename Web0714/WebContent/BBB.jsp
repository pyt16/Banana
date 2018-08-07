<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> [BBB.jsp]</title>
	<style type="text/css">
	  *{font-size:20pt; font-weight:bold; }
	</style>
</head>
<body>
	[BBB.jsp 데이터를 받는문서]<p>
	<%
		request.setCharacterEncoding("UTF-8");
	
		if(FileUpload.isMultipartContent(request)){
			String upDir = application.getRealPath("./storage");
			DiskFileUpload dfu = new DiskFileUpload();
			
			//처음업로드한 파일이 아니면 메모리에저장
			dfu.setRepositoryPath(upDir);
			dfu.setSizeMax(1024*1024*100); //1메가까지 업로드가능
			dfu.setSizeThreshold(1024*1024); //한번에 100k까지만 메모리저장
			
			if(request.getContentLength() < dfu.getSizeMax()){
				List fList = dfu.parseRequest(request);
				int size = fList.size();
				String [] tit = new String[2];
				tit[0] = "이름";
				tit[1] = "제목";
				
				for(int i=0; i<fList.size(); i++){
					FileItem fileitem = (FileItem)fList.get(i);
					if(fileitem.isFormField() == true){
						out.println(tit[i] + fileitem.getFieldName()+"=" + fileitem.getString("UTF-8")+"<br>");
					}else{
						out.println(tit[i] + fileitem.getFieldName()+"=" + fileitem.getName());
						out.println("("+fileitem.getSize()+"Byte)<br>");
						
						if(fileitem.isInMemory() == true){
							System.out.println(upDir);
						}else{out.println("디스크에 저장 <br>");}
						
						if(fileitem.getSize() > 0){
							System.out.println("getName()="+fileitem.getName());
							int idx = fileitem.getName().lastIndexOf("\\");
							if(idx == -1){idx = fileitem.getName().lastIndexOf("/");}
							String fileName = fileitem.getName().substring(idx+1);
							System.out.println("idx="+idx+" fileName="+fileName+"\n");
							
							try{
								File file = new File(upDir, fileName);
								fileitem.write(file);
							}catch(Exception ex){out.println("error:"+ex);}
						}
					}//else
				}//for end
			}else{
				int overSize=(request.getContentLength()/1000000);
				System.out.println("파일의크기는 "+overSize+" MB");
			}//size비교 else end
		}else{
			out.println("인코딩타입이 multipart/form-data가 아닙니다");
		}
	%>
	<p>
	<a href="AAA.jsp">[AAA.jsp]</a>
	<a href="index.jsp">[index]</a>
	<a href="guestList.jsp">[전체출력]</a>
</body>
</html>