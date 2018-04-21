package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Jfb;
import com.wt.po.Jgb;
import com.wt.po.JgbDAO;
import com.wt.po.Sblxb;
import com.wt.po.SblxbDAO;

public class SBLXBAction {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SblxbDAO sblxbdao=SblxbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Sblxb> resultlist;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	
	private Integer sblxid;
	private String sblx;
	public ArrayList<Sblxb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Sblxb> resultlist) {
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
	public Integer getSblxid() {
		return sblxid;
	}
	public void setSblxid(Integer sblxid) {
		this.sblxid = sblxid;
	}
	public String getSblx() {
		return sblx;
	}
	public void setSblx(String sblx) {
		this.sblx = sblx;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexSblxb(){
		resultlist=(ArrayList<Sblxb>)sblxbdao.findWithPageSizeAndPageIndex(pageSize,pageIndex);
		setItemsCount(sblxbdao.findCount());
		return "success";
	}
	
	public String addSblxb(){
		Sblxb insertItem=new Sblxb(sblx);
		sblxbdao.save(insertItem);
		return "success";
	}

	public String updateSblxb(){
		Sblxb updateItem=new Sblxb(sblx);
		updateItem.setSblxid(sblxid);
		sblxbdao.merge(updateItem);
		return "success";
	}

	public String deleteSblxb(){
		Sblxb deleteItem=new Sblxb();
		deleteItem.setSblxid(sblxid);
		sblxbdao.delete(deleteItem);
		return "success";
	}
	
}
