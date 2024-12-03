package com.denec

class Day3MullItOver {
    fun solve(memory: String): Long {
        val regex = """
            mul\([0-9]+,[0-9]+\)
        """.trimIndent().toRegex()

        return regex.findAll(memory)
            .map { memory.substring(it.range.first, it.range.last + 1) }
            .map { it.substring(4, it.length - 1) }
            .map { it.split(",") }
            .map { it[0].toLong() * it[1].toLong() }
            .sum()
    }
}