package com.denec

class Day1HistorianHysteriaPart2 {
    fun solve(firstList: List<Int>, secondList: List<Int>): Long {
        val firstFrequency = countFrequency(firstList)
        val secondFrequency = countFrequency(secondList)

        return firstList.stream()
            .distinct()
            .filter { num -> firstFrequency.containsKey(num) && secondFrequency.containsKey(num) }
            .mapToLong { num -> (firstFrequency[num]!! * secondFrequency[num]!! * num).toLong() }
            .sum()
    }

    private fun countFrequency(nums : List<Int>): MutableMap<Int, Int> {
        val frequencyMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap[num] = frequencyMap[num]!! + 1
            } else {
                frequencyMap[num] = 1
            }
        }
        return frequencyMap
    }
}