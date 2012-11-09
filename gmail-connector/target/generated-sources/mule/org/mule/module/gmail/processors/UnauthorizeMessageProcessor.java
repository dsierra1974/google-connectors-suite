
package org.mule.module.gmail.processors;

import javax.annotation.Generated;
import org.mule.api.DefaultMuleException;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.UnableToAcquireConnectionException;
import org.mule.api.construct.FlowConstructAware;
import org.mule.api.context.MuleContextAware;
import org.mule.api.processor.MessageProcessor;
import org.mule.config.i18n.CoreMessages;
import org.mule.module.gmail.adapters.GmailConnectorOAuth2Adapter;
import org.mule.module.gmail.oauth.GmailConnectorOAuthManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class UnauthorizeMessageProcessor
    extends AbstractMessageProcessor<GmailConnectorOAuthManager>
    implements FlowConstructAware, MuleContextAware, MessageProcessor
{

    private static Logger logger = LoggerFactory.getLogger(UnauthorizeMessageProcessor.class);

    /**
     * Unauthorize the connector
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(MuleEvent event)
        throws MuleException
    {
        GmailConnectorOAuth2Adapter connector = null;
        try {
            String _transformedToken = ((String) evaluateAndTransform(getMuleContext(), event, AbstractConnectedProcessor.class.getDeclaredField("_accessTokenIdType").getGenericType(), null, getAccessTokenId()));
            if (logger.isDebugEnabled()) {
                logger.debug(("Attempting to acquire access token using from store for user "+ _transformedToken.toString()));
            }
            connector = getModuleObject().acquireAccessToken(_transformedToken);
            if (connector == null) {
                throw new UnableToAcquireConnectionException();
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug((("Access Token has been acquired for [tokenId="+ connector.getAccessTokenId())+"]"));
                }
                getModuleObject().destroyAccessToken(_transformedToken, connector);
                if (logger.isDebugEnabled()) {
                    logger.debug((("Access token for [tokenId="+ connector.getAccessTokenId())+"] has been successfully destroyed"));
                }
            }
        } catch (Exception e) {
            throw new DefaultMuleException(CoreMessages.createStaticMessage("Unable to unauthorize the connector"), e);
        }
        return event;
    }

}
