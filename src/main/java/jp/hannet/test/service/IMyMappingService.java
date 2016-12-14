package jp.hannet.test.service;

import java.util.List;

import jp.hannet.test.beans.MyMapping;

public interface IMyMappingService {
	List<MyMapping> likeById(String id);
	MyMapping selectById(String id);
	String save(MyMapping map);
	void delete(MyMapping map);
	void update(MyMapping map);
}
