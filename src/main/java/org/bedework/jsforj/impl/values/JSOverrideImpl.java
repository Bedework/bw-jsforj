/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.JsforjException;
import org.bedework.jsforj.impl.JSPropertyNames;
import org.bedework.jsforj.impl.properties.JSPropertyImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSLocalDateTimeImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSNull;
import org.bedework.jsforj.model.values.JSOverride;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import netscape.javascript.JSException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: mike Date: 10/24/19 Time: 17:18
 *
 * We handle an override by taking a complete copy of the master
 * and updating it using the recurrence-id value and any changes
 * in the object.
 *
 * If there are updates to the override they will be reflected in the
 * copy.
 *
 * If we output the result as a patch object we reconstruct the
 * changes from the copy.
 */
public class JSOverrideImpl extends JSPatchObjectImpl
        implements JSOverride {
  private JSCalendarObject master;
  private String recurrencedId;

  /* This is created from the original node so we can access the
     override values.
   */
  private JSCalendarObject overrides;

  public JSOverrideImpl(final String typeName,
                        final JsonNode node) {
    super(typeName, node);
  }

  @Override
  public void setMaster(final JSCalendarObject master) {
    if (this.master != null) {
      throw new JSException("Master already set for override");
    }
    this.master = master;
    this.recurrencedId = getParentProperty().getName();
    makeMasterCopy();
  }

  @Override
  public JSCalendarObject getMaster() {
    return master;
  }

  @Override
  public void markExcluded() {
    setProperty(JSPropertyNames.excluded, true);
  }

  @Override
  public boolean getExcluded() {
    return getBooleanProperty(JSPropertyNames.excluded);
  }

  // -------------------- JsCalendarObject ------------------------ //
  @Override
  public void setUid(final String val) {
    throw new JsforjException("Cannot set uid in patch object");
  }

  @Override
  public String getUid() {
    return getMaster().getUid();
  }

  private final static Set<String> cannotPatch = new TreeSet<>();

  static {
    cannotPatch.add(JSPropertyNames.type); // immutable
    cannotPatch.add(JSPropertyNames.privacy); // immutable
    cannotPatch.add(JSPropertyNames.prodId); // immutable
    cannotPatch.add(JSPropertyNames.recurrenceId); // immutable
    cannotPatch.add(JSPropertyNames.recurrenceOverrides); // immutable
    cannotPatch.add(JSPropertyNames.recurrenceRules); // immutable
    cannotPatch.add(JSPropertyNames.relatedTo); // immutable
    cannotPatch.add(JSPropertyNames.replyTo); // immutable
    cannotPatch.add(JSPropertyNames.uid); // immutable
  }

  private void makeMasterCopy() {
    overrides = new JSCalendarObjectImpl(JSTypes.typeOverride,
                                         getNode());

    // First clone the master
    final var copyNode = ((JSValueImpl)master)
            .getNode().deepCopy();
    setMasterCopy(copyNode);

    final List<JSProperty<?>> patches = new ArrayList<>();
    JSProperty<?> start = null;
    String timezoneId = null;

    for (final var prop: overrides.getProperties()) {
      final var name = prop.getName();

      if (cannotPatch.contains(name)) {
        continue;
      }

      if (prop.getValue() instanceof JSNull) {
        patches.add(prop);
        continue;
      }

      if (name.equals(JSPropertyNames.start)) {
        start = prop;
      }

      if (name.equals(JSPropertyNames.timeZone)) {
        timezoneId = prop.getValue().getStringValue();
      }

      if (name.contains("/")) {
        patches.add(prop);
        continue;
      }

      setProperty(prop);
    }

    for (final var patch: patches) {
      /* We need to apply the patch. We could locate the node
         using json pointer features but we need to locate the
         actual property
       */

      final JSProperty<?> prop = findProperty(patch.getName());
      if (prop == null) {
        throw new JSException("Undefined property " + patch.getName());
      }

      final var parent = prop.getValue()
                             .getOwner()
                             .getParentProperty();

      if (patch.getValue() instanceof JSNull) {
        // Delete
        parent.getValue()
              .removeProperty(prop.getName());
        continue;
      }

      parent.getValue().setProperty(
              new JSPropertyImpl<>(prop.getName(),
                                   patch.getValue().copy()));
    }

    if (start == null) {
      setProperty(factory.makeProperty(
              JSPropertyNames.start,
              new JSLocalDateTimeImpl(getParentProperty().getName())));
    }
  }

  /** Return referenced property
   *
   * @param path path in patch object format
   * @return referenced property or null
   */
  private JSProperty<?> findProperty(final String path) {
    JsonPointer ptr = JsonPointer.compile("/" + path);
    JSProperty<?> prop = getParentProperty();

    // Get the elements.
    final LinkedList<String> elements = new LinkedList<>();
    while (true) {
      final JsonPointer last = ptr.last();
      if (last == null) {
        break;
      }

      elements.push(last.getMatchingProperty());
      ptr = ptr.head();
    }

    while (!elements.isEmpty()) {
      final var pname = elements.pop();
      prop = prop.getValue().getProperty(pname);
      if (prop == null) {
        return null;
      }
    }

    return prop;
  }
}
