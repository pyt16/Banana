package net.hb.common;

import java.util.Date;

public class DBbean { //한강다리역할,전역변수역할
  private int sabun;
  private String name;
  private String title;
  private Date nalja;
  private int pay;
    //오.버=>source => Generate Getters and Setters...
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
  
  private int rn; //rownum행번호
  private int start,end; //시작시작행, 끝행
  private int rcnt; //댓글갯수 
  
   //오.버=>source => Generate Getters and Setters...
   public int getRn() {return rn;}
   public void setRn(int rn) {this.rn = rn;	}
   public int getStart() {return start;	}
   public void setStart(int start) {this.start = start;}
   public int getEnd() {return end;	}
   public void setEnd(int end) {	this.end = end;	}
   public int getRcnt() {	return rcnt;	}
   public void setRcnt(int rcnt) {	this.rcnt = rcnt;	}
}//DBbean class END


