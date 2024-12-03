import com.denec.Day1HistorianHysteria
import reader.InputReader
import kotlin.test.Test
import kotlin.test.assertEquals

class Day1HistorianHysteriaTest {
    @Test
    fun solve_example() {
     assertEquals(11, Day1HistorianHysteria().solve(listOf(3, 4, 2, 1, 3, 3), listOf(4, 3, 5, 3, 9, 3)))
    }

    @Test
    fun solve() {
        val (firstList, secondList) = InputReader.parseDayOneInput()
        Day1HistorianHysteria().solve(firstList, secondList)
    }
 }