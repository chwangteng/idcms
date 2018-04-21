package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Jfb;
import com.wt.po.JfbDAO;
import com.wt.po.Jgb;
import com.wt.po.JgbDAO;

public class JGBAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	JgbDAO jgbdao=JgbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Jgb> resultlist;
	
	private Integer jgid;
	private Jfb jfb;
	private String jgbh;
	
	
	private String jgwz;
	
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

	public ArrayList<Jgb> getResultlist() {
		return resultlist;
	}

	public void setResultlist(ArrayList<Jgb> resultlist) {
		this.resultlist = resultlist;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Jfb getJfb() {
		return jfb;
	}

	public void setJfb(Jfb jfb) {
		this.jfb = jfb;
	}

	public String getJgbh() {
		return jgbh;
	}

	public void setJgbh(String jgbh) {
		this.jgbh = jgbh;
	}

	public String getJgwz() {
		return jgwz;
	}

	public void setJgwz(String jgwz) {
		this.jgwz = jgwz;
	}

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

	public Integer getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(Integer itemsCount) {
		this.itemsCount = itemsCount;
	}
	
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexJgb(){
		resultlist=(ArrayList<Jgb>)jgbdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,
				jgid,
				jgbh,
				jgwz,
				jfb,sortField,sortOrder);
		setItemsCount(jgbdao.findCount(
				jgid,
				jgbh,
				jgwz,
				jfb));
		return "success";
	}
	
	public String addJgb(){
		Jgb insertItem=new Jgb(jfb, jgbh, jgwz);
		jgbdao.save(insertItem);
		return "success";
	}

	public String updateJgb(){
		Jgb updateItem=new Jgb(jfb,jgbh,jgwz);
		updateItem.setJgid(jgid);
		jgbdao.merge(updateItem);
		return "success";
	}

	public String deleteJgb(){
		Jgb deleteItem=new Jgb();
		deleteItem.setJgid(jgid);
		jgbdao.delete(deleteItem);
		return "success";
	}
}
