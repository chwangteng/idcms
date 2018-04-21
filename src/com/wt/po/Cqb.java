package com.wt.po;

import java.util.Set;

/**
 * Cqb entity. @author MyEclipse Persistence Tools
 */
public class Cqb extends AbstractCqb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Cqb() {
	}

	/** minimal constructor */
	public Cqb(String cqxx) {
		super(cqxx);
	}

	/** full constructor */
	public Cqb(String cqxx, Set sbxxbs) {
		super(cqxx, sbxxbs);
	}

}
