package com.denec

class Day15WarehouseWoesPart2 {
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
                if (modifiableMap[row][col] == '[') {
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
        val obstacle = map[nextPosition.first][nextPosition.second]

        if (obstacle == '.') {
            map[nextPosition.first][nextPosition.second] = '@'
            map[robotPosition.first][robotPosition.second] = '.'
            return nextPosition
        } else if (obstacle == '[' || obstacle == ']') {
            if (dir.second == 0 && canMoveBoxes(map, nextPosition, dir)) {
                moveBoxesVertically(map, nextPosition, dir)
                map[nextPosition.first][nextPosition.second] = '@'
                map[robotPosition.first][robotPosition.second] = '.'
                return nextPosition
            } else if (dir.first == 0 && hasEmptySpace(map, nextPosition, dir)) {
                moveBoxesHorizontally(map, nextPosition, dir)
                map[nextPosition.first][nextPosition.second] = '@'
                map[robotPosition.first][robotPosition.second] = '.'
                return nextPosition
            }
        }

        return robotPosition
    }

    private fun moveBoxesHorizontally(map: List<MutableList<Char>>, position: Pair<Int, Int>, dir: Pair<Int, Int>) {
        if (map[position.first + dir.first][position.second + dir.second] == '.') {
            map[position.first + dir.first][position.second + dir.second] = map[position.first][position.second]
            map[position.first][position.second + dir.second] = '.'
        } else {
            moveBoxesHorizontally(map, Pair(position.first + dir.first, position.second + dir.second), dir)
        }
        map[position.first + dir.first][position.second + dir.second] = map[position.first][position.second]
    }

    private fun hasEmptySpace(map: List<List<Char>>, nextPosition: Pair<Int, Int>, dir: Pair<Int, Int>): Boolean {
        var currentPosition = nextPosition

        while (map[currentPosition.first][currentPosition.second] != '#' && map[currentPosition.first][currentPosition.second] != '.') {
            currentPosition = Pair(currentPosition.first + dir.first, currentPosition.second + dir.second)
        }

        return map[currentPosition.first][currentPosition.second] == '.'
    }

    private fun moveBoxesVertically(map: List<MutableList<Char>>, boxPosition: Pair<Int, Int>, dir: Pair<Int, Int>) {
        val (leftEdge, rightEdge) = getBox(map, boxPosition)
        val nextLeftEdge = Pair(leftEdge.first + dir.first, leftEdge.second + dir.second)
        val nextRightEdge = Pair(rightEdge.first + dir.first, rightEdge.second + dir.second)

        if (map[nextLeftEdge.first][nextLeftEdge.second] == '[' || map[nextLeftEdge.first][nextLeftEdge.second] == ']') {
            moveBoxesVertically(map, nextLeftEdge, dir)
        }

        if (map[nextRightEdge.first][nextRightEdge.second] == '[' || map[nextRightEdge.first][nextRightEdge.second] == ']') {
            moveBoxesVertically(map, nextRightEdge, dir)
        }

        map[nextLeftEdge.first][nextLeftEdge.second] = '['
        map[nextRightEdge.first][nextRightEdge.second] = ']'

        map[leftEdge.first][leftEdge.second] = '.'
        map[rightEdge.first][rightEdge.second] = '.'
    }

    private fun canMoveBoxes(map: List<List<Char>>, boxPosition: Pair<Int, Int>, dir: Pair<Int, Int>): Boolean {
        val (leftEdge, rightEdge) = getBox(map, boxPosition)
        val nextLeftEdge = map[leftEdge.first + dir.first][leftEdge.second + dir.second]
        val nextRightEdge = map[rightEdge.first + dir.first][rightEdge.second + dir.second]

        if (nextLeftEdge == '#' || nextRightEdge == '#') {
            return false
        }

        var ans = true

        if (nextLeftEdge == '[' || nextLeftEdge == ']') {
            ans = ans && canMoveBoxes(map, Pair(leftEdge.first + dir.first, leftEdge.second + dir.second), dir)
        }

        if (nextRightEdge == '[' || nextRightEdge == ']') {
            ans = ans && canMoveBoxes(map, Pair(rightEdge.first + dir.first, rightEdge.second + dir.second), dir)
        }

        return ans
    }

    private fun getBox(map: List<List<Char>>, boxPosition: Pair<Int, Int>) : Pair<Pair<Int, Int>, Pair<Int, Int>> {
        return if (map[boxPosition.first][boxPosition.second] == '[') {
            Pair(boxPosition, Pair(boxPosition.first, boxPosition.second + 1))
        } else if (map[boxPosition.first][boxPosition.second] == ']') {
            Pair(Pair(boxPosition.first, boxPosition.second - 1), boxPosition)
        } else {
            throw Exception("not a box")
        }
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
            when (c) {
                '#' -> ans.add('#').also { ans.add('#') }
                'O' -> ans.add('[').also { ans.add(']') }
                '.' -> ans.add('.').also { ans.add('.') }
                '@' -> ans.add('@').also { ans.add('.') }
            }
        }

        return ans
    }
}