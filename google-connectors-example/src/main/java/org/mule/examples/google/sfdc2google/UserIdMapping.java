/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

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
