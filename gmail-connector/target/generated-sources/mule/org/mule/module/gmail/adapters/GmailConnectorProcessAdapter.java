
package org.mule.module.gmail.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.process.ProcessAdapter;
import org.mule.api.process.ProcessCallback;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.process.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.gmail.GmailConnector;


/**
 * A <code>GmailConnectorProcessAdapter</code> is a wrapper around {@link GmailConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class GmailConnectorProcessAdapter
    extends GmailConnectorLifecycleAdapter
    implements ProcessAdapter<GmailConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, GmailConnectorCapabilitiesAdapter> getProcessTemplate() {
        final GmailConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,GmailConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, GmailConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
