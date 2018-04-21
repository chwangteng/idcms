package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Jhjdkzyb;
import com.wt.po.JhjdkzybDAO;
import com.wt.po.Khxxb;
import com.wt.po.Sbxxb;
import com.wt.po.SbxxbDAO;

public class JHJDKZYBAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	JhjdkzybDAO jhjdkzybdao=JhjdkzybDAO.getFromApplicationContext(ctx);
	
	ArrayList<Jhjdkzyb> resultlist;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	// Fields

	private Integer dkid;
	private Sbxxb sbxxb;
	private Integer dkh;
	private String dkxx;
	private String dkjcrj;
	
	
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
	public ArrayList<Jhjdkzyb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Jhjdkzyb> resultlist) {
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
	public Integer getDkid() {
		return dkid;
	}
	public void setDkid(Integer dkid) {
		this.dkid = dkid;
	}
	public Sbxxb getSbxxb() {
		return sbxxb;
	}
	public void setSbxxb(Sbxxb sbxxb) {
		this.sbxxb = sbxxb;
	}
	public Integer getDkh() {
		return dkh;
	}
	public void setDkh(Integer dkh) {
		this.dkh = dkh;
	}
	public String getDkxx() {
		return dkxx;
	}
	public void setDkxx(String dkxx) {
		this.dkxx = dkxx;
	}
	public String getDkjcrj() {
		return dkjcrj;
	}
	public void setDkjcrj(String dkjcrj) {
		this.dkjcrj = dkjcrj;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexJhjdkzyb(){
		resultlist=(ArrayList<Jhjdkzyb>)jhjdkzybdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,
				 dkid,
				  sbxxb,
				  dkh,
				  dkxx,
				  dkjcrj,sortField,sortOrder);
		setItemsCount(jhjdkzybdao.findCount(
				dkid,
				  sbxxb,
				  dkh,
				  dkxx,
				  dkjcrj));
		return "success";
	}
	
	public String addJhjdkzyb(){
		Jhjdkzyb insertItem=new Jhjdkzyb(sbxxb, dkh, dkxx, dkjcrj);
		jhjdkzybdao.save(insertItem);
		return "success";
	}

	public String updateJhjdkzyb(){
		Jhjdkzyb updateItem=new Jhjdkzyb(sbxxb, dkh, dkxx, dkjcrj);
		updateItem.setDkid(dkid);
		jhjdkzybdao.merge(updateItem);
		return "success";
	}

	public String deleteJhjdkzyb(){
		Jhjdkzyb deleteItem=new Jhjdkzyb();
		deleteItem.setDkid(dkid);
		jhjdkzybdao.delete(deleteItem);
		return "success";
	}
}
