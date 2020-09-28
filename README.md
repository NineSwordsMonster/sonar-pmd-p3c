# SonarQube P3C PMD Plugin 

Sonar-PMD-P3c is a plugin that provides coding rules from 
[PMD](https://pmd.github.io/) and [P3C](https://github.com/alibaba/p3c).

For a list of all rules and their status, see: [RULES.md](https://github.com/jensgerdes/sonar-pmd/blob/master/docs/RULES.md)

## Installation
The plugin is available in the SonarQube marketplace and should preferably be installed from within SonarQube (Administration -->  Marketplace --> Search _pmd_).

Alternatively, download the [latest JAR file](https://github.com/jensgerdes/sonar-pmd/releases/latest), put it into the plugin directory (`./extensions/plugins`) and restart SonarQube.

## Usage
Usage should be straight forward:
1. Activate some PMD rules in your quality profile.
2. Run an analysis.

### Troubleshooting
Sonar-PMD analyzes the given source code with the Java source version defined in your Gradle or Maven project.
In case you are not using one of these build tools, PMD uses the default Java version - which is **1.6**.  

If that does not match the version you are using, set the `sonar.java.source` property to tell PMD which version of Java your source code complies to. 

Possible values: 
- 1.4
- 1.5 or 5 
- 1.6 or 6 
- 1.7 or 7 
- 1.8 or 8
- 9
- 10
- 11

## Description / Features
PMD Plugin|2.0|2.1|2.2|2.3|2.4.1|2.5|2.6|3.0.0|3.1.x|3.2.x
-------|---|---|---|---|---|---|---|---|---|---
PMD|4.3|4.3|5.1.1|5.2.1|5.3.1|5.4.0|5.4.2|5.4.2|6.9.0|6.10.0
Max. supported Java Version | |  |  |  |  | 1.7 | 1.8 | 1.8 | 11 |
Min. SonarQube Version |  |  |  |  |  | 4.5.4 | 4.5.4 | 6.6 | 6.6 |

A majority of the PMD rules have been rewritten in the Java plugin. Rewritten rules are marked "Deprecated" in the PMD plugin, but a [concise summary of replaced rules](http://dist.sonarsource.com/reports/coverage/pmd.html) is available.

## Rules on test
PMD tool provides some rules that can check the code of JUnit tests. Please note that these rules (and only these rules) will be applied only on the test files of your project.

## License
Sonar-PMD is licensed under the [GNU Lesser General Public License, Version 3.0](https://github.com/jensgerdes/sonar-pmd/blob/master/LICENSE.md).

Parts of the rule descriptions displayed in SonarQube have been extracted from [PMD](https://pmd.github.io/) and are licensed under a [BSD-style license](https://github.com/pmd/pmd/blob/master/LICENSE).  

