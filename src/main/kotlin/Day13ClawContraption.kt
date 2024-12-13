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
        var tokens = 1000
        for (bCount in 0..100) {
            for (aCount in 0..100) {
                if (buttonB.first * bCount + buttonA.first * aCount == prize.first
                    && buttonB.second * bCount + buttonA.second * aCount == prize.second) {
                    tokens = tokens.coerceAtMost(bCount + aCount * 3)
                }
            }
        }

        return if (tokens == 1000) 0 else tokens
    }
}