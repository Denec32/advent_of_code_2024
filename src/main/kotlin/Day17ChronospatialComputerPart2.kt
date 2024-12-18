package com.denec

import java.util.*

class Day17ChronospatialComputerPart2 {
    companion object {
        fun solve(a: Long): String {
            var registerA = a
            val output = mutableListOf<Int>()
            while (registerA != 0L) {
                var registerB = registerA % 8
                registerB = registerB xor 7
                val registerC = registerA / (1 shl registerB.toInt())
                registerB = registerB xor 7
                registerA /= 8
                registerB = registerB xor registerC
                output.add((registerB % 8).toInt())
            }

            return output.joinToString("")
        }

        fun dfs(target: String, idx: Int, stack: Stack<Int>): Boolean {
            if (idx < 0) {
                if (stack.joinToString("").toLong(10).toString().length == target.length) {
                    println(stack.joinToString("").toLong(8))
                    return true
                }
                return false
            }

            for (byte in 0..7) {
                stack.push(byte)
                val executionResult = solve(stack.joinToString("").toLong(8))
                if (target.endsWith(executionResult)) {
                    if (dfs(target, idx - 1, stack)) return true
                }
                stack.pop()
            }
            return false
        }
    }
}