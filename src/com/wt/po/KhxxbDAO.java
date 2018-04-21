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
 * A data access object (DAO) providing persistence and search support for Khxxb
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wt.po.Khxxb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class KhxxbDAO {
	private static final Logger log = LoggerFactory.getLogger(KhxxbDAO.class);
	// property constants
	public static final String KHM = "khm";
	public static final String KHDZ = "khdz";
	public static final String TYXYDM = "tyxydm";
	public static final String YYZZ = "yyzz";
	public static final String LXR = "lxr";
	public static final String LXRDH = "lxrdh";
	public static final String LXRYX = "lxryx";

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

	public void save(Khxxb transientInstance) {
		log.debug("saving Khxxb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Khxxb persistentInstance) {
		log.debug("deleting Khxxb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Khxxb findById(java.lang.Integer id) {
		log.debug("getting Khxxb instance with id: " + id);
		try {
			Khxxb instance = (Khxxb) getCurrentSession().get("com.wt.po.Khxxb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Khxxb instance) {
		log.debug("finding Khxxb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Khxxb").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Khxxb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Khxxb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKhm(Object khm) {
		return findByProperty(KHM, khm);
	}

	public List findByKhdz(Object khdz) {
		return findByProperty(KHDZ, khdz);
	}

	public List findByTyxydm(Object tyxydm) {
		return findByProperty(TYXYDM, tyxydm);
	}

	public List findByYyzz(Object yyzz) {
		return findByProperty(YYZZ, yyzz);
	}

	public List findByLxr(Object lxr) {
		return findByProperty(LXR, lxr);
	}

	public List findByLxrdh(Object lxrdh) {
		return findByProperty(LXRDH, lxrdh);
	}

	public List findByLxryx(Object lxryx) {
		return findByProperty(LXRYX, lxryx);
	}

	public List findAll() {
		log.debug("finding all Khxxb instances");
		try {
			String queryString = "from Khxxb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Khxxb merge(Khxxb detachedInstance) {
		log.debug("merging Khxxb instance");
		try {
			Khxxb result = (Khxxb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Khxxb instance) {
		log.debug("attaching dirty Khxxb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Khxxb instance) {
		log.debug("attaching clean Khxxb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KhxxbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (KhxxbDAO) ctx.getBean("KhxxbDAO");
	}
	
	
//	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
//		log.debug("findWithPageSizeAndPageIndex");
//		try {
//			String queryString = "from Khxxb";
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
//			String queryString = "select count(*) from Khxxb";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			return ((Long) queryObject.uniqueResult()).intValue();
//		} catch (RuntimeException re) {
//			log.error("findCount", re);
//			throw re;
//		} 
//	}
	
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex,
	Integer khid,
	 String khm,
	 String khdz,
	 String tyxydm,
	 String yyzz,
	 String lxr,
	 String lxrdh,
	 String lxryx,String sortField,String sortOrder){
	log.debug("findWithPageSizeAndPageIndexAndLikeAndEqual");
	try {
		String queryString = "from Khxxb where 1=1";
		if((khid != null) && !(khid==0)){
       	 queryString = queryString+" and khid = "+khid+"";
        }
		if(khm != null && !"".equals(khm)){  
       	 queryString = queryString+" and khm like '%"+khm+"%'";
        }
		if(khdz != null && !"".equals(khdz)){  
       	 queryString = queryString+" and khdz like '%"+khdz+"%'";
        }
		if(tyxydm != null && !"".equals(tyxydm)){  
       	 queryString = queryString+" and tyxydm like '%"+tyxydm+"%'";
        }
		if(yyzz != null && !"".equals(yyzz)){  
       	 queryString = queryString+" and yyzz like '%"+yyzz+"%'";
        }
		if(lxr != null && !"".equals(lxr)){  
       	 queryString = queryString+" and lxr like '%"+lxr+"%'";
        }
		if(lxrdh != null && !"".equals(lxrdh)){  
       	 queryString = queryString+" and lxrdh like '%"+lxrdh+"%'";
        }
		if(lxryx != null && !"".equals(lxryx)){  
       	 queryString = queryString+" and lxryx like '%"+lxryx+"%'";
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
	public int findCount(Integer khid,
			 String khm,
			 String khdz,
			 String tyxydm,
			 String yyzz,
			 String lxr,
			 String lxrdh,
			 String lxryx) {  
	log.debug("findCount");
	try {
		String queryString = "select count(*) from Khxxb where 1=1";
		if((khid != null) && !(khid==0)){
	       	 queryString = queryString+" and khid = "+khid+"";
	        }
			if(khm != null && !"".equals(khm)){  
	       	 queryString = queryString+" and khm like '%"+khm+"%'";
	        }
			if(khdz != null && !"".equals(khdz)){  
	       	 queryString = queryString+" and khdz like '%"+khdz+"%'";
	        }
			if(tyxydm != null && !"".equals(tyxydm)){  
	       	 queryString = queryString+" and tyxydm like '%"+tyxydm+"%'";
	        }
			if(yyzz != null && !"".equals(yyzz)){  
	       	 queryString = queryString+" and yyzz like '%"+yyzz+"%'";
	        }
			if(lxr != null && !"".equals(lxr)){  
	       	 queryString = queryString+" and lxr like '%"+lxr+"%'";
	        }
			if(lxrdh != null && !"".equals(lxrdh)){  
	       	 queryString = queryString+" and lxrdh like '%"+lxrdh+"%'";
	        }
			if(lxryx != null && !"".equals(lxryx)){  
	       	 queryString = queryString+" and lxryx like '%"+lxryx+"%'";
	        }
		Query queryObject = getCurrentSession().createQuery(queryString);
		return ((Long) queryObject.uniqueResult()).intValue();
	} catch (RuntimeException re) {
		log.error("findCount", re);
		throw re;
	} 
}
}