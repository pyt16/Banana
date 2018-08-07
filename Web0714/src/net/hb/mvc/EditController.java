package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.GuestDAO;
import net.hb.common.GuestDTO;

@WebServlet("/edit.do")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doUser(request, response); //���������
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response); //���������
	}//end

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");	
	 	 
	 GuestDTO dto=new GuestDTO( );
	 GuestDAO dao=new GuestDAO( );
	 
	 //bean=dto=data Transfer object�� ����ȭ
	 dto.setSabun(Integer.parseInt(request.getParameter("sabun")));
	 dto.setName(request.getParameter("name"));
	 dto.setTitle(request.getParameter("title"));
	 dto.setPay(Integer.parseInt(request.getParameter("pay")));
	 
	 //����ȭ bean=dto�� DAO������ �ѱ�
	 dao.dbEdit(dto);  //dbInsert�޼ҵ� �ƴմϴ�
	 response.sendRedirect("list.do"); //�ڿ��� ������ �̴� list.do
	}//end
	
}//EditController class END
















