package com.wt.po;

/**
 * TblSwitchsnmp entity. @author MyEclipse Persistence Tools
 */
public class TblSwitchsnmp extends AbstractTblSwitchsnmp implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TblSwitchsnmp() {
	}

	/** full constructor */
	public TblSwitchsnmp(String id, String deviceid, String devicename, String ipaddr, String ifoid, String flowoid,
			String community, String flowoutoid) {
		super(id, deviceid, devicename, ipaddr, ifoid, flowoid, community, flowoutoid);
	}

}
