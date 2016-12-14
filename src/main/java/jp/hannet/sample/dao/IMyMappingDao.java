package jp.hannet.sample.dao;

import java.util.List;

import jp.hannet.sample.model.MyMapping;

public interface IMyMappingDao {
	MyMapping selectById(String id);
	List<MyMapping> likeById(String id);
	boolean existById(String id);
	void save(MyMapping map);
	void delete(MyMapping map);
	void update(MyMapping map);
}
