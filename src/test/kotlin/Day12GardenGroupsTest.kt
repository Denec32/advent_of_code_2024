import com.denec.Day12GardenGroups
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day12GardenGroupsTest {
     @Test
     fun test_example() {
         assertEquals(1930, Day12GardenGroups().solve(listOf(
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
        println(Day12GardenGroups().solve(InputReader.parseDayTwelveInput()))
    }
 }