package com.wt.po;

import java.sql.Timestamp;

/**
 * AbstractAttackinfoes entity provides the base persistence definition of the
 * Attackinfoes entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAttackinfoes implements java.io.Serializable {

	// Fields

	private String id;
	private String status;
	private String count;
	private String deftype;
	private String SIp;
	private Timestamp startTime;
	private String dropCount;
	private String SPortList;
	private String CPortList;
	private String CIpList;
	private String packetType;
	private Timestamp endTime;
	private String duration;
	private String dropSize;
	private String size;

	// Constructors

	/** default constructor */
	public AbstractAttackinfoes() {
	}

	/** minimal constructor */
	public AbstractAttackinfoes(String id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractAttackinfoes(String id, String status, String count, String deftype, String SIp, Timestamp startTime,
			String dropCount, String SPortList, String CPortList, String CIpList, String packetType, Timestamp endTime,
			String duration, String dropSize, String size) {
		this.id = id;
		this.status = status;
		this.count = count;
		this.deftype = deftype;
		this.SIp = SIp;
		this.startTime = startTime;
		this.dropCount = dropCount;
		this.SPortList = SPortList;
		this.CPortList = CPortList;
		this.CIpList = CIpList;
		this.packetType = packetType;
		this.endTime = endTime;
		this.duration = duration;
		this.dropSize = dropSize;
		this.size = size;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCount() {
		return this.count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDeftype() {
		return this.deftype;
	}

	public void setDeftype(String deftype) {
		this.deftype = deftype;
	}

	public String getSIp() {
		return this.SIp;
	}

	public void setSIp(String SIp) {
		this.SIp = SIp;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getDropCount() {
		return this.dropCount;
	}

	public void setDropCount(String dropCount) {
		this.dropCount = dropCount;
	}

	public String getSPortList() {
		return this.SPortList;
	}

	public void setSPortList(String SPortList) {
		this.SPortList = SPortList;
	}

	public String getCPortList() {
		return this.CPortList;
	}

	public void setCPortList(String CPortList) {
		this.CPortList = CPortList;
	}

	public String getCIpList() {
		return this.CIpList;
	}

	public void setCIpList(String CIpList) {
		this.CIpList = CIpList;
	}

	public String getPacketType() {
		return this.packetType;
	}

	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDropSize() {
		return this.dropSize;
	}

	public void setDropSize(String dropSize) {
		this.dropSize = dropSize;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}