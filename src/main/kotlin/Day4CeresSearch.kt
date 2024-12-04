package com.denec

import java.util.LinkedList
import java.util.Queue

class Day4CeresSearch {
    private val directions = listOf(
        listOf(0, 1),
        listOf(1, 0),
        listOf(1, 1),
        listOf(-1, 0),
        listOf(0, -1),
        listOf(1, -1),
        listOf(-1, 1),
        listOf(-1, -1)
    )

    fun solve(searchField: List<String>): Int {
        val q: Queue<Triple<Int, Int, List<Int>>> = LinkedList()

        for (row in 0..searchField.lastIndex) {
            for (col in 0..searchField[row].lastIndex) {
                if (searchField[row][col] == 'X') {
                    for (direction in directions) {
                        q.offer(Triple(row, col, direction))
                    }
                }
            }
        }

        var ans = 0

        while (q.isNotEmpty()) {
            val (row, col, direction) = q.poll()
            val currentLetter = searchField[row][col]

            if (currentLetter == 'S') {
                ans++
                continue
            }

            val nextLetter = nextLetter(currentLetter)

            if (nextLetter == '0') {
                continue;
            }

            val nextRow = row + direction[0]
            val nextCol = col + direction[1]

            if (nextRow < 0 || nextCol < 0
                || nextRow >= searchField.size || nextCol >= searchField[0].length
                || searchField[nextRow][nextCol] != nextLetter) continue

            q.offer(Triple(nextRow, nextCol, direction))
        }

        return ans
    }

    private fun nextLetter(currentLetter: Char): Char {
        if (currentLetter == 'X') return 'M'
        if (currentLetter == 'M') return 'A'
        if (currentLetter == 'A') return 'S'
        return '0'
    }
}