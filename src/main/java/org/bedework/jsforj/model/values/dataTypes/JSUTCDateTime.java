package org.bedework.jsforj.model.values.dataTypes;

import org.bedework.jsforj.model.values.JSValue;

import java.time.Instant;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface JSUTCDateTime extends JSValue {
  Instant getDt();
}
