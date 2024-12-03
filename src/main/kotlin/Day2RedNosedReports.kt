package com.denec

class Day2RedNosedReports {
    fun solve(reports: List<List<Int>>): Int {
        return reports.stream()
            .filter { report -> isSafe(report) }
            .count().toInt()
    }

    private fun isSafe(report : List<Int>): Boolean {
        return isDecreasing(report) || isIncreasing(report)
    }

    private fun isIncreasing(report: List<Int>): Boolean {
        for (i in 1..report.lastIndex) {
            if (report[i] - report[i - 1] <= 0) return false
            if (report[i] - report[i - 1] > 3) return false
        }
        return true
    }

    private fun isDecreasing(report: List<Int>): Boolean {
        for (i in 1..report.lastIndex) {
            if (report[i - 1] - report[i] <= 0) return false
            if (report[i - 1] - report[i] > 3) return false
        }
        return true
    }
}