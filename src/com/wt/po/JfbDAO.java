package com.wt.po;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for Jfb
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wt.po.Jfb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JfbDAO{
	private static final Logger log = LoggerFactory.getLogger(JfbDAO.class);
	// property constants
	public static final String JFMC = "jfmc";
	public static final String JFDZ = "jfdz";

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

	public void save(Jfb transientInstance) {
		log.debug("saving Jfb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jfb persistentInstance) {
		log.debug("deleting Jfb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jfb findById(java.lang.Integer id) {
		log.debug("getting Jfb instance with id: " + id);
		try {
			Jfb instance = (Jfb) getCurrentSession().get("com.wt.po.Jfb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Jfb instance) {
		log.debug("finding Jfb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Jfb").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Jfb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Jfb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJfmc(Object jfmc) {
		return findByProperty(JFMC, jfmc);
	}

	public List findByJfdz(Object jfdz) {
		return findByProperty(JFDZ, jfdz);
	}

	public List findAll() {
		log.debug("finding all Jfb instances");
		try {
			String queryString = "from Jfb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
		
	public Jfb merge(Jfb detachedInstance) {
		log.debug("merging Jfb instance");
		try {
			Jfb result = (Jfb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jfb instance) {
		log.debug("attaching dirty Jfb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jfb instance) {
		log.debug("attaching clean Jfb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JfbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JfbDAO) ctx.getBean("JfbDAO");
	}
	
	//最早使用的方法，没有添加搜索功能，已弃用已弃用已弃用已弃用已弃用已弃用已弃用，而且该方法中的new根本没必要重载
/*	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
		log.debug("findWithPageSizeAndPageIndex");
		try {
			String queryString = "select new Jfb(jfid, jfmc, jfdz) from Jfb";
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
			String queryString = "select count(*) from Jfb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return ((Long) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("findCount", re);
			throw re;
		} 
	}*/
	
	//目前使用的分页+String模糊搜索Int精确搜索，还没有做排序，看情况有没有实际意义在做
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex, 
			Integer jfid, String jfmc,String jfdz,String sortField,String sortOrder){
		log.debug("findWithPageSizeAndPageIndexAndLike");
		List<Jfb> list = null;
		String queryString = null; 
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "from Jfb where 1=1";    
	         if((jfid != null) && !(jfid==0)){
	        	 queryString = queryString+" and jfid = "+jfid+"";
	         }  
	         if(jfmc != null && !"".equals(jfmc)){  
	        	 queryString = queryString+" and jfmc like '%"+jfmc+"%'";  
	         }
	         if(jfdz != null && !"".equals(jfdz)){  
	        	 queryString = queryString+" and jfdz like '%"+jfdz+"%'";  
	         }
	         if(sortField != null && !"".equals(sortField)){  //只需要判断一个，因为两个参数要么都有，要么都没有
	        	 queryString = queryString+" order by "+sortField+" "+sortOrder;  
	         }
	          Query queryObject = getCurrentSession().createQuery(queryString);
	          queryObject.setFirstResult((PageIndex-1)*PageSize); 
	          queryObject.setMaxResults(PageSize);
	          list = queryObject.list(); 
		} catch (RuntimeException re) {
			log.error("findWithPageSizeAndPageIndexAndLike", re);
			throw re;
		}
		return list; 
	}
	
	//目前使用的分页+String模糊搜索Int精确搜索，还没有做排序，看情况有没有实际意义在做，count是返回计数
	public int findCount(Integer jfid, String jfmc,String jfdz) {
		log.debug("findCount");
		List<Jfb> list = null;
		String queryString = null; 
		Query queryObject=null;
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "select count(*) from Jfb where 1=1";    
	         if((jfid != null) && !(jfid==0)){
	        	 queryString = queryString+" and jfid = "+jfid+"";
	         }  
	         if(jfmc != null && !"".equals(jfmc)){  
	        	 queryString = queryString+" and jfmc like '%"+jfmc+"%'";  
	         }  
	         if(jfdz != null && !"".equals(jfdz)){  
	        	 queryString = queryString+" and jfdz like '%"+jfdz+"%'";  
	         }  
	          queryObject = getCurrentSession().createQuery(queryString);
	          list = queryObject.list(); 
		} catch (RuntimeException re) {
			log.error("findCount", re);
			throw re;
		}
		return ((Long) queryObject.uniqueResult()).intValue();
	}
}