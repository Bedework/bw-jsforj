/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.values.collections;

import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.collections.JSLinks;

import com.fasterxml.jackson.databind.JsonNode;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mike Date: 5/4/20 Time: 23:30
 */
public class JSLinksImpl
        extends JSIdMapImpl<String, JSLink>
        implements JSLinks {
  public JSLinksImpl(final String type,
                     final JsonNode node) {
    super(type, node);
  }

  @Override
  protected String getPropertyType() {
    return JSTypes.typeLink;
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
  public List<JSProperty<JSLink>> getAll(final String rel) {
    final List<JSProperty<JSLink>> res = new ArrayList<>();

    for (final JSProperty<JSLink> prop: get()) {
      if (rel.equals(prop.getValue().getRel())) {
        res.add(prop);
      }
    }

    return res;
  }

  @Override
  public JSProperty<JSLink> makeLink() {
    return makeEntry(nextId());
  }

  @Override
  public JSProperty<JSLink> findLink(final URI href) {
    for (final JSProperty<JSLink> prop: get()) {
      final var hrefVal = prop.getValue().getHref(false);

      if (hrefVal == null) {
        continue;
      }

      if (href.equals(hrefVal.get())) {
        return prop;
      }
    }

    return null;
  }
}
