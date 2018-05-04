package com.wt.po;

import java.sql.Timestamp;

/**
 * Dataflow entity. @author MyEclipse Persistence Tools
 */
public class Dataflow extends AbstractDataflow implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Dataflow() {
	}

	/** full constructor */
	public Dataflow(Integer id, String jhj, String jk, String lrll, String lcll, Timestamp time) {
		super(id, jhj, jk, lrll, lcll, time);
	}

}
