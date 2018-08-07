package net.hb.common;

import java.util.ArrayList;

public class ReplyDAO extends Variable  implements ReplyDAOInterface { 
	
  public ReplyDAO( ){
	CN=DB.getConnection(); 
  }//class END

  @Override
  public void replyInsert(String writer, String content, int sabun) {
      try {
	  msg="insert into guestreply values(guestreply_seq.nextval, ?, ?, ?) ";
	  PST=CN.prepareStatement(msg);
	  	PST.setString(1, writer);
	  	PST.setString(2, content);
	  	PST.setInt(3, sabun);
	  PST.executeUpdate();
	  System.out.println("ReplyDAO.java 댓글저장성공");
      }catch(Exception ex){System.out.println("댓글저장실패"+ex);}
  }//end

  @Override
  public ArrayList<ReplyVO> replySelect(int sabun) {
	  ArrayList<ReplyVO> rlist=new ArrayList<ReplyVO>();
	  try{
		msg="select * from guestreply where sabun="+sabun;
		ST=CN.createStatement();
		RS=ST.executeQuery(msg);
		while(RS.next()==true) {
		  ReplyVO vo=new ReplyVO();
		  vo.setNum(RS.getInt("num"));
		  vo.setWriter(RS.getString("writer"));
		  vo.setContent(RS.getString("content"));
		  vo.setSabun(RS.getInt("sabun"));
		  rlist.add(vo); //꼭꼭꼭반드시 기술 
		}
	  }catch(Exception ex){System.out.print("댓글전체조회실패");}
	  return rlist;
  }//end

  @Override
  public void replyDelete(String num) {	
	 try {
	 msg="delete guestreply where num = " + num;
	 ST=CN.createStatement();
	 ST.executeUpdate(msg);
	 System.out.println("num필드 "+ num + " 댓글 데이터 삭제 성공");
	 }catch(Exception ex){System.out.print("댓글삭제실패");}
  }//end
  
}//ReplyDAO  class END 







