package ru.ilyamnl.lessons

import java.io.File

class FileProcessor {

    fun processFile(file: File): String {
        val content = file.readText()
        return "Processed: $content"
    }

}