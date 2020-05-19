package org.bedework.jsforj.model.values.dataTypes;

import org.bedework.jsforj.model.values.JSValue;

import java.time.LocalDateTime;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSLocalDateTime extends JSValue {
  LocalDateTime getDt();
}
