package com.denec

class Day3MullItOverPart2 {
    fun solve(memory: String): Long {
        val regex = """
            mul\([0-9]+,[0-9]+\)|don't\(\)|do\(\)
        """.trimIndent().toRegex()

        val tokens = regex.findAll(memory)
            .map { memory.substring(it.range.first, it.range.last + 1) }
            .toList()

        var isEnabled = true
        var ans = 0L
        for (token in tokens) {
            if (token == "don't()") {
                isEnabled = false;
            } else if (token == "do()") {
                isEnabled = true;
            } else if (isEnabled) {
                ans += eval(token)
            }
        }

        return ans
    }

    fun eval(function: String) : Long {
        val input = function.substring(4, function.length - 1)
            .split(",")

        return input[0].toLong() * input[1].toLong()
    }
}