
package org.mule.module.gmail.config;

import javax.annotation.Generated;
import org.mule.module.gmail.processors.AdvancedSearchMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class AdvancedSearchDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AdvancedSearchMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "folder", "folder");
        if (hasAttribute(element, "searchTerm-ref")) {
            if (element.getAttribute("searchTerm-ref").startsWith("#")) {
                builder.addPropertyValue("searchTerm", element.getAttribute("searchTerm-ref"));
            } else {
                builder.addPropertyValue("searchTerm", (("#[registry:"+ element.getAttribute("searchTerm-ref"))+"]"));
            }
        }
        parseProperty(builder, element, "expunge", "expunge");
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
