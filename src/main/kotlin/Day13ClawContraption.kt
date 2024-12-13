package com.denec

class Day13ClawContraption {
    fun solve(input: List<String>): Int {
        return input.chunked(4).stream()
            .map { tokensToWin(it) }
            .reduce { a, b -> a + b }
            .orElseThrow()
    }

    private fun tokensToWin(input: List<String>): Int {
        val buttonA = Pair(input[0].split(" ")[2].substring(2).dropLast(1).toInt(), input[0].split(" ")[3].substring(2).toInt())
        val buttonB = Pair(input[1].split(" ")[2].substring(2).dropLast(1).toInt(), input[1].split(" ")[3].substring(2).toInt())
        val prize = Pair(input[2].split(" ")[1].substring(2).dropLast(1).toInt(), input[2].split(" ")[2].substring(2).toInt())

        val delta = buttonA.first * buttonB.second - buttonA.second * buttonB.first

        val deltaX = prize.first * buttonB.second - prize.second * buttonB.first

        val deltaY = buttonA.first * prize.second - buttonA.second * prize.first

        if (deltaX % delta != 0 || deltaY % delta != 0) return 0

        val x = deltaX / delta
        val y = deltaY / delta
        if (x < 0 || y < 0) return 0

        return 3 * x + y
    }
}