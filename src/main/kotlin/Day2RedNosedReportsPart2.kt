package com.denec

class Day2RedNosedReportsPart2 {
    fun solve(reports: List<List<Int>>): Int {
        return reports.stream()
            .filter { report -> isSafe(report, false) || isSafe(report, true) }
            .count().toInt()
    }

    private fun isSafe(report: List<Int>, increasing: Boolean): Boolean {
        var tolerated = false
        var skipNext = false
        for (i in 1..report.lastIndex) {
            if (skipNext) {
                skipNext = false
                continue
            }

            if (!isGood(report, i - 1, i, increasing)) {
                if (!tolerated) {
                    if (isGood(report, i - 1, i + 1, increasing)) {
                        tolerated = true
                        skipNext = true
                    } else if (isGood(report, i - 2, i, increasing) && isGood(report, i, i + 1, increasing)) {
                        tolerated = true
                        skipNext = true
                    } else {
                        return false
                    }
                } else {
                    return false
                }
            }

        }
        return true
    }

    private fun isGood(report: List<Int>, firstIndex: Int, secondIndex: Int, increasing: Boolean = true): Boolean {
        if (firstIndex < 0 || secondIndex < 0 || firstIndex > report.lastIndex || secondIndex > report.lastIndex) {
            return true
        }

        val difference = if (increasing)
            report[secondIndex] - report[firstIndex]
        else
            report[firstIndex] - report[secondIndex]

        return difference in 1..3
    }
}