import com.denec.Day25CodeChronicle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day25CodeChronicleTest {
    @Test
    fun solve_example() {
        assertEquals(
            3, Day25CodeChronicle().solve(
                listOf(
                    "#####",
                    ".####",
                    ".####",
                    ".####",
                    ".#.#.",
                    ".#...",
                    ".....",
                    "",
                    "#####",
                    "##.##",
                    ".#.##",
                    "...##",
                    "...#.",
                    "...#.",
                    ".....",
                    "",
                    ".....",
                    "#....",
                    "#....",
                    "#...#",
                    "#.#.#",
                    "#.###",
                    "#####",
                    "",
                    ".....",
                    ".....",
                    "#.#..",
                    "###..",
                    "###.#",
                    "###.#",
                    "#####",
                    "",
                    ".....",
                    ".....",
                    ".....",
                    "#....",
                    "#.#..",
                    "#.#.#",
                    "#####",
                    ""
                )
            )
        )
    }

    @Test
    fun solve() {
        println(Day25CodeChronicle().solve(InputReader.parseDayTwentyFiveInput()))
    }
}