package net.hb.common;

import java.util.Date;

public class GuestDTO { //Data Trnafer Object
  private int sabun;
  private String name;
  private String title;
  private Date nalja;
  private int pay;
    //��.��=>source => Generate Getters and Setters...
	public int getSabun() {	return sabun;}
	public void setSabun(int sabun) {this.sabun = sabun;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public Date getNalja() {return nalja;}
	public void setNalja(Date nalja) {this.nalja = nalja;}
	public int getPay() {return pay;}
	public void setPay(int pay) {this.pay = pay;}
  
  private int rn; //rownum���ȣ
  private int start,end; //���۽�����, ����
  private int rcnt; //��۰��� 
  
   private String skey, sval; //07-19-�����
   public String getSkey() {return skey;}
   public void setSkey(String skey) {this.skey = skey;}
   public String getSval() {return sval;}
   public void setSval(String sval) {this.sval = sval;}
   //��.��=>source => Generate Getters and Setters...
   
   public int getRn() {return rn;}
   public void setRn(int rn) {this.rn = rn;	}
   public int getStart() {return start;	}
   public void setStart(int start) {this.start = start;}
   public int getEnd() {return end;	}
   public void setEnd(int end) {	this.end = end;	}
   public int getRcnt() {	return rcnt;	}
   public void setRcnt(int rcnt) {	this.rcnt = rcnt;	}
}//GuestDTO class END


