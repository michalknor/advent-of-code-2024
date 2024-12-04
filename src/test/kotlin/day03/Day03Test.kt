package day03

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day03Test {
  @Test
  fun part1() {
    val answer = Day03(ParseFile.parseFileToString("day03/test.txt")).solvePart1()

    assertEquals(161, answer)
  }

  @Test
  fun part2() {
    val answer = Day03(ParseFile.parseFileToString("day03/test.txt")).solvePart2()

    assertEquals(48, answer)
  }
}
