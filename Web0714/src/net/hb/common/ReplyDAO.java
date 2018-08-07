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
	  System.out.println("ReplyDAO.java ������强��");
      }catch(Exception ex){System.out.println("����������"+ex);}
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
		  rlist.add(vo); //�������ݵ�� ��� 
		}
	  }catch(Exception ex){System.out.print("�����ü��ȸ����");}
	  return rlist;
  }//end

  @Override
  public void replyDelete(String num) {	
	 try {
	 msg="delete guestreply where num = " + num;
	 ST=CN.createStatement();
	 ST.executeUpdate(msg);
	 System.out.println("num�ʵ� "+ num + " ��� ������ ���� ����");
	 }catch(Exception ex){System.out.print("��ۻ�������");}
  }//end
  
}//ReplyDAO  class END 







