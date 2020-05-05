package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.values.JSPatchObject;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 4/21/20 Time: 18:36
 */
public class JSPatchObjectImpl extends JSCalendarObjectImpl
        implements JSPatchObject {
  public JSPatchObjectImpl(final String type,
                           final JsonNode node) {
    super(type, node);
  }
}
