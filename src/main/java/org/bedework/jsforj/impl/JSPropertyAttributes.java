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
  private static Map<String, List<String>> ptypes = new HashMap<>();

  private static Map<String, List<String>> validFor = new HashMap<>();

  private static Map<String, List<String>> contains = new HashMap<>();

  static {
    ptype(JSProperty.type, JSTypes.typeString);
    ptype(JSProperty.acknowledged, JSTypes.typeUTCDateTime);
    ptype(JSProperty.action, JSTypes.typeString);
    ptype(JSProperty.alerts, JSTypes.typeAlerts);
    ptype(JSProperty.categories, JSTypes.typeStrings);
    ptype(JSProperty.cid, JSTypes.typeString);
    ptype(JSProperty.color, JSTypes.typeString);
    ptype(JSProperty.contentType, JSTypes.typeString);
    ptype(JSProperty.coordinates, JSTypes.typeString);
    ptype(JSProperty.created, JSTypes.typeUTCDateTime);
    ptype(JSProperty.delegatedFrom, JSTypes.typeStrings);
    ptype(JSProperty.delegatedTo, JSTypes.typeStrings);
    ptype(JSProperty.description, JSTypes.typeString);
    ptype(JSProperty.descriptionContentType, JSTypes.typeString);
    ptype(JSProperty.display, JSTypes.typeString);
    ptype(JSProperty.due, JSTypes.typeLocalDateTime);
    ptype(JSProperty.duration, JSTypes.typeDuration);
    ptype(JSProperty.email, JSTypes.typeString);
    ptype(JSProperty.entries, JSTypes.typeEntries);
    ptype(JSProperty.estimatedDuration, JSTypes.typeDuration);
    ptype(JSProperty.excluded, JSTypes.typeBoolean);
    ptype(JSProperty.expectReply, JSTypes.typeBoolean);
    ptype(JSProperty.freeBusyStatus, JSTypes.typeString);
    ptype(JSProperty.href, JSTypes.typeString);
    ptype(JSProperty.invitedBy, JSTypes.typeString);
    ptype(JSProperty.keywords, JSTypes.typeStrings);
    ptype(JSProperty.kind, JSTypes.typeString);
    ptype(JSProperty.language, JSTypes.typeString);
    ptype(JSProperty.linkIds, JSTypes.typeIds);
    ptype(JSProperty.localizations, JSTypes.typeLocalizations);
    ptype(JSProperty.locationId, JSTypes.typeString);
    ptype(JSProperty.locations, JSTypes.typeLocations);
    ptype(JSProperty.memberOf, JSTypes.typeStrings);
    ptype(JSProperty.method, JSTypes.typeString);
    ptype(JSProperty.name, JSTypes.typeString);
    ptype(JSProperty.offset, JSTypes.typeSignedDuration);
    ptype(JSProperty.participants, JSTypes.typeParticipants);
    ptype(JSProperty.participationComment, JSTypes.typeString);
    ptype(JSProperty.participationStatus, JSTypes.typeString);
    ptype(JSProperty.priority, JSTypes.typeInt);
    ptype(JSProperty.privacy, JSTypes.typeString);
    ptype(JSProperty.prodId, JSTypes.typeString);
    ptype(JSProperty.recurrenceId, JSTypes.typeLocalDateTime);
    ptype(JSProperty.recurrenceOverrides,
          JSTypes.typeRecurrenceOverrides);
    ptype(JSProperty.recurrenceRule, JSTypes.typeRecurrenceRule);
    ptype(JSProperty.rel, JSTypes.typeString);
    ptype(JSProperty.relatedTo, JSTypes.typeRelations);
    ptype(JSProperty.relation, JSTypes.typeStrings);
    ptype(JSProperty.relativeTo, JSTypes.typeString);
    ptype(JSProperty.replyTo, JSTypes.typeStringStrings);
    ptype(JSProperty.roles, JSTypes.typeStrings);
    ptype(JSProperty.scheduleAgent, JSTypes.typeString);
    ptype(JSProperty.scheduleSequence, JSTypes.typeUnsignedInt);
    ptype(JSProperty.scheduleUpdated, JSTypes.typeUTCDateTime);
    ptype(JSProperty.sendTo, JSTypes.typeStringStrings);
    ptype(JSProperty.sequence, JSTypes.typeUnsignedInt);
    ptype(JSProperty.showWithoutTime, JSTypes.typeBoolean);
    ptype(JSProperty.size, JSTypes.typeUnsignedInt);
    ptype(JSProperty.start, JSTypes.typeLocalDateTime);
    ptype(JSProperty.source, JSTypes.typeString);
    ptype(JSProperty.status, JSTypes.typeString);
    ptype(JSProperty.statusUpdatedAt, JSTypes.typeUTCDateTime);
    ptype(JSProperty.timestamp, JSTypes.typeUTCDateTime);
    ptype(JSProperty.timeZone, JSTypes.typeString);
    ptype(JSProperty.timeZones, JSTypes.typeTimeZones);
    ptype(JSProperty.title, JSTypes.typeString);
    ptype(JSProperty.trigger,
          JSTypes.typeOffsetTrigger, JSTypes.typeAbsoluteTrigger,
          JSTypes.typeUnknownTrigger);
    ptype(JSProperty.uid, JSTypes.typeString);
    ptype(JSProperty.updated, JSTypes.typeUTCDateTime);
    ptype(JSProperty.useDefaultAlerts, JSTypes.typeBoolean);
    ptype(JSProperty.virtualLocations,
          JSTypes.typeVirtualLocations);
    ptype(JSProperty.when, JSTypes.typeUTCDateTime);

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
                            final String... types) {
    ptypes.put(name, List.of(types));
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
    return ptypes.get(name);
  }

  static List<String> getValidFor(final String name) {
    return validFor.get(name);
  }

  static List<String> getContained(final String name) {
    return contains.get(name);
  }
}
