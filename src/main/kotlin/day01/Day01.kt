package day01

import utils.ParseFile

class Day01(input: List<String>) {
    private val lists = input.map { it.split("   ") }.let { it.map { pair -> pair[0].toInt() }.sorted() to it.map { pair -> pair[1].toInt() }.sorted() }
    private val rightList = lists.first
    private val leftList = lists.second

    fun solvePart1(): Int = rightList.zip(leftList) { a, b -> Math.abs(a - b) }.sum()
    fun solvePart2(): Int = rightList.map { a -> a * leftList.count {it == a} }.sum()
}



fun main() {
    println(Day01(ParseFile.parseFileToList("day01/input.txt")).solvePart1())
    println(Day01(ParseFile.parseFileToList("day01/input.txt")).solvePart2())
}