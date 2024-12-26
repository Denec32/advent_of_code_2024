package com.denec

private typealias Key = Lock

private data class Lock(val rows: List<Int>)

class Day25CodeChronicle {

    fun solve(input: List<String>): Long {
        val locksAndKeys = input.chunked(8).map { it.dropLast(1) }

        val (locks, keys) = parseLocksAndKeys(locksAndKeys)


        var fittingCombinations = 0L
        for (key in keys) {
            for (lock in locks) {
                if (isFitting(key, lock)) {
                    fittingCombinations++
                }
            }
        }

        return fittingCombinations
    }

    private fun isFitting(key: Key, lock: Lock): Boolean {
        for (idx in 0..key.rows.lastIndex) {
            if (key.rows[idx] + lock.rows[idx] > 5) return false
        }
        return true
    }

    private fun parseLocksAndKeys(locksAndKeys: List<List<String>>): Pair<List<Lock>, List<Key>> {
        val locks = mutableListOf<Lock>()
        val keys = mutableListOf<Key>()

        for (structure in locksAndKeys) {

            val rows = MutableList(structure[0].length) { -1 }

            for (row in structure) {
                for (idx in 0..row.lastIndex) {
                    if (row[idx] == '#') rows[idx]++
                }
            }
            if (structure[0] == "#####") {
                // lock
                locks.add(Lock(rows))
            } else {
                // key
                keys.add(Key(rows))
            }
        }

        return Pair(locks, keys)
    }
}