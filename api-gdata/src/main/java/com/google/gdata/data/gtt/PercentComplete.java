/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.gtt;

import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.AttributeGenerator;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.util.ParseException;

/**
 * Describes a percent complete.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = GttNamespace.GTT_ALIAS,
    nsUri = GttNamespace.GTT,
    localName = PercentComplete.XML_NAME)
public class PercentComplete extends AbstractExtension {

  /** XML element name */
  static final String XML_NAME = "percentComplete";

  /** Value */
  private Integer value = null;

  /**
   * Default mutable constructor.
   */
  public PercentComplete() {
    super();
  }

  /**
   * Immutable constructor.
   *
   * @param value value.
   */
  public PercentComplete(Integer value) {
    super();
    setValue(value);
    setImmutable(true);
  }

  /**
   * Returns the value.
   *
   * @return value
   */
  public Integer getValue() {
    return value;
  }

  /**
   * Sets the value.
   *
   * @param value value or <code>null</code> to reset
   */
  public void setValue(Integer value) {
    throwExceptionIfImmutable();
    this.value = value;
  }

  /**
   * Returns whether it has the value.
   *
   * @return whether it has the value
   */
  public boolean hasValue() {
    return getValue() != null;
  }

  @Override
  protected void validate() {
    if (value == null) {
      throw new IllegalStateException("Missing text content");
    }
  }

  /**
   * Returns the extension description, specifying whether it is required, and
   * whether it is repeatable.
   *
   * @param required   whether it is required
   * @param repeatable whether it is repeatable
   * @return extension description
   */
  public static ExtensionDescription getDefaultDescription(boolean required,
      boolean repeatable) {
    ExtensionDescription desc =
        ExtensionDescription.getDefaultDescription(PercentComplete.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  protected void putAttributes(AttributeGenerator generator) {
    generator.setContent(value.toString());
  }

  @Override
  protected void consumeAttributes(AttributeHelper helper) throws ParseException
      {
    value = helper.consumeInteger(null, true);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!sameClassAs(obj)) {
      return false;
    }
    PercentComplete other = (PercentComplete) obj;
    return eq(value, other.value);
  }

  @Override
  public int hashCode() {
    int result = getClass().hashCode();
    if (value != null) {
      result = 37 * result + value.hashCode();
    }
    return result;
  }

  @Override
  public String toString() {
    return "{PercentComplete value=" + value + "}";
  }

}

