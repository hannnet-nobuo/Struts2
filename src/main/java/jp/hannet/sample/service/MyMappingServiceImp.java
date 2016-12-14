package jp.hannet.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.hannet.sample.dao.IMyMappingDao;
import jp.hannet.sample.model.MyMapping;

@Service
public class MyMappingServiceImp implements IMyMappingService {
	
	private IMyMappingDao dao;

	public void setDao(IMyMappingDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public MyMapping selectById(String id) {
		return dao.selectById(id);
	}

	@Transactional(readOnly = true)
	public List<MyMapping> likeById(String id) {
		return dao.likeById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String save(MyMapping map) {
		String msg;	
		if (!dao.existById(map.getId())) {
			dao.save(map);
			msg = "書き込みました";
		} else {
			msg = "すでに存在するIDです";
		}

		return msg;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(MyMapping map) {
		dao.delete(map);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(MyMapping map) {
		dao.update(map);
	}

}
