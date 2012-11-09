
package org.mule.module.gmail.config;

import javax.annotation.Generated;
import org.mule.module.gmail.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.module.gmail.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.module.gmail.processors.SearchMessageProcessor;
import org.mule.module.gmail.search.holders.FlagCriteriaExpressionHolder;
import org.mule.module.gmail.search.holders.SearchCriteriaExpressionHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class SearchDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(SearchMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "username", "username");
        parseProperty(builder, element, "folder", "folder");
        parseProperty(builder, element, "receivedBefore", "receivedBefore");
        parseProperty(builder, element, "receivedAfter", "receivedAfter");
        parseProperty(builder, element, "sentBefore", "sentBefore");
        parseProperty(builder, element, "sentAfter", "sentAfter");
        parseListAndSetProperty(element, builder, "fromAddresses", "from-addresses", "from-address", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseListAndSetProperty(element, builder, "toAddresses", "to-addresses", "to-address", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseProperty(builder, element, "messageNumber", "messageNumber");
        if (!parseObjectRef(element, builder, "size", "size")) {
            BeanDefinitionBuilder sizeBuilder = BeanDefinitionBuilder.rootBeanDefinition(SearchCriteriaExpressionHolder.class.getName());
            Element sizeChildElement = DomUtils.getChildElementByTagName(element, "size");
            if (sizeChildElement!= null) {
                parseProperty(sizeBuilder, sizeChildElement, "operator", "operator");
                parseProperty(sizeBuilder, sizeChildElement, "value", "value");
                builder.addPropertyValue("size", sizeBuilder.getBeanDefinition());
            }
        }
        parseListAndSetProperty(element, builder, "flags", "flags", "flag", new ParseDelegate<BeanDefinition>() {


            public BeanDefinition parse(Element element) {
                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(FlagCriteriaExpressionHolder.class);
                parseProperty(builder, element, "set", "set");
                parseProperty(builder, element, "flag", "flag");
                return builder.getBeanDefinition();
            }

        }
        );
        parseListAndSetProperty(element, builder, "labels", "labels", "label", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseListAndSetProperty(element, builder, "rawSearchTerms", "raw-search-terms", "raw-search-term", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseProperty(builder, element, "threadId", "threadId");
        parseListAndSetProperty(element, builder, "bodyTerms", "body-terms", "body-term", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseListAndSetProperty(element, builder, "headerTerms", "header-terms", "header-term", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseProperty(builder, element, "messageId", "messageId");
        parseListAndSetProperty(element, builder, "subjectTerms", "subject-terms", "subject-term", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        parseProperty(builder, element, "dateFormat", "dateFormat");
        parseProperty(builder, element, "expunge", "expunge");
        parseProperty(builder, element, "accessTokenId");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
