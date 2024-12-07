package com.denec

class Day6GuardGallivant {
    private val directions = listOf(
        Pair(-1, 0),
        Pair(0, 1),
        Pair(1, 0),
        Pair(0, -1),
    )
    fun solve(map: List<List<Char>>): Long {
        var (row, col) = findGuardPosition(map)

        val visited = List(map.size) {
            List(map[0].size) { false }.toMutableList()
        }.toMutableList()
        var dirIdx = 0
        while (isValid(map, row, col)) {
            visited[row][col] = true
            var dir = directions[dirIdx % 4]
            if (isValid(map, row + dir.first, col + dir.second)) {
                if (map[row + dir.first][col + dir.second] == '#') {
                    dirIdx++
                    dir = directions[dirIdx % 4]
                }

                row += dir.first
                col += dir.second
            } else {
                break
            }
        }
        return countDistinct(visited)
    }

    private fun countDistinct(visited: List<List<Boolean>>): Long {
        return visited.stream().map {
            it.stream()
                .filter { isVisited -> isVisited == true }
                .count() }
            .reduce{ a, b -> a + b}
            .orElseThrow()
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