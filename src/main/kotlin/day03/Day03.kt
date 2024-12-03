package day03

import utils.ParseFile

class Day03(private val input: String) {
    fun solvePart1(): Int = Regex("mul\\((\\d+),(\\d+)\\)")
        .findAll(input)
        .map { match ->
            val (num1, num2) = match.destructured
            num1.toInt() * num2.toInt()
        }
        .sum()
    fun solvePart2(): Int {
        var enabled = true
        return Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")
            .findAll(input)
            .map {
                when (it.value) {
                    "do()" -> {
                        enabled = true
                        0
                    }
                    "don't()" -> {
                        enabled = false
                        0
                    }
                    else -> {
                        if (enabled) {
                            val (num1, num2) = it.destructured
                            num1.toInt() * num2.toInt()
                        }
                        else {
                            0
                        }
                    }
                }
            }
            .sum()
    }
}


fun main() {
    println(Day03(ParseFile.parseFileToString("day03/input.txt")).solvePart1())
    println(Day03(ParseFile.parseFileToString("day03/input.txt")).solvePart2())
}