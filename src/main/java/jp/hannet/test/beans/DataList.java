package jp.hannet.test.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class DataList implements Serializable{

	private static final long serialVersionUID = -50218871003540814L;

	private ArrayList<DataStructure> data;
	
	public DataList() {
		data = new ArrayList<DataStructure>();
	}
	
	public ArrayList<DataStructure> getData() {
		return data;
	}
	
	public void setData(ArrayList<DataStructure> data) {
		this.data = data;
	}
	
	public void add(String s1, String s2) {
		data.add(new DataStructure(s1,s2));
	}
}
