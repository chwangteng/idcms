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
 * A data access object (DAO) providing persistence and search support for Cqb
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wt.po.Cqb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CqbDAO {
	private static final Logger log = LoggerFactory.getLogger(CqbDAO.class);
	// property constants
	public static final String CQXX = "cqxx";

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

	public void save(Cqb transientInstance) {
		log.debug("saving Cqb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cqb persistentInstance) {
		log.debug("deleting Cqb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cqb findById(java.lang.Integer id) {
		log.debug("getting Cqb instance with id: " + id);
		try {
			Cqb instance = (Cqb) getCurrentSession().get("com.wt.po.Cqb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cqb instance) {
		log.debug("finding Cqb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Cqb").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cqb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Cqb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCqxx(Object cqxx) {
		return findByProperty(CQXX, cqxx);
	}

	public List findAll() {
		log.debug("finding all Cqb instances");
		try {
			String queryString = "from Cqb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cqb merge(Cqb detachedInstance) {
		log.debug("merging Cqb instance");
		try {
			Cqb result = (Cqb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cqb instance) {
		log.debug("attaching dirty Cqb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cqb instance) {
		log.debug("attaching clean Cqb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CqbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CqbDAO) ctx.getBean("CqbDAO");
	}
	
	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
		log.debug("findWithPageSizeAndPageIndex");
		try {
			String queryString = "from Cqb";
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
			String queryString = "select count(*) from Cqb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return ((Long) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("findCount", re);
			throw re;
		} 
	}
}