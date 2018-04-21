package com.wt.po;

import java.sql.Timestamp;

/**
 * AbstractSbxxb entity provides the base persistence definition of the Sbxxb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSbxxb implements java.io.Serializable {

	// Fields

	private Integer sbid;
	private String sbbm;
	private String sbmc;
	private Sbztb sbztb;
	private Sblxb sblxb;
	private Sbsylxb sbsylxb;
	private Integer syzt;
	private String gg;
	private String czxt;
	private String cpzl;
	private String cpu;
	private String nc;
	private String yp;
	private Timestamp rksj;
	private Timestamp cksj;
	private String sbcs;
	private String sbxh;
	private String gldz;
	private String vlanh;
	private Cqb cqb;
	private Khxxb khxxb;
	private Jfb jfb;
	private Jgb jgb;
	
	
	// Constructors

	/** default constructor */
	public AbstractSbxxb() {
	}

	/** minimal constructor */
	public AbstractSbxxb(String sbmc) {
		this.sbmc = sbmc;
	}

	/** full constructor */
	public AbstractSbxxb(Sblxb sblxb, Sbztb sbztb, Khxxb khxxb, Sbsylxb sbsylxb, Cqb cqb, Jgb jgb, Jfb jfb, String sbbm,
			String sbmc, Integer syzt, String gg, String czxt, String cpzl, String cpu, String nc, String yp,
			Timestamp rksj, Timestamp cksj, String sbcs, String sbxh, String gldz, String vlanh) {
		this.sblxb = sblxb;
		this.sbztb = sbztb;
		this.khxxb = khxxb;
		this.sbsylxb = sbsylxb;
		this.cqb = cqb;
		this.jgb = jgb;
		this.jfb = jfb;
		this.sbbm = sbbm;
		this.sbmc = sbmc;
		this.syzt = syzt;
		this.gg = gg;
		this.czxt = czxt;
		this.cpzl = cpzl;
		this.cpu = cpu;
		this.nc = nc;
		this.yp = yp;
		this.rksj = rksj;
		this.cksj = cksj;
		this.sbcs = sbcs;
		this.sbxh = sbxh;
		this.gldz = gldz;
		this.vlanh = vlanh;
	}

	// Property accessors

	public Integer getSbid() {
		return this.sbid;
	}

	public void setSbid(Integer sbid) {
		this.sbid = sbid;
	}

	public Sblxb getSblxb() {
		return this.sblxb;
	}

	public void setSblxb(Sblxb sblxb) {
		this.sblxb = sblxb;
	}

	public Sbztb getSbztb() {
		return this.sbztb;
	}

	public void setSbztb(Sbztb sbztb) {
		this.sbztb = sbztb;
	}

	public Khxxb getKhxxb() {
		return this.khxxb;
	}

	public void setKhxxb(Khxxb khxxb) {
		this.khxxb = khxxb;
	}

	public Sbsylxb getSbsylxb() {
		return this.sbsylxb;
	}

	public void setSbsylxb(Sbsylxb sbsylxb) {
		this.sbsylxb = sbsylxb;
	}

	public Cqb getCqb() {
		return this.cqb;
	}

	public void setCqb(Cqb cqb) {
		this.cqb = cqb;
	}

	public Jgb getJgb() {
		return this.jgb;
	}

	public void setJgb(Jgb jgb) {
		this.jgb = jgb;
	}

	public Jfb getJfb() {
		return this.jfb;
	}

	public void setJfb(Jfb jfb) {
		this.jfb = jfb;
	}

	public String getSbbm() {
		return this.sbbm;
	}

	public void setSbbm(String sbbm) {
		this.sbbm = sbbm;
	}

	public String getSbmc() {
		return this.sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public Integer getSyzt() {
		return this.syzt;
	}

	public void setSyzt(Integer syzt) {
		this.syzt = syzt;
	}

	public String getGg() {
		return this.gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getCzxt() {
		return this.czxt;
	}

	public void setCzxt(String czxt) {
		this.czxt = czxt;
	}

	public String getCpzl() {
		return this.cpzl;
	}

	public void setCpzl(String cpzl) {
		this.cpzl = cpzl;
	}

	public String getCpu() {
		return this.cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getNc() {
		return this.nc;
	}

	public void setNc(String nc) {
		this.nc = nc;
	}

	public String getYp() {
		return this.yp;
	}

	public void setYp(String yp) {
		this.yp = yp;
	}

	public Timestamp getRksj() {
		return this.rksj;
	}

	public void setRksj(Timestamp rksj) {
		this.rksj = rksj;
	}

	public Timestamp getCksj() {
		return this.cksj;
	}

	public void setCksj(Timestamp cksj) {
		this.cksj = cksj;
	}

	public String getSbcs() {
		return this.sbcs;
	}

	public void setSbcs(String sbcs) {
		this.sbcs = sbcs;
	}

	public String getSbxh() {
		return this.sbxh;
	}

	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}

	public String getGldz() {
		return this.gldz;
	}

	public void setGldz(String gldz) {
		this.gldz = gldz;
	}

	public String getVlanh() {
		return this.vlanh;
	}

	public void setVlanh(String vlanh) {
		this.vlanh = vlanh;
	}

}