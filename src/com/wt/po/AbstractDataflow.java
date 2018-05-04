package com.wt.po;

import java.sql.Timestamp;

/**
 * AbstractDataflow entity provides the base persistence definition of the
 * Dataflow entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractDataflow implements java.io.Serializable {

	// Fields

	private Integer id;
	private String jhj;
	private String jk;
	private String lrll;
	private String lcll;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public AbstractDataflow() {
	}

	/** full constructor */
	public AbstractDataflow(Integer id, String jhj, String jk, String lrll, String lcll, Timestamp time) {
		this.id = id;
		this.jhj = jhj;
		this.jk = jk;
		this.lrll = lrll;
		this.lcll = lcll;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJhj() {
		return this.jhj;
	}

	public void setJhj(String jhj) {
		this.jhj = jhj;
	}

	public String getJk() {
		return this.jk;
	}

	public void setJk(String jk) {
		this.jk = jk;
	}

	public String getLrll() {
		return this.lrll;
	}

	public void setLrll(String lrll) {
		this.lrll = lrll;
	}

	public String getLcll() {
		return this.lcll;
	}

	public void setLcll(String lcll) {
		this.lcll = lcll;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}