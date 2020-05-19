/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.collections.JSParticipants;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class JSParticipantsImpl
        extends JSListImpl<JSProperty<JSParticipant>>
        implements JSParticipants {
  public JSParticipantsImpl(final String type,
                            final JsonNode node) {
    super(type, node);
  }

  @Override
  protected void store(final JSProperty<JSParticipant> val) {
    final String id = val.getName();
    if (id == null) {
      throw new RuntimeException(
              "Id must be set for a participant");
    }

    addProperty(val);
  }

  @Override
  protected String fieldName(final JSProperty<JSParticipant> val) {
    return val.getName();
  }

  @Override
  protected JSProperty<JSParticipant> convertToT(final String val) {
    return getFactory().makeProperty(val,
                                     JSTypes.typeParticipant,
                                     getNode().get(val));
  }

  @Override
  public JSProperty<JSParticipant> makeParticipant() {
    return makeParticipant(UUID.randomUUID().toString());
  }

  @Override
  public JSProperty<JSParticipant> makeParticipant(final String id) {
    final JSProperty<JSParticipant> p =
            getFactory().makeProperty(id,
                                      JSTypes.typeParticipant,
                                      null);
    add(p);

    return p;
  }
}
