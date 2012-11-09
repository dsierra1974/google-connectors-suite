
package org.mule.module.gmail.oauth;

import javax.annotation.Generated;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.mule.api.context.MuleContextAware;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.module.gmail.adapters.GmailConnectorOAuth2Adapter;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class GmailConnectorOAuthClientFactory implements KeyedPoolableObjectFactory
{

    private GmailConnectorOAuthManager oauthManager;

    public GmailConnectorOAuthClientFactory(GmailConnectorOAuthManager oauthManager) {
        this.oauthManager = oauthManager;
    }

    public Object makeObject(Object key)
        throws Exception
    {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        GmailConnectorOAuthState state = null;
        if (!oauthManager.getAccessTokenObjectStore().contains(((String) key))) {
            throw new RuntimeException((("There is no access token stored under the key "+((String) key))+". You need to call the <authorize> message processor. The key will be given to you via a flow variable after the OAuth dance is completed. You can extract it using flowVars['tokenId']."));
        }
        state = ((GmailConnectorOAuthState) oauthManager.getAccessTokenObjectStore().retrieve(((String) key)));
        GmailConnectorOAuth2Adapter connector = new GmailConnectorOAuth2Adapter();
        connector.setConsumerKey(oauthManager.getConsumerKey());
        connector.setConsumerSecret(oauthManager.getConsumerSecret());
        connector.setApplicationName(oauthManager.getApplicationName());
        connector.setScope(oauthManager.getScope());
        connector.setAccessToken(state.getAccessToken());
        connector.setAuthorizationUrl(state.getAuthorizationUrl());
        connector.setAccessTokenUrl(state.getAccessTokenUrl());
        connector.setRefreshToken(state.getRefreshToken());
        if (connector instanceof Initialisable) {
            ((Initialisable) connector).initialise();
        }
        if (connector instanceof MuleContextAware) {
            ((MuleContextAware) connector).setMuleContext(oauthManager.getMuleContext());
        }
        if (connector instanceof Startable) {
            ((Startable) connector).start();
        }
        return connector;
    }

    public void destroyObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof GmailConnectorOAuth2Adapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        try {
        } catch (Exception e) {
            throw e;
        } finally {
            if (((GmailConnectorOAuth2Adapter) obj) instanceof Stoppable) {
                ((Stoppable) obj).stop();
            }
            if (((GmailConnectorOAuth2Adapter) obj) instanceof Disposable) {
                ((Disposable) obj).dispose();
            }
        }
    }

    public boolean validateObject(Object key, Object obj) {
        return true;
    }

    public void activateObject(Object key, Object obj)
        throws Exception
    {
    }

    public void passivateObject(Object key, Object obj)
        throws Exception
    {
        if (!(key instanceof String)) {
            throw new RuntimeException("Invalid key type");
        }
        if (!(obj instanceof GmailConnectorOAuth2Adapter)) {
            throw new RuntimeException("Invalid connector type");
        }
        GmailConnectorOAuthState state = null;
        if (oauthManager.getAccessTokenObjectStore().contains(((String) key))) {
            state = ((GmailConnectorOAuthState) oauthManager.getAccessTokenObjectStore().retrieve(((String) key)));
            oauthManager.getAccessTokenObjectStore().remove(((String) key));
        }
        if (state == null) {
            state = new GmailConnectorOAuthState();
        }
        state.setAccessToken(((GmailConnectorOAuth2Adapter) obj).getAccessToken());
        state.setAccessTokenUrl(((GmailConnectorOAuth2Adapter) obj).getAccessTokenUrl());
        state.setAuthorizationUrl(((GmailConnectorOAuth2Adapter) obj).getAuthorizationUrl());
        state.setRefreshToken(((GmailConnectorOAuth2Adapter) obj).getRefreshToken());
        oauthManager.getAccessTokenObjectStore().store(((String) key), state);
    }

}
