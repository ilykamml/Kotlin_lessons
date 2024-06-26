package ru.ilyamnl.homework

import java.io.File
import kotlin.math.abs

fun main() {

    val fileProcessor = FileProcessorlmpl()
    val encryptor = Encryptorlmpl()
    val encryptionManager = EncryptionManager(fileProcessor, encryptor)

    val directory = File("encryption_test")
    val backupDirectory = File("encryption_test/backup")
    val extension = "txt"

    encryptionManager.encryptFilesInDirectory(directory, backupDirectory, extension)



}

class FileProcessorlmpl: FileProcessor {

    override fun findFilesByExtension(extension: String, directory: File): List<File> {

//        return if (directory.isDirectory) {
//            directory.listFiles {_, name -> name.endsWith(".$extension")}?.toList() ?: emptyList()
//        } else emptyList()

        return if (directory.isDirectory) {
            directory.walk()
                .filter { it.isFile && it.extension == extension }
                .map { it.absoluteFile }
                .toList()
        } else emptyList()

    }
    override fun encryptFiles(files: List<File>, encryptor: Encryptor) {

        for (file in files) {
            val encryptedText = encryptor.encrypt(file.readText())
            file.writeText(encryptedText)
        }

    }
    override fun moveToBackup(files: List<File>, backupDir: File) {

        if (!backupDir.exists()) backupDir.mkdirs()

        for (file in files) {
            if (file.exists()) {
                file.copyTo(File(backupDir.path + "/" + file.name), overwrite = true)
            }
//        }
//        val absoluteFilePath = backupDir.absolutePath
//        if (!File(absoluteFilePath).exists()) File(absoluteFilePath).mkdirs()
//        files.forEach {
//
        }

    }

}

class Encryptorlmpl: Encryptor {

    override fun encrypt(content: String): String {

        return content.map { it + 14 }.joinToString("")

    }

}

class EncryptionManager(private val file: FileProcessor, private val encrypt: Encryptor) {

    fun encryptFilesInDirectory(directory: File, backupDir: File, extension: String) {

        val files: List<File> = file.findFilesByExtension(extension, directory)
        if (files.isNotEmpty()) {
            file.moveToBackup(files, backupDir)
            file.encryptFiles(files, encrypt)
        }

    }

}

interface FileProcessor {
    fun findFilesByExtension(extension: String, directory: File): List<File>
    fun encryptFiles(files: List<File>, encryptor: Encryptor)
    fun moveToBackup(files: List<File>, backupDir: File)
}

interface Encryptor {
    fun encrypt(content: String): String
}