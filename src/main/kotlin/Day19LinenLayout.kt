package com.denec

class Day19LinenLayout {
    fun solve(input: List<String>): Int {
        val patterns = input[0].split(", ").toSet()

        return input.drop(2).stream()
            .filter { design -> isPossible(patterns, design) }
            .count()
            .toInt()
    }

    private fun isPossible(patterns: Set<String>, design: String): Boolean {
        return dfs(MutableList(design.length) { null }, patterns, design, 0)
    }

    private fun dfs(memo: MutableList<Boolean?>, patterns: Set<String>, design: String, idx: Int): Boolean {
        if (idx == design.length) {
            return true
        }

        if (memo[idx] != null) {
            return memo[idx] == true
        }

        var isPossible = false
        for (pattern in patterns) {
            if (design.substring(idx).startsWith(pattern)) {
                isPossible = isPossible or dfs(memo, patterns, design, idx + pattern.length)
            }
        }

        memo[idx] = isPossible

        return isPossible
    }
}