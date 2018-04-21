package com.wt.po;

import java.util.Set;

/**
 * Jgb entity. @author MyEclipse Persistence Tools
 */
public class Jgb extends AbstractJgb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Jgb() {
	}

	/** minimal constructor */
	public Jgb(Jfb jfb, String jgbh, String jgwz) {
		super(jfb, jgbh, jgwz);
	}

	/** full constructor */
	public Jgb(Jfb jfb, String jgbh, String jgwz, Set sbxxbs) {
		super(jfb, jgbh, jgwz, sbxxbs);
	}

}
