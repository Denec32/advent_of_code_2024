package com.denec

class Day14RestroomRedoubt {
    private data class Vector2(val x: Int, val y: Int)
    private val elapsedTime = 100

    fun solve(map :List<String>, width: Int, height: Int): Int {
        val middleX = width / 2
        val middleY = height / 2
        val quadrants = List(4) { 0 }.toMutableList()

        val pos = map.stream()
            .map { parse(it) }
            .map { elapse(it.first, it.second, width, height) }
            .toList()

            pos.forEach {
                when {
                    it.x < middleX && it.y < middleY -> quadrants[0]++
                    it.x < middleX && it.y > middleY -> quadrants[1]++
                    it.x > middleX && it.y < middleY -> quadrants[2]++
                    it.x > middleX && it.y > middleY -> quadrants[3]++
                }
            }

        return quadrants.stream()
            .reduce{ a, b -> a * b }
            .orElseThrow()
    }

    private fun parse(entry: String): Pair<Vector2, Vector2> {
        val entries = entry.split(" ")
        return Pair(extractVector(entries[0]), extractVector(entries[1]))
    }

    private fun extractVector(vectorEntry: String): Vector2 {
        val trimmedVectorEntry = vectorEntry.substring(2)
        val axes = trimmedVectorEntry.split(",")

        return Vector2(axes[0].toInt(), axes[1].toInt())
    }

    private fun elapse(position: Vector2, velocity: Vector2, width: Int, height: Int): Vector2 {
        val elapsedPosition = Vector2(
            (position.x + velocity.x * elapsedTime) % width,
            (position.y + velocity.y * elapsedTime) % height)

        if (elapsedPosition.x >= 0 && elapsedPosition.y >= 0) {
            return elapsedPosition
        }

        return Vector2((elapsedPosition.x + width) % width, (elapsedPosition.y + height) % height)
    }
}