/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl.properties.factories;

import org.bedework.jsforj.impl.properties.JSAlertImpl;
import org.bedework.jsforj.model.JSProperty;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class JSAlertFactory extends JSPropertyFactoryImpl {
  @Override
  public JSProperty newProperty(final String name,
                                final JsonNode nd) {
    return new JSAlertImpl(name,
                           factory.makeValue(name, nd));
  }
}
