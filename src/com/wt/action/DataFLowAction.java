package com.wt.action;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Attackinfoes;
import com.wt.po.Dataflow;
import com.wt.po.DataflowDAO;
import com.wt.po.TblSwitchsnmp;
import com.wt.po.TblSwitchsnmpDAO;

public class DataFLowAction {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	DataflowDAO dataflowdao=DataflowDAO.getFromApplicationContext(ctx);
	
	ArrayList<Dataflow> resultlist;
	
	//用于筛选时间
	private String starttime;
	private String endtime;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	
	// Fields

	private Integer id;
	private String jhj;
	private String jk;
	private String lrll;
	private String lcll;
	private String time;
	//private Timestamp time;
	
	
	public ArrayList<Dataflow> getResultlist() {
		return resultlist;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public void setResultlist(ArrayList<Dataflow> resultlist) {
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJhj() {
		return jhj;
	}
	public void setJhj(String jhj) {
		this.jhj = jhj;
	}
	public String getJk() {
		return jk;
	}
	public void setJk(String jk) {
		this.jk = jk;
	}
	public String getLrll() {
		return lrll;
	}
	public void setLrll(String lrll) {
		this.lrll = lrll;
	}
	public String getLcll() {
		return lcll;
	}
	public void setLcll(String lcll) {
		this.lcll = lcll;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexDataFLow(){
		resultlist=(ArrayList<Dataflow>)dataflowdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,		 
				 id, jhj, jk,  lrll, lcll, time,sortField,sortOrder,starttime,endtime);
		setItemsCount(dataflowdao.findCount( id, jhj, jk,  lrll, lcll, time,starttime,endtime));
		return "success";
	}
	public String addDataFLow(){
		Timestamp t_time=null;
		if((time!=null)&&(!"".equals(time)))
			t_time=Timestamp.valueOf(time);
		
		Dataflow insertItem=new Dataflow(null, jhj, jk,  lrll, lcll, t_time);
		dataflowdao.save(insertItem);
		return "success";
	}

	public String updateDataFLow(){
		Timestamp t_time=null;
		if((time!=null)&&(!"".equals(time)))
			t_time=Timestamp.valueOf(time);
		
		Dataflow updateItem=new Dataflow(id, jhj, jk,  lrll, lcll, t_time);
		updateItem.setId(id);
		dataflowdao.merge(updateItem);
		return "success";
	}

	public String deleteDataFLow(){

		Dataflow deleteItem=new Dataflow();
		deleteItem.setId(id);
		dataflowdao.delete(deleteItem);
		return "success";
	}
}
