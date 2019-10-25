package org.bedework.jsforj.model;

/**
 * User: mike Date: 10/23/19 Time: 16:19
 */
public interface JSTypes {
  String typeUnknown = "Unknown";

  String typeAlert = "Alert";
  String typeAlerts = "Id[Alert]";
  String typeBoolean = "Boolean";
  String typeDuration = "Duration";
  String typeEntries = "String[JSTask|JSEvent]";
  String typeId = "Id";
  String typeIds = "Id[Boolean]";
  String typeInt = "Int";
  String typeJSEvent = "jsevent";
  String typeJSGroup = "jsgroup";
  String typeJSTask = "jstask";
  String typeLocalDateTime = "LocalDateTime";
  String typeLink = "Link";
  String typeLocalizations = "String[PatchObject]";
  String typeLocation = "Location";
  String typeLocations = "Id[Location]";
  String typeNumber = "Number";
  String typeParticipant = "Participant";
  String typeParticipants = "Id[Participant]";
  String typeParticipantProgress = "ParticipantProgress";
  String typePatchObject = "PatchObject";
  String typeRecurrenceRule = "RecurrenceRule";
  String typeRecurrenceOverrides = "LocalDateTime[PatchObject]";
  String typeRelation = "Relation";
  String typeRelations = "String[Relation]";
  String typeSignedDuration = "SignedDuration";
  String typeString = "String";

  /** e.g.
       "roles": {
         "owner": true,
         "attendee": true,
         "chair": true
       }
   */
  String typeStrings = "String[Boolean]";

  /** e.g.
     "sendTo": {
       "imip": "mailto:zoe@foobar.example.com"
     },
   */
  String typeStringStrings = "String[String]";
  String typeTimeZone = "TimeZone";
  String typeTimeZones = "String[TimeZone]";
  String typeTimeZoneRule = "TimeZoneRule";
  String typeUnsignedInt = "UnsignedInt";
  String typeUTCDateTime = "UTCDateTime";
  String typeVirtualLocation = "VirtualLocation";
  String typeVirtualLocations = "Id[VirtualLocation]";

  String typeOffsetTrigger = "OffsetTrigger";
  String typeAbsoluteTrigger = "AbsoluteTrigger";
  String typeUnknownTrigger = "UnknownTrigger";
}
