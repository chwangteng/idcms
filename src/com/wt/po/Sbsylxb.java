package com.wt.po;

import java.util.Set;

/**
 * Sbsylxb entity. @author MyEclipse Persistence Tools
 */
public class Sbsylxb extends AbstractSbsylxb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sbsylxb() {
	}

	/** minimal constructor */
	public Sbsylxb(String sylx) {
		super(sylx);
	}

	/** full constructor */
	public Sbsylxb(String sylx, Set sbxxbs) {
		super(sylx, sbxxbs);
	}

}
