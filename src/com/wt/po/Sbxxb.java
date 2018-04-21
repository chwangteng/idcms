package com.wt.po;

import java.sql.Timestamp;

/**
 * Sbxxb entity. @author MyEclipse Persistence Tools
 */
public class Sbxxb extends AbstractSbxxb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sbxxb() {
	}

	/** minimal constructor */
	public Sbxxb(String sbmc) {
		super(sbmc);
	}

	/** full constructor */
	public Sbxxb(Sblxb sblxb, Sbztb sbztb, Khxxb khxxb, Sbsylxb sbsylxb, Cqb cqb, Jgb jgb, Jfb jfb, String sbbm,
			String sbmc, Integer syzt, String gg, String czxt, String cpzl, String cpu, String nc, String yp,
			Timestamp rksj, Timestamp cksj, String sbcs, String sbxh, String gldz, String vlanh) {
		super(sblxb, sbztb, khxxb, sbsylxb, cqb, jgb, jfb, sbbm, sbmc, syzt, gg, czxt, cpzl, cpu, nc, yp, rksj, cksj,
				sbcs, sbxh, gldz, vlanh);
	}

}
