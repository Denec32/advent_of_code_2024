package com.denec

import java.math.BigDecimal
import java.util.stream.IntStream

class Day9DiskFragmenter {
    fun solve(diskMap: String): String {
        val blocks = toIndividualBlocks(diskMap)

        val compressedBlocks = compressBlocks(blocks)

        return calculateCheckSum(compressedBlocks)
    }

    private fun calculateCheckSum(compressedBlocks: List<String>): String {
        var decimal = BigDecimal(0)
        IntStream.range(0, compressedBlocks.size)
            .map { compressedBlocks[it].toInt() * it }
            .forEach {
                decimal = decimal.add(BigDecimal(it))
            }
        return decimal.toString()
    }

    private fun compressBlocks(blocks: List<String>): List<String> {

        val compressedBlocks = blocks.toMutableList()

        var high = compressedBlocks.size - 1

        for (low in 0..compressedBlocks.lastIndex) {
            if (compressedBlocks[low] != ".") continue
            while (low < high && compressedBlocks[high] == ".") {
                high--
            }

            if (low >= high) break

            compressedBlocks[low] = compressedBlocks[high]
            compressedBlocks[high] = "."
        }

        return compressedBlocks.subList(0, high)
    }

    private fun toIndividualBlocks(diskMap: String): List<String> {
        var code = -1
        return IntStream.range(0, diskMap.length)
            .mapToObj {
                if (it % 2 == 0) {
                    code++
                    List(diskMap[it].digitToInt()) { (code).toString() }
                }
                else {
                    List(diskMap[it].digitToInt()) { "." }
                }
            }
            .toList().flatten()
    }
}