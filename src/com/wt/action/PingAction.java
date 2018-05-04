package com.wt.action;

import com.wt.util.Ping;

public class PingAction {

	private String address;
	
	private String result;
	
	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String testping() throws Exception{
		
		result=Ping.ping(address);
		
		return "success";
	}
}
