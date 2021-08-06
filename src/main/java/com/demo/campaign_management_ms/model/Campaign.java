package com.demo.campaign_management_ms.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Campaign")
public class Campaign {
	
	@Id
	private long id;
	private String name;
	private  String start_date;
	private String end_date;
	private List state;
	private List channel;
	private long price;
	private List cateogry;
	
	

	/**
	 * @param id
	 * @param name
	 * @param start_date
	 * @param end_date
	 * @param state
	 * @param channel
	 * @param price
	 * @param cateogry
	 */
	public Campaign(long id, String name, String start_date, String end_date, List state, List channel, long price,
			List cateogry) {
		super();
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
		this.channel = channel;
		this.price = price;
		this.cateogry = cateogry;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the start_date
	 */
	public String getStart_date() {
		return start_date;
	}



	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}



	/**
	 * @return the end_date
	 */
	public String getEnd_date() {
		return end_date;
	}



	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}



	/**
	 * @return the state
	 */
	public List getState() {
		return state;
	}



	/**
	 * @param state the state to set
	 */
	public void setState(List state) {
		this.state = state;
	}



	/**
	 * @return the channel
	 */
	public List getChannel() {
		return channel;
	}



	/**
	 * @param channel the channel to set
	 */
	public void setChannel(List channel) {
		this.channel = channel;
	}



	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}



	/**
	 * @return the cateogry
	 */
	public List getCateogry() {
		return cateogry;
	}



	/**
	 * @param cateogry the cateogry to set
	 */
	public void setCateogry(List cateogry) {
		this.cateogry = cateogry;
	}



	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", state=" + state + ", channel=" + channel + ", price=" + price + ", cateogry=" + cateogry + "]";
	}
	
}