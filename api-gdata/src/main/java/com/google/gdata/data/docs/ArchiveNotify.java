/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.data.docs;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * Email address to notify of archive completion.
 *
 * 
 */
@ExtensionDescription.Default(
    nsAlias = DocsNamespace.DOCS_ALIAS,
    nsUri = DocsNamespace.DOCS,
    localName = ArchiveNotify.XML_NAME)
public class ArchiveNotify extends ValueConstruct {

  /** XML element name */
  static final String XML_NAME = "archiveNotify";

  /**
   * Default mutable constructor.
   */
  public ArchiveNotify() {
    this(null);
  }

  /**
   * Constructor (mutable or immutable).
   *
   * @param value immutable value or <code>null</code> for a mutable value
   */
  public ArchiveNotify(String value) {
    super(DocsNamespace.DOCS_NS, XML_NAME, null, value);
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
        ExtensionDescription.getDefaultDescription(ArchiveNotify.class);
    desc.setRequired(required);
    desc.setRepeatable(repeatable);
    return desc;
  }

  @Override
  public String toString() {
    return "{ArchiveNotify value=" + getValue() + "}";
  }

}

