# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).

## Compatibility
The library offers compatibility contracts on the Java API and the POM.

## Java API
The API consists of all public Java types from `com.atlassian.performance.tools.report.api` and its subpackages:

  * [source compatibility]
  * [binary compatibility]
  * [behavioral compatibility] with behavioral contracts expressed via Javadoc

[source compatibility]: http://cr.openjdk.java.net/~darcy/OpenJdkDevGuide/OpenJdkDevelopersGuide.v0.777.html#source_compatibility
[binary compatibility]: http://cr.openjdk.java.net/~darcy/OpenJdkDevGuide/OpenJdkDevelopersGuide.v0.777.html#binary_compatibility
[behavioral compatibility]: http://cr.openjdk.java.net/~darcy/OpenJdkDevGuide/OpenJdkDevelopersGuide.v0.777.html#behavioral_compatibility

### POM
Changing the license is breaking a contract.
Adding a requirement of a major version of a dependency is breaking a contract.
Dropping a requirement of a major version of a dependency is a new contract.

## [Unreleased]
[Unreleased]: https://github.com/atlassian/report/compare/release-4.5.0...master

## [4.5.0] - 2024-07-01
[4.5.0]: https://github.com/atlassian/report/compare/release-4.4.0...release-4.5.0

### Added
- Add `MutableJvmSymbol`, `JfrFilter.Builder.symbolModifier` and `MultiJfrFilter.Builder.symbolModifier`.
  They allow for mutating JVM symbols in JFR files, e.g. to normalize dynamic proxy names or lambda names.
  This way, the same JVM code can be profiled multiple times and resulting JFRs can be merged or diffed.
- Add `DynamicProxyNormalization`.

## [4.4.0] - 2024-01-18
[4.4.0]: https://github.com/atlassian/report/compare/release-4.3.0...release-4.4.0

## 4.3.1 - 2024-01-18

It was a botched 4.4.0 release. Don't use new APIs from this version, switch to 4.4.0 instead.

### Added
- Add `ActionMetricExplainer` and `DurationDrilldown` for explaining `ActionMetric.duration`. Unblock [JPERF-1454].

[JPERF-1454]: https://ecosystem.atlassian.net/browse/JPERF-1454

## [4.3.0] - 2023-12-13
[4.3.0]: https://github.com/atlassian/report/compare/release-4.2.0...release-4.3.0

### Added
- Add `MultiJfrFilter` to process input once and create multiple outputs. Aid [JPERF-1409].

## [4.2.0] - 2023-12-11
[4.2.0]: https://github.com/atlassian/report/compare/release-4.1.0...release-4.2.0

### Added
- Expose `RawCohortResult.cohort`.

## [4.1.0] - 2023-11-30
[4.1.0]: https://github.com/atlassian/report/compare/release-4.0.0...release-4.1.0

### Added
- Link to `EdibleResult.raw`, which can include useful artifacts for reports and analysis (e.g. JFR). Aid [JPERF-1409].

## [4.0.0] - 2023-10-31
[4.0.0]: https://github.com/atlassian/report/compare/release-3.16.3...release-4.0.0

### Added
- Add JfrFilter to allow finding bottlenecks of slow requests in JFR profile. Resolve [JPERF-1409].
 
### Removed
- Drop support for java 1.8.
 
[JPERF-1409]: https://ecosystem.atlassian.net/browse/JPERF-1409

## [3.16.3] - 2023-10-09
[3.16.3]: https://github.com/atlassian/report/compare/release-3.16.2...release-3.16.3

### Fixed
- Speed up all JSON code, by reusing a `JsonProvider` instance. Fix [JPERF-1401].

[JPERF-1401]: https://ecosystem.atlassian.net/browse/JPERF-1401

## [3.16.2] - 2023-10-06
[3.16.2]: https://github.com/atlassian/report/compare/release-3.16.1...release-3.16.2

### Fixed
- Make `LatencyImpactClassifier` thread safe. Unblock [JPERF-1263].

[JPERF-1263]: https://ecosystem.atlassian.net/browse/JPERF-1263

## [3.16.1] - 2023-08-23
[3.16.1]: https://github.com/atlassian/report/compare/release-3.16.0...release-3.16.1

### Fixed
- Don't throw when asking for shifts in `ShiftedDistributionRegressionTest`. Fix [JPERF-1256].

[JPERF-1256]: https://ecosystem.atlassian.net/browse/JPERF-1256

## [3.16.0] - 2023-08-10
[3.16.0]: https://github.com/atlassian/report/compare/release-3.15.0...release-3.16.0

### Added
- Add `LatencyImpactClassifier` to offer `ClassifiedLatencyImpact` with `ImpactClassification`s and confidence without having to parse markdown files.
- Add `api.impact.LatencyImpactMarkdownTable`, a replacement for `api.LatencyImpactMarkdownTable`, which can integrate with the new `LatencyImpactClassifier`.

### Deprecated
- Deprecate `api.LatencyImpactMarkdownTable` in favor of `api.impact.LatencyImpactMarkdownTable`.

### Fixed
- Sort impact tables by action alphabetically.

## [3.15.0] - 2023-07-03
[3.15.0]: https://github.com/atlassian/report/compare/release-3.14.0...release-3.15.0

### Added
- Add `LatencyImpact` and `LatencyImpact.Builder`. Unblock [JPERF-1160].
- Add `RelativeNonparametricPerformanceJudge.Builder`.
- Add `RelativeTypicalPerformanceJudge.Builder`.
- Emit `LatencyImpact` events from `RelativeNonparametricPerformanceJudge`. Unblock [JPERF-1160].
- Emit `LatencyImpact` events from `RelativeTypicalPerformanceJudge`. Unblock [JPERF-1160].
- Render `LatencyImpactMarkdownTable`. Unblock [JPERF-1160].

### Deprecated
- Deprecate `RelativeNonparametricPerformanceJudge` constructors in favor of its `Builder`.
- Deprecate `RelativeTypicalPerformanceJudge` constructor in favor of its `Builder`.

### Fixed
- Fix `RelativeNonparametricPerformanceJudge` and `RelativeTypicalPerformanceJudge` treating improvements as irrelevant.

[JPERF-1160]: https://ecosystem.atlassian.net/browse/JPERF-1160

## [3.14.0] - 2023-04-03
[3.14.0]: https://github.com/atlassian/report/compare/release-3.13.1...release-3.14.0

### Added
- Add `JqlReport`, which can handle multiple JQL `ActionType`s. Fix [JPERF-1059].

### Fixed
- Support `SEARCH_JQL_CHANGELOG`, `SEARCH_WITH_JQL_WILDCARD`, `SEARCH_JQL_SIMPLE` in `SearchJqlReport`.

### Deprecated
- Deprecate `SearchJqlReport` in favor of more flexible `JqlReport`.

[JPERF-1059]: https://ecosystem.atlassian.net/browse/JPERF-1059

## [3.13.1] - 2023-03-14
[3.13.1]: https://github.com/atlassian/report/compare/release-3.13.0...release-3.13.1

### Fixed
- Fix missing waterfall highlights. Fix [JPERF-1021].

[JPERF-1021]: https://ecosystem.atlassian.net/browse/JPERF-1021

## [3.13.0] - 2022-12-16
[3.13.0]: https://github.com/atlassian/report/compare/release-3.12.0...release-3.13.0

### Deprecated
- Mark `RelativeNonparametricStabilityJudge` as deprecated.

## [3.12.0] - 2022-10-27
[3.12.0]: https://github.com/atlassian/report/compare/release-3.11.5...release-3.12.0

### Added
- Add `Verdict.Builder` for easier `Verdict` assembly and `failedActions` injection.

### Deprecated
- Mark `Verdict` constructor as deprecated.

### Fixed
- Fix `Verdict.plus` dropping the `failedActions`.
 
## [3.11.5] - 2022-10-20
[3.11.5]: https://github.com/atlassian/report/compare/release-3.11.4...release-3.11.5

### Fixed
- Restore missing label for failed report's assertion message in `RelativeNonparametricPerformanceJudge` [JPERF-832].
- Reword failed report's assertion message in `RelativeNonparametricPerformanceJudge` so it looks better in logs [JPERF-832].


## [3.11.4] - 2022-10-14
[3.11.4]: https://github.com/atlassian/report/compare/release-3.11.3...release-3.11.4

### Fixed
- Make log message for failed regression test more user friendly [JPERF-832].

[JPERF-832]: https://ecosystem.atlassian.net/browse/JPERF-832

## [3.11.3] - 2022-06-23
[3.11.3]: https://github.com/atlassian/report/compare/release-3.11.2...release-3.11.3

Empty release to test changes in release process.

## [3.11.2] - 2022-04-07
[3.11.2]: https://github.com/atlassian/report/compare/release-3.11.1...release-3.11.2

### Fixed
- Bump log4j dependency to 2.17.2

## [3.11.1] - 2021-07-12
[3.11.1]: https://github.com/atlassian/report/compare/release-3.11.0...release-3.11.1

### Fixed
- Prevent waterfall chart from failing when drilldown performance measurement lists are empty. Unblock [JPERF-747].

[JPERF-747]: https://ecosystem.atlassian.net/browse/JPERF-747

## [3.11.0] - 2021-06-08
[3.11.0]: https://github.com/atlassian/report/compare/release-3.10.1...release-3.11.0

### Added
- Produce CSV report alongside plaintext version.

## [3.10.1] - 2020-12-09
[3.10.1]: https://github.com/atlassian/report/compare/release-3.10.0...release-3.10.1

Test release, no important changes here.

## [3.10.0] - 2020-12-04
[3.10.0]: https://github.com/atlassian/report/compare/release-3.9.0...release-3.10.0

### Added
- Expose Verdict reports.

## [3.9.0] - 2020-12-02
[3.9.0]: https://github.com/atlassian/report/compare/release-3.8.2...release-3.9.0

### Added
- Expose Verdict result.
- Expose IndependentCohortsJudge method that judges a single result.

## [3.8.2] - 2020-04-06
[3.8.2]: https://github.com/atlassian/report/compare/release-3.8.1...release-3.8.2

### Fixed
- The tooltips shown on hover in timeline chart are now correct. Resolve [JPERF-614].

[JPERF-614]: https://ecosystem.atlassian.net/browse/JPERF-614
## [3.8.1] - 2020-03-03
[3.8.1]: https://github.com/atlassian/report/compare/release-3.8.0...release-3.8.1

### Fixed
- Emit useful errors from `RelativePerformanceStabilityJudge`.

## [3.8.0] - 2019-09-30
[3.8.0]: https://github.com/atlassian/report/compare/release-3.7.1...release-3.8.0

### Added 
- Parametrize `RawCohortResult.Factory` with `MetricJsonFormat` to avoid drilldown parsing. Work around [JPERF-395].

[JPERF-395]: https://ecosystem.atlassian.net/browse/JPERF-395

## [3.7.1] - 2019-09-20
[3.7.1]: https://github.com/atlassian/report/compare/release-3.7.0...release-3.7.1

### Fixed
- Remove the confusing histogram from the distribution comparison in the `FullReport`. Resolve [JPERF-475].
- Explain what the quantile function is.
- Sort the action labels on the distribution comparison.

[JPERF-475]: https://ecosystem.atlassian.net/browse/JPERF-475

## [3.7.0] - 2019-09-16
[3.7.0]: https://github.com/atlassian/report/compare/release-3.6.1...release-3.7.0

### Added
- Show the entire cohort latency distribution. Resolve [JPERF-575].

[JPERF-575]: https://ecosystem.atlassian.net/browse/JPERF-575

## [3.6.1] - 2019-08-09
[3.6.1]: https://github.com/atlassian/report/compare/release-3.6.0...release-3.6.1

### Fixed
- Make nonparametric judges more specific about the failure type. Resolve [JPERF-551].

[JPERF-551]: https://ecosystem.atlassian.net/browse/JPERF-551

## [3.6.0] - 2019-07-25
[3.6.0]: https://github.com/atlassian/report/compare/release-3.5.0...release-3.6.0

### Added
- Add `failedActions` property to `Verdict`. Resolve [JPERF-537].

[JPREF-537]: https://ecosystem.atlassian.net/browse/JPERF-537

## [3.5.0] - 2019-07-05
[3.5.0]: https://github.com/atlassian/report/compare/release-3.4.0...release-3.5.0

### Fixed
- Inform about over-cropping action metric timelines. Fix [JPERF-152].
- Stop ignoring OutlierTrimming in MaximumCoverageJudge. Fix [JPERF-443].

### Deprecated
- Deprecate `EdibleResult.actionStats` in favour of `EdibleResult.stats` field.
- Deprecate `StatsMeter` in favour of `EdibleResult`.

[JPREF-152]: https://ecosystem.atlassian.net/browse/JPERF-152
[JPERF-443]: https://ecosystem.atlassian.net/browse/JPERF-443

## [3.4.0] - 2019-06-13
[3.4.0]: https://github.com/atlassian/report/compare/release-3.3.1...release-3.4.0

### Added
- Add second constructor with significance parameter to `RelativeNonparametricStabilityJudge` and `RelativeNonparametricPerformanceJudge`. Resolve [JPERF-500].

[JPREF-500]: https://ecosystem.atlassian.net/browse/JPERF-500

## [3.3.1] - 2019-06-10
[3.3.1]: https://github.com/atlassian/report/compare/release-3.3.0...release-3.3.1

### Fixed
- Use SuanShu's Kolmogorov-Smirnov implementation. Fix [JPERF-495].

[JPREF-495]: https://ecosystem.atlassian.net/browse/JPERF-495

## [3.3.0] - 2019-06-06
[3.3.0]: https://github.com/atlassian/report/compare/release-3.2.2...release-3.3.0

### Added
- Add `ShiftedDistributionRegressionTest`, `RelativeNonparametricPerformanceJudge` and `RelativePerformanceStabilityJudge` which are necessary for [JPERF-493].

[JPREF-493]: https://ecosystem.atlassian.net/browse/JPERF-493

## [3.2.2] - 2019-05-30
[3.2.2]: https://github.com/atlassian/report/compare/release-3.2.1...release-3.2.2

### Fixed
- Trim outliers properly. Fix [JPERF-490].

[JPREF-490]: https://ecosystem.atlassian.net/browse/JPERF-490

## [3.2.1] - 2019-05-10
[3.2.1]: https://github.com/atlassian/report/compare/release-3.2.0...release-3.2.1

### Fixed
- Do not fail Waterfall chart creation when resource URL contains data URI scheme. Fix [JPERF-481].

[JPREF-481]: https://ecosystem.atlassian.net/browse/JPERF-481

## [3.2.0] - 2019-04-30
[3.2.0]: https://github.com/atlassian/report/compare/release-3.1.3...release-3.2.0

### Added
- Add `TableReporter` for HTML table reports. Resolve [JPERF-452].
- Expose detailed performance stats. Resolve [JPERF-455].

### Fixed
- Read `jstat` logs in any order. Fix [JPERF-462].
- Include HTML table report in `FullReport`. 
- Make `Jstat Converter` idempotent. Fix [JPERF-464].
- Fix intensive logging in `WaterfallChart`. Resolve [JPREF-369].

[JPREF-369]: https://ecosystem.atlassian.net/browse/JPERF-369

### Deprecated
- Deprecate `BaselineComparingJuge.judge` in favour of an overloaded method.
- Deprecate `ErrorsJudge.judge` in favour of an overloaded method.
- Deprecate `IndependentCohortsJudge.judge` in favour of an overloaded method.
- Deprecate `RelativeTypicalPerformanceJudge.judge` in favour of an overloaded method.
- Deprecate `SampleSizeJudge.judge` in favour of an overloaded method.
- Deprecate `InteractionStats` in favour of `Stats`.
- Deprecate `StatsMeter.measure` in favour of `StatsMeter.measurePerformance`
- Deprecate `DataReporter` in favour of `CohortsSummaryTable`

[JPERF-462]: https://ecosystem.atlassian.net/browse/JPERF-462
[JPERF-452]: https://ecosystem.atlassian.net/browse/JPERF-452
[JPERF-464]: https://ecosystem.atlassian.net/browse/JPERF-464
[JPERF-455]: https://ecosystem.atlassian.net/browse/JPERF-455

## 3.1.4 - 2019-04-30

It was a botched 3.2.0 release. Don't use new APIs from this version, switch to 3.2.0 instead.

## [3.1.3] - 2019-03-20
[3.1.3]: https://github.com/atlassian/report/compare/release-3.1.2...release-3.1.3

### Fixed
- Replace '-' character to prevent java.lang.NumberFormatException. Resolve [JPERF-426].

[JPERF-426]: https://ecosystem.atlassian.net/browse/JPERF-426

## [3.1.2] - 2019-03-15
[3.1.2]: https://github.com/atlassian/report/compare/release-3.1.1...release-3.1.2

### Fixed
- Do not throw negative phase exception in `WaterfallChart` when `responseEnd` is before `responseStart`. Fix [JPERF-416].
- Move the legend on the distribution chart to the side. Resolve [JPERF-421].
- Group labels in distribution chart by cohort. Resolve [JPERF-421].

[JPERF-416]: https://ecosystem.atlassian.net/browse/JPERF-416
[JPERF-421]: https://ecosystem.atlassian.net/browse/JPERF-421

## [3.1.1] - 2019-01-23
[3.1.1]: https://github.com/atlassian/report/compare/release-3.1.0...release-3.1.1

### Fixed
- Fix nullability issue in `WaterfallChart`. Resolve [JPERF-365].

[JPERF-365]: https://ecosystem.atlassian.net/browse/JPERF-365

## [3.1.0] - 2019-01-22
[3.1.0]: https://github.com/atlassian/report/compare/release-3.0.0...release-3.1.0

### Added
- Expose failure and results in `CohortResult`.
- Add `RawCohortResult`. Unblock [JPERF-363].

### Deprecated
- Deprecate `CohortResult` in favour of `RawCohortResult`.
- Deprecate `FullCohortResult` in favour of `RawCohortResult.Factory`.
- Deprecate `FailedCohortResult` in favour of `RawCohortResult.Factory`.

[JPERF-363]: https://ecosystem.atlassian.net/browse/JPERF-363

## [3.0.0] - 2019-01-17
[3.0.0]: https://github.com/atlassian/report/compare/release-2.6.0...release-3.0.0

### Added
- Add `WaterfallHighlightReport`.
- Enable `WaterfallHighlightReport` in `FullReport`. Resolve [JPERF-316].

### Removed
- Drop support for `jira-actions:2`.
- Remove Kotlin data-class generated methods from API for `Verdict`, `DurationData`, `EdibleResult`, `InteractionStats`, `PerformanceCriteria`.
- Remove all deprecated API: primary constructor of `EdibleResult`, `HistoricalCohortsReporter#report(report: Path)`.

[JPERF-316]: https://ecosystem.atlassian.net/browse/JPERF-316

## [2.6.0] - 2019-01-11
[2.6.0]: https://github.com/atlassian/report/compare/release-2.4.0...release-2.6.0

### Fixed
- Remove `WaterfallHighlightReport` in order to restore compatibility with `jira-actions:[2.0.0,3.1.0)`.  
  This is not a breaking change, because the API from 2.5.0 was not stable.  

## 2.5.0 - 2019-01-10

### INCOMPATIBILITY BUG
2.5.0 is botched.
Don't use new APIs from this version. It's not compatible with `jira-actions:[2.0.0,3.1.0)`. 
Roll back to 2.4.0 or roll forward to 2.6.0 or later to restore this compatibility.

### Added
- Add `WaterfallHighlightReport`.
- Enable `WaterfallHighlightReport` in `FullReport`. Resolve [JPERF-316].

[JPERF-316]: https://ecosystem.atlassian.net/browse/JPERF-316

## [2.4.0] - 2019-01-08
[2.4.0]: https://github.com/atlassian/report/compare/release-2.3.1...release-2.4.0

### Added
- Provide builder for EdibleResult.
- Provide API to perform calculations on action metrics. Resolves [JPERF-338].

[JPERF-338]: https://ecosystem.atlassian.net/browse/JPERF-338

## [2.3.1] - 2019-01-08
[2.3.1]: https://github.com/atlassian/report/compare/release-2.3.0...release-2.3.1

### Fixed
- Create a JUnit report from exceptions containing '%' character. Fix [JPERF-339].

[JPERF-339]: https://ecosystem.atlassian.net/browse/JPERF-339

## [2.3.0] - 2018-11-29
[2.3.0]: https://github.com/atlassian/report/compare/release-2.2.3...release-2.3.0

### Added
- Add support for `infrastructure:3`.
- Add support for `infrastructure:4`.
- Add support for `jira-actions:3`.
- Add support for `virtual-users:3`.

## [2.2.3] - 2018-10-31
[2.2.3]: https://github.com/atlassian/report/compare/release-2.2.2...release-2.2.3

### Fixed
- Fix NPE in `RelativeTypicalPerformanceJudge` when action results are missing. Fix [JPERF-248].

[JPERF-248]: https://ecosystem.atlassian.net/browse/JPERF-248

## [2.2.2] - 2018-10-23
[2.2.2]: https://github.com/atlassian/report/compare/release-2.2.1...release-2.2.2

### Fixed
- Restore original column ordering in `IndependentCohortsJudge`. Fix [JPERF-192].

[JPERF-192]: https://ecosystem.atlassian.net/browse/JPERF-192

## [2.2.1] - 2018-09-21
[2.2.1]: https://github.com/atlassian/report/compare/release-2.2.0...release-2.2.1

### Fixed
- Skip secondary verdicts if failure verdict is negative. Fix [JPERF-106].

[JPERF-106]: https://ecosystem.atlassian.net/browse/JPERF-106

## [2.2.0] - 2018-09-13
[2.2.0]: https://github.com/atlassian/report/compare/release-2.1.0...release-2.2.0

### Added 
- Log test errors in `EdibleResult`.

### Fixed
- Fix date conversion in `MeanLatencyChart`. Fix [JPERF-77](https://ecosystem.atlassian.net/browse/JPERF-77).

## [2.1.0] - 2018-09-11
[2.1.0]: https://github.com/atlassian/report/compare/release-2.0.0...release-2.1.0

### Added
- Add mean latency chart. Resolve [JPERF-65](https://ecosystem.atlassian.net/browse/JPERF-65).

### Fixed
- Abbreviate action names in plain text report.
- Fix SampleSizeJudge when sample size is missing. Fix [JPERF-59](https://ecosystem.atlassian.net/browse/JPERF-59).

### Deprecated
- Deprecate `HistoricalCohortsReporter#report(report: Path)`.

## [2.0.0] - 2018-09-06
[2.0.0]: https://github.com/atlassian/report/compare/release-1.0.0...release-2.0.0

### Changed 
- Use stable APT APIs.
- Require APT `infrastructure:2`.
- Require APT `virtual-users:1`.
- API of `Timelines`.

### Added
- Add APT `virtual-users:2` compatibility.

### Fixed
- Sort plain text report's actions alphabetically.
- Linear interpolation on charts.

## [1.0.0] - 2018-08-24
[1.0.0]: https://github.com/atlassian/report/compare/release-0.0.3...release-1.0.0

### Changed
- Define the public API.

### Added
- Include the plain text report in the full report.

### Fixed
- Extract reports from judges.
- Depend on a stable APT `infrastructure` version.

## [0.0.3] - 2018-08-22
[0.0.3]: https://github.com/atlassian/report/compare/release-0.0.2...release-0.0.3

### Added
- Add plain text report.

## [0.0.2] - 2018-08-21
[0.0.2]: https://github.com/atlassian/report/compare/release-0.0.1...release-0.0.2

### Added
- Add missing [CHANGELOG.md](CHANGELOG.md).

### Fixed
- Depend on a stable version of APT `workspace`.

## [0.0.1] - 2018-08-06
[0.0.1]: https://github.com/atlassian/report/compare/initial-commit...release-0.0.1

### Added
- Migrate performance reporting from [JPT submodule].
- Add [README.md](README.md).
- Configure Bitbucket Pipelines.

[JPT submodule]: https://stash.atlassian.com/projects/JIRASERVER/repos/jira-performance-tests/browse/report?at=b63a98c0283b875b212962237b3e3a04e24006cf
