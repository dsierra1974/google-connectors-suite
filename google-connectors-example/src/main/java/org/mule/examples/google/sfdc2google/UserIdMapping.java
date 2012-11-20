package org.mule.examples.google.sfdc2google;

import java.io.Serializable;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public class UserIdMapping implements Serializable {

	private static final long serialVersionUID = -7895175495993832916L;
	
	private String userId;
	private String googleId;
	private String sfdcId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGoogleId() {
		return googleId;
	}
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}
	public String getSfdcId() {
		return sfdcId;
	}
	public void setSfdcId(String sfdcId) {
		this.sfdcId = sfdcId;
	}
	
	
}
