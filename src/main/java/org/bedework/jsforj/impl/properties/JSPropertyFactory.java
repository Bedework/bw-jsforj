package org.bedework.jsforj.impl.properties;

import org.bedework.jsforj.model.JSProperty;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:32
 */
public abstract class JSPropertyFactory {
  public abstract JSProperty newProperty(final String name,
                                         final JsonNode nd);
}
