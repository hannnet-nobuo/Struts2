package jp.hannet.sample.service;

import java.util.List;

import jp.hannet.sample.model.MyMapping;

public interface IMyMappingService {
	List<MyMapping> likeById(String id);
	MyMapping selectById(String id);
	String save(MyMapping map);
	void delete(MyMapping map);
	void update(MyMapping map);
}
