
package org.mule.module.gmail.oauth;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.oauth.OAuth2Adapter;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessInterceptor;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.gmail.adapters.GmailConnectorOAuth2Adapter;
import org.mule.module.gmail.processors.AbstractExpressionEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class RefreshTokenProcessInterceptor<T >
    extends AbstractExpressionEvaluator
    implements ProcessInterceptor<T, GmailConnectorOAuth2Adapter>
{

    private static Logger logger = LoggerFactory.getLogger(RefreshTokenProcessInterceptor.class);
    private final ProcessInterceptor<T, GmailConnectorOAuth2Adapter> next;

    public RefreshTokenProcessInterceptor(ProcessInterceptor<T, GmailConnectorOAuth2Adapter> next) {
        this.next = next;
    }

    public T execute(ProcessCallback<T, GmailConnectorOAuth2Adapter> processCallback, GmailConnectorOAuth2Adapter object, MessageProcessor messageProcessor, MuleEvent event)
        throws Exception
    {
        T result = null;
        Exception cause = null;
        try {
            result = this.next.execute(processCallback, object, messageProcessor, event);
            return result;
        } catch (Exception e) {
            if (processCallback.getManagedExceptions()!= null) {
                for (Class exceptionClass: ((List<Class> ) processCallback.getManagedExceptions())) {
                    if (exceptionClass.isInstance(e)) {
                        if (((OAuth2Adapter) object).getRefreshToken()!= null) {
                            if (logger.isDebugEnabled()) {
                                logger.debug("A managed exception has been thrown. Attempting to refresh access token.");
                            }
                            try {
                                ((OAuth2Adapter) object).refreshAccessToken(((GmailConnectorOAuth2Adapter) object).getAccessTokenUrl());
                            } catch (Exception newException) {
                                if (logger.isDebugEnabled()) {
                                    logger.debug("Another exception was thrown while attempting to refresh the access token. Throwing original exception back up");
                                }
                                throw e;
                            }
                            result = this.next.execute(processCallback, object, messageProcessor, event);
                            return result;
                        }
                    }
                }
            }
            throw e;
        }
    }

}
