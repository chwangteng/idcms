package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Cqb;
import com.wt.po.CqbDAO;
import com.wt.po.Sbsylxb;
import com.wt.po.SbsylxbDAO;

public class SBSYLXBAction {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SbsylxbDAO sbsylxbdao=SbsylxbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Sbsylxb> resultlist;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	private Integer sylxid;
	private String sylx;
	public ArrayList<Sbsylxb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Sbsylxb> resultlist) {
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
	public Integer getSylxid() {
		return sylxid;
	}
	public void setSylxid(Integer sylxid) {
		this.sylxid = sylxid;
	}
	public String getSylx() {
		return sylx;
	}
	public void setSylx(String sylx) {
		this.sylx = sylx;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexSbsylxb(){
		resultlist=(ArrayList<Sbsylxb>)sbsylxbdao.findWithPageSizeAndPageIndex(pageSize,pageIndex);
		setItemsCount(sbsylxbdao.findCount());
		return "success";
	}
	
	public String addSbsylxb(){
		Sbsylxb insertItem=new Sbsylxb(sylx);
		sbsylxbdao.save(insertItem);
		return "success";
	}

	public String updateSbsylxb(){
		Sbsylxb updateItem=new Sbsylxb(sylx);
		updateItem.setSylxid(sylxid);
		sbsylxbdao.merge(updateItem);
		return "success";
	}

	public String deleteSbsylxb(){
		Sbsylxb deleteItem=new Sbsylxb();
		deleteItem.setSylxid(sylxid);
		sbsylxbdao.delete(deleteItem);
		return "success";
	}
}
