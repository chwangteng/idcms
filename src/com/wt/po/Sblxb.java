package com.wt.po;

import java.util.Set;

/**
 * Sblxb entity. @author MyEclipse Persistence Tools
 */
public class Sblxb extends AbstractSblxb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sblxb() {
	}

	/** minimal constructor */
	public Sblxb(String sblx) {
		super(sblx);
	}

	/** full constructor */
	public Sblxb(String sblx, Set sbxxbs) {
		super(sblx, sbxxbs);
	}

	
}
