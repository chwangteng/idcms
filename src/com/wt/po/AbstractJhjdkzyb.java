package com.wt.po;

/**
 * AbstractJhjdkzyb entity provides the base persistence definition of the
 * Jhjdkzyb entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJhjdkzyb implements java.io.Serializable {

	// Fields

	private Integer dkid;
	private Sbxxb sbxxb;
	private Integer dkh;
	private String dkxx;
	private String dkjcrj;

	// Constructors

	/** default constructor */
	public AbstractJhjdkzyb() {
	}

	/** full constructor */
	public AbstractJhjdkzyb(Sbxxb sbxxb, Integer dkh, String dkxx, String dkjcrj) {
		this.sbxxb = sbxxb;
		this.dkh = dkh;
		this.dkxx = dkxx;
		this.dkjcrj = dkjcrj;
	}

	// Property accessors

	public Integer getDkid() {
		return this.dkid;
	}

	public void setDkid(Integer dkid) {
		this.dkid = dkid;
	}

	public Sbxxb getSbxxb() {
		return this.sbxxb;
	}

	public void setSbxxb(Sbxxb sbxxb) {
		this.sbxxb = sbxxb;
	}

	public Integer getDkh() {
		return this.dkh;
	}

	public void setDkh(Integer dkh) {
		this.dkh = dkh;
	}

	public String getDkxx() {
		return this.dkxx;
	}

	public void setDkxx(String dkxx) {
		this.dkxx = dkxx;
	}

	public String getDkjcrj() {
		return this.dkjcrj;
	}

	public void setDkjcrj(String dkjcrj) {
		this.dkjcrj = dkjcrj;
	}

}