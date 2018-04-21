package com.wt.po;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sbsylxb entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wt.po.Sbsylxb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SbsylxbDAO {
	private static final Logger log = LoggerFactory.getLogger(SbsylxbDAO.class);
	// property constants
	public static final String SYLX = "sylx";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Sbsylxb transientInstance) {
		log.debug("saving Sbsylxb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sbsylxb persistentInstance) {
		log.debug("deleting Sbsylxb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sbsylxb findById(java.lang.Integer id) {
		log.debug("getting Sbsylxb instance with id: " + id);
		try {
			Sbsylxb instance = (Sbsylxb) getCurrentSession().get("com.wt.po.Sbsylxb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sbsylxb instance) {
		log.debug("finding Sbsylxb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Sbsylxb").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sbsylxb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Sbsylxb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySylx(Object sylx) {
		return findByProperty(SYLX, sylx);
	}

	public List findAll() {
		log.debug("finding all Sbsylxb instances");
		try {
			String queryString = "from Sbsylxb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sbsylxb merge(Sbsylxb detachedInstance) {
		log.debug("merging Sbsylxb instance");
		try {
			Sbsylxb result = (Sbsylxb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sbsylxb instance) {
		log.debug("attaching dirty Sbsylxb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sbsylxb instance) {
		log.debug("attaching clean Sbsylxb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SbsylxbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SbsylxbDAO) ctx.getBean("SbsylxbDAO");
	}
	
	
	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
		log.debug("findWithPageSizeAndPageIndex");
		try {
			String queryString = "from Sbsylxb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult((PageIndex-1)*PageSize); 
			queryObject.setMaxResults(PageSize); 
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("findWithPageSizeAndPageIndex", re);
			throw re;
		}
	}
	public int findCount() {  
		log.debug("findCount");
		try {
			String queryString = "select count(*) from Sbsylxb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return ((Long) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("findCount", re);
			throw re;
		} 
	}
}