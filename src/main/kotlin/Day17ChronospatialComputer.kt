package com.denec

class Day17ChronospatialComputer {
    class Computer(
        private var registerA: Int,
        private var registerB: Int,
        private var registerC: Int,
        private var position: Int = 0
    ) {
        fun execute(input: List<Int>): String {
            val output = mutableListOf<Int>()
            while (position in input.indices) {
                val operator = input[position]
                val operand = input[position + 1]
                when(operator) {
                    0 -> adv(operand)
                    1 -> bxl(operand)
                    2 -> bst(operand)
                    3 -> position = jnz(operand)
                    4 -> bxc()
                    5 -> output.add(out(operand))
                    6 -> bdv(operand)
                    7 -> cdv(operand)
                }

                position += 2
            }

            return output.joinToString(",")
        }

        private fun toCombo(comboOperand: Int): Int {
            return when (comboOperand) {
                in 0..3 -> comboOperand
                4 -> registerA
                5 -> registerB
                6 -> registerC
                else -> throw Exception("not valid combo operand")
            }
        }

        private fun dv(operand: Int): Int {
            if (toCombo(operand) > 32) throw Exception("not valid")
            return registerA / (1 shl toCombo(operand))
        }

        private fun adv(operand: Int) {
            registerA = dv(operand)
        }

        private fun bxl(literalOperand: Int) {
            registerB = registerB xor literalOperand
        }

        private fun bst(operand: Int) {
            registerB = toCombo(operand) % 8
        }

        private fun jnz(operand: Int): Int {
            if (registerA == 0) return position
            return operand - 2
        }

        private fun bxc() {
            registerB = registerB xor registerC
        }

        private fun out(operand: Int): Int {
            return toCombo(operand) % 8
        }

        private fun bdv(operand: Int) {
            registerB = dv(operand)
        }

        private fun cdv(operand: Int) {
            registerC = dv(operand)
        }
    }

    fun solve(input: List<String>): String {
        val registerA = input[0].split(" ")[2].toInt()
        val registerB = input[1].split(" ")[2].toInt()
        val registerC = input[2].split(" ")[2].toInt()

        val program = input[4].drop("Program: ".length)
            .split(",")
            .stream()
            .map { it.toInt() }
            .toList()

        return Computer(registerA, registerB, registerC).execute(program)
    }
}