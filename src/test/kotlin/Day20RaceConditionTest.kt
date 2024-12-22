import com.denec.Day20RaceCondition
import org.junit.jupiter.api.Test
import reader.InputReader

class Day20RaceConditionTest {
    /*
    @Test
    fun solve_example() {
        println(
            Day20RaceCondition().solve(
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
                )
            )
        )
    }
    */

    @Test
    fun solve() {
        println(Day20RaceCondition().solve(InputReader.parseDayTwentyInput()))
    }
}