package day01

import utils.ParseFile
import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    @Test
    fun part1() {
        val answer = Day01(ParseFile.parseFileToList(Thread.currentThread().stackTrace[1].toString().split(".").first() + "/test.txt")).solvePart1()

        assertEquals(answer, 11)
    }

    @Test
    fun part2() {
        val answer = Day01(ParseFile.parseFileToList(Thread.currentThread().stackTrace[1].toString().split(".").first() + "/test.txt")).solvePart2()

        assertEquals(answer, 31)
    }
}