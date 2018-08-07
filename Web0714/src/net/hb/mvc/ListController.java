package net.hb.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher; //임포트추가
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.hb.common.GuestDAO;
import net.hb.common.GuestDTO;


@WebServlet("/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException { //생성자 같은 역할
		super.init(config);                   
	}//end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   doUser(request, response); //꼭꼭꼭기술
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doUser(request, response); //꼭꼭꼭기술
	}//end

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	
		
		//7-19-목요일 검색
		String skey="", sval="", returnpage="미사용";
		String AA="", BB=""; 
		
		skey=request.getParameter("keyfield");
		sval=request.getParameter("keyword");
		if(skey=="" || skey==null || sval=="" || sval==null) {
		   skey="title";  sval="";	
		}
		
		//http://localhost:8082/Web0714/list.do?keyfield=name&keyword=b
		returnpage="&keyfield="+skey+"&keyword="+sval;
		
		if(skey.equals("name")){AA=sval;}
		else if(skey.equals("title")) {BB=sval;}
		//::::::::::::::::::::::::::::::::::::::
		int start=1,end=10 ;
		String  pnum="0";
		int startpage=1,endpage=10 ; //값을 넘겨요
		int pageNUM=0,pagecount=0, temp=0;
		//::::::::::::::::::::::::::::::::::::::
		 pnum=request.getParameter("pageNum");
		 if(pnum==null || pnum=="") pnum="1";
		 pageNUM=Integer.parseInt(pnum);
		
		 //페이지갯수 32 , 검색레코드갯수로 pagecount페이징갯수구하기  
		 GuestDAO dao=new GuestDAO();
		 int Gtotal=dao.dbCount();
		 int searchGtotal=dao.dbCountSearch(skey,sval);
		 if(searchGtotal%10==0) {pagecount=Gtotal/10; }
		 else { pagecount=(searchGtotal/10)+1;}
		 
		 //start=61, end=70  [7]클릭 
		 start=((pageNUM-1)*10)+1 ;
		 end=pageNUM*10 ;
		 System.out.println(pageNUM+ "페이지 " + start +" " + end );
		 
		 //startpage=21, endpage=30, temp임시변수 
		 //[이전] [21] ~[26클릭] ~ [30] [다음]
		 temp=(pageNUM-1)%10;
		 startpage=pageNUM-temp;
		 endpage=startpage+9; 
		 if(endpage>pagecount)endpage=pagecount;
		 
		//::::::::::::::::::::::::::::::::::::::
	    //ArrayList<GuestDTO> LG=dao.dbSelect(start,end); //페이징적용
	    ArrayList<GuestDTO> LG=dao.dbSelect(start,end,skey,sval); //검색+페이징
	    request.setAttribute("naver", LG);
	    request.setAttribute("Gtotal", Gtotal);
	    request.setAttribute("searchGtotal", searchGtotal); //추가
	    request.setAttribute("returnpage", returnpage);
	    request.setAttribute("AA", AA);
	    request.setAttribute("BB", BB);
	    request.setAttribute("sval", sval); //검색키워드
	    
	    request.setAttribute("startpage", startpage);
	    request.setAttribute("endpage", endpage);
	    request.setAttribute("pageNUM", pageNUM); 
	    request.setAttribute("pagecount", pagecount);
	    
	    RequestDispatcher dis=request.getRequestDispatcher("guestList.jsp");
		dis.forward(request,response);
  }//end
}//ListController class END











