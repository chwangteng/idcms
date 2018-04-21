package com.wt.po;

import java.sql.Timestamp;
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
 * Attackinfoes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wt.po.Attackinfoes
 * @author MyEclipse Persistence Tools
 */
@Transactional("transactionManagerAttack")
public class AttackinfoesDAO {
	private static final Logger log = LoggerFactory.getLogger(AttackinfoesDAO.class);
	// property constants
	public static final String STATUS = "status";
	public static final String COUNT = "count";
	public static final String DEFTYPE = "deftype";
	public static final String _SIP = "SIp";
	public static final String DROP_COUNT = "dropCount";
	public static final String _SPORT_LIST = "SPortList";
	public static final String _CPORT_LIST = "CPortList";
	public static final String _CIP_LIST = "CIpList";
	public static final String PACKET_TYPE = "packetType";
	public static final String DURATION = "duration";
	public static final String DROP_SIZE = "dropSize";
	public static final String SIZE = "size";

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

	public void save(Attackinfoes transientInstance) {
		log.debug("saving Attackinfoes instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Attackinfoes persistentInstance) {
		log.debug("deleting Attackinfoes instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Attackinfoes findById(java.lang.String id) {
		log.debug("getting Attackinfoes instance with id: " + id);
		try {
			Attackinfoes instance = (Attackinfoes) getCurrentSession().get("com.wt.po.Attackinfoes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Attackinfoes instance) {
		log.debug("finding Attackinfoes instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Attackinfoes").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Attackinfoes instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Attackinfoes as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List findByDeftype(Object deftype) {
		return findByProperty(DEFTYPE, deftype);
	}

	public List findBySIp(Object SIp) {
		return findByProperty(_SIP, SIp);
	}

	public List findByDropCount(Object dropCount) {
		return findByProperty(DROP_COUNT, dropCount);
	}

	public List findBySPortList(Object SPortList) {
		return findByProperty(_SPORT_LIST, SPortList);
	}

	public List findByCPortList(Object CPortList) {
		return findByProperty(_CPORT_LIST, CPortList);
	}

	public List findByCIpList(Object CIpList) {
		return findByProperty(_CIP_LIST, CIpList);
	}

	public List findByPacketType(Object packetType) {
		return findByProperty(PACKET_TYPE, packetType);
	}

	public List findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List findByDropSize(Object dropSize) {
		return findByProperty(DROP_SIZE, dropSize);
	}

	public List findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	public List findAll() {
		log.debug("finding all Attackinfoes instances");
		try {
			String queryString = "from Attackinfoes";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Attackinfoes merge(Attackinfoes detachedInstance) {
		log.debug("merging Attackinfoes instance");
		try {
			Attackinfoes result = (Attackinfoes) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Attackinfoes instance) {
		log.debug("attaching dirty Attackinfoes instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Attackinfoes instance) {
		log.debug("attaching clean Attackinfoes instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AttackinfoesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AttackinfoesDAO) ctx.getBean("AttackinfoesDAO");
	}
	
	
	//目前使用的分页+String模糊搜索Int精确搜索，看情况有没有实际意义在做
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex, 
			 String id,String status,String count,String deftype,String SIp,String startTime,
			 String dropCount,String SPortList,String CPortList,String CIpList,String packetType,
			 String endTime,String duration,String dropSize,String size,
			 String sortField,String sortOrder){
		log.debug("findWithPageSizeAndPageIndexAndLikeAndEqual");
		List<Attackinfoes> list = null;
		String queryString = null; 
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "from Attackinfoes where 1=1";    
	         if(id != null && !"".equals(id)){  
	        	 queryString = queryString+" and id like '%"+id+"%'";  
	         }
	         if(status != null && !"".equals(status)){  
	        	 queryString = queryString+" and status like '%"+status+"%'";  
	         }
	         if(count != null && !"".equals(count)){  
	        	 queryString = queryString+" and count like '%"+count+"%'";  
	         }
	         if(deftype != null && !"".equals(deftype)){  
	        	 queryString = queryString+" and deftype like '%"+deftype+"%'";  
	         }
	         if(SIp != null && !"".equals(SIp)){  
	        	 queryString = queryString+" and SIp like '%"+SIp+"%'";  
	         }
	         if(startTime != null && !"".equals(startTime)){  
	        	 queryString = queryString+" and startTime like '%"+startTime+"%'";  
	         }
	         if(dropCount != null && !"".equals(dropCount)){  
	        	 queryString = queryString+" and dropCount like '%"+dropCount+"%'";  
	         }
	         if(SPortList != null && !"".equals(SPortList)){  
	        	 queryString = queryString+" and SPortList like '%"+SPortList+"%'";  
	         }
	         if(CPortList != null && !"".equals(CPortList)){  
	        	 queryString = queryString+" and CPortList like '%"+CPortList+"%'";  
	         }
	         if(CIpList != null && !"".equals(CIpList)){  
	        	 queryString = queryString+" and CIpList like '%"+CIpList+"%'";  
	         }
	         if(packetType != null && !"".equals(packetType)){  
	        	 queryString = queryString+" and packetType like '%"+packetType+"%'";  
	         }
	         if(endTime != null && !"".equals(endTime)){  
	        	 queryString = queryString+" and endTime like '%"+endTime+"%'";  
	         }
	         if(duration != null && !"".equals(duration)){  
	        	 queryString = queryString+" and duration like '%"+duration+"%'";  
	         }
	         if(dropSize != null && !"".equals(dropSize)){  
	        	 queryString = queryString+" and dropSize like '%"+dropSize+"%'";  
	         }
	         if(size != null && !"".equals(size)){  
	        	 queryString = queryString+" and size like '%"+size+"%'";  
	         }
	         
	         if(sortField != null && !"".equals(sortField)){  //只需要判断一个，因为两个参数要么都有，要么都没有
	        	 queryString = queryString+" order by "+sortField+" "+sortOrder;  
	         }
	          Query queryObject = getCurrentSession().createQuery(queryString);
	          queryObject.setFirstResult((PageIndex-1)*PageSize); 
	          queryObject.setMaxResults(PageSize);
	          list = queryObject.list(); 
		} catch (RuntimeException re) {
			log.error("findWithPageSizeAndPageIndexAndLikeAndEqual", re);
			throw re;
		}
		return list; 
	}
	
	//目前使用的分页+String模糊搜索,count是返回计数
	public int findCount(String id,String status,String count,String deftype,String SIp,String startTime,
			 String dropCount,String SPortList,String CPortList,String CIpList,String packetType,
			 String endTime,String duration,String dropSize,String size) {
		log.debug("findCount");
		List<Attackinfoes> list = null;
		String queryString = null; 
		Query queryObject=null;
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "select count(*) from Attackinfoes where 1=1";    

	         if(id != null && !"".equals(id)){  
	        	 queryString = queryString+" and id like '%"+id+"%'";  
	         }
	         if(status != null && !"".equals(status)){  
	        	 queryString = queryString+" and status like '%"+status+"%'";  
	         }
	         if(count != null && !"".equals(count)){  
	        	 queryString = queryString+" and count like '%"+count+"%'";  
	         }
	         if(deftype != null && !"".equals(deftype)){  
	        	 queryString = queryString+" and deftype like '%"+deftype+"%'";  
	         }
	         if(SIp != null && !"".equals(SIp)){  
	        	 queryString = queryString+" and SIp like '%"+SIp+"%'";  
	         }
	         if(startTime != null && !"".equals(startTime)){  
	        	 queryString = queryString+" and startTime like '%"+startTime+"%'";  
	         }
	         if(dropCount != null && !"".equals(dropCount)){  
	        	 queryString = queryString+" and dropCount like '%"+dropCount+"%'";  
	         }
	         if(SPortList != null && !"".equals(SPortList)){  
	        	 queryString = queryString+" and SPortList like '%"+SPortList+"%'";  
	         }
	         if(CPortList != null && !"".equals(CPortList)){  
	        	 queryString = queryString+" and CPortList like '%"+CPortList+"%'";  
	         }
	         if(CIpList != null && !"".equals(CIpList)){  
	        	 queryString = queryString+" and CIpList like '%"+CIpList+"%'";  
	         }
	         if(packetType != null && !"".equals(packetType)){  
	        	 queryString = queryString+" and packetType like '%"+packetType+"%'";  
	         }
	         if(endTime != null && !"".equals(endTime)){  
	        	 queryString = queryString+" and endTime like '%"+endTime+"%'";  
	         }
	         if(duration != null && !"".equals(duration)){  
	        	 queryString = queryString+" and duration like '%"+duration+"%'";  
	         }
	         if(dropSize != null && !"".equals(dropSize)){  
	        	 queryString = queryString+" and dropSize like '%"+dropSize+"%'";  
	         }
	         if(size != null && !"".equals(size)){  
	        	 queryString = queryString+" and size like '%"+size+"%'";  
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