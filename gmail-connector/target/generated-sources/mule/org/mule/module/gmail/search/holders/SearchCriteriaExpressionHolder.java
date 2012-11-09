
package org.mule.module.gmail.search.holders;

import javax.annotation.Generated;
import org.mule.module.gmail.search.SearchOperator;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class SearchCriteriaExpressionHolder {

    protected Object operator;
    protected SearchOperator _operatorType;
    protected Object value;
    protected String _valueType;

    /**
     * Sets operator
     * 
     * @param value Value to set
     */
    public void setOperator(Object value) {
        this.operator = value;
    }

    /**
     * Retrieves operator
     * 
     */
    public Object getOperator() {
        return this.operator;
    }

    /**
     * Sets value
     * 
     * @param value Value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Retrieves value
     * 
     */
    public Object getValue() {
        return this.value;
    }

}
