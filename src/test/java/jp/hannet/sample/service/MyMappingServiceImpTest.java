package jp.hannet.sample.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jp.hannet.sample.model.MyMapping;
import jp.hannet.sample.service.IMyMappingService;

public class MyMappingServiceImpTest {

	private IMyMappingService service;

	private final static String TEST_ID = "test2";

	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		service = (IMyMappingService) ctx.getBean("myMappingService");
	}

	@Test
	public void testSelectById() {
		MyMapping map = service.selectById(TEST_ID);
		assertNotNull(map);
	}

	@Test
	public void testLikeById() {
		List<MyMapping> maps = service.likeById(TEST_ID);
		assertEquals(1, maps.size());

	}

	@Test
	public void testSaveAndDelete() {
		// ランダムな10個の文字列生成
		String id = RandomStringUtils.randomAscii(10);
		String name = RandomStringUtils.randomAscii(10);
		String memo = RandomStringUtils.randomAscii(10);
		MyMapping map = new MyMapping();
		map.setId(id);
		map.setName(name);
		map.setMemo(memo);
		// DBに書き込む
		service.save(map);

		// DBからIDで取得
		MyMapping mapre = service.selectById(id);

		// 書き込んだデータが取得できているか検証
		assertEquals(id, mapre.getId());
		assertEquals(name, mapre.getName());
		assertEquals(memo, mapre.getMemo());

		// テストが終わったらゴミデータ削除
		service.delete(map);

		// DBからIDで取得
		List<MyMapping> deleteMaps = service.likeById(id);
		assertEquals(0, deleteMaps.size());
	}

	@Test
	public void testUpdate() {
		List<MyMapping> maps = service.likeById(TEST_ID);
		MyMapping map = maps.get(0);
		String name = RandomStringUtils.randomAscii(10);
		String memo = RandomStringUtils.randomAscii(10);
		map.setName(name);
		map.setMemo(memo);
		service.update(map);

		List<MyMapping> updatemaps = service.likeById(TEST_ID);
		MyMapping updatemap = updatemaps.get(0);

		assertEquals(name, updatemap.getName());
		assertEquals(memo, updatemap.getMemo());
	}
}
