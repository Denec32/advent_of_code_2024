import com.denec.Day7BridgeRepairPart2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import reader.InputReader

class Day7BridgeRepairPart2Test {
     @Test
     fun solve_example() {
         assertEquals(11387, Day7BridgeRepairPart2().solve(listOf(
             "190: 10 19",
             "3267: 81 40 27",
             "83: 17 5",
             "156: 15 6",
             "7290: 6 8 6 15",
             "161011: 16 10 13",
             "192: 17 8 14",
             "21037: 9 7 18 13",
             "292: 11 6 16 20",
         )))
     }

     @Test
     fun solve() {
         println(Day7BridgeRepairPart2().solve(InputReader.parseDaySevenInput()))
     }
 }