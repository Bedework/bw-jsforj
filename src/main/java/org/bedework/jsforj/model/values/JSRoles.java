package org.bedework.jsforj.model.values;

import org.bedework.jsforj.model.values.collections.JSList;

/**
 * User: mike Date: 1/29/21 Time: 15:38
 */
public interface JSRoles extends JSList<String> {
  String roleOwner = "owner";
  String roleAttendee = "attendee";
  String roleOptional = "optional";
  String roleInformational = "informational";
  String roleChair = "chair";
  String roleContact = "contact";
}
