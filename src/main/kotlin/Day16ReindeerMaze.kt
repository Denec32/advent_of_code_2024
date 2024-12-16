package com.denec

import java.util.*

class Day16ReindeerMaze {
    data class Position(val row: Int, val col: Int, val direction: Direction, val score: Int) {
        enum class Direction(val row: Int, val col: Int) {
            UP(-1, 0),
            DOWN(1, 0),
            LEFT(0, -1),
            RIGHT(0, 1);

            fun rotateRight(): Direction {
                return when (this) {
                    UP -> RIGHT
                    DOWN -> LEFT
                    LEFT -> UP
                    RIGHT -> DOWN
                }
            }

            fun rotateLeft(): Direction {
                return when (this) {
                    UP -> LEFT
                    DOWN -> RIGHT
                    LEFT -> DOWN
                    RIGHT -> UP
                }
            }
        }

        fun goForward() = this.copy(row = row + direction.row, col = col + direction.col)

        fun rotateRight() = this.copy(direction = direction.rotateRight())

        fun rotateLeft() = this.copy(direction = direction.rotateLeft())
    }

    fun solve(map: List<String>): Int {
        val deerPosition = Position(map.size - 2, 1, Position.Direction.RIGHT, 0)

        val q: PriorityQueue<Position> = PriorityQueue { a, b -> a.score.compareTo(b.score) }
        q.offer(deerPosition)

        val visited = MutableList(map.size) {
            MutableList(map[0].length) {
                MutableList(4) {
                    -1
                }
            }
        }

        while (q.isNotEmpty()) {
            val currentPosition = q.poll()
            if (currentPosition.row == 1 && currentPosition.col == map[0].length - 2) {
                return currentPosition.score
            }

            val visit = visited[currentPosition.row][currentPosition.col][currentPosition.direction.ordinal]
            if (visit != -1 && visit < currentPosition.score) {
                continue
            }
            visited[currentPosition.row][currentPosition.col][currentPosition.direction.ordinal] = currentPosition.score
            var next = currentPosition.goForward()
            if (next.row in map.indices && next.col in map[0].indices && map[next.row][next.col] != '#') {
                q.offer(next.copy(score = next.score + 1))
            }

            next = currentPosition.rotateRight().goForward()
            if (next.row in map.indices && next.col in map[0].indices && map[next.row][next.col] != '#') {
                q.offer(next.copy(score = next.score + 1001))
            }

            next = currentPosition.rotateLeft().goForward()
            if (next.row in map.indices && next.col in map[0].indices && map[next.row][next.col] != '#') {
                q.offer(next.copy(score = next.score + 1001))
            }
        }

        return -1
    }
}