package jp.hannet.test.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import jp.hannet.test.beans.MyMapping;

@Repository
public class MyMappingDaoImp implements IMyMappingDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MyMapping selectById(String id) {
		MyMapping map = null;
		if (id != null && !"".equals(id.trim())) {
			Session session = getSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<MyMapping> cr = builder.createQuery(MyMapping.class);
			Root<MyMapping> root = cr.from( MyMapping.class );
		
			cr.select(root)
				.where(builder.equal(root.<String>get("id"),  id ));
			
			map = session.createQuery(cr).getSingleResult();

		}
		return map;
	}

	public List<MyMapping> likeById(String id) {
		Session session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<MyMapping> cr = builder.createQuery(MyMapping.class);
		Root<MyMapping> root = cr.from( MyMapping.class );
		cr.select(root);
		
		if (id != null && !"".equals(id.trim())) {
			cr.where(
					builder.like(root.<String>get("id"), "%" + id + "%")
					);
		}
		return session.createQuery(cr).getResultList();
	}

	public boolean existById(String id) {
		boolean re = false;
		if (id != null) {
			Session session = getSession();
			@SuppressWarnings("unchecked")
			Query<Long> q = session.getNamedQuery("existById").setParameter("id", id);
			
			if (q.getSingleResult() > 0) {
				re = true;
			}
		}
		return re;
	}

	public void save(MyMapping map) {
		getSession().save(map);
	}

	public void delete(MyMapping map) {
		getSession().delete(map);
	}

	public void update(MyMapping map) {
		getSession().update(map);
		
	}


}
