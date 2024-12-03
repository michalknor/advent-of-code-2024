package utils

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

//fun parseFileToList(filePath: String): List<String> {
//    return try {
//        File(filePath).readLines()
//    } catch (e: Exception) {
//        println("Error reading file: ${e.message}")
//        emptyList()
//    }
//}

internal object ParseFile {
    fun parseFileToString(filePath: String): String {
        return this::class.java.classLoader.getResource(filePath).readText()
    }
    fun parseFileToList(filePath: String): List<String> {
        return this::class.java.classLoader.getResource(filePath).readText().lines().toList()
    }

    fun parseFileToListOfListOfInt(filePath: String): List<List<Int>> {
        return this::class.java.classLoader.getResource(filePath).readText().lines().map{ line -> line.split(" ").mapNotNull { it.toIntOrNull() } }
    }
}