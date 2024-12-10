package com.denec

import java.util.*

class Day10HoofItPart2 {
    fun solve(map: List<List<Int>>): Int {
        var ans = 0
        for (row in map.indices) {
            for (col in map[0].indices) {
                if (map[row][col] == 0) {
                    val score = countScore(map, row, col)
                    ans += score
                }
            }
        }
        return ans
    }

    private val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))

    private fun countScore(map: List<List<Int>>, row: Int, col: Int): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.offer(Pair(row, col))

        var peaks = 0

        while (q.isNotEmpty()) {
            val (r, c) = q.poll()

            if (map[r][c] == 9) {
                peaks++
                continue
            }

            for (dir in directions) {
                val nextRow = r + dir.first
                val nextCol = c + dir.second
                if (nextRow !in map.indices || nextCol !in map[0].indices) continue

                if (map[nextRow][nextCol] != map[r][c] + 1) continue

                q.offer(Pair(nextRow, nextCol))
            }
        }

        return peaks
    }
}