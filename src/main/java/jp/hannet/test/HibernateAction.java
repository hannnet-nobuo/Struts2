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
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import jp.hannet.test.beans.MyMapping;

public class HibernateAction extends ActionSupport {
    
	private static final long serialVersionUID = -7387776517903121938L;

	private List<MyMapping> myMappings ;
    
    public List<MyMapping> getMyMappings() {
		return myMappings;
	}

	public String execute() throws Exception {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		Session session = null;
		try {
			// セッション取得
			session = cfg.buildSessionFactory().openSession();
			// クエリをつくる
			CriteriaBuilder builder = session.getCriteriaBuilder();			
			CriteriaQuery<MyMapping> criteria = builder.createQuery(MyMapping.class);
			Root<MyMapping> root = criteria.from(MyMapping.class);
			// SELECT
			criteria.select(root);
			// 結果取得
			myMappings = session.createQuery(criteria).getResultList();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			if (session != null)
				session.close();
		}
        return SUCCESS;
    }

}
