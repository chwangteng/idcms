package com.wt.po;

/**
 * AbstractTblSwitchsnmp entity provides the base persistence definition of the
 * TblSwitchsnmp entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTblSwitchsnmp implements java.io.Serializable {

	// Fields

	private String id;
	private String deviceid;
	private String devicename;
	private String ipaddr;
	private String ifoid;
	private String flowoid;
	private String community;
	private String flowoutoid;

	// Constructors

	/** default constructor */
	public AbstractTblSwitchsnmp() {
	}

	/** full constructor */
	public AbstractTblSwitchsnmp(String id, String deviceid, String devicename, String ipaddr, String ifoid,
			String flowoid, String community, String flowoutoid) {
		this.id = id;
		this.deviceid = deviceid;
		this.devicename = devicename;
		this.ipaddr = ipaddr;
		this.ifoid = ifoid;
		this.flowoid = flowoid;
		this.community = community;
		this.flowoutoid = flowoutoid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getDevicename() {
		return this.devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getIpaddr() {
		return this.ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getIfoid() {
		return this.ifoid;
	}

	public void setIfoid(String ifoid) {
		this.ifoid = ifoid;
	}

	public String getFlowoid() {
		return this.flowoid;
	}

	public void setFlowoid(String flowoid) {
		this.flowoid = flowoid;
	}

	public String getCommunity() {
		return this.community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getFlowoutoid() {
		return this.flowoutoid;
	}

	public void setFlowoutoid(String flowoutoid) {
		this.flowoutoid = flowoutoid;
	}

}