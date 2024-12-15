package com.denec

class Day15WarehouseWoes {
    fun solve(warehouseMap: List<String>, robotMoves: List<String>): Long {
        val modifiableMap = warehouseMap.stream()
            .map { toCharList(it) }
            .toList()
            .toMutableList()

        var robotPosition = findRobotPosition(modifiableMap)
        for (row in robotMoves.indices) {
            for (col in robotMoves[0].indices) {
                robotPosition = move(modifiableMap, robotPosition, robotMoves[row][col])
            }
        }

        return calculateScore(modifiableMap)
    }

    private fun calculateScore(modifiableMap: List<List<Char>>): Long {
        var ans = 0L
        for (row in modifiableMap.indices) {
            for (col in modifiableMap[0].indices) {
                if (modifiableMap[row][col] == 'O') {
                    ans += row * 100 + col
                }
            }
        }

        return ans
    }

    private fun move(map: List<MutableList<Char>>, robotPosition: Pair<Int, Int>, direction: Char): Pair<Int, Int> {
        val dir = when (direction) {
            '<' -> Pair(0, -1)
            '>' -> Pair(0, 1)
            '^' -> Pair(-1, 0)
            else -> Pair(1, 0)
        }

        val nextPosition = Pair(robotPosition.first + dir.first, robotPosition.second + dir.second)
        if (map[nextPosition.first][nextPosition.second] == '.') {
            map[nextPosition.first][nextPosition.second] = '@'
            map[robotPosition.first][robotPosition.second] = '.'
            return nextPosition
        } else if (map[nextPosition.first][nextPosition.second] == 'O') {
            val spaceOrWallPosition = findFirstWallOrSpace(map, nextPosition, dir)

            if (map[spaceOrWallPosition.first][spaceOrWallPosition.second] == '.') {
                map[spaceOrWallPosition.first][spaceOrWallPosition.second] = 'O'
                map[nextPosition.first][nextPosition.second] = '@'
                map[robotPosition.first][robotPosition.second] = '.'
                return nextPosition
            }

        }

        return robotPosition
    }

    private fun findFirstWallOrSpace(map: List<List<Char>>, nextPosition: Pair<Int, Int>, dir: Pair<Int, Int>): Pair<Int, Int> {
        var currentPosition = nextPosition

        while (map[currentPosition.first][currentPosition.second] != '#' && map[currentPosition.first][currentPosition.second] != '.') {
            currentPosition = Pair(currentPosition.first + dir.first, currentPosition.second + dir.second)
        }

        return currentPosition
    }

    private fun findRobotPosition(map: List<List<Char>>): Pair<Int, Int> {
        for (row in map.indices) {
            for (col in map[0].indices) {
                if (map[row][col] == '@') return Pair(row, col)
            }
        }

        throw Exception("Couldn't find robot")
    }

    private fun toCharList(it: String): MutableList<Char> {
        val ans = mutableListOf<Char>()
        for (c in it.toCharArray()) {
            ans.add(c)
        }

        return ans
    }
}