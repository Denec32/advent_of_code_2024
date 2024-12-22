import com.denec.Day20RaceCondition
import com.denec.Day20RaceConditionPart2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import reader.InputReader
import java.util.concurrent.TimeUnit

class Day20RaceConditionPart2Test {
    @Test
    fun solve_example() {
        assertEquals(32 + 31 + 29 + 39 + 25 + 23 + 20 + 19 + 12 + 14 + 12 + 22 + 4 + 3,
            Day20RaceConditionPart2().solve(
                listOf(
                    "###############",
                    "#...#...#.....#",
                    "#.#.#.#.#.###.#",
                    "#S#...#.#.#...#",
                    "#######.#.#.###",
                    "#######.#.#...#",
                    "#######.#.###.#",
                    "###..E#...#...#",
                    "###.#######.###",
                    "#...###...#...#",
                    "#.#####.#.###.#",
                    "#.#...#.#.#...#",
                    "#.#.#.#.#.#.###",
                    "#...#...#...###",
                    "###############",
                ), 50
            )
        )
    }

    @Test
    fun solve() {
        println(Day20RaceConditionPart2().solve(InputReader.parseDayTwentyInput(), 100))
    }
}