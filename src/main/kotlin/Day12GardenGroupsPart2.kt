package com.denec

import java.util.EnumSet
import java.util.LinkedList
import java.util.Queue

class Day12GardenGroupsPart2 {
    private enum class Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        fun toPair(): Pair<Int, Int> {
            return when (this) {
                UP -> Pair(-1, 0)
                DOWN -> Pair(1, 0)
                LEFT -> Pair(0, -1)
                RIGHT -> Pair(0, 1)
            }
        }
    }

    fun solve(map: List<String>): Int {
        val visited = List(map.size) { BooleanArray(map[0].length) { false } }

        var totalCost = 0

        for (row in map.indices) {
            for (col in map[0].indices) {
                if (visited[row][col]) continue
                val (area, perimeter) = measure(map, visited, row, col)
                totalCost += area * perimeter
            }
        }

        return totalCost
    }

    private fun measure(map: List<String>, visited: List<BooleanArray>, row: Int, col: Int): Pair<Int, Int> {
        val regionLetter = map[row][col]
        val dirMap = List(map.size) { List(map[0].length) { EnumSet.noneOf(Direction::class.java) } }

        val q: Queue<Pair<Int, Int>> = LinkedList()

        q.offer(Pair(row, col))

        var area = 0

        while (q.isNotEmpty()) {
            val (r, c) = q.poll()
            if (visited[r][c]) continue

            visited[r][c] = true
            area++

            for (dir in Direction.entries) {
                val nextRow = r + dir.toPair().first
                val nextCol = c + dir.toPair().second
                if (nextRow !in map.indices || nextCol !in map[0].indices) {
                    // out of bounds
                    dirMap[r][c].add(dir)
                } else if (map[nextRow][nextCol] != regionLetter) {
                    // other region
                    dirMap[r][c].add(dir)
                } else if (!visited[nextRow][nextCol]) {
                    q.offer(Pair(nextRow, nextCol))
                }
            }
        }

        return Pair(area, countSides(dirMap))
    }

    private fun countSides(dirMap: List<List<EnumSet<Direction>>>): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()

        for (row in dirMap.indices) {
            for (col in dirMap[0].indices) {
                if (dirMap[row][col].size == 0) continue
                q.offer(Pair(row, col))
            }
        }

        var sides = 0
        while (q.isNotEmpty()) {
            val (r, c) = q.poll()

            val dirs = dirMap[r][c]

            if (dirs.contains(Direction.UP)) {
                unmarkHorizontalSide(dirMap, r, c, Direction.UP)
                sides++
            }

            if (dirs.contains(Direction.DOWN)) {
                unmarkHorizontalSide(dirMap, r, c, Direction.DOWN)
                sides++
            }


            if (dirs.contains(Direction.LEFT)) {
                // go left and right
                for (nextR in r..dirMap.lastIndex) {
                    if (dirMap[nextR][c].contains(Direction.LEFT)) {
                        dirMap[nextR][c].remove(Direction.LEFT)
                    } else {
                        break
                    }
                }

                for (nextR in r - 1 downTo 0) {
                    if (dirMap[nextR][c].contains(Direction.LEFT)) {
                        dirMap[nextR][c].remove(Direction.LEFT)
                    } else {
                        break
                    }
                }
                sides++
            }

            if (dirs.contains(Direction.RIGHT)) {
                // go left and right
                for (nextR in r..dirMap.lastIndex) {
                    if (dirMap[nextR][c].contains(Direction.RIGHT)) {
                        dirMap[nextR][c].remove(Direction.RIGHT)
                    } else {
                        break
                    }
                }


                for (nextR in r - 1 downTo 0) {
                    if (dirMap[nextR][c].contains(Direction.RIGHT)) {
                        dirMap[nextR][c].remove(Direction.RIGHT)
                    } else {
                        break
                    }
                }
                sides++
            }
        }

        return sides
    }

    private fun unmarkHorizontalSide(
        dirMap: List<List<EnumSet<Direction>>>,
        r: Int,
        c: Int,
        direction: Direction
    ) {
        for (nextC in c..dirMap[0].lastIndex) {
            if (dirMap[r][nextC].contains(direction)) {
                dirMap[r][nextC].remove(direction)
            } else {
                break
            }
        }

        for (nextC in c - 1 downTo 0) {
            if (dirMap[r][nextC].contains(direction)) {
                dirMap[r][nextC].remove(direction)
            } else {
                break
            }
        }
    }
}