import com.denec.Day16ReindeerMazePart2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day16ReindeerMazePart2Test {
    @Test
    fun solve_example1() {
        assertEquals(
            45, Day16ReindeerMazePart2().solve(
                listOf(
                    "###############",
                    "#.......#....E#",
                    "#.#.###.#.###.#",
                    "#.....#.#...#.#",
                    "#.###.#####.#.#",
                    "#.#.#.......#.#",
                    "#.#.#####.###.#",
                    "#...........#.#",
                    "###.#.#####.#.#",
                    "#...#.....#.#.#",
                    "#.#.#.###.#.#.#",
                    "#.....#...#.#.#",
                    "#.###.#.#.#.#.#",
                    "#S..#.....#...#",
                    "###############",
                )
            )
        )
    }

    @Test
    fun solve_example2() {
        assertEquals(
            64, Day16ReindeerMazePart2().solve(
                listOf(
                    "#################",
                    "#...#...#...#..E#",
                    "#.#.#.#.#.#.#.#.#",
                    "#.#.#.#...#...#.#",
                    "#.#.#.#.###.#.#.#",
                    "#...#.#.#.....#.#",
                    "#.#.#.#.#.#####.#",
                    "#.#...#.#.#.....#",
                    "#.#.#####.#.###.#",
                    "#.#.#.......#...#",
                    "#.#.###.#####.###",
                    "#.#.#...#.....#.#",
                    "#.#.#.#####.###.#",
                    "#.#.#.........#.#",
                    "#.#.#.#########.#",
                    "#S#.............#",
                    "#################",
                )
            )
        )
    }

    @Test
    fun solve() {
        println(Day16ReindeerMazePart2().solve(InputReader.parseDaySixteenInput()))
    }
}