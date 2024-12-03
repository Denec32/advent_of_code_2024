import com.denec.Day2RedNosedReportsPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader.Companion.parseDayTwoInput

class Day2RedNosedReportsPart2Test {

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

        assertEquals(4, Day2RedNosedReportsPart2().solve(reports))
    }

    @Test
    fun solve() {
        println(Day2RedNosedReportsPart2().solve(parseDayTwoInput()))
    }
}