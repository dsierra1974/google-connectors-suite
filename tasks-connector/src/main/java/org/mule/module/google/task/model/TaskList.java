/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.task.model;

import org.mule.modules.google.api.datetime.DateTime;
import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Wrapper for {@link org.mule.module.google.task.model.TaskList}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class TaskList extends BaseWrapper<com.google.api.services.tasks.model.TaskList> {
	
	 public TaskList() {
		 this(new com.google.api.services.tasks.model.TaskList());
	 }
	 
	 public TaskList(com.google.api.services.tasks.model.TaskList wrapped) {
		 super(wrapped);
	 }

	public String getTitle() {
		return wrapped.getTitle();
	}

	public DateTime getUpdated() {
		return new DateTime(wrapped.getUpdated());
	}

	public boolean equals(Object arg0) {
		return wrapped.equals(arg0);
	}

	public String getId() {
		return wrapped.getId();
	}

	public String getSelfLink() {
		return wrapped.getSelfLink();
	}

	public int hashCode() {
		return wrapped.hashCode();
	}

	public void setTitle(String title) {
		wrapped.setTitle(title);
	}

	public void setUpdated(DateTime updated) {
		wrapped.setUpdated(updated.getWrapped());
	}

	public void setId(String id) {
		wrapped.setId(id);
	}

	public void setSelfLink(String selfLink) {
		wrapped.setSelfLink(selfLink);
	}

	public String toString() {
		return wrapped.toString();
	}

	public String toPrettyString() {
		return wrapped.toPrettyString();
	}
}
