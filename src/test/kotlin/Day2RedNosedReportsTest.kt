import com.denec.Day2RedNosedReports
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import reader.InputReader.Companion.parseDayTwoInput

class Day2RedNosedReportsTest {

    @Test
    fun solve_example() {
        val reports = listOf(
            listOf(7, 6, 4, 2, 1),
            listOf(1, 2, 7, 8, 9),
            listOf(9, 7, 6, 2, 1),
            listOf(1, 3, 2, 4, 5),
            listOf(8, 6, 4, 4, 1),
            listOf(1, 3, 6, 7, 9),
        )

        assertEquals(2, Day2RedNosedReports().solve(reports))
    }

    @Test
    fun solve() {
        println(Day2RedNosedReports().solve(parseDayTwoInput()))
    }
}