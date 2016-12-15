package jp.hannet.sample.dao;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import static org.junit.Assert.*;
import org.junit.Test;

import jp.hannet.sample.dao.MyMappingDao;
import jp.hannet.sample.model.MyMapping;

public class MyMappingDaoTest {

	/** テストするオブジェクト **/
	final private static MyMappingDao dao = new MyMappingDao();
	
	/** テスト用のID **/
	final private static String TEST_ID = "test2";
	
	@Test
	public void testExistById() {
		assertEquals(true, dao.existById(TEST_ID));
	}

	@Test
	public void selectById() {
		assertNotNull(dao.selectById(TEST_ID));
	}
	
	@Test
	public void save() {
		// ランダムな10個の文字列生成
		String id = RandomStringUtils.randomAscii(10);
		String name = RandomStringUtils.randomAscii(10);
		String memo = RandomStringUtils.randomAscii(10);
		MyMapping map = new MyMapping();
		map.setId(id);
		map.setName(name);
		map.setMemo(memo);
		// DBに書き込む
		dao.save(map);
		
		// DBからIDで取得
		List<MyMapping> maps = dao.likeById(id);
		MyMapping mapre = maps.get(0);

		// 書き込んだデータが取得できているか検証
		assertEquals(id, mapre.getId());
		assertEquals(name, mapre.getName());
		assertEquals(memo, mapre.getMemo());
		
		// テストが終わったらゴミデータ削除
		dao.delete(map);
	}

	@Test
	public void delete() {
		
		String id = RandomStringUtils.randomAscii(10);
		String name = RandomStringUtils.randomAscii(10);
		String memo = RandomStringUtils.randomAscii(10);
		MyMapping map = new MyMapping();
		map.setId(id);
		map.setName(name);
		map.setMemo(memo);
		dao.save(map);
		dao.delete(map);
		assertEquals(false, dao.existById(map.getId()));
	}

	@Test
	public void update() {
		String name = RandomStringUtils.randomAscii(10);
		String memo = RandomStringUtils.randomAscii(10);
		MyMapping map = new MyMapping();
		map.setId(TEST_ID);
		map.setName(name);
		map.setMemo(memo);
		
		dao.update(map);
		
		MyMapping mapre = dao.likeById(TEST_ID).get(0);
		assertEquals(name, mapre.getName());
		assertEquals(memo, map.getMemo());
	}

}
