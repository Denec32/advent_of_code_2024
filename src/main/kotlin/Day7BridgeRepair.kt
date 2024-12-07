package com.denec

class Day7BridgeRepair {
    fun solve(equations: List<String>): Long {
        return equations.stream()
            .map { parse(it) }
            .filter { canProduce(it.first, it.second) }
            .map { it.first }
            .reduce { a, b -> a + b }
            .orElseThrow()
    }

    private fun parse(equation: String): Pair<Long, List<Int>> {
        val input = equation.split(": ")

        return Pair(input[0].toLong(), input[1].split(" ").map { it.toInt() })
    }

    private fun canProduce(target: Long, operands: List<Int>): Boolean {
        return dfs(target, operands, 1, operands[0].toLong())
    }

    private fun dfs(target: Long, operands: List<Int>, idx: Int, accum: Long): Boolean {
        if (idx == operands.size) {
            return target == accum
        }

        return dfs(target, operands, idx + 1, accum * operands[idx])
                || dfs(target, operands, idx + 1, accum + operands[idx])
    }
}