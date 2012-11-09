
package org.mule.module.gmail.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
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
import org.mule.module.gmail.search.FlagCriteria;
import org.mule.module.gmail.search.SearchCriteria;
import org.mule.modules.google.oauth.invalidation.OAuthTokenExpiredException;


/**
 * SearchMessageProcessor invokes the {@link org.mule.module.gmail.BaseGmailConnector#search(java.lang.String, org.mule.module.gmail.model.GmailFolder, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.Integer, org.mule.module.gmail.search.SearchCriteria, java.util.List, java.util.List, java.util.List, java.lang.String, java.util.List, java.util.List, java.lang.String, java.util.List, java.lang.String, java.lang.Boolean)} method in {@link BaseGmailConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class SearchMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object username;
    protected String _usernameType;
    protected Object folder;
    protected GmailFolder _folderType;
    protected Object receivedBefore;
    protected String _receivedBeforeType;
    protected Object receivedAfter;
    protected String _receivedAfterType;
    protected Object sentBefore;
    protected String _sentBeforeType;
    protected Object sentAfter;
    protected String _sentAfterType;
    protected Object fromAddresses;
    protected List<String> _fromAddressesType;
    protected Object toAddresses;
    protected List<String> _toAddressesType;
    protected Object messageNumber;
    protected Integer _messageNumberType;
    protected Object size;
    protected SearchCriteria _sizeType;
    protected Object flags;
    protected List<FlagCriteria> _flagsType;
    protected Object labels;
    protected List<String> _labelsType;
    protected Object rawSearchTerms;
    protected List<String> _rawSearchTermsType;
    protected Object threadId;
    protected String _threadIdType;
    protected Object bodyTerms;
    protected List<String> _bodyTermsType;
    protected Object headerTerms;
    protected List<String> _headerTermsType;
    protected Object messageId;
    protected String _messageIdType;
    protected Object subjectTerms;
    protected List<String> _subjectTermsType;
    protected Object dateFormat;
    protected String _dateFormatType;
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
     * Sets receivedBefore
     * 
     * @param value Value to set
     */
    public void setReceivedBefore(Object value) {
        this.receivedBefore = value;
    }

    /**
     * Sets flags
     * 
     * @param value Value to set
     */
    public void setFlags(Object value) {
        this.flags = value;
    }

    /**
     * Sets threadId
     * 
     * @param value Value to set
     */
    public void setThreadId(Object value) {
        this.threadId = value;
    }

    /**
     * Sets subjectTerms
     * 
     * @param value Value to set
     */
    public void setSubjectTerms(Object value) {
        this.subjectTerms = value;
    }

    /**
     * Sets labels
     * 
     * @param value Value to set
     */
    public void setLabels(Object value) {
        this.labels = value;
    }

    /**
     * Sets sentAfter
     * 
     * @param value Value to set
     */
    public void setSentAfter(Object value) {
        this.sentAfter = value;
    }

    /**
     * Sets bodyTerms
     * 
     * @param value Value to set
     */
    public void setBodyTerms(Object value) {
        this.bodyTerms = value;
    }

    /**
     * Sets size
     * 
     * @param value Value to set
     */
    public void setSize(Object value) {
        this.size = value;
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
     * Sets toAddresses
     * 
     * @param value Value to set
     */
    public void setToAddresses(Object value) {
        this.toAddresses = value;
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
     * Sets sentBefore
     * 
     * @param value Value to set
     */
    public void setSentBefore(Object value) {
        this.sentBefore = value;
    }

    /**
     * Sets headerTerms
     * 
     * @param value Value to set
     */
    public void setHeaderTerms(Object value) {
        this.headerTerms = value;
    }

    /**
     * Sets receivedAfter
     * 
     * @param value Value to set
     */
    public void setReceivedAfter(Object value) {
        this.receivedAfter = value;
    }

    /**
     * Sets messageNumber
     * 
     * @param value Value to set
     */
    public void setMessageNumber(Object value) {
        this.messageNumber = value;
    }

    /**
     * Sets dateFormat
     * 
     * @param value Value to set
     */
    public void setDateFormat(Object value) {
        this.dateFormat = value;
    }

    /**
     * Sets rawSearchTerms
     * 
     * @param value Value to set
     */
    public void setRawSearchTerms(Object value) {
        this.rawSearchTerms = value;
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
     * Sets messageId
     * 
     * @param value Value to set
     */
    public void setMessageId(Object value) {
        this.messageId = value;
    }

    /**
     * Sets fromAddresses
     * 
     * @param value Value to set
     */
    public void setFromAddresses(Object value) {
        this.fromAddresses = value;
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
            final String _transformedUsername = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_usernameType").getGenericType(), null, username));
            final GmailFolder _transformedFolder = ((GmailFolder) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_folderType").getGenericType(), null, folder));
            final String _transformedReceivedBefore = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_receivedBeforeType").getGenericType(), null, receivedBefore));
            final String _transformedReceivedAfter = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_receivedAfterType").getGenericType(), null, receivedAfter));
            final String _transformedSentBefore = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_sentBeforeType").getGenericType(), null, sentBefore));
            final String _transformedSentAfter = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_sentAfterType").getGenericType(), null, sentAfter));
            final List<String> _transformedFromAddresses = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_fromAddressesType").getGenericType(), null, fromAddresses));
            final List<String> _transformedToAddresses = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_toAddressesType").getGenericType(), null, toAddresses));
            final Integer _transformedMessageNumber = ((Integer) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_messageNumberType").getGenericType(), null, messageNumber));
            final SearchCriteria _transformedSize = ((SearchCriteria) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_sizeType").getGenericType(), null, size));
            final List<FlagCriteria> _transformedFlags = ((List<FlagCriteria> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_flagsType").getGenericType(), null, flags));
            final List<String> _transformedLabels = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_labelsType").getGenericType(), null, labels));
            final List<String> _transformedRawSearchTerms = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_rawSearchTermsType").getGenericType(), null, rawSearchTerms));
            final String _transformedThreadId = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_threadIdType").getGenericType(), null, threadId));
            final List<String> _transformedBodyTerms = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_bodyTermsType").getGenericType(), null, bodyTerms));
            final List<String> _transformedHeaderTerms = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_headerTermsType").getGenericType(), null, headerTerms));
            final String _transformedMessageId = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_messageIdType").getGenericType(), null, messageId));
            final List<String> _transformedSubjectTerms = ((List<String> ) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_subjectTermsType").getGenericType(), null, subjectTerms));
            final String _transformedDateFormat = ((String) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_dateFormatType").getGenericType(), null, dateFormat));
            final Boolean _transformedExpunge = ((Boolean) evaluateAndTransform(getMuleContext(), event, SearchMessageProcessor.class.getDeclaredField("_expungeType").getGenericType(), null, expunge));
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
                    return ((BaseGmailConnector) object).search(_transformedUsername, _transformedFolder, _transformedReceivedBefore, _transformedReceivedAfter, _transformedSentBefore, _transformedSentAfter, _transformedFromAddresses, _transformedToAddresses, _transformedMessageNumber, _transformedSize, _transformedFlags, _transformedLabels, _transformedRawSearchTerms, _transformedThreadId, _transformedBodyTerms, _transformedHeaderTerms, _transformedMessageId, _transformedSubjectTerms, _transformedDateFormat, _transformedExpunge);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("search"), event, e);
        }
    }

}
