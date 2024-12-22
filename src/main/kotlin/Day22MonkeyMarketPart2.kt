package com.denec

import java.util.*
import kotlin.math.max

class Day22MonkeyMarketPart2 {
    fun solve(secretNumbers: List<String>): Int {
        val secrets = secretNumbers
            .map { it.toLong() }
            .map { generateSecret(it) }

        val sequenceMaps = secrets.map { mapToDiff(it) }.toList()

        val possibleSequences = sequenceMaps.map { it.keys }.flatten().toSet()
        var maxBananas = 0
        possibleSequences.forEach { sequence ->
            maxBananas = max(maxBananas, buy(sequenceMaps, sequence))
        }

        return maxBananas
    }

    private fun buy(sequenceMaps: List<Map<List<Int>, Int>>, sequence: List<Int>): Int {
        return sequenceMaps.sumOf { map -> if (map.containsKey(sequence)) map[sequence]!! else 0 }
    }

    private fun mapToDiff(secrets: List<Int>): Map<List<Int>, Int> {
        val map = mutableMapOf<List<Int>, Int>()
        val q: Deque<Int> = LinkedList()
        for (i in 1..secrets.lastIndex) {
            val difference = secrets[i] - secrets[i - 1]
            q.offerLast(difference)
            if (q.size == 4) {
                val sequence = q.toList()
                if (!map.containsKey(sequence)) map[sequence] = secrets[i]
                q.pollFirst()
            }
        }

        return map
    }

    private fun generateSecret(secret: Long): List<Int> {
        val secrets = mutableListOf(secret)
        repeat(2000 - 1) {
            val res1 = prune(mix(secrets.last(), secrets.last() * 64))
            val res2 = prune(mix(res1, res1 / 32))
            val res3 = prune(mix(res2, res2 * 2048))

            secrets.add(res3)
        }

        return secrets.map { it.toInt() % 10 }.toList()
    }

    private fun mix(secret: Long, value: Long) = secret xor value

    private fun prune(secret: Long) = secret % 16777216
}