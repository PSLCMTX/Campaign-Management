package com.demo.campaign_management_ms.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="State")
public class State {
	
	 private String active;
	 private String suspended;
	 private String terminated;
	
	/**
	 * @param active
	 * @param suspended
	 * @param terminated
	 */
	public State(String active, String suspended, String terminated) {
		super();
		this.active = active;
		this.suspended = suspended;
		this.terminated = terminated;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the suspended
	 */
	public String getSuspended() {
		return suspended;
	}

	/**
	 * @param suspended the suspended to set
	 */
	public void setSuspended(String suspended) {
		this.suspended = suspended;
	}

	/**
	 * @return the terminated
	 */
	public String getTerminated() {
		return terminated;
	}

	/**
	 * @param terminated the terminated to set
	 */
	public void setTerminated(String terminated) {
		this.terminated = terminated;
	}

	@Override
	public String toString() {
		return "State [active=" + active + ", suspended=" + suspended + ", terminated=" + terminated + "]";
	}

}
