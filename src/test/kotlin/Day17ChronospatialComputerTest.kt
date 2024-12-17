import com.denec.Day17ChronospatialComputer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day17ChronospatialComputerTest {
    @Test
    fun solve_example() {
        assertEquals(
            "4,6,3,5,6,3,5,2,1,0", Day17ChronospatialComputer().solve(
                listOf(
                    "Register A: 729",
                    "Register B: 0",
                    "Register C: 0",
                    "",
                    "Program: 0,1,5,4,3,0",
                )
            )
        )
    }

    @Test
    fun solve() {
        println(
            Day17ChronospatialComputer().solve(
                listOf(
                    "Register A: 66752888",
                    "Register B: 0",
                    "Register C: 0",
                    "",
                    "Program: 2,4,1,7,7,5,1,7,0,3,4,1,5,5,3,0",
                )
            )
        )
    }
}