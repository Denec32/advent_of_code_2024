package com.denec

import java.util.Stack
import kotlin.math.min

class Day21KeypadConundrum {
    data class Position(val row: Int, val col: Int) {
        operator fun plus(other: Position): Position {
            return Position(row + other.row, col + other.col)
        }

        operator fun minus(other: Position): Position {
            return Position(row - other.row, col - other.col)
        }
    }

    private val keypad = listOf(
        "789",
        "456",
        "123",
        " 0A",
    )

    private val directionalKeypad = listOf(
        " ^A",
        "<v>"
    )

    fun solve(codes: List<String>): Long {
        return codes.map { solve(it) }.reduce(Long::plus)
    }

    fun solve(code: String): Long {
        val keypadInputSequence = calculateKeypadSequence(code)

        return keypadInputSequence * code.dropLast(1).toLong()
    }

    private fun calculateKeypadSequence(code: String): Long {
        val sequence = "A$code"
        var length = 0L
        for (i in 1..sequence.lastIndex) {
            var len = Long.MAX_VALUE
            val sequences = getKeypadSequence(sequence[i - 1], sequence[i], keypad)

            sequences.forEach { len = min(len, calculateDirKeypadSequence1(it)) }

            length += len
        }

        return length
    }

    private fun calculateDirKeypadSequence1(code: String): Long {
        val sequence = "A$code"
        var length = 0L
        for (i in 1..sequence.lastIndex) {
            var len = Long.MAX_VALUE
            val sequences = getKeypadSequence(sequence[i - 1], sequence[i], directionalKeypad)

            sequences.forEach { len = min(len, calculateDirKeypadSequence2(it)) }

            length += len
        }

        return length
    }

    private fun calculateDirKeypadSequence2(code: String): Long {
        val sequence = "A$code"
        var length = 0L
        for (i in 1..sequence.lastIndex) {
            var len = Long.MAX_VALUE
            val sequences = getKeypadSequence(sequence[i - 1], sequence[i], directionalKeypad)

            sequences.forEach { len = min(len, it.length.toLong()) }

            length += len
        }

        return length
    }

    private val directions = listOf(Position(1, 0), Position(0, 1), Position(0, -1), Position(-1, 0))
    private val dirMap = mapOf(
        directions[0] to 'v',
        directions[1] to '>',
        directions[2] to '<',
        directions[3] to '^'
    )
    private fun getKeypadSequence(src: Char, dest: Char, keypad: List<String>): List<String> {
        val start = findLetter(keypad, src)
        val end = findLetter(keypad, dest)

        val result = mutableListOf<String>()

        dfs(result, keypad, start, end, mutableSetOf(), Stack())

        var len = Int.MAX_VALUE
        for (res in result) {
            len = min(len, res.length)
        }

        return result.filter { it.length == len }
    }

    private fun dfs(
        result: MutableList<String>,
        keypad: List<String>,
        current: Position,
        end: Position,
        visited: MutableSet<Position>,
        sequence: Stack<Char>
    ) {
        if (current == end) {
            val res = sequence.joinToString("") + "A"
            result.add(res)
            return
        }

        visited.add(current)

        for (dir in directions) {
            val next = current + dir

            if (visited.contains(next) || next.row !in keypad.indices || next.col !in keypad[0].indices || keypad[next.row][next.col] == ' ') continue
            sequence.add(dirMap[dir]!!)
            dfs(result, keypad, next, end, visited, sequence)
            sequence.pop()
        }

        visited.remove(current)
    }

    private fun findLetter(keypad: List<String>, src: Char): Position {
        for (row in keypad.indices) {
            for (col in keypad[0].indices) {
                if (keypad[row][col] == src) return Position(row, col)
            }
        }

        throw IllegalStateException("No letter found")
    }
}