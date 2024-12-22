package com.denec

class Day22MonkeyMarket {
    fun solve(secretNumbers: List<String>): Long {
        return secretNumbers
            .map { it.toLong() }
            .sumOf { generateSecret(it) }
    }

    private tailrec fun generateSecret(secret: Long, count: Int = 2000): Long {
        if (count == 0) return secret
        val res1 = prune(mix(secret, secret * 64))
        val res2 = prune(mix(res1, res1 / 32))
        val res3 = prune(mix(res2, res2 * 2048))

        return generateSecret(res3, count - 1)
    }

    private fun mix(secret: Long, value: Long): Long {
        return secret xor value
    }

    private fun prune(secret: Long): Long {
        return secret % 16777216
    }
}