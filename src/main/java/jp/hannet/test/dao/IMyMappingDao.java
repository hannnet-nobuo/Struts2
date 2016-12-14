package jp.hannet.test.dao;

import java.util.List;

import jp.hannet.test.beans.MyMapping;

public interface IMyMappingDao {
	MyMapping selectById(String id);
	List<MyMapping> likeById(String id);
	boolean existById(String id);
	void save(MyMapping map);
	void delete(MyMapping map);
	void update(MyMapping map);
}
