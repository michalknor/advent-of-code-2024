package day03

import utils.ParseFile

class Day03(private val input: String) {
    fun solvePart1(): Int = sumMul(input)

    fun solvePart2(): Int =
        Regex("""(^|do\(\)).*?($|don't\(\))""")
            .findAll(input)
            .sumOf { sumMul(it.value) }

    private fun sumMul(mul: String): Int =
        Regex("mul\\((\\d+),(\\d+)\\)")
            .findAll(mul)
            .map { match ->
                val (num1, num2) = match.destructured
                num1.toInt() * num2.toInt()
            }
            .sum()
}

fun main() {
    println(Day03(ParseFile.parseFileToString("day03/input.txt")).solvePart1())
    println(Day03(ParseFile.parseFileToString("day03/input.txt")).solvePart2())
}