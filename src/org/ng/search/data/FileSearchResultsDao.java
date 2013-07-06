package org.ng.search.data;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FileSearchResultsDao {

	private static final Log log = LogFactory
			.getLog(FileSearchResultsDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException(
					"Could not create SessionFactory "+e.getMessage());
		}
	}

	public void persist(FileSearchResults transientInstance) {
		log.debug("persisting FileSearchResults instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			try {
				tx.begin();
				session.persist(transientInstance);
				tx.commit();
				log.debug("persist successful");
			} catch( Exception e) {
				tx.rollback();
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

}
