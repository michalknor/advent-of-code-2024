package utils

internal object ParseFile {
  fun parseFileToString(filePath: String): String =
      this::class.java.classLoader.getResource(filePath)?.readText()?.lines().toString()

  fun parseFileToList(filePath: String): List<String> =
      this::class.java.classLoader.getResource(filePath)?.readText()?.lines() ?: emptyList()

  fun parseFileToListOfListOfInt(filePath: String): List<List<Int>> =
      this::class.java.classLoader.getResource(filePath)?.readText()?.lines()?.map { line ->
        line.split(" ").mapNotNull { it.toIntOrNull() }
      } ?: emptyList()

  fun parseFileToListOfListOfChars(filePath: String): List<List<Char>> =
      this::class.java.classLoader.getResource(filePath)?.readText()?.lines()?.map { it.toList() }
          ?: emptyList()
}
