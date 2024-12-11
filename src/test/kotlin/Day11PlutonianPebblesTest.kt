import com.denec.Day11PlutonianPebbles
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day11PlutonianPebblesTest {
    @Test
    fun solve_example() {
        assertEquals(55312, Day11PlutonianPebbles().solve(listOf("125", "17"), 25))
    }

    @Test
    fun solve_part1() {
        println(Day11PlutonianPebbles().solve(listOf("475449", "2599064", "213", "0", "2", "65", "5755", "51149"), 25))
    }

    @Test
    fun solve_part2() {
        println(Day11PlutonianPebbles().solve(listOf("475449", "2599064", "213", "0", "2", "65", "5755", "51149"), 75))
    }
}