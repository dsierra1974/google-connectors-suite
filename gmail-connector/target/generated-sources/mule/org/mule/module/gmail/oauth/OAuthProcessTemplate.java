
package org.mule.module.gmail.oauth;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.oauth.OAuthAdapter;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.gmail.adapters.GmailConnectorCapabilitiesAdapter;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class OAuthProcessTemplate<P >implements ProcessTemplate<P, GmailConnectorCapabilitiesAdapter>
{

    private final GmailConnectorCapabilitiesAdapter object;

    public OAuthProcessTemplate(GmailConnectorCapabilitiesAdapter object) {
        this.object = object;
    }

    public P execute(ProcessCallback<P, GmailConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        if (processCallback.isProtected()) {
            ((OAuthAdapter) object).hasBeenAuthorized();
        }
        return processCallback.process(object);
    }

}
