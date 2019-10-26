/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.jsforj.test;

import org.bedework.jsforj.impl.JSMapper;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * User: mike Date: 10/25/19 Time: 16:39
 */
public class JsForJTest {
  private final static String dataPath =
          "/Users/mike/bedework/quickstart-dev/bw-jsforj/src/test/resources/data";
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

        final JSMapper mapper = new JSMapper();

        mapper.parse(new FileReader(f));
      }
    } catch (final Throwable t) {
      throw new RuntimeException(t);
    }
  }

  private void info(final String msg) {
    System.out.println(msg);
  }
}
