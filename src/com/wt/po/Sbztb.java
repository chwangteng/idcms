package com.wt.po;

import java.util.Set;

/**
 * Sbztb entity. @author MyEclipse Persistence Tools
 */
public class Sbztb extends AbstractSbztb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sbztb() {
	}

	/** minimal constructor */
	public Sbztb(String sbzt) {
		super(sbzt);
	}

	/** full constructor */
	public Sbztb(String sbzt, Set sbxxbs) {
		super(sbzt, sbxxbs);
	}

}
