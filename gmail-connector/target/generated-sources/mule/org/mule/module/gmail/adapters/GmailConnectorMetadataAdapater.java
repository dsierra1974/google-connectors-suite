
package org.mule.module.gmail.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.module.gmail.GmailConnector;


/**
 * A <code>GmailConnectorMetadataAdapater</code> is a wrapper around {@link GmailConnector } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class GmailConnectorMetadataAdapater
    extends GmailConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "GMail Connector";
    private final static String MODULE_VERSION = "1.0.3-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.3.1";
    private final static String DEVKIT_BUILD = "UNNAMED.1297.150f2c9";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

}
