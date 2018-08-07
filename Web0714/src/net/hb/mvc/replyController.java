package net.hb.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.GuestDAO;
import net.hb.common.GuestDTO;
import net.hb.common.ReplyDAO;
import net.hb.common.ReplyVO;

@WebServlet("/reply.do")
public class replyController extends HttpServlet {
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
		
		String insert = request.getParameter("insert");
		ReplyDAO rdao = new ReplyDAO();
		
		if(insert == null || insert == "") {
			int data = Integer.parseInt(request.getParameter("idx"));
			System.out.println("댓글출력처리 ReplyController.jsp 넘어온 idx=" + data);
			ArrayList<ReplyVO> rLG = rdao.replySelect(data);
				request.setAttribute("rnaver", data);
				RequestDispatcher dis = request.getRequestDispatcher("guestDetail.jsp");
				dis.forward(request, response);
		}else {
			System.out.println("댓글저장처리 ReplyController.jsp");
			int sabun = Integer.parseInt(request.getParameter("sabun"));
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			rdao.replyInsert(writer, content, sabun);
			response.sendRedirect("detail.do?idx=" + sabun);
		}
		
		
		
	}//end
}//class end
