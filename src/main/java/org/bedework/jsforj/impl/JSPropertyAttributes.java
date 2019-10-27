/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.impl.values.factories.JSAlertFactory;
import org.bedework.jsforj.impl.values.factories.JSAlertsFactory;
import org.bedework.jsforj.impl.values.factories.JSCalendarObjectFactory;
import org.bedework.jsforj.impl.values.factories.JSEntriesFactory;
import org.bedework.jsforj.impl.values.factories.JSIdsFactory;
import org.bedework.jsforj.impl.values.factories.JSLinkFactory;
import org.bedework.jsforj.impl.values.factories.JSLinksFactory;
import org.bedework.jsforj.impl.values.factories.JSLocationFactory;
import org.bedework.jsforj.impl.values.factories.JSLocationsFactory;
import org.bedework.jsforj.impl.values.factories.JSParticipantFactory;
import org.bedework.jsforj.impl.values.factories.JSParticipantProgressFactory;
import org.bedework.jsforj.impl.values.factories.JSParticipantsFactory;
import org.bedework.jsforj.impl.values.factories.JSRecurrenceRuleFactory;
import org.bedework.jsforj.impl.values.factories.JSRelationFactory;
import org.bedework.jsforj.impl.values.factories.JSRelationsFactory;
import org.bedework.jsforj.impl.values.factories.JSTimeZoneFactory;
import org.bedework.jsforj.impl.values.factories.JSTimeZoneRuleFactory;
import org.bedework.jsforj.impl.values.factories.JSTriggerFactory;
import org.bedework.jsforj.impl.values.factories.JSVirtualLocationFactory;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Mappings for property names to types and valid objects
 *
 * User: mike Date: 10/23/19 Time: 16:53
 */
public class JSPropertyAttributes {
  public static class PropertyInfo {
    final String name;
    private final List<String> types;

    public PropertyInfo(final String name,
                        final String... types) {
      this.name = name;
      this.types = List.of(types);
    }

    public String getName() {
      return name;
    }

    public List<String> getTypes() {
      return types;
    }
  }

  public static class TypeInfo {
    final String name;
    private final boolean valueList;
    private final boolean propertyList;
    private final String[] elementType;
    private final boolean object;
    private final Class<? extends JSValueFactory> factoryClass;

    TypeInfo(final String name,
             final boolean valueList,
             final boolean propertyList,
             final String[] elementType,
             final boolean object,
             final Class<? extends JSValueFactory> factoryClass) {
      this.name = name;
      this.valueList = valueList;
      this.propertyList = propertyList;
      this.elementType = elementType;
      this.object = object;
      this.factoryClass = factoryClass;
    }

    public String getName() {
      return name;
    }

    public boolean getValueList() {
      return valueList;
    }

    public boolean getPropertyList() {
      return propertyList;
    }

    public boolean getBoolean() {
      return name.equals(JSTypes.typeBoolean);
    }

    public boolean getString() {
      return name.equals(JSTypes.typeString);
    }

    public String[] getElementType() {
      return elementType;
    }

    public boolean getObject() {
      return object;
    }

    /**
     *
     * @return class used to create objects - maybe the class represented here
     *               or elements of the property list.
     */
    public Class getFactoryClass() {
      return factoryClass;
    }
  }

  // Type info for properties
  private static Map<String, PropertyInfo> ptypes = new HashMap<>();

  // Type info for types
  private static Map<String, TypeInfo> types = new HashMap<>();

  private static Map<String, List<String>> validFor = new HashMap<>();

  private static Map<String, List<String>> contains = new HashMap<>();

  static {
    ptype(JSPropertyNames.type,
          JSTypes.typeString);

    ptype(JSPropertyNames.acknowledged,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.action,
          JSTypes.typeString);

    ptype(JSPropertyNames.alerts,
          JSTypes.typeAlerts);

    ptype(JSPropertyNames.categories,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.cid,
          JSTypes.typeString);

    ptype(JSPropertyNames.color,
          JSTypes.typeString);

    ptype(JSPropertyNames.contentType,
          JSTypes.typeString);

    ptype(JSPropertyNames.coordinates,
          JSTypes.typeString);

    ptype(JSPropertyNames.created,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.delegatedFrom,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.delegatedTo,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.description,
          JSTypes.typeString);

    ptype(JSPropertyNames.descriptionContentType,
          JSTypes.typeString);

    ptype(JSPropertyNames.display,
          JSTypes.typeString);

    ptype(JSPropertyNames.due,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.duration,
          JSTypes.typeDuration);

    ptype(JSPropertyNames.email,
          JSTypes.typeString);

    ptype(JSPropertyNames.entries,
          JSTypes.typeEntries);

    ptype(JSPropertyNames.estimatedDuration,
          JSTypes.typeDuration);

    ptype(JSPropertyNames.excluded,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.expectReply,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.freeBusyStatus,
          JSTypes.typeString);

    ptype(JSPropertyNames.href,
          JSTypes.typeString);

    ptype(JSPropertyNames.invitedBy,
          JSTypes.typeString);

    ptype(JSPropertyNames.keywords,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.kind,
          JSTypes.typeString);

    ptype(JSPropertyNames.language,
          JSTypes.typeString);

    ptype(JSPropertyNames.linkIds,
          JSTypes.typeIds);

    ptype(JSPropertyNames.links,
          JSTypes.typeLinks);

    ptype(JSPropertyNames.locale,
          JSTypes.typeString);

    ptype(JSPropertyNames.localizations,
          JSTypes.typeLocalizations);

    ptype(JSPropertyNames.locationId,
          JSTypes.typeString);

    ptype(JSPropertyNames.locations,
          JSTypes.typeLocations);

    ptype(JSPropertyNames.locationType,
          JSTypes.typeString);

    ptype(JSPropertyNames.memberOf,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.method,
          JSTypes.typeString);

    ptype(JSPropertyNames.name,
          JSTypes.typeString);

    ptype(JSPropertyNames.offset,
          JSTypes.typeSignedDuration);

    ptype(JSPropertyNames.participants,
          JSTypes.typeParticipants);

    ptype(JSPropertyNames.participationComment,
          JSTypes.typeString);

    ptype(JSPropertyNames.participationStatus,
          JSTypes.typeString);

    ptype(JSPropertyNames.priority,
          JSTypes.typeInt);

    ptype(JSPropertyNames.privacy,
          JSTypes.typeString);

    ptype(JSPropertyNames.prodId,
          JSTypes.typeString);

    ptype(JSPropertyNames.recurrenceId,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.recurrenceOverrides,
          JSTypes.typeRecurrenceOverrides);

    ptype(JSPropertyNames.recurrenceRule,
          JSTypes.typeRecurrenceRule);

    ptype(JSPropertyNames.rel,
          JSTypes.typeString);

    ptype(JSPropertyNames.relatedTo,
          JSTypes.typeRelations);

    ptype(JSPropertyNames.relation,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.relativeTo,
          JSTypes.typeString);

    ptype(JSPropertyNames.replyTo,
          JSTypes.typeStringStrings);

    ptype(JSPropertyNames.roles,
          JSTypes.typeStrings);

    ptype(JSPropertyNames.scheduleAgent,
          JSTypes.typeString);

    ptype(JSPropertyNames.scheduleSequence,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.scheduleUpdated,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.sendTo,
          JSTypes.typeStringStrings);

    ptype(JSPropertyNames.sequence,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.showWithoutTime,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.size,
          JSTypes.typeUnsignedInt);

    ptype(JSPropertyNames.start,
          JSTypes.typeLocalDateTime);

    ptype(JSPropertyNames.source,
          JSTypes.typeString);

    ptype(JSPropertyNames.status,
          JSTypes.typeString);

    ptype(JSPropertyNames.statusUpdatedAt,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.timestamp,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.timeZone,
          JSTypes.typeString);

    ptype(JSPropertyNames.timeZones,
          JSTypes.typeTimeZones);

    ptype(JSPropertyNames.title,
          JSTypes.typeString);

    ptype(JSPropertyNames.trigger,
          JSTypes.typeUnknownTrigger);

    ptype(JSPropertyNames.uid,
          JSTypes.typeString);

    ptype(JSPropertyNames.updated,
          JSTypes.typeUTCDateTime);

    ptype(JSPropertyNames.useDefaultAlerts,
          JSTypes.typeBoolean);

    ptype(JSPropertyNames.virtualLocations,
          JSTypes.typeVirtualLocations);

    ptype(JSPropertyNames.when,
          JSTypes.typeUTCDateTime);

    /* ===== info for types ======================= */

    type(JSTypes.typeAlert,
         false, // valueList
         false, // propertyList
         types(JSTypes.typeAlert), // elementType
         true, // object
         JSAlertFactory.class); // factoryClass

    type(JSTypes.typeAlerts,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeAlert), // elementType
         false, // object
         JSAlertsFactory.class); // factoryClass

    type(JSTypes.typeBoolean,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeDuration,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeEntries,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeJSEvent, JSTypes.typeJSTask),// elementType
         false, // object
         JSEntriesFactory.class); // factoryClass

    type(JSTypes.typeId,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeIds,
         true, // valueList
         false, // propertyList
         types(JSTypes.typeId), // elementType
         false, // object
         JSIdsFactory.class); // factoryClass

    type(JSTypes.typeInt,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeJSEvent,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSCalendarObjectFactory.class); // factoryClass

    type(JSTypes.typeJSTask,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSCalendarObjectFactory.class); // factoryClass

    type(JSTypes.typeLink,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSLinkFactory.class); // factoryClass

    type(JSTypes.typeLinks,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeLink), // elementType
         false, // object
         JSLinksFactory.class); // factoryClass

    type(JSTypes.typeLocalDateTime,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeLocalizations,
         false, // valueList
         true, // propertyList
         types(JSTypes.typePatchObject), // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeLocation,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSLocationFactory.class); // factoryClass

    type(JSTypes.typeLocations,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeLocation), // elementType
         false, // object
         JSLocationsFactory.class); // factoryClass

    type(JSTypes.typeOffsetTrigger,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeParticipant,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSParticipantFactory.class); // factoryClass

    type(JSTypes.typeParticipantProgress,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSParticipantProgressFactory.class); // factoryClass

    type(JSTypes.typeParticipants,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeParticipant), // elementType
         false, // object
         JSParticipantsFactory.class); // factoryClass

    type(JSTypes.typePatchObject,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         null); // factoryClass

    type(JSTypes.typeRecurrenceOverrides,
         false, // valueList
         true, // propertyList
         types(JSTypes.typePatchObject), // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeRecurrenceRule,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSRecurrenceRuleFactory.class); // factoryClass

    type(JSTypes.typeRelation,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSRelationFactory.class); // factoryClass

    type(JSTypes.typeRelations,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeRelation), // elementType
         false, // object
         JSRelationsFactory.class); // factoryClass

    type(JSTypes.typeSignedDuration,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeString,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeStrings,
         true, // valueList
         false, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeStringStrings,
         true, // valueList
         false, // propertyList
         types(JSTypes.typeString), // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeTimeZone,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTimeZoneFactory.class); // factoryClass

    type(JSTypes.typeTimeZoneRule,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTimeZoneRuleFactory.class); // factoryClass

    type(JSTypes.typeTimeZones,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeTimeZone), // elementType
         false, // object
         JSTimeZoneFactory.class); // factoryClass

    type(JSTypes.typeUnknownTrigger,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeUnsignedInt,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeUTCDateTime,
         false, // valueList
         false, // propertyList
         null, // elementType
         false, // object
         null); // factoryClass

    type(JSTypes.typeAbsoluteTrigger,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSTriggerFactory.class); // factoryClass

    type(JSTypes.typeVirtualLocation,
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         JSVirtualLocationFactory.class); // factoryClass

    type(JSTypes.typeVirtualLocations,
         false, // valueList
         true, // propertyList
         types(JSTypes.typeVirtualLocation), // elementType
         false, // object
         JSVirtualLocationFactory.class); // factoryClass

    /* ===== valid for ============================== */

    validFor(JSPropertyNames.type, JSTypes.typeJSEvent, JSTypes.typeJSTask,
             JSTypes.typeJSGroup, JSTypes.typeAbsoluteTrigger,
             JSTypes.typeAlert, JSTypes.typeLink,
             JSTypes.typeLocation, JSTypes.typeOffsetTrigger,
             JSTypes.typeParticipant, JSTypes.typeParticipantProgress,
             JSTypes.typeRecurrenceRule, JSTypes.typeRelation,
             JSTypes.typeTimeZone, JSTypes.typeVirtualLocation);

    validFor(JSPropertyNames.acknowledged, JSTypes.typeAlert);

    validFor(JSPropertyNames.action, JSTypes.typeAlert);

    validFor(JSPropertyNames.alerts,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.categories,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup,
             JSTypes.typeLocation);
    validFor(JSPropertyNames.cid, JSTypes.typeLink);
    validFor(JSPropertyNames.color,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.contentType, JSTypes.typeLink);
    validFor(JSPropertyNames.coordinates, JSTypes.typeLocation);
    validFor(JSPropertyNames.created ,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.delegatedFrom, JSTypes.typeParticipant);
    validFor(JSPropertyNames.delegatedTo, JSTypes.typeParticipant);
    validFor(JSPropertyNames.description,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeLocation,
             JSTypes.typeVirtualLocation);
    validFor(JSPropertyNames.descriptionContentType, JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.display, JSTypes.typeLink);
    validFor(JSPropertyNames.due,  JSTypes.typeJSTask);
    validFor(JSPropertyNames.duration,  JSTypes.typeJSEvent);
    validFor(JSPropertyNames.email, JSTypes.typeParticipant);
    validFor(JSPropertyNames.entries, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.estimatedDuration,  JSTypes.typeJSTask);
    validFor(JSPropertyNames.excluded,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.expectReply, JSTypes.typeParticipant);
    validFor(JSPropertyNames.freeBusyStatus,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.href, JSTypes.typeLink);
    validFor(JSPropertyNames.invitedBy, JSTypes.typeParticipant);
    validFor(JSPropertyNames.keywords,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.kind, JSTypes.typeParticipant);
    validFor(JSPropertyNames.language, JSTypes.typeParticipant);
    validFor(JSPropertyNames.linkIds, JSTypes.typeLocation,
             JSTypes.typeParticipant);
    validFor(JSPropertyNames.localizations,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.locationId, JSTypes.typeParticipant);
    validFor(JSPropertyNames.locations,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.memberOf, JSTypes.typeParticipant);
    validFor(JSPropertyNames.method,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.name, JSTypes.typeLocation,
             JSTypes.typeParticipant);
    validFor(JSPropertyNames.offset, JSTypes.typeOffsetTrigger);
    validFor(JSPropertyNames.participants,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.participationComment, JSTypes.typeParticipant);
    validFor(JSPropertyNames.participationStatus, JSTypes.typeParticipant);
    validFor(JSPropertyNames.priority,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.privacy,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.prodId,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.recurrenceId,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.recurrenceOverrides,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.recurrenceRule,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.rel, JSTypes.typeLink);
    validFor(JSPropertyNames.relatedTo,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeAlert);
    validFor(JSPropertyNames.relation, JSTypes.typeRelation);
    validFor(JSPropertyNames.relativeTo, JSTypes.typeOffsetTrigger,
             JSTypes.typeLocation);
    validFor(JSPropertyNames.replyTo,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.roles, JSTypes.typeParticipant);
    validFor(JSPropertyNames.scheduleAgent, JSTypes.typeParticipant);
    validFor(JSPropertyNames.scheduleSequence, JSTypes.typeParticipant);
    validFor(JSPropertyNames.scheduleUpdated, JSTypes.typeParticipant);
    validFor(JSPropertyNames.sendTo, JSTypes.typeParticipant);
    validFor(JSPropertyNames.sequence,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.showWithoutTime,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.size, JSTypes.typeLink);
    validFor(JSPropertyNames.start,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.source, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.status,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeParticipantProgress);
    validFor(JSPropertyNames.statusUpdatedAt,  JSTypes.typeJSTask);
    validFor(JSPropertyNames.timestamp, JSTypes.typeParticipantProgress);
    validFor(JSPropertyNames.timeZone,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeLocation);
    validFor(JSPropertyNames.timeZones,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.title,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup, JSTypes.typeLink);
    validFor(JSPropertyNames.trigger, JSTypes.typeOffsetTrigger,
             JSTypes.typeAbsoluteTrigger, JSTypes.typeUnknownTrigger,
             JSTypes.typeAlert);
    validFor(JSPropertyNames.uid,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.updated,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSPropertyNames.useDefaultAlerts,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.virtualLocations,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSPropertyNames.when, JSTypes.typeAbsoluteTrigger);

    // Replace all contains values with immutable lists
    for (final var name: contains.keySet()) {
      final var val = contains.get(name);
      if (val != null) {
        contains.put(name, List.copyOf(val));
      }
    }
  }

  private static void ptype(final String name,
                            final String... types) {
    ptypes.put(name, new PropertyInfo(name, types));
  }

  private static void type(final String typeName,
                           final boolean valueList,
                           final boolean propertyList,
                           final String[] elementType,
                           final boolean object,
                           final Class<? extends JSValueFactory> factoryClass) {
    types.put(typeName, new TypeInfo(typeName, valueList, propertyList,
                                     elementType, object, factoryClass));
  }

  private static void validFor(final String name,
                               final String... types) {
    validFor.put(name, List.of(types));

    for (final var type: types) {
      List<String> contained = contains.computeIfAbsent(type,
                                                        k -> new ArrayList<>());
      contained.add(name);
    }
  }

  private static String[] types(final String... types) {
    return types;
  }

  static List<String> getTypes(final String name) {
    final var info = ptypes.get(name);

    if (info == null) {
      return null;
    }

    return info.getTypes();
  }

  /**
   *
   * @param name of property
   * @return type information - null if unknown property
   */
  public static PropertyInfo getPropertyTypeInfo(final String name) {
    return ptypes.get(name);
  }

  /**
   *
   * @param name of type
   * @return type information - null if unknown type
   */
  public static TypeInfo getTypeInfo(final String name) {
    return types.get(name);
  }

  static List<String> getValidFor(final String name) {
    return validFor.get(name);
  }

  static List<String> getContained(final String name) {
    return contains.get(name);
  }
}
