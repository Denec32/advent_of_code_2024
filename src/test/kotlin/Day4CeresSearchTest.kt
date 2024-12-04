import com.denec.Day4CeresSearch
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import reader.InputReader

class Day4CeresSearchTest {

    @Test
    fun solve_example() {
        assertEquals(18, Day4CeresSearch().solve(listOf(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        )))
    }

    @Test
    fun solve() {
        println(Day4CeresSearch().solve(InputReader.parseDayFourInput()))
    }
}