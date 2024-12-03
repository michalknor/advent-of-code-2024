package day03

import utils.ParseFile
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {
    @Test
    fun part1() {
        val answer = Day03(ParseFile.parseFileToString("day03/test.txt")).solvePart1()

        assertEquals(answer, 161)
    }

    @Test
    fun part2() {
        val answer = Day03(ParseFile.parseFileToString("day03/test.txt")).solvePart2()

        assertEquals(answer, 48)
    }
}