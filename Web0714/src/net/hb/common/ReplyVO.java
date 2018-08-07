package net.hb.common;

public class ReplyVO { //guestreply테이블의 필드 
   int num;  //시퀀스 guestreply_seq 
   String writer; //입력
   String content; //입력
   int sabun; //guest테이블PK연결 
   
	public int getNum() {	return num;	}
	public void setNum(int num) {	this.num = num;	}
	public String getWriter() {	return writer;	}
	public void setWriter(String writer) {	this.writer = writer;	}
	public String getContent() {return content;	}
	public void setContent(String content) {this.content = content;	}
	public int getSabun() {return sabun;	}
	public void setSabun(int sabun){this.sabun = sabun;	}
} //ReplyVO class END
