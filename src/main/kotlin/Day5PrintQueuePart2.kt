package com.denec

class Day5PrintQueuePart2 {
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
            .filter { !isCorrect(rulesMap, it) }
            .map { fixOrdering(rules, it) }
            .map { it[it.size / 2] }
            .reduce { a, b -> a + b }
            .orElseThrow()
    }

    private fun fixOrdering(rules: List<String>, update: List<Int>): List<Int> {
        val fixedUpdate = mutableListOf<Int>()

        val adj = rules.stream().map { upd ->
            upd.split("|").stream()
                .map { it.toInt() }
                .toList()
        }
            .filter { update.contains(it.first()) && update.contains(it.last()) }
            .map { Pair(it.first(), it.last()) }
            .toList()
            .toMutableList()

        val visited = mutableSetOf<Int>()

        while (fixedUpdate.size != update.size) {
            val node = update.stream()
                .filter { !visited.contains(it) }
                .filter { node -> adj.find { it.first == node } == null }
                .findFirst()
                .orElseThrow()

            fixedUpdate.add(node)

            adj.removeIf { it.first == node || it.second == node }
            visited.add(node)
        }

        return fixedUpdate
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