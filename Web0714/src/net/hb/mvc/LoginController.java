package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;//�߰�

import net.hb.common.DB;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response); 
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response); 
	}//end
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out=response.getWriter(); // out��ü
	  
	  String uid=request.getParameter("uid");
	  String upwd=request.getParameter("upwd");
	  
	  HttpSession session=request.getSession();//session ��ü
	  
	  try{
		int total=0;
		Connection CN=DB.getConnection();
		String msg="select count(*) as cnt from login where userid=? and pwd=? " ;   
		PreparedStatement PST=CN.prepareStatement(msg);
			PST.setString(1, uid);
			PST.setString(2, upwd);
		ResultSet RS=PST.executeQuery( );
		if(RS.next()==true){total=RS.getInt("cnt"); }
		if(total>0){
		  session.setAttribute("temp", uid);  //���Ǽ��� String bit = (String)session.getAttribute("");
		  out.println("<font size=7 color='#FF00FF'><b>OK�α��μ���OK</b></font><p>");
		  out.println("<img src=images/bt_login.gif width=450 height=70><p>");
		  out.println("<img src=images/bar.gif width=450 height=70>");
		}else{
		  out.println("<font size=7 color=red><b>�α��ν���</b></font> <p> ");
		  out.println("<img src=images/bar.gif width=450 height=70><br>");
		  out.println("<font size=7><a href='login.jsp'>[�α���]</a></font>");
		  out.println("<font size=7><a href='index.jsp'>[index]</a></font>");	
		  out.println("<font size=7><a href='list.do'>[list.do]</a></font>");	
		}
	  }catch(Exception ex){ }
	}//doUser end
	
}//LoginController class END






