package com.denec

import java.util.stream.Collectors

class Day24CrossedWires {
    data class Gate(val operand1: String, val operator: OperatorType, val operand2: String, val result: String)

    enum class OperatorType {
        AND, OR, XOR;

        fun eval(operand1: Boolean, operand2: Boolean): Boolean {
            return when (this) {
                AND -> operand1 and operand2
                OR -> operand1 or operand2
                XOR -> operand1 xor operand2
            }
        }
    }

    fun solve(input: List<String>): Long {
        val (initialValues, gates) = input.partition { it.contains(":") }

        return solve(initialValues, gates.drop(1))
    }

    private fun solve(initialValues: List<String>, gates: List<String>): Long {
        val initialValues = initialValues.stream().map { it.split(": ") }
            .collect(Collectors.toMap({ it[0] }, { if (it[1] == "1") true else false }))

        val gates = gates.stream()
            .map { it.split(" ") }
            .map { Gate(it[0], OperatorType.valueOf(it[1]), it[2], it[4]) }
            .toList()

        val resultToGates = gates.stream()
            .collect(Collectors.toMap({ it.result }, { it }))

        gates.forEach { gate -> evalGate(initialValues, resultToGates, gate) }

        return initialValues
            .filter { it.key.startsWith('z') }
            .toSortedMap()
            .reversed()
            .map { if (it.value) 1 else 0 }
            .joinToString("").toLong(2)
    }

    private fun evalGate(
        values: MutableMap<String, Boolean>,
        resultToGates: Map<String, Gate>,
        gate: Gate
    ): Boolean {
        val operand1 = values[gate.operand1] ?: evalGate(values, resultToGates, resultToGates[gate.operand1]!!)
        val operand2 = values[gate.operand2] ?: evalGate(values, resultToGates, resultToGates[gate.operand2]!!)

        values[gate.result] = gate.operator.eval(operand1, operand2)

        return values[gate.result]!!
    }
}