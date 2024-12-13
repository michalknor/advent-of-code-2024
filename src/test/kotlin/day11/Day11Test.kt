package day11

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day11Test {
  @Test
  fun part1() {
    assertEquals(55312, Day11(ParseFile.parseFileToListOfLong("day11/test.txt", " ")).solve(25))
  }

  @Test
  fun part2() {
    assertEquals(65601038650482, Day11(ParseFile.parseFileToListOfLong("day11/test.txt", " ")).solve(75))
  }
}
