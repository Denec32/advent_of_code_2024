import com.denec.Day3MullItOver
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import reader.InputReader.Companion.parseDayThreeInput

class Day3MullItOverTest {

    @Test
    fun solve_example() {
        assertEquals(161L, Day3MullItOver().solve("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"))
    }

    @Test
    fun solve() {
        println(Day3MullItOver().solve(parseDayThreeInput()))
    }
}