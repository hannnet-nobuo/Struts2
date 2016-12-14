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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.MyMapping;

public class HiEditAction extends ActionSupport implements HttpParametersAware {
    
	private static final long serialVersionUID = -3521141713234828082L;
	private String editid;
	private String id;
	private String name;
	private String memo;
	private String update;
	private HttpParameters param;
	
	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getEditid() {
		return editid;
	}

	public void setEditid(String editid) {
		this.editid = editid;
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

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String execute() throws Exception {
		
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

		if (param.contains("editid")) {
			editid = param.get("editid").getValue();
		}
		
		Session session = null;
		Transaction txn = null;
		try {
			session = new MetadataSources( registry )
					.buildMetadata()
					.buildSessionFactory()
					.openSession();
			
			if (editid != null) {
				// セッション取得
				
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaQuery<MyMapping> cr = builder.createQuery(MyMapping.class);
				
				Root<MyMapping> root = cr.from( MyMapping.class );
				cr.select(root)
					.where(
							builder.equal(root.get("id"), editid)
						);
				
				// 結果取得
				MyMapping map = (MyMapping) session.createQuery(cr)
													.getSingleResult();
				id = map.getId();
				name = map.getName();
				memo = map.getMemo();
			} else if (update != null && id != null) {
				MyMapping map = new MyMapping();
				map.setId(id);
				map.setName(name);
				map.setMemo(memo);
				
				txn = session.getTransaction();
				txn.begin();
				session.update(map);
				txn.commit();
			}
			
		} catch (RuntimeException ex) {
			StandardServiceRegistryBuilder.destroy( registry );
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}
        return SUCCESS;
    }

	public void setParameters(HttpParameters arg0) {
		param = arg0;
		
	}

}
