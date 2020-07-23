package org.bedework.jsforj;

import org.bedework.jsforj.model.values.JSValue;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:32
 */
public abstract class JSValueFactory {
  /**
   *
   * @param typeName for value
   * @param nd never null
   * @return new cvalue
   */
  public abstract JSValue newValue(String typeName,
                                   JsonNode nd);
}
