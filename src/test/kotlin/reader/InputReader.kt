package reader

import kotlin.streams.toList

class InputReader {
    companion object {
        fun parseDayOneInput(): Pair<MutableList<Int>, MutableList<Int>> {
            val input = {}.javaClass.getResource("/input_1.txt")?.readText() ?: ""
            val firstList = mutableListOf<Int>()
            val secondList = mutableListOf<Int>()

            for (line in input.lines()) {
                if (line.isEmpty()) continue
                val (first, second) = line.split("   ")
                firstList.add(first.toInt())
                secondList.add(second.toInt())
            }

            return firstList to secondList
        }

        fun parseDayTwoInput(): List<List<Int>> {
            val input = {}.javaClass.getResource("/input_2.txt")?.readText() ?: ""

            return input.lines().stream()
                .filter { line -> line.isNotEmpty() }
                .map { line -> line.split(" ").map { it.toInt() } }
                .toList()
        }

        fun parseDayThreeInput(): String {
            val input = {}.javaClass.getResource("/input_3.txt")?.readText() ?: ""
            return input
        }

        fun parseDayFourInput(): List<String> {
            val input = {}.javaClass.getResource("/input_4.txt")?.readText() ?: ""
            return input.lines().filter { line -> line.isNotEmpty() }.toList()
        }

        fun parseDayFiveInput(): Pair<List<String>, List<String>> {
            val input = {}.javaClass.getResource("/input_5.txt")?.readText() ?: ""
            val idx = input.lines().indexOf("");
            return Pair(input.lines().take(idx), input.lines().drop(idx + 1).dropLast(1))
        }

        fun parseDaySixInput(): List<List<Char>> {
            val input = {}.javaClass.getResource("/input_6.txt")?.readText() ?: ""

            return input.lines().stream()
                .map { toList(it) }
                .filter { it.isNotEmpty() }
                .toList()
        }

        private fun toList(line: String): List<Char> {
            val list = mutableListOf<Char>()
            for (letter in line.toCharArray()) {
                list.add(letter)
            }

            return list
        }

        fun parseDaySevenInput(): List<String> {
            val input = {}.javaClass.getResource("/input_7.txt")?.readText() ?: ""
            return input.lines().filter { line -> line.isNotEmpty() }
        }

        fun parseDayEightInput(): List<String> {
            val input = {}.javaClass.getResource("/input_8.txt")?.readText() ?: ""
            return input.lines().filter { line -> line.isNotEmpty() }
        }

        fun parseDayNineInput(): String {
            return {}.javaClass.getResource("/input_9.txt")?.readText() ?: ""
        }

        fun parseDayTenInput(): List<List<Int>> {
            val input = {}.javaClass.getResource("/input_10.txt")?.readText() ?: ""

            return input.lines().stream()
                .filter { line -> line.isNotEmpty() }
                .map { line -> line.toCharArray().map { it.digitToInt() } }
                .toList()
        }

        fun parseDayTwelveInput(): List<String> {
            val input = {}.javaClass.getResource("/input_12.txt")?.readText() ?: ""
            return input.lines().filter { line -> line.isNotEmpty() }
        }

        fun parseDayThirteenInput(): List<String> {
            val input = {}.javaClass.getResource("/input_13.txt")?.readText() ?: ""
            return input.lines().dropLast(1)
        }

        fun parseDayFourteenInput(): List<String> {
            val input = {}.javaClass.getResource("/input_14.txt")?.readText() ?: ""
            return input.lines().dropLast(1)
        }


        fun parseDayFifteenInput(): Pair<List<String>, List<String>> {
            val input = {}.javaClass.getResource("/input_15.txt")?.readText() ?: ""
            val idx = input.lines().indexOf("");
            return Pair(input.lines().take(idx), input.lines().drop(idx + 1).dropLast(1))
        }
    }
}