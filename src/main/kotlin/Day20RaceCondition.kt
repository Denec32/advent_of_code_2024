package com.denec

import java.util.*

class Day20RaceCondition {
    private data class Point(val row: Int, val col: Int) {
        operator fun plus(that: Point) = Point(this.row + that.row, this.col + that.col)
        operator fun minus(that: Point) = Point(this.row - that.row, this.col - that.col)

        companion object {
            val DOWN = Point(1, 0)
            val UP = Point(-1, 0)
            val RIGHT = Point(0, 1)
            val LEFT = Point(0, -1)

            val DIRECTIONS = listOf(DOWN, UP, RIGHT, LEFT)
        }
    }

    private data class Entry(val pos: Point, val prev: Point, val picoseconds: Int, val cheats: Int = 0)

    fun solve(racetrack: List<String>): Int {
        val start = findSymbol(racetrack, 'S')
        val end = findSymbol(racetrack, 'E')

        val visited = mutableMapOf<Point, Int>()
        val fairTime = traverseRacetrack(racetrack, visited, end, start)

        // when we get on one of these without cheats -- sum current point with it and return
        val visitedReverse = visited.mapValues { entry -> fairTime - entry.value }

        val finishes = mutableMapOf<Int, Int>()

        val q: Queue<Entry> = LinkedList()
        q.add(Entry(start, Point(-1, -1), 0, 2))

        while (q.isNotEmpty()) {
            val (pos, prev, picoseconds, cheats) = q.poll()

            if (racetrack[pos.row][pos.col] == '#' && cheats == 0) continue

            if (pos == end || (cheats != 2 && visitedReverse.containsKey(pos))) {
                val time = picoseconds + visitedReverse[pos]!!
                if (time < fairTime) {
                    val savedTime = fairTime - time
                    if (savedTime >= 100) finishes[savedTime] = finishes.getOrDefault(savedTime, 0) + 1
                }
                continue
            }

            for (direction in Point.DIRECTIONS) {
                val next = pos + direction
                if (next.row !in racetrack.indices
                    || next.col !in racetrack[0].indices
                    || next == prev
                ) continue

                if (racetrack[next.row][next.col] == '#') {
                    if (cheats == 0) continue

                    q.offer(Entry(next, pos, picoseconds + 1, cheats - 1))
                } else {
                    q.offer(Entry(next, pos, picoseconds + 1, if (cheats == 1) 0 else cheats))
                }
            }
        }

        return finishes.values.sum()
    }

    private fun traverseRacetrack(racetrack: List<String>, visited: MutableMap<Point, Int>, end: Point, start: Point): Int {
        val q: Queue<Entry> = LinkedList()
        q.add(Entry(start, Point(-1, -1), 0))

        while (q.isNotEmpty()) {
            val (pos, prev, picoseconds) = q.poll()
            visited[pos] = picoseconds

            if (pos == end) {
                return picoseconds
            }

            for (direction in Point.DIRECTIONS) {
                val next = pos + direction
                if (next.row !in racetrack.indices
                    || next.col !in racetrack[0].indices
                    || next == prev
                    || racetrack[next.row][next.col] == '#'
                ) continue

                q.offer(Entry(next, pos, picoseconds + 1))
            }
        }

        throw Exception("There is no way to traverse.")
    }

    private fun findSymbol(racetrack: List<String>, letter: Char): Point {
        for (row in racetrack.indices) {
            for (col in racetrack[0].indices) {
                if (racetrack[row][col] == letter) return Point(row, col)
            }
        }

        throw IllegalArgumentException("Letter $letter not found")
    }
}