package com.wt.po;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractSbztb entity provides the base persistence definition of the Sbztb
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSbztb implements java.io.Serializable {

	// Fields

	private Integer sbztid;
	private String sbzt;
	private Set sbxxbs = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractSbztb() {
	}

	/** minimal constructor */
	public AbstractSbztb(String sbzt) {
		this.sbzt = sbzt;
	}

	/** full constructor */
	public AbstractSbztb(String sbzt, Set sbxxbs) {
		this.sbzt = sbzt;
		this.sbxxbs = sbxxbs;
	}

	// Property accessors

	public Integer getSbztid() {
		return this.sbztid;
	}

	public void setSbztid(Integer sbztid) {
		this.sbztid = sbztid;
	}

	public String getSbzt() {
		return this.sbzt;
	}

	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}

	public Set getSbxxbs() {
		return this.sbxxbs;
	}

	public void setSbxxbs(Set sbxxbs) {
		this.sbxxbs = sbxxbs;
	}

}