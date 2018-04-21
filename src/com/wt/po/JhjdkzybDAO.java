package com.wt.po;

import java.util.List;
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
 * Jhjdkzyb entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wt.po.Jhjdkzyb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JhjdkzybDAO {
	private static final Logger log = LoggerFactory.getLogger(JhjdkzybDAO.class);
	// property constants
	public static final String DKH = "dkh";
	public static final String DKXX = "dkxx";
	public static final String DKJCRJ = "dkjcrj";

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

	public void save(Jhjdkzyb transientInstance) {
		log.debug("saving Jhjdkzyb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jhjdkzyb persistentInstance) {
		log.debug("deleting Jhjdkzyb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jhjdkzyb findById(java.lang.Integer id) {
		log.debug("getting Jhjdkzyb instance with id: " + id);
		try {
			Jhjdkzyb instance = (Jhjdkzyb) getCurrentSession().get("com.wt.po.Jhjdkzyb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Jhjdkzyb instance) {
		log.debug("finding Jhjdkzyb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Jhjdkzyb").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Jhjdkzyb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Jhjdkzyb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDkh(Object dkh) {
		return findByProperty(DKH, dkh);
	}

	public List findByDkxx(Object dkxx) {
		return findByProperty(DKXX, dkxx);
	}

	public List findByDkjcrj(Object dkjcrj) {
		return findByProperty(DKJCRJ, dkjcrj);
	}

	public List findAll() {
		log.debug("finding all Jhjdkzyb instances");
		try {
			String queryString = "from Jhjdkzyb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jhjdkzyb merge(Jhjdkzyb detachedInstance) {
		log.debug("merging Jhjdkzyb instance");
		try {
			Jhjdkzyb result = (Jhjdkzyb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jhjdkzyb instance) {
		log.debug("attaching dirty Jhjdkzyb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jhjdkzyb instance) {
		log.debug("attaching clean Jhjdkzyb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JhjdkzybDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JhjdkzybDAO) ctx.getBean("JhjdkzybDAO");
	}
	
//	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
//		log.debug("findWithPageSizeAndPageIndex");
//		try {
//			String queryString = "from Jhjdkzyb";
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
//			String queryString = "select count(*) from Jhjdkzyb";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			return ((Long) queryObject.uniqueResult()).intValue();
//		} catch (RuntimeException re) {
//			log.error("findCount", re);
//			throw re;
//		} 
//	}
	
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex,
			 Integer dkid,
			 Sbxxb sbxxb,
			 Integer dkh,
			 String dkxx,
			 String dkjcrj,String sortField,String sortOrder){
		log.debug("findWithPageSizeAndPageIndexAndLikeAndEqual");
		try {
			String queryString = "from Jhjdkzyb where 1=1";
			if((dkid != null) && !(dkid==0)){
	        	 queryString = queryString+" and dkid = "+dkid+"";
	         }
			if((sbxxb!=null)&&(sbxxb.getSbid() != null) && !(sbxxb.getSbid()==0)){
	        	 queryString = queryString+" and sbxxb.sbid = "+sbxxb.getSbid()+"";
	         }
			if((dkh != null) && !(dkh==0)){
	        	 queryString = queryString+" and dkh = "+dkh+"";
	         }
			if(dkxx != null && !"".equals(dkxx)){  
	        	 queryString = queryString+" and dkxx like '%"+dkxx+"%'";
	         }
			if(dkjcrj != null && !"".equals(dkjcrj)){  
	        	 queryString = queryString+" and dkjcrj like '%"+dkjcrj+"%'";
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
	public int findCount(
			Integer dkid,
			 Sbxxb sbxxb,
			 Integer dkh,
			 String dkxx,
			 String dkjcrj) {  
		log.debug("findCount");
		try {
			String queryString = "select count(*) from Jhjdkzyb  where 1=1";
			if((dkid != null) && !(dkid==0)){
	        	 queryString = queryString+" and dkid = "+dkid+"";
	         }
			if((sbxxb!=null)&&(sbxxb.getSbid() != null) && !(sbxxb.getSbid()==0)){
	        	 queryString = queryString+" and sbxxb.sbid = "+sbxxb.getSbid()+"";
	         }
			if((dkh != null) && !(dkh==0)){
	        	 queryString = queryString+" and dkh = "+dkh+"";
	         }
			if(dkxx != null && !"".equals(dkxx)){  
	        	 queryString = queryString+" and dkxx like '%"+dkxx+"%'";
	         }
			if(dkjcrj != null && !"".equals(dkjcrj)){  
	        	 queryString = queryString+" and dkjcrj like '%"+dkjcrj+"%'";
	         }
			Query queryObject = getCurrentSession().createQuery(queryString);
			return ((Long) queryObject.uniqueResult()).intValue();
		} catch (RuntimeException re) {
			log.error("findCount", re);
			throw re;
		} 
	}
}