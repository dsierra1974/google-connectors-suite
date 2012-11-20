/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.examples.google.sfdc2google;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.google.task.model.Task;
import org.mule.transformer.AbstractMessageTransformer;

public class TaskTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		Task task = new Task();
		task.setTitle("Meet with " + message.getPayload().toString());
		
		return task;
	}

}
