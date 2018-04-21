package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractJgb entity provides the base persistence definition of the Jgb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJgb implements java.io.Serializable {

	// Fields

	private Integer jgid;
	private String jgbh;
	private String jgwz;
	private Jfb jfb;
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractJgb() {
	}

	/** minimal constructor */
	public AbstractJgb(Jfb jfb, String jgbh, String jgwz) {
		this.jfb = jfb;
		this.jgbh = jgbh;
		this.jgwz = jgwz;
	}

	/** full constructor */
	public AbstractJgb(Jfb jfb, String jgbh, String jgwz, Set sbxxbs) {
		this.jfb = jfb;
		this.jgbh = jgbh;
		this.jgwz = jgwz;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getJgid() {
		return this.jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Jfb getJfb() {
		return this.jfb;
	}

	public void setJfb(Jfb jfb) {
		this.jfb = jfb;
	}

	public String getJgbh() {
		return this.jgbh;
	}

	public void setJgbh(String jgbh) {
		this.jgbh = jgbh;
	}

	public String getJgwz() {
		return this.jgwz;
	}

	public void setJgwz(String jgwz) {
		this.jgwz = jgwz;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}