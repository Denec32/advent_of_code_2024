package com.denec

class Day13ClawContraptionPart2 {
    fun solve(input: List<String>): Long {
        return input.chunked(4).stream()
            .map { tokensToWin(it) }
            .reduce { a, b -> a + b }
            .orElseThrow()
    }

    private val offset = 10000000000000L

    private fun tokensToWin(input: List<String>): Long {
        val buttonA = Pair(input[0].split(" ")[2].substring(2).dropLast(1).toLong(), input[0].split(" ")[3].substring(2).toLong())
        val buttonB = Pair(input[1].split(" ")[2].substring(2).dropLast(1).toLong(), input[1].split(" ")[3].substring(2).toLong())
        val prize = Pair(input[2].split(" ")[1].substring(2).dropLast(1).toLong() + offset, input[2].split(" ")[2].substring(2).toLong() + offset)

        val delta: Long = buttonA.first * buttonB.second - buttonA.second * buttonB.first

        val deltaX: Long = prize.first * buttonB.second - prize.second * buttonB.first

        val deltaY: Long = buttonA.first * prize.second - buttonA.second * prize.first

        if (deltaX % delta != 0L || deltaY % delta != 0L) return 0

        val x = deltaX / delta
        val y = deltaY / delta
        if (x < 0 || y < 0) return 0

        return 3L * x + y
    }
}