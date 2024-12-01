import com.denec.Day1HistorianHysteria
import com.denec.Day1HistorianHysteriaPart2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
class Day1HistorianHysteriaPart2Test {

    @Test
    fun solve_example() {
        assertEquals(31, Day1HistorianHysteriaPart2().solve(listOf(3, 4, 2, 1, 3, 3), listOf(4, 3, 5, 3, 9, 3)))
    }

    @Test
    fun solve() {
        val (firstList, secondList) = parseInput("input_1.txt")
        Day1HistorianHysteriaPart2().solve(firstList, secondList)
    }

    private fun parseInput(inputFileName: String): Pair<MutableList<Int>, MutableList<Int>> {
        val input = {}.javaClass.getResource(inputFileName)?.readText() ?: ""
        val firstList = mutableListOf<Int>()
        val secondList = mutableListOf<Int>()

        for (line in input.lines()) {
            if (line.isEmpty()) continue
            val (first, second) = line.split("   ")
            firstList.add(first.toInt())
            secondList.add(second.toInt())
        }

        return firstList to secondList;
    }
}