package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCqb entity provides the base persistence definition of the Cqb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCqb implements java.io.Serializable {

	// Fields

	private Integer cqid;
	private String cqxx;
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCqb() {
	}

	/** minimal constructor */
	public AbstractCqb(String cqxx) {
		this.cqxx = cqxx;
	}

	/** full constructor */
	public AbstractCqb(String cqxx, Set sbxxbs) {
		this.cqxx = cqxx;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getCqid() {
		return this.cqid;
	}

	public void setCqid(Integer cqid) {
		this.cqid = cqid;
	}

	public String getCqxx() {
		return this.cqxx;
	}

	public void setCqxx(String cqxx) {
		this.cqxx = cqxx;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}