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
 * TblSwitchsnmp entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wt.po.TblSwitchsnmp
 * @author MyEclipse Persistence Tools
 */
@Transactional("transactionManagerPostgres")
public class TblSwitchsnmpDAO {
	private static final Logger log = LoggerFactory.getLogger(TblSwitchsnmpDAO.class);
	// property constants
	public static final String DEVICEID = "deviceid";
	public static final String DEVICENAME = "devicename";
	public static final String IPADDR = "ipaddr";
	public static final String IFOID = "ifoid";
	public static final String FLOWOID = "flowoid";
	public static final String COMMUNITY = "community";
	public static final String FLOWOUTOID = "flowoutoid";

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

	public void save(TblSwitchsnmp transientInstance) {
		log.debug("saving TblSwitchsnmp instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TblSwitchsnmp persistentInstance) {
		log.debug("deleting TblSwitchsnmp instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TblSwitchsnmp findById(java.lang.String id) {
		log.debug("getting TblSwitchsnmp instance with id: " + id);
		try {
			TblSwitchsnmp instance = (TblSwitchsnmp) getCurrentSession().get("com.wt.po.TblSwitchsnmp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TblSwitchsnmp instance) {
		log.debug("finding TblSwitchsnmp instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.TblSwitchsnmp").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TblSwitchsnmp instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TblSwitchsnmp as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDeviceid(Object deviceid) {
		return findByProperty(DEVICEID, deviceid);
	}

	public List findByDevicename(Object devicename) {
		return findByProperty(DEVICENAME, devicename);
	}

	public List findByIpaddr(Object ipaddr) {
		return findByProperty(IPADDR, ipaddr);
	}

	public List findByIfoid(Object ifoid) {
		return findByProperty(IFOID, ifoid);
	}

	public List findByFlowoid(Object flowoid) {
		return findByProperty(FLOWOID, flowoid);
	}

	public List findByCommunity(Object community) {
		return findByProperty(COMMUNITY, community);
	}

	public List findByFlowoutoid(Object flowoutoid) {
		return findByProperty(FLOWOUTOID, flowoutoid);
	}

	public List findAll() {
		log.debug("finding all TblSwitchsnmp instances");
		try {
			String queryString = "from TblSwitchsnmp";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TblSwitchsnmp merge(TblSwitchsnmp detachedInstance) {
		log.debug("merging TblSwitchsnmp instance");
		try {
			TblSwitchsnmp result = (TblSwitchsnmp) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TblSwitchsnmp instance) {
		log.debug("attaching dirty TblSwitchsnmp instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TblSwitchsnmp instance) {
		log.debug("attaching clean TblSwitchsnmp instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TblSwitchsnmpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TblSwitchsnmpDAO) ctx.getBean("TblSwitchsnmpDAO");
	}
	
	
	
	//目前使用的分页+String模糊搜索Int精确搜索，还没有做排序，看情况有没有实际意义在做
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex, 
			 String id,String deviceid,String devicename,String ipaddr,String ifoid,String flowoid,String community,String flowoutoid,
			 String sortField,String sortOrder){
		log.debug("findWithPageSizeAndPageIndexAndLike");
		List<TblSwitchsnmp> list = null;
		String queryString = null; 
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "from TblSwitchsnmp where 1=1";    
	         if((id != null) && !"".equals(id)){
	        	 queryString = queryString+" and id = "+id+"";
	         }  
	         if(deviceid != null && !"".equals(deviceid)){  
	        	 queryString = queryString+" and deviceid like '%"+deviceid+"%'";  
	         }
	         if(devicename != null && !"".equals(devicename)){  
	        	 queryString = queryString+" and devicename like '%"+devicename+"%'";  
	         }
	         if(ipaddr != null && !"".equals(ipaddr)){  
	        	 queryString = queryString+" and ipaddr like '%"+ipaddr+"%'";  
	         }
	         if(ifoid != null && !"".equals(ifoid)){  
	        	 queryString = queryString+" and ifoid like '%"+ifoid+"%'";  
	         }
	         if(flowoid != null && !"".equals(flowoid)){  
	        	 queryString = queryString+" and flowoid like '%"+flowoid+"%'";  
	         }
	         if(community != null && !"".equals(community)){  
	        	 queryString = queryString+" and community like '%"+community+"%'";  
	         }
	         if(flowoutoid != null && !"".equals(flowoutoid)){  
	        	 queryString = queryString+" and flowoutoid like '%"+flowoutoid+"%'";  
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
	public int findCount(String id,String deviceid,String devicename,String ipaddr,String ifoid,String flowoid,String community,String flowoutoid) {
		log.debug("findCount");
		List<TblSwitchsnmp> list = null;
		String queryString = null; 
		Query queryObject=null;
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "select count(*) from TblSwitchsnmp where 1=1";    
	         if((id != null) && !"".equals(id)){
	        	 queryString = queryString+" and id = "+id+"";
	         }  
	         if(deviceid != null && !"".equals(deviceid)){  
	        	 queryString = queryString+" and deviceid like '%"+deviceid+"%'";  
	         }
	         if(devicename != null && !"".equals(devicename)){  
	        	 queryString = queryString+" and devicename like '%"+devicename+"%'";  
	         }
	         if(ipaddr != null && !"".equals(ipaddr)){  
	        	 queryString = queryString+" and ipaddr like '%"+ipaddr+"%'";  
	         }
	         if(ifoid != null && !"".equals(ifoid)){  
	        	 queryString = queryString+" and ifoid like '%"+ifoid+"%'";  
	         }
	         if(flowoid != null && !"".equals(flowoid)){  
	        	 queryString = queryString+" and flowoid like '%"+flowoid+"%'";  
	         }
	         if(community != null && !"".equals(community)){  
	        	 queryString = queryString+" and community like '%"+community+"%'";  
	         }
	         if(flowoutoid != null && !"".equals(flowoutoid)){  
	        	 queryString = queryString+" and flowoutoid like '%"+flowoutoid+"%'";  
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