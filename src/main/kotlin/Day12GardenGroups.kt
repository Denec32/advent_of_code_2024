package com.denec

import java.util.LinkedList
import java.util.Queue

class Day12GardenGroups {
    fun solve(map: List<String>): Int {
        val visited = List(map.size) { BooleanArray(map[0].length) { false } }

        var totalCost = 0

        for (row in map.indices) {
            for (col in map.indices) {
                if (visited[row][col]) continue
                val (area, perimeter) = measure(map, visited, row, col)
                totalCost += area * perimeter
            }
        }

        return totalCost
    }

    private val directions = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))

    private fun measure(map: List<String>, visited: List<BooleanArray>, row: Int, col: Int): Pair<Int, Int> {
        val regionLetter = map[row][col]

        val q: Queue<Pair<Int, Int>> = LinkedList()

        q.offer(Pair(row, col))

        var area = 0
        var perimeter = 0

        while (q.isNotEmpty()) {
            val (r, c) = q.poll()
            if (visited[r][c]) continue

            visited[r][c] = true
            area++

            for (dir in directions) {
                val nextRow = r + dir.first
                val nextCol = c + dir.second
                if (nextRow !in map.indices || nextCol !in map[0].indices) {
                    // out of bounds
                    perimeter++
                } else if (map[nextRow][nextCol] != regionLetter) {
                    // other region
                    perimeter++
                } else if (!visited[nextRow][nextCol]) {
                    q.offer(Pair(nextRow, nextCol))
                }
            }

        }

        return Pair(area, perimeter)
    }
}