veraPDF-validation
==================
*Greenfield PDF/A and PDF/UA validation, feature reporting and metadata repair developed for veraPDF*

[![Build Status](https://jenkins.openpreservation.org/job/veraPDF/job/1.25/job/validation-arlington/badge/icon)](https://jenkins.openpreservation.org/job/veraPDF/job/1.25/job/validation-arlington/ "OPF Jenkins")
[![Maven Central](https://img.shields.io/maven-central/v/org.verapdf/validation.svg)](https://repo1.maven.org/maven2/org/verapdf/validation/ "Maven central")
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/34416471585a474e85e7821d61048d1c)](https://app.codacy.com/gh/veraPDF/veraPDF-validation/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade "Codacy grade")

[![GitHub issues](https://img.shields.io/github/issues/veraPDF/veraPDF-library.svg)](https://github.com/veraPDF/veraPDF-library/issues "Open issues on GitHub")
[![GitHub issues](https://img.shields.io/github/issues-closed/veraPDF/veraPDF-library.svg)](https://github.com/veraPDF/veraPDF-library/issues?q=is%3Aissue+is%3Aclosed "Closed issues on GitHub")
[![GitHub issues](https://img.shields.io/github/issues-pr/veraPDF/veraPDF-validation.svg)](https://github.com/veraPDF/veraPDF-validation/pulls "Open pull requests on GitHub")
[![GitHub issues](https://img.shields.io/github/issues-pr-closed/veraPDF/veraPDF-validation.svg)](https://github.com/veraPDF/veraPDF-validation/pulls?q=is%3Apr+is%3Aclosed "Closed pull requests on GitHub")

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

 * Java 8 - 17, which can be downloaded [from Oracle](https://www.oracle.com/technetwork/java/javase/downloads/index.html), or for Linux users [OpenJDK](https://openjdk.java.net/install/index.html).
 * [Maven v3+](https://maven.apache.org/)

### Building the veraPDF Validation Model

 1. Download the veraPDF-validation repository, either: `git clone https://github.com/veraPDF/veraPDF-validation`
 or download the [latest tar archive](https://github.com/veraPDF/veraPDF-validation/archive/integration.tar.gz "veraPDF-validation latest GitHub tar archive") or [zip equivalent](https://github.com/veraPDF/veraPDF-validation/archive/integration.zip "veraPDF-validation latest GitHub zip archive") from GitHub.
 2. Move to the downloaded project directory, e.g. `cd veraPDF-validation`
 3. Build and install using Maven: `mvn clean install`
