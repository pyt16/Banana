package net.hb.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class GuestDAO  extends Variable{ //Data Access Ojbect	

  public GuestDAO( ){
	CN=DB.getConnection();
	//DB���������� �����ڿ��� ����� ȣ��
  }//�⺻������ end
   
   public void dbInsert(GuestDTO dto ){ //InsertController.java
     try{
	   msg="insert into guest values(?,?,?,sysdate,?)" ;
	   PST=CN.prepareStatement(msg);
	   	PST.setInt(1, dto.getSabun());
	   	PST.setString(2, dto.getName());
	   	PST.setString(3, dto.getTitle());
	   	PST.setInt(4, dto.getPay());
	    PST.executeUpdate(); 
	   System.out.println("GuestDAO.java dbInsert ���强��");
	  }catch(Exception e){System.out.println("������� "+e); }
   }//end dbinsert(GuestDTO dto)
   
   
 //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::     
   public ArrayList<GuestDTO> dbSelect( ){ //ListController.java
     ArrayList<GuestDTO> my=new ArrayList<GuestDTO>();
      try{
    	String x="select  * from (" ;  
    	String y="select rownum rn,sabun,name,title,nalja,pay from guest";   
    	String z=" ) where rn between 1 and 10 ";
    	msg=x+y+z; 
    	
    	ST=CN.createStatement();
    	RS=ST.executeQuery(msg +"\n");
    	while(RS.next()==true) {
    		GuestDTO dto=new GuestDTO( );
    		dto.setRn(RS.getInt("rn")); //���ȣ
    		dto.setSabun(RS.getInt("sabun"));
    		dto.setName(RS.getString("name"));
    		dto.setTitle(RS.getString("title"));
    		dto.setNalja(RS.getDate("nalja"));
    		dto.setPay(RS.getInt("pay"));
    		my.add(dto); //���������� ���
    	}//while end
      }catch(Exception e){System.out.println(e);}	
     return my;
   }//dbSelect end
   
   
   public ArrayList<GuestDTO> dbSelect(int start,int end){ 
	 return null ;  //���ÿ�=��������������   ����¡+�˻��۾� �Ʒ����� �ǽ�
   }//end
   
   //07-19-����� ����¡+�˻� 
   public ArrayList<GuestDTO> dbSelect(int start,int end, String skey, String sval){   
     ArrayList<GuestDTO> my=new ArrayList<GuestDTO>();
     //sqry=" where " + skey + " like ��%" +sval +"%��";
     sqry=" where " + skey + " like '%" +sval +"%'";
     
      try{
   String x="select * from  ( ";
   String y=" select rownum rn,sabun,name,title,nalja,pay from guest " + sqry;
   System.out.println("y="+y); //������õ 
   String z=") where rn between " +start+ " and "+end;
   msg=x+y+z ;
    	
    	ST=CN.createStatement();
    	RS=ST.executeQuery(msg);
    	while(RS.next()==true) {
    		GuestDTO dto=new GuestDTO( );
    		dto.setRn(RS.getInt("rn")); //���ȣ4:46��
    		dto.setSabun(RS.getInt("sabun"));
    		dto.setName(RS.getString("name"));
    		dto.setTitle(RS.getString("title"));
    		dto.setNalja(RS.getDate("nalja"));
    		dto.setPay(RS.getInt("pay"));
    		my.add(dto); //���������� ���
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
   
   public int dbCountSearch(String skey, String sval) {
	int sGtotal=0;
	String sqry=" where " + skey + " like '%" + sval +"%'";
	  try{
	   ST=CN.createStatement();
	   msg="select count(*) as cnt from guest " + sqry;  
	   RS=ST.executeQuery(msg);
	   if(RS.next()==true){ sGtotal=RS.getInt("cnt"); }
	  }catch(Exception e){System.out.println(e);} 
	  System.out.println("�˻����ڵ尹��=" + sGtotal);
	return sGtotal;
   }//dbCountSearch end 
   
   
  public GuestDTO dbDetail(String data){//DetailController.java
	GuestDTO  dto = new GuestDTO( );
	try{
	  msg="select * from guest where sabun = "+data;
	  ST=CN.createStatement();
	  RS=ST.executeQuery(msg);
	  if(RS.next()==true) {
		  dto.setSabun(RS.getInt("sabun"));
		  dto.setName(RS.getString("name"));
		  dto.setTitle(RS.getString("title"));
		  dto.setNalja(RS.getDate("nalja"));
		  dto.setPay(RS.getInt("pay"));  
	  }
	}catch(Exception ex) { }
	return dto;
  }//dbDetail end
   
   
  public void dbDelete(String data) {
	 try {
	  msg="delete from guest where sabun = " + data ; 
	  ST=CN.createStatement();
	  ST.executeUpdate(msg);
	 }catch(Exception ex) { }
  }//dbDelete end
   
  public void dbEdit(GuestDTO dto){//EditController.java
	try {
     //msg="update~~,pay=? where sabun=?";
     msg="update guest set name=?,title=?,nalja=sysdate,pay=? where sabun=?";       
     PST=CN.prepareStatement(msg);
     	PST.setString(1, dto.getName());
     	PST.setString(2, dto.getTitle());
     	PST.setInt(3, dto.getPay());
     	PST.setInt(4, dto.getSabun());
     PST.executeUpdate(); //��¥����ó��
	}catch(Exception ex) { }
  }//dbEdit end
   
}//GuestDAO class END













