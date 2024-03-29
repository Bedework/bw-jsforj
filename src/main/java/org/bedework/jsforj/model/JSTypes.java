package org.bedework.jsforj.model;

/**
 * User: mike Date: 10/23/19 Time: 16:19
 */
public interface JSTypes {
  String typeUnknown = "Unknown";

  // Top level objects
  String typeEvent = "Event";
  String typeGroup = "Group";
  String typeTask = "Task";

  String typeVPoll = "Vpoll";

  String typeAlert = "Alert";
  String typeAlerts = "Id[Alert]";
  String typeBoolean = "Boolean";
  String typeComments = "String[]";
  String typeDuration = "Duration";
  String typeEntries = "(JSTask|JSEvent)[]";
  String typeId = "Id";
  String typeIds = "Id[Boolean]";
  String typeInt = "Int";
  String typeIntArray = "Int[]";
  String typeLink = "Link";
  String typeLinks = "Id[Link]";
  String typeLocalDateTime = "LocalDateTime";
  String typeLocalizations = "String[PatchObject]";
  String typeLocation = "Location";
  String typeLocations = "Id[Location]";
  String typeNDay = "NDay";
  String typeNDayArray = "NDay[]";
  String typeNumber = "Number";
  String typeParticipant = "Participant";
  String typeParticipants = "Id[Participant]";
  String typePatchObject = "PatchObject";
  String typeRecurrenceOverrides = "LocalDateTime[PatchObject]";
  String typeRecurrenceRule = "RecurrenceRule";
  String typeRecurrenceRules = "RecurrenceRule[]";
  String typeRelation = "Relation";
  String typeRelations = "String[Relation]";
  String typeSignedDuration = "SignedDuration";
  String typeString = "String";
  String typeStringArray = "String[]";

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
  // Too general String typeStringStrings = "String[String]";
  String typeReplyTo = "String[String-replyToUrl]";
  String typeSendTo = "String[String-sendToUrl]";
  String typeTimeZone = "TimeZone";
  String typeTimeZones = "String[TimeZone]";
  String typeTimeZoneRule = "TimeZoneRule";
  String typeUnsignedInt = "UnsignedInt";
  String typeUnsignedIntArray = "UnsignedInt[]";
  String typeURI = "Uri";
  String typeUTCDateTime = "UTCDateTime";
  String typeVirtualLocation = "VirtualLocation";
  String typeVirtualLocations = "Id[VirtualLocation]";

  String typeOffsetTrigger = "OffsetTrigger";
  String typeAbsoluteTrigger = "AbsoluteTrigger";
  String typeUnknownTrigger = "UnknownTrigger";

  // Internally used types
  String typeNull = "null";
  String typeRoles = "roles";
  String typeOverride = "override";
  String typeTrigger = "trigger";
}
