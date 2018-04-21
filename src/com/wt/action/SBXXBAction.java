package com.wt.action;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wt.po.Cqb;
import com.wt.po.CqbDAO;
import com.wt.po.Jfb;
import com.wt.po.Jgb;
import com.wt.po.Khxxb;
import com.wt.po.Sblxb;
import com.wt.po.Sbsylxb;
import com.wt.po.Sbxxb;
import com.wt.po.SbxxbDAO;
import com.wt.po.Sbztb;

public class SBXXBAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	SbxxbDAO sbxxbdao=SbxxbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Sbxxb> resultlist;
	
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	// Fields



	private Integer sbid;
	private Sblxb sblxb;
	private Sbztb sbztb;
	private Khxxb khxxb;
	private Sbsylxb sbsylxb;
	private Cqb cqb;
	private Jgb jgb;
	private Jfb jfb;
	private String sbbm;
	private String sbmc;
	private Integer syzt;
	private String gg;
	private String czxt;
	private String cpzl;
	private String cpu;
	private String nc;
	private String yp;
//	private Timestamp rksj;
	private String rksj;
//	private Timestamp cksj;
	private String cksj;
	private String sbcs;
	private String sbxh;
	private String gldz;
	private String vlanh;
	public ArrayList<Sbxxb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Sbxxb> resultlist) {
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
	
	public Integer getSbid() {
		return sbid;
	}
	public void setSbid(Integer sbid) {
		this.sbid = sbid;
	}
	public Sblxb getSblxb() {
		return sblxb;
	}
	public void setSblxb(Sblxb sblxb) {
		this.sblxb = sblxb;
	}
	public Sbztb getSbztb() {
		return sbztb;
	}
	public void setSbztb(Sbztb sbztb) {
		this.sbztb = sbztb;
	}
	public Khxxb getKhxxb() {
		return khxxb;
	}
	public void setKhxxb(Khxxb khxxb) {
		this.khxxb = khxxb;
	}
	public Sbsylxb getSbsylxb() {
		return sbsylxb;
	}
	public void setSbsylxb(Sbsylxb sbsylxb) {
		this.sbsylxb = sbsylxb;
	}
	public Cqb getCqb() {
		return cqb;
	}
	public void setCqb(Cqb cqb) {
		this.cqb = cqb;
	}
	public Jgb getJgb() {
		return jgb;
	}
	public void setJgb(Jgb jgb) {
		this.jgb = jgb;
	}
	public Jfb getJfb() {
		return jfb;
	}
	public void setJfb(Jfb jfb) {
		this.jfb = jfb;
	}
	public String getSbbm() {
		return sbbm;
	}
	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}
	public String getSbmc() {
		return sbmc;
	}
	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	public Integer getSyzt() {
		return syzt;
	}
	public void setSyzt(Integer syzt) {
		this.syzt = syzt;
	}
	public String getGg() {
		return gg;
	}
	public void setGg(String gg) {
		this.gg = gg;
	}
	public String getCzxt() {
		return czxt;
	}
	public void setCzxt(String czxt) {
		this.czxt = czxt;
	}
	public String getCpzl() {
		return cpzl;
	}
	public void setCpzl(String cpzl) {
		this.cpzl = cpzl;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getNc() {
		return nc;
	}
	public void setNc(String nc) {
		this.nc = nc;
	}
	public String getYp() {
		return yp;
	}
	public void setYp(String yp) {
		this.yp = yp;
	}
//	public Timestamp getRksj() {
//		return rksj;
//	}
//	public void setRksj(Timestamp rksj) {
//		this.rksj = rksj;
//	}
	
	public String getRksj() {
		return rksj;
	}
	
	public void setRksj(String rksj) {
		this.rksj = rksj;
	}
//	public Timestamp getCksj() {
//		return cksj;
//	}
//	
//	public void setCksj(Timestamp cksj) {
//		this.cksj = cksj;
//	}
	
	public String getCksj() {
		return cksj;
	}
	public void setCksj(String cksj) {
		this.cksj = cksj;
	}
	
	
	public String getSbcs() {
		return sbcs;
	}

	public void setSbcs(String sbcs) {
		this.sbcs = sbcs;
	}
	public String getSbxh() {
		return sbxh;
	}
	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}
	public String getGldz() {
		return gldz;
	}
	public void setGldz(String gldz) {
		this.gldz = gldz;
	}
	public String getVlanh() {
		return vlanh;
	}
	public void setVlanh(String vlanh) {
		this.vlanh = vlanh;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexSbxxb(){
		//这里不需要判断出入库时间也不需要转换，因为是模糊查询，没有必要
		resultlist=(ArrayList<Sbxxb>)sbxxbdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,
				 sbid,sbbm,sbmc,
				  sbztb,sblxb,sbsylxb,syzt,
				  gg,czxt,cpzl,cpu,nc,yp,rksj,cksj,sbcs,sbxh,gldz,vlanh,
				  cqb,khxxb,jfb,jgb,sortField,sortOrder);
		setItemsCount(sbxxbdao.findCount(
				sbid,sbbm,sbmc,
				  sbztb,sblxb,sbsylxb,syzt,
				  gg,czxt,cpzl,cpu,nc,yp,rksj,cksj,sbcs,sbxh,gldz,vlanh,
				  cqb,khxxb,jfb,jgb));
		return "success";
	}
	
	public String addSbxxb(){
//		for(int i=0;i<10;i++)
//			addMockData();
//		return "success";
		
		Timestamp t_rksj=null;
		if((rksj!=null)&&(!"".equals(rksj)))
			t_rksj=Timestamp.valueOf(rksj);
		Timestamp t_cksj=null;
		if((cksj!=null)&&(!"".equals(cksj)))
			t_cksj=Timestamp.valueOf(cksj);
		Sbxxb insertItem=new Sbxxb(sblxb, sbztb, khxxb, sbsylxb, cqb, jgb, jfb, sbbm,
				sbmc, syzt, gg, czxt, cpzl, cpu, nc, yp,
				t_rksj, t_cksj, sbcs, sbxh, gldz,vlanh);
		sbxxbdao.save(insertItem);
		return "success";
	}
	
	//添加模拟数据
	public void addMockData(){
		String [] ggs={"1U","2U","4U"};
		String [] czxts={"CentOS 7.4 64bit","FreeBSD 10.1 64bit","Ubuntu Server 16.04.1 LTS 32bit","Ubuntu Server 16.04.1 LTS 64bit","Windows Server 2012 R2"};
		String [] cpzls={"DELL PowerVault MD1200","HUAWEI OceanStor S2200T","HP MSA 2040 SAN DC SFF Storage(K2R80A)"};
		String [] cpus={"Intel Xeon E5-2680 v2","Intel Xeon E5-2620 v4","Intel Xeon E5620","Intel Xeon Platinum 8168","Intel Xeon E5-2699 v4",
				"2*Intel Xeon E5-2680 v2","2*Intel Xeon E5-2620 v4","4*Intel Xeon E5620","4*Intel Xeon Platinum 8168","8*Intel Xeon E5-2699 v4","8*Intel Xeon Platinum 8168"};
		String [] ncs={"SAMSUNG 8GB","KINGSTON 16GB","KINGSTON 32GB","SAMSUNG 64GB","KINGSTON 128GB","SAMSUNG 256GB","KINGSTON 512GB","KINGSTON 1024GB"};
		String [] yps={"8TB RAID5","8TB RAID6","16TB RAID6","16TB RAID5","32TB RAID6","32TB RAID5","64TB RAID6","64TB RAID5","128TB RAID6","128TB RAID5","256TB RAID6","256TB RAID5","512TB RAID6","512TB RAID5"};
		
		Sblxb sblxb=new Sblxb();
		sblxb.setSblxid(1001);
		Sbztb sbztb=new Sbztb();
		sbztb.setSbztid(1001);
		Khxxb khxxb=new Khxxb();
		
		int [] khxxbrestrain={1001,1002,1003,1020,1021,1022,1023};
		int khxxbindex = (int) (Math.random() * khxxbrestrain.length);
		khxxb.setKhid(khxxbrestrain[khxxbindex]);
		Sbsylxb sbsylxb=new Sbsylxb();
		int [] sbsylxbrestrain={1001,1002,1003,1004,1005,1006,9001};
		int sbsylxbindex=(int) (Math.random() * sbsylxbrestrain.length);
		sbsylxb.setSylxid(sbsylxbrestrain[sbsylxbindex]);
		int [] cqbrestain={1001,1002,1003,1004};
		int cqbindex=(int) (Math.random() * cqbrestain.length);
		Cqb cqb=new Cqb();
		cqb.setCqid(cqbrestain[cqbindex]);
		Jgb jgb=new Jgb();
		jgb.setJgid(1001+(int) (Math.random() * 10));
		Jfb jfb=new Jfb();
		jfb.setJfid(1001);
		String sbbm=null;
		String sbmc="未命名设备";
		Integer syzt=1;
		String gg=ggs[(int) (Math.random() * ggs.length)];
		String czxt=czxts[(int) (Math.random() * czxts.length)];
		String cpzl=cpzls[(int) (Math.random() * cpzls.length)];
		String cpu=cpus[(int) (Math.random() * cpus.length)];
		String nc=ncs[(int) (Math.random() * ncs.length)];
		String yp=yps[(int) (Math.random() * yps.length)];
		Timestamp t_rksj=null,t_cksj=null;
		String sbcs=null,sbxh=null,gldz=null,vlanh=null;
		
		Sbxxb insertItem=new Sbxxb(sblxb, sbztb, khxxb, sbsylxb, cqb, jgb, jfb, sbbm,
		sbmc, syzt, gg, czxt, cpzl, cpu, nc, yp,
		t_rksj, t_cksj, sbcs, sbxh, gldz,vlanh);
		sbxxbdao.save(insertItem);
	}

	public String updateSbxxb(){
		Timestamp t_rksj=null;
		if((rksj!=null)&&(!"".equals(rksj)))
			t_rksj=Timestamp.valueOf(rksj);
		Timestamp t_cksj=null;
		if((cksj!=null)&&(!"".equals(cksj)))
			t_cksj=Timestamp.valueOf(cksj);
		Sbxxb updateItem=new Sbxxb(sblxb, sbztb, khxxb, sbsylxb, cqb, jgb, jfb, sbbm,
				sbmc, syzt, gg, czxt, cpzl, cpu, nc, yp,
				t_rksj, t_cksj, sbcs, sbxh, gldz,vlanh);
		updateItem.setSbid(sbid);
		sbxxbdao.merge(updateItem);
		return "success";
	}

	public String deleteSbxxb(){
		Sbxxb deleteItem=new Sbxxb();
		deleteItem.setSbid(sbid);
		sbxxbdao.delete(deleteItem);
		return "success";
	}
}
