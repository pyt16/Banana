package net.hb.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBSQL {
   Connection CN; //DB�������,��ɾ����
   Statement ST; //ST��ɾ����
   PreparedStatement PST; //sql�����̸����ؼ� �˸��̾��»���
   ResultSet RS; //select����� ���
   String msg;
   String data; //�����͹޴¿��� data=request.getParamater(" ")
   int Gsabun, Gpay ; //���,�޿�
   String Gname, Gtitle; //�̸�,����
   Date Gnalja, dt ; //��¥
   int total=316, Gtotal=316;
   
   Statement ST3;
   String msg3;
   ResultSet RS3;
   int tot3;	
	
   public DBSQL( ){
	 CN=DB.getConnection();
	 //DB���������� �����ڿ��� ����� ȣ��
   }//�⺻������ end
   
   public void dbInsert(DBbean bean){ //guestSave.jsp
     try{
	   msg="insert into guest values(?,?,?,sysdate,?)" ;
	   PST=CN.prepareStatement(msg);
	   	PST.setInt(1, bean.getSabun());
	   	PST.setString(2, bean.getName());
	   	PST.setString(3, bean.getTitle());
	   	PST.setInt(4, bean.getPay());
	    PST.executeUpdate(); 
	   System.out.println("DBSQL.java ���强��");
	  }catch(Exception e){System.out.println("������� "+e); }
   }//end dbinsert(DBbean)
   
 //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::     
   public ArrayList<DBbean> dbSelect( ){ //guestList.jsp���� ���ܼ����
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
    		bean.setRn(RS.getInt("rn")); //���ȣ
    		bean.setSabun(RS.getInt("sabun"));
    		bean.setName(RS.getString("name"));
    		bean.setTitle(RS.getString("title"));
    		bean.setNalja(RS.getDate("nalja"));
    		bean.setPay(RS.getInt("pay"));
    		my.add(bean); //���������� ���
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
    		bean.setRn(RS.getInt("rn")); //���ȣ4:46��
    		bean.setSabun(RS.getInt("sabun"));
    		bean.setName(RS.getString("name"));
    		bean.setTitle(RS.getString("title"));
    		bean.setNalja(RS.getDate("nalja"));
    		bean.setPay(RS.getInt("pay"));
    		my.add(bean); //���������� ���
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
     PST.executeUpdate(); //��¥����ó��
	}catch(Exception ex) { }
  }//dbEdit end
   
}//DBSQL class END













