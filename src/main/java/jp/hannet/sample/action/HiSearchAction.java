package jp.hannet.sample.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.dao.MyMappingDao;
import jp.hannet.sample.model.MyMapping;

public class HiSearchAction extends ActionSupport {

	private static final long serialVersionUID = 761698363602136320L;

	private List<MyMapping> myMappings;
	private String delid;
	private String s_id;

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getDelid() {
		return delid;
	}

	public void setDelid(String delid) {
		this.delid = delid;
	}

	public List<MyMapping> getMyMappings() {
		return myMappings;
	}

	public String execute() throws Exception {

		MyMappingDao dao = new MyMappingDao();
		if (this.delid != null) {
			MyMapping delMap = new MyMapping();
			delMap.setId(delid);
			// 削除
			dao.delete(delMap);
		}
		// 結果取得
		myMappings = dao.likeById(s_id);
		return SUCCESS;
	}

}
