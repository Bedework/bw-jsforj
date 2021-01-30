package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.impl.properties.JSPropertyImpl;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.values.JSPatchObject;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.dataTypes.JSUnsignedInteger;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
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

  @Override
  public void setNull(final String... names) {
    setProperty(new JSPropertyImpl<>(makePath(names), new JSNullImpl()));
  }

  @Override
  public JSProperty<?> setOverrideProperty(final JSValue val,
                                           final String... names) {
    return setProperty(makePath(names), val);
  }

  @Override
  public JSProperty<?> setOverrideProperty(final String val,
                                           final String... names) {
    return setProperty(makePath(names), val);
  }

  @Override
  public JSProperty<?> setOverrideProperty(
          final JSUnsignedInteger val,
          final String... names) {
    return setProperty(makePath(names), val);
  }

  @Override
  public JSProperty<?> setOverrideProperty(final boolean val,
                                           final String... names) {
    return setProperty(makePath(names), val);
  }

  @Override
  public <T extends JSValue> JSProperty<T> newOverrideProperty(
          final TypeReference<T> typeRef, final String type,
          final String... names) {
    return newProperty(typeRef, makePath(names), type);
  }

  protected String makePath(final String... names) {
    if ((names == null) || (names.length == 0)) {
      throw new RuntimeException("Empty path");
    }

    JsonPointer ptr = JsonPointer.compile(null);

    for (final var n: names) {
      ptr = ptr.append(JsonPointer.compile("/" + n));
    }

    return ptr.toString();
  }
}
