package com.demo.campaign.management.ms.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Component
@Document(collection="Channel")
public class Channel {
	private String channelValue;

	/**
	 * 
	 */
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param channelValue
	 */
	public Channel(String channelValue) {
		super();
		this.channelValue = channelValue;
	}

	/**
	 * @return the channelValue
	 */
	public String getChannelValue() {
		return channelValue;
	}

	/**
	 * @param channelValue the channelValue to set
	 */
	public void setChannelValue(String channelValue) {
		this.channelValue = channelValue;
	}

	@Override
	public String toString() {
		return "Channel [channelValue=" + channelValue + "]";
	}
	
	
	
	
	
	

}
