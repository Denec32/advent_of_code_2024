import com.denec.Day1HistorianHysteriaPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day1HistorianHysteriaPart2Test {

    @Test
    fun solve_example() {
        assertEquals(31, Day1HistorianHysteriaPart2().solve(listOf(3, 4, 2, 1, 3, 3), listOf(4, 3, 5, 3, 9, 3)))
    }

    @Test
    fun solve() {
        val (firstList, secondList) = InputReader.parseDayOneInput()
        Day1HistorianHysteriaPart2().solve(firstList, secondList)
    }
}