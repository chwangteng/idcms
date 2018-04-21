package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractJfb entity provides the base persistence definition of the Jfb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJfb implements java.io.Serializable {

	// Fields

	private Integer jfid;
	private String jfmc;
	private String jfdz;
	private Set jgbs = new HashSet(0);
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractJfb() {
	}

	/** minimal constructor */
	public AbstractJfb(String jfmc, String jfdz) {
		this.jfmc = jfmc;
		this.jfdz = jfdz;
	}

	/** full constructor */
	public AbstractJfb(String jfmc, String jfdz, Set jgbs, Set sbxxbs) {
		this.jfmc = jfmc;
		this.jfdz = jfdz;
		this.jgbs = jgbs;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getJfid() {
		return this.jfid;
	}

	public void setJfid(Integer jfid) {
		this.jfid = jfid;
	}

	public String getJfmc() {
		return this.jfmc;
	}

	public void setJfmc(String jfmc) {
		this.jfmc = jfmc;
	}

	public String getJfdz() {
		return this.jfdz;
	}

	public void setJfdz(String jfdz) {
		this.jfdz = jfdz;
	}

	public Set getJgbs() {
		return this.jgbs;
	}

	public void setJgbs(Set jgbs) {
		this.jgbs = jgbs;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}