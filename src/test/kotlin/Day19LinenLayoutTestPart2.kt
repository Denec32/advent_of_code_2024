import com.denec.Day19LinenLayoutPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day19LinenLayoutTestPart2 {
    @Test
    fun solve_example() {
        assertEquals(
            16, Day19LinenLayoutPart2().solve(
                listOf(
                    "r, wr, b, g, bwu, rb, gb, br",
                    "",
                    "brwrr",
                    "bggr",
                    "gbbr",
                    "rrbgbr",
                    "ubwu",
                    "bwurrg",
                    "brgr",
                    "bbrgwb",
                )
            )
        )
    }

    @Test
    fun solve() {
        println(Day19LinenLayoutPart2().solve(InputReader.parseDayNineteenInput()))
    }
}