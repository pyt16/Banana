package net.hb.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Variable {
	 Connection CN; //DB�������,��ɾ����
	 Statement ST; //ST��ɾ����
	 PreparedStatement PST; //sql�����̸����ؼ� �˸��̾��»���
	 ResultSet RS; //select����� ���
	 String msg;   //insert,delete,update, select
	 String sqry; //sqry=" where title like 
	 String data; //�����͹޴¿��� data=request.getParamater(" ")
	 int Gsabun, Gpay ; //���,�޿�
	 String Gname, Gtitle; //�̸�,����
	 Date Gnalja, dt ; //��¥
	 int total=316, Gtotal=316;
	   
	 Statement ST3;
	 String msg3;
	 ResultSet RS3;
	 int tot3;
} // Variable class END
