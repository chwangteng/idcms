package com.wt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.util.Base64Decoder;
import com.wt.po.Khxxb;
import com.wt.po.KhxxbDAO;
import com.wt.po.Sblxb;
import com.wt.po.SblxbDAO;
import com.wt.po.Sbsylxb;

public class KHXXBAction {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	KhxxbDAO khxxbdao=KhxxbDAO.getFromApplicationContext(ctx);
	
	ArrayList<Khxxb> resultlist;
	
	//用于分页
	private Integer pageIndex;
	private Integer pageSize;
	
	private Integer itemsCount;
	
	//用于分页排序
	private String sortField;     // the name of sorting field
	private String sortOrder;     // the order of sorting as string "asc"|"desc"
	
	// Fields

	private Integer khid;
	private String khm;
	private String khdz;
	private String tyxydm;
	private String yyzz;
	private String lxr;
	private String lxrdh;
	private String lxryx;
	
	
	
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
	public ArrayList<Khxxb> getResultlist() {
		return resultlist;
	}
	public void setResultlist(ArrayList<Khxxb> resultlist) {
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
	public Integer getKhid() {
		return khid;
	}
	public void setKhid(Integer khid) {
		this.khid = khid;
	}
	public String getKhm() {
		return khm;
	}
	public void setKhm(String khm) {
		this.khm = khm;
	}
	public String getKhdz() {
		return khdz;
	}
	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}
	public String getTyxydm() {
		return tyxydm;
	}
	public void setTyxydm(String tyxydm) {
		this.tyxydm = tyxydm;
	}
	public String getYyzz() {
		return yyzz;
	}
	public void setYyzz(String yyzz) {
		this.yyzz = yyzz;
	}
	public String getLxr() {
		return lxr;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public String getLxrdh() {
		return lxrdh;
	}
	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}
	public String getLxryx() {
		return lxryx;
	}
	public void setLxryx(String lxryx) {
		this.lxryx = lxryx;
	}
	
	@SuppressWarnings("unchecked")
	public String showWithPageSizeAndPageIndexKhxxb(){
		resultlist=(ArrayList<Khxxb>)khxxbdao.findWithPageSizeAndPageIndexAndLikeAndEqual(pageSize,pageIndex,
				 khid,khm,khdz,tyxydm,yyzz,lxr,lxrdh,lxryx,sortField,sortOrder);
		setItemsCount(khxxbdao.findCount(
				khid,khm,khdz,tyxydm,yyzz,lxr,lxrdh,lxryx));
		return "success";
	}
	
	public String addKhxxb() throws IOException{
		//先保存到数据库，这样才能获得自增的id以创建文件
		Khxxb insertItem=new Khxxb(khm, khdz, tyxydm, null, lxr, lxrdh, lxryx);
		khxxbdao.save(insertItem);
		//将文件写入路径，以id命名，当然不安全
		byte[] imagecontent=null;
		if((yyzz != null)&&!"".equals(yyzz)){
			if(yyzz.contains("base64")){
				yyzz=yyzz.substring(yyzz.indexOf(",")+1);
				imagecontent=Base64.getDecoder().decode(yyzz);
				String root = ServletActionContext.getServletContext().getRealPath(
						"/");
				root+="ampleadmin/images/yyzz/"+ insertItem.getKhid()+".jpg";
				//写入，写入的路径与保存的路径略有不同
				Files.write(Paths.get(root), imagecontent, StandardOpenOption.CREATE);
				//保存到数据的路径
				insertItem.setYyzz("images/yyzz/"+ insertItem.getKhid()+".jpg");
				khxxbdao.merge(insertItem);
			}
		}
		return "success";
	}

	public String updateKhxxb() throws IOException{
		Khxxb oldItem=khxxbdao.findById(khid);
		if((yyzz != null)&&!"".equals(yyzz)){
			if(yyzz.contains("base64")){//上传了新的图片，需要重新写入，并记录数据库防止之前是空的
				String root = ServletActionContext.getServletContext().getRealPath(
						"/");
				root+="ampleadmin/images/yyzz/"+ khid+".jpg";
				File yyzzImg=new File(root);
				if(yyzzImg.exists())
					yyzzImg.delete(); //如果原来存在，删除图片
				yyzz=yyzz.substring(yyzz.indexOf(",")+1);
				byte[] imagecontent=null;
				imagecontent=Base64.getDecoder().decode(yyzz);
				//写入
				Files.write(Paths.get(root), imagecontent, StandardOpenOption.CREATE);
				Khxxb updateItem=new Khxxb(khm, khdz, tyxydm, "images/yyzz/"+ oldItem.getKhid()+".jpg", lxr, lxrdh, lxryx);
				updateItem.setKhid(khid);
				khxxbdao.merge(updateItem);
			}
		}else{//没有上传新的图片，但是上传了其他数据，
				Khxxb updateItem=new Khxxb(khm, khdz, tyxydm, oldItem.getYyzz(), lxr, lxrdh, lxryx);
				updateItem.setKhid(khid);
				khxxbdao.merge(updateItem);
		}
		return "success";
	}

	public String deleteKhxxb(){
		
		String root = ServletActionContext.getServletContext().getRealPath(
				"/");
		root+="ampleadmin/images/yyzz/"+ khid+".jpg";
		File yyzzImg=new File(root);
		if(yyzzImg.exists())
			yyzzImg.delete(); //删除图片
		
		Khxxb deleteItem=new Khxxb();
		deleteItem.setKhid(khid);
		khxxbdao.delete(deleteItem);
		return "success";
	}
	
}
