package com.wt.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.wt.po.AbstractJfb;
import com.wt.po.Jfb;
import com.wt.po.JfbDAO;

public class JFBAction {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	JfbDAO jfbdao=JfbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Jfb> resultlist;
	

	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	
	public String getSortField() {
		return sortField;
	}


	public void setSortField(String sortField) {
		this.sortField = sortField;
	}


	public String getSortOrder() {
		return sortOrder;
	}


	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	//Fields
	private String jfmc;
	private String jfdz;
	private Integer jfid;
	
	
	public Integer getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public String getJfmc() {
		return jfmc;
	}


	public void setJfmc(String jfmc) {
		this.jfmc = jfmc;
	}


	public String getJfdz() {
		return jfdz;
	}


	public void setJfdz(String jfdz) {
		this.jfdz = jfdz;
	}


	public ArrayList<Jfb> getResultlist() {
		return resultlist;
	}


	public void setResultlist(ArrayList<Jfb> resultlist) {
		this.resultlist = resultlist;
	}

	
	public Integer getItemsCount() {
		return itemsCount;
	}


	public void setItemsCount(Integer itemsCount) {
		this.itemsCount = itemsCount;
	}


	public Integer getJfid() {
		return jfid;
	}


	public void setJfid(Integer jfid) {
		this.jfid = jfid;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexJfb(){
		resultlist=(ArrayList<Jfb>)jfbdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,jfid,jfmc,jfdz,sortField,sortOrder);
		//resultlist=(ArrayList<Jfb>)jfbdao.findWithPageSizeAndPageIndex(pageSize,pageIndex);
		setItemsCount(jfbdao.findCount(jfid,jfmc,jfdz));
		return "success";
	}
	
	public String addJfb(){
		Jfb insertItem=new Jfb(jfmc,jfdz);
		jfbdao.save(insertItem);
//		int i;
//		for(i=1;i<30;i++)
//		{
//			int hao=i+116;
//			String sjfmc=""+hao+"号机房";
//			int address=100+i;
//			String sjfdz="B座"+address;
//			Jfb insertItem=new Jfb(sjfmc,sjfdz);
//			jfbdao.save(insertItem);
//		}
		return "success";
	}

	public String updateJfb(){
		Jfb updateItem=new Jfb(jfid,jfmc,jfdz);
		jfbdao.merge(updateItem);
		return "success";
	}

	public String deleteJfb(){
		Jfb deleteItem=new Jfb();
		deleteItem.setJfid(jfid);
		jfbdao.delete(deleteItem);
		return "success";
	}
}
