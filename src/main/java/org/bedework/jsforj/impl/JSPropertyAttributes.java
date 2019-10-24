/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

import org.bedework.jsforj.model.JSProperty;
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
  public static class TypeInfo {
    private final boolean valueList;
    private final boolean propertyList;
    private final String elementType;
    private final boolean object;
    private final List<String> types;

    TypeInfo(final String name,
             final boolean valueList,
             final boolean propertyList,
             final String elementType,
             final boolean object,
             final String... types) {
      this.valueList = valueList;
      this.propertyList = propertyList;
      this.elementType = elementType;
      this.object = object;
      this.types = List.of(types);
    }

    public boolean getValueList() {
      return valueList;
    }

    public boolean getPropertyList() {
      return propertyList;
    }

    public String getElementType() {
      return elementType;
    }

    public boolean getObject() {
      return object;
    }

    public List<String> getTypes() {
      return types;
    }
  }

  private static Map<String, TypeInfo> ptypes = new HashMap<>();

  private static Map<String, List<String>> validFor = new HashMap<>();

  private static Map<String, List<String>> contains = new HashMap<>();

  static {
    ptype(JSProperty.type,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.acknowledged,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSProperty.action,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.alerts,
          false, // valueList
          true, // propertyList
          JSTypes.typeAlert, // elementType
          false, // object
          JSTypes.typeAlerts);
    ptype(JSProperty.categories,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.cid,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.color,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.contentType,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.coordinates,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.created,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSProperty.delegatedFrom,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.delegatedTo,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.description,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.descriptionContentType,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.display,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.due,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeLocalDateTime);
    ptype(JSProperty.duration,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeDuration);
    ptype(JSProperty.email,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.entries,
          false, // valueList
          true, // propertyList
          "JSTask|JSEvent", // elementType - special cased
          false, // object
          JSTypes.typeEntries);
    ptype(JSProperty.estimatedDuration,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeDuration);
    ptype(JSProperty.excluded,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSProperty.expectReply,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSProperty.freeBusyStatus,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.href,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.invitedBy,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.keywords,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.kind,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.language,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.linkIds,
          true, // valueList
          false, // propertyList
          JSTypes.typeId, // elementType
          false, // object
          JSTypes.typeIds);
    ptype(JSProperty.localizations,
          false, // valueList
          true, // propertyList
          JSTypes.typePatchObject, // elementType
          false, // object
          JSTypes.typeLocalizations);
    ptype(JSProperty.locationId,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.locations,
          false, // valueList
          true, // propertyList
          JSTypes.typeLocation, // elementType
          false, // object
          JSTypes.typeLocations);
    ptype(JSProperty.memberOf,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.method,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.name,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.offset,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeSignedDuration);
    ptype(JSProperty.participants,
          false, // valueList
          true, // propertyList
          JSTypes.typeParticipant, // elementType
          false, // object
          JSTypes.typeParticipants);
    ptype(JSProperty.participationComment,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.participationStatus,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.priority,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeInt);
    ptype(JSProperty.privacy,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.prodId,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.recurrenceId,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeLocalDateTime);
    ptype(JSProperty.recurrenceOverrides,
          false, // valueList
          true, // propertyList
          JSTypes.typePatchObject, // elementType
          false, // object
          JSTypes.typeRecurrenceOverrides);
    ptype(JSProperty.recurrenceRule,
          false, // valueList
          false, // propertyList
          null, // elementType
          true, // object
          JSTypes.typeRecurrenceRule);
    ptype(JSProperty.rel,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.relatedTo,
          false, // valueList
          true, // propertyList
          JSTypes.typeRelation, // elementType
          false, // object
          JSTypes.typeRelations);
    ptype(JSProperty.relation,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.relativeTo,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.replyTo,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStringStrings);
    ptype(JSProperty.roles,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSProperty.scheduleAgent,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.scheduleSequence,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUnsignedInt);
    ptype(JSProperty.scheduleUpdated,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSProperty.sendTo,
          false, // valueList
          true, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStringStrings);
    ptype(JSProperty.sequence,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUnsignedInt);
    ptype(JSProperty.showWithoutTime,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSProperty.size,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUnsignedInt);
    ptype(JSProperty.start,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeLocalDateTime);
    ptype(JSProperty.source,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.status,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.statusUpdatedAt,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSProperty.timestamp,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSProperty.timeZone,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.timeZones,
          false, // valueList
          true, // propertyList
          JSTypes.typeTimeZone, // elementType
          false, // object
          JSTypes.typeTimeZones);
    ptype(JSProperty.title,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.trigger,
          false, // valueList
          false, // propertyList
          null, // elementType
          true, // object
          JSTypes.typeOffsetTrigger, JSTypes.typeAbsoluteTrigger,
          JSTypes.typeUnknownTrigger);
    ptype(JSProperty.uid,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSProperty.updated,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSProperty.useDefaultAlerts,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSProperty.virtualLocations,
          false, // valueList
          true, // propertyList
          JSTypes.typeVirtualLocation, // elementType
          false, // object
          JSTypes.typeVirtualLocations);
    ptype(JSProperty.when,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);

    /* ===== valid for ============================== */

    validFor(JSProperty.type, JSTypes.typeJSEvent, JSTypes.typeJSTask,
             JSTypes.typeJSGroup, JSTypes.typeAbsoluteTrigger,
             JSTypes.typeAlert, JSTypes.typeLink,
             JSTypes.typeLocation, JSTypes.typeOffsetTrigger,
             JSTypes.typeParticipant, JSTypes.typeParticipantProgress,
             JSTypes.typeRecurrenceRule, JSTypes.typeRelation,
             JSTypes.typeTimeZone, JSTypes.typeVirtualLocation);

    validFor(JSProperty.acknowledged, JSTypes.typeAlert);

    validFor(JSProperty.action, JSTypes.typeAlert);

    validFor(JSProperty.alerts,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.categories,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup,
             JSTypes.typeLocation);
    validFor(JSProperty.cid, JSTypes.typeLink);
    validFor(JSProperty.color,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSProperty.contentType, JSTypes.typeLink);
    validFor(JSProperty.coordinates, JSTypes.typeLocation);
    validFor(JSProperty.created ,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSProperty.delegatedFrom, JSTypes.typeParticipant);
    validFor(JSProperty.delegatedTo, JSTypes.typeParticipant);
    validFor(JSProperty.description,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeLocation,
             JSTypes.typeVirtualLocation);
    validFor(JSProperty.descriptionContentType, JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.display, JSTypes.typeLink);
    validFor(JSProperty.due,  JSTypes.typeJSTask);
    validFor(JSProperty.duration,  JSTypes.typeJSEvent);
    validFor(JSProperty.email, JSTypes.typeParticipant);
    validFor(JSProperty.entries, JSTypes.typeJSGroup);
    validFor(JSProperty.estimatedDuration,  JSTypes.typeJSTask);
    validFor(JSProperty.excluded,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.expectReply, JSTypes.typeParticipant);
    validFor(JSProperty.freeBusyStatus,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.href, JSTypes.typeLink);
    validFor(JSProperty.invitedBy, JSTypes.typeParticipant);
    validFor(JSProperty.keywords,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSProperty.kind, JSTypes.typeParticipant);
    validFor(JSProperty.language, JSTypes.typeParticipant);
    validFor(JSProperty.linkIds, JSTypes.typeLocation,
             JSTypes.typeParticipant);
    validFor(JSProperty.localizations,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.locationId, JSTypes.typeParticipant);
    validFor(JSProperty.locations,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.memberOf, JSTypes.typeParticipant);
    validFor(JSProperty.method,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.name, JSTypes.typeLocation,
             JSTypes.typeParticipant);
    validFor(JSProperty.offset, JSTypes.typeOffsetTrigger);
    validFor(JSProperty.participants,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.participationComment, JSTypes.typeParticipant);
    validFor(JSProperty.participationStatus, JSTypes.typeParticipant);
    validFor(JSProperty.priority,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.privacy,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.prodId,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSProperty.recurrenceId,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.recurrenceOverrides,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.recurrenceRule,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.rel, JSTypes.typeLink);
    validFor(JSProperty.relatedTo,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeAlert);
    validFor(JSProperty.relation, JSTypes.typeRelation);
    validFor(JSProperty.relativeTo, JSTypes.typeOffsetTrigger,
             JSTypes.typeLocation);
    validFor(JSProperty.replyTo,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.roles, JSTypes.typeParticipant);
    validFor(JSProperty.scheduleAgent, JSTypes.typeParticipant);
    validFor(JSProperty.scheduleSequence, JSTypes.typeParticipant);
    validFor(JSProperty.scheduleUpdated, JSTypes.typeParticipant);
    validFor(JSProperty.sendTo, JSTypes.typeParticipant);
    validFor(JSProperty.sequence,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.showWithoutTime,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.size, JSTypes.typeLink);
    validFor(JSProperty.start,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.source, JSTypes.typeJSGroup);
    validFor(JSProperty.status,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeParticipantProgress);
    validFor(JSProperty.statusUpdatedAt,  JSTypes.typeJSTask);
    validFor(JSProperty.timestamp, JSTypes.typeParticipantProgress);
    validFor(JSProperty.timeZone,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeLocation);
    validFor(JSProperty.timeZones,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.title,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup, JSTypes.typeLink);
    validFor(JSProperty.trigger, JSTypes.typeOffsetTrigger,
             JSTypes.typeAbsoluteTrigger, JSTypes.typeUnknownTrigger,
             JSTypes.typeAlert);
    validFor(JSProperty.uid,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSProperty.updated,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask, JSTypes.typeJSGroup);
    validFor(JSProperty.useDefaultAlerts,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.virtualLocations,  JSTypes.typeJSEvent,
             JSTypes.typeJSTask);
    validFor(JSProperty.when, JSTypes.typeAbsoluteTrigger);

    // Replace all contains values with immutable lists
    for (final var name: contains.keySet()) {
      final var val = contains.get(name);
      if (val != null) {
        contains.put(name, List.copyOf(val));
      }
    }
  }

  private static void ptype(final String name,
                            final boolean valueList,
                            final boolean propertyList,
                            final String elementType,
                            final boolean object,
                            final String... types) {
    ptypes.put(name, new TypeInfo(name, valueList, propertyList,
                                  elementType, object, types));
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

  static List<String> getTypes(final String name) {
    final var info = ptypes.get(name);

    if (info == null) {
      return null;
    }

    return info.getTypes();
  }

  static TypeInfo getTypeInfo(final String name) {
    return ptypes.get(name);
  }

  static List<String> getValidFor(final String name) {
    return validFor.get(name);
  }

  static List<String> getContained(final String name) {
    return contains.get(name);
  }
}
