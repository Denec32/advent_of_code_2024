import com.denec.Day19LinenLayout
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day19LinenLayoutTest {
    @Test
    fun solve_example() {
        assertEquals(
            6, Day19LinenLayout().solve(
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
        println(Day19LinenLayout().solve(InputReader.parseDayNineteenInput()))
    }
}