/**
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.gmail;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.OAuthInvalidateAccessTokenOn;
import org.mule.api.annotations.oauth.OAuthProtected;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.module.gmail.model.GmailFolder;
import org.mule.module.gmail.search.FlagCriteria;
import org.mule.module.gmail.search.SearchCriteria;
import org.mule.modules.google.AbstractGoogleOAuthConnector;
import org.mule.modules.google.api.datetime.DateTimeUtils;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;

import com.google.code.com.sun.mail.imap.IMAPFolder;
import com.google.code.com.sun.mail.imap.IMAPMessage;
import com.google.code.javax.mail.AuthenticationFailedException;
import com.google.code.javax.mail.FetchProfile;
import com.google.code.javax.mail.Folder;
import com.google.code.javax.mail.MessagingException;
import com.google.code.javax.mail.Store;
import com.google.code.javax.mail.internet.InternetAddress;
import com.google.code.javax.mail.search.AndTerm;
import com.google.code.javax.mail.search.BodyTerm;
import com.google.code.javax.mail.search.ComparisonTerm;
import com.google.code.javax.mail.search.FlagTerm;
import com.google.code.javax.mail.search.FromTerm;
import com.google.code.javax.mail.search.GmailLabelTerm;
import com.google.code.javax.mail.search.GmailRawSearchTerm;
import com.google.code.javax.mail.search.GmailThreadIDTerm;
import com.google.code.javax.mail.search.HeaderTerm;
import com.google.code.javax.mail.search.MessageIDTerm;
import com.google.code.javax.mail.search.MessageNumberTerm;
import com.google.code.javax.mail.search.OrTerm;
import com.google.code.javax.mail.search.ReceivedDateTerm;
import com.google.code.javax.mail.search.SearchTerm;
import com.google.code.javax.mail.search.SentDateTerm;
import com.google.code.javax.mail.search.SizeTerm;
import com.google.code.javax.mail.search.SubjectTerm;

/**
 * 
 * @author mariano.gonzalez@mulesoft.com
 *
 */
public abstract class BaseGmailConnector extends AbstractGoogleOAuthConnector {

	protected abstract Store getStore(String username);
	
//	public void send()
	
	/**
	 * Search and returns messages on a folder of the given username
	 * using a search criteria provided by the user via the searchTerm parameter
	 * 
	 * {@sample.xml ../../../doc/Gmail-connector.xml.sample gmail:advanced-search}
	 * 
	 * @param username the account's username
	 * @param folder the folder in which to search. If you want all of them then use ALL_MAIL
	 * @param searchTerm an instance of {@link com.google.code.javax.mail.search.SearchTerm}. If not provided, then no filtering criteria is applied
	 * @param expunge if true, all read messages will be deleted upon operation completion
	 * @return a list of {@link com.google.code.com.sun.mail.imap.IMAPMessage} representing the found messages
	 * @throws MessagingException if an error is found accessing the mailbox
	 */
	@Processor
	@OAuthProtected
	@OAuthInvalidateAccessTokenOn(exception=OAuthTokenExpiredException.class)
	public List<IMAPMessage> advancedSearch(
									String username,
									GmailFolder folder,
									SearchTerm searchTerm,
									@Optional @Default("false") Boolean expunge) throws MessagingException {
		
		List<SearchTerm> terms = new ArrayList<SearchTerm>(1);
		terms.add(searchTerm);
		return this.doGetMessages(username, folder, terms, expunge);
	}
	

	/**
	 * Returns messages in the user mailbox
	 * 
	 * {@sample.xml ../../../doc/Gmail-connector.xml.sample gmail:search}
	 * 
	 * @param username the account's username
	 * @param folder the folder in which to search. If you want all of them then use ALL_MAIL
	 * @param receivedBefore a date in the specified string format giving a lower bound filter to the received date. If no dateFormat is specified, then RFC3339 is assumed
	 * @param receivedAfter a date in the specified string format giving an upper bound filter to the received date. If no dateFormat is specified, then RFC3339 is assumed
	 * @param sentBefore a date in the specified string format giving a lower bound filter to the sent date. If no dateFormat is specified, then RFC3339 is assumed
	 * @param sentAfter a date in the specified string format giving an upper bound filter to the sent date. If no dateFormat is specified, then RFC3339 is assumed
	 * @param fromAddresses a list of addresses to be found in the from attribute. This is an OR operation logic. All messages with any one of these addresses will be returned 
	 * @param toAddresses a list of addresses to be found in the to attribute. This is an OR operation logic. All messages with any one of these addresses will be returned
	 * @param messageNumber used to look for the message with the specified number
	 * @param size an instance of {@link org.mule.module.gmail.search.SearchCriteria} to specify restrictions on the message's size
	 * @param flags a list of {@link org.mule.module.gmail.search.FlagCriteria} to specify flag values that the messages should have
	 * @param labels a list of Strings which represent the labels that the messages need to have. This is an OR operation logic. All messages with any one of these labels will be returned
	 * @param rawSearchTerms a list of Strings which represent terms that the message should have. This is an OR operation logic. All messages with any one of these terms will be returned
	 * @param threadId the id of the thread for which the message should belong 
	 * @param bodyTerms a list of Strings which represent the body terms that the messages need to have. This is an OR operation logic. All messages with any one of these terms will be returned
	 * @param headerTerms a list of Strings which represent the header terms that the messages need to have. This is an OR operation logic. All messages with any one of these terms will be returned
	 * @param messageId used to fetch one given message by id
	 * @param subjectTerms a list of Strings which represent the subject terms that the messages need to have. This is an OR operation logic. All messages with any one of these terms will be returned
	 * @param dateFormat the format to be used to parse the date attributes. If no dateFormat is specified, then RFC3339 is assumed
	 * @param expunge if true, all read messages will be deleted upon operation completion
	 * @return a list of {@link com.google.code.com.sun.mail.imap.IMAPMessage}
	 * @throws MessagingException if an error is found accessing the mailbox
	 */
	@Processor
	@OAuthProtected
	@OAuthInvalidateAccessTokenOn(exception=OAuthTokenExpiredException.class)
	public List<IMAPMessage> search(
					String username,
					GmailFolder folder,
					@Optional @Default("") String receivedBefore,
					@Optional @Default("") String receivedAfter,
					@Optional @Default("") String sentBefore,
					@Optional @Default("") String sentAfter,
					@Optional List<String> fromAddresses,
					@Optional List<String> toAddresses,
					@Optional Integer messageNumber,
					@Optional SearchCriteria size,
					@Optional List<FlagCriteria> flags,
					@Optional List<String> labels,
					@Optional List<String> rawSearchTerms,
					@Optional @Default("") String threadId,
					@Optional List<String> bodyTerms,
					@Optional List<String> headerTerms,
					@Optional @Default("") String messageId,
					@Optional List<String> subjectTerms,
					@Optional @Default(DateTimeUtils.RFC3339) String dateFormat,
					@Optional @Default("false") Boolean expunge) throws MessagingException {
		
		List<SearchTerm> searchTerms = new ArrayList<SearchTerm>();
		
		if (!StringUtils.isBlank(receivedBefore)) {
			searchTerms.add(new ReceivedDateTerm(ComparisonTerm.LE, DateTimeUtils.parseDate(receivedBefore, dateFormat)));
		}
		
		if (!StringUtils.isBlank(receivedAfter)) {
			searchTerms.add(new ReceivedDateTerm(ComparisonTerm.GE, DateTimeUtils.parseDate(receivedAfter, dateFormat)));
		}
		
		if (!StringUtils.isBlank(sentBefore)) {
			searchTerms.add(new SentDateTerm(ComparisonTerm.LE, DateTimeUtils.parseDate(sentBefore, dateFormat)));
		}
		
		if (!StringUtils.isBlank(sentAfter)) {
			searchTerms.add(new SentDateTerm(ComparisonTerm.GE, DateTimeUtils.parseDate(sentAfter, dateFormat)));
		}
		
		if (!CollectionUtils.isEmpty(fromAddresses)) {
			List<SearchTerm> from = new ArrayList<SearchTerm>(fromAddresses.size());
			for (String address : fromAddresses) {
				from.add(new FromTerm(new InternetAddress(address)));
			}
			
			searchTerms.add(new OrTerm(from.toArray(new SearchTerm[from.size()])));
		}
		
		if (!CollectionUtils.isEmpty(toAddresses)) {
			List<SearchTerm> to = new ArrayList<SearchTerm>(toAddresses.size());
			for (String address : toAddresses) {
				to.add(new FromTerm(new InternetAddress(address)));
			}
			
			searchTerms.add(new OrTerm(to.toArray(new SearchTerm[to.size()])));
		}
		
		if (messageNumber != null) {
			searchTerms.add(new MessageNumberTerm(messageNumber));
		}
		
		if (size != null) {
			searchTerms.add(new SizeTerm(size.getOperator().getTerm(), Integer.valueOf(size.getValue())));
		}
		
		if (!CollectionUtils.isEmpty(flags)) {
			List<SearchTerm> f = new ArrayList<SearchTerm>(flags.size());
			for (FlagCriteria criteria : flags) {
				f.add(new FlagTerm(criteria.getFlag().getValue(), criteria.isSet()));
			}
			searchTerms.add(new OrTerm(f.toArray(new SearchTerm[f.size()])));
		}
		
		this.addStringTerms(searchTerms, labels, GmailLabelTerm.class);
		this.addStringTerms(searchTerms, rawSearchTerms, GmailRawSearchTerm.class);
		this.addStringTerms(searchTerms, bodyTerms, BodyTerm.class);
		this.addStringTerms(searchTerms, headerTerms, HeaderTerm.class);
		this.addStringTerms(searchTerms, subjectTerms, SubjectTerm.class);

		if (!StringUtils.isBlank(threadId)) {
			searchTerms.add(new GmailThreadIDTerm(threadId));
		}
		
		if (!StringUtils.isBlank(messageId)) {
			searchTerms.add(new MessageIDTerm(messageId));
		}
		
		return this.doGetMessages(username, folder, searchTerms, expunge);
	}
	
	private List<IMAPMessage> doGetMessages(String username, GmailFolder gmailFolder, List<SearchTerm> searchTerms, boolean expunge) throws MessagingException {
		FetchProfile fp = new FetchProfile();
		fp.add(IMAPFolder.FetchProfileItem.X_GM_MSGID);
		fp.add(IMAPFolder.FetchProfileItem.X_GM_THRID);
		fp.add(IMAPFolder.FetchProfileItem.X_GM_LABELS);
		
		Store store = null;
		Folder folder = null;
		
		try {
			store = this.getStore(username);
			folder = this.openFolder(store, gmailFolder);

			int size = searchTerms != null ? searchTerms.size() : 0;
			if (size == 0) {
				return this.returnMessages((IMAPMessage[]) folder.getMessages());
			} else if (size == 1) {
				return this.returnMessages((IMAPMessage[]) folder.search(searchTerms.get(0)));
			} else {
				return this.returnMessages((IMAPMessage[]) folder.search(new AndTerm(searchTerms.toArray(new SearchTerm[searchTerms.size()]))));
			}
		} catch (AuthenticationFailedException e) {
			throw new OAuthTokenExpiredException("Authentication failed", e);
		} finally {
			
			if (folder != null && folder.isOpen()) {
				folder.close(expunge);
			}
			
			if (store != null) {
				store.close();
			}
		}
	}
	
	private List<IMAPMessage> returnMessages(IMAPMessage... messages) {
		return (List<IMAPMessage>) Arrays.asList(messages);
	}
	
	private <T extends SearchTerm> List<SearchTerm> addStringTerms(List<SearchTerm> searchTerms, List<String> values, Class<T> termClass) {
		if (!CollectionUtils.isEmpty(values)) {
			List<SearchTerm> terms = new ArrayList<SearchTerm>();
			for (String value : values) {
				try {
					Constructor<T> constructor = termClass.getConstructor(String.class);
					terms.add(constructor.newInstance(value));
				} catch (Exception e) {
					throw new RuntimeException(e); 
				}
			}
			searchTerms.add(new OrTerm(terms.toArray(new SearchTerm[terms.size()])));
		}
		
		return searchTerms;
	}
	
	private Folder openFolder(Store store, GmailFolder gmailFolder) throws MessagingException {
		String target = gmailFolder.getDescription(); 
		for (Folder f : store.getDefaultFolder().xlist("*")) {
			IMAPFolder folder = (IMAPFolder) f;
			for (String attr : folder.getAttributes()) {
				attr = attr.substring(1);
				if (target.equals(attr)) { // xlist returns things like \Inbox so remove first character
					f = store.getFolder(target.equals("Inbox") ? target : folder.getFullName());
					f.open(Folder.READ_ONLY);
					return f;
				}
			}
		}
		
		throw new IllegalArgumentException(String.format("No such folder %s", target));
	}
	
}
