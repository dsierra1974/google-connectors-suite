/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.google.task.model;

import java.util.List;

import org.mule.modules.google.api.datetime.DateTime;
import org.mule.modules.google.api.model.BaseWrapper;

/**
 * Wrapper for {@link org.mule.module.google.task.model.Task}
 * to make it data mapper friendly.
 * 
 * @author mariano.gonzalez@mulesoft.com
 */
public class Task extends BaseWrapper<com.google.api.services.tasks.model.Task> {
	
	public Task() {
		this(new com.google.api.services.tasks.model.Task());
	}
	
	public Task(com.google.api.services.tasks.model.Task wrapped) {
		super(wrapped);
	}
	
	public boolean equals(Object o) {
		return wrapped.equals(o);
	}

	public String getStatus() {
		return wrapped.getStatus();
	}

	public DateTime getUpdated() {
		return new DateTime(wrapped.getUpdated());
	}

	public String getParent() {
		return wrapped.getParent();
	}

	public List<Links> getLinks() {
		return Links.valueOf(wrapped.getLinks(), Links.class);
	}

	public String getTitle() {
		return wrapped.getTitle();
	}

	public Boolean getDeleted() {
		return wrapped.getDeleted();
	}

	public DateTime getCompleted() {
		return new DateTime(wrapped.getCompleted());
	}

	public DateTime getDue() {
		return new DateTime(wrapped.getDue());
	}

	public String getNotes() {
		return wrapped.getNotes();
	}

	public String getPosition() {
		return wrapped.getPosition();
	}

	public Boolean getHidden() {
		return wrapped.getHidden();
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

	public void setStatus(String status) {
		wrapped.setStatus(status);
	}

	public void setUpdated(DateTime updated) {
		wrapped.setUpdated(updated.getWrapped());
	}

	public void setParent(String parent) {
		wrapped.setParent(parent);
	}

	public void setLinks(List<Links> links) {
		wrapped.setLinks(Links.unwrapp(links, com.google.api.services.tasks.model.Task.Links.class));
	}

	public void setTitle(String title) {
		wrapped.setTitle(title);
	}

	public void setDeleted(Boolean deleted) {
		wrapped.setDeleted(deleted);
	}

	public void setCompleted(DateTime completed) {
		wrapped.setCompleted(completed.getWrapped());
	}

	public void setDue(DateTime due) {
		wrapped.setDue(due.getWrapped());
	}

	public void setNotes(String notes) {
		wrapped.setNotes(notes);
	}

	public void setPosition(String position) {
		wrapped.setPosition(position);
	}

	public void setHidden(Boolean hidden) {
		wrapped.setHidden(hidden);
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
