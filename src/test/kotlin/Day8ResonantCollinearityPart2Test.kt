import com.denec.Day8ResonantCollinearityPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day8ResonantCollinearityPart2Test {
     @Test
     fun solve_example() {
         assertEquals(34, Day8ResonantCollinearityPart2().solve(listOf(
             "............",
             "........0...",
             ".....0......",
             ".......0....",
             "....0.......",
             "......A.....",
             "............",
             "............",
             "........A...",
             ".........A..",
             "............",
             "............",
         )))
     }

     @Test
     fun solve() {
         println(Day8ResonantCollinearityPart2().solve(InputReader.parseDayEightInput()))
     }
 }