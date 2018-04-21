package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSblxb entity provides the base persistence definition of the Sblxb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSblxb implements java.io.Serializable {

	// Fields

	private Integer sblxid;
	private String sblx;
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSblxb() {
	}

	/** minimal constructor */
	public AbstractSblxb(String sblx) {
		this.sblx = sblx;
	}

	/** full constructor */
	public AbstractSblxb(String sblx, Set sbxxbs) {
		this.sblx = sblx;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getSblxid() {
		return this.sblxid;
	}

	public void setSblxid(Integer sblxid) {
		this.sblxid = sblxid;
	}

	public String getSblx() {
		return this.sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}