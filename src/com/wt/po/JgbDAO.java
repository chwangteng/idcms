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
 * A data access object (DAO) providing persistence and search support for Jgb
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wt.po.Jgb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JgbDAO {
	private static final Logger log = LoggerFactory.getLogger(JgbDAO.class);
	// property constants
	public static final String JGBH = "jgbh";
	public static final String JGWZ = "jgwz";

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

	public void save(Jgb transientInstance) {
		log.debug("saving Jgb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jgb persistentInstance) {
		log.debug("deleting Jgb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jgb findById(java.lang.Integer id) {
		log.debug("getting Jgb instance with id: " + id);
		try {
			Jgb instance = (Jgb) getCurrentSession().get("com.wt.po.Jgb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Jgb instance) {
		log.debug("finding Jgb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Jgb").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Jgb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Jgb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	  
	public List findByJgbh(Object jgbh) {
		return findByProperty(JGBH, jgbh);
	}

	public List findByJgwz(Object jgwz) {
		return findByProperty(JGWZ, jgwz);
	}

	public List findAll() {
		log.debug("finding all Jgb instances");
		try {
			String queryString = "from Jgb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jgb merge(Jgb detachedInstance) {
		log.debug("merging Jgb instance");
		try {
			Jgb result = (Jgb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jgb instance) {
		log.debug("attaching dirty Jgb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jgb instance) {
		log.debug("attaching clean Jgb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JgbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JgbDAO) ctx.getBean("JgbDAO");
	}
	
//	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
//		log.debug("findWithPageSizeAndPageIndex");
//		try {
//			String queryString = "from Jgb";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			queryObject.setFirstResult((PageIndex-1)*PageSize); 
//			queryObject.setMaxResults(PageSize); 
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("findWithPageSizeAndPageIndex", re);
//			throw re;
//		}
//	}
//	public int findCount() {  
//		log.debug("findCount");
//		try {
//			String queryString = "select count(*) from Jgb";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			return ((Long) queryObject.uniqueResult()).intValue();
//		} catch (RuntimeException re) {
//			log.error("findCount", re);
//			throw re;
//		} 
//	}
	
	
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex,
			Integer jgid,
			String jgbh,
			String jgwz,
			Jfb jfb,String sortField,String sortOrder){
		log.debug("findWithPageSizeAndPageIndexAndLikeAndEqual");
		try {
			String queryString = "from Jgb where 1=1";
	         if((jgid != null) && !(jgid==0)){
	        	 queryString = queryString+" and jgid = "+jgid+"";
	         }
	         if(jgbh != null && !"".equals(jgbh)){  
	        	 queryString = queryString+" and jgbh like '%"+jgbh+"%'";
	         }
	         if(jgwz != null && !"".equals(jgwz)){  
	        	 queryString = queryString+" and jgwz like '%"+jgwz+"%'";
	         }
	         if((jfb!=null)&&(jfb.getJfid() != null) && !(jfb.getJfid()==0)){
	        	 queryString = queryString+" and jfb.jfid = "+jfb.getJfid()+"";
	         }
	         if(sortField != null && !"".equals(sortField)){  //只需要判断一个，因为两个参数要么都有，要么都没有
	        	 queryString = queryString+" order by "+sortField+" "+sortOrder;
	         }
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult((PageIndex-1)*PageSize); 
			queryObject.setMaxResults(PageSize); 
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("findWithPageSizeAndPageIndexAndLikeAndEqual", re);
			throw re;
		}
	}
	
	public int findCount(Integer jgid,
			String jgbh,
			String jgwz,
			Jfb jfb) {  
	log.debug("findCount");
	try {
		String queryString = "select count(*) from Jgb where 1=1";
		if((jgid != null) && !(jgid==0)){
       	 queryString = queryString+" and jgid = "+jgid+"";
        }
        if(jgbh != null && !"".equals(jgbh)){  
       	 queryString = queryString+" and jgbh like '%"+jgbh+"%'";
        }
        if(jgwz != null && !"".equals(jgwz)){  
       	 queryString = queryString+" and jgwz like '%"+jgwz+"%'";
        }
        if((jfb!=null)&&(jfb.getJfid() != null) && !(jfb.getJfid()==0)){
       	 queryString = queryString+" and jfb.jfid = "+jfb.getJfid()+"";
        }
		Query queryObject = getCurrentSession().createQuery(queryString);
		return ((Long) queryObject.uniqueResult()).intValue();
	} catch (RuntimeException re) {
		log.error("findCount", re);
		throw re;
	} 
}

}