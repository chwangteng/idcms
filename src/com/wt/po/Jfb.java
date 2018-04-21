package com.wt.po;

import java.util.Set;

/**
 * Jfb entity. @author MyEclipse Persistence Tools
 */
public class Jfb extends AbstractJfb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Jfb() {
	}

	/** minimal constructor */
	public Jfb(String jfmc, String jfdz) {
		super(jfmc, jfdz);
	}
	
	public Jfb(Integer jfid, String jfmc, String jfdz) {
		super(jfmc, jfdz);
		this.setJfid(jfid);
	}

	/** full constructor */
	public Jfb(String jfmc, String jfdz, Set jgbs, Set sbxxbs) {
		super(jfmc, jfdz, jgbs, sbxxbs);
	}

}
