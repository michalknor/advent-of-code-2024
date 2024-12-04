package day04

import utils.ParseFile
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
  @Test
  fun part1() {
    assertEquals(18, Day04(ParseFile.parseFileToListOfListOfChars("day04/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    val answer = Day04(ParseFile.parseFileToListOfListOfChars("day04/test.txt")).solvePart2()

    assertEquals(9, answer)
  }
}
