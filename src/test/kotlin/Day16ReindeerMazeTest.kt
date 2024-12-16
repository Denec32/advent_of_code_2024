import com.denec.Day16ReindeerMaze
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day16ReindeerMazeTest {
    @Test
    fun solve_example1() {
        assertEquals(
            7036, Day16ReindeerMaze().solve(
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
            11048, Day16ReindeerMaze().solve(
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
        println(Day16ReindeerMaze().solve(InputReader.parseDaySixteenInput()))
    }
}