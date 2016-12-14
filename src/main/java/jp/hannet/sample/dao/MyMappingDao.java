package jp.hannet.sample.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jp.hannet.sample.common.DbAccess;
import jp.hannet.sample.model.MyMapping;

public class MyMappingDao {
	
	public List<MyMapping> likeById(String id) {
		
		Session session = DbAccess.getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<MyMapping> cr = builder.createQuery(MyMapping.class);
		Root<MyMapping> root = cr.from( MyMapping.class );
		cr.select(root);
		
		if (id != null && !"".equals(id.trim())) {
			cr.where(
				builder.like(root.<String>get("id"), "%" + id + "%")
				);
		}
		
		// 結果取得
		return session.createQuery(cr)
						.getResultList();
	}
	
	public boolean existById(String id) {
		boolean re = false;
		if (id != null) {
			Session session = null;
			try {
				session = DbAccess.getSession();
				
				@SuppressWarnings("unchecked")
				Query<Long> q = session
								.getNamedQuery("existById")
								.setParameter("id", id);
				
				if (q.getSingleResult() > 0) {
					re = true;
				}
			} finally {
				session.close();
			}
		}
		return re;
	}
	
	public void save(MyMapping map) {
		Transaction txn = null;
		Session session = null;
		try {
			session = DbAccess.getSession();
			txn = session.getTransaction();
			txn.begin();
			session.save(map);
			txn.commit();
		} finally {
			session.close();
		}
	}

	public void delete(MyMapping map) {
		Transaction txn = null;
		Session session = null;
		try {
			session = DbAccess.getSession();
			txn = session.getTransaction();
			txn.begin();
			session.delete(map);
			txn.commit();
		} finally {
			session.close();
		}
	}
	
	public void update(MyMapping map) {
		Transaction txn = null;
		Session session = null;
		try {
			session = DbAccess.getSession();
			txn = session.getTransaction();
			txn.begin();
			session.update(map);
			txn.commit();
		} finally {
			session.close();
		}
	}
}
