package com.wt.po;

import java.sql.Timestamp;

/**
 * Attackinfoes entity. @author MyEclipse Persistence Tools
 */
public class Attackinfoes extends AbstractAttackinfoes implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Attackinfoes() {
	}

	/** minimal constructor */
	public Attackinfoes(String id) {
		super(id);
	}

	/** full constructor */
	public Attackinfoes(String id, String status, String count, String deftype, String SIp, Timestamp startTime,
			String dropCount, String SPortList, String CPortList, String CIpList, String packetType, Timestamp endTime,
			String duration, String dropSize, String size) {
		super(id, status, count, deftype, SIp, startTime, dropCount, SPortList, CPortList, CIpList, packetType, endTime,
				duration, dropSize, size);
	}

}
