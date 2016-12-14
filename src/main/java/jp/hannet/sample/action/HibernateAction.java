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

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.opensymphony.xwork2.ActionSupport;

import jp.hannet.sample.model.MyMapping;

public class HibernateAction extends ActionSupport {
    
	private static final long serialVersionUID = -7387776517903121938L;

	private List<MyMapping> myMappings ;
    
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
		try {
			// セッション取得
			session = new MetadataSources( registry )
						.buildMetadata()
						.buildSessionFactory()
						.openSession();
			
			// creiteria詳細は以下のURL
			// http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#criteria
			CriteriaQuery<MyMapping> cr = session.getCriteriaBuilder()
												.createQuery(MyMapping.class);
			Root<MyMapping> root = cr.from( MyMapping.class );
			cr.select(root);
			
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
