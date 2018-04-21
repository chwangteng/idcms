package com.wt.po;

import java.util.Set;

/**
 * Khxxb entity. @author MyEclipse Persistence Tools
 */
public class Khxxb extends AbstractKhxxb implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Khxxb() {
	}

	/** minimal constructor */
	public Khxxb(String khm) {
		super(khm);
	}

	public Khxxb(String khm, String khdz, String tyxydm, String yyzz, String lxr, String lxrdh, String lxryx) {
		super(khm, khdz, tyxydm, yyzz, lxr, lxrdh, lxryx);
	}
	
	/** full constructor */
	public Khxxb(String khm, String khdz, String tyxydm, String yyzz, String lxr, String lxrdh, String lxryx,
			Set sbxxbs) {
		super(khm, khdz, tyxydm, yyzz, lxr, lxrdh, lxryx, sbxxbs);
	}

}
