import com.denec.Day1HistorianHysteria
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1HistorianHysteriaTest {
    @Test
    fun solve_example() {
     assertEquals(11, Day1HistorianHysteria().solve(listOf(3, 4, 2, 1, 3, 3), listOf(4, 3, 5, 3, 9, 3)));
    }

    @Test
    fun solve() {
        val (firstList, secondList) = parseInput("input_1.1.txt")
        assertEquals(2378066, Day1HistorianHysteria().solve(firstList, secondList))
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