/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.impl;

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
    ptype(JSPropertyNames.type,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.acknowledged,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSPropertyNames.action,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.alerts,
          false, // valueList
          true, // propertyList
          JSTypes.typeAlert, // elementType
          false, // object
          JSTypes.typeAlerts);
    ptype(JSPropertyNames.categories,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.cid,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.color,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.contentType,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.coordinates,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.created,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSPropertyNames.delegatedFrom,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.delegatedTo,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.description,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.descriptionContentType,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.display,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.due,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeLocalDateTime);
    ptype(JSPropertyNames.duration,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeDuration);
    ptype(JSPropertyNames.email,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.entries,
          false, // valueList
          true, // propertyList
          "JSTask|JSEvent", // elementType - special cased
          false, // object
          JSTypes.typeEntries);
    ptype(JSPropertyNames.estimatedDuration,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeDuration);
    ptype(JSPropertyNames.excluded,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSPropertyNames.expectReply,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSPropertyNames.freeBusyStatus,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.href,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.invitedBy,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.keywords,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.kind,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.language,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.linkIds,
          true, // valueList
          false, // propertyList
          JSTypes.typeId, // elementType
          false, // object
          JSTypes.typeIds);
    ptype(JSPropertyNames.localizations,
          false, // valueList
          true, // propertyList
          JSTypes.typePatchObject, // elementType
          false, // object
          JSTypes.typeLocalizations);
    ptype(JSPropertyNames.locationId,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.locations,
          false, // valueList
          true, // propertyList
          JSTypes.typeLocation, // elementType
          false, // object
          JSTypes.typeLocations);
    ptype(JSPropertyNames.memberOf,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.method,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.name,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.offset,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeSignedDuration);
    ptype(JSPropertyNames.participants,
          false, // valueList
          true, // propertyList
          JSTypes.typeParticipant, // elementType
          false, // object
          JSTypes.typeParticipants);
    ptype(JSPropertyNames.participationComment,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.participationStatus,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.priority,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeInt);
    ptype(JSPropertyNames.privacy,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.prodId,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.recurrenceId,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeLocalDateTime);
    ptype(JSPropertyNames.recurrenceOverrides,
          false, // valueList
          true, // propertyList
          JSTypes.typePatchObject, // elementType
          false, // object
          JSTypes.typeRecurrenceOverrides);
    ptype(JSPropertyNames.recurrenceRule,
          false, // valueList
          false, // propertyList
          null, // elementType
          true, // object
          JSTypes.typeRecurrenceRule);
    ptype(JSPropertyNames.rel,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.relatedTo,
          false, // valueList
          true, // propertyList
          JSTypes.typeRelation, // elementType
          false, // object
          JSTypes.typeRelations);
    ptype(JSPropertyNames.relation,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.relativeTo,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.replyTo,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStringStrings);
    ptype(JSPropertyNames.roles,
          true, // valueList
          false, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStrings);
    ptype(JSPropertyNames.scheduleAgent,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.scheduleSequence,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUnsignedInt);
    ptype(JSPropertyNames.scheduleUpdated,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSPropertyNames.sendTo,
          false, // valueList
          true, // propertyList
          JSTypes.typeString, // elementType
          false, // object
          JSTypes.typeStringStrings);
    ptype(JSPropertyNames.sequence,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUnsignedInt);
    ptype(JSPropertyNames.showWithoutTime,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSPropertyNames.size,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUnsignedInt);
    ptype(JSPropertyNames.start,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeLocalDateTime);
    ptype(JSPropertyNames.source,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.status,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.statusUpdatedAt,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSPropertyNames.timestamp,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSPropertyNames.timeZone,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.timeZones,
          false, // valueList
          true, // propertyList
          JSTypes.typeTimeZone, // elementType
          false, // object
          JSTypes.typeTimeZones);
    ptype(JSPropertyNames.title,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.trigger,
          false, // valueList
          false, // propertyList
          null, // elementType
          true, // object
          JSTypes.typeOffsetTrigger, JSTypes.typeAbsoluteTrigger,
          JSTypes.typeUnknownTrigger);
    ptype(JSPropertyNames.uid,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeString);
    ptype(JSPropertyNames.updated,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);
    ptype(JSPropertyNames.useDefaultAlerts,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeBoolean);
    ptype(JSPropertyNames.virtualLocations,
          false, // valueList
          true, // propertyList
          JSTypes.typeVirtualLocation, // elementType
          false, // object
          JSTypes.typeVirtualLocations);
    ptype(JSPropertyNames.when,
          false, // valueList
          false, // propertyList
          null, // elementType
          false, // object
          JSTypes.typeUTCDateTime);

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
