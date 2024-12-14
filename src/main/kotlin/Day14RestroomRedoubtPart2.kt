package com.denec

import java.awt.image.BufferedImage
import java.io.File
import java.util.stream.IntStream
import javax.imageio.ImageIO

class Day14RestroomRedoubtPart2 {
    private data class Vector2(val x: Int, val y: Int)

    fun solve(map :List<String>, width: Int, height: Int) {
        val parsedPositions = map.stream()
            .map { parse(it) }
            .toList()

        File("output")
        IntStream.range(0, 10000)
            .forEach { time ->
                writeMap(parsedPositions
                    .map { elapse(it.first, it.second, width, height, time) }
                    .toList(),
                    width, height, time)
            }
    }

    private fun writeMap(map :List<Vector2>, width: Int, height: Int, elapsedTime: Int) {
        val printMap = List(height) { MutableList(width) { 0 } }
        map.stream().forEach { printMap[it.y][it.x]++ }

        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

        val graphics = image.createGraphics()
        for (row in printMap.indices) {
            for (col in printMap[0].indices) {
                if (printMap[row][col] == 0) {
                    //graphics.fillRect(col, row, 1, 1)
                } else {
                    graphics.fillRect(col, row, 1, 1)
                }
            }
        }

        val file = File("output${File.separator}image_$elapsedTime.png")
        ImageIO.write(image, "PNG", file)
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

    private fun elapse(position: Vector2, velocity: Vector2, width: Int, height: Int, time: Int): Vector2 {
        val elapsedPosition = Vector2(
            (position.x + velocity.x * time) % width,
            (position.y + velocity.y * time) % height)

        if (elapsedPosition.x >= 0 && elapsedPosition.y >= 0) {
            return elapsedPosition
        }

        return Vector2((elapsedPosition.x + width) % width, (elapsedPosition.y + height) % height)
    }
}