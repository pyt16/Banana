package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher; //7-17-ȭ���� �߰�
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.GuestDAO;
import net.hb.common.GuestDTO;

@WebServlet("/preEdit.do")
public class PreEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doUser(request, response); //���������
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response); //���������
	}//end

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");	
	 	 
	 GuestDAO dao=new GuestDAO( );
	 
	 String data=request.getParameter("idx");
	 System.out.println("PreEdit��Ʈ�� �Ѿ�� idx=" + data);
	 
	 GuestDTO dto=dao.dbDetail(data);
	 request.setAttribute("dto", dto);
	 RequestDispatcher dis=null; 
	 dis=request.getRequestDispatcher("guestEdit.jsp");
	 dis.forward(request,response);
	}//end
}//PreEditController class END
















