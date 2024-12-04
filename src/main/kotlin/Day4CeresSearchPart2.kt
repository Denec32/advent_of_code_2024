package com.denec

class Day4CeresSearchPart2 {
    private val directions = listOf(
        listOf(-1, 1),
        listOf(1, 1),
    )

    fun solve(searchField: List<String>): Int {
        var ans = 0

        for (row in 0..searchField.lastIndex) {
            for (col in 0..searchField[row].lastIndex) {
                if (searchField[row][col] != 'A') continue

                if (isXmas(searchField, row, col)) {
                    ans++
                }
            }
        }

        return ans
    }

    private fun isXmas(searchField: List<String>, row: Int, col: Int): Boolean {
        var count = 0
        for (direction in directions) {
            val next = Pair(row + direction[0], col + direction[1])
            val prev = Pair(row - direction[0], col - direction[1])
            if (isMas(searchField, next, prev)) count++
        }

        return count >= 2
    }

    private fun isMas(searchField: List<String>, next: Pair<Int, Int>, prev: Pair<Int, Int>): Boolean {
        if (next.first < 0 || next.second < 0 || next.first >= searchField.size || next.second >= searchField.size) return false
        if (prev.first < 0 || prev.second < 0 || prev.first >= searchField.size || prev.second >= searchField.size) return false

        val first = searchField[prev.first][prev.second]
        val second = searchField[next.first][next.second]

        return first == 'M' && second == 'S' || first == 'S' && second == 'M'
    }
}