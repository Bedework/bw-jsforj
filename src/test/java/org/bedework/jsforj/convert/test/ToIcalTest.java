/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.convert.test;

import org.bedework.jsforj.convert.ToIcal;
import org.bedework.jsforj.impl.JSMapper;
import org.bedework.jsforj.model.JSCalendarObject;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.String.format;

/**
 * User: mike Date: 1/7/24 Time: 23:45
 */
public class ToIcalTest {
  private static final JSMapper mapper = new JSMapper();

  private final static String dataPath =
          "src/test/resources/data/convert";

  @Test
  public void testConvert() {
    try {
      final Path jpath = FileSystems.getDefault().getPath(dataPath);

      Assert.assertTrue(format("%s not a directory", jpath),
                        jpath.toFile().isDirectory());

      try (final var dirStream = Files.newDirectoryStream(jpath)) {
        for (final Path dirPath: dirStream) {
          Assert.assertTrue(format("%s not a directory", dirPath),
                            dirPath.toFile().isDirectory());

          try (final var filesStream = Files.newDirectoryStream(dirPath)) {
            File ics = null;
            File json = null;

            for (final Path path: filesStream) {
              final File f = path.toFile();

              Assert.assertTrue(format("%s not a file", path),
                                f.isFile());

              final var name =  f.getName();

              if (name.endsWith(".ics")) {
                Assert.assertNull(format("Expect only 1 ics file found %s and %s in %s",
                                            ics, name, dirPath), ics);

                ics = f;
                continue;
              }

              if (name.endsWith(".json")) {
                Assert.assertNull(format("Expect only 1 json file found %s and %s in %s",
                                            json, name, dirPath), json);

                json = f;
                continue;
              }

              Assert.fail(format("Expect only 1 json and ics file: found %s in %s",
                                 name, dirPath));
            }

            Assert.assertNotNull(format("Expect exactly 1 ics file in %s",
                               dirPath));

            Assert.assertNotNull(format("Expect exactly 1 json file in %s",
                               dirPath));

            info(format("ics: %s, json: %s", ics, json));

            final JSCalendarObject jscal = mapper.parse(new FileReader(json));

            info(jscal.writeValueAsStringFormatted(mapper));

            final var resp = ToIcal.convert(jscal);

            if (!resp.isOk()) {
              Assert.fail(format("Failed to convert with message %s",
                          resp.getMessage()));
            }

            info(resp.getEntity().toString());
          }
        }
      }
    } catch (final Throwable t) {
      error(t);
    }
  }

  private void info(final String msg) {
    System.out.println(msg);
  }

  private void error(final Throwable t) {
    t.printStackTrace(System.err);
    Assert.fail(t.getMessage());
  }
}
