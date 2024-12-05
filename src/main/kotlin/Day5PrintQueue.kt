package com.denec

class Day5PrintQueue {
    fun solve(rules: List<String>, updates: List<String>): Int {
        val rulesMap = HashMap<Int, MutableList<Int>>()

        for (rule in rules) {
            val (key, value) = rule.split("|").stream()
                .map { it.toInt() }
                .toList()

            if (rulesMap.containsKey(key)) {
                rulesMap[key]?.add(value)
            } else {
                rulesMap[key] = mutableListOf(value)
            }
        }

        return updates.stream()
            .map { upd -> upd.split(",").map { it.toInt() } }
            .filter { isCorrect(rulesMap, it) }
            .map { it[it.size / 2] }
            .reduce {a, b -> a + b }
            .orElseThrow()
    }

    private fun isCorrect(rulesMap: Map<Int, List<Int>>, update: List<Int>): Boolean {
        val seen = HashSet<Int>()
        for (num in update) {
            seen.add(num)

            val comesAfter = rulesMap[num] ?: continue

            for (forbidden in comesAfter) {
                if (seen.contains(forbidden)) return false
            }
        }
        return true
    }
}