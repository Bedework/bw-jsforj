# bw-jsforj [![Build Status](https://travis-ci.org/Bedework/bw-jsforj.svg)](https://travis-ci.org/Bedework/bw-jsforj)

This project provides a number of classes and methods to handle jscalendar and jscontacts for
[Bedework](https://www.apereo.org/projects/bedework).

## Requirements

1. JDK 11
2. Maven 3

## Building Locally

> mvn clean install

## Releasing

Releases of this fork are published to Maven Central via Sonatype.

To create a release, you must have:

1. Permissions to publish to the `org.bedework` groupId.
2. `gpg` installed with a published key (release artifacts are signed).

To perform a new release use the release script:

> ./bedework/build/quickstart/linux/util-scripts/release.sh <module-name> "<release-version>" "<new-version>-SNAPSHOT"

When prompted, indicate all updates are committed

For full details, see [Sonatype's documentation for using Maven to publish releases](http://central.sonatype.org/pages/apache-maven.html).

For full details, see [Sonatype's documentation for using Maven to publish releases](http://central.sonatype.org/pages/apache-maven.html).

## Release Notes
### 1.0.0
    * Initial version. Will parse and output jscalendar objects. Can be used to programmatically build them.

