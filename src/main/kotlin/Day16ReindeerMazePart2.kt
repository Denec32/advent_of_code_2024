package com.denec

import com.denec.Day16ReindeerMaze.Position
import java.util.*

class Day16ReindeerMazePart2 {
    fun solve(map: List<String>): Int {
        val targetScore = Day16ReindeerMaze().solve(map)

        val deerPosition = Position(map.size - 2, 1, Position.Direction.RIGHT, 0)

        val visited = List(map.size) {
            List(map[0].length) {
                MutableList(4) {
                    -1
                }
            }
        }

        val bestPaths = List(map.size) {
            MutableList(map[0].length) {
                false
            }
        }

        dfs(map, bestPaths, visited, Stack(), targetScore, deerPosition)

        var ans = 0
        for (row in bestPaths) {
            for (item in row) {
                if (item) ans++
            }
        }

        return ans + 1
    }

    private fun dfs(
        map: List<String>,
        bestPaths: List<MutableList<Boolean>>,
        visited: List<List<MutableList<Int>>>,
        path: Stack<Pair<Int, Int>>,
        targetScore: Int,
        currentPosition: Position
    ) {
        if (currentPosition.row == 1 && currentPosition.col == map[0].length - 2 && currentPosition.score == targetScore) {
            for (pos in path) {
                bestPaths[pos.first][pos.second] = true
            }
            return
        }

        if (path.contains(Pair(currentPosition.row, currentPosition.col))) return

        val visit = visited[currentPosition.row][currentPosition.col][currentPosition.direction.ordinal]
        if (visit != -1 && visit < currentPosition.score) {
            return
        }

        visited[currentPosition.row][currentPosition.col][currentPosition.direction.ordinal] = currentPosition.score

        path.push(Pair(currentPosition.row, currentPosition.col))

        var next = currentPosition.goForward()
        if (next.row in map.indices && next.col in map[0].indices && map[next.row][next.col] != '#') {
            dfs(map, bestPaths, visited, path, targetScore, next.copy(score = next.score + 1))
        }

        next = currentPosition.rotateRight().goForward()
        if (next.row in map.indices && next.col in map[0].indices && map[next.row][next.col] != '#') {
            dfs(map, bestPaths, visited, path, targetScore, next.copy(score = next.score + 1001))
        }

        next = currentPosition.rotateLeft().goForward()
        if (next.row in map.indices && next.col in map[0].indices && map[next.row][next.col] != '#') {
            dfs(map, bestPaths, visited, path, targetScore, next.copy(score = next.score + 1001))
        }

        path.pop()
    }
}