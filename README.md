veraPDF-validation
==================
*Greenfield PDF/A validation, feature reporting and metadata repair developed for veraPDF*

[![Build Status](https://travis-ci.org/veraPDF/veraPDF-validation.svg?branch=integration)](https://travis-ci.org/veraPDF/valdation "Travis-CI")
[![Build Status](http://jenkins.openpreservation.org/buildStatus/icon?job=veraPDF-validation)](http://jenkins.openpreservation.org/job/veraPDF-validation/ "OPF Jenkins Release")
[![Build Status](http://jenkins.openpreservation.org/buildStatus/icon?job=veraPDF-validation-dev)](http://jenkins.openpreservation.org/job/veraPDF-validation-dev/ "OPF Jenkins Development")
[![Maven Central](https://img.shields.io/maven-central/v/org.verapdf/validation.svg)](http://repo1.maven.org/maven2/org/verapdf/validation/ "Maven central")
[![CodeCov Coverage](https://img.shields.io/codecov/c/github/veraPDF/veraPDF-validation.svg)](https://codecov.io/gh/veraPDF/veraPDF-validation/ "CodeCov coverage")
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1d81323d73c04d2794032b6d6770a6ef)](https://www.codacy.com/app/veraPDF/veraPDF-validation?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=veraPDF/veraPDF-validation&amp;utm_campaign=Badge_Grade "Codacy grade")

[![GitHub issues](https://img.shields.io/github/issues/veraPDF/veraPDF-validation.svg)](https://github.com/veraPDF/veraPDF-validation/issues "Open issues on GitHub")
[![GitHub issues](https://img.shields.io/github/issues-closed/veraPDF/veraPDF-validation.svg)](https://github.com/veraPDF/veraPDF-validation/issues-closed "Open issues on GitHub")
[![GitHub issues](https://img.shields.io/github/issues-pr/veraPDF/veraPDF-validation.svg)](https://github.com/veraPDF/veraPDF-validation/issues-pr "Open issues on GitHub")
[![GitHub issues](https://img.shields.io/github/issues-pr-closed/veraPDF/veraPDF-validation.svg)](https://github.com/veraPDF/veraPDF-validation/issues-pr-closed "Open issues on GitHub")

Licensing
---------
The veraPDF Validation project is dual-licensed, see:

 - [GPLv3+](LICENSE.GPL "GNU General Public License, version 3")
 - [MPLv2+](LICENSE.MPL "Mozilla Public License, version 2.0")

Documentation
-------------
See the [veraPDF documentation site](http://docs.verapdf.org/).

Quick Start
-----------
### Pre-requisites

In order to build this project you'll need:

 * Java 7, which can be downloaded [from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html), or for Linux users [OpenJDK](http://openjdk.java.net/install/index.html).
 * [Maven v3+](https://maven.apache.org/)

### Building the veraPDF Validation Model

 1. Download the veraPDF-validation repository, either: `git clone https://github.com/veraPDF/veraPDF-validation`
 or download the [latest tar archive](https://github.com/veraPDF/veraPDF-validation/archive/integration.tar.gz "veraPDF-validation latest GitHub tar archive") or [zip equivalent](https://github.com/veraPDF/veraPDF-validation/archive/integration.zip "veraPDF-validation latest GitHub zip archive") from GitHub.
 2. Move to the downloaded project directory, e.g. `cd veraPDF-validation`
 3. Build and install using Maven: `mvn clean install`
