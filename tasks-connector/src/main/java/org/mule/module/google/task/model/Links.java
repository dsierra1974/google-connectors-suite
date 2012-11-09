/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.task.model;

import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Wrapper for {@link org.mule.module.google.task.model.Links}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Links extends BaseWrapper<com.google.api.services.tasks.model.Task.Links> {
	
	public Links() {
		this(new com.google.api.services.tasks.model.Task.Links());
	}
	
	public Links(com.google.api.services.tasks.model.Task.Links wrapped) {
		super(wrapped);
	}
	
	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public String getType() {
		return wrapped.getType();
	}

	public String getLink() {
		return wrapped.getLink();
	}

	public String getDescription() {
		return wrapped.getDescription();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setType(String type) {
		wrapped.setType(type);
	}

	public void setLink(String link) {
		wrapped.setLink(link);
	}

	public void setDescription(String description) {
		wrapped.setDescription(description);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
