package ru.ilyamnl.lessons

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class FileProcessorTest {

    private val mockFile = mockk<File>()
    private val processor = FileProcessor()

    @Test
    fun `test processFile with mocked content`() {
        mockkStatic("kotlin.io.FilesKt__FileReadWriteKt") // ссылка на файл с методами
        every { mockFile.readText() } returns "Hello, test!" // говорим, что будет отвечать наш мок на вызов метода читки файла
        val result = processor.processFile(mockFile)
        Assertions.assertEquals("Processed: Hello, test!", result)
        verify(exactly = 1) { mockFile.readText() } // говорим, что ожидаем, что метод вызван только один раз!!!
    }

}