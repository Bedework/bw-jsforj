/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.JSLinks;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 5/4/20 Time: 23:30
 */
public class JSLinksImpl extends JSValueImpl implements
        JSLinks {
  public JSLinksImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  public void add(final JSLink link) {
    final String href = link.getStringProperty(JSPropertyNames.href);
    if (href == null) {
      throw new RuntimeException("Href must be set for a link");
    }

    setProperty(factory.makeProperty(href, link));
  }

  @Override
  public List<JSLink> getAll() {
    final List<JSLink> res = new ArrayList<>();

    for (final JSProperty prop: getPropertyList()) {
      res.add((JSLink)prop.getValue());
    }

    return res;
  }

  @Override
  public List<JSLink> getAll(final String rel) {
    final List<JSLink> res = new ArrayList<>();

    for (final JSProperty prop: getPropertyList()) {
      final String prel = prop.getValue()
                              .getStringProperty(JSPropertyNames.rel);
      if (rel.equals(prel)) {
        res.add((JSLink)prop.getValue());
      }
    }

    return res;
  }

  @Override
  public void clear() {

  }
}
