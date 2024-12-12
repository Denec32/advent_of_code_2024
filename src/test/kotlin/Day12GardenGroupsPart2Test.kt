import com.denec.Day12GardenGroupsPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day12GardenGroupsPart2Test {
     @Test
     fun test_example() {
         assertEquals(1206, Day12GardenGroupsPart2().solve(listOf(
             "RRRRIICCFF",
             "RRRRIICCCF",
             "VVRRRCCFFF",
             "VVRCCCJFFF",
             "VVVVCJJCFE",
             "VVIVCCJJEE",
             "VVIIICJJEE",
             "MIIIIIJJEE",
             "MIIISIJEEE",
             "MMMISSJEEE",
         )))
     }

     @Test
     fun solve() {
         println(Day12GardenGroupsPart2().solve(InputReader.parseDayTwelveInput()))
     }
 }