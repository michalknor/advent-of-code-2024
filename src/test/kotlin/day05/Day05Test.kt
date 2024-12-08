package day05

import utils.ParseFile
import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {
    @Test
    fun part1() {
        assertEquals(143, Day05(ParseFile.parseFileToString("day05/test.txt")).solvePart1())
    }

    @Test
    fun part2() {
        assertEquals(123, Day05(ParseFile.parseFileToString("day05/test.txt")).solvePart2())
    }
}
