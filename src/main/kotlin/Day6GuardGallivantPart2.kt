package com.denec

class Day6GuardGallivantPart2 {
    fun solve(map: List<List<Char>>): Int {
        val mutableMap = map.stream().map { it.toMutableList() }.toList().toMutableList()

        var ans = 0
        for (row in 0..mutableMap.lastIndex) {
            for (col in 0..mutableMap[0].lastIndex) {
                if (mutableMap[row][col] != '.') continue
                mutableMap[row][col] = '#'
                if (!canTraverse(mutableMap)) ans++
                mutableMap[row][col] = '.'
            }
        }

        return ans
    }

    private val directions = listOf(
        Pair(-1, 0),
        Pair(0, 1),
        Pair(1, 0),
        Pair(0, -1),
    )

    private fun canTraverse(map: List<List<Char>>): Boolean {
        var (row, col) = findGuardPosition(map)

        val visited = List(map.size) {
            List(map[0].size) { -1 }.toMutableList()
        }.toMutableList()

        var dirIdx = 0

        while (true) {
            var dir = directions[dirIdx % 4]
            if (visited[row][col] == dirIdx % 4) return false
            visited[row][col] = dirIdx % 4
            if (isValid(map, row + dir.first, col + dir.second)) {
                while (map[row + dir.first][col + dir.second] == '#') {
                    dir = directions[++dirIdx % 4]
                }

                row += dir.first
                col += dir.second
            } else {
                return true
            }
        }
    }

    private fun isValid(map: List<List<Char>>, row: Int, col: Int): Boolean {
        return row >= 0 && col >= 0 && row < map.size && col < map[0].size
    }

    private fun findGuardPosition(map: List<List<Char>>) : Pair<Int, Int> {
        for (r in 0..map.lastIndex) {
            for (c in 0..map[0].lastIndex) {
                if (map[r][c] == '^') return Pair(r, c)
            }
        }

        throw RuntimeException("no guard")
    }
}