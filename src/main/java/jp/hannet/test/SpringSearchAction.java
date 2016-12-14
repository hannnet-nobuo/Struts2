package jp.hannet.test;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import jp.hannet.test.beans.MyMapping;
import jp.hannet.test.service.IMyMappingService;

public class SpringSearchAction extends ActionSupport {
    
	private static final long serialVersionUID = 8227800417545931037L;
	private List<MyMapping> myMappings ;
	private String delid;
	private String s_id;
	
	private IMyMappingService myMappingService; 
	
	public void setMyMappingService(IMyMappingService myMappingService) {
		this.myMappingService = myMappingService;
	}
	
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
			
		if(this.delid != null) {
			MyMapping delMap = new MyMapping();
			delMap.setId(delid);
			// 削除
			myMappingService.delete(delMap);
		}
		// 結果取得
		myMappings = myMappingService.likeById(s_id);
		
        return SUCCESS;
    }

}
