import com.denec.Day14RestroomRedoubt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import reader.InputReader

class Day14RestroomRedoubtTest {
     @Test
     fun solve_example() {
         assertEquals(12, Day14RestroomRedoubt().solve(listOf(
             "p=0,4 v=3,-3",
             "p=6,3 v=-1,-3",
             "p=10,3 v=-1,2",
             "p=2,0 v=2,-1",
             "p=0,0 v=1,3",
             "p=3,0 v=-2,-2",
             "p=7,6 v=-1,-3",
             "p=3,0 v=-1,-2",
             "p=9,3 v=2,3",
             "p=7,3 v=-1,2",
             "p=2,4 v=2,-3",
             "p=9,5 v=-3,-3",
         ), 11, 7))
     }

    @Test
    fun solve() {
        println(Day14RestroomRedoubt().solve(InputReader.parseDayFourteenInput(), 101, 103))
    }
 }