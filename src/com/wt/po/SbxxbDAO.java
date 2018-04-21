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
 * A data access object (DAO) providing persistence and search support for Sbxxb
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wt.po.Sbxxb
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SbxxbDAO {
	private static final Logger log = LoggerFactory.getLogger(SbxxbDAO.class);
	// property constants
	public static final String SBBM = "sbbm";
	public static final String SBMC = "sbmc";
	public static final String SYZT = "syzt";
	public static final String GG = "gg";
	public static final String CZXT = "czxt";
	public static final String CPZL = "cpzl";
	public static final String CPU = "cpu";
	public static final String NC = "nc";
	public static final String YP = "yp";
	public static final String SBCS = "sbcs";
	public static final String SBXH = "sbxh";
	public static final String GLDZ = "gldz";
	public static final String VLANH = "vlanh";

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

	public void save(Sbxxb transientInstance) {
		log.debug("saving Sbxxb instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sbxxb persistentInstance) {
		log.debug("deleting Sbxxb instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sbxxb findById(java.lang.Integer id) {
		log.debug("getting Sbxxb instance with id: " + id);
		try {
			Sbxxb instance = (Sbxxb) getCurrentSession().get("com.wt.po.Sbxxb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sbxxb instance) {
		log.debug("finding Sbxxb instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.wt.po.Sbxxb").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sbxxb instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Sbxxb as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySbbm(Object sbbm) {
		return findByProperty(SBBM, sbbm);
	}

	public List findBySbmc(Object sbmc) {
		return findByProperty(SBMC, sbmc);
	}

	public List findBySyzt(Object syzt) {
		return findByProperty(SYZT, syzt);
	}

	public List findByGg(Object gg) {
		return findByProperty(GG, gg);
	}

	public List findByCzxt(Object czxt) {
		return findByProperty(CZXT, czxt);
	}

	public List findByCpzl(Object cpzl) {
		return findByProperty(CPZL, cpzl);
	}

	public List findByCpu(Object cpu) {
		return findByProperty(CPU, cpu);
	}

	public List findByNc(Object nc) {
		return findByProperty(NC, nc);
	}

	public List findByYp(Object yp) {
		return findByProperty(YP, yp);
	}

	public List findBySbcs(Object sbcs) {
		return findByProperty(SBCS, sbcs);
	}

	public List findBySbxh(Object sbxh) {
		return findByProperty(SBXH, sbxh);
	}

	public List findByGldz(Object gldz) {
		return findByProperty(GLDZ, gldz);
	}

	public List findByVlanh(Object vlanh) {
		return findByProperty(VLANH, vlanh);
	}

	public List findAll() {
		log.debug("finding all Sbxxb instances");
		try {
			String queryString = "from Sbxxb";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sbxxb merge(Sbxxb detachedInstance) {
		log.debug("merging Sbxxb instance");
		try {
			Sbxxb result = (Sbxxb) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sbxxb instance) {
		log.debug("attaching dirty Sbxxb instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sbxxb instance) {
		log.debug("attaching clean Sbxxb instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SbxxbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SbxxbDAO) ctx.getBean("SbxxbDAO");
	}
	
//	public List findWithPageSizeAndPageIndex(int PageSize, int PageIndex){
//		log.debug("findWithPageSizeAndPageIndex");
//		try {
//			String queryString = "from Sbxxb";
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
//			String queryString = "select count(*) from Sbxxb";
//			Query queryObject = getCurrentSession().createQuery(queryString);
//			return ((Long) queryObject.uniqueResult()).intValue();
//		} catch (RuntimeException re) {
//			log.error("findCount", re);
//			throw re;
//		} 
//	}
	
	public List findWithPageSizeAndPageIndexAndLikeAndEqual(int PageSize, int PageIndex,
	 Integer sbid,
	 String sbbm,
	 String sbmc,
	 Sbztb sbztb,
	 Sblxb sblxb,
	 Sbsylxb sbsylxb,
	 Integer syzt,
	 String gg,
	 String czxt,
	 String cpzl,
	 String cpu,
	 String nc,
	 String yp,
	 String rksj,
	 String cksj,
	 String sbcs,
	 String sbxh,
	 String gldz,
	 String vlanh,
	 Cqb cqb,
	 Khxxb khxxb,
	 Jfb jfb,
	 Jgb jgb,String sortField,String sortOrder){
	log.debug("findWithPageSizeAndPageIndexAndLikeAndEqual");
	try {
		String queryString = "from Sbxxb where 1=1";
		if((sbid != null) && !(sbid==0)){
       	 queryString = queryString+" and sbid = "+sbid+"";
        }
		if(sbbm != null && !"".equals(sbbm)){  
       	 queryString = queryString+" and sbbm like '%"+sbbm+"%'";
        }
		if(sbmc != null && !"".equals(sbmc)){  
	       	 queryString = queryString+" and sbmc like '%"+sbmc+"%'";
	        }
		if((sbztb!=null)&&(sbztb.getSbztid() != null) && !(sbztb.getSbztid()==0)){
	       	 queryString = queryString+" and sbztb.sbztid = "+sbztb.getSbztid()+"";
	        }
		if((sblxb != null)&&(sblxb.getSblxid() != null) && !(sblxb.getSblxid()==0)){
	       	 queryString = queryString+" and sblxb.sblxid = "+sblxb.getSblxid()+"";
	        }
		if((sbsylxb!=null)&&(sbsylxb.getSylxid() != null) && !(sbsylxb.getSylxid()==0)){
	       	 queryString = queryString+" and sbsylxb.sylxid = "+sbsylxb.getSylxid()+"";
	        }
		if((syzt != null) && !(syzt==0)){
	       	 queryString = queryString+" and syzt = "+syzt+"";
	        }
		if(gg != null && !"".equals(gg)){  
	       	 queryString = queryString+" and gg like '%"+gg+"%'";
	        }
		if(czxt != null && !"".equals(czxt)){  
	       	 queryString = queryString+" and czxt like '%"+czxt+"%'";
	        }
		if(cpzl != null && !"".equals(cpzl)){  
	       	 queryString = queryString+" and cpzl like '%"+cpzl+"%'";
	        }
		if(cpu != null && !"".equals(cpu)){  
	       	 queryString = queryString+" and cpu like '%"+cpu+"%'";
	        }
		if(nc != null && !"".equals(nc)){  
	       	 queryString = queryString+" and nc like '%"+nc+"%'";
	        }
		if(yp != null && !"".equals(yp)){  
	       	 queryString = queryString+" and yp like '%"+yp+"%'";
	        }
		
		
		//TimeStamp不知道怎么处理,先加上了
		if(rksj != null && !"".equals(rksj)){  
	       	 queryString = queryString+" and rksj like '%"+rksj+"%'";
	        }
		//TimeStamp不知道怎么处理,先加上了
		if(cksj != null && !"".equals(cksj)){  
	       	 queryString = queryString+" and cksj like '%"+cksj+"%'";
	        }
		
		
		if(sbcs != null && !"".equals(sbcs)){  
	       	 queryString = queryString+" and sbcs like '%"+sbcs+"%'";
	        }
		if(sbxh != null && !"".equals(sbxh)){  
	       	 queryString = queryString+" and sbxh like '%"+sbxh+"%'";
	        }
		if(gldz != null && !"".equals(gldz)){  
	       	 queryString = queryString+" and gldz like '%"+gldz+"%'";
	        }
		if(vlanh != null && !"".equals(vlanh)){  
	       	 queryString = queryString+" and vlanh like '%"+vlanh+"%'";
	        }
		if((cqb!=null)&&(cqb.getCqid() != null) && !(cqb.getCqid()==0)){
	       	 queryString = queryString+" and cqb.cqid = "+cqb.getCqid()+"";
	        }
		if((khxxb!=null)&&(khxxb.getKhid() != null) && !(khxxb.getKhid()==0)){
	       	 queryString = queryString+" and khxxb.khid = "+khxxb.getKhid()+"";
	        }
		if((jfb!=null)&&(jfb.getJfid() != null) && !(jfb.getJfid()==0)){
	       	 queryString = queryString+" and jfb.jfid = "+jfb.getJfid()+"";
	        }
		if((jgb!=null)&&(jgb.getJgid() != null) && !(jgb.getJgid()==0)){
	       	 queryString = queryString+" and jgb.jgid = "+jgb.getJgid()+"";
	        }
		if(sortField != null && !"".equals(sortField)){  //只需要判断一个，因为两个参数要么都有，要么都没有
       	 	queryString = queryString+" order by "+sortField+" "+sortOrder;  
        }
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult((PageIndex-1)*PageSize); 
		queryObject.setMaxResults(PageSize); 
		return queryObject.list();
	} catch (RuntimeException re) {
		log.error("findWithPageSizeAndPageIndex", re);
		throw re;
	}
}
	
	public int findCount(
			Integer sbid,
			 String sbbm,
			 String sbmc,
			 Sbztb sbztb,
			 Sblxb sblxb,
			 Sbsylxb sbsylxb,
			 Integer syzt,
			 String gg,
			 String czxt,
			 String cpzl,
			 String cpu,
			 String nc,
			 String yp,
			 String rksj,
			 String cksj,
			 String sbcs,
			 String sbxh,
			 String gldz,
			 String vlanh,
			 Cqb cqb,
			 Khxxb khxxb,
			 Jfb jfb,
			 Jgb jgb) {  
	log.debug("findCount");
	try {
		String queryString = "select count(*) from Sbxxb where 1=1";
		if((sbid != null) && !(sbid==0)){
	       	 queryString = queryString+" and sbid = "+sbid+"";
	        }
			if(sbbm != null && !"".equals(sbbm)){  
	       	 queryString = queryString+" and sbbm like '%"+sbbm+"%'";
	        }
			if(sbmc != null && !"".equals(sbmc)){  
		       	 queryString = queryString+" and sbmc like '%"+sbmc+"%'";
		        }
			if((sbztb!=null)&&(sbztb.getSbztid() != null) && !(sbztb.getSbztid()==0)){
		       	 queryString = queryString+" and sbztb.sbztid = "+sbztb.getSbztid()+"";
		        }
			if((sblxb != null)&&(sblxb.getSblxid() != null) && !(sblxb.getSblxid()==0)){
		       	 queryString = queryString+" and sblxb.sblxid = "+sblxb.getSblxid()+"";
		        }
			if((sbsylxb!=null)&&(sbsylxb.getSylxid() != null) && !(sbsylxb.getSylxid()==0)){
		       	 queryString = queryString+" and sbsylxb.sylxid = "+sbsylxb.getSylxid()+"";
		        }
			if((syzt != null) && !(syzt==0)){
		       	 queryString = queryString+" and syzt = "+syzt+"";
		        }
			if(gg != null && !"".equals(gg)){  
		       	 queryString = queryString+" and gg like '%"+gg+"%'";
		        }
			if(czxt != null && !"".equals(czxt)){  
		       	 queryString = queryString+" and czxt like '%"+czxt+"%'";
		        }
			if(cpzl != null && !"".equals(cpzl)){  
		       	 queryString = queryString+" and cpzl like '%"+cpzl+"%'";
		        }
			if(cpu != null && !"".equals(cpu)){  
		       	 queryString = queryString+" and cpu like '%"+cpu+"%'";
		        }
			if(nc != null && !"".equals(nc)){  
		       	 queryString = queryString+" and nc like '%"+nc+"%'";
		        }
			if(yp != null && !"".equals(yp)){  
		       	 queryString = queryString+" and yp like '%"+yp+"%'";
		        }
			
			
			//TimeStamp不知道怎么处理,先加上了
			if(rksj != null && !"".equals(rksj)){  
		       	 queryString = queryString+" and rksj like '%"+rksj+"%'";
		        }
			//TimeStamp不知道怎么处理,先加上了
			if(cksj != null && !"".equals(cksj)){  
		       	 queryString = queryString+" and cksj like '%"+cksj+"%'";
		        }
			
			
			if(sbcs != null && !"".equals(sbcs)){  
		       	 queryString = queryString+" and sbcs like '%"+sbcs+"%'";
		        }
			if(sbxh != null && !"".equals(sbxh)){  
		       	 queryString = queryString+" and sbxh like '%"+sbxh+"%'";
		        }
			if(gldz != null && !"".equals(gldz)){  
		       	 queryString = queryString+" and gldz like '%"+gldz+"%'";
		        }
			if(vlanh != null && !"".equals(vlanh)){  
		       	 queryString = queryString+" and vlanh like '%"+vlanh+"%'";
		        }
			if((cqb!=null)&&(cqb.getCqid() != null) && !(cqb.getCqid()==0)){
		       	 queryString = queryString+" and cqb.cqid = "+cqb.getCqid()+"";
		        }
			if((khxxb!=null)&&(khxxb.getKhid() != null) && !(khxxb.getKhid()==0)){
		       	 queryString = queryString+" and khxxb.khid = "+khxxb.getKhid()+"";
		        }
			if((jfb!=null)&&(jfb.getJfid() != null) && !(jfb.getJfid()==0)){
		       	 queryString = queryString+" and jfb.jfid = "+jfb.getJfid()+"";
		        }
			if((jgb!=null)&&(jgb.getJgid() != null) && !(jgb.getJgid()==0)){
		       	 queryString = queryString+" and jgb.jgid = "+jgb.getJgid()+"";
		        }
		Query queryObject = getCurrentSession().createQuery(queryString);
		return ((Long) queryObject.uniqueResult()).intValue();
	} catch (RuntimeException re) {
		log.error("findCount", re);
		throw re;
	} 
}
	
	
}