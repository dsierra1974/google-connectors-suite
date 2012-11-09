
package org.mule.module.gmail.processors;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public abstract class AbstractConnectedProcessor
    extends AbstractExpressionEvaluator
{

    private Object accessTokenId;
    private String _accessTokenIdType;

    /**
     * Retrieves accessTokenId
     * 
     */
    public Object getAccessTokenId() {
        return this.accessTokenId;
    }

    /**
     * Sets accessTokenId
     * 
     * @param value Value to set
     */
    public void setAccessTokenId(Object value) {
        this.accessTokenId = value;
    }

}
