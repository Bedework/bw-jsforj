/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.test;

import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.impl.JSMapper;
import org.bedework.jsforj.impl.values.JSOverrideImpl;
import org.bedework.jsforj.impl.values.collections.JSReplyToImpl;
import org.bedework.jsforj.impl.values.collections.JSUnsignedIntArrayImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSStringImpl;
import org.bedework.jsforj.impl.values.dataTypes.JSUnsignedIntegerImpl;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSGroup;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSLink;
import org.bedework.jsforj.model.values.JSLocation;
import org.bedework.jsforj.model.values.JSOffsetTrigger;
import org.bedework.jsforj.model.values.JSOverride;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.JSRecurrenceRule;
import org.bedework.jsforj.model.values.JSRelation;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.collections.JSArray;
import org.bedework.jsforj.model.values.collections.JSLinks;
import org.bedework.jsforj.model.values.collections.JSList;
import org.bedework.jsforj.model.values.collections.JSRecurrenceOverrides;
import org.bedework.jsforj.model.values.collections.JSRecurrenceRules;
import org.bedework.jsforj.model.values.dataTypes.JSString;
import org.bedework.util.misc.Util;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * User: mike Date: 10/25/19 Time: 16:39
 */
public class JsForJTest {
  final static JSFactory factory = JSFactory.getFactory();

  private final static String dataPath =
          "src/test/resources/data/";

  private final static String specificPath =
          "src/test/resources/specific/";

  private static final JSMapper mapper = new JSMapper();

  private String glob;

  protected Iterator<Path> files;

  @BeforeClass
  public static void oneTimeSetUp() {

  }

  @AfterClass
  public static void oneTimeTearDown() {

  }

  @Test
  public void testReadData() {
    try {
      final Path jpath = FileSystems.getDefault().getPath(dataPath);

      if (!jpath.toFile().isDirectory()) {
        throw new RuntimeException("Not a directory");
      }

      final DirectoryStream<Path> filesStream;

      if (glob == null) {
        filesStream = Files.newDirectoryStream(jpath, "*.json");
      } else {
        filesStream = Files.newDirectoryStream(jpath, glob);
      }

      files = filesStream.iterator();

      while (files.hasNext()) {
        final File f = files.next().toFile();

        info("Test read of " + f.getName());

        if (!f.isFile()) {
          System.out.println("Not a file: " + f.getAbsolutePath());
          continue;
        }

        final JSCalendarObject obj = mapper.parse(new FileReader(f));

        info(obj.writeValueAsStringFormatted(mapper));

        /*
        final var bwloc = obj.getPropertyValue(
                "bedework.org/location");
        if (bwloc != null) {
          info("Has bwloc with class " + bwloc.getClass());
        }
        */
        final var overrides = obj.getOverrides(false);
        if (overrides != null) {
          info("Has overrides with class " + overrides.getClass());

          final var ovs = overrides.get();

          info("Has " + ovs.size() + " overrides");

          for (final var ov: ovs) {
            info("value has class " + ov.getValue().getClass());
          }
        }

        final var replyTo = obj.getReplyTo(false);
        if (replyTo != null) {
          assertEquals("Must be JSReplyToImpl:",
                              JSReplyToImpl.class,
                              replyTo.getClass());
          final List<JSProperty<JSString>> rtl = replyTo.get();
          if (!Util.isEmpty(rtl)) {
            final JSString rtlVal = rtl.get(0).getValue();

            assertEquals("Must be JSStringImpl:",
                                JSStringImpl.class,
                                rtlVal.getClass());
          }
        }

        final JSRecurrenceRules rrules =
                obj.getRecurrenceRules(false);

        if (rrules != null) {
          for (final var rule: rrules.get()) {
            checkRecurrenceRule(rule);
          }
        }

        final JSRecurrenceOverrides ovs = obj.getOverrides(false);

        if (ovs != null) {
          final List<JSProperty<JSOverride>> ovsl = ovs.get();
          if (!Util.isEmpty(ovsl)) {
            final JSOverride ovVal = ovsl.get(0).getValue();

            assertEquals("Must be JSOverrideImpl:",
                                JSOverrideImpl.class,
                                ovVal.getClass());
          }
        }
      }
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  @Test
  public void testOddPath() {
    try {
      final JSCalendarObject obj =
              readSpecificFile("oddNames.json");

      final var overrides = obj.getOverrides(false);

      assertNotNull("Expected overrides", overrides);

      final var overrideList = overrides.get();

      assertFalse("Non-empty overrides list",
                  Util.isEmpty(overrideList));

      assertEquals("Only one entry", 1, overrideList.size());

      final var override =
              overrideList.get(0).getValue();
      assertEquals("Odd names", override.getTitle());

      final var anObject =
              override.getProperty("anObject");

      assertNotNull("Expected anObject", anObject);

      final var oddNamedProp =
              anObject.getValue()
                      .getProperty("another/odd/name/with/slash");

      assertNotNull("Expected another/odd/name/with/slash",
                    oddNamedProp);

      assertEquals("and that", oddNamedProp.getValue().getStringValue());
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  @Test
  public void testAlertEvent() {
    try {
      final JSCalendarObject obj =
              readSpecificFile("alertEvent.json");

      final var alerts = obj.getAlerts(false);
      assertNotNull(alerts);

      final var alist = alerts.get();
      assertEquals("Should only be one", 1, alist.size());

      final var alert = alist.get(0).getValue();

      final var trigger = alert.getTrigger();
      assertTrue(trigger instanceof JSOffsetTrigger);

      info("Offset alert passes");
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  private JSCalendarObject readSpecificFile(final String name) {
    try {
      final Path jpath = FileSystems.getDefault()
                                    .getPath(specificPath,
                                             name);

      final File theFile = jpath.toFile();
      if (!theFile.isFile()) {
        throw new RuntimeException("Not a file");
      }

      info("Test read of " + theFile.getName());

      return mapper.parse(new FileReader(theFile));
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
      return null;
    }
  }

  private void checkRecurrenceRule(final JSRecurrenceRule rule) {
    mustBeUnsignedInt(rule.getCount(false));
    mustBeUnsignedInts(rule.getByHour(false));
    mustBeUnsignedInts(rule.getByMinute(false));
  }

  private void mustBeUnsignedInt(final JSValue val) {
    if (val == null) {
      return;
    }

    assertEquals("Must be JSUnsignedInteger:",
                        JSUnsignedIntegerImpl.class,
                        val.getClass());
  }

  private void mustBeUnsignedInts(final JSValue val) {
    if (val == null) {
      return;
    }

    assertEquals("Must be JSArray<JSUnsignedInteger>:",
                        JSUnsignedIntArrayImpl.class,
                        val.getClass());

    for (final var el: ((JSArray<?>)val).get()) {
      mustBeUnsignedInt((JSValue)el);
    }
  }

  @Test
  public void testSimpleGroup() {
    try {
      final File jsonGroup = new File(dataPath + "simpleGroup.json");

      final var obj = mapper.parse(new FileReader(jsonGroup));

      assertTrue("Not JSGroup", obj instanceof JSGroup);

      final var group = (JSGroup)obj;

      final var entries = group.getEntries();
      assertEquals("Not 2 entries", 2, entries.size());
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  @Test
  public void testBuildEvent() {
    try {
      final JSCalendarObject event =
              (JSCalendarObject)factory.newValue(JSTypes.typeJSEvent);

      assertTrue("Not JSEvent", event instanceof JSEvent);

      event.setUid(UUID.randomUUID().toString());

      //event.addComment("comment 1");
      //event.addComment("comment 2");

      final var locations = event.getLocations(true);

      final JSLocation loc = locations.makeLocation().getValue();

      loc.setName("My new location");
      final JSList<String> loctypes = loc.getLocationTypes(true);
      loctypes.add("airport");
      loc.setCoordinates("geo:40.7654,73.9876");

      final var rrules = event.getRecurrenceRules(true);

      final JSRecurrenceRule rrule = rrules.makeRecurrenceRule();

      rrule.setFrequency(JSRecurrenceRule.freqWeekly);
      rrule.setCount(new JSUnsignedIntegerImpl(10));

      final var replyTo = event.getReplyTo(true);

      replyTo.makeReplyTo("imip",
                          "mailto:farmerjo@wearepoultry.example.com");

      final var participants = event.getParticipants(true);
      final JSParticipant part = participants.makeParticipant().getValue();

      part.setName("Turkey Lurkey");
      part.setEmail("tlurkey@turkeys.example.com");
      part.getSendTo(true).makeSendTo("imip",
                                      "mailto:tlurkey@turkeys.example.com");
      part.setKind("turkey");
      part.setLanguage("gobble");
      part.setInvitedBy("thechicken@chickens.example.com");
      final var roles = part.getRoles(true);
      roles.add("owner");
      roles.add("chair");

      final var relations = event.getRelatedTo(true);

      final var rel = relations.makeEntry("this.is.a.uid");
      final JSRelation relVal = rel.getValue();

      relVal.getRelations(true).add("parent");

      final JSLinks links = event.getLinks(true);
      final JSProperty<JSLink> link =
              links.makeEntry("http://example.org/something.ics");
      link.getValue().setRel("alternate");

      info("Dump of created event");
      info(event.writeValueAsStringFormatted(mapper));
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  private void info(final String msg) {
    System.out.println(msg);
  }
}
