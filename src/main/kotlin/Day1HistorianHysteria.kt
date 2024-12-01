package com.denec

import java.util.stream.IntStream
import kotlin.math.abs

class Day1HistorianHysteria {
    fun solve(firstList: List<Int>, secondList: List<Int>): Int {
        val firstListSorted = firstList.sorted()
        val secondListSorted = secondList.sorted()

        return IntStream.range(0, firstListSorted.size)
            .map { abs(secondListSorted[it] - firstListSorted[it]) }
            .sum()
    }
}