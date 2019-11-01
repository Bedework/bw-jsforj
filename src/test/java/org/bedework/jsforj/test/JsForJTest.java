/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.test;

import org.bedework.jsforj.impl.JSFactory;
import org.bedework.jsforj.impl.JSMapper;
import org.bedework.jsforj.model.JSCalendarObject;
import org.bedework.jsforj.model.JSEvent;
import org.bedework.jsforj.model.JSGroup;
import org.bedework.jsforj.model.JSProperty;
import org.bedework.jsforj.model.JSPropertyNames;
import org.bedework.jsforj.model.JSTypes;
import org.bedework.jsforj.model.values.JSList;
import org.bedework.jsforj.model.values.JSLocation;
import org.bedework.jsforj.model.values.JSParticipant;
import org.bedework.jsforj.model.values.JSRecurrenceRule;
import org.bedework.jsforj.model.values.JSValue;
import org.bedework.jsforj.model.values.UnsignedInteger;

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

/**
 * User: mike Date: 10/25/19 Time: 16:39
 */
public class JsForJTest {
  final static JSFactory factory = JSFactory.getFactory();

  private final static String dataPath =
          "/Users/mike/bedework/quickstart-dev/bw-jsforj/src/test/resources/data/";

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
        filesStream = Files.newDirectoryStream(jpath);
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

        dumpProperties(obj, "  ");
      }
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  @Test
  public void testSimpleGroup() {
    try {
      final File jsonGroup = new File(dataPath + "simpleGroup.json");

      var obj = mapper.parse(new FileReader(jsonGroup));

      Assert.assertTrue("Not JSGroup", obj instanceof JSGroup);

      var group = (JSGroup)obj;

      var entries = group.getEntries();
      Assert.assertEquals("Not 2 entries", 2, entries.size());
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  @Test
  public void testBuildEvent() {
    try {
      final var event = factory.newValue(JSTypes.typeJSEvent);

      Assert.assertTrue("Not JSEvent", event instanceof JSEvent);

      event.addProperty(factory.makeProperty(JSPropertyNames.uid,
                                             UUID.randomUUID().toString()));

      var locations = event.addProperty(
              factory.makeProperty(JSPropertyNames.locations));

      JSLocation loc = (JSLocation)factory.newValue(JSTypes.typeLocation);
      var uid = UUID.randomUUID().toString();

      loc.setName("My new location");
      JSList<String> loctypes = loc.getLocationTypes();
      loctypes.add("airport");
      loc.setCoordinates("geo:40.7654,73.9876");

      locations.getValue().addProperty(factory.makeProperty(uid, loc));

      var rruleP = event.addProperty(
              factory.makeProperty(JSPropertyNames.recurrenceRule));

      JSRecurrenceRule rrule = (JSRecurrenceRule)rruleP.getValue();

      rrule.setFrequency(JSRecurrenceRule.freqWeekly);
      rrule.setCount(new UnsignedInteger(10));

      var participants = event.addProperty(
              factory.makeProperty(JSPropertyNames.participants));

      JSParticipant part =
              (JSParticipant)factory.newValue(JSTypes.typeParticipant);
      uid = UUID.randomUUID().toString();

      part.setName("Turkey Lurkey");
      part.setEmail("tlurkey@turkeys.example.com");
      part.setKind("turkey");
      part.setLanguage("gobble");
      part.setInvitedBy("thechicken@chickens.example.com");

      participants.getValue().addProperty(factory.makeProperty(uid, part));

      info("Dump of created event");
      dumpProperties(event, "  ");
      info(event.writeValueAsStringFormatted(mapper));
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  private void info(final String msg) {
    System.out.println(msg);
  }

  private void dumpProperties(final JSValue value,
                              final String indent) {
    final List<JSProperty> props;

    if (value.isObject()) {
      props = value.getProperties();
    } else if (value.isPropertyList()) {
      props = value.getPropertyList();
    } else {
      return;
    }

    for (final var prop: props) {
      info(indent + prop.getName() + ": " + prop.getType());

      var pval = prop.getValue();
      if (pval.isObject() || pval.isPropertyList()) {
        dumpProperties(pval, indent + "  ");
      }
    }
  }
}
