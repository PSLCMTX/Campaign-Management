package com.demo.campaign.management.ms.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Component
@Document(collection="State")
public class State {
	
	 private String stateValue;

	/**
	 * 
	 */
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the stateValue
	 */
	public String getStateValue() {
		return stateValue;
	}

	/**
	 * @param stateValue the stateValue to set
	 */
	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}

	/**
	 * @param stateValue
	 */
	public State(String stateValue) {
		super();
		this.stateValue = stateValue;
	}

	@Override
	public String toString() {
		return "State [stateValue=" + stateValue + "]";
	}
	
}
