package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Cqb;
import com.wt.po.CqbDAO;

public class CQBAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	CqbDAO cqbdao=CqbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Cqb> resultlist;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	private Integer cqid;
	private String cqxx;
	
	public Integer getCqid() {
		return cqid;
	}
	public void setCqid(Integer cqid) {
		this.cqid = cqid;
	}
	public String getCqxx() {
		return cqxx;
	}
	public void setCqxx(String cqxx) {
		this.cqxx = cqxx;
	}
	public ArrayList<Cqb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Cqb> resultlist) {
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

	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexCqb(){
		resultlist=(ArrayList<Cqb>)cqbdao.findWithPageSizeAndPageIndex(pageSize,pageIndex);
		setItemsCount(cqbdao.findCount());
		return "success";
	}
	
	public String addCqb(){
		Cqb insertItem=new Cqb(cqxx);
		cqbdao.save(insertItem);
		return "success";
	}

	public String updateCqb(){
		Cqb updateItem=new Cqb(cqxx);
		updateItem.setCqid(cqid);
		cqbdao.merge(updateItem);
		return "success";
	}

	public String deleteCqb(){
		Cqb deleteItem=new Cqb();
		deleteItem.setCqid(cqid);
		cqbdao.delete(deleteItem);
		return "success";
	}
}
