/**
 * Mule Google Api Commons
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.atom.Category;
import com.google.gdata.model.atom.Feed;
import com.google.gdata.util.Namespaces;

import java.util.List;

/**
 * Describes a message feed.
 *
 * 
 */
public class MessageFeed extends Feed {

  /**
   * Message kind term value.
   */
  public static final String KIND = Namespaces.gPrefix + "message";

  /**
   * Message kind category.
   */
  public static final Category CATEGORY = new Category(Namespaces.gKind,
      KIND).lock();

  /**
   * The key for this element.
   */
  @SuppressWarnings("hiding")
  public static final ElementKey<Void,
      MessageFeed> KEY = ElementKey.of(Feed.KEY.getId(), Void.class,
      MessageFeed.class);

  /**
   * Registers the metadata for this element.
   */
  public static void registerMetadata(MetadataRegistry registry) {
    if (registry.isRegistered(KEY)) {
      return;
    }

    // Register superclass metadata.
    Feed.registerMetadata(registry);

    // The builder for this element
    ElementCreator builder = registry.build(KEY);

    // Local properties
    builder.addUndeclaredElementMarker();
    builder.addElement(MessageEntry.KEY);

    // Adaptations from the super type
    registry.adapt(Feed.KEY, KIND, KEY);
  }

  /**
   * Constructs an instance using the default key.
   */
  public MessageFeed() {
    super(KEY);
    addCategory(CATEGORY);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link Feed} instance.
   *
   * @param sourceFeed source feed
   */
  public MessageFeed(Feed sourceFeed) {
    super(KEY, sourceFeed);
  }

  /**
   * Subclass constructor, allows subclasses to supply their own element key.
   */
  protected MessageFeed(ElementKey<?, ? extends MessageFeed> key) {
    super(key);
  }

  /**
   * Constructs a new instance by doing a shallow copy of data from an existing
   * {@link Feed} instance. Will use the given {@link ElementKey} as the key for
   * the element. This constructor is used when adapting from one element key to
   * another. You cannot call this constructor directly, instead use {@link
   * Element#createElement(ElementKey, Element)}.
   *
   * @param key The key to use for this element.
   * @param source source element
   */
  protected MessageFeed(ElementKey<?, ? extends MessageFeed> key, Feed source) {
    super(key, source);
  }

  @Override
  public MessageFeed lock() {
    return (MessageFeed) super.lock();
  }

  @Override
  public List<? extends MessageEntry> getEntries() {
    return getEntries(MessageEntry.KEY);
  }

}


