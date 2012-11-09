/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.google;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public abstract class GoogleUserIdExtractor {
	
	private static Logger logger = Logger.getLogger(GoogleUserIdExtractor.class);
	private static Client restClient = Client.create();
	private static final Pattern userIdPattern = Pattern.compile("\"user_id\"[ ]*:[ ]*\"([^\\\"]*)\"");
	
	public static String getUserId(AbstractGoogleOAuthConnector connector) {
		if (StringUtils.isBlank(connector.getUserId())) {
			
			String accessToken = connector.getAccessToken();
			
			if (StringUtils.isBlank(accessToken)) {
				if (logger.isDebugEnabled()) {
					logger.debug("NO access token yet available, returning null as user id");
				}
				return null;
			}
			
			String response = restClient.resource("https://www.googleapis.com/oauth2/v1/tokeninfo")
					.queryParam("alt", "json")
					.queryParam("access_token", accessToken)
					.get(String.class);
			
			Matcher matcher = userIdPattern.matcher(response);
			if (matcher.find()) {
				connector.setUserId(matcher.group(1));
			} else {
				throw new RuntimeException("Could not extract user_id from " + response);
			}
		}
		
		return connector.getUserId();
	}

}
