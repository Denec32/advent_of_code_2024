package com.denec

import java.util.*
import java.util.stream.IntStream

class Day18RamRun {

    private val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(-1, 0), Pair(0, -1))

    fun solve(bytes: List<String>, width: Int, height: Int, byteCount: Int): Int {
        val map = List(height + 1) {
            MutableList(width + 1) {
                '.'
            }
        }

        IntStream.range(0, byteCount)
            .mapToObj { entry -> bytes[entry].split(",").stream().map { it.toInt() }.toList() }
            .forEach { map[it.last()][it.first()] = '#' }

        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.offer(Triple(0, 0, 0))

        val visited = List(height + 1) {
            MutableList(width + 1) {
                false
            }
        }

        while (q.isNotEmpty()) {
            val (r, c, steps) = q.poll()

            if (visited[r][c]) continue

            visited[r][c] = true

            if (r == height && c == width) return steps

            for (dir in directions) {
                val nextRow = r + dir.first
                val nextCol = c + dir.second

                if (nextRow !in map.indices || nextCol !in map[0].indices
                    || map[nextRow][nextCol] == '#' || visited[nextRow][nextCol]) continue

                q.offer(Triple(nextRow, nextCol, steps + 1))
            }
        }

        return -1
    }
}