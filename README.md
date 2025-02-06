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

### 1.0.1
 * String arrays, recurrence mods, overrides.
 * Redo JSList classes to be more generic.
 * Add relations and links classes.
 * Add locations type.
 * Add locations type.
 * Use genetics for properties
 * Introduce integer types and add tests for recurrence rule elements.
 * Add a JSMAP class and use for a number of property types.
 * Add a JsforjException
 * Add ability to skip generated properties in overrides - e.g. start and recurrence id.
 * Many more changes...

### 1.0.2
* Update library versions

### 1.1.0
* Use bedework-parent for builds.
* Update library versions

### 1.1.1
* Fix parsing of triggers
* Add description and title to alert
* Add ToIcal conversion class - incomplete
* Switch to static methods.
* Add calendarAddress property
* Make link.href a URI type
* Make location.coordinates a URI
* Initial handling of recurrence overrides.
* Add href as a String value to Link

### 1.1.2
* Update library versions
* Response classes moved to bw-base
* Pre jakarta release
