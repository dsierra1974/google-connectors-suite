
package org.mule.module.gmail.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.google.code.javax.mail.search.SearchTerm;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.process.ProcessAdapter;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.config.i18n.CoreMessages;
import org.mule.module.gmail.BaseGmailConnector;
import org.mule.module.gmail.model.GmailFolder;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;


/**
 * AdvancedSearchMessageProcessor invokes the {@link org.mule.module.gmail.BaseGmailConnector#advancedSearch(java.lang.String, org.mule.module.gmail.model.GmailFolder, com.google.code.javax.mail.search.SearchTerm, java.lang.Boolean)} method in {@link BaseGmailConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class AdvancedSearchMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object username;
    protected String _usernameType;
    protected Object folder;
    protected GmailFolder _folderType;
    protected Object searchTerm;
    protected SearchTerm _searchTermType;
    protected Object expunge;
    protected Boolean _expungeType;

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    public void start()
        throws MuleException
    {
    }

    public void stop()
        throws MuleException
    {
    }

    public void dispose() {
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        super.setFlowConstruct(flowConstruct);
    }

    /**
     * Sets folder
     * 
     * @param value Value to set
     */
    public void setFolder(Object value) {
        this.folder = value;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(Object value) {
        this.username = value;
    }

    /**
     * Sets searchTerm
     * 
     * @param value Value to set
     */
    public void setSearchTerm(Object value) {
        this.searchTerm = value;
    }

    /**
     * Sets expunge
     * 
     * @param value Value to set
     */
    public void setExpunge(Object value) {
        this.expunge = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(final MuleEvent event)
        throws MuleException
    {
        try {
            findOrCreate(ProcessAdapter.class, false, event);
            final String _transformedUsername = ((String) evaluateAndTransform(getMuleContext(), event, AdvancedSearchMessageProcessor.class.getDeclaredField("_usernameType").getGenericType(), null, username));
            final GmailFolder _transformedFolder = ((GmailFolder) evaluateAndTransform(getMuleContext(), event, AdvancedSearchMessageProcessor.class.getDeclaredField("_folderType").getGenericType(), null, folder));
            final SearchTerm _transformedSearchTerm = ((SearchTerm) evaluateAndTransform(getMuleContext(), event, AdvancedSearchMessageProcessor.class.getDeclaredField("_searchTermType").getGenericType(), null, searchTerm));
            final Boolean _transformedExpunge = ((Boolean) evaluateAndTransform(getMuleContext(), event, AdvancedSearchMessageProcessor.class.getDeclaredField("_expungeType").getGenericType(), null, expunge));
            Object resultPayload;
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) getModuleObject()).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class> getManagedExceptions() {
                    return Arrays.asList(new Class[] {OAuthTokenExpiredException.class });
                }

                public boolean isProtected() {
                    return true;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((BaseGmailConnector) object).advancedSearch(_transformedUsername, _transformedFolder, _transformedSearchTerm, _transformedExpunge);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("advancedSearch"), event, e);
        }
    }

}
