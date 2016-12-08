package jp.hannet.test.beans;

import java.io.Serializable;

public class MyMapping implements Serializable {

	private static final long serialVersionUID = -5691674981407366694L;
	private String id;
	private String name;
	private String memo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
