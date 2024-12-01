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
    fun parseFileToList(filePath: String): List<String> {

            // Get the file as a resource
            val a = this::class.java.classLoader.getResource(filePath).readText().lines().toList()
            val list: List<String> = a.toList()
            return list
    }
}