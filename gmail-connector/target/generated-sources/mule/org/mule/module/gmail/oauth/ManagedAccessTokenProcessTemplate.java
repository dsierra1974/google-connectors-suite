
package org.mule.module.gmail.oauth;

import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.oauth.OAuthManager;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessInterceptor;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.gmail.adapters.GmailConnectorOAuth2Adapter;
import org.mule.module.gmail.process.ProcessCallbackProcessInterceptor;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class ManagedAccessTokenProcessTemplate<P >implements ProcessTemplate<P, GmailConnectorOAuth2Adapter>
{

    private final ProcessInterceptor<P, GmailConnectorOAuth2Adapter> processInterceptor;

    public ManagedAccessTokenProcessTemplate(OAuthManager<GmailConnectorOAuth2Adapter> oauthManager, MuleContext muleContext) {
        ProcessInterceptor<P, GmailConnectorOAuth2Adapter> processCallbackProcessInterceptor = new ProcessCallbackProcessInterceptor<P, GmailConnectorOAuth2Adapter>();
        ProcessInterceptor<P, GmailConnectorOAuth2Adapter> refreshTokenProcessInterceptor = new RefreshTokenProcessInterceptor<P>(processCallbackProcessInterceptor);
        ProcessInterceptor<P, GmailConnectorOAuth2Adapter> managedAccessTokenProcessInterceptor = new ManagedAccessTokenProcessInterceptor<P>(refreshTokenProcessInterceptor, oauthManager, muleContext);
        processInterceptor = managedAccessTokenProcessInterceptor;
    }

    public P execute(ProcessCallback<P, GmailConnectorOAuth2Adapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        return processInterceptor.execute(processCallback, null, messageProcessor, event);
    }

}
