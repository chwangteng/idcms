package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSbsylxb entity provides the base persistence definition of the
 * Sbsylxb entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSbsylxb implements java.io.Serializable {

	// Fields

	private Integer sylxid;
	private String sylx;
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSbsylxb() {
	}

	/** minimal constructor */
	public AbstractSbsylxb(String sylx) {
		this.sylx = sylx;
	}

	/** full constructor */
	public AbstractSbsylxb(String sylx, Set sbxxbs) {
		this.sylx = sylx;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getSylxid() {
		return this.sylxid;
	}

	public void setSylxid(Integer sylxid) {
		this.sylxid = sylxid;
	}

	public String getSylx() {
		return this.sylx;
	}

	public void setSylx(String sylx) {
		this.sylx = sylx;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}