package org.bedework.jsforj.model;

/**
 * User: mike Date: 10/24/19 Time: 23:52
 */
public interface JSPropertyNames {
  String type = "@type";      //  String    Valid for: JSEvent, JSTask,
  //      JSGroup, AbsoluteTrigger, Alert, Link,
  //      Location, OffsetTrigger, Participant,
  //      ParticipantProgress, RecurrenceRule,
  //      Relation, TimeZone, VirtualLocationValid for:

  String acknowledged = "acknowledged";//  UTCDateTime    Valid for: Alert   Valid for:

  String action = "action";      //  String    Valid for: Alert   Valid for:

  String alerts = "alerts";      //  Id[Alert]      Valid for: JSEvent,
  //                                   JSTask
  String categories = "categories";  // String[Boolean]Valid for: JSEvent,
  //                                   JSTask, JSGroup Location
  String cid = "cid";         //  String    Valid for: Link
  String color = "color";       //  String    Valid for: JSEvent,
  //                                   JSTask, JSGroup
  String contentType = "contentType"; //  String    Valid for: Link
  String coordinates = "coordinates"; //  String    Valid for: Location
  String created  = "created ";    //  UTCDateTime    Valid for: JSEvent,
  //                                   JSTask, JSGroup
  String delegatedFrom = "delegatedFrom";//  String[Boolean]Valid for: Participant
  String delegatedTo = "delegatedTo"; //  String[Boolean]Valid for: Participant
  String description = "description"; //  String    Valid for: JSEvent,
  //                                   JSTask, Location, VirtualLocation
  String descriptionContentType = "descriptionContentType";//  String    Valid for: JSEvent, JSTask
  String display = "display";     //  String    Valid for: Link
  String due = "due";         //  LocalDateTime  Valid for: JSTask
  String duration = "duration";    //  Duration       Valid for: JSEvent
  String email = "email";       //  String    Valid for: Participant
  String entries = "entries";     //  String[JSTask|JSEvent]   Valid for: JSGroup
  String estimatedDuration = "estimatedDuration";//  Duration       Valid for: JSTask
  String excluded = "excluded";       //  Boolean        Valid for: JSEvent,
  //                                   JSTask
  String expectReply = "expectReply"; //  Boolean        Valid for: Participant
  String freeBusyStatus = "freeBusyStatus";//  String    Valid for: JSEvent,
  //                                   JSTask
  String href = "href";        //  String    Valid for: Link
  String invitedBy = "invitedBy";   //  String    Valid for: Participant
  String keywords = "keywords";    //  String[Boolean]Valid for: JSEvent,
  //                                   JSTask, JSGroup
  String kind = "kind";        //  String    Valid for: Participant
  String language = "language";    //  String    Valid for: Participant
  String links = "links";         //  Id[Link]    Valid for: JSEvent,
  //                                   JSTask
  String linkIds = "linkIds";     //  Id[Boolean]    Valid for: Location,
  //                                   Participant
  String locale = "locale";         //  Id[Link]    Valid for: JSEvent,
  //                                   JSTask
  String localizations = "localizations";//  String[PatchObject]   Valid for: JSEvent,
  //                                   JSTask
  String locationId = "locationId";  //  String    Valid for: Participant
  String locations = "locations";   //  Id[Location]   Valid for: JSEvent,
  //                                   JSTask
  String memberOf = "memberOf";    //  String[Boolean]Valid for: Participant
  String method = "method";      //  String    Valid for: JSEvent,
  //                                   JSTask
  String name = "name";        //  String    Valid for: Location,
  //     Participant
  String offset = "offset";      //  SignedDuration Valid for: OffsetTriggerValid for:
  String participants = "participants";//  Id[Participant]Valid for: JSEvent,
  //                                   JSTask
  String participationComment = "participationComment";//  String    Valid for: Participant
  String participationStatus = "participationStatus";//  String    Valid for: Participant
  String priority = "priority";    //  Int            Valid for: JSEvent,
  //                                   JSTask
  String privacy = "privacy";     //  String    Valid for: JSEvent,
  //                                   JSTask
  String prodId = "prodId";      //  String    Valid for: JSEvent,
  //                                   JSTask, JSGroup
  String recurrenceId = "recurrenceId";//  LocalDateTime  Valid for: JSEvent,
  //                                   JSTask
  String recurrenceOverrides = "recurrenceOverrides";//  LocalDateTime[PatchObject]   Valid for: JSEvent,
  //                                   JSTask
  String recurrenceRule = "recurrenceRule";//  RecurrenceRule Valid for: JSEvent,
  //                                   JSTask
  String rel = "rel";         //  String    Valid for: Link
  String relatedTo = "relatedTo";   //  String[Relation]   Valid for: JSEvent,
  //                                   JSTask, Alert
  String relation = "relation";    //  String[Boolean]Valid for: Relation
  String relativeTo = "relativeTo";  //  String    Valid for: OffsetTrigger, Location
  String replyTo = "replyTo";     //  String[String] Valid for: JSEvent,
  //                                   JSTask
  String roles = "roles";       //  String[Boolean]Valid for: Participant
  String scheduleAgent = "scheduleAgent";//  String    Valid for: Participant
  String scheduleSequence = "scheduleSequence";//  UnsignedInt    Valid for: Participant
  String scheduleUpdated = "scheduleUpdated";//  UTCDateTime    Valid for: Participant
  String sendTo = "sendTo";      //  String[String] Valid for: Participant
  String sequence = "sequence";    //  UnsignedInt    Valid for: JSEvent,
  //                                   JSTask
  String showWithoutTime = "showWithoutTime";//  Boolean        Valid for: JSEvent,
  //                                   JSTask
  String size = "size";        //  UnsignedInt    Valid for: Link
  String start = "start";       //  LocalDateTime  Valid for: JSEvent,
  //                                   JSTask
  String source = "source";      //  String    Valid for: JSGroup
  String status = "status";      //  String    Valid for: JSEvent,
  //                                   JSTask, ParticipantProgress
  String statusUpdatedAt = "statusUpdatedAt";//  UTCDateTime    Valid for: JSTask
  String timestamp = "timestamp";   //  UTCDateTime    Valid for: ParticipantProgress
  String timeZone = "timeZone";    //  String|null    Valid for: JSEvent,
  //                                   JSTask, Location
  String timeZones = "timeZones";   //  String[TimeZone]      Valid for: JSEvent,
  //                                   JSTask
  String title = "title";      //  String    Valid for: JSEvent,
  //                                   JSTask, JSGroup, Link
  String trigger = "trigger";     //  OffsetTrigger|AbsoluteTrigger|UnknownTrigger   Valid for: Alert
  String uid = "uid";         //  String    Valid for: JSEvent,
  //                                   JSTask, JSGroup
  String updated = "updated";     //  UTCDateTime    Valid for: JSEvent,
  //                                   JSTask, JSGroup
  String useDefaultAlerts = "useDefaultAlerts";//  Boolean        Valid for: JSEvent,
  //                                   JSTask
  String virtualLocations = "virtualLocations";//  Id[VirtualLocation]   Valid for: JSEvent,
  //                                   JSTask
  String when = "when";        //  UTCDateTime    Valid for: AbsoluteTrigger
}
