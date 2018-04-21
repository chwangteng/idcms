package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Sbztb;
import com.wt.po.SbztbDAO;

public class SBZTBAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SbztbDAO sbztbdao=SbztbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Sbztb> resultlist;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	
	private Integer sbztid;
	private String sbzt;
	public ArrayList<Sbztb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Sbztb> resultlist) {
		this.resultlist = resultlist;
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
	public Integer getSbztid() {
		return sbztid;
	}
	public void setSbztid(Integer sbztid) {
		this.sbztid = sbztid;
	}
	public String getSbzt() {
		return sbzt;
	}
	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexSbztb(){
		resultlist=(ArrayList<Sbztb>)sbztbdao.findWithPageSizeAndPageIndex(pageSize,pageIndex);
		setItemsCount(sbztbdao.findCount());
		return "success";
	}
	
	public String addSbztb(){
		Sbztb insertItem=new Sbztb(sbzt);
		sbztbdao.save(insertItem);
		return "success";
	}

	public String updateSbztb(){
		Sbztb updateItem=new Sbztb(sbzt);
		updateItem.setSbztid(sbztid);
		sbztbdao.merge(updateItem);
		return "success";
	}

	public String deleteSbztb(){
		Sbztb deleteItem=new Sbztb();
		deleteItem.setSbztid(sbztid);
		sbztbdao.delete(deleteItem);
		return "success";
	}
}
