package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractKhxxb entity provides the base persistence definition of the Khxxb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKhxxb implements java.io.Serializable {

	// Fields

	private Integer khid;
	private String khm;
	private String khdz;
	private String tyxydm;
	private String yyzz;
	private String lxr;
	private String lxrdh;
	private String lxryx;
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractKhxxb() {
	}

	/** minimal constructor */
	public AbstractKhxxb(String khm) {
		this.khm = khm;
	}

	public AbstractKhxxb(String khm, String khdz, String tyxydm, String yyzz, String lxr, String lxrdh, String lxryx) {
		this.khm = khm;
		this.khdz = khdz;
		this.tyxydm = tyxydm;
		this.yyzz = yyzz;
		this.lxr = lxr;
		this.lxrdh = lxrdh;
		this.lxryx = lxryx;
	}
	
	
	/** full constructor */
	public AbstractKhxxb(String khm, String khdz, String tyxydm, String yyzz, String lxr, String lxrdh, String lxryx,
			Set sbxxbs) {
		this.khm = khm;
		this.khdz = khdz;
		this.tyxydm = tyxydm;
		this.yyzz = yyzz;
		this.lxr = lxr;
		this.lxrdh = lxrdh;
		this.lxryx = lxryx;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getKhid() {
		return this.khid;
	}

	public void setKhid(Integer khid) {
		this.khid = khid;
	}

	public String getKhm() {
		return this.khm;
	}

	public void setKhm(String khm) {
		this.khm = khm;
	}

	public String getKhdz() {
		return this.khdz;
	}

	public void setKhdz(String khdz) {
		this.khdz = khdz;
	}

	public String getTyxydm() {
		return this.tyxydm;
	}

	public void setTyxydm(String tyxydm) {
		this.tyxydm = tyxydm;
	}

	public String getYyzz() {
		return this.yyzz;
	}

	public void setYyzz(String yyzz) {
		this.yyzz = yyzz;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxrdh() {
		return this.lxrdh;
	}

	public void setLxrdh(String lxrdh) {
		this.lxrdh = lxrdh;
	}

	public String getLxryx() {
		return this.lxryx;
	}

	public void setLxryx(String lxryx) {
		this.lxryx = lxryx;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}