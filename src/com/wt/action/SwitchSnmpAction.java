package com.wt.action;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Jfb;
import com.wt.po.JfbDAO;
import com.wt.po.TblSwitchsnmp;
import com.wt.po.TblSwitchsnmpDAO;

public class SwitchSnmpAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	TblSwitchsnmpDAO switchsnmpdao=TblSwitchsnmpDAO.getFromApplicationContext(ctx);
	
	ArrayList<TblSwitchsnmp> resultlist;
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	// Fields

	private String id;
	private String deviceid;
	private String devicename;
	private String ipaddr;
	private String ifoid;
	private String flowoid;
	private String community;
	private String flowoutoid;
	
	
	public ArrayList<TblSwitchsnmp> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<TblSwitchsnmp> resultlist) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public String getIfoid() {
		return ifoid;
	}
	public void setIfoid(String ifoid) {
		this.ifoid = ifoid;
	}
	public String getFlowoid() {
		return flowoid;
	}
	public void setFlowoid(String flowoid) {
		this.flowoid = flowoid;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getFlowoutoid() {
		return flowoutoid;
	}
	public void setFlowoutoid(String flowoutoid) {
		this.flowoutoid = flowoutoid;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexSwitchSnmp(){
		resultlist=(ArrayList<TblSwitchsnmp>)switchsnmpdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,  id, deviceid, devicename, ipaddr, ifoid, flowoid, community, flowoutoid,sortField,sortOrder);
		setItemsCount(switchsnmpdao.findCount(id, deviceid, devicename, ipaddr, ifoid, flowoid, community, flowoutoid));
		return "success";
	}
	
	public String addSwitchSnmp(){
		TblSwitchsnmp insertItem=new TblSwitchsnmp(id, deviceid, devicename, ipaddr, ifoid, flowoid, community, flowoutoid);
		switchsnmpdao.save(insertItem);
		return "success";
	}

	public String updateSwitchSnmp(){
		TblSwitchsnmp updateItem=new TblSwitchsnmp(id, deviceid, devicename, ipaddr, ifoid, flowoid, community, flowoutoid);
		switchsnmpdao.merge(updateItem);
		return "success";
	}

	public String deleteSwitchSnmp(){
		TblSwitchsnmp deleteItem=new TblSwitchsnmp();
		deleteItem.setId(id);
		switchsnmpdao.delete(deleteItem);
		return "success";
	}
}
