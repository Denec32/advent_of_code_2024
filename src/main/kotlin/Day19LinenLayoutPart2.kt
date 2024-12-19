package com.denec

class Day19LinenLayoutPart2 {
    fun solve(input: List<String>): Long {
        val patterns = input[0].split(", ").toSet()

        return input.drop(2).stream()
            .map { design -> isPossible(patterns, design) }
            .reduce { a, b -> a + b }.orElseThrow()
    }

    private fun isPossible(patterns: Set<String>, design: String): Long {
        return dfs(MutableList(design.length) { null }, patterns, design, 0)
    }

    private fun dfs(memo: MutableList<Long?>, patterns: Set<String>, design: String, idx: Int): Long {
        if (idx == design.length) {
            return 1
        }

        if (memo[idx] != null) {
            return memo[idx]!!
        }

        memo[idx] = patterns
            .filter { pattern ->
                design.substring(idx).startsWith(pattern)
            }.map { pattern ->
                dfs(memo, patterns, design, idx + pattern.length)
            }.reduceOrNull(Long::plus) ?: 0L

        return memo[idx]!!
    }
}