package org.ng.search.data;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class KeyworldsListDao {

	private static final Log log = LogFactory.getLog(KeyworldsListDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			throw new IllegalStateException(
					"Could not SessionFactory ");
		}
	}

	public void persist(Keywordlist transientInstance) {
		log.debug("persisting Keywordlist instance");
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.begin();
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			re.printStackTrace();
			tx.rollback();
			throw re;
		}
	}

}
