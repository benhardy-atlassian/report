package com.atlassian.performance.tools.report.api.judge

import com.atlassian.performance.tools.jiraactions.api.ActionType
import com.atlassian.performance.tools.report.api.junit.FailedAssertionJUnitReport
import com.atlassian.performance.tools.report.api.junit.SuccessfulJUnitReport
import com.atlassian.performance.tools.report.api.result.InteractionStats
import com.atlassian.performance.tools.report.api.result.Stats
import com.atlassian.performance.tools.report.result.PerformanceStats
import java.time.Duration

class RelativePerformanceStabilityJudge {

    @Deprecated("Use the other judge method")
    internal fun judge(
        maxDispersionDifferences: Map<ActionType<*>, Duration>,
        baselineStats: InteractionStats,
        experimentStats: InteractionStats
    ): Verdict = this.judge(
        maxDispersionDifferences = maxDispersionDifferences,
        baselineStats = PerformanceStats.adapt(baselineStats),
        experimentStats = PerformanceStats.adapt(experimentStats)
    )

    internal fun judge(
        maxDispersionDifferences: Map<ActionType<*>, Duration>,
        baselineStats: Stats,
        experimentStats: Stats
    ): Verdict {
        val verdict = Verdict.Builder()
        maxDispersionDifferences.forEach { (action, maxDispersionDifference) ->
            val label = action.label
            val experimentDispersion = dispersions(experimentStats, label)
            val baselineDispersion = dispersions(baselineStats, label)
            val regression = experimentDispersion - baselineDispersion
            val reportName = "Stability regression for $label ${experimentStats.cohort} vs ${baselineStats.cohort}"
            val report = if (regression > maxDispersionDifference) {
                val message = "$label $regression stability regression overcame $maxDispersionDifference threshold"
                FailedAssertionJUnitReport(reportName, message)
            } else {
                SuccessfulJUnitReport(testName = reportName)
            }
            verdict.addReport(report)
        }
        return verdict.build()
    }

    private fun dispersions(stats: Stats, label: String) =
        stats.dispersions[label] ?: error("No action $label for the cohort ${stats.cohort}")
}
