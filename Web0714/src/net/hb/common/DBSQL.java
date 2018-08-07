package net.hb.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBSQL {
   Connection CN; //DB정보기억,명령어생성
   Statement ST; //ST명령어생성
   PreparedStatement PST; //sql쿼리미리서해석 알맹이없는상태
   ResultSet RS; //select결과값 기억
   String msg;
   String data; //데이터받는역할 data=request.getParamater(" ")
   int Gsabun, Gpay ; //사번,급여
   String Gname, Gtitle; //이름,제목
   Date Gnalja, dt ; //날짜
   int total=316, Gtotal=316;
   
   Statement ST3;
   String msg3;
   ResultSet RS3;
   int tot3;	
	
   public DBSQL( ){
	 CN=DB.getConnection();
	 //DB연결정보를 생성자에서 연결및 호출
   }//기본생성자 end
   
   public void dbInsert(DBbean bean){ //guestSave.jsp
     try{
	   msg="insert into guest values(?,?,?,sysdate,?)" ;
	   PST=CN.prepareStatement(msg);
	   	PST.setInt(1, bean.getSabun());
	   	PST.setString(2, bean.getName());
	   	PST.setString(3, bean.getTitle());
	   	PST.setInt(4, bean.getPay());
	    PST.executeUpdate(); 
	   System.out.println("DBSQL.java 저장성공");
	  }catch(Exception e){System.out.println("저장실패 "+e); }
   }//end dbinsert(DBbean)
   
 //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::     
   public ArrayList<DBbean> dbSelect( ){ //guestList.jsp문서 땡겨서사용
     ArrayList<DBbean> my=new ArrayList<DBbean>();
      try{
    	String x="select * from ( ";
    	String y="select rownum rn,sabun,name,title,nalja,pay from guest";
    	String z=" ) where rn between 1 and 10 ";
    	msg=x+y+z; 
    	
    	ST=CN.createStatement();
    	RS=ST.executeQuery(msg);
    	while(RS.next()==true) {
    		DBbean bean=new DBbean( );
    		bean.setRn(RS.getInt("rn")); //행번호
    		bean.setSabun(RS.getInt("sabun"));
    		bean.setName(RS.getString("name"));
    		bean.setTitle(RS.getString("title"));
    		bean.setNalja(RS.getDate("nalja"));
    		bean.setPay(RS.getInt("pay"));
    		my.add(bean); //꼭꼭꼭꼭꼭 기술
    	}//while end
      }catch(Exception e){System.out.println(e);}	
     return my;
   }//dbSelect end
   
   public ArrayList<DBbean> dbSelect(int start,int end){ 
     ArrayList<DBbean> my=new ArrayList<DBbean>();
      try{
   String x="select * from  ( ";
   String y=" select rownum rn,sabun,name,title,nalja,pay from guest";
   String z=") where rn between " +start+ " and "+end;
   msg=x+y+z ;
    	
    	ST=CN.createStatement();
    	RS=ST.executeQuery(msg);
    	while(RS.next()==true) {
    		DBbean bean=new DBbean( );
    		bean.setRn(RS.getInt("rn")); //행번호4:46분
    		bean.setSabun(RS.getInt("sabun"));
    		bean.setName(RS.getString("name"));
    		bean.setTitle(RS.getString("title"));
    		bean.setNalja(RS.getDate("nalja"));
    		bean.setPay(RS.getInt("pay"));
    		my.add(bean); //꼭꼭꼭꼭꼭 기술
    	}//while end
      }catch(Exception e){System.out.println(e);}	
     return my;
   }//dbSelect end
 //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::  
   
   public int dbCount( ) {
	 try{
	   ST=CN.createStatement();
	   msg="select count(*) as cnt from guest";
	   RS=ST.executeQuery(msg);
	   if(RS.next()==true){ Gtotal=RS.getInt("cnt"); }
	 }catch(Exception e){System.out.println(e);}    
	 return Gtotal;
   }//dbCount end
   
   public DBbean dbDetail(String data ) { 
	DBbean  bean = new DBbean( );
	try{
	  msg="select * from guest where sabun="+data;
	  ST=CN.createStatement();
	  RS=ST.executeQuery(msg);
	  if(RS.next()==true) {
		 bean.setSabun(RS.getInt("sabun"));
   	     bean.setName(RS.getString("name"));
   	     bean.setTitle(RS.getString("title"));
   	     bean.setNalja(RS.getDate("nalja"));
   	     bean.setPay(RS.getInt("pay"));  
	  }
	}catch(Exception ex) { }
	return bean;
   }//dbDetail end
   
  public void dbDelete(String data) {
	 try {
	  msg="delete from guest where sabun = " + data ; 
	  ST=CN.createStatement();
	  ST.executeUpdate(msg);
	 }catch(Exception ex) { }
  }//dbDelete end
   
  public void dbEdit(DBbean bean) {
	try {
     //msg="update~~,pay=? where sabun=?";
     msg="update guest set name=?,title=?,nalja=sysdate,pay=? where sabun=?";
     PST=CN.prepareStatement(msg);
     	PST.setString(1, bean.getName());
     	PST.setString(2, bean.getTitle());
     	PST.setInt(3, bean.getPay());
     	PST.setInt(4, bean.getSabun());
     PST.executeUpdate(); //진짜수정처리
	}catch(Exception ex) { }
  }//dbEdit end
   
}//DBSQL class END













