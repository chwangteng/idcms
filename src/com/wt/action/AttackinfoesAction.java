package com.wt.action;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Attackinfoes;
import com.wt.po.AttackinfoesDAO;
import com.wt.po.Jfb;
import com.wt.po.Khxxb;
import com.wt.po.KhxxbDAO;

public class AttackinfoesAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	AttackinfoesDAO attackinfoesdao=AttackinfoesDAO.getFromApplicationContext(ctx);
	
	ArrayList<Attackinfoes> resultlist;
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	// Fields

	private String id;
	private String status;
	private String count;
	private String deftype;
	private String SIp;
	//private Timestamp startTime;
	private String startTime;
	private String dropCount;
	private String SPortList;
	private String CPortList;
	private String CIpList;
	private String packetType;
	//private Timestamp endTime;
	private String endTime;
	private String duration;
	private String dropSize;
	private String size;
	public ArrayList<Attackinfoes> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Attackinfoes> resultlist) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getDeftype() {
		return deftype;
	}
	public void setDeftype(String deftype) {
		this.deftype = deftype;
	}
	public String getSIp() {
		return SIp;
	}
	public void setSIp(String sIp) {
		SIp = sIp;
	}
//	public Timestamp getStartTime() {
//		return startTime;
//	}
//	public void setStartTime(Timestamp startTime) {
//		this.startTime = startTime;
//	}
	public String getDropCount() {
		return dropCount;
	}
	public void setDropCount(String dropCount) {
		this.dropCount = dropCount;
	}
	public String getSPortList() {
		return SPortList;
	}
	public void setSPortList(String sPortList) {
		SPortList = sPortList;
	}
	public String getCPortList() {
		return CPortList;
	}
	public void setCPortList(String cPortList) {
		CPortList = cPortList;
	}
	public String getCIpList() {
		return CIpList;
	}
	public void setCIpList(String cIpList) {
		CIpList = cIpList;
	}
	public String getPacketType() {
		return packetType;
	}
	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}
//	public Timestamp getEndTime() {
//		return endTime;
//	}
//	public void setEndTime(Timestamp endTime) {
//		this.endTime = endTime;
//	}
	
	
	public String getDuration() {
		return duration;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getDropSize() {
		return dropSize;
	}
	public void setDropSize(String dropSize) {
		this.dropSize = dropSize;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexAttackinfoes(){
		resultlist=(ArrayList<Attackinfoes>)attackinfoesdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,id, status, count, deftype, SIp, startTime,
				  dropCount, SPortList, CPortList, CIpList, packetType,
				  endTime, duration, dropSize, size,sortField,sortOrder);
		setItemsCount(attackinfoesdao.findCount( id, status, count, deftype, SIp, startTime,
				  dropCount, SPortList, CPortList, CIpList, packetType,
				  endTime, duration, dropSize, size));
		return "success";
	}
	
}
