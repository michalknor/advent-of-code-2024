package day02

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day02Test {
  @Test
  fun part1() {
    val answer = Day02(ParseFile.parseFileToListOfListOfInt("day02/test.txt", " ")).solvePart1()

    assertEquals(2, answer)
  }

  @Test
  fun part2() {
    val answer = Day02(ParseFile.parseFileToListOfListOfInt("day02/test.txt", " ")).solvePart2()

    assertEquals(4, answer)
  }
}
