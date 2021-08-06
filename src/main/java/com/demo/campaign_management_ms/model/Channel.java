package com.demo.campaign_management_ms.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Channel")
public class Channel {
	private String sms;
	private String mms;
	private String tv;
	
	/**
	 * @param sms
	 * @param mms
	 * @param tv
	 */
	public Channel(String sms, String mms, String tv) {
		super();
		this.sms = sms;
		this.mms = mms;
		this.tv = tv;
	}

	/**
	 * @return the sms
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * @param sms the sms to set
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}

	/**
	 * @return the mms
	 */
	public String getMms() {
		return mms;
	}

	/**
	 * @param mms the mms to set
	 */
	public void setMms(String mms) {
		this.mms = mms;
	}

	/**
	 * @return the tv
	 */
	public String getTv() {
		return tv;
	}

	/**
	 * @param tv the tv to set
	 */
	public void setTv(String tv) {
		this.tv = tv;
	}

	@Override
	public String toString() {
		return "Channel [sms=" + sms + ", mms=" + mms + ", tv=" + tv + "]";
	}
	

}
