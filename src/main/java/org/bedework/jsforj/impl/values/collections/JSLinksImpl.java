/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.collections.JSLinks;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 5/4/20 Time: 23:30
 */
public class JSLinksImpl extends JSListImpl<JSProperty> implements
        JSLinks {
  public JSLinksImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  protected void store(final JSProperty val) {
    addProperty(val);
  }

  @Override
  protected String fieldName(final JSProperty val) {
    return val.getName();
  }

  @Override
  protected JSProperty convertToT(final String val) {
    return getFactory().makeProperty(val,
                                     JSTypes.typeLink,
                                     getNode().get(val));
  }

  @Override
  public JSProperty makeLink(final String href) {
    final JSProperty p =
            getFactory().makeProperty(href,
                                      JSTypes.typeLink,
                                      null);

    p.getValue().setProperty(
            factory.makeProperty(JSPropertyNames.href, href));
    add(p);

    return p;
  }

  @Override
  public List<JSLink> getAll(final String rel) {
    final List<JSLink> res = new ArrayList<>();

    for (final JSProperty prop: get()) {
      final String prel = prop.getValue()
                              .getStringProperty(JSPropertyNames.rel);
      if (rel.equals(prel)) {
        res.add((JSLink)prop.getValue());
      }
    }

    return res;
  }
}
