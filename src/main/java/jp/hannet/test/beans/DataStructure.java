package jp.hannet.test.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DataStructure implements Serializable{

	private static final long serialVersionUID = -9212056371749027038L;

	private String title;
	private String msg;
	private Date date;
	private SimpleDateFormat format;
	
	public DataStructure() {
		format = new SimpleDateFormat("yyyy/M/d");
	}
	
	public DataStructure(String s1, String s2) {
		this();
		this.title = s1;
		this.msg = s2;
		this.date = new GregorianCalendar().getTime();
	}
	
	public String getDate() {
		return format.format(date);
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
