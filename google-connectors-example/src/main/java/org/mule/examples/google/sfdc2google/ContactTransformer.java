package org.mule.examples.google.sfdc2google;


import java.util.ArrayList;
import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.FamilyName;
import com.google.gdata.data.extensions.GivenName;
import com.google.gdata.data.extensions.Name;

public class ContactTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		String payload = message.getPayload().toString();
		String email = payload.replaceAll(" ", "@");
		String[] nameParts = payload.split(" ");
		
		
		Name name = new Name();
		GivenName givenName = new GivenName();
		givenName.setValue(nameParts[0]);
		name.setGivenName(givenName);
		
		FamilyName familyName = new FamilyName();
		familyName.setValue(nameParts[1]);
		
		ContactEntry contact = new ContactEntry();
		contact.setName(name);
		
		Email mail = new Email();
		mail.setAddress(email);
		mail.setLabel(email);
		mail.setPrimary(true);
		
		List<Email> mails = new ArrayList<Email>();
		mails.add(mail);
		contact.setEmailAddresses(mails);
		
		return contact;
	}

}
