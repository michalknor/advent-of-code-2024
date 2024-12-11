package utils

import java.net.URL

internal object ParseFile {
  fun parseFileToString(filePath: String): String = getResource(filePath)?.readText().toString()

  fun parseFileToList(filePath: String): List<String> =
      getResource(filePath)?.readText()?.lines() ?: emptyList()

  fun parseFileToListOfInt(filePath: String): List<Int> =
      getResource(filePath)?.readText()?.lines()?.first()?.map { char -> char.digitToInt() }
          ?: emptyList()

  fun parseFileToListOfListOfInt(filePath: String, delimiter: String): List<List<Int>> =
      getResource(filePath)?.readText()?.lines()?.map { line ->
        line.split(delimiter).mapNotNull { it.toIntOrNull() }
      } ?: emptyList()

  fun parseFileToListOfListOfChars(filePath: String): List<List<Char>> =
      getResource(filePath)?.readText()?.lines()?.map { it.toList() } ?: emptyList()

  private fun getResource(filePath: String): URL? =
      this::class.java.classLoader.getResource(filePath)
}
