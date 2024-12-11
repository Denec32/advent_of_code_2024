package com.denec

import java.math.BigDecimal

class Day11PlutonianPebbles {
    fun solve(stones: List<String>, blinkCount: Int): Long {
        return stones.sumOf { blink(it, blinkCount) }
    }

    private val memo = hashMapOf<String, Long>()

    private fun blink(stone: String, blinkCount: Int): Long {
        if (blinkCount == 0) return 1

        val key = "$stone $blinkCount"
        if (memo[key] != null) {
            return memo[key]!!
        }

        memo[key] = change(stone).sumOf {
            blink(it, blinkCount - 1)
        }

        return memo[key]!!
    }

    private fun change(stone: String): List<String> {
        if (stone == "0") {
            return listOf("1")
        }else if (stone.length % 2 == 0) {
            val first = stone.substring(0, stone.length / 2)
            var second = stone.substring(stone.length / 2, stone.length)
            while (second.isNotEmpty() && second.startsWith("0")) {
                second = second.substring(1)
            }
            return listOf(first, second.ifEmpty { "0" })
        } else {
            val dec = BigDecimal(stone).multiply(BigDecimal(2024))
            return listOf(dec.toString())
        }
    }
}