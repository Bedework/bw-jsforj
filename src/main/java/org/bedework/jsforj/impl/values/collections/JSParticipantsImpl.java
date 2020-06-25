/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.collections.JSParticipants;
import org.bedework.util.misc.Util;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSParticipantsImpl
        extends JSMapImpl<String, JSParticipant>
        implements JSParticipants {
  public JSParticipantsImpl(final String type,
                            final JsonNode node) {
    super(type, node);
  }

  @Override
  protected String getPropertyType() {
    return JSTypes.typeParticipant;
  }

  @Override
  protected String convertKey(final String key) {
    return key;
  }

  @Override
  protected String convertFieldName(final String fieldName) {
    return fieldName;
  }

  @Override
  public JSProperty<JSParticipant> makeParticipant() {
    return makeEntry(UUID.randomUUID().toString());
  }

  @Override
  public JSProperty<JSParticipant> findParticipant(final String cua) {
    for (final var partp: get()) {
      final var sendTos = partp.getValue().getSendTo(false);
      if (sendTos == null) {
        continue;
      }

      for (final var sendTo: sendTos.get()) {
        if (Util.compareStrings(cua, sendTo.getValue().get()) == 0) {
          return partp;
        }
      }
    }

    return null;
  }
}
