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

@WebServlet("/insert.do")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doUser(request, response); //꼭꼭꼭기술
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response); //꼭꼭꼭기술
	}//end

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");	
	 	 
	 GuestDTO dto=new GuestDTO( );
	 GuestDAO dao=new GuestDAO( );
	 
	 //bean=dto=data Transfer object에 세터화
	 dto.setSabun(Integer.parseInt(request.getParameter("sabun")));
	 dto.setName(request.getParameter("name"));
	 dto.setTitle(request.getParameter("title"));
	 dto.setPay(Integer.parseInt(request.getParameter("pay")));
	 
	 //세터화 bean=dto를 DAO단으로 넘김
	 dao.dbInsert(dto);
	 response.sendRedirect("list.do"); //자원을 포워딩 미는 list.do
	}//end
}//InsertController class END
















