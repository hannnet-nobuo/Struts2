package jp.hannet.sample.action;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.MyMapping;
import jp.hannet.sample.service.IMyMappingService;

public class SpringNewAction extends ActionSupport {

	private static final long serialVersionUID = -3895394479687020879L;
	private String id;
	private String name;
	private String memo;
	private String insert;
	private String msg;

	private IMyMappingService myMappingService;

	public void setMyMappingService(IMyMappingService myMappingService) {
		this.myMappingService = myMappingService;
	}

	public String getMsg() {
		return msg;
	}

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

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String execute() throws Exception {
		msg = "";
		if (id != null) {
			MyMapping map = new MyMapping();
			map.setId(id);
			map.setName(name);
			map.setMemo(memo);
			msg = myMappingService.save(map);
		}
		return SUCCESS;
	}
}
