/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.hannet.sample.action;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.dao.MyMappingDao;
import jp.hannet.sample.model.MyMapping;

public class HiSearchAction extends ActionSupport {
    
	private static final long serialVersionUID = 761698363602136320L;

	private List<MyMapping> myMappings ;
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
		if(this.delid != null) {
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
