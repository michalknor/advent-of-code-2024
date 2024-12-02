package day02

import utils.ParseFile
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {
    @Test
    fun part1() {
        val answer = Day02(ParseFile.parseFileToListOfListOfInt("day02/test.txt")).solvePart1()

        assertEquals(answer, 2)
    }

    @Test
    fun part2() {
        val answer = Day02(ParseFile.parseFileToListOfListOfInt("day02/test.txt")).solvePart2()

        assertEquals(answer, 4)
    }
}