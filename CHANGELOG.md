# Release Notes

This project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## Unreleased (2.1.0-SNAPSHOT)

## [2.0.0] - 2025-06-27
* First jakarta release

## [1.1.2] - 2025-02-06
* Pre jakarta release.
* Update library versions
* Response classes moved to bw-base

## [1.1.1] - 2024-03-21
* Fix parsing of triggers
* Add description and title to alert
* Add ToIcal conversion class - incomplete
* Switch to static methods.
* Add calendarAddress property
* Make link.href a URI type
* Make location.coordinates a URI
* Initial handling of recurrence overrides.
* Add href as a String value to Link

## [1.1.0] - 2022-02-12
* Use bedework-parent for builds.
* Update library versions

## [1.0.2] - 2021-09-11
* Update library versions

## [1.0.1] - 2021-05-31
* String arrays, recurrence mods, overrides.
* Redo JSList classes to be more generic.
* Add relations and links classes.
* Add locations type.
* Use genetics for properties
* Introduce integer types and add tests for recurrence rule elements.
* Add a JSMAP class and use for a number of property types.
* Add a JsforjException
* Add ability to skip generated properties in overrides - e.g. start and recurrence id.
* Many more changes...

## [1.0.0] - 2020-03-20
* Initial version. Will parse and output jscalendar objects. Can be used to programmatically build them.
