package com.denec

import java.math.BigDecimal
import java.util.stream.IntStream

class Day9DiskFragmenterPart2 {
    data class Block(val code: Int, val count: Int) {
        fun isFreeSpace(): Boolean {
            return code == -1
        }
    }

    fun solve(diskMap: String): String {
        val blocks = toIndividualBlocks(diskMap).toMutableList()
        while(fragment(blocks));

        return calculateCheckSum(blocks)
    }

    private fun calculateCheckSum(fragmentedBlocks: List<Block>): String {
        var decimal = BigDecimal(0)

        var code = 0
        IntStream.range(0, fragmentedBlocks.size)
            .forEach {
                val block = fragmentedBlocks[it]
                if (block.isFreeSpace()) {
                    code += block.count
                } else {
                    for (i in 1..block.count) {
                        decimal = decimal.add(BigDecimal(code++ * block.code))
                    }
                }
            }

        return decimal.toString()
    }

    private fun fragment(blocks: MutableList<Block>): Boolean {
        for (high in blocks.indices.reversed()) {
            val block = blocks[high]
            if (block.isFreeSpace()) continue

            for (low in blocks.indices) {
                val emptyBlock = blocks[low]
                if (!emptyBlock.isFreeSpace() || emptyBlock.count < block.count) continue
                if (low > high) break

                if (emptyBlock.count == block.count) {
                    blocks[low] = block
                    blocks[high] = Block(-1, block.count)
                    return true
                } else {
                    blocks[low] = Block(-1, emptyBlock.count - block.count)
                    blocks[high] = Block(-1, block.count)
                    blocks.add(low, block)
                    return true
                }
            }
        }

        return false
    }

    private fun toIndividualBlocks(diskMap: String): List<Block> {
        var code = 0
        return IntStream.range(0, diskMap.length)
            .mapToObj {
                if (it % 2 == 0) {
                    Block(code++, diskMap[it].digitToInt())
                }
                else {
                    Block(-1, diskMap[it].digitToInt())
                }
            }
            .toList()
    }
}