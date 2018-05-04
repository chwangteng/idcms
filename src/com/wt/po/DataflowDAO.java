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
 * Dataflow entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wt.po.Dataflow
 * @author MyEclipse Persistence Tools
 */
@Transactional("transactionManagerPostgres")
public class DataflowDAO {
	private static final Logger log = LoggerFactory.getLogger(DataflowDAO.class);
	// property constants
	public static final String JHJ = "jhj";
	public static final String JK = "jk";
	public static final String LRLL = "lrll";
	public static final String LCLL = "lcll";

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

	public void save(Dataflow transientInstance) {
		log.debug("saving Dataflow instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dataflow persistentInstance) {
		log.debug("deleting Dataflow instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dataflow findById(java.lang.Integer id) {
		log.debug("getting Dataflow instance with id: " + id);
		try {
			Dataflow instance = (Dataflow) getCurrentSession().get("com.wt.po.Dataflow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dataflow instance) {
		log.debug("finding Dataflow instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Dataflow").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Dataflow instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Dataflow as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJhj(Object jhj) {
		return findByProperty(JHJ, jhj);
	}

	public List findByJk(Object jk) {
		return findByProperty(JK, jk);
	}

	public List findByLrll(Object lrll) {
		return findByProperty(LRLL, lrll);
	}

	public List findByLcll(Object lcll) {
		return findByProperty(LCLL, lcll);
	}

	public List findAll() {
		log.debug("finding all Dataflow instances");
		try {
			String queryString = "from Dataflow";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dataflow merge(Dataflow detachedInstance) {
		log.debug("merging Dataflow instance");
		try {
			Dataflow result = (Dataflow) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dataflow instance) {
		log.debug("attaching dirty Dataflow instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dataflow instance) {
		log.debug("attaching clean Dataflow instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DataflowDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DataflowDAO) ctx.getBean("DataflowDAO");
	}
	
	
	
	//目前使用的分页+String模糊搜索Int精确搜索，看情况有没有实际意义在做
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex, 
			 Integer id,String jhj,String jk, String lrll,String lcll,String time,
			 String sortField,String sortOrder,String starttime,String endtime){
		log.debug("findWithPageSizeAndPageIndexAndLikeAndEqual");
		List<Dataflow> list = null;
		String queryString = null; 
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "from Dataflow where 1=1";    
			if((id != null) && !(id==0)){
	        	 queryString = queryString+" and id = "+id+"";
	         }
	         if(jhj != null && !"".equals(jhj)){
	        	 queryString = queryString+" and jhj like '%"+jhj+"%'";  
	         }
	         if(jk != null && !"".equals(jk)){
	        	 queryString = queryString+" and jk like '%"+jk+"%'";  
	         }
	         if(lrll != null && !"".equals(lrll)){
	        	 queryString = queryString+" and lrll like '%"+lrll+"%'";  
	         }
	         if(lcll != null && !"".equals(lcll)){
	        	 queryString = queryString+" and lcll like '%"+lcll+"%'";  
	         }
	         if(time != null && !"".equals(time)){
	        	 queryString = queryString+" and time like '%"+time+"%'";  
	         }
	         if(starttime != null && !"".equals(starttime)){
	        	 queryString = queryString+" and time between '"+starttime+"'";  
	         }else{
	        	 queryString = queryString+" and time between '1970-01-01 00:00:00'"; 
	         }
	         if(endtime != null && !"".equals(endtime)){
	        	 queryString = queryString+" and '"+endtime+"'";  
	         }else{
	        	 queryString = queryString+" and '2037-12-31 23:59:59'"; 
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
	public int findCount(Integer id,String jhj,String jk, String lrll,String lcll,String time,String starttime,String endtime) {
		log.debug("findCount");
		List<Dataflow> list = null;
		String queryString = null; 
		Query queryObject=null;
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "select count(*) from Dataflow where 1=1";    
			if((id != null) && !(id==0)){
	        	 queryString = queryString+" and id = "+id+"";
	         }
	         if(jhj != null && !"".equals(jhj)){
	        	 queryString = queryString+" and jhj like '%"+jhj+"%'";  
	         }
	         if(jk != null && !"".equals(jk)){
	        	 queryString = queryString+" and jk like '%"+jk+"%'";  
	         }
	         if(lrll != null && !"".equals(lrll)){
	        	 queryString = queryString+" and lrll like '%"+lrll+"%'";  
	         }
	         if(lcll != null && !"".equals(lcll)){
	        	 queryString = queryString+" and lcll like '%"+lcll+"%'";  
	         }
	         if(time != null && !"".equals(time)){
	        	 queryString = queryString+" and time like '%"+time+"%'";  
	         }

			
	          queryObject = getCurrentSession().createQuery(queryString);
	          list = queryObject.list(); 
		} catch (RuntimeException re) {
			log.error("findCount", re);
			throw re;
		}
		return ((Long) queryObject.uniqueResult()).intValue();
	}
	
	
	//返回所有记录的条数
	public int countAll(){
		log.debug("countAll");
		List<Dataflow> list = null;
		String queryString = null; 
		Query queryObject=null;
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "select count(*) from Dataflow";    
	        queryObject = getCurrentSession().createQuery(queryString);
	        list = queryObject.list(); 
		} catch (RuntimeException re) {
			log.error("countAll", re);
			throw re;
		}
		return ((Long) queryObject.uniqueResult()).intValue();
	}
	
	
	//获取最后一条记录
	public List getLastItem(){
		log.debug("getLastItem");
		List<Dataflow> list = null;
		String queryString = null; 
		try {
			/********************* 普通方式(HQL) *************************/  
			queryString = "from Dataflow order by id desc limit 1";    
	          Query queryObject = getCurrentSession().createQuery(queryString);
//	          queryObject.setMaxResults(1);
	          list = queryObject.list(); 
		} catch (RuntimeException re) {
			log.error("getLastItem", re);
			throw re;
		}
		return list;
	}
}