package net.hb.common;

public class ReplyVO { //guestreply���̺��� �ʵ� 
   int num;  //������ guestreply_seq 
   String writer; //�Է�
   String content; //�Է�
   int sabun; //guest���̺�PK���� 
   
	public int getNum() {	return num;	}
	public void setNum(int num) {	this.num = num;	}
	public String getWriter() {	return writer;	}
	public void setWriter(String writer) {	this.writer = writer;	}
	public String getContent() {return content;	}
	public void setContent(String content) {this.content = content;	}
	public int getSabun() {return sabun;	}
	public void setSabun(int sabun){this.sabun = sabun;	}
} //ReplyVO class END
