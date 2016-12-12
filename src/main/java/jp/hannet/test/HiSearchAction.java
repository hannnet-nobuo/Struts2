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
package jp.hannet.test;

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
import jp.hannet.test.beans.MyMapping;

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
		// 詳細は以下のURL
		// http://docs.jboss.org/hibernate/orm/5.2/quickstart/html_single/#hibernate-gsg-tutorial-basic-config
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		Session session = null;
		Transaction txn = null;
		try {
			// セッション取得
			session = new MetadataSources( registry )
						.buildMetadata()
						.buildSessionFactory()
						.openSession();
			
			if(this.delid != null) {
				// トランザクション取得
				txn = session.getTransaction();
				// トランザクション開始
				txn.begin();
				MyMapping delMap = new MyMapping();
				delMap.setId(delid);
				// 削除
				session.delete(delMap);
				// トランザクションコミット
				txn.commit();
			}
			// creiteria詳細は以下のURL
			// http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<MyMapping> cr = builder.createQuery(MyMapping.class);
			Root<MyMapping> root = cr.from( MyMapping.class );
			cr.select(root);
			
			if (s_id != null && !"".equals(s_id.trim())) {
				cr.where(
						builder.like(root.<String>get("id"), "%" + s_id + "%")
						);
			}
			
			// 結果取得
			myMappings = session.createQuery(cr)
									.getResultList();
			
		} catch (RuntimeException ex) {
			StandardServiceRegistryBuilder.destroy( registry );
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}
        return SUCCESS;
    }

}
